# ----------------------------------------------------------------------------
#
# This software is in the public domain, furnished "as is", without technical
# support, and with no warranty, express or implied, as to its usefulness for
# any purpose.
#
<<<<<<< HEAD
# TornadoFloodThreat
#
# Author: Tom LeFebvre/Pablo Santos
# Updated: April 16, 2012 to lower Low Category Threshold and hide Sliding Bars
# Migrated procedure for AWIPS2. Updated 6/22/2012.  S.O.
# Sept 19, 2014: Updated Low to Elevated for 2015 Official Implementation. PS
# Modified: By Belk 07/15/2016 to make efficiency improvements, and 
#   refactor to make use of a utility containing common methods with other tools
# Modified: By LeFebvre 09/23/2016 finish conversion to numpy conventions. 
# CHECKED IN for 17.1.1
# Modified: By LeFebvre 06/12/17 - Fixed bug that incremented TornadoThreat
# beyond Extreme and caused a crash.
#
# Modified: By Santos 02/03/2020 to adapt to new SPC Thresholds and Day 2 Individual
# Hazards and better matching against SPC Probability to Categorical Mapping
# CHECKED IN FOR BUILD 19.3.4 DR 21872
#
# Modified: By Harrigan, Don and P. Santos on 07/8/2020 to fix bug that was causing tool to miss
# Day 3 SPC guidance when ran after 00Z. On 07/15/2020 added banner to let forecaster know
# When the new Days 1 to 3 data is still coming in and need to wait longer to run tool.
#
# ----------------------------------------------------------------------------
#
=======
# TCTornadoThreat
#
# Author: Tom LeFebvre/Pablo Santos
#
# ----------------------------------------------------------------------------
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
# SOFTWARE HISTORY
#
# Date         Ticket#     Engineer           Description
# -----------  ----------  -----------        --------------------------
# 02/03/2020   DR21872     psantos            To adapt to new SPC Thresholds and Day 2 Individual
#                                             Hazards and better matching against SPC Probability
#                                             to Categorical Mapping.
# 07/08/2020   DR22123     dharrigan,psantos  Fix bug that was causing tool to miss Day 3 SPC
#                                             guidance when ran after 00Z.
# 02/01/2021   DR22451     psantos            Show a banner to the forecaster letting
#                                             them know to wait until the whole new Day 1 to
#                                             Day 3 cycle data was in before running the tool.
# 06/23/2021   DR22701     mscalora,psantos   Fix to properly determine Day 3. Tool logic broke
#                                             when they added SPC days 4-7 probabilities with
#                                             NIC 11.
<<<<<<< HEAD
=======
#
# 07/12/2021   DCS22519    jlamb              Cleaned up code, added time shift option
# 02/15/2022   DCS22519    jlamb              Made GUI more intuitive based on feedback
# 05/07/2022   DCS22519    jlamb              Fixed problem with move-forward option
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
# ----------------------------------------------------------------------------
##
# This is an absolute override file, indicating that a higher priority version
# of the file will completely replace a lower priority version of the file.
##

# The MenuItems list defines the GFE menu item(s) under which the
# Procedure is to appear.
# Possible items are: Populate, Edit, Consistency, Verify, Hazards
MenuItems = ["Populate"]

import TropicalUtility
import time
<<<<<<< HEAD
import sys
import AbsTime
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import TimeRange
import numpy as np
import LogStream

<<<<<<< HEAD
VariableList = [("Days 1 and 2: If Prob Tor >= 2 -> Elevated\n>= 10 -> Mod\n>= 15 -> High\n>= 30 -> Extreme", "", "label"),
                ("If Prob Sig Tor Present:\nMod -> High\nHigh -> Extreme", "", "label"),
                ("Day 3:\nProb Svr >= 5 -> Elevated \n >= 15 -> Mod", "", "label"),
                ("Day 3: If Prob Sig Svr Present:\nMod -> High", "", "label"),
                ("NOTE: After applying logic above", "", "label"),
                ("THREAT level is the max composite from Day 1-3", "", "label"),    
                ]

