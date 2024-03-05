<<<<<<< HEAD
##
=======
#
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
# This software was developed and / or modified by Raytheon Company,
# pursuant to Contract DG133W-05-CQ-1067 with the US Government.
#
# U.S. EXPORT CONTROLLED TECHNICAL DATA
# This software product contains export-restricted data whose
# export/transfer/disclosure is restricted by U.S. law. Dissemination
# to non-U.S. persons whether in the United States or abroad requires
# an export license or other authorization.
#
# Contractor Name:        Raytheon Company
# Contractor Address:     6825 Pine Street, Suite 340
#                         Mail Stop B8
#                         Omaha, NE 68106
#                         402.291.0100
#
# See the AWIPS II Master Rights File ("Master Rights File.pdf") for
# further licensing information.
##
#
<<<<<<< HEAD
#    Name:
#       TafDecoder.py
#       GFS1-NHD:A7822.0000-SCRIPT;1.65
#
#    Status:
#       DELIVERED
#
#    History:
#       Revision 1.65 (DELIVERED)
#         Created:  21-OCT-2009 21:53:54      OBERFIEL
#           VC events not handled correctly for VRB winds.
#
#       Revision 1.64 (DELIVERED)
#         Created:  21-SEP-2009 07:14:57      OBERFIEL
#           Fixed monitoring of TEMPO groups at start of forecast.
#           Monitoring corrected TAFs also fixed.
#           Showers are considered convective and so VRB with speeds >
#           6kts is allowed.
#
#       Revision 1.63 (DELIVERED)
#         Created:  16-JUN-2009 14:41:14      OBERFIEL
#           Added checks on misuse of LLWS in conditional groups.
#
#       Revision 1.62 (DELIVERED)
#         Created:  15-MAY-2009 15:09:08      OBERFIEL
#           Fixed crash when bad wind group in prevailing fcst is
#           inherited by the occasional group
#           TEMPO or PROB30.
#
#       Revision 1.61 (REVIEW)
#         Created:  14-APR-2009 10:36:34      OBERFIEL
#           Added new checks for AMD NOT SKED and AMD LTD TO clauses,
#           proper use of NSW and VRB winds.
#
#       Revision 1.60 (REVIEW)
#         Created:  30-MAR-2009 23:01:09      OBERFIEL
#           Fixed typo in check_wind() routine.
#
#       Revision 1.59 (REVIEW)
#         Created:  30-MAR-2009 18:31:54      OBERFIEL
#           Removed obsolete TAF format code.  Fixed VRB winds with
#           convection. Fixed NSW handling.
#           Added checks for times in AMD clauses.
#
#       Revision 1.58 (DELIVERED)
#         Created:  10-MAR-2009 08:49:20      OBERFIEL
#           Added new check for end of month, e.g. 31st April.  Fixed
#           typos and added overlooked check for wind shear in
#           TEMPO/PROB groups.
#
#       Revision 1.57 (REVIEW)
#         Created:  10-DEC-2008 12:46:59      OBERFIEL
#           Documented patched OB9 TafDecoder.py
#
#       Revision 1.56 (DELIVERED)
#         Created:  10-DEC-2008 12:40:20      OBERFIEL
#           Documented patched OB8.3.1 TafDecoder.py
#
#       Revision 1.55 (DELIVERED)
#         Created:  02-DEC-2008 10:11:20      OBERFIEL
#           Used fix_date routine to handle month-to-month and
#           year-to-year transitions.
#
#       Revision 1.54 (DELIVERED)
#         Created:  19-NOV-2008 14:08:03      OBERFIEL
#           Fixed swapped dates/hours in TEMPO and PROB30 groups
#
#       Revision 1.53 (DELIVERED)
#         Created:  31-OCT-2008 11:40:08      OBERFIEL
#           Fixed beginning of month problem with TEMPO and PROB30
#           groups
#
#       Revision 1.52 (DELIVERED)
#         Created:  29-OCT-2008 12:57:54      OBERFIEL
#           Fixed end-of-month/beginning-of-next-month bug
#
#       Revision 1.51 (DELIVERED)
#         Created:  28-AUG-2008 15:28:43      OBERFIEL
#           NIL AMD is now flagged.  TAF COR is now allowed.
#
#       Revision 1.50 (DELIVERED)
#         Created:  01-AUG-2008 15:44:46      OBERFIEL
#           Synch'd up with changes in OB8.3.1
#
#       Revision 1.49 (DELIVERED)
#         Created:  30-JUN-2008 14:42:35      OBERFIEL
#           Initial guess for part-time TAF, pending consensus from
#
#       Revision 1.48 (REVIEW)
#         Created:  19-JUN-2008 14:19:35      OBERFIEL
#           Allowed different TAF formats without raising fatal error.
#
#       Revision 1.47 (DELIVERED)
#         Created:  31-MAR-2008 12:48:21      OBERFIEL
#           Corrected valid_day for OB8.3 release
#
#       Revision 1.46 (DELIVERED)
#         Created:  03-MAR-2008 10:08:20      OBERFIEL
#           Fixed Leap-Day bug.
#
#       Revision 1.45 (APPROVED)
#         Created:  29-FEB-2008 09:55:46      OBERFIEL
#           Fixed bug with leap-day.  Made the logic a bit more clear.
#
#       Revision 1.44 (DELIVERED)
#         Created:  26-FEB-2008 14:25:36      OBERFIEL
#           Fixed _talk notification (unimplemented) and DTG for Nov
#           2008
#
#       Revision 1.43 (DELIVERED)
#         Created:  27-JUN-2007 13:14:16      OBERFIEL
#           MetarMonitorP.py revamped logic and created new rule for
#           Alaska region.
#           TafDecoder.py changed to allow variable AMD LTD element
#           list
#
#       Revision 1.42 (DELIVERED)
#         Created:  14-MAY-2007 10:04:50      OBERFIEL
#           Removed references to the obsolete prototype XTF product.
#           Allow decoder and encoder to format TAF in two different
#           ways.  New format will be triggered by day and time to be
#           specified at a later date.
#
#       Revision 1.41 (DELIVERED)
#         Created:  21-JUN-2006 08:57:36      TROJAN
#           spr 7162: fixed start time of the first TAF group
#
#       Revision 1.40 (DELIVERED)
#         Created:  20-JUN-2006 08:28:29      TROJAN
#           spr 7163: fixed start time of the first TAF group
#
#       Revision 1.39 (DELIVERED)
#         Created:  02-JUN-2006 10:28:09      TROJAN
#           spr 7160: changed regular expression for visibility
#
#       Revision 1.38 (DELIVERED)
#         Created:  02-JUN-2006 09:04:22      TROJAN
#           spr 7159: changed regular expression for visibility
#
#       Revision 1.37 (DELIVERED)
#         Created:  03-MAY-2006 13:49:15      TROJAN
#           SPR 7139: fixed issue/valid time checks
#
#       Revision 1.36 (DELIVERED)
#         Created:  03-MAY-2006 13:28:39      TROJAN
#           SPR 7140: fixed issue/valid time checks
#
#       Revision 1.35 (DELIVERED)
#         Created:  14-APR-2006 13:17:50      TROJAN
#           spr 7118
#
#       Revision 1.34 (DELIVERED)
#         Created:  14-APR-2006 08:42:21      TROJAN
#           spr 7117
#
#       Revision 1.33 (APPROVED)
#         Created:  14-APR-2006 08:24:42      TROJAN
#           spr 7117
#
#       Revision 1.32 (DELIVERED)
#         Created:  27-MAR-2006 08:30:43      TROJAN
#           spr 7112: added check for valid time of FM group for
#           regular issuance TAFs
#
#       Revision 1.31 (DELIVERED)
#         Created:  19-JAN-2006 11:11:08      OBERFIEL
#           Numerous changes to sync up platforms
#
#       Revision 1.30 (APPROVED)
#         Created:  03-NOV-2005 13:16:33      TROJAN
#           spr 7051
#
#       Revision 1.29 (APPROVED)
#         Created:  12-OCT-2005 18:29:27      TROJAN
#           spr 7038
#
#       Revision 1.28 (DELIVERED)
#         Created:  19-SEP-2005 13:47:39      TROJAN
#           spr 7011
#
#       Revision 1.27 (APPROVED)
#         Created:  08-SEP-2005 14:40:39      TROJAN
#           spr 7011
#
#       Revision 1.26 (DELIVERED)
#         Created:  19-AUG-2005 19:50:32      TROJAN
#           spr 6999
#
#       Revision 1.25 (APPROVED)
#         Created:  17-AUG-2005 19:50:31      TROJAN
#           spr 6992
#
#       Revision 1.24 (APPROVED)
#         Created:  16-AUG-2005 13:23:17      TROJAN
#           spr 6987
#
#       Revision 1.23 (APPROVED)
#         Created:  12-AUG-2005 12:39:09      OBERFIEL
#           Volcanic Ash can be forecasted regardless of visibility.
#
#       Revision 1.22 (APPROVED)
#         Created:  09-AUG-2005 15:02:46      TROJAN
#           spr 6975
#
#       Revision 1.21 (DELIVERED)
#         Created:  26-JUL-2005 18:27:56      TROJAN
#           spr 6946
#
#       Revision 1.20 (APPROVED)
#         Created:  06-JUL-2005 18:16:41      TROJAN
#           spr 6548
#
#       Revision 1.19 (DELIVERED)
#         Created:  13-MAY-2005 18:56:28      TROJAN
#           spr 6834
#
#       Revision 1.18 (REVIEW)
#         Created:  12-MAY-2005 14:20:56      TROJAN
#           spr 6834
#
#       Revision 1.17 (REVIEW)
#         Created:  07-MAY-2005 11:38:28      OBERFIEL
#           Added Item Header Block
#
#       Revision 1.16 (DELIVERED)
#         Created:  26-APR-2005 15:07:40      TROJAN
#           spr 6812
#
#       Revision 1.15 (REVIEW)
#         Created:  26-APR-2005 14:12:30      TROJAN
#           spr 6812
#
#       Revision 1.14 (APPROVED)
#         Created:  26-APR-2005 13:56:52      TROJAN
#           spr 6812
#
#       Revision 1.13 (DELIVERED)
#         Created:  06-APR-2005 11:46:47      TROJAN
#           spr 6776
#
#       Revision 1.12 (APPROVED)
#         Created:  04-APR-2005 15:12:25      TROJAN
#           spr 6778
#
#       Revision 1.11 (DELIVERED)
#         Created:  01-MAR-2005 21:07:14      TROJAN
#           spr 6689
#
#       Revision 1.10 (DELIVERED)
#         Created:  14-FEB-2005 20:54:51      TROJAN
#           spr 6649
#
#       Revision 1.9 (APPROVED)
#         Created:  24-JAN-2005 21:18:47      TROJAN
#           spr 6612
#
#       Revision 1.8 (APPROVED)
#         Created:  24-JAN-2005 17:49:56      TROJAN
#           spr 6608
#
#       Revision 1.7 (APPROVED)
#         Created:  19-JAN-2005 15:13:59      TROJAN
#           spr 6565
#
#       Revision 1.6 (APPROVED)
#         Created:  07-DEC-2004 19:18:35      TROJAN
#           spr 6527
#
#       Revision 1.5 (UNDER WORK)
#         Created:  21-OCT-2004 19:33:49      TROJAN
#           spr 6398
#
#       Revision 1.4 (APPROVED)
#         Created:  01-OCT-2004 13:38:14      TROJAN
#           spr 6399
#
#       Revision 1.3 (APPROVED)
#         Created:  19-AUG-2004 20:49:16      OBERFIEL
#           Code chage
#
#       Revision 1.2 (APPROVED)
#         Created:  09-JUL-2004 18:07:07      OBERFIEL
#           Updated to fix problem with NSW
#
#       Revision 1.1 (APPROVED)
#         Created:  01-JUL-2004 14:45:02      OBERFIEL
#           date and time created -2147483647/-2147483648/-2147481748
#           -2147483648:-2147483648:-2147483648 by oberfiel
#
#    Change Document History:
#       1:
#               Change Document:   GFS1-NHD_SPR_7431
#               Action Date:       22-OCT-2009 20:05:48
#               Relationship Type: In Response to
#               Status:           TEST
#               Title:             AvnFPS: OB9.2 installation breaks mtrs.cfg file
#
#    Date            Ticket#       Engineer       Description
#    ------------    ----------    -----------    --------------------------
#    02APR2014       17211         zhao (code obtained from the listserver via Virgil that implements a new rule regarding CB, TS etc)
#    May 12, 2014    16928         zhao           Modified check_prev_time()
#    Sep 17, 2014    16928         zhao           Added a line break "\n" to message 25 (since it appears together with message 49)
#    Jul 07, 2015    16973         zhao           Added 'DRSN' as valid value of sig weather
#    Mar 03, 2016    18664         zhao           Fixed an indentation error in check_vsby_wx()
#    Jan 15, 2018    7119          tgurney        check_tempo_group() correctly handle invalid vsby in the "FM" Part
#
#

##
# This is a base file that is not intended to be overridden.
##


import re
import time
import traceback
=======
#    Date            Ticket#       Engineer       Description
#    ------------    ----------    -----------    --------------------------
#    02APR2014       17211         zhao (code obtained from the listserver via Virgil that implements a new rule
#                                                 regarding CB, TS etc)
#    May 12, 2014    16928         zhao           Modified check_prev_time()
#    Sep 17, 2014    16928         zhao           Added a line break "\n" to message 25 (since it appears together with
#                                                 message 49)
#    Jul 07, 2015    16973         zhao           Added 'DRSN' as valid value of sig weather
#    Mar 03, 2016    18664         zhao           Fixed an indentation error in check_vsby_wx()
#    Jan 15, 2018    7119          tgurney        check_tempo_group() correctly handle invalid vsby in the "FM" Part
#    Apr 15, 2022    103155        m. oberfield   Additional checks to catch mistakes by forecasters, updates to
#                                                 conform to most recent 10-813 instructions, overall code cleanup and
#                                                 additional documentation.
#    Aug 15, 2022    DCS 23235     m. oberfield   Commented out PROB30 nine-hour check
#
##
# This is a base file that is not intended to be overridden.
##
import calendar
import datetime
import itertools
import logging
import re
import time
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import tpg
import Avn
import AvnLib
import AvnParser

<<<<<<< HEAD
###############################################################################
# local exceptions

class Error(Exception):
    pass

class Warning1(Exception):
    pass  # avoiding name clash

