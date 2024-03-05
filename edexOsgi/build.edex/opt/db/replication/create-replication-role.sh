#!/bin/bash

# This script just creates a PostgreSQL role called 'replication', destroying
# and re-creating the role if it already exists.
#
# Author: tgurney

psql="/awips2/psql/bin/psql"

if [[ "$(id -u)" -ne 0 ]]; then
    echo ERROR: You need to be root.
    exit 1
fi

echo "INFO: Creating replication role"

sudo -u awips -i "${psql}" -v ON_ERROR_STOP=1 --user=awipsadmin --db=metadata << EOF || exit 1
    begin transaction;
    drop role if exists replication;
    create role replication with replication login password 'replication';
    commit transaction;
EOF

echo "INFO: Finished. No errors reported."