class Procedure (TropicalUtility.TropicalUtility):
    def __init__(self, dbss):
        TropicalUtility.TropicalUtility.__init__(self, dbss)


    def variableExists(self, modelName, weName, weLevel):

        # it turns out the the modelName will not match the dbID().model()
        # directly, so it needs to be massaged a bit.
        parts = modelName.split("_")
        if len(parts) >= 4:
            modelName = parts[3]
            
        availParms = self.availableParms()    
        for pName, level, dbID in availParms:
            if dbID.modelName().find(modelName) > -1:
                if pName.find(weName) > -1 and level.find(weLevel) > -1:
                    return True

        return False

    def getWEInventory(self, modelName, WEName, timeRange = None):

        allTimes = TimeRange.allTimes()
        
        if timeRange is None:
            timeRange = allTimes

        weLevel = "SFC"

        if not self.variableExists(modelName, WEName, weLevel):
            return []

        try:
            gridInfo = self.getGridInfo(modelName, WEName, weLevel, timeRange)
        except:
            return []

        trList = []
        for g in gridInfo:
            start = g.gridTime().startTime().unixTime()
            end = g.gridTime().endTime().unixTime()
            tr = self.GM_makeTimeRange(start, end)
            if timeRange.overlaps(tr):
                trList.append(tr)

        return trList    

    # get the current time, truncates to the last six hour value.
    # returns a timeRange with this startTime until 24 hrs from this time
    def make6hrTimeRange(self):
        startTime = int(self._gmtime().unixTime()/ (3600 * 6)) * 3600 * 6
        endTime = startTime + (3600 * 6)
        
        timeRange = self.GM_makeTimeRange(startTime, endTime)

        return timeRange

    # Returns a list of dbIdentifiers that match the specified model
    # name, weName and level.
    def getModelList(self, modelName, weName, weLevel):
        modelList = []

        availParms = self.availableParms()

        for pName, level, dbID in availParms:
            if dbID.modelName().find(modelName) > -1:
                if pName.find(weName) > -1:
                    if level.find(weLevel) > -1:
                        if dbID.modelIdentifier() not in modelList:   
                            modelList.append(dbID.modelIdentifier())
        return modelList

    def determineDay(self, modelTime, validTime):
#
# SPC data for Days 1, 2, and 3 come into the system with different model cycle times. Not as part
# of the same model cycle with forecast hours 24, 48, and 72. Worst, they can come at different times.
# Because of that this is coded as shown below to identify Days 1, 2, and 3. SPC never sends the data before 05Z 
# for the new Day 1-4 cycle. Because of this, you should never run the tool between 05-08Z unless you confirm
# first in your system the new Days 1 to 3 cycles are in the system. This is true of both the new and old versions
# of the tool. Check HTI User Guide on how to check that.
#
=======
VariableList = [
    (
        "Run Option",
        "Recalculate grid using latest data",
        "radio",
        ["Recalculate grid using latest data", "Keep existing grid and shift forward"],
    ),
]


class Procedure(TropicalUtility.TropicalUtility):
    def __init__(self, dbss):
        TropicalUtility.TropicalUtility.__init__(self, dbss)

    def determineDay(self, modelTime, validTime):
        """
        SPC data for Days 1, 2, and 3 come into the system with different model cycle
        times. Not as part of the same model cycle with forecast hours 24, 48, and 72.
        Worse, they can come at different times. Because of that this is coded as shown
        below to identify Days 1, 2, and 3. SPC never sends the data before 05Z for the
        new Day 1-4 cycle. Because of this, you should never run the tool between 05-08Z
        unless you confirm first in your system the new Days 1 to 3 cycles are in the
        system.
        """

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        diff = (validTime - modelTime) // 3600
        if diff < 30:
            return 1
        elif diff >= 30 and diff < 54:
            return 2
<<<<<<< HEAD
        elif  diff >= 54 and diff < 78:
=======
        elif diff >= 54 and diff < 78:
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            return 3

        return 0

