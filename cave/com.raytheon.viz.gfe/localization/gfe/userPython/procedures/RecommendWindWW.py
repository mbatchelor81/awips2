# ----------------------------------------------------------------------------
# This software is in the public domain, furnished "as is", without technical
# support, and with no warranty, express or implied, as to its usefulness for
# any purpose.
#
# RecommendWindWW.py
#
<<<<<<< HEAD
# SOFTWARE HISTORY
=======
# # SOFTWARE HISTORY
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
#
# Date         Ticket#    Engineer    Description
# ------------ ---------- ----------- ------------------------------------------
# May  9, 2019 21020      tlefebvr    Original version
# May 16, 2019 21020      tlefebvr    Code review changes
# Jun  3, 2019 21020      tlefebvr    Limited recommended hazards to inland zones
<<<<<<< HEAD
# Jul 31, 2019 21020      tlefebvr    Fixed Recommended hazards over coastal zones
# Aug  2, 2019 21020      tlefebvr    Code now correctly stores ETNs.
# Aug  3, 2019 21020      tlefebvr    Fixed issue with Define breakpoint zones not
#                                     getting initialized.
# Aug 15, 2019 21020      tlefebvr    Added automatic generation of 
#                                     WindWWEditAreaCoastalZones. Final clean-up
#                                     for code review.
# Aug 20, 2019 21020      tlefebvr    Now plotting all breakpoints for all storms. 
# Aug 22, 2019 21020      tlefebvr    Code Review changes
# Aug 23, 2019 21020      tlefebvr    Code Review change - removed one method.
# Apr  7, 2020 21682      tlefebvr    Added saving of inland zones to the JSON file.
# Apr  8, 2020 21682      tlefebvr    Old Proposed grids are now purged first. 
# Apr 22, 2020 21682      tlefebvr    Fixed ETNs so the work for all basins. 
# May  6, 2020 22033      tlefebvr    Minor changes for Python3. 
# May 20, 2020 22033      tlefebvr    Addressed code review comments.
# June 1, 2020 22033      tlefebvr    Addressed code review comment.
################################################################################

MenuItems = ["Populate"]
=======
# Jul  31 2019 21020      tlefebvr    Fixed Recommended hazards over coastal zones
# Aug  2, 2019 21020      tlefebvr    Code now correctly stores ETNs.
# Aug  3, 2019 21020      tlefebvr    Fixed issue with Define breakpoint zones not
#                                     getting initialized.
# Aug 15, 2019 21020      tlefebvr    Added automatic generation of
#                                     WindWWEditAreaCoastalZones. Final clean-up
#                                     for code review.
# Aug 20, 2019 21020      tlefebvr    Now plotting all breakpoints for all storms.
# Aug 22, 2019 21020      tlefebvr    Code Review changes
# Aug 23, 2019 21020      tlefebvr    Code Review change - removed one method.
# Apr  7, 2020 21682      tlefebvr    Added saving of inland zones to the JSON file.
# Apr  8, 2020 21682      tlefebvr    Old Proposed grids are now purged first.
# Apr 22, 2020 21682      tlefebvr    Fixed ETNs so the work for all basins.
# May  6, 2020 22033      tlefebvr    Minor changes for Python3.
# May 20, 2020 22033      tlefebvr    Addressed code review comments.
# Jun  1, 2020 22033      tlefebvr    Addressed code review comment.
# Jul 23, 2020 22033      tlefebvr    Fixed label issue when plotting indvidual hazards.
# Sep  9, 2020 22203      tlefebvr    Existing hazard grids are combined into a single grid.
# Sep 15, 2020 22203      tlefebvr    Ensure ProposedTropWindWW display matches JSON files.
# Sep 16, 2020 22203      tlefebvr    Added ETNs to hazard keys.
# Sep 17, 2020 22203      tlefebvr    Inland zones are now replaced in the JSON file.
# Sep 21, 2020 22203      tlefebvr    Inland zones are now correctly replaced in the JSON file.
# Sep 22, 2020 22203      tlefebvr    Bug in Inland zone replacement fixed. And fixed again.
# Oct  8, 2020 22203      tlefebvr    Fixed bug to save Recommended grid and not Guiddance grid.
# May 10, 2021 22203      tlefebvr    Added guidance zones to JSON file.
# May 13, 2021 22033      tlefebvr    Changed saveAdvisory to use common version.
# Jul 29, 2021 22531      tlefebvr    Final code clean-up before check-in.
# Aug  2, 2021 22531      tlefebvr    Removed obsolete method for making coastal mask.
# Aug 24, 2021 22531      tlefebvr    Fixed docs strings.
# Sep 13, 2021  8657      randerso    Changed to use etnBaseForBasin().
#                                     Additional code cleanup
# Sep 15, 2021 22531      tlefebvre   Removed edit area option in GUI.
# Sep 21, 2021 22531      tlefebvre   Fixed key:etn issue in displayJSONHazard.
# Sep 21, 2021 22531      tlefebvre   Now storing only the most significant hazard per zone
#                                     in the JSON file and combining appropriate keys.
# Sep 23, 2021 22531      tlefebvre   Fixed combo key issue when determining max hazard per zone.
# Sep 25, 2021 22531      tlefebvre   Fixed issue with same zone in multiple hazards.
#                                     Added code to force edit area to be selected.
# Sep 30, 2021 22531      tlefebvre   Added a check for conflict checking in the JSON fiels before saving.
# Oct 21, 2021 22531      tlefebvre   Fixed issue with multiple storms in makeRecommendedGrid.
# Oct 21, 2021 22531      tlefebvre   Removed superfluous weName definition.
# Nov  1, 2021 22531      tlefebvre   Now using existing Proposed grid to start, if available.
# Dec  6, 2021 22531      tlefebvre   Removed code that saved to JSON file.
# Dec  9, 2021 22531      tlefebvre   Added changes to support "inlandZoneDict".
# Dec 10, 2021 22531      tlefebvre   Fixed issue with conflictChecking.
# Feb 23, 2022 22531      tlefebvre   Fixed code to handle multiple storms.
# Mar 25, 2022 22531      tlefebvre   Remove old Hazards from same ETN in makeRecommendedGrid
# Apr 13, 2022 22531      tlefebvre   Made a few changes for Python3 compatibility.
# Apr 14, 2022 22531      tlefebvre   Snapping drawn edit area to zone boundaries.
# Sep 15, 2022 22531      santos/composano/white Fixes to code post 21.4.1-13 testing.
################################################################################

MenuItems = ["None"]
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import AbsTime, TimeRange
import ProcessVariableList
import RecommendWindWWConfig
import TropicalUtility
import WindWWUtils
import ZoneMap
import copy
import numpy as np

<<<<<<< HEAD
class Procedure (TropicalUtility.TropicalUtility):

    def __init__(self, dbss):
        TropicalUtility.TropicalUtility.__init__(self, dbss)
        self._dbss = dbss
        
        # Make the utility object
        self._WindWWUtils = WindWWUtils.WindWWUtils(self._dbss)
=======

class Procedure (WindWWUtils.WindWWUtils):

    def __init__(self, dbss):
        WindWWUtils.WindWWUtils.__init__(self, dbss)
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

        # Fetch the zone map. This will create one if it's not there
        self._zoneMap = ZoneMap.ZoneMap(self._dbss)
        self._zoneMapGrid = self._zoneMap.zoneMapGrid()

    def getLatestProbWindDBID(self, modelName):
        """
        Finds the latest DBID with the specified model name
        """

        dbIDs = self.availableDatabases()

        latest = next((dbid for dbid in dbIDs if modelName == dbid.modelName()), None)
        if not latest:
            self.statusBarMsg("Error! No databases found with modelName: " + modelName, "S")
        return latest

