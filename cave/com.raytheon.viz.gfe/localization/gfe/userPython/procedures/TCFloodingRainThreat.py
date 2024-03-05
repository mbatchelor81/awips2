# ----------------------------------------------------------------------------
# This software is in the public domain, furnished "as is", without technical
# support, and with no warranty, express or implied, as to its usefulness for
# any purpose.
#
<<<<<<< HEAD
# InlandFloodThreat
#
# Author: lefebvre,santos
# Last Modified: April 4, 2012 - Fixed to handle negative gridded FFG.
# Migrated procedure for AWIPS2. Updated 6/22/2012.   S.O.
# 
# Comment on 05/21/2014 (Santos): Some sites used QPF and others QPF6hr. Check that parameter 
# in getQPFGrid method. Also in AWIPS 2 FFG is gridded and called just FFG. 
# This is fixed in getRFCFFGModels method.
#
# LeFevbre/Santos: This is the version being turned in for baseline in 16.1.2 as of 12/7/2015. It includes fixes
#for new ERP data changes that took place in Summer of 2015 and better handling of grid points where there
#is no FFG guidance available.
=======
# TCFloodingRainThreat
#
# Author: Tom LeFebvre/Pablo Santos
#
# Last Modified: April 4, 2012 - Fixed to handle negative gridded FFG.
# Migrated procedure for AWIPS2. Updated 6/22/2012.   S.O.
#
# Comment on 05/21/2014 (Santos): Some sites used QPF and others QPF6hr. Check that parameter
# in getQPFGrid method. Also in AWIPS 2 FFG is gridded and called just FFG.
# This is fixed in getRFCFFGModels method.
#
# LeFevbre/Santos: This is the version being turned in for baseline in 16.1.2 as of 12/7/2015. It includes fixes
# for new ERP data changes that took place in Summer of 2015 and better handling of grid points where there
# is no FFG guidance available.
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
# Last Modified
# 7/15/2016 - Lefebvre/Santos: working on code to add PQPF to the algorithm.
# 9/2/2016 - Lefebvre/Santos: Finished integrating {QPF into the algorithm
# 9/7/2016 - Lefebvre/Santos: Added better logic for grid missing messages and Don't use guidance option.
<<<<<<< HEAD
# 9/7/2016 - Lefebvre/Santos: Change ppffg timeRanges to anchor on 12Z cycles. 
# VERSION 17.1.1 = The one checked in.
# 11/14/2016 - Santos - Modified at testbed in Silver Springs to fix overlap variable to do the composite
# of the rfc list edit areas, not just the overlap with cwa mask. Commented out statusBarMsg for the ppffg inventories.
# 07/21/2017 - Tweaked for 2018 baseline (17.3.1) based on WPC recommendations following upcoming change in ERPs 
=======
# 9/7/2016 - Lefebvre/Santos: Change ppffg timeRanges to anchor on 12Z cycles.
# VERSION 17.1.1 = The one checked in.
# 11/14/2016 - Santos - Modified at testbed in Silver Springs to fix overlap variable to do the composite
# of the rfc list edit areas, not just the overlap with cwa mask. Commented out statusBarMsg for the ppffg inventories.
# 07/21/2017 - Tweaked for 2018 baseline (17.3.1) based on WPC recommendations following upcoming change in ERPs
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
# to neighborhood based probabilities. Check 2018 version of HTI User Guide for details. PS/TL
# 8/31/2017 - Fixed issues found during Harvey when FFG was zero across large chunks of the area. PS/TL
# 10/21/2017 - Additional tweaks made per Raytheon suggestions during code review. (DR20333)
# 11/14/2017 - Fixed ERP thresholds per WPC recommendations during SWiT. Fixed also minimum value allowed for
# FFG guidance in GFE D2D FFGXXX db to treat NO DATA or exception values as negative in GFE. This change was made in
# the RFCFFGParameterInfo file. Otherwise logic below would not work.
# 05/20/2019 - Got rid of code dealing with obsolete text FFG.
# 07/27/2019 - PS Working on this version from current baseline with text FFG code removed for Testing with Past cases.
# 08/28/2019 bart.stough@noaa.gov DR 21354 Remove FFG Blending
<<<<<<< HEAD
# 
# 12/6/2019 - Cleaned Code to Preserve New Algorithm Coding based on WPC Option 1a based on Past cases (Harvey and Florence). 
# To be made available to the field for 2020 as a site level override if it cannot make the 19.3.1 baseline. Changes to this 
# algorithm were necessary due to elimination of the text FFG and the noisy nature of the gridded FFG forcing forecasters
# at times to make significant post edits. The change to the algorithm made here was vetted by the Tropical Program 
# Office and coordinated with WPC. The new algorithm lines the flooding rain threat much better with the excessive rainfall outlook.
# This is how it works:
# For Day 1, 2 and 3 of the Excessive rainfall outlook period:
# If the excessive rainfall probability (ERP) >=5% Flooding Rain Threat is Yellow for potential of Localized Flooding.
# If the ERP >= 10% Flooding Rain Threat is Orange for potential of Moderate Flooding
# If the ERP >= 20% Flooding Rain Threat is Red for potential of Major Flooding
# If the ERP >= 50% or ERP >= 20% and the Storm Total Accum is > 10 Inches for the corresponding 24 hour period (Day 1, 2, or 3), then Flooding Rain Threat is purple for potential of extreme Flooding resulting in devastating to catastrophic impacts.  
=======
#
# 12/6/2019 - Cleaned Code to Preserve New Algorithm Coding based on WPC Option 1a based on Past cases (Harvey and Florence).
# To be made available to the field for 2020 as a site level override if it cannot make the 19.3.1 baseline. Changes to this
# algorithm were necessary due to elimination of the text FFG and the noisy nature of the gridded FFG forcing forecasters
# at times to make significant post edits. The change to the algorithm made here was vetted by the Tropical Program
# Office and coordinated with WPC. The new algorithm lines the flooding rain threat much better with the excessive rainfall outlook.
# This is how it works:
# For Day 1, 2 and 3 of the Excessive rainfall outlook period (Updated 2/15/2022 to match WPC changes):
# If the excessive rainfall probability (ERP) >=5% Flooding Rain Threat is Yellow for potential of Localized Flooding.
# If the ERP >= 15% Flooding Rain Threat is Orange for potential of Moderate Flooding
# If the ERP >= 40% Flooding Rain Threat is Red for potential of Major Flooding
# If the ERP >= 70% or ERP >= 40% and the Storm Total Accum is > 10 Inches for the corresponding 24 hour period (Day 1, 2, or 3), then Flooding Rain Threat is purple for potential of extreme Flooding resulting in devastating to catastrophic impacts.
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
# Therefore, the only input paramters to this new version of the algorithm are the ERPs and the QPF grids in the Fcst db.
#
# 12/17/2019 - Tweaks made based on Raytheon's Code Review. PS
#
<<<<<<< HEAD
#Search for COMMENTS to see any local config step you might need to take.
=======
# 01/22/2021 - P. Santos - Added option to move grid forward in time 6 hours.
# 7/12/2021 - J. Lamb - Cleaned up code and made adjustment so tool will work with
# upcoming changes to the NIC in terms of how the input data used is stored in the D2D db.
# 2/15/2022 - Improved GUI, adjusted WPC ERO probability thresholds
# 05/18/2022 - Fixed problem with move-forward option
#
# Search for COMMENTS to see any local config step you might need to take.
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
# ----------------------------------------------------------------------------

