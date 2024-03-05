#!/awips2/python/bin/python

########################################################################
#
# pushTurnKeyFiles.py arg1 arg2
#
# Input Arguments:
# arg1 = The turnkey flag (i.e., "cold", "heat", or "both")
# arg2 = The site ID pulled from ${AW_SITE_IDENTIFIER} environment
#        variable
#
# Description: There is a hazard simplification effort surrounding
# Non-Precipitation Weather (NPW) heat and cold hazards. This script
# activates either the "cold", "heat", or "both" components inside GFE.
#
# Running this script with either the "cold", "heat", or "both" flag will
# perform the following:
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
########################################################################

import os, re, shutil
from sys import exit, argv
from glob import glob

def getRegion(wfoID):
    siteRegionDict = {}
    siteRegionDict['AR'] = ['AFG', 'AJK', 'ALU', 'AER', 'ACR', 'AFC',
                            'VRH', 'AAWU', 'AVAK']
    siteRegionDict['CR'] = ['ABR', 'APX', 'ARX', 'BIS', 'BOU', 'CYS',
                            'DDC', 'DLH', 'DMX', 'DTX', 'DVN', 'EAX',
                            'FGF', 'FSD', 'GID', 'GJT', 'GLD', 'GRB',
                            'GRR', 'ICT', 'ILX', 'IND', 'IWX', 'JKL',
                            'LBF', 'LMK', 'LOT', 'LSX', 'MKX', 'MPX',
                            'MQT', 'OAX', 'PAH', 'PUB', 'RIW', 'SGF',
                            'TOP', 'UNR']
    siteRegionDict['ER'] = ['AKQ', 'ALY', 'BGM', 'BOX', 'BTV', 'BUF',
                            'CAE', 'CAR', 'CHS', 'CLE', 'CTP', 'GSP',
                            'GYX', 'ILM', 'ILN', 'LWX', 'MHX', 'OKX',
                            'PBZ', 'PHI', 'RAH', 'RLX', 'RNK']
    siteRegionDict['PR'] = ['GUM', 'HFO', 'PBP', 'PPG', 'PQW', 'PQE']
    siteRegionDict['SR'] = ['ABQ', 'AMA', 'BMX', 'BRO', 'CRP', 'EPZ',
                            'EWX', 'FFC', 'FWD', 'HGX', 'HUN', 'JAN',
                            'JAX', 'KEY', 'LCH', 'LIX', 'LUB', 'LZK',
                            'MAF', 'MEG', 'MFL', 'MLB', 'MOB', 'MRX',
                            'OHX', 'OUN', 'SHV', 'SJT', 'SJU', 'TAE',
                            'TBW', 'TSA']
    siteRegionDict['WR'] = ['BOI', 'BYZ', 'EKA', 'FGZ', 'GGW', 'HNX',
                            'LKN', 'LOX', 'MFR', 'MSO', 'MTR', 'OTX',
                            'PDT', 'PIH', 'PQR', 'PSR', 'REV', 'SEW',
                            'SGX', 'SLC', 'STO', 'TFX', 'TWC', 'VEF']

    nwsRegion = None
    for region in siteRegionDict:
        if wfoID in siteRegionDict.get(region):
            nwsRegion = region
            break
    return nwsRegion

def confirmMessage(fileName, filePath):
    '''
    Method to solicit input from the user
    '''
    answer = ""
    msg = f"Do you want this script to create a {fileName} override at \n{filePath} (Y/N)? "
    while answer not in ["y", "n"]:
      answer = input(msg).lower()
    return answer == "y"

def deletePath(inFile):
    '''
    Method to delete a file or path
    '''
    if os.path.isdir(inFile):
        shutil.rmtree(inFile)
    else:
        os.remove(inFile)
    if not os.path.exists(inFile):
        print(f"  Deleted {inFile}")

def printMessageBreak():
    print("=========================================")
##############
# Main Method
##############