<<<<<<< HEAD
    # returns a unix time based on the specified model ID.
    def getModelTime(self, modelName):

        timeStr = modelName[-13:]

        year = int(timeStr[0:4])
        month = int(timeStr[4:6])
        day = int(timeStr[6:8])
        hour = int(timeStr[9:11])

        absTime = AbsTime.absTimeYMD(year, month, day, hour, 0, 0)
        absTime = AbsTime.absTimeYMD(year, month, day, hour, 0, 0)
        
        return absTime.unixTime()

    def getTornadoGrid(self, varName, dayNum):
        siteID = self.getSiteID()
        SPCModelName = siteID + "_D2D_SPC"
        SPCVarName = varName
        SPCLevel = "SFC"

        modelList = self.getModelList("SPC", SPCVarName, SPCLevel)

        hours24 = 24 * 3600

        for modelName in modelList:

            trList = self.getWEInventory(modelName, SPCVarName)
            if len(trList) == 0:   # no grids found for this version
                continue   # go on to older versions

            modelTime = self.getModelTime(modelName)
            currentTime = int(time.time())

            for tr in trList:
                gridDayNum = self.determineDay(currentTime,
                                               tr.startTime().unixTime())
                if gridDayNum == dayNum:
                    grid = self.getGrids(modelName, SPCVarName, SPCLevel, tr)
                    LogStream.logVerbose("modelName, modelTime, tr:", SPCVarName, modelName, modelTime, tr)
=======
    def getTornadoGrid(self, SPCVarName, dayNum):

        # Narrow the search window
        searchTR = self.createTimeRange(self.curHr - 12, self.curHr + 96)

        for modelName in self.modelList:

            # Look through valid D2D_SPC databases until we find data
            trList = self.GM_getWEInventory(
                SPCVarName, modelName, "SFC", timeRange=searchTR
            )
            if not trList:
                continue

            currentTime = int(time.time())

            for tr in trList:
                gridDayNum = self.determineDay(currentTime, tr.startTime().unixTime())
                if gridDayNum == dayNum:
                    grid = self.getGrids(modelName, SPCVarName, "SFC", tr)
                    LogStream.logVerbose("modelName, tr:", SPCVarName, modelName, tr)
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                    return grid, 1

        return None, 0

<<<<<<< HEAD
    # This method adjusts an existing threat grid
    def adjustTornadoGrid(self, tornadoThreat, threatKeys, var, dayNum, extThreshold):
=======
    def adjustTornadoGrid(self, tornadoThreat, threatKeys, var, dayNum, extThreshold):
        """Adjusts an existing threat grid using additional SPC data."""

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        D2DGrid, NumberOfDays = self.getTornadoGrid(var, dayNum)
        if D2DGrid is None:
            return tornadoThreat, NumberOfDays

<<<<<<< HEAD
        # Account for offices using the four key arrangement
        # Just change the "Very Low" to "Low" in the threshDict
        #if "Very Low" not in threatKeys:
        #    # find all places greater than "Very Low or Low" in the tornadoThreat
        #    lowIndex = self.getIndex("Low", threatKeys)
        #else:
        #    lowIndex = self.getIndex("Very Low", threatKeys)
        #lowMask = greater_equal(tornadoThreat, lowIndex)

#        lowMask = greater(tornadoThreat, 0)
        lowMask = tornadoThreat > 0

        # finds all places in the extreme grid >= to the extThreshold
#        xMask = greater_equal(D2DGrid, extThreshold)
        xMask = D2DGrid >= extThreshold

        # increment the threat where these masks intersect
=======
        # finds all places in the extreme grid >= to the extThreshold
        xMask = D2DGrid >= extThreshold

        # increment the threat where these masks intersect
        lowMask = tornadoThreat > 0
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        mask = lowMask & xMask

        # make sure we're not incrementing too far
        extremeIndex = self.getIndex("Extreme", threatKeys)

        # increment the category.  This code assumes that the categories are
        # defined in increasing order of severity.
<<<<<<< HEAD
        tornadoThreat[mask] +=  1
=======
        tornadoThreat[mask] += 1
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

        # Clip the adjusted grid to the maximum allowed value - extremeIndex
        tornadoThreat = np.clip(tornadoThreat, 0, extremeIndex)

        return tornadoThreat, NumberOfDays

<<<<<<< HEAD

=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    def setTornadoGrid(self, tornadoThreat, threatKeys, var, dayNum, threshDict):

        D2DGrid, NumberOfDays = self.getTornadoGrid(var, dayNum)
        if D2DGrid is None:
            return tornadoThreat, NumberOfDays

        # Account for offices using the four key arrangement