###############################################################################
# dictionary of errors and warnings
_Errors = {
11: """Thunderstorm forecast requires CB in the cloud
group (NWSI 10-813, Appendix C, 1.2.7.3)""",
12: """Visibility <= 6SM requires forecast of significant
weather (NWSI 10-813, Appendix C, 1.2.5)""",
13: """Volcanic ash requires visibility forecast
(NWSI 10-813, Appendix C, 1.2.6)""",
14: """FG or FZFG forecast requires visibility < 5/8SM,
MIFG requires visibility >= 5/8SM
(NWSI 10-813, Appendix C, 1.2.6)""",
15: """BR forecast requires visibility between 5/8SM
and 6SM (NWSI 10-813, Appendix C, 1.2.6)""",
16: """PROB group must include forecast of a thunderstorm
or precipitation event (NWSI 10-813, Appendix C, 1.2.9.4)""",
17: """Invalid sky cover sequence
(NWSI 10-813, Appendix C, 1.2.7.1)""",
18: """Invalid weather with visibility >= 6SM
(NWSI 10-813, Appendix C, 1.2.5)""",
19: """Missing terminating blank""",
20: """Invalid datetime format""",
21: """Invalid end hour""",
22: """Invalid start hour""",
23: """Invalid day""",
24: """Issue and valid times do not match""",
25: """Group time period not within TAF forecast period\n""",
26: """Only PROB30 is allowed""",
27: """The PROB group shall not be used in the first
9 hours of the valid TAF forecast
(NWSI 10-813, Appendix C, 1.2.9.4)""",
28: """Weather in the vicinity shall not be used in TEMPO
or PROB groups (NWSI 10-813, Appendix C, 1.2.6.1)""",
29: """Wrong day of the month""",
30: """Invalid value of wind direction""",
31: """Invalid value of wind speed""",
32: """Wind gust <= wind speed""",
33: """Forecast of non-convective low-level wind shear
shall not be included in TEMPO or PROB groups
(NWSI 10-813, Appendix C, 1.2.8)""",
34: """Missing weather in this group""",
35: """Invalid value of wind shear direction""",
36: """Invalid value of wind shear height""",
37: """Invalid value of visibility
(NWSI 10-813, Appendix C, 1.2.5)""",
38: """Invalid value of sig weather
(NWSI 10-813, Appendix B, 4)""",
39: """Unnecessary leading zero for wind shear speed""",
40: """Invalid cloud amount
(NWSI 10-813, Appendix C, 1.2.7.1)""",
41: """Invalid cloud base
(NWSI 10-813, Appendix C, 1.2.7.1)""",
42: """Cannot forecast partial obscuration
(NWSI 10-813, Appendix C, 1.2.7.2)""",
43: """Invalid VC weather. Allowed entries:
VCFG, VCSH, VCTS.
(NWSI 10-813, Appendix C, 1.2.6.1)""",
44: """CLR shall not be used in TAF
(NWSI 10-813, Appendix C, 1.2.7.1)""",
45: """Invalid precipitation string
(NWSI 10-813, Appendix C, 1.2.6)""",
46: """P6SM needed with NSW in this group
(NWSI 10-813, Appendix C, 1.2.6)""",
47: """Consecutive NSW groups not permitted
(NWSI 10-813, Appendix C, 1.2.6)""",
48: """When reduction in visibility is forecast
to change in TEMPO group, the significant weather
causing the deterioration shall be included
(NWSI 10-813, Appendix C, 1.2.9.2)""",
49: """Valid time of FM group must be > valid time for
the entire TAF or a previous FM group""",
50: """Valid time must be >= valid time of previous
TEMPO or PROB group""",
51: """Bad TEMPO/PROB group duration""",
52: """Valid time of TEMPO/PROB must be >= valid time
of previous FM group""",
53: """+PL requires visibility < 3SM
PL requires visibility <= 6SM (FMH#1, p 8-3)""",
54: """+SN or +DZ requires visibility <= 1/4SM
SN or DZ requires visibility <= 1/2SM
(FMH#1, p 8-3)""",
55: """+SS or +DS requires visibility <= 1/4SM
SS or DS requires visibility <= 1/2SM
(NWSI 10-813, B-4)""",
56: """The period covered by a TEMPO group will not
exceed 4 hours (NWSI 10-813, 4.3.4)""",
57: """Repeated occurence of weather elements""",
59: """Invalid AMD phrase. Valid phrases are:
=======
_Logger = logging.getLogger(__name__)

try:
    import UFStatusHandler as UFSH
except ModuleNotFoundError:
    pass
else:
    _Logger.addHandler(UFSH.UFStatusHandler(Avn.PLUGIN_NAME, Avn.CATEGORY))

###############################################################################
# local exceptions


class Error(Exception):
    pass


class Warning1(Exception):
    pass  # avoiding name clash

#
# Forecasters (and software) are to follow NWS Instruction 10-813 when
# writing TAFs. The requirements for this module are ascertained
# (sentences having 'shall' and 'will') from that instruction and
# encoded as checks. When these checks are violated, error message(s)
# will be returned and will refer to the NWS Instruction for
# additional details in most instances. Many of the warning messages
# are derived from sentences having the word 'should not'.
#
##############################################################################
# Derived from NWSI 10-813, Dated 18 November 2020
#
# dictionary of errors and warnings
#
#   0 -  9  - Typos, Basic
#  10 - 99  - Warnings
# 100 - TAF elements:
# 100 - 119 - Time
# 120 - 129 - Wind
# 130 - 139 - Visibility
# 140 - 149 - Precip & Tstm
# 150 - 159 - Obvis
# 160 - 165 - Vcnty
# 165 - 169 - NSW
# 170 - 179 - Cloud
# 180 - 189 - Shear
# 190 - 195 - Amd
# 200 -      Policy
#


_Errors = {
    0: """Missing terminating blank""",
    1: """Space required between whole number and fraction
(NWSI 10-813, Appendix B2.6)""",
    2: """Missing weather in this group""",

    100: """Invalid datetime format""",
    101: """Invalid end hour""",
    102: """Invalid start hour""",
    103: """Issue and valid times do not match""",
    105: """Wrong day of the month""",
    106: """Group time period not within forecast period""",
    107: """The duration of a TAF shall not exceed 30 hours""",
    109: """Bad TEMPO/PROB group duration""",
    111: """The duration of a TEMPO group shall not exceed four
hours (NWSI 10-813, Appendix B, 2.9.3)""",
    113: """The duration of a PROB group shall not exceed six
hours (NWSI 10-813, Appendix B, 2.9.4)""",
    115: """Valid time of FM group must be greater than the
start time of the TAF or the previous FM group""",
    117: """Valid time must be greater or equal to the valid
time of previous TEMPO or PROB group""",
    119: """Valid time of TEMPO/PROB group must be greater or
equal to the valid time of prevailing FM group""",

    120: """Invalid value of wind direction""",
    121: """Invalid value of wind speed""",
    122: """Wind gust <= wind speed""",
    123: """Superfluous zero for wind speed""",
    125: """Variable wind speed must be less than 7 knots when no
convective activity is forecast. (NWSI 10-813, Appendix B, 2.4.3)""",
    127: """SQ wind gust speed criteria not met. (NWSI 10-813,
Appendix E4)""",

    130: """Invalid value of visibility (NWSI 10-813, Appendix B,
2.5)""",
    131: """Visibility above 6 statute miles shall be encoded as
P6SM (NWSI 10-813, Appendix B2.6)""",
    132: """Visibility <= 6SM requires forecast of significant
weather (NWSI 10-813, Appendix B, 2.5)""",

    140: """Invalid w'w' group (NWSI 10-813, Appendix E, E4)""",
    141: """Repeated occurence of weather element""",
    142: """No more than three separate w'w' groups in a forecast
period (NWSI 10-813, Appendix B, 2.6)""",
    143: """Invalid weather with visibility >= 6SM (NWSI 10-813,
Appendix B, 2.5)""",
    144: """Thunderstorm forecast requires a CB cloud layer
(NWSI 10-813, Appendix B, 2.7.3)""",
    145: """+PL requires visibility < 3SM, PL requires visibility
< 7SM (FMH-1, Tbl 8-3)""",
    146: """+SN, +DZ, +GS requires visibility < 1/2SM
-SN, -DZ, -GS requires visibility > 1/2SM (FMH-1, Tbl 8-4)""",
    148: """SQ in forecast requires wind gust speed, (NWSI 10-813,
Appendix B, 2.4.4)""",

    151: """Volcanic ash requires a visibility forecast, even
if unrestricted (NWSI 10-813, Appendix B, 2.5)""",
    152: """FG or FZFG forecast requires visibility < 3/4SM,
MIFG requires visibility > 1/2SM (NWSI 10-813, Appendix B,
2.6.3)""",
    153: """BR forecast requires visibility between 3/4SM and
and 6SM (NWSI 10-813, Appendix B, 2.6.3)""",
    154: """+SS or +DS requires visibility <= 1/4SM
SS or DS requires visibility <= 1/2SM (NWSI 10-813, Appendix
E, E4)""",

    160: """Invalid VC weather. Allowed types: VCFG, VCSH, VCTS.
(NWSI 10-813, Appendix B, 2.6.4)""",

    165: """NSW not needed""",
    166: """NSW shall not be used in the initial forecast and FM
groups (NWSI 10-813, Appendix B2.6)""",
    167: """P6SM needed with NSW in this group (NWSI 10-813,
Appendix B, 2.6)""",
    168: """Consecutive NSW groups are not permitted (NWSI 10-813,
Appendix B, 2.6)""",

    170: """Precipitation, including VCSH, requires a cloud layer""",
    171: """Invalid cloud base (NWSI 10-813, Appendix B, 2.7.1)""",
    172: """Invalid sky cover sequence (NWSI 10-813, Appendix
B, 2.7.1)""",
    173: """Cannot forecast partial obscuration (NWSI 10-813,
Appendix B, 2.7.2)""",
    174: """Cloud type CB shall not be used without thunderstorm
in the forecast (NWSI 10-813, Appendix B, 2.7.3)""",

    180: """Invalid value of wind shear direction""",
    181: """Invalid value of wind shear height""",

    190: """Invalid AMD phrase. Valid phrases are:
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
AMD NOT SKED
AMD NOT SKED AFT ddHHmm
AMD NOT SKED TIL ddHHmm
AMD NOT SKED ddHH/ddHH
AMD LTD TO (element list) (AFT ddHHmm, or TIL ddHHmm, or
ddHH/ddHH)""",
<<<<<<< HEAD
60: """NSW not needed""",
61: """The period covered by a TAF shall not exceed 30
hours""",
81: """CB may only be mentioned when TS or VCTS mentioned
(NWSI 10-813, Appendix B, 1.2.7.3)""",
}

_Warnings = { \
#11: """Forecast weather in the vicinity should be
#the last entry in the weather group
#(NWSI 10-813, 1.2.6.1)""",
12: """Number of cloud groups should not exceed three
(NWSI 10-813, Appendix C, 1.2.7.1)""",
13: """The period of time covered by a PROB should be
6 hours or less (NWSI 10-813, Appendix C, 1.2.9.4)""",
14: """Tornadoes or Waterspouts should not be
forecast in terminal forecasts
(NWSI 10-813, Appendix B, 4)""",
15: """Suspicious value of wind speed""",
16: """Suspicious value of wind gust""",
17: """Suspicious value of llws speed""",
19: """AMD restriction not within TAF forecast period""",
31: """Variable wind speed must be between 1 and 6KT
without convective activity.
(NWSI 10-813, Appendix C, 1.2.4)""",
=======
    191: """AMD time period not entirely within the forecast
valid time""",

    200: """Only PROB30 groups are allowed (NWSI 10-813,
Appendix B, 2.9.4)""",
    201: """The PROB group shall not be used in the first nine
hours of the forecast (NWSI 10-813, Appendix B, 2.9.4)""",
    240: """No more than three precip contractions can be combined
in a group without spaces. (NWSI 10-813, Appendix B, 2.6)""",
    241: """Seriously? (NWSI 10-813, Appendix E, E3 Footnote #2)""",
    242: """When reduction in visibility is forecast to change in
the TEMPO group, the significant weather causing the
deterioration shall be included (NWSI 10-813, Appendix B,
2.9.3)""",
    243: """PROB group must include forecast of a thunderstorm
or precipitation event (NWSI 10-813, Appendix B, 2.9.4)""",
    260: """Weather in the vicinity shall not be used in TEMPO
or PROB groups (NWSI 10-813, Appendix B, 2.6.4)""",
    265: """Forecast of no significant weather shall not be
included in PROB groups (NWSI 10-813, Appendix B, 2.9.4)""",
    270: """CLR shall not be used (NWSI 10-813, Appendix B,
2.7.1)""",
    280: """Forecast of non-convective low-level wind shear
shall not be included in TEMPO or PROB groups (NWSI 10-813,
Appendix B, 2.8)""",
}

_Warnings = {
    10: """No more than six FM groups unless absolutely necessary
(NWSI 10-813, Section 4)""",
    11: """No more than eight FM groups unless absolutely necessary
(NWSI 10-813, Section 4)""",
    12: """Amended (AAX), corrected (CCX) or delayed (RRX) code
should be used""",
    20: """Suspicious value of wind speed""",
    21: """Suspicious value of wind gust""",
    40: """Forecast of funnel clouds, waterspouts or tornadoes
only when absolutely necessary (NWSI 10-813, Appendix B, 2.6)""",
    42: """Suspicious precipitation intensity with visibility
value""",
    70: """Sky forecast should not exceed three cloud layers
(NWSI 10-813, Appendix B, 2.7.1)""",
    80: """Suspicious value of low-level wind shear speed""",
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
}

_Messages = {'error': _Errors, 'warning': _Warnings}

###############################################################################
<<<<<<< HEAD
# valid wx elements
# NWSI 10-813, 1.2.5
_ValidVsby = {
    '0': 0.0,
    'M1/4': 0.0,
    '1/4': 0.25,
    '1/2': 0.5,
    '3/4': 0.75,
    '1': 1.0,
    '1 1/2': 1.5,
    '2': 2.0,
    '3': 3.0,
    '4': 4.0,
    '5': 5.0,
    '6': 6.0,
    'P6': 99.0
}

# Appendix B, NWSI 10-813
_ValidObvis = dict.fromkeys(['BR', 'FG', 'FZFG', 'MIFG', 'PRFG', 'BCFG',
    'FU', 'VA', 'HZ', 'BLPY',
    'DU', 'DRDU', 'BLDU',
    'SA', 'DRSA', 'BLSA', 'DRSN',
    'BLSN', 'BLSA', 'BLDU',
    'PO', 'SQ', 'FC', '+FC', 'SS', '+SS', 'DS', '+DS'])

_ValidPcp = dict.fromkeys(['-DZ', 'DZ', '+DZ', '-FZDZ', 'FZDZ', '+FZDZ',
    '-RA', 'RA', '+RA', '-SHRA', 'SHRA', '+SHRA',
        '-TSRA', 'TSRA', '+TSRA', '-FZRA', 'FZRA', '+FZRA',
    '-SN', 'SN', '+SN', '-SHSN', 'SHSN', '+SHSN', 'DRSN',
        '-TSSN', 'TSSN', '+TSSN',
    '-PL', 'PL', '+PL', '+SHPL', 'SHPL', '+SHPL',
        '-TSPL', 'TSPL', '+TSPL',
    '-SG', 'SG', '+SG',
    'IC',
    'GR', 'SHGR', 'TSGR',
    'GS', 'SHGS', 'TSGS',
    'TS'])

_ValidVcnty = dict.fromkeys(['TS', 'SH', 'FG'])