<<<<<<< HEAD
    def fetchGuidanceGrid(self, dbid, weName, fcstHour, level):
=======
    def fetchGuidanceGrid(self, dbid, weName, fcstHour, level, hazard):
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        """
        Fetches the specified guidance grid
        """
        modelTime = dbid.modelTime().unixTime()

        trList = self.GM_getWEInventory(weName, dbid, level)
        gridStart = modelTime + (fcstHour * 3600)
        gridTime = next(tr for tr in trList if tr.startTime().unixTime() == gridStart)
        if gridTime:
            # Create a small dictionary to make labeling easier
<<<<<<< HEAD
            labelDict = {
                42 : "TRW",
                48 : "HUW",
                54 : "TRA",
                60 : "HUA",
                }

            grid = self.getGrids(dbid, weName, level, gridTime)
            # Plot the guidance for testing
            if "34" in weName:
                if fcstHour in [42, 54]:
                    self.createGrid(self.mutableID(), "Guidance" + labelDict[fcstHour], "SCALAR",
                                    grid, self._timeRange, minAllowedValue=0.0, maxAllowedValue=100.0,
                                    defaultColorTable="SITE/NHA/TPCWindProb", precision=2)
            if "64" in weName:
                if fcstHour in [48, 60]:
                    self.createGrid(self.mutableID(), "Guidance" + labelDict[fcstHour], "SCALAR",
                                    grid, self._timeRange, minAllowedValue=0.0, maxAllowedValue=100.0,
                                    defaultColorTable="SITE/NHA/TPCWindProb", precision=2)
        return grid

    def fetchNHCZoneMask(self):
        """
        Fetch and/or create and store an edit area that represents the set of zones
        that are the responsibility of NHC. If the edit area is not found, create
        and store it for faster performance next time.
        """

        try: # Try to read the nhcZones
            nhcEA = self.getEditArea("WindWWNHCZones")
            self._nhcZoneMask = self.encodeEditArea(nhcEA)
        except: # Make one from scratch
            self.statusBarMsg("Making NHCZone mask. Stand by.", "R")
            nhcZoneList = self._WindWWUtils.breakpointZoneList()
            # Set the mask
            self._nhcZoneMask = self._zoneMap.maskFromZoneList(nhcZoneList)
            # Convert to edit area and save
            nhcEA = self.decodeEditArea(self._nhcZoneMask)
            self.saveEditArea("WindWWNHCZones", nhcEA)
            
        return


=======

            grid = self.getGrids(dbid, weName, level, gridTime)
            # Plot the guidance for testing
            label = hazard.replace(".", "")
            self.createGrid(self.mutableID(), "Guidance" + label, "SCALAR",
                            grid, self._timeRange, minAllowedValue=0.0, maxAllowedValue=100.0,
                            defaultColorTable="GFE/TPCprob", precision=2)
        return grid

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    def getStormNames(self, stormInfoDicts):
        """
        Gets the current list of storm names from the StormInfo JSON file.
        """

        return [storm['stormName'] for storm in stormInfoDicts]

    def getProbWindThreshold(self, zoneType, thresholdType, haz):
        """
        Returns the Probability wind threshold given the specified info.
        """
        key = (zoneType + thresholdType, haz)
        return RecommendWindWWConfig.WSPThresholds[key]

<<<<<<< HEAD
 
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    def getFilteredHazardGrid(self, filterKeys):
        """
        Fetch the hazard grid, but filter all hazards to the specified keys.
        """
        # See if we have an Hazards grids. If not, create an empty one.
        weName = "Hazards"
        trList = self.GM_getWEInventory(weName, self.mutableID())
<<<<<<< HEAD
        if len(trList) == 0:  # no grids found
            hazGrid = self.empty(np.int8)
            hazKeys = self._rankingHazardList
            self.createGrid(self.mutableID(), weName, "DISCRETE", (hazGrid, hazKeys), self._timeRange,
                            discreteKeys=hazKeys, discreteOverlap=1, discreteAuxDataLength=5)
            return hazGrid, hazKeys

        # Otherwise fetch the Hazards grid
        hazardGrid = self.getGrids(self.mutableID(), weName, "SFC", trList[0])
        if hazardGrid is None:
            self.statusBarMsg("ERROR!!! No Hazards grids found.", "S")

        # Filter out all but the specified hazards.
        filteredHazardGrid = self.filterHazardGrid(hazardGrid, filterKeys)
=======
        newHazGrid = self.empty(np.int8)
        hazKeys = self._rankingHazardList
        if len(trList) == 0:  # no grids found
            self.createGrid(self.mutableID(), weName, "DISCRETE", (newHazGrid, hazKeys), self._timeRange,
                            discreteKeys=hazKeys, discreteOverlap=1, discreteAuxDataLength=5)
            return newHazGrid, hazKeys

        elif len(trList) == 1:
            hazardGrid = self.getGrids(self.mutableID(), weName, "SFC", trList[0])
            if hazardGrid is None:
                self.statusBarMsg("Error fetching Hazards grid.", "S")
                return None, None
            filteredHazardGrid = self.filterHazardGrid(hazardGrid, filterKeys)
            return hazardGrid

        # Multiple hazard grids, so merge them into one grid.
        newHazKeys = ["<None>"]
        for tr in trList:
            # Skip any grids in the past
            if tr.endTime().unixTime() < self._gmtime().unixTime():
                continue
            hazardGrid, hazardKeys = self.getGrids(self.mutableID(), weName, "SFC", tr)
            for haz in hazardKeys:
                if haz == "<None>":
                    continue
                hazIndex = self.getIndex(haz, hazardKeys)
                mask = hazardGrid == hazIndex
                if not mask.any():
                    continue
                hazNoETN = self.stripETN(haz)
                newIndex = self.getIndex(hazNoETN, newHazKeys)
                newHazGrid[mask] = newIndex

        # Filter out all but the specified hazards.
        filteredHazardGrid = self.filterHazardGrid((newHazGrid, newHazKeys), filterKeys)
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

        return filteredHazardGrid

    def getETN(self, stormName):
        """
        Lookup and return the ETN from the stormName and stormInfo
        """
<<<<<<< HEAD
        etnDict = self._WindWWUtils.etnDict()
        
        for stormInfo in self._stormInfoDicts:
            if stormInfo["stormName"] == stormName:
                stormNumber = stormInfo["stormNumber"]
                pil = stormInfo["pil"]
                etnValue = etnDict[pil[0:2]]
=======
        for stormInfo in self._stormInfoDicts:
            if stormInfo["stormName"] == stormName:
                stormNumber = stormInfo["stormNumber"]
                stormID = stormInfo["stormID"]
                etnValue = self.etnBaseForBasin(stormID[0:2])
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                break

        return str(stormNumber + etnValue)

    def stripETN(self, hazKey):
        """
        Remove the ETN from the hazKey and return the result.
        """
        while ":" in hazKey:
            pos = hazKey.find(":")
<<<<<<< HEAD
            if pos >=0:
                delStr = hazKey[pos:pos+5]
=======
            if pos >= 0:
                delStr = hazKey[pos:pos + 5]
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                hazKey = hazKey.replace(delStr, "")
        return hazKey

    def addETNToHazardKey(self, hazKey, etnStr):
        """
        Add the specified ETN to the hazKey and return the result
        Handles cases where the keys are combined.
        """
        hazList = hazKey.split("^")
        hazList = [hazKey + ":" + etnStr for hazKey in hazList]
        newHaz = "^".join(hazList)

        return newHaz

    def insertBreakpointHazards(self, initialHazardGrid):
        """
        Uses the specified initialHazardGrid and assigns hazards to it
        using the information in the specified stormInfo file.
        """
        hazardGrid, hazKeys = initialHazardGrid
        # Initialize the initialHazardGrid to None over the Coastal zone area.
        noneIndex = self.getIndex("<None>", hazKeys)
