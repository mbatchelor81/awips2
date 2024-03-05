#!/bin/bash

#########################################################################
# NOTE: THIS IS NOT A DELTA SCRIPT THAT WILL BE RUN WITH A FRESH AWIPS
# INSTALLATION. IT WILL BE RUN AS PART OF A NATIONAL ACTIVATION OF
# HAZSIMP FOR NON-PRECIPITATION WEATHER (NPW) HAZARDS.
#
# Script: gfeNPWHazSimpTurnkeyInstall.sh
#
# Description: There is a hazard simplification effort surrounding
# Non-Precipitation Weather (NPW) heat and cold hazards. This script
# activates either the "heat", "cold", or "both" components inside GFE.
#
# The actual file pushing is performed by pushTurnKeyFiles.py inside
# the same folder as this script.
#
# Running this script with either the "cold", "heat", or "both" flag will
# perform the following:
#
# a. Overwrite the BASE-level gfeConfig.py and MakeHazardConfig.py files
# b. Scan all overrides of gfeConfig.py and MakeHazardConfig.py and alert
#     the user of manual changes to be made
#
# Summary of Changes:
# "cold" flag:
# - Remove the WC.A, WC.W, and WC.Y phensigs from gfeConfig.py
# - Add the new Cold Weather Advisory (CW.Y) phensig to gfeConfig.py
# - Remove WC.A, WC.W, and WC.Y from the "Winter Weather" category in
#   MakeHazardConfig.py
# - Add CW.Y to the "Non-Precipitation" category in MakeHazardConfig.py
#
# "heat" flag:
# - Replace EH.A --> XH.A and EH.W --> XH.W in gfeConfig.py
# - Replace EH.A --> XH.A and EH.W --> XH.W in the "Non-Precipitation"
#   category in MakeHazardConfig.py
#
# "both" flag:
# - Will perform all the operations specified above in the "cold" and
#    "heat" flags above.
#########################################################################

# Verify a "heat", "cold", or "both" flag is provided
if [ -z "$1" ]
then
    echo "A turnkey flag must be provided. Either: heat, cold, or both"
    echo "Example: ./$0 heat"
    exit 1
fi

# Set the turnkey flag
turnFlag=$1

# Verify the turnkey flag is valid
if [ "$turnFlag" != "heat" ] && [ "$turnFlag" != "cold" ] && [ "$turnFlag" != "both" ]
then
    echo "Invalid turnkey flag provided. Must be either: heat, cold, or both"
    echo "Example: ./$0 cold"
    exit 1
fi

# Verify the user is awips
user=$(whoami)
if [ "$user" != "awips" ]
then
    echo "ERROR: Script must be run as the user 'awips'."
    exit 1
fi

# Verify the setup.env file exists
if [ ! -f "/awips2/edex/bin/setup.env" ]
then
        echo "ERROR: /awips2/edex/bin/setup.env not found. Re-run on dv3."
        exit 1
fi

# Source setup.env to get the $AW_SITE_IDENTIFIER
source /awips2/edex/bin/setup.env
if [ -z ${AW_SITE_IDENTIFIER} ]
then
        echo "ERROR: AW_SITE_IDENTIFIER not set"
        exit 1
fi

# Perform the turnkey operations
python pushTurnKeyFiles.py ${turnFlag} ${AW_SITE_IDENTIFIER}

echo "INFO: GFE NPW HazSimp turnkey script for DCS 22297 complete"