# NWSI 10-813, 1.2.7
_ValidCover = {'FEW': 1, 'SCT': 2, 'BKN': 3, 'OVC': 4}

# NWSI 10-813, 1.2.6
_UnltdVsbyWx = dict.fromkeys(['VA', 'DRDU', 'DRSA', 'DRSN', 'MIFG',
    'PRFG', 'BCFG'])

##############################################################################
# parser stuff
_Cld = '(FEW|SCT|BKN|OVC|VV)\d{3}(CB)?'
_Fract = '(1\s*)?[13]/[24]'
_Obv = 'BR|FG|FU|VA|DU|SA|HZ|PY|PO|SQ|\+?(FC|SS|DS)|SN'
_ObvQ = 'MI|PR|BC|DR|BL|FZ'
_Pcp = 'DZ|RA|SN|SG|IC|PE|GR|GS|UP|PL'
_PcpQ = 'SH|TS|FZ'
_TimePhrase = '(AFT|TIL)\s+(\d{6})|(\d{4}/\d{4})'
_Options = r"""
set lexer = ContextSensitiveLexer
set lexer_dotall = True
"""

_Separator = r"separator spaces:    '\s+' ;"

_pcptok = '[+-]?(%s)?(%s)+' % (_PcpQ, _Pcp)
_obvtok = '(%s)?(%s)' % (_ObvQ, _Obv)

_TokList = [
    ('prefix', r'TAF(\s+(AMD|COR))?'),
    ('ident', r'[A-Z][A-Z0-9]{3}'),
    ('itime', r'\d{6}Z'),
    ('nil', r'NIL'),
    ('vtime', r'\d{4}/\d{4}'),
    ('ftime', r'FM\d{6}'),
    ('ttime', r'TEMPO \d{4}/\d{4}'),
    ('ptime', r'PROB\d{2}\s+\d{4}/\d{4}'),
    ('wind', r'(VRB|\d{3})\d{2,3}(G\d{2,3})?KT'),
    ('vsby', r'(%s|\d|P6)SM' % _Fract),
    ('pcp', r'%s|TS(\s+%s)?' % (_pcptok, _pcptok)),
    ('obv', r'%s(\s+%s)*' % (_obvtok, _obvtok)),
    ('vcnty', r'VC\w+'),
    ('nsw', r'NSW'),
    ('sky', r'SKC|CLR|(%s(\s+%s)*)' % (_Cld, _Cld)),
    ('llws', r'WS\d{3}/\d{5,6}KT'),
    ('amd', r'AMD\s+(NOT\s+|LTD\s+)[^=]+'),
]

_Tokens = '\n'.join([r"token %s: '%s' ;" % tok for tok in _TokList])

_Rules = r"""
START/e -> TAF/e $ e=self.taf() $ ;
TAF -> Prefix? Main (TGroup | PGroup)? (FGroup (TGroup | PGroup)?)* Amd? '(=.*|$)' ;
Main -> Ident ITime VTime/t (Nil | FWeather) $ self.add_group('FM') $ ;
FGroup -> FTime FWeather $ self.add_group('FM') $ ;
TGroup -> TTime/t TWeather $ self.add_group('TEMPO') $ ;
PGroup -> PTime/t PWeather $ self.add_group('PROB') $ ;
FWeather -> Wind Vsby Pcp? Obv? Vcnty? Sky Shear? ;
TWeather -> Wind? Vsby? Pcp? Obv? Vcnty? Nsw? Sky? Shear? ;
PWeather -> Wind? Vsby? Pcp? Obv? Vcnty? Sky? Shear? ;

Prefix -> prefix/x $ self.prefix(x) $ ;
Ident -> ident/x $ self.ident(x) $ ;
ITime -> itime/x $ self.itime(x) $ ;
VTime -> vtime/x $ self.vtime(x) $ ;
FTime -> ftime/x $ self.ftime(x) $ ;
TTime -> ttime/x $ self.ttime(x) $ ;
PTime -> ptime/x $ self.ptime(x) $ ;
Nil -> nil $ self._nil = 1 $ ;
Wind -> wind/x $ self.wind(x) $ ;
Vsby -> vsby/x $ self.vsby(x) $ ;
Pcp -> pcp/x $ self.pcp(x) $ ;
Obv -> obv/x $ self.obv(x) $ ;
Nsw -> nsw/x $ self.nsw(x) $ ;
Vcnty -> vcnty/x $ self.vcnty(x) $ ;
Sky -> sky/x $ self.sky(x) $ ;
Shear -> llws/x $ self.llws(x) $ ;
Amd -> amd/x $ self.amd(x) $ ;
"""
=======
# valid TAF values from NWSI 10-813
# Appendix B Section 2.5
_ValidVsby = {'0': 0.0,
              '1/4': 0.25,
              '1/2': 0.5,
              '3/4': 0.75,
              '1': 1.0,
              '1 1/2': 1.5,
              '2': 2.0,
              '3': 3.0,
              '4': 4.0,
              '5': 5.0,
              '6': 6.0,
              'P6': 99.0}

# Appendix B Section 2.6.2
_ValidObvis = {'BR', 'FG', 'FZFG', 'MIFG', 'PRFG', 'BCFG', 'FU', 'VA', 'HZ',
               'BLPY', 'DU', 'DRDU', 'BLDU', 'SA', 'DRSA', 'BLSA', 'SS', '+SS',
               'DS', '+DS', 'SQ', 'PO', 'FC', '+FC'}

# Appendix B Section 2.6.2
_ValidPcp = {'-DZ', 'DZ', '+DZ',
             '-FZDZ', 'FZDZ', '+FZDZ',
             '-RA', 'RA', '+RA',
             '-SHRA', 'SHRA', '+SHRA',
             '-TSRA', 'TSRA', '+TSRA',
             '-FZRA', 'FZRA', '+FZRA',
             '-SN', 'SN', '+SN',
             '-SHSN', 'SHSN', '+SHSN',
             '-TSSN', 'TSSN', '+TSSN',
             '-PL', 'PL', '+PL',
             '-SHPL', 'SHPL', '+SHPL',
             '-TSPL', 'TSPL', '+TSPL',
             '-SG', 'SG', '+SG',
             'IC',
             'GR', 'SHGR', 'TSGR',
             'GS', 'SHGS', 'TSGS',
             'DRSN', 'BLSN'}

_ValidVcnty = {'TS', 'SH', 'FG'}

# NWSI 10-813, Appendix B 2.7.1
_ValidCover = {'FEW': 1, 'SCT': 2, 'BKN': 3, 'OVC': 4}

# Appendix B 2.5 & 2.6
_UnltdVsbyWx = {'DRDU', 'DRSA', 'DRSN', 'MIFG', 'PRFG', 'BCFG', 'SQ', 'PO', 'VA', 'FC', '+FC'}
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

##############################################################################
# to produce a meaningful error messsage
_TokDict = {
    'prefix': 'TAF or TAF AMD or TAF COR',
    'ident': 'site id',
    'itime': 'issue time',
    'nil': 'NIL',
    'vtime': 'valid time',
    'ftime': 'FMddHHMM',
    'ttime': 'TEMPO ddHH/ddhh',
    'ptime': 'PROB30 ddHH/ddhh',
    'wind': 'wind',
    'vsby': 'visibility',
<<<<<<< HEAD
    'pcp': 'precipitation or thunder',
=======
    'tstm': 'thunderstorm',
    'pcp': 'precipitation',
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    'obv': 'obstruction to vision',
    'vcnty': 'weather in vicinity',
    'nsw': 'no significant wx',
    'sky': 'sky conditions',
    'llws': 'low level wind shear',
<<<<<<< HEAD
    'amd': 'AMD ... phrase',
}

alist = [r'AMD\s+NOT\s+SKED(\s+(%s))?$' % _TimePhrase,
         r'AMD\s+LTD\s+TO(\s+(CLD|VIS|WX|AND|WIND)){1,5}(\s+(%s))?$' % _TimePhrase]
_AmdPat = re.compile('|'.join(alist))
_ConvectionPat = re.compile(r'TS|SH')

##############################################################################
# local functions
=======
    'amd': 'AMD phrase',
}

_TimePhrase = r'(AFT|TIL)\s+(\d{6})|(\d{4}/\d{4})'

alist = [r'AMD\s+NOT\s+SKED(\s+(%s))?' % _TimePhrase,
         r'AMD\s+LTD\s+TO(\s+(CLD|VIS|WX|AND|WIND)){1,5}(\s+(%s))?' % _TimePhrase]
_AmdPat = re.compile(r'|'.join(alist))

_OK = 0
_LO = 1
_HI = 2

EPOCH = datetime.datetime(year=1970, month=1, day=1, tzinfo=datetime.timezone.utc)

##############################################################################
# local functions


def tstm_present(g):
    """Utility to check if TS is present"""
    return element_present(g, 'pcp', 'TS') or element_present(g, 'vcnty', 'VCTS') or 'tstm' in g


def element_present(g, key, target):
    """Check to see if target is present"""
    try:
        return target in g[key]['str']
    except KeyError:
        return False


>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
def valid_base(base):
    """Checks if cloud base is valid"""
    if base <= 30:
        return True
    elif base <= 50:
        return base % 5 == 0
    else:
        return base % 10 == 0

<<<<<<< HEAD
def invalid_pl_vsby(i, v):
    """Checks if visibility is inconsistent with PL"""
    if i == '+' and v >= 3.0:
        return True
    elif i == '' and v > 6.0:
        return True
    else:
        return False

def invalid_sn_vsby(i, v):
    """Checks if visibility is inconsistent with SN or DZ
Returns 0 if consistent, -1 if too high, +1 if too low"""
    if i == '+':
        if v > 0.25:
            return -1
        else:
            return 0
    elif i == '':
        if v > 0.5:
            return -1
        elif v <= 0.25:
            return 1
        else:
            return 0
    elif i == '-':
        if v <= 0.5:
            return 1
        else:
            return 0
    else:
        return 0
=======

def check_ww_w_vsby(ww, vsby):
    """Examines predominate ww with prevailing visibility
    and issues a ruling returning a tuple containing the
    decision, and the associated error or warning message
    via err_key"""
    vsbyIs = None
    ww_list = get_pcp_list(ww['str'].split()[0])
    first_ww = ww_list.pop(0)

    i, ptype = first_ww[0], first_ww[-2:]
    if i not in '+-':
        i = ''

    if ptype == 'PL':
        vsbyIs, err_key = invalid_pl_vsby(i, vsby), 145

    elif ptype in {'SN', 'DZ', 'GS'}:
        if first_ww[:2] not in {'BL', 'DR'}:
            vsbyIs, err_key = invalid_sn_vsby(i, vsby), 146
        else:
            vsbyIs, err_key = _OK, None

    elif ptype in ['IC', 'SG']:
        vsbyIs, err_key = _OK, None

    if vsbyIs is None:
        #
        # Suspicious
        if i == '' and vsby > 4:
            return _HI, 42
        elif i == '+' and vsby > 2:
            return _HI, 42
        else:
            return _OK, None
    else:
        return vsbyIs, err_key


def invalid_pl_vsby(i, v):
    """Checks if visibility is inconsistent with PL
    intensity. Returns _OK if consistent, _HI if too high"""
    if i == '':
        if v > 6.0:
            return _HI
    elif i == '+':
        if v >= 3.0:
            return _HI
    return _OK


def invalid_sn_vsby(i, v):
    """Checks if visibility is inconsistent with SN, DZ or GS
    intensity. Returns _OK if consistent, _HI if too high, _LO if
    too low"""
    if i == '+':
        if v > 0.25:
            return _HI
    elif i == '':
        if v > 0.5:
            return _HI
        elif v <= 0.25:
            return _LO
    elif i == '-':
        if v <= 0.5:
            return _LO
    return _OK

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

def invalid_fg_vsby(s, v):
    """Checks if visibility is inconsistent with FG"""
    # NWSI 10-813, 1.2.6
<<<<<<< HEAD
    if len(s) == 2 or s.startswith('FZ'):
        if v > 0.6:
            return True
    elif s.startswith('MI'):
=======
    if s in ['FG', 'FZFG']:
        if v > 0.6:
            return True
    elif s == 'MIFG':
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        if v < 0.6:
            return True
    return False

<<<<<<< HEAD
=======

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
def invalid_br_vsby(v):
    """Checks if visibility is inconsistent with BR"""
    return not 0.6 < v < 6.1

<<<<<<< HEAD
=======

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
def invalid_ds_vsby(i, v):
    """Checks if visibility is inconsistent with DS or SS"""
    if i == '+' and v >= 0.3:
        return True
    elif i == '' and not 0.3 < v < 0.6:
        return True
    return False

<<<<<<< HEAD
=======

def invalid_taf_timestamp(d, sday, eday):
    """Double check forecaster timestamps"""
    dt = datetime.datetime.utcfromtimestamp(d['from'])
    r1 = sday != dt.day

    dt = datetime.datetime.utcfromtimestamp(d['to'])
    r2 = eday != dt.day

    return r1 or r2


>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
def check_sky(tok, cover, base, cig):
    """Verifies validity of cloud layer.
Calculates summary cover, base, cig. Raises exception on error.
Arguments: (cover, base, cig) evaluated from lower layers."""
    if tok.startswith('VV'):
<<<<<<< HEAD
        if cover != 0:
            raise Error(_Errors[40])
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        base = cig = int(tok[2:5])
    elif tok == 'CLR':
        cig = Avn.CLEAR
    elif tok == 'SKC':
        cig = Avn.UNLIMITED
    else:
        tcover, tbase = _ValidCover.get(tok[:3], None), int(tok[3:6])
        if tcover is None or tcover < cover or cover == 4:
<<<<<<< HEAD
            raise Error(_Errors[17])
        if not valid_base(tbase) or tbase <= base:
            raise Error(_Errors[41])
        if tbase == 0 and tcover != 4:
            raise Error(_Errors[42])
=======
            raise Error(_Errors[172])
        if not valid_base(tbase) or tbase <= base:
            raise Error(_Errors[171])
        if tbase == 0 and tcover != 4:
            raise Error(_Errors[173])
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        if tcover in [3, 4]:
            cig = min(cig, tbase)
        cover, base = tcover, tbase

    return cover, base, cig

<<<<<<< HEAD
def valid_day(tms):
    """Checks if day of month is valid"""
    year, month, day = tms[:3]
    if day > 31:
        return False
    if month in [4, 6, 9, 11] and day > 30:
        return False
    if month == 2:
        if (year%4 and day > 28) or day > 29:
            return False
    return True

def fix_date(tms):
    """Tries to determine month and year from report timestamp"""
    now = time.time()
    t = time.mktime(tuple(tms)) - time.timezone
    # tms contains day, hour, min of the report, current year and month
    if t > now + 3*86400.0:     # previous month
=======

def valid_day(tms):
    """Checks if day of month is valid"""
    try:
        datetime.date(tms[0], tms[1], tms[2])
    except ValueError:
        return False
    return True


