/**
 * This software was developed and / or modified by Raytheon Company,
 * pursuant to Contract DG133W-05-CQ-1067 with the US Government.
<<<<<<< HEAD
 * 
=======
 *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 * U.S. EXPORT CONTROLLED TECHNICAL DATA
 * This software product contains export-restricted data whose
 * export/transfer/disclosure is restricted by U.S. law. Dissemination
 * to non-U.S. persons whether in the United States or abroad requires
 * an export license or other authorization.
<<<<<<< HEAD
 * 
=======
 *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 * Contractor Name:        Raytheon Company
 * Contractor Address:     6825 Pine Street, Suite 340
 *                         Mail Stop B8
 *                         Omaha, NE 68106
 *                         402.291.0100
<<<<<<< HEAD
 * 
=======
 *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 * See the AWIPS II Master Rights File ("Master Rights File.pdf") for
 * further licensing information.
 **/
package com.raytheon.uf.edex.ndm.dataplugin.subscriber;

import java.io.File;
<<<<<<< HEAD
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
=======
import java.io.IOException;
import java.nio.file.Files;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.raytheon.uf.common.dataplugin.radar.util.RadarsInUseUtil;
import com.raytheon.uf.common.dataplugin.radar.util.SsssRadarUtil;
import com.raytheon.uf.common.dataplugin.radar.util.TerminalRadarUtils;
import com.raytheon.uf.common.localization.IPathManager;
import com.raytheon.uf.common.localization.LocalizationContext;
import com.raytheon.uf.common.localization.LocalizationContext.LocalizationLevel;
import com.raytheon.uf.common.localization.LocalizationContext.LocalizationType;
import com.raytheon.uf.common.localization.LocalizationFile;
import com.raytheon.uf.common.localization.PathManagerFactory;
<<<<<<< HEAD
=======
import com.raytheon.uf.common.localization.SaveableOutputStream;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import com.raytheon.uf.common.localization.exception.LocalizationException;
import com.raytheon.uf.common.menus.xml.CommonAbstractMenuContribution;
import com.raytheon.uf.common.menus.xml.CommonIncludeMenuContribution;
import com.raytheon.uf.common.menus.xml.CommonIncludeMenuItem;
import com.raytheon.uf.common.menus.xml.CommonMenuContributionFile;
import com.raytheon.uf.common.menus.xml.CommonSeparatorMenuContribution;
import com.raytheon.uf.common.menus.xml.CommonSubmenuContribution;
import com.raytheon.uf.common.menus.xml.MenuTemplateFile;
import com.raytheon.uf.common.menus.xml.VariableSubstitution;
import com.raytheon.uf.common.status.IUFStatusHandler;
import com.raytheon.uf.common.status.UFStatus;
import com.raytheon.uf.common.status.UFStatus.Priority;
<<<<<<< HEAD
import com.raytheon.uf.common.util.FileUtil;
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import com.raytheon.uf.edex.menus.AbstractMenuUtil;
import com.raytheon.uf.edex.ndm.ingest.INationalDatasetSubscriber;

/**
 * Builds menus using JAXB
<<<<<<< HEAD
 * 
 * <pre>
 * 
 * SOFTWARE HISTORY
 * Date         Ticket#    Engineer    Description
 * ------------ ---------- ----------- --------------------------
 * Jun 30, 2010            mnash       Initial creation
 * Feb 25, 2013 DR14418    zwang       Change radar menu to dual pol style
 * 03/07/2013   DR15495    zwang       Handle additional elevation for ssss radars
 * Mar 06, 2014   2876      mpduff     New NDM plugin.
 * Sep 08, 2015 ASM #17944 D. Friedman Handle other elevation list files.
 * Mar 02, 2016   5434     bkowal      Relocated to ndm dataplugin.
 * 
 * </pre>
 * 
 * @author mnash
 * @version 1.0
 */