##
# This is an absolute override file, indicating that a higher priority version
# of the file will completely replace a lower priority version of the file.
##

MenuItems = ["Populate"]

<<<<<<< HEAD
import numpy as np

import AbsTime
import GridManipulation
import TimeRange

class Procedure (GridManipulation.GridManipulation):
    def __init__(self, dbss):
        GridManipulation.GridManipulation.__init__(self, dbss)

    # returns a list of timeRange with the specified duration in hours over the
    # specified timeRange
    def makeTimeRangeList(self, timeRange, duration):
        trList = []
        sTime = timeRange.startTime().unixTime()
        delta = duration * 3600
        while sTime < timeRange.endTime().unixTime():
            trList.append(self.GM_makeTimeRange(sTime, sTime + delta))
            sTime = sTime + delta

        return trList


    # Returns a list of database IDs matching the specified model name,
    # weather element name and level
    def getModelList(self, modelName, weName, weLevel):
=======
import AbsTime
import TimeRange
import TropicalUtility
import numpy as np
import LogStream

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

    def getModelList(self, modelName, weName, weLevel):
        """
        Returns a list of database IDs matching the specified model name,
        weather element name and level.
        """

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        modelList = []

        availParms = self.availableParms()

        for pName, level, dbID in availParms:
            if modelName in dbID.modelName():
                if weName in pName:
                    if weLevel in level:
<<<<<<< HEAD
                        if dbID not in modelList:   
                            modelList.append(dbID)
        return modelList

    # Find the time of the model with a day 3 grid and truncate the modelTime to the last 12Z
    def getPpffgBaseTime(self):
        ERPModelName = "HPCERP"
        ERPVarName = "ppffg"
        ERPLevel = "SFC"
        # get the list of all available models. They come sorted latest to oldest. 
        modelList = self.getModelList(ERPModelName, ERPVarName, ERPLevel)
        
        if len(modelList) == 0:
            self.statusBarMsg("No ERP Guidance found for ppffg.", "S")
            return None
        
        for model in modelList:
            trList = self.GM_getWEInventory(ERPVarName, model)
            if len(trList) == 0:
                continue
            
            latestHr = (trList[-1].startTime().unixTime() - model.modelTime().unixTime()) // 3600
            
            # return the time of the first model we find with enough data
            if latestHr > 48:
                
                #print "model time with day 3 grid:", model.modelTime()
                modelTime = model.modelTime().unixTime() - (12 * 3600)
                
                # truncate the model time to the last 12Z cycle
                baseTime = int(modelTime / (3600 * 24)) * (3600 * 24) + (12 * 3600)
                return AbsTime.AbsTime(baseTime)
            
        # If we get here, we have found no models with 72 hours of data so return the latest model time
        self.statusBarMsg("No model runs found with 72 hours of grids. Using latest model")
        return modelList[0].modelTime()
    
    # Fetch ERP probabilistic data using the latest available model. In some cases 
    # the grids retrieved may originate from more than one model version. In all cases,
    # latest guidance available for each time slot will returned.
    # Returns a dictionary with key as timeRange and grid as the data.    
    def getERPGuidance(self, weName, trList):
        
        ERPModelName = "HPCERP"
        ERPLevel = "SFC"

        #  Get the list of all available models. They come sorted latest to oldest. 
        modelList = self.getModelList(ERPModelName, weName, ERPLevel)
        if len(modelList) == 0:  # No grids found for the model/weName combination
            return {}  # So just return an empty GridDict
                       
        # For each timeRange, find the model with the latest grid and save that
        gridDict = {}
        for tr in trList:
            
            # Determine the equivalent d2D timeRange based on GFE QPF tr in the trList 
            d2dTR = self.GM_makeTimeRange(tr.endTime().unixTime(), tr.endTime().unixTime() + 3600)

            foundGrid = False
            for model in modelList:
            
            #  See if the ERP grids we want are in this model cycle
                d2dInv = self.GM_getWEInventory(weName, model)
                
                
                if d2dTR not in d2dInv:
                    continue          
                
                # Fetch the grid and save it
                grid = self.getGrids(model, weName, ERPLevel, d2dTR, mode="First")
                gridDict[tr] = grid
                
                modelStr = str(model.modelTime())[0:13] + "Z"
                
                #print("MODEL STRING IS: ", modelStr)
                                
                if modelList.index(model) != 0:
                    # Suppress messages for ppffg for the last timeRange only, since ppffg only arrives once per day
                    if weName == "ppffg" and tr == trList[-1]:
                        pass
                     
                foundGrid = True
                break
            