def fix_date(tms, overrideTime=None):
    """Tries to determine month and year from report timestamp.
    tms - list of time.tm_struct elements
    overrideTime - an 'aware' datetime object to use instead of the
    current system time"""
    #
    if overrideTime is None:
        now = time.time()
    else:
        deltatime = overrideTime - EPOCH
        now = deltatime.total_seconds()
    #
    # Always UTC
    t = calendar.timegm(tuple(tms))
    # tms contains day, hour, min of the report, current year and month
    if t > now + 3 * 86400.0:     # previous month
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        if tms[1] > 1:
            tms[1] -= 1
        else:
            tms[1] = 12
            tms[0] -= 1
<<<<<<< HEAD
    elif t < now - 25*86400.0:  # next month
=======

    elif t < now - 25 * 86400.0:  # next month
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        if tms[1] < 12:
            tms[1] += 1
        else:
            tms[1] = 1
            tms[0] += 1

<<<<<<< HEAD
def get_prev_pcp(s):
    """Parses precipitation string to extract prevailing precipitation.
Return tuple: (prev, other). Skips stand-alone TS"""
    if s.startswith('TS'):
        s = s.split()[-1]
=======

def get_pcp_list(s):
    """Parses precipitation string to extract prevailing precipitation.
Return list: [prev, other]"""
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    if s[0] in '-+':
        n = 1
    else:
        n = 0
<<<<<<< HEAD
    if s[n:n+2] in _PcpQ:
        n += 2
    return s[:n+2], s[n+2:]
=======

    PcpQs = ['SH', 'TS', 'FZ', 'DR', 'BL']
    if s[n:n + 2] in PcpQs:
        n += 2

    tokens = [s[:n + 2]]
    tokens.extend(re.findall('..', s[n + 2:]))

    return tokens

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

def add_msg(d, key, msg):
    """Adds text error message to dictionary d. msg is either a text or
message number from _Errors or _Warnings"""
<<<<<<< HEAD
    if type(msg) is int:
        msg = _Messages[key].get(msg, 'Unknown %s %d' % (key, msg))
    else:
        msg = str(msg)
    if key in d:
        d[key].append(msg)
    else:
        d[key] = [msg]

##############################################################################
# decoder class
class Decoder(tpg.VerboseParser):
    """TAF decoder class"""
    verbose = 0
    __doc__ = '\n'.join([_Options, _Separator, _Tokens, _Rules])

    def __call__(self, taf, bbb=None, firstline=0, strict=False):
        """Decodes TAF. taf starts with CCCC ddhhmmZ"""
        if type(taf) is list:
            taf = '\n'.join(taf)
        if not bbb:
            bbb = '   '
        self._taf = {'bbb': bbb, 'group': []}
        self._strict = strict
        self._group = {}
        self._first = firstline
        self._cutoff = 0
        self.expected = []
        self._nil = 0
        self.bad = {}
        # strip trailing '=' and add a terminating blank
        i = taf.find('=')
        if i > 0:
            taf = taf[:i]
        self._text = taf + ' '
        try:
            return super(Decoder, self).__call__(self._text)
        except tpg.SyntacticError:
            if self.expected:
                return {'index': self.bad['index'], \
                    'fatal': ['Invalid word %s. Expecting one of:\n%s' % \
                        (self.bad['text'], '\n'.join(self.expected))]}
            else:
                return {'index': self.bad['index'], \
                    'fatal': ['Unexpected end after %s.' % self.bad['text']]}
        except Exception as e:
            # highlight only site id
            row = self._first+2
            index = ('%d.%d' % (row, 0), '%d.%d' % (row, 4))
            return {'index': index, 'fatal': ['TAF decoder bug:\n', traceback.format_exc()]}

    def __index(self, pos, token):
        tmp = self.lexer.input[:pos]
        line = tmp.count('\n') + self._first + 1
        row = pos - tmp.rfind('\n') - 1
        return ('%d.%d' % (line, row), '%d.%d' % (line, row+len(token)))

    def index(self):
        token = self.lexer.token()
        return self.__index(token.start, token.text)

    def tokenOK(self, pos=0):
        """Checks whether token ends with a blank"""
        return self._text[self.lexer.token().stop+pos] in ' \t\n'
=======
    if isinstance(msg, int):
        msg = _Messages[key].get(msg, 'Unknown %s %d' % (key, msg))
    else:
        msg = str(msg)

    d.setdefault(key, []).append(msg)


class Decoder(tpg.Parser):
    r"""
    set lexer = ContextSensitiveLexer
    set lexer_dotall = True

    separator spaces:    '\s+' ;
    token prefix: 'TAF(\s+(AMD|COR))?' ;
    token ident: '[A-Z][A-Z0-9]{3}' ;
    token itime: '\d{6}Z' ;
    token nil: 'NIL' ;
    token vtime: '\d{4}/\d{4}' ;
    token ftime: 'FM\d{6}' ;
    token ttime: 'TEMPO \d{4}/\d{4}' ;
    token ptime: 'PROB\d{2}\s+\d{4}/\d{4}' ;
    token wind: '(VRB|\d{3})\d{2,3}(G\d{2,3})?KT' ;
    token vsby: '(((?P<w>\d\s*)?(?P<f>[13]/[24]))|(\d+)|P6)SM' ;
    token tstm: 'TS[\s\n]' ;
    token pcp: '([+-]?(SH|TS|FZ)?(DZ|RA|(DR|BL)?SN|SG|IC|PE|GR|GS|PL|UP)+)(\s+([+-]?(SH|TS|FZ)?(DZ|RA|(DR|BL)?SN|SG|IC|PE|GR|GS|PL|UP)+))*' ; # noqa: E501
    token obv: '(MI|PR|BC|DR|BL|FZ)?(BR|FG|FU|VA|DU|SA|HZ|PY|\+?(SS|DS|FC)|PO|SQ)(\s+(MI|PR|BC|DR|BL|FZ)?(BR|FG|FU|VA|DU|SA|HZ|PY|\+?(SS|DS|FC)|PO|SQ))*' ; # noqa: E501
    token vcnty: 'VC\w+' ;
    token nsw: 'NSW' ;
    token sky: 'SKC|CLR|((FEW|SCT|BKN|OVC|VV)\d{3}(CB)?(\s+(FEW|SCT|BKN|OVC|VV)\d{3}(CB)?)*)' ;
    token llws: 'WS\d{3}/\d{5,6}KT' ;
    token amd: 'AMD\s+(NOT\s+|LTD\s+)[^=]+' ;

    START/e -> TAF/e $ e=self.taf() $ ;
    TAF -> Prefix? Main (TGroup | PGroup)? (FGroup (TGroup | PGroup)?)* Amd? '=' ;
    Main -> Ident ITime VTime/t (Nil | FWeather) $ self.add_group('FM') $ ;
    FGroup -> FTime FWeather $ self.add_group('FM') $ ;
    TGroup -> TTime Any $ self.add_group('TEMPO') $ ;
    PGroup -> PTime Any $ self.add_group('PROB') $ ;
    FWeather -> Wind Vsby Tstm? Pcp? Obv? Vcnty? Nsw? Sky Shear? ;
    Any -> Wind? Vsby? Tstm? Pcp? Obv? Vcnty? Nsw? Sky? Shear? ;

    Prefix -> prefix ;
    Ident -> ident/x $ self.ident(x) $ ;
    ITime -> itime/x $ self.itime(x) $ ;
    VTime -> vtime/x $ self.vtime(x) $ ;
    FTime -> ftime/x $ self.ftime(x) $ ;
    TTime -> ttime/x $ self.ttime(x) $ ;
    PTime -> ptime/x $ self.ptime(x) $ ;
    Nil -> nil $ self._nil = True $ ;
    Wind -> wind/x $ self.wind(x) $ ;
    Vsby -> vsby/x $ self.vsby(x) $ ;
    Tstm -> tstm $ self._group['tstm'] = {'index': self.index()} $ ;
    Pcp -> pcp/x $ self.pcp(x) $ ;
    Obv -> obv/x $ self.obv(x) $ ;
    Nsw -> nsw/x $ self._group['nsw'] = {'index': self.index()} $ ;
    Vcnty -> vcnty/x $ self.vcnty(x) $ ;
    Sky -> sky/x $ self.sky(x) $ ;
    Shear -> llws/x $ self.llws(x) $ ;
    Amd -> amd/x $ self.amd(x) $ ;"""

    def __init__(self):

        super(Decoder, self).__init__()
        #
        # Attributes needed for component/regression testing
        self._taf = {'bbb': ' ', 'group': []}
        self._strict = False
        self._group = {}
        self._grptype = None
        self._first = 0
        self._cutoff = 0
        self.expected = []
        self._nil = False
        self.bad = {}
        #
        # Attribute self._SystemClockTime allows the decoder be to set
        # at any point in time instead of the system clock time. This
        # permits historical case studies/scenarios to be done. Also
        # regression tests for end-of-the-month, leap-day, and
        # end-of-year scenarios as well can be performed as needed.
        #
        # It is an 'aware' datetime object when not None.
        self._SystemClockTime = None

        self.precipSet = {'tstm', 'pcp', 'obv', 'vcnty'}

    def __call__(self, raw, bbb=None, firstline=0, strict=False):
        """Transforms alphanumeric TAF into a dictionary"""
        if isinstance(raw, list):
            raw = '\n'.join(raw)

        if bbb is None:
            bbb = '   '
        #
        # Reset attributes each time the decoder is called
        self._taf = {'bbb': bbb, 'group': []}
        self._group = {}
        self._grptype = None
        self._nil = False
        self._fm_cnt = 0

        self._first = firstline
        self._strict = strict
        self._cutoff = 0
        self.expected = []
        self.bad = {}
        #
        # strip trailing '=' and anything else
        taf  = raw.partition('=')[0]
        #
        # The parser proceeds to decode the TAF line-by-line. Each
        # line consist of several possible meteorological parameters,
        # (see: FGroup, TGroup, PGroup axioms above). As text strings
        # are identified via regular expressions, the associated
        # methods below are called. Most methods then perform simple
        # checks for errors and store the parsed data in the
        # self._group dictionary with their unique key value.
        #
        # When the end of the FGroup, TGroup, PGroup axioms is
        # reached, the add_group() method is called.  This routine
        # then performs additional checks *between* elements in the
        # self._group dictionary and in self._taf['group']. Once the
        # checks are completed, the self._group dictionary contents
        # are copied and appended as a new dictionary to the list
        # self._taf['group']. self._group dictionary is then reset for
        # the next FGroup, TGroup, or PGroup of the TAF.
        #
        # When the ETX character '=' is found, the parser concludes
        # the TAF has been completely parsed. In case of the TAF
        # Editor, strict is True when the TafDecoder is called, and
        # time checks are then performed on the issue time, valid
        # period and setting of the bbb field.
        #
        # self._taf is returned to the TafEditor. The editor then
        # traverses the list of dictionaries in the 'group' key for
        # any errors or warnings found and highlights them using the
        # 'index' values.
        #
        try:
            return super(Decoder, self).__call__('{}='.format(taf.rstrip()))
        #
        # If meteorological parameters appear out of order in the TAF text . . .
        except tpg.SyntacticError:
            if self.expected:
                return {'index': self.bad['index'],
                        'fatal': ['Invalid word %s. Expecting one of:\n%s' %
                                  (self.bad['text'], '\n'.join(self.expected))]}
            else:
                return {'index': self.bad['index'],
                        'fatal': ['Unexpected end after %s' % self.bad['text']]}

        except Exception:
            #
            # Report this in the log file, along with traceback information.
            _Logger.error('TAF: %s\n', self.lexer.input, exc_info=True, stack_info=True)
            return {'index': self.index(), 'fatal': ['TAF decoder stopped here with\nunexpected error. Open ticket.']}

    def _index(self, pos, token):
        """Adjust line numbering to account for multiple TAFs in editor"""
        tmp = self.lexer.input[:pos]
        line = tmp.count('\n') + self._first + 1
        row = pos - tmp.rfind('\n') - 1
        return ('%d.%d' % (line, row), '%d.%d' % (line, row + len(token)))

    def index(self):
        """Return current position of token within the input string"""
        token = self.lexer.token()
        return self._index(token.start, token.text)

    def tokenOK(self, pos=0):
        """Checks whether token ends with a blank or ETX character"""
        return self.lexer.input[self.lexer.token().stop + pos] in ' \t\n='
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    def taf(self):
        """Called by the parser at the end of work"""
        if self._strict:
            self.check_issue_time()
        return self._taf

<<<<<<< HEAD
    def eatCSL(self, name):
        """Overrides super definition"""
        try:
            value = super(Decoder, self).eatCSL(name)
            self.bad = {}
            self.expected = []
            return value
        except tpg.WrongToken:
            if self.lexer.input[self.lexer.pos:]:
                bad = self.lexer.input[self.lexer.pos:].split(None, 1)[0]
                if self.bad:
                    if bad == self.bad['text']:
                        self.expected.append(_TokDict.get(name, ''))
                else:
                    self.bad['text'] = bad
                    self.bad['index'] = self.__index(self.lexer.pos, bad)
                    self.expected.append(_TokDict.get(name, ''))
            else:
                bad = self.lexer.input.split()[-1]
                self.bad['text'] = bad
                self.bad['index'] = self.__index(self.lexer.pos-len(bad)-1, bad)
            raise

    def add_group(self, type):
        """Checks for valid syntax between elements in a group and
        and valid times"""
        if self._nil or not self._group:
            return
        if type == 'PROB':
            self.check_prob_group()
        if type == 'TEMPO':
            self.check_tempo_group()

        self._group['type'] = type

        # TEMPO and PROB groups modify conditions reported in FM group
        if self._group['type'] in ['PROB', 'TEMPO']:
            tmpgroup = self._taf['group'][-1]['prev'].copy()
            # pcp, obv and vcnty go together, wx in TEMPO overrides FM
            if 'nsw' in self._group or 'pcp' in self._group or \
                   'obv' in self._group:    # no VC in TEMPO
                rmvditem = False
                for item in ['pcp', 'obv', 'vcnty']:
                    if item in tmpgroup:
                        del tmpgroup[item]
                        rmvditem = True

                if not rmvditem and 'nsw' in self._group:
                    add_msg(self._group['nsw'],'error',60)

            tmpgroup.update(self._group)
        else:
            tmpgroup = self._group

        try:
            self.check_wind(tmpgroup)
        except Warning1 as e:
            # Wind 'inherited' from prevailing group if not
            # in occasional group
            try:
                add_msg(self._group['wind'], 'warning', e)
            except KeyError:
                pass

        try:
            self.check_pcp(tmpgroup)
        except Error as e:
            try:
                add_msg(self._group['pcp'], 'error', e)
            except KeyError:
                pass

        self.check_obv()

        try:
            self.check_vsby_wx(tmpgroup)
        except Error as e:
            for k in ['pcp', 'obv', 'vsby']:
                if k in self._group:
                    add_msg(self._group[k], 'error', e)
                    break
        try:
            self.check_ts_cb(tmpgroup)
        except Error as e:
            for k in ['vcnty', 'pcp', 'sky']:
=======
    def expectFilter(self, token_name):
        """Provide messages that are appropriate at the halting position"""
        if token_name in ['wind', 'vsby', 'tstm', 'pcp', 'obv', 'sky'] or self._grptype is None:
            return True
        elif self._grptype == 'ftime':
            return token_name in ['vcnty', 'llws']
        elif self._grptype == 'ttime':
            return token_name == 'nsw'
        else:
            return False

    def eatCSL(self, name):
        """Overrides super-class definition. Don't change unless you really know what
           you are doing."""
        try:
            value = super(Decoder, self).eatCSL(name)

            self.bad = {}
            self.expected = []

            if name in ['ftime', 'ttime', 'ptime']:
                self._grptype = name

            return value

        except tpg.WrongToken:

            if self.lexer.input[self.lexer.pos:]:
                bad = self.lexer.input[self.lexer.pos:].split(None, 1)[0]

                if self.bad:
                    if bad == self.bad['text']:
                        if self.expectFilter(name):
                            self.expected.append(_TokDict.get(name, ''))
                else:
                    self.bad['text'] = bad
                    self.bad['index'] = self._index(self.lexer.pos, bad)
                    if self.expectFilter(name):
                        self.expected.append(_TokDict.get(name, ''))
            else:
                bad = self.lexer.input.split()[-1]
                self.bad['text'] = bad
                self.bad['index'] = self._index(self.lexer.pos - len(bad) - 1, bad)

            raise

    def add_group(self, grp_type):
        """Checks for compliance between TAF elements in a group and and valid times"""
        #
        # For NIL TAF there's nothing to check.
        if self._nil:
            return

        if grp_type == 'FM':
            self.check_fm_time()
            self.check_fm_group()

        else:
            self.check_ocnl_time()
            if grp_type == 'PROB':
                self.check_prob_group()

        self._group['type'] = grp_type

        # TEMPO and PROB groups modify conditions reported in FM group
        if grp_type != 'FM':
            #
            # Get a copy of prevailing conditions as a new group
            new_group = self._taf['group'][-1]['prev'].copy()
            #
            # What elements will be updated
            updated_elements = self._group.keys()
            #
            # Is there any weather in the updated_element set?
            if any([k in self.precipSet | {'nsw'} for k in updated_elements]):
                #
                # Check to see if there's any weather to remove in the
                # new group, i.e. prevailing
                if any([k in self.precipSet for k in new_group]):
                    for item in self.precipSet:
                        if item in new_group:
                            del new_group[item]
                #
                # If there is no weather in new_group AND TEMPO has NSW, flag that
                # as un-necessary
                elif grp_type == 'TEMPO' and 'nsw' in self._group:
                    add_msg(self._group['nsw'], 'error', 165)
            #
            # Update new_group with what is occurring in the TEMPO/PROB group
            new_group.update(self._group)
            #
            # FM groups always have the vsby group. For TEMPO and PROB groups, it's
            # optional NWSI 10-813, Appendix B2.5
            if element_present(self._group, 'obv', 'VA') and 'vsby' not in self._group:
                add_msg(self._group['obv'], 'error', 151)

            if grp_type == 'TEMPO':
                self.check_tempo_group()
        #
        # Else this is a FM group, everything is checked
        else:
            updated_elements = self._group.keys()
            new_group = self._group
        #
        # If there was a change to the following elements, perform check
        if any([x in updated_elements for x in {'wind', 'sky', 'tstm', 'pcp'}]):
            try:
                self.check_vrb_wind(new_group)
            except Error as e:
                for k in ['wind', 'sky', 'tstm', 'pcp']:
                    if k in self._group:
                        add_msg(self._group[k], 'error', e)
                        break

        if any([x in updated_elements for x in {'obv', 'wind'}]):
            try:
                self.check_sq_wind(new_group)
            except Error as e:
                for k in ['obv', 'wind']:
                    if k in self._group:
                        add_msg(self._group[k], 'error', e)
                        break

        try:
            self.check_ww(new_group)
        except Error as e:
            for k in ['vcnty', 'obv', 'pcp']:
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                if k in self._group:
                    add_msg(self._group[k], 'error', e)
                    break

<<<<<<< HEAD
        if self._group['type'] == 'FM':
            self.check_prev_time()
            self._taf['group'].append({'prev': self._group})
        else:
            period = self._taf['group'][-1]
            self.check_ocnl_time()
            period['ocnl'] = self._group
        self._group = {}
=======
        if any([x in updated_elements for x in self.precipSet | {'vsby'}]):
            try:
                self.check_vsby_wx(new_group)
            except Error as e:
                for k in self.precipSet | {'vsby'}:
                    if k in self._group:
                        add_msg(self._group[k], 'error', e)
                        break
            except Warning1 as e:
                for k in ['pcp', 'vsby']:
                    if k in self._group:
                        add_msg(self._group[k], 'warning', e)
                        break

        if any([x in updated_elements for x in self.precipSet | {'sky'}]):
            try:
                self.check_cb_tstm(new_group)
            except Error as e:
                for k in ['sky', 'tstm', 'pcp', 'vcnty']:
                    if k in self._group:
                        add_msg(self._group[k], 'error', e)
                        break

        if any([x in updated_elements for x in {'pcp', 'vcnty', 'sky'}]):
            try:
                self.check_sky_pcp(new_group)
            except Error as e:
                for k in ['sky', 'pcp', 'vcnty']:
                    if k in self._group:
                        add_msg(self._group[k], 'error', e)
                        break

        self.prepend_tstm()

        if grp_type == 'FM':
            self._taf['group'].append({'prev': self._group})
        else:
            period = self._taf['group'][-1]
            period['ocnl'] = self._group

        self._group = {}
        self._grptype = None
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    ###################################################################
    # Element checks
    def check_issue_time(self):
<<<<<<< HEAD
=======
        """Checks the issue time with the valid period provided"""
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        try:
            itime = self._taf['itime']['value']
            vtime = self._taf['vtime']['from']
            bbb = self._taf['bbb'][0]
            if bbb == ' ':
<<<<<<< HEAD
                if -2401.0 <= itime - vtime < 0:
                    return
            elif bbb == 'R':    # to allow incoming TAFs
                if -2401.0 < itime - vtime < 1800.0:
                    return
            elif bbb == 'C':
=======
                if -2401.0 <= itime - vtime <= 0:
                    return
                elif itime - vtime > 0:
                    add_msg(self._taf['itime'], 'warning', 12)
                    return

            elif bbb == 'R':    # to allow incoming TAFs
                if -2401.0 < itime - vtime < 1801.0:
                    return
            elif bbb == 'C':    # no checks as unwilling to give decoder a memory.
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                if -2401.0 <= itime - vtime < 21600.0:
                    return
            else:
                if -1801.0 < itime - vtime < 1801.0:
                    return
<<<<<<< HEAD
            add_msg(self._taf['itime'], 'error', 24)
        except KeyError:
            pass

    def check_prev_time(self):
        if not self._taf['group']:  # main group
            return
        period = self._taf['group'][-1]
        t = self._group['time']
        try:
            if t['from'] <= max(period['prev']['time']['from'], self._cutoff):
                add_msg(t, 'error', 49)
            elif t['from'] <= self._taf['vtime']['from']:
                add_msg(t, 'error', 49)
            if 'ocnl' in period and t['from'] < period['ocnl']['time']['to']:
                add_msg(t, 'error', 50)
=======

            add_msg(self._taf['itime'], 'error', 103)
        #
        # NIL TAFs do not have a valid period (or shouldn't, anyway)
        except KeyError:
            pass

    def check_fm_time(self):
        """Check time span for FM group"""
        try:
            period = self._taf['group'][-1]
        #
        # initial condition spans entire valid time period, so no
        # adjustments required
        except IndexError:
            return

        t = self._group['time']
        try:
            if t['from'] <= max(period['prev']['time']['from'], self._cutoff):
                add_msg(t, 'error', 115)
            elif t['from'] <= self._taf['vtime']['from']:
                add_msg(t, 'error', 115)
            if 'ocnl' in period and t['from'] < period['ocnl']['time']['to']:
                add_msg(t, 'error', 117)
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            period['prev']['time']['to'] = t['from']
        except KeyError:
            pass

    def check_ocnl_time(self):
<<<<<<< HEAD
=======
        """Check time spans in conditional group"""
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        period = self._taf['group'][-1]
        t = self._group['time']
        # adjust start of valid time for the first conditional group
        if len(self._taf['group']) == 1:
            itime = self._taf['itime']['value']
            vtime = self._taf['vtime']['from']

            if itime - 1800.0 < t['from'] < itime:
                t['from'] = itime
            elif t['from'] == vtime and vtime % 21600 < 60.0:
                t['from'] = itime
        try:
            if t['from'] < period['prev']['time']['from']:
<<<<<<< HEAD
                add_msg(t, 'error', 52)
        except KeyError:
            pass

    def check_prob_group(self):
        if 'pcp' not in self._group:
            add_msg(self._group['time'], 'error', 16)
        if 'llws' in self._group:
            add_msg(self._group['llws'], 'error', 33)
        if 'vcnty' in self._group:
            add_msg(self._group['vcnty'], 'error', 28)

    def check_tempo_group(self):
        if len(self._group) < 2:
            add_msg(self._group['time'], 'error', 34)
        if 'llws' in self._group:
            add_msg(self._group['llws'], 'error', 33)
        if 'vcnty' in self._group:
            add_msg(self._group['vcnty'], 'error', 28)

        if 'nsw' in self._group:
            try:
                if 'nsw' in self._taf['group'][-2]['ocnl']:
                    add_msg(self._group['nsw'], 'error', 47)
                    return
            except (IndexError,KeyError):
                pass

            if 'vsby' in self._group:
                if self._group['vsby']['value'] < 7.0:
                    add_msg(self._group['vsby'], 'error', 46)
            else:
                add_msg(self._group['nsw'], 'error', 46)

            if 'obv' in self._group or 'pcp' in self._group:
                add_msg(self._group['nsw'], 'error', 60)

        else:
#            if 'vsby' in self._group:
            # When invalid 'value' can be missing.
            if 'vsby' in self._group and 'value' in self._group['vsby']:
                #
                # If reduction in visibility is forecasted in TEMPO and there's
                # no mention of obv or wx...
                prev = self._taf['group'][-1]['prev']
                if 'value' in prev['vsby'] and \
                       prev['vsby']['value'] > self._group['vsby']['value'] and \
                       ('pcp' in prev or 'obv' in prev or 'vcnty' in prev) and \
                       not ('pcp' in self._group or 'obv' in self._group):
                    add_msg(self._group['vsby'], 'error', 48)

    def check_wind(self,g):
        # variable wind speed > 6kt needs convective weather
        try:
            wind = g['wind']
        except KeyError:
            return

        dd, ff = wind.get('dd', None), wind.get('ff', None)
        if dd == 'VRB' and ff > 6:
            wx = g.get('pcp', None)
            if wx:
                for tok in wx['str'].split():
                    if _ConvectionPat.search(tok):
                        return

            wx = g.get('vcnty', None)
            if wx:
                if wx['str'] in ['VCTS','VCSH']:
                    return

            sky = g.get('sky', None)
            if sky:
                for lyr in sky['str'].split():
                    if lyr.endswith('CB'):
                        return

            raise Warning1(_Warnings[31])

    def check_pcp(self,g):
        # NWSI 10-813, 1.2.6
        if 'pcp' not in g:
            return
        try:
            plist = g['pcp']['str'].split()
            if plist.index('TS') != 0 or 'FZ' not in plist[1]:
                raise Error(_Errors[45])
        except (KeyError, IndexError, ValueError):
            pass

        prev, other = get_prev_pcp(g['pcp']['str'])
        tok = [prev[-2:]] + [other[n:n+2] for n in range(0, len(other)-2, 2)]
        if len(tok) != len(dict.fromkeys(tok)):
            raise Error(_Errors[57])

    def check_ts_cb(self, g):
        # NWSI 10-813, 1.2.6
        if 'pcp' in g and 'TS' in g['pcp']['str'] or 'vcnty' in g and \
            'TS' in g['vcnty']['str']:
            if 'sky' not in g or 'CB' not in g['sky']['str']:
                raise Error(_Errors[11])
        if 'sky' in g and 'CB' in g['sky']['str']:
            if ('pcp' not in g or 'TS' not in g['pcp']['str']) and \
                    ('vcnty' not in g or 'TS' not in g['vcnty']['str']):
                raise Error(_Errors[81])

    def check_obv(self):
        # NWSI 10-813, 1.2.6
        if 'obv' in self._group and 'VA' in self._group['obv']['str'] \
               and not 'vsby' in self._group:
            add_msg(self._group['obv'], 'error', 13)

    def check_vsby_wx(self, g):
        if 'vsby' in g:
            try:
                vsby = g['vsby']['value']
            except KeyError:
                return
            # visibility consistent with precipitation
            snow = 0
            if 'pcp' in g:
                prev = get_prev_pcp(g['pcp']['str'])[0]
                try:
                    i, ptype = prev[0], prev[-2:]
                    if i not in '+-':
                        i = ''
                    if ptype == 'PL':
                        if invalid_pl_vsby(i, vsby):
                            raise Error(_Errors[53])
                    elif ptype in ('SN', 'DZ'):
                        snow = invalid_sn_vsby(i, vsby)
                except TypeError:   # TS
                    pass
            if g['vsby']['str'] == 'P6SM':
                if 'obv' in g and 'nsw' not in g:
                    for wx in g['obv']['str'].split():
                        if wx not in _UnltdVsbyWx:
                            raise Error(_Errors[18])
                if snow == -1:
                    raise Error(_Errors[54])
            # NWSI 10-813, 1.2.6
            else:
                if not ('pcp' in g or 'obv' in g or 'nsw' in g):
                    add_msg(g['vsby'], 'error', 12)
                if 'obv' in g:
                    for tok in g['obv']['str'].split():
                        wx = tok[-2:]
                        if wx == 'FG' and \
                            invalid_fg_vsby(tok, vsby):
                            raise Error(_Errors[14])
                        if wx == 'BR' and invalid_br_vsby(vsby):
                            raise Error(_Errors[15])
                        if wx in ('DS', 'SS'):
                            if tok[0] in '+-':
                                i = tok[0]
                            else:
                                i = ''
                            if invalid_ds_vsby(i, vsby):
                                raise Error(_Errors[55])
                    if snow == -1:
                        raise Error(_Errors[54])
                else:
                    if snow:
                        raise Error(_Errors[54])

    ########################################################################
    # Methods called by the parser
    def prefix(self, s):
        pass

    def ident(self, s):
        self._taf['ident'] = {'str': s, 'index': self.index()}
        if not self.tokenOK():
            add_msg(self._taf['ident'], 'error', 19)

    def itime(self, s):
        self._group = {'type': 'FM'}
        d = self._taf['itime'] = {'str': s, 'index': self.index()}
        mday, hour, minute = int(s[:2]), int(s[2:4]), int(s[4:6])
        try:
            tms = list(time.gmtime())
            tms[2:6] = mday, hour, minute, 0
            fix_date(tms)
            d['value'] = time.mktime(tuple(tms)) - time.timezone
            if mday > 31 or hour > 23 or minute > 59:
                raise Error(_Errors[20])
            if not valid_day(tms):
                raise Error(_Errors[29])
        except Error as e:
            add_msg(d, 'error', e)
        if not self.tokenOK():
            add_msg(d, 'error', 19)

    def vtime(self, s):
        d = self._group['time'] = {'str': s, 'index': self.index()}

        tms = list(time.gmtime())
        tms[2:6] = int(s[0:2]),int(s[2:4]),0,0
        fix_date(tms)

        mday, shour, eday, ehour = int(s[:2]), int(s[2:4]), int(s[5:7]), int(s[7:9])

        try:
            tms[2:6] = mday, shour, 0, 0
            fix_date(tms)
            d['from'] = time.mktime(tuple(tms)) - time.timezone

            if len(s) == 6:
                period = ehour - shour
                if period <= 0:
                    period += 24
                d['to'] = d['from'] + 3600*period
            else:
                tms[2:6] = eday, ehour, 0, 0
                fix_date(tms)
                d['to'] = time.mktime(tuple(tms)) - time.timezone

            period = abs((d['to'] - d['from'])/3600)

            if period > 30.01:
                add_msg(d, 'error', 61)

            if mday > 31:
                raise Error(_Errors[23])
            if shour > 23:
                raise Error(_Errors[22])
            if not valid_day(tms):
                raise Error(_Errors[29])
            if not 0 < ehour <= 24:
                raise Error(_Errors[21])
