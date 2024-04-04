Name: awips2-edex-enableservices
Summary: AWIPS II Edex Enable Services
Version: %{_component_version}
Release: %{_component_release}
Group: AWIPSII
BuildRoot: %{_build_root}
URL: N/A
License: N/A
Distribution: N/A
Vendor: Raytheon
Packager: %{_build_site}
requires: awips2-edex

%description
AWIPS II Edex Enable Installation - Enables EDEX JVMs with systemd.

%prep
# Verify That The User Has Specified A BuildRoot.
if [ "%{_build_root}" = "" ]
then
   echo "ERROR: The RPM Build Root has not been specified."
   exit 1
fi

if [ -d %{_build_root} ]; then
   rm --recursive --force %{_build_root}
fi

%build

%install

%pre

%post
#update edexServiceList on install
if [ "${1}" = "1" ]; then

  #add services to the edex service list
  LIST_FILE=/awips2/edex/conf/edexServiceList
  BASE_SERVICES=(ingest ingestGrib request)

  if [ -f $LIST_FILE ]; then
     source $LIST_FILE

     for service in ${BASE_SERVICES[*]}; do
        addService=true;
        for index in ${!SERVICES[@]};
        do
           if [ ${SERVICES[$index]} = $service ]; then
              addService=false;
           fi
        done
        if $addService; then
           SERVICES=(${SERVICES[@]} $service)
        fi
     done
  else
     SERVICES=${BASE_SERVICES[@]}
  fi

  echo "#generated on $(date)" > $LIST_FILE
  echo "export SERVICES=(${SERVICES[@]})" >> $LIST_FILE

  # enable the standard edex modes
  if [ -f %{_unitdir}/edex_camel@.service ]; then
     for item in "${BASE_SERVICES[@]}";
     do
        /bin/systemctl enable --quiet edex_camel@"${item}"
     done
  fi
fi

%preun
if [ "${1}" = "1" ]; then
   exit 0
fi

LIST_FILE=/awips2/edex/conf/edexServiceList
BASE_SERVICES=(ingest ingestGrib request)

if [ -f $LIST_FILE ]; then
   source $LIST_FILE

   for service in ${BASE_SERVICES[*]}; do
       for index in ${!SERVICES[@]}
       do
           if [ ${SERVICES[$index]} = $service ]; then
              unset SERVICES[$index]
           fi
       done
   done

   echo "#generated on $(date)" > $LIST_FILE
   echo "export SERVICES=(${SERVICES[@]})" >> $LIST_FILE
fi

# shut down and disable the standard modes
for item in "${BASE_SERVICES[@]}";
do
   /bin/systemctl disable --now --quiet edex_camel@"${item}"
done

%postun

%clean
rm --recursive --force %{_build_root}

%files