<<<<<<< HEAD
        # Just change the "Very Low" to "Low" in the threshDict
      
        if "Very Low" not in threatKeys:
            for key in threshDict:
                if threshDict[key] == "Very Low":
                    threshDict[key] = "Elevated"

        # Set the grid values based on the tornado prob grid and thresholds
        for key in sorted(threshDict): 
            thresh = int(key)
            keyIndex = self.getIndex(threshDict[key], threatKeys)
            # make a temp grid where the thresholds are exceeded
            tempGrid = self.empty(dtype=np.int8)
            tempGrid[D2DGrid >= thresh] =  keyIndex
            # calculate areas where this temp grid exceeds the threatGrid
            mask = tempGrid > tornadoThreat
=======
        if "Very Low" not in threatKeys and "Very Low" in threshDict:
            threshDict["Very Low"] = "Elevated"

        # Set the grid values based on the tornado prob grid and thresholds
        for key in sorted(threshDict):
            thresh = int(key)
            keyIndex = self.getIndex(threshDict[key], threatKeys)

            # make a temp grid where the thresholds are exceeded
            tempGrid = self.empty(dtype=np.int8)
            tempGrid[D2DGrid >= thresh] = keyIndex

            # calculate areas where this temp grid exceeds the threatGrid
            mask = tempGrid > tornadoThreat

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            # update the threatGrid for these areas only
            tornadoThreat[mask] = keyIndex

        return tornadoThreat, NumberOfDays
<<<<<<< HEAD
                    
    def execute(self, varDict):

        threatWEName = "TornadoThreat"
        
        threatKeys = self.getDiscreteKeys(threatWEName)
       
=======

    def execute(self, varDict):

        # Current hour
        self.curHr = self._gmtime().timetuple().tm_hour

        threatWEName = "TornadoThreat"

        # Setup time ranges
        threatTR = self.createTimeRange(self.curHr, self.curHr + 8, "Zulu")
        allTR = self.createTimeRange(self.curHr - 24, self.curHr + 24, "Zulu")

        if varDict["Run Option"] == "Keep existing grid and shift forward":

            # Search for active grids over this time range
            thisInv = self.GM_getWEInventory(
                threatWEName, self.mutableID(), "SFC", allTR
            )
            if not thisInv:
                self.statusBarMsg(
                    "You chose to move forward existing grid but {} is "
                    "missing from Fcst db".format(threatWEName),
                    "S",
                )
                return

            # Get value from last grid of this type
            lastGridVal = self.getGrids(
                self.mutableID(), threatWEName, "SFC", thisInv[-1], noDataError=0
            )

            # No adjustment needed
            if (
                thisInv[-1].startTime() == threatTR.startTime()
                and thisInv[-1].endTime() == threatTR.endTime()
            ):
                return

            # Delete existing grid
            self.deleteAllGrids(threatWEName)

            # Recreate the grid over the desired time range
            self.createGrid(
                self.mutableID(),
                threatWEName,
                "DISCRETE",
                lastGridVal,
                threatTR,
            )

            return

        threatKeys = self.getDiscreteKeys(threatWEName)

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        # Set up the data for processing the various grids.
        # Each entry consists of the D2D variable to be checked,
        # the day number of that grid, and a dictionary that defines
        # each threshold value and the corresponding discrete value.
        # Note the grids will be processed in the order defined in
        # this list.
        actionList = [
<<<<<<< HEAD
            ("ptor", 1, { 2  : "Elevated",
                          10 : "Mod",
                          15 : "High",
                          30 : "Extreme",
                        },
                         "sigtrndprob", 10),  
                      
            ("ptor", 2, { 2  : "Elevated",
                          10 : "Mod",
                          15 : "High",
                          30 : "Extreme",
                        },
                         "sigtrndprob", 10),  
            ("prsvr", 3, { 5 : "Very Low",
                            #15 : "Elevated",
                             5 : "Elevated",
                             15 : "Mod",
                             
                           },
                            "prsigsv", 10),

                    ]

         # make a grid of zeros.  This will be the TornadoThreat grid