=======
                add_msg(t, 'error', 119)
        except KeyError:
            pass

    def check_fm_group(self):
        """Check requirements for FM groups"""
        self._fm_cnt += 1

        if 'nsw' in self._group:
            add_msg(self._group['nsw'], 'error', 166)

        if self._fm_cnt > 6:
            if self._validperiod <= 24:
                add_msg(self._group['time'], 'warning', 10)
            elif self._fm_cnt > 8:
                add_msg(self._group['time'], 'warning', 11)

    def check_prob_group(self):
        """Check requirements for PROB groups"""
        if not any({x in self._group for x in {'pcp', 'tstm'}}):
            add_msg(self._group['time'], 'error', 243)
        if 'nsw' in self._group:
            add_msg(self._group['nsw'], 'error', 265)
        if 'llws' in self._group:
            add_msg(self._group['llws'], 'error', 280)
        if 'vcnty' in self._group:
            add_msg(self._group['vcnty'], 'error', 260)

    def check_tempo_group(self):
        """Check requirements for TEMPO groups"""
        #
        # self._group is the parsed TEMPO line
        if len(self._group) < 2:
            add_msg(self._group['time'], 'error', 2)
            return

        if 'llws' in self._group:
            add_msg(self._group['llws'], 'error', 280)
        if 'vcnty' in self._group:
            add_msg(self._group['vcnty'], 'error', 260)
        #
        # If an attempt to enter NSW in consecutive TEMPO group
        try:
            if 'nsw' in self._taf['group'][-2]['ocnl']:
                add_msg(self._group['nsw'], 'error', 168)
                return

        except (IndexError, KeyError):
            pass
        #
        # Is precip or obvis forecasted in TEMPO group?
        precip = any({x in self._group for x in {'obv', 'pcp', 'tstm'}})
        prevailing_vsby = self._taf['group'][-1]['prev']['vsby']['value']

        if 'nsw' in self._group:
            if precip:
                add_msg(self._group['nsw'], 'error', 165)
            else:
                #
                # With no precip, P6SM is required, either in the TEMPO group itself
                # or inherited from the prevailing forecast (FM group)
                try:
                    if self._group['vsby']['value'] < 7.0:
                        add_msg(self._group['vsby'], 'error', 167)
                except KeyError:
                    if prevailing_vsby < 7.0:
                        add_msg(self._group['nsw'], 'error', 167)

        elif not precip:
            #
            # If reduction in visibility is forecasted in TEMPO and there's
            # no mention of obv or wx in the TEMPO group
            try:
                if self._group['vsby']['value'] < prevailing_vsby:
                    add_msg(self._group['vsby'], 'error', 242)
            except KeyError:
                pass

    def check_vrb_wind(self, g):
        """Check compliance with variable wind direction"""
        wind = g.get('wind')
        dd, ff = wind.get('dd'), wind.get('ff')
        #
        #
        if dd == 'VRB' and ff > 6:
            # NWSI 10-813 B2.4.3
            #
            sky = g.get('sky')
            for lyr in sky['str'].split():
                if lyr.endswith('CB'):
                    break
            else:
                wx = g.get('pcp', {'str': 'None'})
                if 'SH' not in wx['str']:
                    raise Error(_Errors[125])

    def check_sq_wind(self, g):
        """Check compliance with squall criteria"""
        wind = g.get('wind')
        ff, gg = wind.get('ff'), wind.get('gg', None)

        obv = g.get('obv', {'str': ''})
        if 'SQ' in obv['str']:
            #
            # NWSI 10-813, Appendix E, E4
            if gg is None:
                raise Error(_Errors[148])

            elif gg < 22 or (gg - ff) < 16:
                raise Error(_Errors[127])

    def check_ww(self, g):
        # NWSI 10-813, B2.6
        if all({x not in g for x in {'pcp', 'obv', 'vcnty'}}):
            return
        #
        # Count standalone thunderstorm as w'w'
        ww_cnt = 1 if 'tstm' in g else 0
        if ww_cnt == 1 and 'TS' in g['pcp']['str']:
            raise Error(_Errors[141])
        #
        try:
            ww_cnt += len(g['pcp']['str'].split(' '))
        except KeyError:
            pass

        try:
            ww_cnt += len(g['obv']['str'].split(' '))
        except KeyError:
            pass

        try:
            ww_cnt += len(g['vcnty']['str'].split(' '))
        except KeyError:
            pass

        if ww_cnt > 3:
            raise Error(_Errors[142])

    def check_cb_tstm(self, g):
        # NWSI 10-813, B2.7.3
        if element_present(g, 'sky', 'CB') and not tstm_present(g):
            raise Error(_Errors[174])
        elif tstm_present(g) and not element_present(g, 'sky', 'CB'):
            raise Error(_Errors[144])

    def check_vsby_wx(self, g):
        # NWSI 10-813, Appendix E, E4 footnotes
        try:
            vsby = g['vsby']['value']
        except KeyError:
            return
        #
        # Determine if vis values are too _HI, _LO or _OK for the precip
        # intensity
        try:
            vis, code = check_ww_w_vsby(g['pcp'], vsby)
        except KeyError:
            vis, code = None, None

        if vsby > 6.0:
            if 'obv' in g:
                if any([obsc not in _UnltdVsbyWx for obsc in g['obv']['str'].split()]):
                    raise Error(_Errors[143])

            if 'pcp' in g:
                if code is not None:
                    if code > 100 and vis is not _OK:
                        raise Error(_Errors[code])
                    elif code < 100:
                        raise Warning1(_Warnings[code])
        else:
            #
            # Either pcp or obvis required if visibility is at or below 6SM
            if not any([x in g for x in ['pcp', 'obv']]):
                raise Error(_Errors[132])

            if 'obv' in g and (vis is None or vis is not _OK):
                for tok in g['obv']['str'].split():
                    obsc = tok[-2:]
                    if obsc == 'FG' and invalid_fg_vsby(tok, vsby):
                        raise Error(_Errors[152])

                    elif obsc == 'BR' and invalid_br_vsby(vsby):
                        raise Error(_Errors[153])

                    elif obsc in ('DS', 'SS'):
                        if tok[0] in '+-':
                            i = tok[0]
                        else:
                            i = ''

                        if invalid_ds_vsby(i, vsby):
                            raise Error(_Errors[154])
                #
                # At this point, obvis consistent with vsby value, but pcpn isn't.
                # Flag if visibility is too high for the precipitation intensity
                if code is not None and code > 100 and vis == _HI:
                    raise Error(_Errors[code])
            else:
                if code is not None and vis is not _OK:
                    if code > 100:
                        raise Error(_Errors[code])
                    else:
                        raise Warning1(_Warnings[code])

    def check_sky_pcp(self, g):
        """Sanity check between precipitation and sky condition"""

        if element_present(g, 'sky', 'SKC'):
            if element_present(g, 'vcnty', 'VCSH'):
                raise Error(_Errors[170])

            wws = []
            pcp = g.get('pcp', {'str': ''})
            for x in pcp['str'].split():
                wws.extend(get_pcp_list(x))

            if any({x not in {'DRSN', 'BLSN', 'IC'} for x in wws}):
                raise Error(_Errors[170])

    def prepend_tstm(self):
        """Prepend standalone thunderstorm to pcp group"""
        try:
            tstm = self._group['tstm']
            try:
                pcp = self._group['pcp']

                nos = int(pcp['index'][0].split('.')[1]) - int(tstm['index'][1].split('.')[1])
                pcp['str'] = 'TS {}{}'.format(' ' * nos, pcp['str'])
                pcp['index'] = tstm['index'][0], pcp['index'][1]
                try:
                    pcp.setdefault('error', []).append(tstm['error'])
                except KeyError:
                    del pcp['error']

            except KeyError:
                self._group['pcp'] = self._group['tstm'].copy()
                self._group['pcp']['str'] = 'TS'
                i = self._group['pcp']['index']
                self._group['pcp']['index'] = i[0], '.'.join([i[1].split('.')[0],
                                                              str(int(i[1].split('.')[1]) - 1)])
            del self._group['tstm']

        except KeyError:
            pass

    #######################################################################
    # Methods called by the parser
    def ident(self, s):
        """Just store the ID. No muss, no fuss"""
        self._taf['ident'] = {'str': s, 'index': self.index()}
        if not self.tokenOK():
            add_msg(self._taf['ident'], 'error', 0)

    def itime(self, s):
        """Store issuance time"""
        self._group = {'type': 'FM'}
        d = self._taf['itime'] = {'str': s, 'index': self.index()}
        sday, hour, minute = int(s[:2]), int(s[2:4]), int(s[4:6])
        try:
            tms = list(self._SystemClockTime.utctimetuple())
        except AttributeError:
            tms = list(time.gmtime())

        tms[2:6] = sday, hour, minute, 0
        fix_date(tms, self._SystemClockTime)
        d['value'] = calendar.timegm(tuple(tms))
        #
        # Flag nonsense
        if sday > 31 or hour > 23 or minute > 59:
            add_msg(d, 'error', _Errors[100])
        elif not valid_day(tms):
            add_msg(d, 'error', _Errors[105])

        if not self.tokenOK():
            add_msg(d, 'error', 0)

    def vtime(self, s):
        """Store time period of validity"""
        d = self._group['time'] = {'str': s, 'index': self.index()}

        try:
            tms = list(self._SystemClockTime.utctimetuple())
        except AttributeError:
            tms = list(time.gmtime())

        tms[2:6] = int(s[0:2]), int(s[2:4]), 0, 0
        fix_date(tms, self._SystemClockTime)

        sday, shour, eday, ehour = int(s[:2]), int(s[2:4]), int(s[5:7]), int(s[7:9])
        try:
            tms[2:6] = sday, shour, 0, 0
            fix_date(tms, self._SystemClockTime)

            if not valid_day(tms):
                add_msg(d, 'error', _Errors[105])

            d['from'] = calendar.timegm(tuple(tms))

            tms[2:6] = eday, ehour, 0, 0
            fix_date(tms, self._SystemClockTime)

            d['to'] = calendar.timegm(tuple(tms))

            period = abs((d['to'] - d['from'])) / 3600

            if period > 30.01:
                add_msg(d, 'error', 107)

            if not valid_day(tms):
                raise Error(_Errors[105])
            #
            # Catch nonsense
            if shour > 23:
                raise Error(_Errors[102])
            if not 0 < ehour <= 24:
                raise Error(_Errors[101])
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

        except Error as e:
            add_msg(d, 'error', e)

        self._taf['vtime'] = self._group['time'].copy()
        if not self.tokenOK():
<<<<<<< HEAD
            add_msg(d, 'error', 19)
=======
            add_msg(d, 'error', 0)
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        # to determine the earliest time of the first FM group
        if self._strict:
            # make start of valid time to be issue time and
            # determine the earliest time of the first FM group
            if self._taf['bbb'][0] == 'C':
                if shour in [0, 6, 12, 18]:
                    d['from'] = self._taf['itime']['value']
                else:
<<<<<<< HEAD
                    self._cutoff = d['from'] = self._taf['vtime']['from']-1800
=======
                    self._cutoff = d['from'] = self._taf['vtime']['from'] - 1800
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            else:
                self._cutoff = d['from'] = self._taf['itime']['value']

            if shour in [0, 6, 12, 18] and self._cutoff < self._taf['vtime']['from']:
                self._cutoff = self._taf['vtime']['from']
        else:
            # it should not matter, for monitoring
            d['from'] = min(self._taf['vtime']['from'],
                            self._taf['itime']['value'])

<<<<<<< HEAD
    def ftime(self, s):
        d = self._group['time'] = {'str': s, 'index': self.index()}

        mday, hour, minute = int(s[2:4]), int(s[4:6]), int(s[6:8])
        if not (0 <= hour <= 23 and 0 <= minute <= 59):
            add_msg(d, 'error', 22)
        try:
            tms = list(time.gmtime(self._taf['vtime']['from']))
            tms[2:5] = mday, hour, minute

            t = time.mktime(tuple(tms)) - time.timezone
            if t <= self._taf['vtime']['from']-1800:
                fix_date(tms)
                t = time.mktime(tuple(tms)) - time.timezone

            if not (self._taf['vtime']['from']-1800 <= t < self._taf['vtime']['to']):
                add_msg(d, 'error', 25)

            if 'error' not in d and mday != time.gmtime(t)[2]:
                add_msg(d, 'error', 29)

=======
        self._validperiod = (d['to'] - d['from']) / 3600

    def ftime(self, s):
        """Store start time of a new FM group"""
        d = self._group['time'] = {'str': s, 'index': self.index()}

        sday, hour, minute = int(s[2:4]), int(s[4:6]), int(s[6:8])
        #
        # Catch forecaster typos
        if not (0 <= hour <= 23 and 0 <= minute <= 59):
            add_msg(d, 'error', 102)

        try:
            tms = list(time.gmtime(self._taf['vtime']['from']))
            #
            # Starting from valid time's tms, put in the FM timestamp
            tms[2:5] = sday, hour, minute

            t = calendar.timegm(tuple(tms))
            #
            # If FM group is more than 30 minutes before the start of the TAF validity
            if t <= self._taf['vtime']['from'] - 1800:
                fix_date(tms)
                t = calendar.timegm(tuple(tms))
            #
            # FM group must start within the period of validity
            if not (self._taf['vtime']['from'] - 1800 <= t < self._taf['vtime']['to']):
                add_msg(d, 'error', 106)
            #
            # calendar.timegm is tolerant about tms members not rolled over properly.
            # Here we re-compute datetime structure for comparison to check for forecaster
            # typos, like April 31.
            #
            if 'error' not in d:
                dt = datetime.datetime.utcfromtimestamp(t)
                if sday != dt.day:
                    add_msg(d, 'error', 105)
            #
            # Initially all FM groups valid periods go to the end of the TAF period
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            d.update({'from': t, 'to': self._taf['vtime']['to']})

        except KeyError:
            pass

        if not self.tokenOK():