# Determine flag being used when the script is being run
if len(argv) < 2 or argv[1].lower() not in ["heat", "cold", "both"]:
    print("Please specify either a \"heat\", \"cold\", or \"both\" turnkey flag")
    print(f"e.g., python {argv[0]} heat")
    exit()

# Retrieve turnkey flag passed in from gfeNPWHazSimpTurnkeyInstall.sh
runFlag = argv[1].lower()

# Retrieve the $AW_SITE_IDENTIFIER passed in from gfeNPWHazSimpTurnkeyInstall.sh
wfoID = argv[2]

if runFlag == "both":
    runFlagString = "Cold & Heat Updates"
else:
    runFlagString = f"{runFlag.capitalize()} Update"

# Path to the current directory
scriptDirectory = os.path.dirname(os.path.realpath(__file__))

# Path to BASE-level GFE files
caveRootDir = "/awips2/cave/etc/gfe/userPython"
gfeConfigFile = os.path.join(caveRootDir, "gfeConfig", "gfeConfig.py")
makeHazardConfigFile = os.path.join(caveRootDir, "utilities", "MakeHazardConfig.py")

# Path to the cave_static directory
utilityRootDir = "/awips2/edex/data/utility"
caveStaticRootDir = os.path.join(utilityRootDir, "cave_static")

# Verify the path to cave_static exists
if not os.path.isdir(caveStaticRootDir):
    print(f"{caveStaticRootDir} is not a directory; can't run this delta script")
    exit()

# Get the NWS region from the WFO ID
nwsRegion = getRegion(wfoID)
awipsSetupFile = "/awips2/edex/bin/setup.env"
if not nwsRegion:
    print(f"No region found for WFO {wfoID}, please check the AW_SITE_IDENTIFIER variable in {awipsSetupFile}.")
    exit()

# Path to the turnkey files
npwHazSimpFolder = os.path.join(scriptDirectory, "GFE_NPW_HazSimp", runFlag)

##################################################################
# Make region-level override of gfeConfig.py
##################################################################
printMessageBreak()
regionOverrideDir = os.path.join(caveStaticRootDir, "region", nwsRegion,
                                 "gfe", "userPython", "gfeConfig")
gfeConfigRegionFile = os.path.join(regionOverrideDir, "gfeConfig.py")
if not os.path.exists(regionOverrideDir):
    os.makedirs(regionOverrideDir, 0o755, exist_ok=True)
    if not os.path.exists(regionOverrideDir):
        print(f"Could not create region override directory: {regionOverrideDir}")
        exit()
fileToCopy = os.path.join(npwHazSimpFolder, "gfeConfig.py")
confirmUpdate = confirmMessage("gfeConfig.py", regionOverrideDir)
if confirmUpdate:
    shutil.copy(fileToCopy, regionOverrideDir)

##################################################################
# Make region-level override of MakeHazardConfig.py
##################################################################
printMessageBreak()
regionOverrideDir = os.path.join(caveStaticRootDir, "region", nwsRegion,
                                 "gfe", "userPython", "utilities")
makeHazardRegionFile = os.path.join(regionOverrideDir, "MakeHazardConfig.py")
if not os.path.exists(regionOverrideDir):
    os.makedirs(regionOverrideDir, 0o755, exist_ok=True)
    if not os.path.exists(regionOverrideDir):
        print(f"Could not create region override directory: {regionOverrideDir}")
        exit()
fileToCopy = os.path.join(npwHazSimpFolder, "MakeHazardConfig.py")
confirmUpdate = confirmMessage("MakeHazardConfig.py", regionOverrideDir)
if confirmUpdate:
    shutil.copy(fileToCopy, regionOverrideDir)

