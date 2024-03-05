# ----------------------------------------------------------------------------
# This software is in the public domain, furnished "as is", without technical
# support, and with no warranty, express or implied, as to its usefulness for
# any purpose.
#
# RemoveZoneMap.py
#
# Author: lefebvre
<<<<<<< HEAD
# ----------------------------------------------------------------------------
#
# SOFTWARE HISTORY
#
# Date         Ticket#    Engineer    Description
# ------------ ---------- ----------- ----------------------------------------
# May 20, 2020 22033      tlefebvr    Addressed code review comments.
# 
=======
#
# # SOFTWARE HISTORY
#
# Date         Ticket#    Engineer    Description
# ------------ ---------- ----------- ------------------------------------------
# May 20, 2020 22033      tlefebvr    Addressed code review comments.
# Apr 13, 2022 22531      tlefebvr    Tested in Python3 environment.
#
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
# ----------------------------------------------------------------------------

MenuItems = ["Edit"]

import SmartScript

<<<<<<< HEAD
class Procedure (SmartScript.SmartScript):
=======

class Procedure (SmartScript.SmartScript):

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    def __init__(self, dbss):
        SmartScript.SmartScript.__init__(self, dbss)

    def execute(self, editArea, timeRange, varDict):
<<<<<<< HEAD
        name = "NHCZoneMap"
        category = "ZoneMap"

        self.deleteObject(name, category)

=======
        name = "NHCZoneMap" + self.getSiteID()
        category = "ZoneMap"

        self.deleteObject(name, category)
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