<<<<<<< HEAD
            add_msg(d, 'error', 19)

    def ttime(self, s):
        d = self._group['time'] = {'str': s, 'index': self.index()}
        try:
            tmp = s.split()[1]
            sday, shour, eday, ehour = int(tmp[:2]), int(tmp[2:4]),\
                                       int(tmp[5:7]),int(tmp[7:9])

            tms = list(time.gmtime(self._taf['vtime']['from']))
            tms[2:4] = sday,shour
            t = time.mktime(tuple(tms)) - time.timezone
            if t < self._taf['vtime']['from']:
                fix_date(tms)

            t = time.mktime(tuple(tms)) - time.timezone
            if t < self._taf['vtime']['from']:
                add_msg(d, 'error', 25)

            tms[2:4] = eday, ehour
            if eday < sday:
                tms[1] += 1

            d.update({'from': t, 'to': time.mktime(tuple(tms)) - time.timezone})

            if not 0 <= shour < 24:
                add_msg(d, 'error', 22)
            if not 0 < ehour <= 24:
                add_msg(d, 'error', 21)

            if t >= self._taf['vtime']['to']:
                add_msg(d, 'error', 25)

            if d['to'] > self._taf['vtime']['to']:
                add_msg(d, 'error', 25)

            if d['to'] - d['from'] > 14400.0:
                add_msg(d, 'error', 56)

            if d['to'] <= d['from']:
                add_msg(d, 'error', 51)

            if 'error' not in d:
                if sday != time.gmtime(t)[2]:
                    add_msg(d, 'error', 29)
                else:
                    if ehour != 24 and eday != time.gmtime(d['to'])[2]:
                        add_msg(d, 'error', 29)

        except Error as e:
            add_msg(d, 'error', e)

        if not self.tokenOK():
            add_msg(d, 'error', 19)

    def ptime(self, s):
        d = self._group['time'] = {'str': s, 'index': self.index()}
        try:
            if not s.startswith('PROB30'):
                raise Error(_Errors[26])

            tmp = s.split()[1]
            sday = int(tmp[:2])
            shour = int(tmp[2:4])
            eday = int(tmp[5:7])
            ehour = int(tmp[7:9])

            tms = list(time.gmtime(self._taf['vtime']['from']))
            tms[2:4] = sday, shour
            t = time.mktime(tuple(tms)) - time.timezone
            if t < self._taf['vtime']['from']:
                fix_date(tms)

            t = time.mktime(tuple(tms)) - time.timezone
            if t <= self._taf['vtime']['from']:
                add_msg(d, 'error', 25)

            tms[2:4] = eday,ehour
            if eday < sday:
                tms[1] += 1

            d.update({'from': t, 'to': time.mktime(tuple(tms)) - time.timezone})

            if not 0 <= shour < 24:
                add_msg(d, 'error', 22)
            if not 0 < ehour <= 24:
                add_msg(d, 'error', 21)

            if t >= self._taf['vtime']['to']:
                add_msg(d, 'error', 25)

            if d['to'] > self._taf['vtime']['to']:
                add_msg(d, 'error', 25)

            if d['from'] < 9*3600.0+self._taf['vtime']['from']:
                add_msg(d, 'error', 27)

            if d['to'] - d['from'] > 21600.0:
                add_msg(d, 'warning', 13)

            if d['to'] <= d['from']:
                add_msg(d, 'error', 51)

            if 'error' not in d:
                if sday != time.gmtime(t)[2]:
                    add_msg(d, 'error', 29)
                else:
                    if ehour != 24 and eday != time.gmtime(d['to'])[2]:
                        add_msg(d, 'error', 29)

        except Warning1 as e:
            add_msg(d, 'warning', e)
        except Error as e:
            add_msg(d, 'error', e)
        if not self.tokenOK():
            add_msg(d, 'error', 19)

    def vsby(self, s):
        d = self._group['vsby'] = {'str': s, 'index': self.index()}
        tok = ' '.join(s[:-2].split())
        v = _ValidVsby.get(tok, None)
        if v is None:
            add_msg(d, 'error', 37)
        else:
            d['value'] = v
        if not self.tokenOK():
            add_msg(d, 'error', 19)

    def wind(self, s):
=======
            add_msg(d, 'error', 0)

    def ttime(self, s):
        """Store start time of a new TEMPO group"""
        d = self._group['time'] = {'str': s, 'index': self.index()}
        tmp = s.split()[1]
        sday, shour, eday, ehour = int(tmp[:2]), int(tmp[2:4]),\
            int(tmp[5:7]), int(tmp[7:9])
        #
        # Catch forecaster typos
        if not 0 <= shour < 24:
            add_msg(d, 'error', 102)
        if not 0 < ehour <= 24:
            add_msg(d, 'error', 101)
        #
        # Get start of the TAF, then plug in beginning day/hour of TEMPO group
        tms = list(time.gmtime(self._taf['vtime']['from']))
        tms[2:4] = sday, shour
        t = calendar.timegm(tuple(tms))
        if t < self._taf['vtime']['from']:
            fix_date(tms)

        t = calendar.timegm(tuple(tms))
        #
        # TEMPO group cannot start before TAF valid time
        if t < self._taf['vtime']['from']:
            add_msg(d, 'error', 106)

        tms[2:4] = eday, ehour
        #
        # Ending time has rolled over to next month.
        if eday < sday:
            tms[1] += 1

        d.update({'from': t, 'to': calendar.timegm(tuple(tms))})
        #
        # TEMPO group cannot start after the TAF ends
        if d['from'] >= self._taf['vtime']['to']:
            add_msg(d, 'error', 106)
        #
        # Ending time of TEMPO group cannot go beyond TAF valid time
        if d['to'] > self._taf['vtime']['to']:
            add_msg(d, 'error', 106)
        #
        # TEMPO groups cannot exceed 4 hours in length
        if d['to'] - d['from'] > 14400.0:
            add_msg(d, 'error', 111)
        #
        # Catch forecaster typo
        if d['to'] <= d['from']:
            add_msg(d, 'error', 109)
        #
        # Double checking to make sure integer times match the days
        # given in the TEMPO group
        if 'error' not in d:
            if ehour != 24 and invalid_taf_timestamp(d, sday, eday):
                add_msg(d, 'error', 105)

        if not self.tokenOK():
            add_msg(d, 'error', 0)

    def ptime(self, s):
        """Store time period of probability group"""
        d = self._group['time'] = {'str': s, 'index': self.index()}

        if not s.startswith('PROB30'):
            add_msg(d, 'error', 200)

        tmp = s.split()[1]
        sday, shour, eday, ehour = int(tmp[:2]), int(tmp[2:4]),\
            int(tmp[5:7]), int(tmp[7:9])
        #
        # Catch forecaster typos
        if not 0 <= shour < 24:
            add_msg(d, 'error', 102)
        if not 0 < ehour <= 24:
            add_msg(d, 'error', 101)
        #
        # Get start of the TAF, then plug in beginning day/hour of PROB group
        tms = list(time.gmtime(self._taf['vtime']['from']))
        tms[2:4] = sday, shour
        t = calendar.timegm(tuple(tms))
        if t < self._taf['vtime']['from']:
            fix_date(tms)

        tfrom = calendar.timegm(tuple(tms))
        tms[2:4] = eday, ehour
        #
        # Ending time has rolled over to next month.
        if eday < sday:
            tms[1] += 1

        d.update({'from': tfrom, 'to': calendar.timegm(tuple(tms))})
        #
        # If PROB group starts after TAF ends
        if d['from'] >= self._taf['vtime']['to']:
            add_msg(d, 'error', 106)
        #
        # If PROB group ends after TAF ends
        if d['to'] > self._taf['vtime']['to']:
            add_msg(d, 'error', 106)
        #
        # PROB group cannot appear in the first 9 hours of TAF
        #if d['from'] < 9 * 3600.0 + self._taf['vtime']['from']:
        #    add_msg(d, 'error', 201)
        #
        # PROB group cannot exceed 6 hours in length
        if d['to'] - d['from'] > 21600.0:
            add_msg(d, 'error', 113)
        #
        # Catch forecaster typo
        if d['to'] <= d['from']:
            add_msg(d, 'error', 109)
        #
        # Double checking to make sure integer times match the days
        # given in the PROB group
        if 'error' not in d:
            if ehour != 24 and invalid_taf_timestamp(d, sday, eday):
                add_msg(d, 'error', 105)

        if not self.tokenOK():
            add_msg(d, 'error', 0)

    def vsby(self, s):
        """Store visibility"""
        d = self._group['vsby'] = {'str': s, 'index': self.index()}

        result = self.lexer.tokens[self.lexer.cur_token.name][0].match(s)
        if result.group('w') is not None:
            tok = '{} {}'.format(result.group('w').strip(), result.group('f'))
            if result.group('w')[-1] != ' ':
                add_msg(d, 'error', 1)
        else:
            tok = result.group(1)

        d['value'] = _ValidVsby.get(tok, None)

        if d['value'] is None:
            try:
                d['value'] = float(result.group(5))

            except TypeError:
                try:
                    v = float(result.group('w'))
                    fraction = tok.replace(result.group('w'), '', 1)
                except TypeError:
                    v = 0
                    fraction = result.group('f')

                numerator, denominator = fraction.split('/')
                d['value'] = v + float(numerator) / float(denominator)

            if d['value'] > 6.1:
                d['value'] = _ValidVsby.get('P6')
                add_msg(d, 'error', 131)
            else:
                add_msg(d, 'error', 130)

        if not self.tokenOK():
            add_msg(d, 'error', 0)

    def wind(self, s):
        """Store wind group"""
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        d = self._group['wind'] = {'str': s, 'index': self.index()}
        try:
            if s.startswith('VRB'):
                dd = d['dd'] = 'VRB'
            else:
                dd = d['dd'] = int(s[:3])
<<<<<<< HEAD
            tok = s[3:-2].split('G', 1)
            ff = d['ff'] = int(tok[0])
            if len(tok[0]) > 2 and tok[0][0] != '1':
                raise Error(_Errors[31])
            if len(tok) > 1:
                gg = d['gg'] = int(tok[1])
                if gg <= ff:
                    raise Error(_Errors[32])
            else:
                gg = None
            if dd == 'VRB':
                if ff == 0:
                    raise Error(_Errors[30])
            else:
                if (dd % 10 != 0 or dd > 360 or ff == 0 and dd != 0 or
                    ff > 0 and dd == 0):
                    raise Error(_Errors[30])
            if ff > 99:
                raise Warning1(_Warnings[15])
            if gg and gg - ff > 30:
                raise Warning1(_Warnings[16])
        except Warning1 as e:
            add_msg(d, 'warning', e)
        except Error as e:
            add_msg(d, 'error', e)
        if not self.tokenOK():
            add_msg(d, 'error', 19)

    def obv(self, s):
        d = self._group['obv'] = {'str': s, 'index': self.index()}
        try:
            tmp = s.split()
            for tok in tmp:
                if tok not in _ValidObvis:
                    raise Error(_Errors[38])
            if len(tmp) != len(dict.fromkeys(tmp)):
                raise Error(_Errors[57])
            if 'FC' in s:
                raise Warning1(_Warnings[14])
        except Warning1 as e:
            add_msg(d, 'warning', e)
        except Error as e:
            add_msg(d, 'error', e)
        if not self.tokenOK():
            add_msg(d, 'error', 19)

    def pcp(self, s):
        d = self._group['pcp'] = {'str': s, 'index': self.index()}
        prev, other = get_prev_pcp(s)
        if prev is None:    # TS
            return
        try:
            if prev not in _ValidPcp:
                raise Error(_Errors[38])
            tmp = [other[i:i+2] for i in range(0, len(other), 2)]
            for tok in tmp:
                if tok not in _ValidPcp:
                    raise Error(_Errors[38])
            tmp.append(prev[-2:])  # also has to check prevailing precipitation
            if len(tmp) != len(dict.fromkeys(tmp)):
                raise Error(_Errors[57])
        except Warning1 as e:
            add_msg(d, 'warning', e)
        except Error as e:
            add_msg(d, 'error', e)
        if not self.tokenOK():
            add_msg(d, 'error', 19)

    def nsw(self, s):
        d = self._group['nsw'] = {'str': s, 'index': self.index()}
        if not self.tokenOK():
            add_msg(d, 'error', 19)

    def vcnty(self, s):
        d = self._group['vcnty'] = {'str': s, 'index': self.index()}
        if not s[2:] in _ValidVcnty:
            add_msg(d, 'error', 43)
        if not self.tokenOK():
            add_msg(d, 'error', 19)

    def sky(self, s):
        d = self._group['sky'] = {'str': s, 'index': self.index()}
        cover, base, cig = 0, -1, Avn.UNLIMITED
        try:
            clds = s.split()
            for tok in clds:
                cover, base, cig = check_sky(tok, cover, base, cig)
            if cig == Avn.CLEAR:
                add_msg(d, 'error', 44)
            elif cig < Avn.CLEAR:
                cig *= 100
            if len(clds) > 3:
                raise Warning1(_Warnings[12])
        except Warning1 as e:
            add_msg(d, 'warning', e)
        except Error as e:
            add_msg(d, 'error', e)
        if not self.tokenOK():
            add_msg(d, 'error', 19)
        d.update({'cover': cover, 'cig': cig})

    def llws(self, s):
