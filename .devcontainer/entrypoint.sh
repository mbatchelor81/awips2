#!/bin/bash
set -e

AUTO_START=${AUTO_START_SERVICES:-true}

check_pg_log() {
    if [ -f /awips2/database/data/pg_log/startup.log ]; then
        echo "=== PostgreSQL startup log ==="
        cat /awips2/database/data/pg_log/startup.log
        echo "==========================="
    fi
}

source /awips2/edex/bin/setup.env

HOSTNAME=$(hostname)
sed -i "s/external.fqdn/${HOSTNAME}/g" /awips2/edex/bin/setup.env
sed -i "s/DB_SSLMODE=verify-ca/DB_SSLMODE=disable/g" /awips2/edex/bin/setup.env

source /awips2/edex/bin/setup.env

if [ -f /awips2/edex/conf/edexServiceList ]; then
    source /awips2/edex/conf/edexServiceList
else
    export SERVICES=(ingest ingestGrib request)
fi

if [ "$AUTO_START" = "false" ]; then
    echo "=========================================="
    echo "AUTO_START_SERVICES is false"
    echo "Services will NOT start automatically"
    echo "=========================================="
    echo ""
    echo "To manually start services:"
    echo "  1. Initialize database (if needed):"
    echo "     sudo /usr/local/bin/entrypoint.sh"
    echo "  2. Or start individual services manually"
    echo ""
    echo "Opening interactive shell..."
    exec /bin/bash
fi

echo "=========================================="
echo "AUTO_START_SERVICES is enabled"
echo "Starting EDEX services: ${SERVICES[@]}"
echo "=========================================="

data_dir="/awips2/database/data"
tablespace_dir="/awips2/database/tablespaces"
sql_share_dir="/awips2/database/sqlScripts/share/sql"
marker_file="/awips2/database/.awips_db_initialized"