=======
                        if dbID not in modelList:
                            modelList.append(dbID)
        return modelList

    def getPpffgBaseTime(self):
        """
        Find the time of the model with a day 3 grid and truncate the modelTime
        to the last 12Z.
        """

        ERPModelName = "HPCERP"
        ERPVarName = "ppffg"
        ERPLevel = "SFC"
        # get the list of all available models. They come sorted latest to oldest.
        modelList = self.getModelList(ERPModelName, ERPVarName, ERPLevel)

        if not modelList:
            self.statusBarMsg("No ERP Guidance found for ppffg.", "S")
            return None

        for model in modelList:
            trList = self.GM_getWEInventory(ERPVarName, model)
            if not trList:
                continue

            latestHr = (
                trList[-1].startTime().unixTime() - model.modelTime().unixTime()
            ) // 3600

            print(latestHr)

            # return the time of the first model we find with enough data
            if latestHr > 48:

                LogStream.logVerbose("model time with day 3 grid:", model.modelTime())
                print("model time with day 3 grid:", model.modelTime())
                modelTime = model.modelTime().unixTime() - (12 * 3600)

                # truncate the model time to the last 12Z cycle
                baseTime = int(modelTime / (3600 * 24)) * (3600 * 24) + (12 * 3600)
                print(AbsTime.AbsTime(baseTime))
                return AbsTime.AbsTime(baseTime)

        # If we get here, we have found no models with 72 hours of data so return
        # the latest model time
        self.statusBarMsg(
            "No model runs found with 72 hours of grids. Using latest model"
        )
        return modelList[0].modelTime()

    def getERPGuidance(self, weName, trList):
        """
        Fetch ERP probabilistic data using the latest available model. In some cases
        the grids retrieved may originate from more than one model version. In all cases,
        latest guidance available for each time slot will returned.
        Returns a dictionary with key as timeRange and grid as the data.
        """

        ERPModelName = "HPCERP"
        ERPLevel = "SFC"

        #  Get the list of all available models. They come sorted latest to oldest.
        modelList = self.getModelList(ERPModelName, weName, ERPLevel)
        if not modelList:  # No grids found for the model/weName combination
            return {}  # So just return an empty GridDict

        # For each timeRange, find the model with the latest grid and save that
        gridDict = {}
        for tr in trList:

            # Determine the equivalent d2D timeRange based on GFE QPF tr in the trList
            # Add wiggle room to allow for slight variation in time position of this
            # ppffg grid
            d2dTR = self.GM_makeTimeRange(
                tr.endTime().unixTime() - 7200, tr.endTime().unixTime() + 3600
            )

            foundGrid = False
            for model in modelList:

                #  See if the ERP grids we want are in this model cycle
                d2dInv = self.GM_getWEInventory(weName, model, timeRange=d2dTR)
                if not d2dInv:
                    continue

                # Fetch the grid and save it
                grid = self.getGrids(model, weName, ERPLevel, d2dInv[0])
                gridDict[tr] = grid

                modelStr = str(model.modelTime())[0:13] + "Z"

                LogStream.logVerbose("MODEL STRING IS: ", modelStr)

                if modelList.index(model) != 0:
                    # Suppress messages for ppffg for the last timeRange only,
                    # since ppffg only arrives once per day
                    if weName == "ppffg" and tr == trList[-1]:
                        pass

                foundGrid = True
                break

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            # If we get here, no model was found with the TR we want
            if not foundGrid:
                gridDict[tr] = None
                self.statusBarMsg("No ERP found for timeRange:" + str(tr), "S")
<<<<<<< HEAD
            
        return gridDict

    # Returns the QPF sum over the specified timeRange 

    def getQPFGrid(self, timeRange):
#
#  This assumes QPF has a constraint of TC6NG. If not and your office uses QPF6
#  or QPF6hr you will need to change this here accordingly.
#
        #  Inventory all QPF grids from the Fcst database
        trList = self.GM_getWEInventory("QPF", self.mutableID(), timeRange=timeRange)
        if len(trList) == 0:
=======

        return gridDict

    def getQPFGrid(self, timeRange):
        """
        Returns the QPF sum over the specified timeRange.
        This assumes QPF has a constraint of TC6NG. If not and your office uses QPF6
        or QPF6hr you will need to change this here accordingly.
        """

        #  Inventory all QPF grids from the Fcst database
        trList = self.GM_getWEInventory("QPF", self.mutableID(), timeRange=timeRange)
        if not trList:
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            return None

        qpfGrid = self.empty()
        for tr in trList:
            grid = self.getGrids(self.mutableID(), "QPF", "SFC", timeRange)
            qpfGrid += grid

        return qpfGrid