=======

            tok = s[3:-2].split('G', 1)
            ff = d['ff'] = int(tok[0])

            if ff > 199:
                raise Error(_Errors[121])

            if len(tok) > 1:
                gg = d['gg'] = int(tok[1])
                if gg <= ff:
                    raise Error(_Errors[122])
            else:
                gg = None

            if dd == 'VRB':
                if ff == 0:
                    raise Error(_Errors[120])
            else:
                if (dd % 10 != 0 or dd > 360 or ff == 0 and dd != 0 or
                        ff > 0 and dd == 0):
                    raise Error(_Errors[120])

            if ff > 99:
                raise Warning1(_Warnings[20])

            if gg is not None and (gg - ff) > 30:
                raise Warning1(_Warnings[21])

        except Warning1 as e:
            add_msg(d, 'warning', e)

        except Error as e:
            add_msg(d, 'error', e)

        if not self.tokenOK():
            add_msg(d, 'error', 0)

    def obv(self, s):
        """Store obstruction to vision group"""
        d = self._group['obv'] = {'str': s, 'index': self.index()}
        try:
            tmp = s.split()
            for cnt, tok in enumerate(tmp):
                if tok not in _ValidObvis:
                    raise Error(_Errors[140])

                if any({tok == x for x in {'+FC', 'FC'}}):
                    add_msg(d, 'warning', _Warnings[40])

            seen = set()
            if [x for x in tmp if x in seen or seen.add(x)] != []:
                raise Error(_Errors[141])
            if cnt > 2:
                raise Error(_Errors[142])

        except Error as e:
            add_msg(d, 'error', e)

        if not self.tokenOK():
            add_msg(d, 'error', 0)

    def pcp(self, s):
        """Evaluate and store precipitation string"""
        d = self._group['pcp'] = {'str': s, 'index': self.index()}
        all_pcp = []

        try:
            ww_groups = s.split(' ')
            if len(ww_groups) > 3:
                raise Error(_Errors[142])

            for ww_group in ww_groups:

                ww_list = get_pcp_list(ww_group)
                all_pcp.extend(ww_list)

                if len(ww_list) > 3:
                    raise Error(_Errors[240])

                if not all([ww in _ValidPcp for ww in ww_list]):
                    if 'UP' in d['str']:
                        raise Error(_Errors[241])
                    raise Error(_Errors[140])

        except Error as e:
            add_msg(d, 'error', e)

        seen = set()
        if [ww for ww in all_pcp if ww in seen or seen.add(ww)] != []:
            add_msg(d, 'error', _Errors[141])

        if not self.tokenOK():
            add_msg(d, 'error', 0)

    def vcnty(self, s):

        d = self._group['vcnty'] = {'str': s, 'index': self.index()}
        #
        # Only FG, SH and TS are allowed with VC prefix
        if not s[2:] in _ValidVcnty:
            add_msg(d, 'error', 160)

    def sky(self, s):
        """Store and process the cloud group"""
        d = self._group['sky'] = {'str': s, 'index': self.index()}
        cover, base, cig = 0, -1, Avn.UNLIMITED

        try:
            clds = s.split()
            amts = [x[:-3] for x in clds]

            for cnt, tok in enumerate(clds):
                cover, base, cig = check_sky(tok, cover, base, cig)
                if cnt == 0:
                    first = amts.pop(0)
                    if first == 'VV' and len(amts) > 0:
                        raise Error(_Errors[172])
                    elif any([x == 'VV' for x in amts]):
                        raise Error(_Errors[172])

            if cig == Avn.CLEAR:
                add_msg(d, 'error', 270)
            elif cig < Avn.CLEAR:
                cig *= 100

            if len(clds) > 3:
                add_msg(d, 'warning', _Warnings[70])

        except Error as e:
            add_msg(d, 'error', e)

        if not self.tokenOK():
            add_msg(d, 'error', 0)

        d.update({'cover': cover, 'cig': cig})

    def llws(self, s):
        """Extract and store low-level wind shear data"""
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        d = self._group['llws'] = {'str': s, 'index': self.index()}
        try:
            h = int(s[2:5])
            dd = int(s[6:9])
            ff = int(s[9:-2])
            d.update({'hgt': h, 'dd': dd, 'ff': ff})
<<<<<<< HEAD
            if ff > 99:
                raise Warning1(_Warnings[17])
            elif len(s) >= 14:
                raise Error(_Errors[39])
            if not 0 < h <= 20:
                raise Error(_Errors[36])
            if dd % 10 != 0 or dd > 360 or ff == 0 and dd != 0:
                raise Error(_Errors[35])
        except Warning1 as e:
            add_msg(d, 'warning', e)
        except Error as e:
            add_msg(d, 'error', e)
        if not self.tokenOK():
            add_msg(d, 'error', 19)

    def amd(self, s):
        # s does not contain the whole phrase
        phrase = (s+self.lexer.input[self.lexer.pos:]).rstrip()
        m = _AmdPat.match(phrase)

        if m:
            s = m.group()
            ix0 = self.index()[0]
            row, col = ix0.split('.')
            col = int(col)+len(s)
=======

            if ff > 99:
                raise Warning1(_Warnings[80])

            elif len(s) >= 14:
                raise Error(_Errors[123])

            if not 0 < h <= 20:
                raise Error(_Errors[181])

            if dd % 10 != 0 or dd > 360 or ff == 0 and dd != 0:
                raise Error(_Errors[180])

        except Warning1 as e:
            add_msg(d, 'warning', e)

        except Error as e:
            add_msg(d, 'error', e)

        if not self.tokenOK():
            add_msg(d, 'error', 0)

    def amd(self, s):
        # s does not contain the whole phrase
        phrase = '{}{}'.format(s, self.lexer.input[self.lexer.pos:-1])
        m = _AmdPat.match(phrase)

        if m and m.end() == len(phrase):
            s = m.group()
            ix0 = self.index()[0]
            row, col = ix0.split('.')
            col = int(col) + len(s)
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            ix = (ix0, '%s.%d' % (row, col))
            self._taf['amd'] = {'str': s, 'index': ix}

            # If reference to time is found in the clause one of these
            # groups will have it.
            strng = m.group(4) or m.group(5) or m.group(11) or m.group(12)
            if strng:
                tms = list(time.gmtime(self._taf['vtime']['from']))
                mins = 0
                if len(strng) == 6:
                    mins = int(strng[-2:])

                for ddmm in strng.split('/'):
<<<<<<< HEAD
                    tms[2:6] = int(ddmm[0:2]),int(ddmm[2:4]),mins,0
                    fix_date(tms)
                    if not (self._taf['vtime']['from'] <= (time.mktime(tuple(tms)) - time.timezone) <= self._taf['vtime']['to']):
                        self._taf['amd'] = {'str': s, 'index': self.index()}
                        add_msg(self._taf['amd'], 'warning', 19)
                        break
        else:
            self._taf['amd'] = {'str': s, 'index': self.index()}
            add_msg(self._taf['amd'], 'error', 59)

    def __updateIssueValidTimes(self, bbb, fcst):
        TafIdent = re.compile(r'(?P<ident>[KTPN]\w{3})\s+\d{6}Z\s+\d{4}/(?P<evtime>\d{4})\s+')
        # Updates issuance and valid times in a forecast
        t=time.time()
=======
                    tms[2:6] = int(ddmm[0:2]), int(ddmm[2:4]), mins, 0
                    fix_date(tms)
                    intTime = calendar.timegm(tuple(tms))

                    if m.group(3) == 'AFT':
                        intTime += 1

                    if not (self._taf['vtime']['from'] <= intTime <= self._taf['vtime']['to']):
                        self._taf['amd'] = {'str': s, 'index': self.index()}
                        add_msg(self._taf['amd'], 'error', 191)
                        break
        else:
            self._taf['amd'] = {'str': s, 'index': self.index()}
            add_msg(self._taf['amd'], 'error', 190)

    def _updateIssueValidTimes(self, bbb, fcst):

        TafIdent = re.compile(r'(?P<ident>[KTPN]\w{3})\s+\d{6}Z\s+\d{4}/(?P<evtime>\d{4})\s+')
        # Updates issuance and valid times in a forecast
        t = time.time()
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        itime = AvnLib.getFmtIssueTime(bbb, t)

        if bbb and bbb[0] == 'C':
            # corrected forecast has the same timestamp
<<<<<<< HEAD
            return re.sub(' (DD|\d{2})\d{4}Z ', ' %s ' % itime, fcst, 1)
=======
            return re.sub(r' (DD|\d{2})\d{4}Z ', ' %s ' % itime, fcst, 1)
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        else:
            result = TafIdent.search(fcst)
            if result:
                ident = result.group('ident')
<<<<<<< HEAD
                tafDuration=int(AvnParser.getTafSiteCfg(ident)['thresholds']['tafduration'])
=======
                tafDuration = int(AvnParser.getTafSiteCfg(ident)['thresholds']['tafduration'])
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            else:
                tafDuration = 24

            if result:
<<<<<<< HEAD
                vtime = AvnLib.getFmtValidTime(bbb,None,tafDuration=tafDuration,
                                               evtime=result.group('evtime'))[4:]
            else:
                vtime = AvnLib.getFmtValidTime(bbb,None,tafDuration)[4:]

            return re.sub(' (DD|\d{2})\d{4}Z [/D\d]{6,9} ',
                          ' %s %s ' % (itime, vtime), fcst, 1)

    def splitBulletin(self, text):
=======
                vtime = AvnLib.getFmtValidTime(bbb, None, tafDuration=tafDuration,
                                               evtime=result.group('evtime'))[4:]
            else:
                vtime = AvnLib.getFmtValidTime(bbb, None, tafDuration)[4:]

            return re.sub(r' (DD|\d{2})\d{4}Z [/D\d]{6,9} ',
                          ' %s %s ' % (itime, vtime), fcst, 1)

    def splitBulletin(self, text):

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        SplitReg = re.compile(r'=+[\s\n]*|\n{2,}|\n$')
        # Splits bulletin into forecasts. Assumes that a forcast is
        # terminated with '=' or forecasts are separated by a blank
        # line
<<<<<<< HEAD
        forecasts = [x.strip() for x in \
            SplitReg.split(text)]
=======
        forecasts = [x.strip() for x in
                     SplitReg.split(text)]
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        return ['%s=\n' % x for x in forecasts if x]

##############################################################################
# java interface part ... added to support calling python from java
# Like the TafEditDialog this formats then parses the TAF.
    def parseFromJava(self, text, bbb):

        import JUtil
        fcsts = self.splitBulletin(text)

        tmpText = []
<<<<<<< HEAD
        for fcst in map(Avn.curry(_format, bbb), fcsts) :
            tmpText.extend(fcst+[''])
=======
        for fcst in map(Avn.curry(_format, bbb), fcsts):
            tmpText.extend(fcst + [''])
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

        text = '\n'.join(tmpText)

        result = self(text, bbb)
<<<<<<< HEAD
        text = '\n'.join([self.__updateIssueValidTimes(bbb, f)
=======
        text = '\n'.join([self._updateIssueValidTimes(bbb, f)
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                          for f in self.splitBulletin(text)])
        headerTime = AvnLib.getFmtHeaderTime(bbb)

        return JUtil.pyDictToJavaMap({'result': result, 'text': text, 'headerTime': headerTime})

##############################################################################
# java interface part ... added to support calling python from java
# updated java interface method to work with TAF editor QC
    def updateTime(self, text, bbb):
<<<<<<< HEAD
        import JUtil
        text = '\n'.join([self.__updateIssueValidTimes(bbb, f)
=======

        import JUtil
        text = '\n'.join([self._updateIssueValidTimes(bbb, f)
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                          for f in self.splitBulletin(text)])
        headerTime = AvnLib.getFmtHeaderTime(bbb)

        return JUtil.pyDictToJavaMap({'text': text, 'headerTime': headerTime})

<<<<<<< HEAD
##############################################################################
# public part
def errors(decoded):
    """Returns list of elements that have 'error' or 'warning' key"""
    d = {'error': [], 'warning': []}
    def walk(item, k=None):
        if type(item) is list:
            for i in item:
                walk(i)
        elif type(item) is dict:
            if 'error' in item:
                d['error'].append((k, item))
            elif 'warning' in item:
                d['warning'].append((k, item))
            else:
                for k, v in item.items():
                    walk(v, k)
    if 'fatal' in decoded:
        return d
    walk(decoded)
    return d
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

###############################################################################
# These methods were grabbed from TafEditDialog, OB9.2.X_source
# Revision 1.76. Placed here so all the TafEditDialg GUI is not imported.
###############################################################################
<<<<<<< HEAD
import itertools
def _preamble(kind, bbb):
    if bbb[:2] == 'AA':
        return kind + ' AMD'
    elif bbb[:2] == 'CC':
        return kind + ' COR'
    else:
        return kind

=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
_format_pat = re.compile('|'.join([r'(FM\d+)', r'(TEMPO)', r'(AMD\s+[LN])',
                                   r'(NIL\s+AMD)', r'(TAF\s+AMD)', r'(TAF\s+COR)',
                                   r'(TAF)']))

<<<<<<< HEAD
def _format(bbb, fcst):
=======

def _format(bbb, fcst):

    def _preamble(kind, bbb):
        if bbb[:2] == 'AA':
            return kind + ' AMD'
        elif bbb[:2] == 'CC':
            return kind + ' COR'
        else:
            return kind
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    # split each forecast into groups
    tmplist = [_f for _f in _format_pat.split(' '.join(fcst.split())) if _f]
    # fix first line
    kind = tmplist[0][:3]
    if kind == 'TAF':
        preamble = _preamble(kind, bbb)
        tmplist[0] = preamble
<<<<<<< HEAD
    elif re.match('\s*[A-Z]{4}\s', tmplist[0]):    # missing TAF
=======
    elif re.match(r'\s*[A-Z]{4}\s', tmplist[0]):    # missing TAF
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        preamble = _preamble('TAF', bbb)
        tmplist.insert(0, preamble)
    else:   # unknown string, leave alone
        return tmplist
    newlist = tmplist[:2] + [''.join(x) for x in
<<<<<<< HEAD
        zip(itertools.islice(tmplist, 2, None, 2),
        itertools.islice(tmplist, 3, None, 2))]
    return AvnLib.indentTaf(newlist)

####################################################################################################################
# End of TafEditDialog code
####################################################################################################################
# test
def main(report):
    _startTaf = re.compile(r'[A-Z][A-Z0-9]{3}\s+\d{6}Z|TAF(\s+(AMD|COR))?')
    def splitTaf(report):
        # Splits report into header and TAF
        if type(report) is str:
            report = report.rstrip().split('\n')
        # skip header
        for n, line in enumerate(report):
            if _startTaf.match(line):
                return report[:n], '\n'.join(report[n:])+'\n'
        raise Avn.AvnError('Cannot find start of forecast')
    header, taf = splitTaf(report)
    tmp = header[0].split()
    try:
        bbb = tmp[3]
    except IndexError:
        bbb = '   '
    decoder = Decoder()
    decoded = decoder(''.join(taf), bbb, strict=True)
    if 'fatal' in decoded:
        print('Fatal error at ' + str(decoded['index']) + ' ' + str(decoded['fatal']))
        return
    for key in decoded:
        if key == 'group':
            for g in decoded['group']:
                print()
                for key2 in g:
                    print(str(time.ctime(g[key2]['time']['from'])) + ' ' +
                        str(time.ctime(g[key2]['time']['to'])))
                    print('\t' + ' ' + str(key2) + ' ' + str(g[key2]))
        elif key == 'bbb':
            print('%s \'%s\'' % (str(key), str(decoded[key])))
        else:
            print(str(key) + ' ' + str(decoded[key]))

    errlist = errors(decoded)
    print('====== Errors =======')
    for k, d in errlist['error']:
        print(str(k) + ' ' + str(d['index']) + ' ' + str(d['error']))
    print('====== Warnings =====')
    for k, d in errlist['warning']:
        print(str(k) + ' ' + str(d['index']) + ' ' + str(d['warning']))


###############################################################################
# commented-out the standalone program part to support calling python from java
#if __name__ == '__main__':
#    import sys
#    main(sys.stdin.read())
=======
                             zip(itertools.islice(tmplist, 2, None, 2),
                                 itertools.islice(tmplist, 3, None, 2))]
    return AvnLib.indentTaf(newlist)
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
