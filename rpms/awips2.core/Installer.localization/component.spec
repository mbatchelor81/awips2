#
# AWIPS II Localization Spec File
#
Name: %{_component_name}
Summary: AWIPS II Localization Installation
Version: %{_component_version}
Release: %{_component_release}%{?dist}
Group: AWIPSII
BuildRoot: /tmp
BuildArch: noarch
URL: N/A
License: N/A
Distribution: N/A
Vendor: %{_build_vendor}
Packager: %{_build_site}

AutoReq: no
Provides: %{_component_name}
Requires: awips2-edex
Requires: awips2-edex-shapefiles
Obsoletes: awips2-localization-OAX < 16.1.4

%description
AWIPS II Site Localization.

# disable python byte compile
%global _python_bytecompile_extra 0

%prep
# Verify That The User Has Specified A BuildRoot.
if [ "${RPM_BUILD_ROOT}" = "/tmp" ]
then
   echo "An Actual BuildRoot Must Be Specified. Use The --buildroot Parameter."
   echo "Unable To Continue ... Terminating"
   exit 1
fi

if [ -d ${RPM_BUILD_ROOT} ]; then
   rm --recursive --force ${RPM_BUILD_ROOT}
   if [ $? -ne 0 ]; then
      exit 1
   fi
fi

%build

# Build all WFO site localization Map Scales (Regional.xml and WFO.xml)
BUILD_DIR=%{_baseline_workspace}/rpms/awips2.core/Installer.localization/
UTIL=${AWIPSII_STATIC_FILES}/localization
COMMON_DIR=$BUILD_DIR/common_static
file=$BUILD_DIR/coords.dat
regional=$BUILD_DIR/coords_regional.dat