=======
            (
                "ptor",
                1,
                {
                    2: "Elevated",
                    10: "Mod",
                    15: "High",
                    30: "Extreme",
                },
                "sigtrndprob",
                10,
            ),
            (
                "ptor",
                2,
                {
                    2: "Elevated",
                    10: "Mod",
                    15: "High",
                    30: "Extreme",
                },
                "sigtrndprob",
                10,
            ),
            (
                "prsvr",
                3,
                {
                    5: "Elevated",
                    15: "Mod",
                },
                "prsigsv",
                10,
            ),
        ]

        # Get list of available SPC D2D databases, listed latest to earliest
        self.modelList = []
        for i in range(0, -20, -1):
            thisDb = self.findDatabase("D2D_SPC", i)
            if not thisDb.isValid():
                break

            self.modelList.append(thisDb)

        # make a grid of zeros.  This will be the TornadoThreat grid
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        tornadoThreat = self.empty(dtype=np.int8)

        TotalDays1 = 0
        TotalDays2 = 0
        for var, dayNum, threshDict, xVar, xThreshold in actionList:
<<<<<<< HEAD

            tornadoThreat, NumberOfDays1 = self.setTornadoGrid(tornadoThreat, threatKeys,
                                                var, dayNum, threshDict)
            TotalDays1 += NumberOfDays1
            
            # now adjust the grid based on the extreme grid category
            tornadoThreat, NumberOfDays2 = self.adjustTornadoGrid(tornadoThreat, threatKeys,
                                                   xVar, dayNum, xThreshold)
            TotalDays2 += NumberOfDays2

        LogStream.logVerbose("TotalDays1 and TotalDays2 for var1 and var2 are: ", TotalDays1, TotalDays2)

        if TotalDays1 != 3 or TotalDays2 != 3:
            self.statusBarMsg("Did Not Retrieve SPC Probabilities For Days 1, 2, and 3." +
            " This likely means you run tool between 05Z and 08Z" +
            " and the new Days 1-3 data is still coming in. Wait til new data" +
            " for Days 1-3 is completely in the system and run tool again." +
            " Check in SPC website if tornado probabilities for Days 1 and 2 AND" +
            " severe weather probabilities for Day 3 have all been posted.", "S")
            return

        # make a timeRange - 6 hours long, rounded to nearest hour
        startTime = int(self._gmtime().unixTime()/ 3600) * 3600
        endTime = startTime + (6 * 3600)
        threatTR = self.GM_makeTimeRange(startTime, endTime)

        # remove any old grids that are lying around
        startTime = int(self._gmtime().unixTime()/ 3600) * 3600 - (24 * 3600)
        endTime = startTime + (24 * 3600 * 10)
        removeTR = self.GM_makeTimeRange(startTime, endTime)
        self.deleteCmd([threatWEName], removeTR)

        # create the TornadoThreat Grid
        self.createGrid(self.mutableID(), threatWEName, "DISCRETE",
                        (tornadoThreat, threatKeys), threatTR,
                        discreteKeys=threatKeys,
                        discreteOverlap=0,
                        discreteAuxDataLength=2,
                        defaultColorTable="Hazards")

        return
=======
            tornadoThreat, NumberOfDays1 = self.setTornadoGrid(
                tornadoThreat, threatKeys, var, dayNum, threshDict
            )

            TotalDays1 += NumberOfDays1

            # now adjust the grid based on the extreme grid category
            tornadoThreat, NumberOfDays2 = self.adjustTornadoGrid(
                tornadoThreat, threatKeys, xVar, dayNum, xThreshold
            )

            TotalDays2 += NumberOfDays2

        LogStream.logVerbose(
            "TotalDays1 and TotalDays2 for var1 and var2 are: ", TotalDays1, TotalDays2
        )

        if TotalDays1 != 3 or TotalDays2 != 3:
            self.statusBarMsg(
                "Did Not Retrieve SPC Probabilities For Days 1, 2, and 3. This likely "
                "means you ran the tool between 05Z and 08Z and the new Day 1-3 data "
                "is still coming in. Check SPC website and re-run after tornado "
                "probabilities for Days 1 and 2 AND severe weather probabilities for "
                "Day 3 have all been posted.",
                "S",
            )
            return

        # remove any old grids that are lying around
        self.deleteAllGrids(threatWEName)

        # create the TornadoThreat Grid
        self.createGrid(
            self.mutableID(),
            threatWEName,
            "DISCRETE",
            (tornadoThreat, threatKeys),
            threatTR,
            discreteKeys=threatKeys,
            discreteOverlap=0,
            discreteAuxDataLength=2,
            defaultColorTable="Hazards",
        )

        return
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