<<<<<<< HEAD
        hazardGrid[self._nhcZoneMask] = noneIndex
        
        HUAmask = self.empty(np.bool)
        TRWmask = self.empty(np.bool)

        # Get the information
        for stormInfo in self._stormInfoDicts:
            zoneDict = stormInfo["zoneDict"]
=======
        hazardGrid[self._coastalMask] = noneIndex

        # Get the information
        for stormInfo in self._stormInfoDicts:
#             if stormInfo["stormName"] != self._stormName:
#                 continue
            if "zoneDict" in stormInfo:
                zoneDict = stormInfo["zoneDict"]
            else:
                zoneDict = {}
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            stormName = stormInfo["stormName"]

            # These hazards must have ETNs
            etnStr = self.getETN(stormName)

<<<<<<< HEAD
            comboMask = self.empty(np.bool)
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            # Set the hazard value zone by zone
            for haz, zoneList in zoneDict.items():
                for zoneName in zoneList:
                    zoneID = self._zoneMap.zoneID(zoneName)
                    mask = self._zoneMapGrid == zoneID
<<<<<<< HEAD
                    if haz == "HU.A":
                        HUAmask = HUAmask | mask
                    if haz == "TR.W":
                        TRWmask = TRWmask | mask
                    
                    hazKeyETN = self.addETNToHazardKey(haz, etnStr)
                    hazIndex = self.getIndex(hazKeyETN, hazKeys)
                    hazardGrid[mask] = hazIndex
    
            comboMask = HUAmask & TRWmask
            TRWkey = self.addETNToHazardKey("TR.W", etnStr)
            HUAkey = self.addETNToHazardKey("HU.A", etnStr)
            hazKey = TRWkey + "^" + HUAkey
            hazIndex = self.getIndex(hazKey, hazKeys)
            hazardGrid[comboMask] = hazIndex
=======
                    hazKeyETN = self.addETNToHazardKey(haz, etnStr)
                    hazIndex = self.getIndex(hazKeyETN, hazKeys)
                    hazardGrid[mask] = hazIndex
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

        return hazardGrid, hazKeys

    def downgradeAllowed(self, prevHaz, propHaz):
        """
        Returns True if the combination of previous and proposed hazards is allowed.
        """
        if prevHaz == "HU.W" and (propHaz == "TR.W" or propHaz == "<None>"):
            return True
        if prevHaz == "HU.A":
            if propHaz == "TR.A" or propHaz == "<None>":
                return True
        if prevHaz == "TR.W" and propHaz == "<None>":
            return True
        if prevHaz == "TR.A" and propHaz == "<None>":
            return True
<<<<<<< HEAD
        if ((prevHaz == "TR.W^HU.A") or (prevHaz == "HU.A^TR.W")) and (propHaz == "TR.W" or propHaz =="<None>"):
=======
        if ((prevHaz == "TR.W^HU.A") or (prevHaz == "HU.A^TR.W")) and (propHaz == "TR.W" or propHaz == "<None>"):
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            return True

        return False

    def hazardMask(self, hazardGrid, hazardKey):
        """
        Returns a mask over the areas that matches the specified hazard key.
        """
        hazGrid, hazardKeys = hazardGrid
        for hazKey in hazardKeys:
            if hazardKey in hazKey:
                hazIndex = self.getIndex(hazKey, hazardKeys)
                return hazGrid == hazIndex

        return self.empty(np.bool)

<<<<<<< HEAD
    def makeGuidanceGrid(self, dbID, stormName):
        """
        Creates a hazard grid based purely on the wind probability guidance.
        """
        hazardGrid = self.empty(np.int8)
        hazardKeys = self.getDiscreteKeys("ProposedTropWWGuidance")

        maskDict = {}
        maskDict["Inland"] = self._zoneMapGrid >= 100.0
        maskDict["Coastal"] = (self._zoneMapGrid > 0.0) & (self._zoneMapGrid < 100.0)

        # Make and/or populate some handy dictionaries per hazard
        # The _hazardPercentage dict will be used for another algorithm.
        thresholdDict = {}
        hazMaskDict = {}
=======
    def hazardRank(self, hazNoETN):
        if hazNoETN not in self._rankingHazardList:
            return -1

        rank = self._rankingHazardList.index(hazNoETN)
        return rank

    def makeGuidanceGrid(self, stormName):
        """
        Creates a hazard grid based purely on the wind probability guidance. Saves this guidance in the JSON file.
        """
        # Fetch the hazard grid, if we have one.
        hazardGrid = self.empty(np.int8)
        hazardKeys = self.getDiscreteKeys("ProposedTropWWGuidance")

        # Make and/or populate some handy dictionaries per hazard
        # The _hazardPercentage dict will be used for another algorithm.
        thresholdDict = {}
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        for haz in hazardKeys:
            if haz == self._noneHazard:
                continue

<<<<<<< HEAD
            self._hazardPercentage[haz] = self.empty()
            
            hazMaskDict[haz] = self.empty(np.bool)
=======
            self._hazardPercentage[haz] = self.empty(np.float)

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            for zoneType in self._zoneTypes:
                thresholdDict[(haz, zoneType)] = self.getProbWindThreshold(zoneType, "Add", haz)

        # Note: for efficiency the guidance grids have already been fetched in self._guideDict[haz]
        etnStr = self.getETN(stormName)
        guidanceHazKeys = ["<None>"]
<<<<<<< HEAD
=======
        guidanceZoneDict = {}
        maxHazForZone = {}
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        for hazardKey in hazardKeys:
            if hazardKey == self._noneHazard:
                continue

            hazNoETN = self.stripETN(hazardKey)
<<<<<<< HEAD

            if self._debug:
                weName = hazNoETN.replace(".", "") + "guidance"
                self.createGrid("Fcst", weName, "SCALAR", self._guideDict[hazNoETN], self._timeRange)

=======
            if hazNoETN not in self._hazardPercentage:
                continue

            if self._debug:
                weName = hazNoETN.replace(".", "") + "guidance"
                self.createGrid(self.mutableID(), weName, "SCALAR", self._guideDict[hazNoETN], self._timeRange)
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            for zoneType in self._zoneTypes:
                areaThreshold = RecommendWindWWConfig.AreaThresholds[zoneType]
                if zoneType == "Coastal":
                    zoneTypeMask = self._coastalMask
                else:
                    zoneTypeMask = ~self._coastalMask
<<<<<<< HEAD
                    
=======

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                windProbMask = (self._guideDict[hazNoETN] >= thresholdDict[(hazNoETN, zoneType)]) \
                                & self._affectedAreaMask & zoneTypeMask
                zoneIDList = self._zoneMap.getOverlappingZoneIDs(windProbMask)
                for zoneID in zoneIDList:
                    zoneMask = (self._zoneMapGrid == zoneID)
                    if not zoneMask.any():
<<<<<<< HEAD
                        continue

=======
                        print("No mask found for:", self._zoneMap.zoneName(zoneID))
                        continue

                    zoneName = self._zoneMap.zoneName(zoneID)

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                    # Count the points inside the zoneMask to get the zone percentage
                    probPoints = windProbMask & zoneMask
                    percCoverage = float(probPoints.sum()) / zoneMask.sum() * 100.0
                    # Save this value for later
                    self._hazardPercentage[hazNoETN][zoneMask] = percCoverage
