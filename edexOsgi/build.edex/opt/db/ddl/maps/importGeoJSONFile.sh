#!/bin/bash 
##
#
# For permanent static GeoJSON file, use this script to import into maps database
# Adding a MapDescriptor and other installation steps will be same as Shapefiles
#
# SOFTWARE HISTORY
# Date         Ticket#    Engineer    Description
# ------------ ---------- ----------- --------------------------
<<<<<<< HEAD
# 06/10/2016    #17912    pwang       Added support for importing GeoJSON files
# 04/11/2018    7140      tgurney     Use a2dbauth
=======
# Jun 10, 2016 17912      pwang       Added support for importing GeoJSON files
# Apr 11, 2018 7140       tgurney     Use a2dbauth
# Jul  1, 2021 8544       tgurney     Remove PGBINDIR and PSQLBINDIR, not
#                                     needed anymore. Update GDAL data path
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
#     
##

function usage()
{
    echo
echo usage: `basename $0` filePath fileName schema tableName [AWIPS2_install_dir [dbUser [dbPort [simplev]]]]
    echo "where: filePath  - pathname of the GeoJSON file to be imported"
    echo "       fileName  - the file name of the GeoJSON file to be imported"
    echo "       schema    - database schema, usually mapdata, where the GeoJSON file is to be imported"
    echo "       tableName - database table name where the GeoJSON file is to be imported"
<<<<<<< HEAD
    echo "       AWIPS2_install_dir    - optional special AWIPS2 install directory if not /awips2"
=======
    echo "       AWIPS2_install_dir    - ignored (exists for backward compatibility only) "
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    echo "       dbUser    - optional database user id, default to awipsadmin"
    echo "       dbPort    - optional database port number"
    echo "       simplev   - optional list of geometry simplification levels to be created"
}

if [ $# -lt 4 ] ; then
    usage
    exit -1
fi

GJS_PATH=`readlink -f ${1}`
GJS_NAME=${2}  # GeoJSON file name with extension
SCHEMA=`echo "${3}" | tr '[:upper:]' '[:lower:]'`
TABLE=`echo "${4}" | tr '[:upper:]' '[:lower:]'`

<<<<<<< HEAD
if [ -z "${5}" ] ; then
    PGBINDIR=/awips2/postgresql/bin/
    PSQLBINDIR=/awips2/psql/bin/
else
    PGBINDIR=${5}/postgresql/bin/
    PSQLBINDIR=${5}/psql/bin/
fi
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

if [ -z "${DB_HOST}" ] ; then
    DBHOST=localhost
else
    DBHOST="${DB_HOST}"
fi

<<<<<<< HEAD
=======
# $5 is awips2_install_dir, ignored

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
if [ -z "${6}" ] ; then
    PGUSER=awipsadmin
else
    PGUSER=${6}
fi

if [ -z "${7}" ] ; then
    PGPORT=5432
else
    PGPORT=${7}
fi


if [ -z "${8}" ] ; then
    SIMPLEVS=''
else
    SIMPLEVS=${8}
fi

<<<<<<< HEAD
psql="a2dbauth ${PSQLBINDIR}psql"

# set env
export GDAL_DATA=/awips2/postgresql/share/gdal
=======
psql="a2dbauth psql"

# set env
export GDAL_DATA=/awips2/python/share/gdal
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

echo "${GJS_PATH}  ${GJS_NAME}" 
echo "  Importing ${GJS_NAME} into ${SCHEMA}.${TABLE} ..."
${psql} -d maps -U ${PGUSER} -q -p ${PGPORT} -c "
    DELETE FROM public.geometry_columns WHERE f_table_schema = '${SCHEMA}' AND f_table_name = '${TABLE}';
    DELETE FROM ${SCHEMA}.map_version WHERE table_name='${TABLE}';
    DROP TABLE IF EXISTS ${SCHEMA}.${TABLE}
"

<<<<<<< HEAD
a2dbauth -f ${PGBINDIR}ogr2ogr \
=======
a2dbauth -f ogr2ogr \
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    -f PostgreSQL PG:"host=$DBHOST user=${PGUSER} port=${PGPORT} dbname=maps password=awips" \
    ${GJS_PATH}/${GJS_NAME} \
    -nln ${SCHEMA}.${TABLE} \
    -lco GEOMETRY_NAME=the_geom \
    -lco FID=gid \
    -t_srs "EPSG:4326";

${psql} -d maps -U ${PGUSER} -q -p ${PGPORT} -c "
    INSERT INTO ${SCHEMA}.map_version (table_name, filename) values ('${TABLE}','${GJS_NAME}');
    SELECT AddGeometryColumn('${SCHEMA}','${TABLE}','the_geom_0','4326',(SELECT type FROM public.geometry_columns WHERE f_table_schema='${SCHEMA}' and f_table_name='${TABLE}' and f_geometry_column='the_geom'),2);
    UPDATE ${SCHEMA}.${TABLE} SET the_geom_0=ST_Segmentize(the_geom,0.1);
    CREATE INDEX ${TABLE}_the_geom_0_gist ON ${SCHEMA}.${TABLE} USING gist(the_geom_0);
"

if [ -n "$SIMPLEVS" ] ; then
    echo "  Creating simplification levels ${SIMPLEVS}..."
    IFS=",	 "
    for LEV in $SIMPLEVS ; do
        echo "    Creating simplified geometry level $LEV ..."
        IFS="."
        SUFFIX=
        for x in $LEV ; do SUFFIX=${SUFFIX}_${x} ; done
        ${psql} -d maps -U ${PGUSER} -q -p ${PGPORT} -c "
        SELECT AddGeometryColumn('${SCHEMA}','${TABLE}','the_geom${SUFFIX}','4326',(SELECT type FROM public.geometry_columns WHERE f_table_schema='${SCHEMA}' and f_table_name='${TABLE}' and f_geometry_column='the_geom'),2);
        UPDATE ${SCHEMA}.${TABLE} SET the_geom${SUFFIX}=ST_Segmentize(ST_Multi(ST_SimplifyPreserveTopology(the_geom,${LEV})),0.1);
        CREATE INDEX ${TABLE}_the_geom${SUFFIX}_gist ON ${SCHEMA}.${TABLE} USING gist(the_geom${SUFFIX});"
    done
fi
<<<<<<< HEAD
a2dbauth ${PGBINDIR}vacuumdb -d maps -t ${SCHEMA}.${TABLE} -U ${PGUSER} -p ${PGPORT} -vfz
=======
a2dbauth vacuumdb -d maps -t ${SCHEMA}.${TABLE} -U ${PGUSER} -p ${PGPORT} -vfz
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