public class RadarMenuUtil extends AbstractMenuUtil implements
        INationalDatasetSubscriber {
    private static final IUFStatusHandler statusHandler = UFStatus
            .getHandler(RadarMenuUtil.class);

    private final int NUM_POSSIBLE_RADARS = 25;

    /**
     * 
=======
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 *
 * Date          Ticket#  Engineer     Description
 * ------------- -------- ------------ -----------------------------------------
 * Jun 30, 2010           mnash        Initial creation
 * Feb 25, 2013  14418    zwang        Change radar menu to dual pol style
 * Mar 07, 2013  15495    zwang        Handle additional elevation for ssss
 *                                     radars
 * Mar 06, 2014  2876     mpduff       New NDM plugin.
 * Sep 08, 2015  17944    D. Friedman  Handle other elevation list files.
 * Mar 02, 2016  5434     bkowal       Relocated to ndm dataplugin.
 * Jul 12, 2021  8576     randerso     Code cleanup. Generate radar vbsources
 *                                     based on local radars as defined in
 *                                     radarsInUse.txt
 * Jul 26, 2021  8576     randerso     Moved radar vbsources generation to
 *                                     RadarVBMenuUtil.
 *
 * </pre>
 *
 * @author mnash
 */

public class RadarMenuUtil extends AbstractMenuUtil
        implements INationalDatasetSubscriber {
    private static final IUFStatusHandler statusHandler = UFStatus
            .getHandler(RadarMenuUtil.class);

    private static final int NUM_POSSIBLE_RADARS = 25;

    /**
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    public RadarMenuUtil() {
        setSkipParse(false);
    }

    @Override
    public void createMenus() {
        statusHandler.info("Creating radar menus...");

<<<<<<< HEAD
        // retrieve the local radars from
        // radarsInUse.txt
        RadarsInUseUtil.setParsed(false);
        List<String> radars = RadarsInUseUtil.getSite(getSite(),
=======
        /*
         * retrieve the local radars from radarsInUse.txt
         */
        RadarsInUseUtil.setParsed(false);
        List<String> localRadars = RadarsInUseUtil.getSite(getSite(),
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                RadarsInUseUtil.LOCAL_CONSTANT);

        String path = "menus" + File.separator + "radar" + File.separator;
        CommonMenuContributionFile menuContributionFile = new CommonMenuContributionFile();
        CommonIncludeMenuItem includeMenuItem = null;
        VariableSubstitution[] vars = null;
<<<<<<< HEAD
        if (radars.size() == 0) {
            menuContributionFile.contribution = new CommonIncludeMenuItem[1];
        } else {
            menuContributionFile.contribution = new CommonIncludeMenuItem[radars
                    .size()];
        }
        // loop through all the radars
        Map<String, List<Double>> map = TerminalRadarUtils
                .parseTerminalRadarFile();
        if (radars.size() > 0) {
            for (int i = radars.size() - 1; i >= 0; i--) {
                includeMenuItem = new CommonIncludeMenuItem();
                // check for terminal radars
                boolean terminal = TerminalRadarUtils.isTerminalRadar(radars
                        .get(i).toLowerCase());
                if (terminal) {
                    includeMenuItem.fileName = new File(path + "dualPol"
                            + File.separator + "baseTerminalLocalRadarMenu.xml");
                    List<Double> elevations = map.get(radars.get(i));
=======
        if (localRadars.isEmpty()) {
            menuContributionFile.contribution = new CommonIncludeMenuItem[1];
        } else {
            menuContributionFile.contribution = new CommonIncludeMenuItem[localRadars
                    .size()];
        }
        // loop through the local radars
        Map<String, List<Double>> map = TerminalRadarUtils
                .parseTerminalRadarFile();
        if (!localRadars.isEmpty()) {
            for (int i = localRadars.size() - 1; i >= 0; i--) {
                String icao = localRadars.get(i).toLowerCase();

                includeMenuItem = new CommonIncludeMenuItem();
                // check for terminal radars
                boolean terminal = TerminalRadarUtils.isTerminalRadar(icao);
                if (terminal) {
                    includeMenuItem.fileName = new File(
                            path + "dualPol" + File.separator
                                    + "baseTerminalLocalRadarMenu.xml");
                    List<Double> elevations = map.get(icao);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                    vars = new VariableSubstitution[(elevations.size() + 1)
                            + NUM_POSSIBLE_RADARS + 1];
                    vars[0] = new VariableSubstitution();
                    vars[0].key = "icao";
<<<<<<< HEAD
                    vars[0].value = radars.get(i);
=======
                    vars[0].value = icao;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                    for (int j = 1; j <= elevations.size(); j++) {
                        vars[j] = new VariableSubstitution();
                        vars[j].key = "elev" + (j - 1);
                        vars[j].value = String.valueOf(elevations.get(j - 1));
                    }
                    for (int j = 1; j <= elevations.size(); j++) {
<<<<<<< HEAD
                        vars[j + elevations.size()] = new VariableSubstitution();
=======
                        vars[j + elevations
                                .size()] = new VariableSubstitution();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                        vars[j + elevations.size()].key = "suppressErrors"
                                + (j - 1);
                        vars[j + elevations.size()].value = "false";
                    }
<<<<<<< HEAD
                    for (int j = elevations.size() + 1; j <= NUM_POSSIBLE_RADARS; j++) {
                        vars[j + elevations.size()] = new VariableSubstitution();
=======
                    for (int j = elevations.size()
                            + 1; j <= NUM_POSSIBLE_RADARS; j++) {
                        vars[j + elevations
                                .size()] = new VariableSubstitution();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                        vars[j + elevations.size()].key = "suppressErrors"
                                + (j - 1);
                        vars[j + elevations.size()].value = "true";
                    }
                    includeMenuItem.substitutions = vars;
                } else {
<<<<<<< HEAD
                    if (SsssRadarUtil.isSsssRadar(radars.get(i).toLowerCase())) {
                        String ssssRadar = radars.get(i).toLowerCase();
=======
                    if (SsssRadarUtil.isSsssRadar(icao)) {
                        String ssssRadar = icao;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                        includeMenuItem.fileName = new File(path + ssssRadar
                                + File.separator + "baseLocalRadarMenu.xml");
                    } else {
                        includeMenuItem.fileName = new File(path + "dualPol"
                                + File.separator + "baseLocalRadarMenu.xml");
                    }
                    vars = new VariableSubstitution[1];
                    vars[0] = new VariableSubstitution();
                    vars[0].key = "icao";
<<<<<<< HEAD
                    vars[0].value = radars.get(i);
                    includeMenuItem.substitutions = vars;
                }
                includeMenuItem.visibleOnActionSet = new String[] { "com.raytheon.uf.viz.d2d.ui.D2DActionSet" };
                includeMenuItem.installationLocation = "menu:org.eclipse.ui.main.menu?after=satellite";
                menuContributionFile.contribution[radars.size() - 1 - i] = includeMenuItem;
=======
                    vars[0].value = icao;
                    includeMenuItem.substitutions = vars;
                }
                includeMenuItem.visibleOnActionSet = new String[] {
                        "com.raytheon.uf.viz.d2d.ui.D2DActionSet" };
                includeMenuItem.installationLocation = "menu:org.eclipse.ui.main.menu?after=satellite";
                menuContributionFile.contribution[localRadars.size() - 1
                        - i] = includeMenuItem;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            }
        } else {
            includeMenuItem = new CommonIncludeMenuItem();
            menuContributionFile.contribution[0] = includeMenuItem;
            menuContributionFile.contribution[0].fileName = new File("");
        }

        toXml(menuContributionFile, "menus" + File.separator + "radar"
                + File.separator + "index.xml");

        // now on to dial radars
<<<<<<< HEAD
        radars = RadarsInUseUtil.getSite(getSite(),
=======
        List<String> dialRadars = RadarsInUseUtil.getSite(getSite(),
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                RadarsInUseUtil.DIAL_CONSTANT);

        // create MenuTemplateFile for the dialRadars.xml
        MenuTemplateFile menuTemplateFile = new MenuTemplateFile();
<<<<<<< HEAD
        menuTemplateFile.contributions = new CommonIncludeMenuContribution[radars
                .size()];

        CommonIncludeMenuContribution includeMenuContribution = null;
        for (int i = radars.size() - 1; i >= 0; i--) {
            includeMenuContribution = new CommonIncludeMenuContribution();
            includeMenuContribution.substitutions = vars;

            boolean terminal = TerminalRadarUtils.isTerminalRadar(radars.get(i)
                    .toLowerCase());
            if (terminal) {
                List<Double> elevations = map.get(radars.get(i));
                includeMenuContribution.fileName = new File(path + "dualPol"
                        + File.separator + File.separator
                        + "baseTerminalLocalRadarMenu.xml");
=======
        menuTemplateFile.contributions = new CommonIncludeMenuContribution[dialRadars
                .size()];

        CommonIncludeMenuContribution includeMenuContribution = null;
        for (int i = dialRadars.size() - 1; i >= 0; i--) {
            includeMenuContribution = new CommonIncludeMenuContribution();
            includeMenuContribution.substitutions = vars;

            boolean terminal = TerminalRadarUtils
                    .isTerminalRadar(dialRadars.get(i).toLowerCase());
            if (terminal) {
                List<Double> elevations = map.get(dialRadars.get(i));
                includeMenuContribution.fileName = new File(
                        path + "dualPol" + File.separator + File.separator
                                + "baseTerminalLocalRadarMenu.xml");
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                vars = new VariableSubstitution[(elevations.size() + 1)
                        + NUM_POSSIBLE_RADARS + 1];
                vars[0] = new VariableSubstitution();
                vars[0].key = "icao";
<<<<<<< HEAD
                vars[0].value = radars.get(i);
=======
                vars[0].value = dialRadars.get(i);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                for (int j = 1; j <= elevations.size(); j++) {
                    vars[j] = new VariableSubstitution();
                    vars[j].key = "elev" + (j - 1);
                    vars[j].value = String.valueOf(elevations.get(j - 1));
                }
                for (int j = 1; j <= elevations.size(); j++) {
                    vars[j + elevations.size()] = new VariableSubstitution();
                    vars[j + elevations.size()].key = "suppressErrors"
                            + (j - 1);
                    vars[j + elevations.size()].value = "false";
                }
<<<<<<< HEAD
                for (int j = elevations.size() + 1; j <= NUM_POSSIBLE_RADARS; j++) {
=======
                for (int j = elevations.size()
                        + 1; j <= NUM_POSSIBLE_RADARS; j++) {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                    vars[j + elevations.size()] = new VariableSubstitution();
                    vars[j + elevations.size()].key = "suppressErrors"
                            + (j - 1);
                    vars[j + elevations.size()].value = "true";
                }
                includeMenuContribution.substitutions = vars;
                terminal = true;
            } else {
<<<<<<< HEAD
                if (SsssRadarUtil.isSsssRadar(radars.get(i).toLowerCase())) {
                    String ssssRadar = radars.get(i).toLowerCase();
                    includeMenuContribution.fileName = new File(path
                            + ssssRadar + File.separator
                            + "baseLocalRadarMenu.xml");
                } else {
                    includeMenuContribution.fileName = new File(path
                            + "dualPol" + File.separator
                            + "baseLocalRadarMenu.xml");
=======
                if (SsssRadarUtil
                        .isSsssRadar(dialRadars.get(i).toLowerCase())) {
                    String ssssRadar = dialRadars.get(i).toLowerCase();
                    includeMenuContribution.fileName = new File(path + ssssRadar
                            + File.separator + "baseLocalRadarMenu.xml");
                } else {
                    includeMenuContribution.fileName = new File(path + "dualPol"
                            + File.separator + "baseLocalRadarMenu.xml");
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                }
                vars = new VariableSubstitution[1];
                vars[0] = new VariableSubstitution();
                vars[0].key = "icao";
<<<<<<< HEAD
                vars[0].value = radars.get(i);
                includeMenuContribution.substitutions = vars;
            }
            menuTemplateFile.contributions[radars.size() - 1 - i] = includeMenuContribution;
=======
                vars[0].value = dialRadars.get(i);
                includeMenuContribution.substitutions = vars;
            }
            menuTemplateFile.contributions[dialRadars.size() - 1
                    - i] = includeMenuContribution;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        }

        Arrays.sort(menuTemplateFile.contributions);
        // only want 12 radars in the dial radar menu, otherwise put it in
        // submenus
        if (menuTemplateFile.contributions.length > 12) {
<<<<<<< HEAD
            double numMenus = Math
                    .ceil(((double) menuTemplateFile.contributions.length) / 12);
=======
            double numMenus = Math.ceil(
                    ((double) menuTemplateFile.contributions.length) / 12);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            int perMenu = (int) (menuTemplateFile.contributions.length
                    / numMenus + 1);
            statusHandler.info("For " + menuTemplateFile.contributions.length
                    + " dial radars, menus have increased to " + (int) numMenus
                    + " with an average of " + perMenu + " per menu");
            List<CommonAbstractMenuContribution> list = Arrays
                    .asList(menuTemplateFile.contributions);
            menuTemplateFile.contributions = new CommonSubmenuContribution[(int) numMenus];

            int count = 0;
            for (int i = 0; i < numMenus; i++) {
                menuTemplateFile.contributions[i] = new CommonSubmenuContribution();
                int numCount = 0;
                if (list.size() - count < perMenu) {
                    numCount = list.size() - count;
                    ((CommonSubmenuContribution) menuTemplateFile.contributions[i]).contributions = new CommonIncludeMenuContribution[list
                            .size() - count];
                    ((CommonSubmenuContribution) menuTemplateFile.contributions[i]).menuText = ((CommonIncludeMenuContribution) list
                            .get(count)).substitutions[0].value
                            + "-"
<<<<<<< HEAD
                            + ((CommonIncludeMenuContribution) list.get(perMenu
                                    * i + list.size() - count - 1)).substitutions[0].value;
=======
                            + ((CommonIncludeMenuContribution) list
                                    .get(perMenu * i + list.size() - count
                                            - 1)).substitutions[0].value;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                } else {
                    numCount = perMenu;
                    ((CommonSubmenuContribution) menuTemplateFile.contributions[i]).contributions = new CommonIncludeMenuContribution[perMenu];
                    ((CommonSubmenuContribution) menuTemplateFile.contributions[i]).menuText = ((CommonIncludeMenuContribution) list
                            .get(count)).substitutions[0].value
                            + "-"
<<<<<<< HEAD
                            + ((CommonIncludeMenuContribution) list.get(perMenu
                                    * (i + 1) - 1)).substitutions[0].value;
=======
                            + ((CommonIncludeMenuContribution) list
                                    .get(perMenu * (i + 1)
                                            - 1)).substitutions[0].value;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                }
                for (int j = 0; j < numCount; j++) {
                    ((CommonSubmenuContribution) menuTemplateFile.contributions[i]).contributions[j] = list
                            .get(count);
                    count++;
                }
            }
        }

        toXml(menuTemplateFile, "menus" + File.separator + "radar"
                + File.separator + "dialRadars.xml");

        CommonSubmenuContribution submenuContribution = new CommonSubmenuContribution();
<<<<<<< HEAD
        List<CommonAbstractMenuContribution> contributions = new ArrayList<CommonAbstractMenuContribution>();

        // now on to asr radars
        radars = RadarsInUseUtil.getSite(getSite(),
                RadarsInUseUtil.ASR_CONSTANT);
        if (!radars.isEmpty()) {
            submenuContribution.contributions = new CommonAbstractMenuContribution[radars
=======
        List<CommonAbstractMenuContribution> contributions = new ArrayList<>();

        // now on to asr radars
        List<String> asrRadars = RadarsInUseUtil.getSite(getSite(),
                RadarsInUseUtil.ASR_CONSTANT);
        if (!asrRadars.isEmpty()) {
            submenuContribution.contributions = new CommonAbstractMenuContribution[asrRadars
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                    .size()];
            submenuContribution.menuText = "ASR-11 Radar";
            submenuContribution.id = "asr11radarsubmenu";
            menuTemplateFile = new MenuTemplateFile();
<<<<<<< HEAD
            for (int i = radars.size() - 1; i >= 0; i--) {
=======
            for (int i = asrRadars.size() - 1; i >= 0; i--) {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                includeMenuContribution = new CommonIncludeMenuContribution();
                vars = new VariableSubstitution[1];
                vars[0] = new VariableSubstitution();
                vars[0] = new VariableSubstitution();
                vars[0].key = "icao";
<<<<<<< HEAD
                vars[0].value = radars.get(i);
                includeMenuContribution.substitutions = vars;
                includeMenuContribution.fileName = new File(path + "dualPol"
                        + File.separator + "asrRadars.xml");
=======
                vars[0].value = asrRadars.get(i);
                includeMenuContribution.substitutions = vars;
                includeMenuContribution.fileName = new File(
                        path + "dualPol" + File.separator + "asrRadars.xml");
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                submenuContribution.contributions[i] = includeMenuContribution;
            }
            contributions.add(submenuContribution);
        }

        // now on to arsr radars
<<<<<<< HEAD
        radars = RadarsInUseUtil.getSite(getSite(),
                RadarsInUseUtil.ARSR_CONSTANT);
        if (!radars.isEmpty()) {
            submenuContribution = new CommonSubmenuContribution();
            submenuContribution.contributions = new CommonAbstractMenuContribution[radars
                    .size()];
            submenuContribution.menuText = "ARSR-4 Radar";
            submenuContribution.id = "arsr4radarsubmenu";
            for (int i = radars.size() - 1; i >= 0; i--) {
=======
        List<String> arsrRadars = RadarsInUseUtil.getSite(getSite(),
                RadarsInUseUtil.ARSR_CONSTANT);
        if (!arsrRadars.isEmpty()) {
            submenuContribution = new CommonSubmenuContribution();
            submenuContribution.contributions = new CommonAbstractMenuContribution[arsrRadars
                    .size()];
            submenuContribution.menuText = "ARSR-4 Radar";
            submenuContribution.id = "arsr4radarsubmenu";
            for (int i = arsrRadars.size() - 1; i >= 0; i--) {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                includeMenuContribution = new CommonIncludeMenuContribution();
                vars = new VariableSubstitution[1];
                vars[0] = new VariableSubstitution();
                vars[0].key = "icao";
<<<<<<< HEAD
                vars[0].value = radars.get(i);
                includeMenuContribution.fileName = new File(path + "dualPol"
                        + File.separator + "arsrRadars.xml");
                includeMenuContribution.substitutions = vars;
                submenuContribution.contributions[radars.size() - 1 - i] = includeMenuContribution;
=======
                vars[0].value = arsrRadars.get(i);
                includeMenuContribution.fileName = new File(
                        path + "dualPol" + File.separator + "arsrRadars.xml");
                includeMenuContribution.substitutions = vars;
                submenuContribution.contributions[arsrRadars.size() - 1
                        - i] = includeMenuContribution;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            }
            contributions.add(submenuContribution);
        }
        if (contributions.isEmpty()) {
            CommonSeparatorMenuContribution separatorCont = new CommonSeparatorMenuContribution();
            separatorCont.id = "emptyAirportRadarId";
            contributions.add(separatorCont);
        }
<<<<<<< HEAD
        menuTemplateFile.contributions = contributions
                .toArray(new CommonAbstractMenuContribution[contributions
                        .size()]);
=======
        menuTemplateFile.contributions = contributions.toArray(
                new CommonAbstractMenuContribution[contributions.size()]);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

        toXml(menuTemplateFile, "menus" + File.separator + "radar"
                + File.separator + "airportRadars.xml");

        menuContributionFile = new CommonMenuContributionFile();

        menuContributionFile.contribution = new CommonIncludeMenuItem[1];
        includeMenuItem = menuContributionFile.contribution[0] = new CommonIncludeMenuItem();
        includeMenuItem.installationLocation = "menu:radar?after=RADAR_MENU_START";
        includeMenuItem.fileName = new File(path + "baseRadarMenu.xml");
        vars = includeMenuItem.substitutions = new VariableSubstitution[1];
        vars[0] = new VariableSubstitution();
        vars[0].key = "mosaicIcaoList";
        vars[0].value = "";
        for (String icao : RadarsInUseUtil.getSite(getSite(),
                RadarsInUseUtil.MOSAIC_CONSTANT)) {
            if (!vars[0].value.isEmpty()) {
                vars[0].value += ",";
            }
            vars[0].value += icao;
        }
        toXml(menuContributionFile, "menus" + File.separator + "radar"
                + File.separator + "radarindex.xml");

        statusHandler.info("Finished processing radar menus.");
    }

    public void setSkipParse(boolean rebuild) {
        RadarsInUseUtil.setParsed(rebuild);
    }

    @Override
    public void notify(String fileName, File file) {
        if ("tdwrElevations.txt".equals(fileName)) {
            saveFile(file, TerminalRadarUtils.getElevationsFile());
            setSkipParse(false);
            createMenus();
<<<<<<< HEAD
        } else if ("elevationLists.txt".equals(fileName) ||
                "ssssElevationLists.txt".equals(fileName)) {
=======
        } else if ("elevationLists.txt".equals(fileName)
                || "ssssElevationLists.txt".equals(fileName)) {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            saveFile(file, getRadarElevationLocalizationFile(fileName));
        }
        statusHandler.handle(Priority.INFO,
                "Successfully processed " + file.getAbsolutePath());
    }

<<<<<<< HEAD
    private LocalizationFile getRadarElevationLocalizationFile(String fileName) {
=======
    private LocalizationFile getRadarElevationLocalizationFile(
            String fileName) {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        IPathManager pathMgr = PathManagerFactory.getPathManager();
        LocalizationContext context = pathMgr.getContext(
                LocalizationType.COMMON_STATIC, LocalizationLevel.BASE);
        return pathMgr.getLocalizationFile(context,
                "radar" + File.separator + fileName);
    }

    private void saveFile(File file, LocalizationFile outFile) {
        if ((file != null) && file.exists()) {
<<<<<<< HEAD
            InputStream fis = null;
            OutputStream fos = null;
            try {
                fis = new FileInputStream(file);
                fos = outFile.openOutputStream();
                try {
                    FileUtil.copy(fis, fos);
                } catch (IOException e) {
                    statusHandler.handle(Priority.PROBLEM,
                            "Could not read file: " + file.getName(), e);

                }
            } catch (LocalizationException e) {
                statusHandler.handle(Priority.PROBLEM,
                        "Failed to open localization file for output: "
                        + outFile, e);
            } catch (FileNotFoundException e) {
                statusHandler.handle(Priority.PROBLEM, "Failed to find file: "
                        + file.getName(), e);
            } finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        // ignore
                    }
                }
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        // ignore
                    }
                }
=======
            try (SaveableOutputStream out = outFile.openOutputStream()) {
                Files.copy(file.toPath(), out);
            } catch (IOException | LocalizationException e) {
                statusHandler.warn("Error copying " + file + " to " + outFile,
                        e);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            }
        }
    }

<<<<<<< HEAD
    /*
     * (non-Javadoc)
     * 
     * @see com.raytheon.uf.common.menus.AbstractMenuUtil#checkCreated()
     */
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    @Override
    public boolean checkCreated() {
        return super.checkCreated("radarsInUse.txt", "radar");
    }
}