<<<<<<< HEAD

                    # If the area coverage threshold is met, assign this hazard to the zone 
                    if percCoverage >= areaThreshold:
                        # Keep track of each hazard's masks
                        hazMaskDict[hazNoETN] = hazMaskDict[hazNoETN] | zoneMask
                        # Set this value over this zone in the hazard grid we will return
                        hazETN = hazNoETN + ":" + etnStr
                        hazIndex = self.getIndex(hazETN, guidanceHazKeys)
                        hazardGrid[zoneMask] = hazIndex

        # Calculate the overlap of HU.A and TR.W and assign the combo key
        comboMask = hazMaskDict["HU.A"] & hazMaskDict["TR.W"] & self._affectedAreaMask
        # Take away the points over the HU.W area to make the final mask
        overlap = comboMask & hazMaskDict["HU.W"]
        comboMask = comboMask & (comboMask ^ overlap)  # subtract HU.W area from comboMask

        # Assign the TR.W^HU.A combined key
        if comboMask.any():
            # Set the value over this mask
            hazETN = "TR.W" + ":" + etnStr + "^" + "HU.A" + ":" + etnStr
            comboIndex = self.getIndex(hazETN, guidanceHazKeys)
            hazardGrid[comboMask] = comboIndex
=======
                    update = True
                    # If the area coverage threshold is met, assign this hazard to the zone
                    if percCoverage >= areaThreshold:
                        # See if we already have a higher ranked hazard for this zone.
                        if zoneID in maxHazForZone:
                            # Check for the combine key case first TR.W, HU.A
                            if maxHazForZone[zoneID] in self._comboHazards and hazNoETN in self._comboHazards:
                                oldHaz = maxHazForZone[zoneID]
                                maxHazForZone[zoneID] = self._comboHazards[0] + "^" + self._comboHazards[1]
                            # See if this hazard ranks higher
                            elif self.hazardRank(hazNoETN) > self.hazardRank(maxHazForZone[zoneID]):
                                oldHaz = maxHazForZone[zoneID]
                                guidanceZoneDict[oldHaz].remove(zoneName)
                                maxHazForZone[zoneID] = hazNoETN
                            else:
                                # hazardRank is less, so do no update with this hazard.
                                update = False
                        else:
                            maxHazForZone[zoneID] = hazNoETN
                        if update:
                            # Set this value over this zone in the hazard grid we will return
                            hazETN = self.addETNToHazardKey(maxHazForZone[zoneID], etnStr)

                            hazIndex = self.getIndex(hazETN, guidanceHazKeys)
                            hazardGrid[zoneMask] = hazIndex
                            # Populate the guidanceZoneDict
                            zoneList = guidanceZoneDict.get(maxHazForZone[zoneID], [])
                            zoneList.append(zoneName)
                            guidanceZoneDict[maxHazForZone[zoneID]] = zoneList

        # Save the guidanceZoneDict
        for stormInfo in self._stormInfoDicts:
            if stormInfo["stormName"] == self._stormName:
                stormInfo["guidanceZoneDict"] = guidanceZoneDict
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

        # Dump the percentage for each zone
        if self._debug:
            for haz in self._hazardPercentage:
                weName = "PercAbvThres" + haz.replace(".", "")
<<<<<<< HEAD
                self.createGrid("Fcst", weName, "SCALAR", self._hazardPercentage[haz], self._timeRange)

        return hazardGrid, guidanceHazKeys

    def makeRecommendedGrid(self, guidanceHazGrid, stormName):
=======
                self.createGrid(self.mutableID(), weName, "SCALAR", self._hazardPercentage[haz], self._timeRange)

        return hazardGrid, guidanceHazKeys

    def dumpHazValue(self, hazGrid, hazKeys, zoneName):
        zoneMask = self.encodeEditArea(zoneName)
        for haz in hazKeys:
            hazIndex = self.getIndex(haz, hazKeys)
            hazMask = (hazGrid == hazIndex) & zoneMask
            perc = float(hazMask.sum()) / zoneMask.sum()
            if perc >= 0.5:
                return haz
        return "<None>"

    def makeRecommendedGrid(self, guidanceHazGrid):
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        """
        Creates the recommended hazard grid based on a complex algorithm
        """

        guidanceGrid, guidanceKeys = guidanceHazGrid
<<<<<<< HEAD
        hazardKeys = guidanceKeys  # make a copy as we want them identical
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        keys = ["<None>"] + self._windHazards
        filteredHazGrid, filteredHazardKeys = self.getFilteredHazardGrid(keys)  # hazard grid from the previous forecast

        if self._debug:
<<<<<<< HEAD
            self.createGrid("Fcst", "FilteredHazards", "DISCRETE", (filteredHazGrid, filteredHazardKeys), self._timeRange,
                                discreteKeys=self._rankingHazardList, discreteOverlap=1,
                                discreteAuxDataLength=5)
            self.createGrid("Fcst", "GuidanceHazards", "DISCRETE", (guidanceGrid, guidanceKeys), self._timeRange,
=======
            self.createGrid(self.mutableID(), "FilteredHazards", "DISCRETE", (filteredHazGrid, filteredHazardKeys), self._timeRange,
                                discreteKeys=self._rankingHazardList, discreteOverlap=1,
                                discreteAuxDataLength=5)
            self.createGrid(self.mutableID(), "GuidanceHazards", "DISCRETE", (guidanceGrid, guidanceKeys), self._timeRange,
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                                discreteKeys=self._rankingHazardList, discreteOverlap=1,
                                discreteAuxDataLength=5)

        copyOfFilteredKeys = copy.copy(filteredHazardKeys)
        diffGrid = self.makeDiffGrid(guidanceHazGrid, (filteredHazGrid, copyOfFilteredKeys))
<<<<<<< HEAD
        
        noChangeMask = diffGrid == 0
        changeMask = ~noChangeMask

        if self._debug:
            self.createGrid("Fcst", "ChangeMask", "SCALAR", changeMask.astype(np.float32), self._timeRange, minAllowedValue=-1.0, maxAllowedValue=1.0,
                                        defaultColorTable="SITE/NHA/DiffWW")
            self.createGrid("Fcst", "NoChangeMask", "SCALAR", noChangeMask.astype(np.float32), self._timeRange, minAllowedValue=-1.0, maxAllowedValue=1.0,
                                        defaultColorTable="SITE/NHA/DiffWW")

        weName = "ProposedTropWindWW"

        hazKeys = []
        byteGrid = self.empty(np.int8)
        # Pre-fill hazKeys with all keys from both the filtered and guidance grids
        for key in filteredHazardKeys:
            if key not in hazKeys:
                i = self.getIndex(key, hazKeys)
        for key in guidanceKeys:
            if key not in hazKeys:
                i = self.getIndex(key, hazKeys)

        # First add the noChange hazards
        for hazKey in hazKeys:
            hazIndex = self.getIndex(hazKey, hazKeys)
            filterIndex = self.getIndex(hazKey, filteredHazardKeys)
            mask = noChangeMask & (filteredHazGrid == filterIndex)
            if mask.any():
                byteGrid[mask] = hazIndex

        for hazKey in hazKeys:
            hazIndex = self.getIndex(hazKey, hazKeys)
            guideIndex = self.getIndex(hazKey, guidanceKeys)
            mask = changeMask & (guidanceGrid == guideIndex)
            if mask.any():
                byteGrid[mask] = hazIndex

        # Overlay the Breakpoint hazards on this grids as they are not to be modified.
        # Note we are purposely ignoring the self._affected area
        hazardGrid, hazardKeys = self.insertBreakpointHazards((byteGrid, hazKeys))

        return hazardGrid, hazardKeys
=======

        noChangeMask = (diffGrid == 0)
        changeMask = ~noChangeMask & self._affectedAreaMask

        if self._debug:
            self.createGrid(self.mutableID(), "ChangeMask", "SCALAR", changeMask.astype(np.float32), self._timeRange, minAllowedValue=-1.0, maxAllowedValue=1.0,
                                        defaultColorTable="SITE/NHA/DiffWW")
            self.createGrid(self.mutableID(), "NoChangeMask", "SCALAR", noChangeMask.astype(np.float32), self._timeRange, minAllowedValue=-1.0, maxAllowedValue=1.0,
                                       defaultColorTable="SITE/NHA/DiffWW")

        hazKeys = []
        byteGrid = self.empty(np.int8)
        # Fetch the ETN so we can filter hazards for this storm only
        etnStr = self.getETN(self._stormName)

        propWEName = "ProposedTropWindWW"
        propInv = self.GM_getWEInventory(propWEName)
        if not propInv:
            hazKeys = []
            byteGrid = self.empty(np.int8)
        else:
            byteGrid, hazKeys = self.getGrids(self.mutableID(), propWEName, "SFC", propInv[-1])
            if byteGrid is None:
                self.statusBarMsg("Error getting existing" + propWEName + "grid.", "S")
                return byteGrid, hazKeys

        # Erase the hazards for this etn
        noneIndex = self.getIndex("<None>", hazKeys)
        for hazKey in hazKeys:
            if etnStr in hazKey:
                mask = byteGrid == self.getIndex(hazKey, hazKeys)
                byteGrid[mask] = noneIndex

        # Pre-fill hazKeys with all keys from both the filtered and guidance grids
        for key in filteredHazardKeys:
            if key not in hazKeys:
                self.getIndex(key, hazKeys)
        for key in guidanceKeys:
            if key not in hazKeys:
                self.getIndex(key, hazKeys)

        # Fetch the ETN so we can filter hazards for this storm only
        etnStr = self.getETN(self._stormName)
        for hazKey in hazKeys:
            # Use valid keys for this storm only.
            if hazKey == "<None>" or etnStr not in hazKey:
                continue
            filterIndex = self.getIndex(hazKey, filteredHazardKeys)
            guideIndex = self.getIndex(hazKey, guidanceKeys)
            hazMask = noChangeMask & (filteredHazGrid == filterIndex)
            guideMask = changeMask & (guidanceGrid == guideIndex)
            hazIndex = self.getIndex(hazKey, hazKeys)
            if guideMask.any():
                byteGrid[guideMask] = hazIndex
            if hazMask.any():
                byteGrid[hazMask] = hazIndex

        return byteGrid, hazKeys
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    def makeDifferenceGrids(self, guidanceGrid, recommendedGrid):
        """
        Calculates the differences between the previous hazard grid
        and the guidance and recommended grids.
        """
        hazardGrid = self.getFilteredHazardGrid(self._rankingHazardList)  # hazard grid from the previous forecast

        hazardRank = self.hazardRankGrid(hazardGrid)
        guideRank = self.hazardRankGrid(guidanceGrid)
        recRank = self.hazardRankGrid(recommendedGrid)

        guideDiff = guideRank - hazardRank
        self.createGrid(self.mutableID(), "GuidanceMinusPrevious", "SCALAR", guideDiff.astype(np.float32), self._timeRange)

        recDiff = recRank - hazardRank
        self.createGrid(self.mutableID(), "RecommendedMinusPrevious", "SCALAR", recDiff.astype(np.float32), self._timeRange)

        return

<<<<<<< HEAD
    def calculateAffectedArea(self, editArea):
        """
        Calculates the area that will ultimately be affected by the tool.
        If the edit area is not empty, use that. Otherwise calculate the 
        union of the guidance area and the area covered by any hazards.
        """
        mask = self.empty(np.bool)
        # See if any area is selected and if so, return its mask
        mask = self.encodeEditArea(editArea)
        if mask.any():
            return mask
        # Fetch the guidance for TR.A which is the largest area
        guideGrid = self._guideDict["TR.A"]
        guideMask = guideGrid > 0.0  # any positive values
=======
    def snapMaskToZones(self, mask):
        zoneList = self._zoneMap.getOverlappingZoneNames(mask)
        zoneMask = self._zoneMap.maskFromZoneList(zoneList)
        return zoneMask

    def calculateAffectedArea(self, editArea):
        """
        Calculates the area that will ultimately be affected by the tool.
        If the edit area is not empty, use that. Otherwise calculate the
        union of the guidance area and the area covered by any hazards.
        """
        mask = self.empty(np.bool)
        # Fetch the guidance for TR.A which is the largest area
        guideGrid = self._guideDict["TR.A"]
        guideMask = guideGrid > 0.0  # any positive values
        # See if any area is selected and if so, return its mask
        mask = self.encodeEditArea(editArea)
        if mask.any():
            mask &= guideMask
            mask = self.snapMaskToZones(mask)
            self.setActiveEditArea(self.decodeEditArea(mask))
            return mask
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

        # Fetch the Hazards and see what is defined there
        level = "SFC"
        dbid = self.mutableID()
        weName = "Hazards"
        allTimes = TimeRange.allTimes()
        hazInv = self.GM_getWEInventory(weName, dbid, level)
        hazMask = self.empty(np.bool)

<<<<<<< HEAD
        if len(hazInv) > 0: # Fetch the grid and determine the hazMask
            hazGrid = self.getGrids(dbid, weName, level, allTimes)

            if isinstance(hazGrid, list):     # there should only be one grid
=======
        if len(hazInv) > 0:  # Fetch the grid and determine the hazMask
            hazGrid = self.getGrids(dbid, weName, level, allTimes)

            if isinstance(hazGrid, list):  # there should only be one grid
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                hazGrid = hazGrid[0]
            # Get the areas where there are some Hazards defined
            byteGrid, keys = hazGrid
            noneIndex = self.getIndex(self._noneHazard, keys)
            hazMask = (byteGrid != noneIndex)  # Find where it's not None

        finalMask = (guideMask | hazMask)

        return finalMask

    def getAllGuidanceGrids(self, dbid):
        """
        Fetches all of the guidance grids that will be needed for the algorithms.
        """
        WIND_PROB_LEVEL = "FHAG10"

        guidanceDict = {}
        hazardKeys = self.getDiscreteKeys("ProposedTropWindWW")
        for haz in hazardKeys:

            if haz == self._noneHazard:
                continue

            if "TR" in haz:
                weName = "prob34"
            elif "HU" in haz:
                weName = "prob64"

            fcstHour = RecommendWindWWConfig.WSPThresholds[("FcstTime", haz)]
<<<<<<< HEAD
            grid = self.fetchGuidanceGrid(dbid, weName, fcstHour, WIND_PROB_LEVEL)
=======
            grid = self.fetchGuidanceGrid(dbid, weName, fcstHour, WIND_PROB_LEVEL, haz)
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            guidanceDict[haz] = grid

        return guidanceDict

    def makeTimeRange(self, hours):
        """
        Creates a timeRange that is used for creating all grids.
        """
        now = int(self._gmtime().unixTime() / 3600) * 3600  # round to nearest hour
        later = now + (hours * 3600)
        timeRange = self.GM_makeTimeRange(now, later)

        return timeRange

<<<<<<< HEAD
=======
    def fetchGrid(self, weName):
        trList = self.GM_getWEInventory(weName)
        grid = None
        if trList:
            grid = self.getGrids(self.mutableID(), weName, "SFC", trList[-1])
        return grid

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    def hazardRankGrid(self, hazardGrid):
        """
        Converts the specified hazardGrid to a scalar ranking based on the order
        in which hazards are found in the self._rankingHazardList. The resulting
        grid is used to calculate differences between on hazard grid and another.
        """
        rankGrid = self.empty()

        hazardKeys = hazardGrid[1]
        for hazKey in hazardKeys:
            hazKeyNoETN = self.stripETN(hazKey)
            if hazKeyNoETN in self._rankingHazardList:
                hazValue = self.getIndex(hazKey, hazardGrid[1])
                mask = hazardGrid[0] == hazValue
                rankValue = self._rankingHazardList.index(hazKeyNoETN)
                if rankValue == 5:
                    rankValue = 4
                rankGrid[mask] = rankValue

        return rankGrid

    def removeAllETNs(self, hazardGrid):
        """
        Strips all ETNs from the keys specified in the hazardGrid and returns the
        keys without ETNs.
        """
        grid, hazKeys = hazardGrid
        cleanKeys = []
        for haz in hazKeys:
            cleanHaz = self.stripETN(haz)
            if cleanHaz not in cleanKeys:
                cleanKeys.append(cleanHaz)

        return cleanKeys

    def makeThresholdGrids(self):
        """
        Defines grids of thresholds for each hazard and area type (coastal, inland)
        """
        self._downgradeWSPGrids = {}

        # Set the wind probability thresholds
        for haz in self._windHazards:
            self._downgradeWSPGrids[haz] = self.empty()
            self._downgradeWSPGrids[haz][self._coastalMask] = self.getProbWindThreshold("Coastal", "Remove", haz)
            self._downgradeWSPGrids[haz][~self._coastalMask] = self.getProbWindThreshold("Inland", "Remove", haz)
            self._downgradePercentage[haz] = self.empty(np.float32)

        # Set the area thresholds
        self._downgradeCov = self.empty(np.float32)
<<<<<<< HEAD
        self._downgradeCov[self._coastalMask] = 100 - RecommendWindWWConfig.AreaThresholds["Coastal"] 
=======
        self._downgradeCov[self._coastalMask] = 100 - RecommendWindWWConfig.AreaThresholds["Coastal"]
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        self._downgradeCov[~self._coastalMask] = 100 - RecommendWindWWConfig.AreaThresholds["Inland"]

        return

    def downgradeMaskForCombined(self, combinedKey, hazardGrid):
        """
        Calculates the special mask of where downgrades are valid for the combined hazard
        such as "HU.A^TR.W". This combination gets speial rules and thus is implemented
        in a separate module.
        """
        etnStr = self.getETN(self._stormName)
        combinedKeyETN = self.addETNToHazardKey(combinedKey, etnStr)
        hazardByteGrid, hazardKeys = hazardGrid
        # Get the TRW mask
        if combinedKey == "TR.W^HU.A":
            combinedIndex = self.getIndex(combinedKeyETN, hazardKeys)
            combinedMask = hazardByteGrid == combinedIndex
        elif combinedKey == "HU.A^TR.W":
            combinedIndex = self.getIndex(combinedKeyETN, hazardKeys)
            combinedMask = hazardByteGrid == combinedIndex

        trwMask = (self._guideDict["TR.W"] <= self._downgradeWSPGrids["TR.W"]) & combinedMask
        huaMask = (self._guideDict["HU.A"] <= self._downgradeWSPGrids["HU.A"]) & combinedMask
        downgradeMask = self.empty(np.bool)
        downgradeMask[trwMask & huaMask] = True  # set the mask to indicate a downgrade possibility
        downgradeMask[huaMask & ~trwMask] = True  # set the mask to indicate a downgrade possibility

        return downgradeMask

    def makeDiffGrid(self, guidanceGrid, hazardGrid):
        """
        Calculates the differences between the previous hazard grid and the guidance grid
        This is a critical grid as it determines where hazards are upgraded or downgraded.
        This method returns a grid containing three values, -1, 0, and 1. A value of -1
        indicates areas that should be downgraded, 0 represents no change, and a value of
        1 indicates areas that should be upgraded.
        """
        # Calculate the "rank" of each of the grids. The rank is used to calculate the difference.
        guideRank = self.hazardRankGrid(guidanceGrid)
        hazRank = self.hazardRankGrid(hazardGrid)
        diffGrid = guideRank - hazRank

<<<<<<< HEAD
        signGrid =  np.sign(diffGrid)
=======
        signGrid = np.sign(diffGrid)
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        signGrid[diffGrid < 0] = 0

        # Adjust the signGrid by applying the downgrade criteria
        # First check each guidance hazard to see if the suggested downgrade is allowed.
        previousHazardKeys = self.removeAllETNs(hazardGrid)
        proposedHazardKeys = self.removeAllETNs(guidanceGrid)
        self.makeThresholdGrids()
        noHazIndex = self.getIndex("<None>", hazardGrid[1])
        hazMask = hazardGrid[0] != noHazIndex

        for prevHaz in previousHazardKeys:
            combinedKey = "^" in prevHaz  # it's a combinedKey. Process this differently
<<<<<<< HEAD
            if combinedKey: # Initializes the downgradePercentage grid
                self._downgradePercentage[prevHaz] = self.empty() # Add the combinedKey for this dict
            # Calculate areas where this hazards exists in the hazard grid.
            hazardArea = self.hazardMask(hazardGrid, prevHaz)  # mask where this hazard exists
            if prevHaz == "<None>":
                maskName = "None"
            else:
                maskName = prevHaz[0:2]+prevHaz[-1]
=======
            if combinedKey:  # Initializes the downgradePercentage grid
                self._downgradePercentage[prevHaz] = self.empty()  # Add the combinedKey for this dict
            # Calculate areas where this hazards exists in the hazard grid.
            hazardArea = self.hazardMask(hazardGrid, prevHaz)  # mask where this hazard exists
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

            for propHaz in proposedHazardKeys:
                # See if this combination is allowed by policy/rules
                if not self.downgradeAllowed(prevHaz, propHaz):
                    continue

                # Make a sensible wename
                if "^" in prevHaz:
<<<<<<< HEAD
                    weName = prevHaz[0:2]+prevHaz[3] + prevHaz[5:7]+prevHaz[-1]
                else:
                    weName = prevHaz[0:2]+prevHaz[-1]
=======
                    weName = prevHaz[0:2] + prevHaz[3] + prevHaz[5:7] + prevHaz[-1]
                else:
                    weName = prevHaz[0:2] + prevHaz[-1]
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

                # Calculate areas where the Wind speed prob is below the threshold
                # These are potential areas for downgrade
                if combinedKey:
<<<<<<< HEAD
                    downgradeMask = self.downgradeMaskForCombined(prevHaz, hazardGrid) & hazardArea
                else:  # simple key
                    downgradeMask = (self._guideDict[prevHaz] <= self._downgradeWSPGrids[prevHaz]) & hazMask & hazardArea
=======
                    downgradeMask = self.downgradeMaskForCombined(prevHaz, hazardGrid) & hazardArea & self._affectedAreaMask
                else:  # simple key
                    downgradeMask = (self._guideDict[prevHaz] <= self._downgradeWSPGrids[prevHaz]) & hazMask & hazardArea \
                                     & self._affectedAreaMask
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

                # Get the zones over this area and calculate areal coverage over each zone
                zoneIDList = self._zoneMap.getOverlappingZoneIDs(downgradeMask)
                for zoneType in self._zoneTypes:
<<<<<<< HEAD
                    if zoneType == "Coastal":
                        zoneTypeMask = self._coastalMask
                    else:
                        zoneTypeMask = ~self._coastalMask

                    for zoneID in zoneIDList:
                        zoneMask = (self._zoneMapGrid == zoneID)
=======
                    for zoneID in zoneIDList:
                        zoneMask = (self._zoneMapGrid == zoneID) & self._affectedAreaMask
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                        # Calc the points inside the zoneMask
                        probPoints = downgradeMask & zoneMask
                        percCoverage = float(probPoints.sum()) / zoneMask.sum() * 100.0
                        # Save this value for later
                        self._downgradePercentage[prevHaz][zoneMask] = percCoverage
                if self._debug:
<<<<<<< HEAD
                    self.createGrid("Fcst", "DowngradeCoverage" + weName, "SCALAR", self._downgradePercentage[prevHaz], self._timeRange)
                    self.createGrid("Fcst", "DowngradeArealCoverage" + weName, "SCALAR", self._downgradeCov, self._timeRange)

                downgradeMask = self._downgradePercentage[prevHaz] >= self._downgradeCov

                signGrid[downgradeMask] = -1  # Set the grid to indicate a downgrade should be done

        self.createGrid("Fcst", "FinalDiff", "SCALAR", signGrid, self._timeRange, minAllowedValue=-1.0, maxAllowedValue=1.0,
                                    defaultColorTable="SITE/NHA/DiffWW")

        return signGrid

    def getInlandZones(self, wwHazardGrid):
        """
        Fetches the set of inland zones based on the specified Hazard grid.
        Only zones where a hazard is defined are returned.
        """
        zoneDict = {}
        
        hazardGrid, hazardKeys = wwHazardGrid
        # Calculate the areas where hazards exist
        for hazard in hazardKeys:
            if hazard == "<None>":
                continue
            hazIndex = self.getIndex(hazard, hazardKeys)  
            hazMask = (hazardGrid == hazIndex)
            # Remove any coastal zone areas
            hazMask[self._nhcZoneMask] = 0  # Turn off the coastal zones 
        
            # Use ZoneMap to find the list of zones
            inlandZones = self._zoneMap.getOverlappingZoneNames(hazMask)
            zoneDict[hazard] = inlandZones
            
        return zoneDict
    
    def saveZonesToJSONFile(self, hazardGrid):
        """ Appends any inland zones to the current set of zones in the json
            file and re-saves the file.
        """
        for stormInfo in self._stormInfoDicts:
            if stormInfo["stormName"] == self._stormName:
                if "zoneDict" not in stormInfo:
                    stormInfo["zoneDict"] = []
                # Get all of the inland zones that have a hazard
                zoneDict = self.getInlandZones(hazardGrid)
                for hazard in zoneDict:
                    
                    haz = self.stripETN(hazard)
                    if haz == "HU.A^TR.W":
                        haz = "TR.W^HU.A"
                    if haz not in stormInfo["zoneDict"]:
                        stormInfo["zoneDict"][haz] = []
                    # Add the inland zones to the stormInfo
                    stormInfo["zoneDict"][haz] += zoneDict[hazard]
                
                self._saveAdvisory(stormInfo["pil"], stormInfo)
                return
        print("Error...stormName:", self._stormName, "not found when saving inland zones.")
        return
    
    def removedOldPropGrids(self):
        """
        Removes all previous Proposed grids.
        """
        timeRange = TimeRange.allTimes()
        weList = ["ProposedTropWWGuidance", "ProposedTropWindWW"]
        for weName in weList:
            self.deleteGrid(self.mutableID(), weName, "SFC", timeRange)
            
        return 

    # Main method called when the tool is envoked.
    def execute(self, editArea):

        ###########################   GUI Section  #################################

        # Get the stormInfos and extract the stormNames for the GUI
        self._stormInfoDicts = self._WindWWUtils.getStormInfoDicts()
        stormNames = self.getStormNames(self._stormInfoDicts)

        modelNames = ["TPCProb", "TPCProbPrelim"]
        editAreaChoices = ["Current Edit Area", "Hazards and Guidance"]
=======
                    self.createGrid(self.mutableID(), "DowngradeCoverage" + weName, "SCALAR", self._downgradePercentage[prevHaz], self._timeRange)
                    self.createGrid(self.mutableID(), "DowngradeArealCoverage" + weName, "SCALAR", self._downgradeCov, self._timeRange)

                downgradeMask = (self._downgradePercentage[prevHaz] >= self._downgradeCov) & self._affectedAreaMask

                signGrid[downgradeMask] = -1  # Set the grid to indicate a downgrade should be done

        self.createGrid(self.mutableID(), "FinalDiff", "SCALAR", signGrid, self._timeRange, minAllowedValue=-1.0, maxAllowedValue=2.0,
                                    defaultColorTable="GFE/diffSS")

        return signGrid

    def etnMask(self, hazardGrid, stormETN=None):
        hazGrid, hazKeys = hazardGrid
        if not stormETN:
            stormETN = str(self.getETN(self._stormName))
        # Make a mask covering all the hazards with this ETN
        etnMask = self.empty(np.bool)
        for hazKey in hazKeys:
            if stormETN in hazKey:
                hazIndex = self.getIndex(hazKey, hazKeys)
                etnMask |= (hazGrid == hazIndex)
        return etnMask

    def extractETN(self, hazKey):

        if ":" in hazKey:
            pos = hazKey.find(":") + 1
            return hazKey[pos:pos + 4]
        return ""

    def checkForHazardConflicts(self, hazGrid1, hazGrid2):
        """
        Check to see if any hazGrid1 hazards for the current storm conflict with any
        other hazards in hazGrid2
        """
        # None grids never have conflicts
        if hazGrid1[0] is None or hazGrid2[0] is None:
            return False

        haz1Values, haz1Keys = hazGrid1
        haz2Values, haz2Keys = hazGrid2

        stormETN = self.getETN(self._stormName)
        stormMask = self.etnMask(hazGrid1, stormETN)

        etnMask = self.empty(np.bool)
        for hazKey in haz2Keys:
            etn = self.extractETN(hazKey)
            if not etn:
                continue
            if etn == stormETN:
                continue
            hazIndex = self.getIndex(hazKey, haz2Keys)
            mask = (haz2Values == hazIndex)
#             mask = self.etnMask(hazGrid2, etn)
            etnMask |= mask
            if (stormMask & mask).any():
                self._conflictMask |= (mask & ~self._coastalMask) & self._affectedAreaMask

        if self._conflictMask.any():
            return True

        return False

    def checkForJSONConflicts(self, hazGrid):
        """
        Check the specified grid for any conflicts with the current set of JSON files.
        """
        # Make a grid based on the JSON file.
        stormInfoDicts = self.getStormInfoDicts()
        jsonGrid = self.empty(np.int8)
        jsonKeys = self.getDiscreteKeys("ProposedTropWWGuidance")

        zoneDictNames = ["zoneDict", "inlandZoneDict"]
        for stormInfo in stormInfoDicts:
            stormName = stormInfo["stormName"]
            etn = self.getETN(stormName)
            for zoneDictName in zoneDictNames:
                zoneDict = stormInfo.get(zoneDictName, None)
                if not zoneDict:
                    continue
                zoneList = []
                for hazKey in zoneDict:
                    if not zoneDict[hazKey]:
                        continue
                    zoneList = zoneDict[hazKey]
                    for zone in zoneList:
                        mask = self.encodeEditArea(zone)
                        etnKey = hazKey + ":" + etn
                        hazIndex = self.getIndex(etnKey, jsonKeys)
                        jsonGrid[mask] = hazIndex

        return self.checkForHazardConflicts(hazGrid, (jsonGrid, jsonKeys))

    def removeOldGrids(self, weName):
        """
        Removes all grids found in the past with the specified weName.
        """
        now = int(self._gmtime().unixTime() / 3600) * 3600
        startTime = AbsTime.AbsTime(now - (48 * 3600))
        endTime = AbsTime.AbsTime(now)
        timeRange = TimeRange.TimeRange(startTime, endTime)
        self.deleteGrid(self.mutableID(), weName, "SFC", timeRange)

        return

    def displayConflictMask(self, weName):
        weName = "ConflictsWith" + weName
        self.deleteGrid(self.mutableID(), weName, "SFC", TimeRange.allTimes())
        self.createGrid(self.mutableID(), weName, "SCALAR", self._conflictMask.astype(np.float32), self._timeRange,
                        minAllowedValue=0, maxAllowedValue=1, defaultColorTable="YesNo")

    def execute(self, editArea):
        # Check for non-empty edit area. An empty edit area shows up as all points selected.
        if self.encodeEditArea(editArea).all():
            self.statusBarMsg("Please select an edit area before running RecommendWindWW.", "S")
            return
        ###########################   GUI Section  #################################
        # Get the stormInfos and extract the stormNames for the GUI
        self._stormInfoDicts = self.getStormInfoDicts()
        stormNames = self.getStormNames(self._stormInfoDicts)

        modelNames = ["TPCProb", "TPCProbPrelim"]
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

        variableList = []
        variableList.append(("StormName:", stormNames[0], "radio", stormNames))
        variableList.append(("Database Source:", modelNames[0], "radio", modelNames))
<<<<<<< HEAD
        variableList.append(("Restrict Watches/Warnings to:", editAreaChoices[0], "radio", editAreaChoices))

        varDict = {}
        processVarList = ProcessVariableList.ProcessVariableList("Continue?", variableList, varDict) 
        status = processVarList.status()
        if status.upper() != "OK": 
=======

        varDict = {}
        processVarList = ProcessVariableList.ProcessVariableList("Continue?", variableList, varDict)
        status = processVarList.status()
        if status.upper() != "OK":
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            self.cancel()
            return

        # Initialize a few variable global to this tool.
<<<<<<< HEAD
        self._debug = False #True
=======
        self._debug = False  # True
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        self._noneHazard = "<None>"
        self._hazardPercentage = {}
        self._downgradePercentage = {}
        self._zoneTypes = ["Inland", "Coastal"]

        # Fetch the GUI choices
        stormNameChoice = varDict["StormName:"]
        databaseChoice = varDict["Database Source:"]
<<<<<<< HEAD
        editAreaChoice = varDict["Restrict Watches/Warnings to:"]
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

        self._stormName = stormNameChoice

        ###########################   End GUI Section  #################################

        self._windHazards = ["TR.A", "HU.A", "TR.W", "HU.W"]
        self._rankingHazardList = ["<None>", "TR.A", "HU.A", "TR.W", "HU.A^TR.W", "TR.W^HU.A", "HU.W"]
<<<<<<< HEAD

        self._dbid = self.getLatestProbWindDBID(databaseChoice)
        if self._debug:
            print("Using databaseID:", self._dbid)
=======
        self._comboHazards = ["TR.W", "HU.A"]

        self._dbid = self.getLatestProbWindDBID(databaseChoice)
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

        # Make a timeRange when all grids will be defined
        self._timeRange = self.makeTimeRange(48)

        # Fetch the Coastal zone mask
<<<<<<< HEAD
        self._coastalMask = self._zoneMap.coastalZonesMask()
        # Abort the tool if this edit area is missing.
        if self._coastalMask is None:
            return 
=======
        self._coastalMask = self._zoneMap.fetchNHCZonesMask()
        # Abort the tool if this edit area is missing.
        if self._coastalMask is None:
            return
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

        # Plot the wind thresholds as a grid
        grid = self.empty()
        for haz in self._windHazards:
            for zoneType in self._zoneTypes:
                if zoneType == "Coastal":
                    mask = self._coastalMask
                else:
                    mask = ~self._coastalMask
                grid[mask] = self.getProbWindThreshold(zoneType, "Add", haz)

<<<<<<< HEAD
        # Fetch and/or create some masks that will be used throughout the process.
        self.fetchNHCZoneMask()

=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        # Fetch all the guidance grids we'll need. Other methods will use these
        self._guideDict = self.getAllGuidanceGrids(self._dbid)

        # Calculate the area over which the tool will run
        self._affectedAreaMask = self.calculateAffectedArea(editArea)

<<<<<<< HEAD
        self.removedOldPropGrids()
        # Make the guidance hazard grid
        guidanceHazardGrid = self.makeGuidanceGrid(self._dbid, stormNameChoice)
        self.createGrid("Fcst", "ProposedTropWWGuidance", "DISCRETE", guidanceHazardGrid, self._timeRange,
                        defaultColorTable="SITE/NHA/ProposedWind")

        # Make the Recommended guidance grid
        recommendedHazardGrid = self.makeRecommendedGrid(guidanceHazardGrid, stormNameChoice)
        self.createGrid("Fcst", "ProposedTropWindWW", "DISCRETE", recommendedHazardGrid, self._timeRange,
                        defaultColorTable="SITE/NHA/ProposedWind")

        # Remove any old grids
        endTime = self._timeRange.startTime().unixTime()
        startTime = endTime - (12 * 3600) # 12 hours earlier
        deleteTR = TimeRange.TimeRange(AbsTime.AbsTime(startTime), AbsTime.AbsTime(endTime))
        for weName in ["ProposedTropWWGuidance", "ProposedTropWindWW", "Hazards"]:
            self.deleteGrid(self.mutableID(), weName, "SFC", deleteTR)

        if self._debug:
            self.makeDifferenceGrids(guidanceHazardGrid, recommendedHazardGrid)
            
        self.saveZonesToJSONFile(guidanceHazardGrid)

        return
=======
        self._conflictMask = self.empty(np.bool)

        tempWEs = ["ConflictsWithGuidanceAndHazards", "ConflictsWithProposedAndHazards", "ConflictsWithProposedAndJSON"]
        for weName in tempWEs:
            self.unloadWE(self.mutableID(), weName, "SFC")

        # Check for conflicts before we make the recommended grid
        hazardGrid = self.getAllTropicalHazards(needETN=True)
        guidanceHazardGrid = self.makeGuidanceGrid(self._stormName)
        if self.checkForHazardConflicts(guidanceHazardGrid, hazardGrid):
            self.statusBarMsg("ETN Conflicts were detected between storm guidance and existing Hazards. Carefully select the edit area for the current storm.", "S")
            self.displayConflictMask("GuidanceAndHazards")
            return

        # Make the Recommended guidance grid - or the Proposed grid.
        recommendedHazardGrid = self.makeRecommendedGrid(guidanceHazardGrid)

        if self.checkForHazardConflicts(recommendedHazardGrid, hazardGrid):
            self.statusBarMsg("ETN Conflicts were detected between new proposed and Hazards. Carefully select the edit area for the current storm.", "S")
            self.displayConflictMask("ProposedAndHazards")
            return

        if self.checkForJSONConflicts(recommendedHazardGrid):
            self.statusBarMsg("ETN Conflicts were detected between new proposed from current storm and existing JSON hazards from concurrent storms. Carefully re-select the edit area for the current storm.", "S")
            self.displayConflictMask("ProposedAndJSON")
            return

        # Overlay the Breakpoint hazards on this grids as they are not to be modified.
        # Note we are purposely ignoring the self._affected area
        recommendedHazardGrid = self.insertBreakpointHazards(recommendedHazardGrid)

        self.removeOldGrids("ProposedTropWWGuidance")
        self.createGrid(self.mutableID(), "ProposedTropWWGuidance", "DISCRETE", guidanceHazardGrid, self._timeRange,
                        defaultColorTable="GFE/ProposedWind")
        self.removeOldGrids("ProposedTropWindWW")
        self.createGrid(self.mutableID(), "ProposedTropWindWW", "DISCRETE", recommendedHazardGrid, self._timeRange,
                        discreteKeys=self._rankingHazardList, discreteOverlap=1, discreteAuxDataLength=5,
                        defaultColorTable="GFE/ProposedWind")

        if self._debug:
            self.makeDifferenceGrids(guidanceHazardGrid, recommendedHazardGrid)

        return
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