##################################################################
# Notify user to update any overrides to gfeConfig.py
##################################################################
printMessageBreak()
print("Checking for changes that need to be made to python files in cave_static/*/*/gfe/userPython/gfeConfig/*.py")
gfeConfigOverrides = glob(os.path.join(caveStaticRootDir, "*", "*", "gfe", "userPython", "gfeConfig", "*.py"))
for localOverride in gfeConfigOverrides:
    # Skip newly copied region level override
    if localOverride == gfeConfigRegionFile:
        continue

    printMessageBreak()
    allClear = True
    # Open file and parse lines
    f = open(localOverride, "r")

    # If Hazards_commonValues is found, then throw message to user to check for changes to be made
    for line in f:
        matchesFound = re.search("Hazards_commonValues", line)
        if matchesFound:
            allClear = False
            print(f"You need to verify the following changes have been made to:\n{localOverride}\n",
                    "within the Hazards_commonValues entry:")
            if runFlag in ["cold", "both"]:
                print("1. You need to remove the entries for WC.A, WC.W, and WC.Y:\n",
                      "For Example:\n",
                      "Watches|Winter Storm|WC.A\n",
                      "Advisories|Winter Weather|WC.Y\n",
                      "Warnings|Winter Weather|WC.W",
                      )
                print("2. You need to add an entry for the new Cold Weather Advisory (CW.Y):\n",
                      "For Example:\n",
                      "Advisories|Non-Precipitation|CW.Y")
            if runFlag in["heat", "both"]:
                stepNum = 3
                if runFlag == "heat":
                    stepNum = 1
                print(f"{stepNum}. You need to rename the EH.W/EH.A entries to XH.W/XH.A:\n",
                      "For Example:\n",
                      "Watches|Non-Precipitation|EH.A --> Watches|Non-Precipitation|XH.A\n",
                      "Warnings|Non-Precipitation|EH.W --> Warnings|Non-Precipitation|XH.W",
                      )
            break
    # Close out of the file
    f.close()

    if allClear:
       print(f"{localOverride} is compatible\nwith the {runFlagString}...no further action needed.")

##################################################################
# Notify user to update any overrides to MakeHazardConfig.py
##################################################################
printMessageBreak()
print("Checking for overrides to MakeHazardConfig.py")
makeHazardOverrides = glob(os.path.join(caveStaticRootDir, "*", "*", "gfe", "userPython", "utilities", "MakeHazardConfig.py"))
for localOverride in makeHazardOverrides:
    # Skip newly copied region level override
    if localOverride == makeHazardRegionFile:
        continue

    print(f"\nFound {localOverride}...")
    allClear = True

    # Open file and parse lines
    f = open(localOverride, "r")
    lineList = f.read()
    lineList = lineList.split("\n")
    f.close()

    # Set flag to determine if CW.Y message needs to be thrown
    if runFlag == "heat":
        foundCWY = True
    else:
        foundCWY = False

    # Walk through each line in the file
    for i in range(len(lineList)):
        line = lineList[i]
        lineNum = i + 1

        # Checks for the cold turnkey
        if runFlag in ["cold", "both"]:
            for wswHazard in ["WC.Y", "WC.A", "WC.W"]:
                if wswHazard in line:
                    print(f"{wswHazard} found on Line #{lineNum}: This entry needs to be removed from the hazardDict")
                    allClear = False
            if "CW.Y" in line:
                foundCWY = True
        # Checks for the heat turnkey
        if runFlag in ["heat", "both"]:
            for heatHazard in ["EH.A", "EH.W"]:
                if heatHazard in line:
                    heatPhen,heatSig = heatHazard.split(".")
                    print(f"{heatHazard} found on Line #{lineNum}: This hazardDict entry needs to be renamed to XH.{heatSig}")
                    allClear = False

    if not foundCWY:
       print(f"CW.Y not found in {localOverride}: A hazardDict\nentry for CW.Y needs to be",
             "added to the \"Non-Precipitation\" category")
       allClear = False

    if allClear:
       print(f"{localOverride} is compatible with\nthe {runFlagString}...no further action needed.")