if [ ! -f "${marker_file}" ]; then
    echo "Initializing PostgreSQL database..."
    
    echo "Clearing existing database directory contents..."
    sudo rm -rf ${data_dir}/*
    sudo rm -rf ${data_dir}/.[!.]*
    
    echo "Creating tablespace directories..."
    sudo mkdir -p ${tablespace_dir}/{metadata,pgdata_ihfs,damcat,hmdb,climate,maps,ncep}
    sudo chown -R awips:fxalpha ${tablespace_dir}
    
    /awips2/postgresql/bin/initdb -D ${data_dir} \
                   --auth=trust \
                   --locale=en_US.UTF-8 \
                   --lc-collate=en_US.UTF-8 \
                   --lc-ctype=en_US.UTF-8
    
    echo "Starting PostgreSQL for database setup..."
    sudo mkdir -p ${data_dir}/pg_log
    sudo chown -R awips:fxalpha ${data_dir}
    
    sudo mkdir -p /var/run/postgresql
    sudo chown awips:fxalpha /var/run/postgresql
    
    if ! /awips2/postgresql/bin/pg_ctl -D ${data_dir} \
                   -l ${data_dir}/pg_log/startup.log start; then
        echo "ERROR: Failed to start PostgreSQL"
        check_pg_log
        exit 1
    fi
    sleep 10
    
    echo "Creating AWIPS databases..."
    initial_sql="${sql_share_dir}/initial_setup_server.sql"
    
    cp ${initial_sql} /tmp/initial_setup_server.sql
    
    sed -i "s/%{databaseUsername}/awips/g" /tmp/initial_setup_server.sql
    sed -i "s|%{tablespace_dir}%|${tablespace_dir}|g" /tmp/initial_setup_server.sql
    
    psql -U awips -d postgres -f /tmp/initial_setup_server.sql || {
        echo "ERROR: Failed to create AWIPS databases"
        cat ${data_dir}/pg_log/startup.log
        exit 1
    }
    
    echo "Creating PostGIS extensions..."
    psql -U awipsadmin -d metadata \
        -c 'create extension if not exists postgis;' || true
    psql -U awipsadmin -d metadata \
        -c 'create extension if not exists postgis_raster;' || true
    psql -U awipsadmin -d metadata \
        -c 'create extension if not exists postgis_topology;' || true
    
    echo "Running permissions.sql..."
    psql -U awipsadmin -d metadata -f ${sql_share_dir}/permissions.sql || true
    
    echo "Running fxatext.sql..."
    psql -U awipsadmin -d metadata -f ${sql_share_dir}/fxatext.sql || true
    
    echo "Running createEventsSchema.sql..."
    psql -U awipsadmin -d metadata -f ${sql_share_dir}/createEventsSchema.sql || true
    
    echo "Running createEbxml.sql..."
    psql -U awipsadmin -d metadata -f ${sql_share_dir}/createEbxml.sql || true
    
    echo "Creating maps database..."
    maps_sql="${sql_share_dir}/maps/createMapsDb.sql"
    cp ${maps_sql} /tmp/createMapsDb.sql
    sed -i "s|/awips2/database/tablespaces/maps|${tablespace_dir}/maps|g" /tmp/createMapsDb.sql
    psql -U awipsadmin -d postgres -f /tmp/createMapsDb.sql || true
    rm -f /tmp/createMapsDb.sql
    
    echo "Creating ncep database..."
    ncep_sql="${sql_share_dir}/ncep/createNcepDb.sql"
    cp ${ncep_sql} /tmp/createNcepDb.sql
    sed -i "s|/awips2/database/tablespaces/ncep|${tablespace_dir}/ncep|g" /tmp/createNcepDb.sql
    psql -U awipsadmin -d postgres -f /tmp/createNcepDb.sql || true
    rm -f /tmp/createNcepDb.sql
    
    echo "Database initialization complete"
    rm -f /tmp/initial_setup_server.sql
    
    sudo touch "${marker_file}"
    echo "Created marker file ${marker_file}"
fi

echo "Starting PostgreSQL..."
if ! pgrep -f "postgres" > /dev/null; then
    sudo mkdir -p /awips2/database/data/pg_log
    sudo chown -R awips:fxalpha /awips2/database/data/pg_log
    
    sudo mkdir -p /var/run/postgresql
    sudo chown awips:fxalpha /var/run/postgresql
    
    /awips2/postgresql/bin/pg_ctl -D /awips2/database/data \
                   -l /awips2/database/data/pg_log/startup.log start
    sleep 5
fi

echo "Starting httpd-pypies..."
if [ -f /awips2/httpd_pypies/etc/httpd/conf/httpd.conf ]; then
    sudo mkdir -p /run/httpd_pypies/
    sudo chown -R awips:fxalpha /run/httpd_pypies/
    sudo /usr/sbin/httpd -f /awips2/httpd_pypies/etc/httpd/conf/httpd.conf
fi
sleep 3

echo "Starting Qpid..."
/awips2/qpid/bin/qpid-wrapper &
sleep 5

rm -rf /awips2/qpid/edexMessageStore/edex/

for service in ${SERVICES[@]}; do
    echo "Starting EDEX ${service}..."
    /awips2/edex/bin/start.sh -noConsole ${service} &
    sleep 10
done

if [ -f /awips2/ldm/bin/ldmadmin ]; then
    echo "Starting LDM..."
    cd /awips2/ldm && \
        /awips2/ldm/bin/ldmadmin mkqueue && \
        /awips2/ldm/bin/ldmadmin start
fi

echo "All services started. EDEX is now operational."
echo "Connect using Python API with: changeEDEXHost('localhost')"

trap "echo 'Shutting down...'; \
      /awips2/ldm/bin/ldmadmin stop 2>/dev/null || true; \
      pkill -f 'edex.run.mode'; \
      sudo /usr/sbin/httpd -f /awips2/httpd_pypies/etc/httpd/conf/httpd.conf -k graceful-stop 2>/dev/null || true; \
      pkill -f qpid-wrapper; \
      /awips2/postgresql/bin/pg_ctl -D /awips2/database/data stop; \
      exit 0" SIGTERM SIGINT

tail -f /awips2/edex/logs/edex-*.log