<<<<<<< HEAD
    
    def getOverlappingTR(self, tr6, tr24List):
        
=======

    def getOverlappingTR(self, tr6, tr24List):

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        for tr24 in tr24List:
            if tr6.overlaps(tr24):
                return tr24
        return None

    def execute(self, varDict):
<<<<<<< HEAD
          
        ### CONFIGURATION SECTION  ################################
        ### Levels must exactly match the levels in the inland threat
        ### weather element.
        ### Next line changed for 2020.
        
        erps = [0.0, 5.0, 10.0, 20.0, 50.0, 100.0]   # WPC Option 1a
#      
        try:
            threatKeys = self.getDiscreteKeys("FloodingRainThreat")
        except:
            threatKeys = ["None", "Elevated", "Mod", "High", "Extreme"]

        ppffgBaseTime = self.getPpffgBaseTime().unixTime()
        ppffgTimeRange = self.GM_makeTimeRange(ppffgBaseTime, ppffgBaseTime + (3600 * 72))

        # make a 72 hour timeRange and a list of 24 hour timeRanges based on the anchorTime
        ppffgTRList = self.makeTimeRangeList(ppffgTimeRange, 24)

        # Create an empty discrete grid
        maxFloodThreat = np.zeros(self.getGridShape(), np.int8)
=======

        erps = [0.0, 5.0, 15.0, 40.0, 70.0, 100.0]

        # Current hour
        self.curHr = self._gmtime().timetuple().tm_hour

        threatWEName = "FloodingRainThreat"

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

        ppffgBaseTime = self.getPpffgBaseTime().unixTime()
        ppffgTimeRange = self.GM_makeTimeRange(
            ppffgBaseTime, ppffgBaseTime + (3600 * 72)
        )

        # make a 72 hour timeRange and a list of 24 hour timeRanges based on the
        # anchorTime
        ppffgTRList = self.GM_makeTimeRangeList(
            ppffgTimeRange, duration=24, interpHours=24
        )

        # Create an empty discrete grid
        maxFloodThreat = self.empty(dtype=np.int8)
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

        # Get the ERP grids and stuff them in six hour time blocks to match
        # the cummulative QPF grids will create later
        ppffgGridDict = self.getERPGuidance("ppffg", ppffgTRList)

        if not ppffgGridDict:  # Didn't find any ppffg guidance
<<<<<<< HEAD
            self.statusBarMsg("The current ERP guidance is not available. Please re-run this tool at a later time.", "S")
            return
        
        #### DEBUG DEBUG  DEBUG ########################################################################################
           
        for tr in ppffgTRList:
            self.createGrid(self.mutableID(), "ERP", "SCALAR", ppffgGridDict[tr], tr, precision=2)
            
        #### DEBUG DEBUG  DEBUG ########################################################################################
        

        for probTR in ppffgTRList:
            qpfFcstGrid = self.getQPFGrid(probTR) 
            self.createGrid(self.mutableID(), "StormFRTQPF", "SCALAR", qpfFcstGrid, probTR, precision=2)
            
            # get the EPR grid
            
            # Fetch the erp grids and reference by timeRange (24 hours each)
            # Use the probTR in this loop and timeRange.overlaps to figure out which erp grid to use.
            ppffgTR = self.getOverlappingTR(probTR, ppffgTRList)
            if ppffgTR is None:
                continue
                        
            ppffgGrid = ppffgGridDict[ppffgTR] 
          
