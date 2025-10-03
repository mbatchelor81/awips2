#!/bin/bash
set -e

source /awips2/edex/bin/setup.env

HOSTNAME=$(hostname)
sed -i "s/external.fqdn/${HOSTNAME}/g" /awips2/edex/bin/setup.env

source /awips2/edex/bin/setup.env

if [ -f /awips2/edex/conf/edexServiceList ]; then
    source /awips2/edex/conf/edexServiceList
else
    export SERVICES=(ingest ingestGrib request)
fi

echo "Starting EDEX services: ${SERVICES[@]}"

if [ ! -d /awips2/database/data/base ]; then
    echo "Initializing PostgreSQL database..."
    su - awips -c "export PATH=/awips2/postgresql/bin:/awips2/psql/bin:\$PATH && \
                   initdb -D /awips2/database/data"
fi

echo "Starting PostgreSQL..."
su - awips -c "/awips2/postgresql/bin/pg_ctl -D /awips2/database/data \
               -l /awips2/database/data/pg_log/startup.log start"
sleep 5

echo "Starting httpd-pypies..."
if [ -f /awips2/httpd_pypies/usr/sbin/httpd ]; then
    /awips2/httpd_pypies/usr/sbin/httpd -k start
fi
sleep 3

echo "Starting Qpid..."
su - awips -c "/awips2/qpid/bin/qpid-wrapper &"
sleep 5

rm -rf /awips2/qpid/edexMessageStore/edex/

for service in ${SERVICES[@]}; do
    echo "Starting EDEX ${service}..."
    su - awips -c "/awips2/edex/bin/start.sh -noConsole ${service} &"
    sleep 10
done

if [ -f /awips2/ldm/bin/ldmadmin ]; then
    echo "Starting LDM..."
    su - awips -c "cd /awips2/ldm && \
                   /awips2/ldm/bin/ldmadmin mkqueue && \
                   /awips2/ldm/bin/ldmadmin start"
fi

echo "All services started. EDEX is now operational."
echo "Connect using Python API with: changeEDEXHost('localhost')"

trap "echo 'Shutting down...'; \
      su - awips -c '/awips2/ldm/bin/ldmadmin stop' 2>/dev/null || true; \
      pkill -f 'edex.run.mode'; \
      /awips2/httpd_pypies/usr/sbin/httpd -k stop 2>/dev/null || true; \
      pkill -f qpid-wrapper; \
      su - awips -c '/awips2/postgresql/bin/pg_ctl -D /awips2/database/data stop'; \
      exit 0" SIGTERM SIGINT

tail -f /awips2/edex/logs/edex-*.log