for site in $(cat $file |cut -c -3)
do
   lat=$(cat $file   |grep $site | cut -d"," -f2  | tr -d '[[:space:]]')
   lon=$(cat $file   |grep $site | cut -d"," -f3  | tr -d '[[:space:]]')

   # <gridGeometry rangeX="LOWX HIGHX" rangeY="LOWY HIGHY" envelopeMinX="MINX" envelopeMaxX="MAXX" envelopeMinY="MINY" envelopeMaxY="MAXY">
   lowx=$(cat $file  |grep $site | cut -d"," -f4  | tr -d '[[:space:]]')
   highx=$(cat $file |grep $site | cut -d"," -f5  | tr -d '[[:space:]]')
   lowy=$(cat $file  |grep $site | cut -d"," -f6  | tr -d '[[:space:]]')
   highy=$(cat $file |grep $site | cut -d"," -f7  | tr -d '[[:space:]]')
   minx=$(cat $file  |grep $site | cut -d"," -f8  | tr -d '[[:space:]]')
   maxx=$(cat $file  |grep $site | cut -d"," -f9  | tr -d '[[:space:]]')
   miny=$(cat $file  |grep $site | cut -d"," -f10 | tr -d '[[:space:]]')
   maxy=$(cat $file  |grep $site | cut -d"," -f11 | tr -d '[[:space:]]')

   # CAVE
   CAVE_DIR=$BUILD_DIR/utility/cave_static/site/$site/
   mkdir -p $CAVE_DIR
   cp -R $UTIL/cave_static/* $CAVE_DIR
   grep -rl 'LOWX'  $CAVE_DIR/bundles/scales/WFO.xml | xargs sed -i 's/LOWX/'$lowx'/g'
   grep -rl 'HIGHX' $CAVE_DIR/bundles/scales/WFO.xml | xargs sed -i 's/HIGHX/'$highx'/g'
   grep -rl 'LOWY'  $CAVE_DIR/bundles/scales/WFO.xml | xargs sed -i 's/LOWY/'$lowy'/g'
   grep -rl 'HIGHY' $CAVE_DIR/bundles/scales/WFO.xml | xargs sed -i 's/HIGHY/'$highy'/g'
   grep -rl 'MINX'  $CAVE_DIR/bundles/scales/WFO.xml | xargs sed -i 's/MINX/'$minx'/g'
   grep -rl 'MAXX'  $CAVE_DIR/bundles/scales/WFO.xml | xargs sed -i 's/MAXX/'$maxx'/g'
   grep -rl 'MINY'  $CAVE_DIR/bundles/scales/WFO.xml | xargs sed -i 's/MINY/'$miny'/g'
   grep -rl 'MAXY'  $CAVE_DIR/bundles/scales/WFO.xml | xargs sed -i 's/MAXY/'$maxy'/g'

   lowx=$(cat $regional  |grep $site | cut -d"," -f4  | tr -d '[[:space:]]')
   highx=$(cat $regional |grep $site | cut -d"," -f5  | tr -d '[[:space:]]')
   lowy=$(cat $regional  |grep $site | cut -d"," -f6  | tr -d '[[:space:]]')
   highy=$(cat $regional |grep $site | cut -d"," -f7  | tr -d '[[:space:]]')
   minx=$(cat $regional  |grep $site | cut -d"," -f8  | tr -d '[[:space:]]')
   maxx=$(cat $regional  |grep $site | cut -d"," -f9  | tr -d '[[:space:]]')
   miny=$(cat $regional  |grep $site | cut -d"," -f10 | tr -d '[[:space:]]')
   maxy=$(cat $regional  |grep $site | cut -d"," -f11 | tr -d '[[:space:]]')

   grep -rl 'LOWX'  $CAVE_DIR/bundles/scales/Regional.xml | xargs sed -i 's/LOWX/'$lowx'/g'
   grep -rl 'HIGHX' $CAVE_DIR/bundles/scales/Regional.xml | xargs sed -i 's/HIGHX/'$highx'/g'
   grep -rl 'LOWY'  $CAVE_DIR/bundles/scales/Regional.xml | xargs sed -i 's/LOWY/'$lowy'/g'
   grep -rl 'HIGHY' $CAVE_DIR/bundles/scales/Regional.xml | xargs sed -i 's/HIGHY/'$highy'/g'
   grep -rl 'MINX'  $CAVE_DIR/bundles/scales/Regional.xml | xargs sed -i 's/MINX/'$minx'/g'
   grep -rl 'MAXX'  $CAVE_DIR/bundles/scales/Regional.xml | xargs sed -i 's/MAXX/'$maxx'/g'
   grep -rl 'MINY'  $CAVE_DIR/bundles/scales/Regional.xml | xargs sed -i 's/MINY/'$miny'/g'
   grep -rl 'MAXY'  $CAVE_DIR/bundles/scales/Regional.xml | xargs sed -i 's/MAXY/'$maxy'/g'

   grep -rl 'XXX' $CAVE_DIR | xargs sed -i 's/XXX/'$site'/g'
   grep -rl 'LATITUDE' $CAVE_DIR | xargs sed -i 's/LATITUDE/'$lat'/g'
   grep -rl 'LONGITUDE' $CAVE_DIR | xargs sed -i 's/LONGITUDE/'$lon'/g'

done
ls -la $BUILD_DIR/utility/cave_static
find $BUILD_DIR/utility/cave_static
# COMMON
cp -R $UTIL/common_static/* $COMMON_DIR/

%install
if [ ! -d %{_baseline_workspace}/%{_localization_directory} ]; then
   echo "ERROR: The specified localization directory does not exist - %{_localization_directory}."
   exit 1
fi

mkdir -p ${RPM_BUILD_ROOT}/awips2/edex/data/utility
if [ $? -ne 0 ]; then
   exit 1
fi

# Copy the localization files
cp -rv %{_baseline_workspace}/localization/utility/* \
   ${RPM_BUILD_ROOT}/awips2/edex/data/utility
if [ $? -ne 0 ]; then
   exit 1
fi
cp -rv %{_baseline_workspace}/rpms/awips2.core/Installer.localization/utility/* \
   ${RPM_BUILD_ROOT}/awips2/edex/data/utility
if [ $? -ne 0 ]; then
   exit 1
fi
# Copy FFMP shapefiles from awips2-static
mkdir -p ${RPM_BUILD_ROOT}/awips2/edex/data/utility/common_static/site/OAX/shapefiles/FFMP/
if [ $? -ne 0 ]; then
   exit 1
fi
cp -rv /awips2/repo/awips2-static/shapefiles/FFMP/* \
   ${RPM_BUILD_ROOT}/awips2/edex/data/utility/common_static/site/OAX/shapefiles/FFMP/
if [ $? -ne 0 ]; then
   exit 1
fi

%pre

%post
# only import the shapefiles and/or hydro databases, if we are on
# the same machine as the db.
if [ ! -d /awips2/database/tablespaces/maps ] ||
   [ ! -f /awips2/database/sqlScripts/share/sql/maps/importShapeFile.sh ]; then
   # we are missing a file or directory, exit
   exit 0
fi

DAMCAT_DATABASE=dc_ob7oax
IHFS_DATABASE=hd_ob92oax
siteid="OAX"
edex_utility="/awips2/edex/data/utility"
data_directory="/awips2/database/data"
DB_OWNER=$(stat -c %U ${data_directory})
I_STARTED_POSTGRESQL="NO"
POSTGRESQL_RUNNING="NO"

log_file="/awips2/database/sqlScripts/share/sql/localization_db.log"
a2_shp_script="/awips2/database/sqlScripts/share/sql/maps/importShapeFile.sh"
a2_postmaster="/awips2/postgresql/bin/postmaster"
a2_pg_ctl="/awips2/postgresql/bin/pg_ctl"
a2_pg_restore="/awips2/postgresql/bin/pg_restore"
site_directory="${edex_utility}/common_static/site/${siteid}"
ffmp_shp_directory="${site_directory}/shapefiles/FFMP"
hydro_db_directory="${site_directory}/hydro/db"

if [ -f ${log_file} ]; then
   /bin/rm -f ${log_file}
fi
/bin/touch ${log_file}
chmod 666 ${log_file}

function restoreHydroDb(){
   if [ ! -d ${hydro_db_directory} ]; then
      return 0
   fi
   if [ ! -f ${hydro_db_directory}/${DAMCAT_DATABASE} ] ||
      [ ! -f ${hydro_db_directory}/${IHFS_DATABASE} ]; then
      echo "The expected Hydro Database Exports are not present!" >> ${log_file}
      return 0
   fi

   /bin/date >> ${log_file}
   echo "Restoring Database ${DAMCAT_DATABASE} ..." >> ${log_file}
   pg_restore -U awipsadmin -C -d postgres ${hydro_db_directory}/${DAMCAT_DATABASE} \
      >> ${log_file} 2>&1
   # do not check the return code because any errors encountered during
   # the restoration may cause the return code to indicate a failure even
   # though the database was successfully restored.
   echo "Restoring Database ${IHFS_DATABASE} ..." >> ${log_file}
   pg_restore -U awipsadmin -C -d postgres ${hydro_db_directory}/${IHFS_DATABASE} \
      >> ${log_file} 2>&1
   echo "INFO: The Hydro databases were successfully restored." >> ${log_file}
}

if ! systemctl status postgresql@awips; then
    i_started_postgresql=1
    systemctl start postgresql@awips
else
    i_started_postgresql=
fi

importShapefiles
restoreHydroDb

if [[ "$i_started_postgresql" != "" ]]; then
    systemctl stop postgresql@awips
fi

exit 0

%preun

%postun

%clean
rm --recursive --force ${RPM_BUILD_ROOT}

%files
%defattr(755,awips,fxalpha,755)
%dir /awips2/edex/data/utility
/awips2/edex/data/utility/*