=======
            self.statusBarMsg(
                "The current ERP guidance is not available. "
                "Please re-run this tool at a later time.",
                "S",
            )
            return

        # DEBUG
        for tr in ppffgTRList:
            self.createGrid(
                self.mutableID(), "ERP", "SCALAR", ppffgGridDict[tr], tr, precision=2
            )
        # DEBUG

        for probTR in ppffgTRList:
            qpfFcstGrid = self.getQPFGrid(probTR)
            self.createGrid(
                self.mutableID(),
                "StormFRTQPF",
                "SCALAR",
                qpfFcstGrid,
                probTR,
                precision=2,
            )

            # Fetch the erp grids and reference by timeRange (24 hours each)
            # Use the probTR in this loop and timeRange.overlaps to figure out which
            # erp grid to use.
            ppffgTR = self.getOverlappingTR(probTR, ppffgTRList)
            if ppffgTR is None:
                continue

            ppffgGrid = ppffgGridDict[ppffgTR]

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            if ppffgGrid is None:
                self.statusBarMsg("ERP grids missing at timeRange:" + str(probTR), "S")
                continue

<<<<<<< HEAD
            floodThreat = np.zeros(self.getGridShape(), np.int8)

            for e in range(len(erps) - 1):
                eMin = erps[e]
                eMax = erps[e+1]
                erpMask = (ppffgGrid >= eMin) & (ppffgGrid < eMax)
                keyIndex = self.getIndex(threatKeys[e], threatKeys) #e is y and r ix x
                floodThreat[erpMask] = keyIndex
                if e == 4:
                    eMin = erps[e-1]
                    eMax = erps[e]
                    erpMask = (ppffgGrid >= eMin) & (ppffgGrid < eMax) & (qpfFcstGrid > 10.0) # Option 1a
                    if erpMask.any():
                        floodThreat[erpMask] = keyIndex
                
            # Create the grid
            self.createGrid(self.mutableID(), "FloodThreat", "DISCRETE",
                        (floodThreat, threatKeys), probTR,
                        discreteKeys=threatKeys,
                        discreteOverlap=0,
                        discreteAuxDataLength=2,
                        defaultColorTable="gHLS_new")
                    

            maxFloodThreat = np.maximum(floodThreat, maxFloodThreat)
            
        # Make a big timeRange and delete all the FloodingRainThreat grids
        startTime = int(self._gmtime().unixTime()/ 3600) * 3600 - (24 * 3600)
        endTime = startTime + (24 * 3600 * 10)
        dbTR = self.GM_makeTimeRange(startTime, endTime) 
        self.deleteCmd(["FloodingRainThreat"], dbTR)
        cTime = int(self._gmtime().unixTime()/ 3600)  * 3600 
        end = cTime + (6*3600)
        threatTR = self.GM_makeTimeRange(cTime, end)

        self.createGrid(self.mutableID(), "FloodingRainThreat", "DISCRETE",
                        (maxFloodThreat, threatKeys), threatTR,
                        discreteKeys=threatKeys,
                        discreteOverlap=0,
                        discreteAuxDataLength=2,
                        defaultColorTable="gHLS_new")
=======
            floodThreat = self.empty(dtype=np.int8)

            for e in range(len(erps) - 1):
                eMin = erps[e]
                eMax = erps[e + 1]
                erpMask = (ppffgGrid >= eMin) & (ppffgGrid < eMax)
                keyIndex = self.getIndex(threatKeys[e], threatKeys)
                floodThreat[erpMask] = keyIndex
                if e == 4:
                    eMin = erps[e - 1]
                    eMax = erps[e]
                    erpMask = (ppffgGrid >= eMin) & (qpfFcstGrid > 10.0)
                    if erpMask.any():
                        floodThreat[erpMask] = keyIndex

            # Create the grid
            self.createGrid(
                self.mutableID(),
                "FloodThreat",
                "DISCRETE",
                (floodThreat, threatKeys),
                probTR,
                discreteKeys=threatKeys,
                discreteOverlap=0,
                discreteAuxDataLength=2,
                defaultColorTable="gHLS_new",
            )

            maxFloodThreat = np.maximum(floodThreat, maxFloodThreat)

        self.deleteAllGrids(threatWEName)

        self.createGrid(
            self.mutableID(),
            threatWEName,
            "DISCRETE",
            (maxFloodThreat, threatKeys),
            threatTR,
            discreteKeys=threatKeys,
            discreteOverlap=0,
            discreteAuxDataLength=2,
            defaultColorTable="gHLS_new",
        )
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

        return