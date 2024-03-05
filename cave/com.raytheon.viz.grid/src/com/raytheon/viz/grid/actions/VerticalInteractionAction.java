/**
 * This software was developed and / or modified by Raytheon Company,
 * pursuant to Contract DG133W-05-CQ-1067 with the US Government.
 *
 * U.S. EXPORT CONTROLLED TECHNICAL DATA
 * This software product contains export-restricted data whose
 * export/transfer/disclosure is restricted by U.S. law. Dissemination
 * to non-U.S. persons whether in the United States or abroad requires
 * an export license or other authorization.
 *
 * Contractor Name:        Raytheon Company
 * Contractor Address:     6825 Pine Street, Suite 340
 *                         Mail Stop B8
 *                         Omaha, NE 68106
 *                         402.291.0100
 *
 * See the AWIPS II Master Rights File ("Master Rights File.pdf") for
 * further licensing information.
 **/
package com.raytheon.viz.grid.actions;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.eclipse.jface.action.Action;

import com.raytheon.uf.common.dataplugin.grid.GridConstants;
import com.raytheon.uf.common.dataquery.requests.RequestConstraint;
import com.raytheon.uf.common.dataquery.requests.RequestConstraint.ConstraintType;
import com.raytheon.uf.common.localization.IPathManager;
import com.raytheon.uf.common.localization.LocalizationContext.LocalizationLevel;
import com.raytheon.uf.common.localization.LocalizationContext.LocalizationType;
import com.raytheon.uf.common.localization.LocalizationFile;
import com.raytheon.uf.common.localization.LocalizationUtil;
import com.raytheon.uf.common.localization.PathManagerFactory;
import com.raytheon.uf.common.localization.exception.LocalizationException;
import com.raytheon.uf.common.status.IUFStatusHandler;
import com.raytheon.uf.common.status.UFStatus;
import com.raytheon.uf.common.time.DataTime;
import com.raytheon.uf.viz.core.AbstractTimeMatcher;
import com.raytheon.uf.viz.core.IDisplayPane;
import com.raytheon.uf.viz.core.drawables.IDescriptor;
import com.raytheon.uf.viz.core.drawables.IDescriptor.FramesInfo;
import com.raytheon.uf.viz.core.exception.VizException;
import com.raytheon.uf.viz.core.rsc.AbstractResourceData;
import com.raytheon.uf.viz.core.rsc.AbstractVizResource;
import com.raytheon.uf.viz.d2d.core.time.D2DTimeMatcher;
import com.raytheon.viz.grid.rsc.GridNameGenerator;
import com.raytheon.viz.grid.rsc.GridResourceData;
import com.raytheon.viz.ui.cmenu.AbstractRightClickAction;

/**
 * Enable Vertical Interaction Action
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 *
 * Date          Ticket#  Engineer  Description
 * ------------- -------- --------- -----------------
 * May 07, 2021  8453     randerso  Initial creation
 * Nov 02, 2022  8963     mapeters  Prevent error when no data is available,
 *                                  redo time matching for other descriptors too,
 *                                  disable/uncheck when not the time match basis
 *
 * </pre>
 *
 * @author randerso
 */
public class VerticalInteractionAction extends AbstractRightClickAction {
    private static final IUFStatusHandler statusHandler = UFStatus
            .getHandler(VerticalInteractionAction.class);

    private static final String CONFIG_PATH = LocalizationUtil.join("levels",
            "VerticalInteractionLevels.properties");

    /**
     * key=master level, value=comma separated list of levels
     */
    private static Properties levelProps = new Properties();

    private static final Object levelPropsLock = new Object();

    private static final IPathManager pathMgr = PathManagerFactory
            .getPathManager();
    static {
        pathMgr.addLocalizationPathObserver(CONFIG_PATH, file -> {
            synchronized (levelPropsLock) {
                levelProps.clear();
            }
        });
    }

    /**
     * Constructor
     */
    public VerticalInteractionAction() {
        super("Enable Vertical Interaction", Action.AS_CHECK_BOX);
    }

    private GridResourceData getGridResourceData() {
        AbstractVizResource<?, ?> rsc = getSelectedRsc();

        if (rsc != null) {
            AbstractResourceData rscData = getSelectedRsc().getResourceData();
            if (rscData instanceof GridResourceData) {
                return (GridResourceData) rscData;
            }
        }
        return null;
    }

    /**
     * @param gridRscData
     * @return the master level from the gridRscData, or null if no level
     *         constraint is specified.
     */
    private String getMasterLevel(GridResourceData gridRscData) {
        String masterLevel = null;

        RequestConstraint masterLevelConstraint = gridRscData.getMetadataMap()
                .get(GridConstants.MASTER_LEVEL_NAME);
        if (masterLevelConstraint != null) {
            masterLevel = masterLevelConstraint.getConstraintValue();
        }
        return masterLevel;

    }

    @Override
    public boolean isEnabled() {
        /*
         * Return true if vertical interaction levels are configured for the
         * master level associated with the selected resource and we are the
         * time match basis
         */
        GridResourceData gridRscData = getGridResourceData();
        if (gridRscData != null) {
            String masterLevel = getMasterLevel(gridRscData);
            String levels = getConfiguredLevels(masterLevel);

            if (levels != null && !levels.isBlank()
                    && isResourceTimeMatchBasis()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getToolTipText() {
        /*
         * Set tool tip text if no vertical interaction levels are specified for
         * the master level associated with the selected resource
         */
        GridResourceData gridRscData = getGridResourceData();
        if (gridRscData != null) {
            String masterLevel = getMasterLevel(gridRscData);
            String levels = getConfiguredLevels(masterLevel);

            if (levels == null || levels.isBlank()) {
                return "No levels configured for master level \"" + masterLevel
                        + "\"";
            } else if (!isResourceTimeMatchBasis()) {
                return "Vertical Interaction can only be enabled for the Time Match Basis";
            }
        }
        return null;
    }

    @Override
    public boolean isChecked() {
        GridResourceData gridRscData = getGridResourceData();
        return gridRscData != null && gridRscData.isSpatial()
                && isResourceTimeMatchBasis();
    }

    @Override
    public void setChecked(boolean checked) {
        GridResourceData gridRscData = getGridResourceData();
        if (gridRscData != null) {
            gridRscData.setSpatial(checked);
        }
    }

    @Override
    public void run() {
        GridResourceData gridRscData = getGridResourceData();
        if (gridRscData == null) {
            return;
        }

        AbstractVizResource<?, ?> rsc = getSelectedRsc();
        IDescriptor descriptor = getDescriptor();

        RequestConstraint levelConstraint = gridRscData.getMetadataMap()
                .get(GridConstants.LEVEL_ONE);
        levelConstraint.setConstraintType(ConstraintType.IN);
        if (gridRscData.isSpatial()) {
            /*
             * replace the levels in the constraint with the levels configured
             * for vertical interaction for the master level associated with the
             * selected resource
             */
            String masterLevel = getMasterLevel(gridRscData);
            String levels = getConfiguredLevels(masterLevel);
            if (levels != null) {
                levelConstraint.setConstraintValue(levels);

                /*
                 * Replace the name generator with a new GridNameGenerator
                 * without planeLabelString set to ensure we have one that will
                 * properly display the level in the legend.
                 */
                gridRscData.setNameGenerator(new GridNameGenerator());
            }
        } else {
            /* set level constraint to just the currently displayed level */
            FramesInfo framesInfo = descriptor.getFramesInfo();
            DataTime dataTime = framesInfo.getTimeForResource(rsc);
            String levelValueStr;
            if (dataTime != null) {
                levelValueStr = dataTime.getLevelValue().toString();
            } else {
                /*
                 * No data available for current frame, default to first
                 * configured level
                 */
                String masterLevel = getMasterLevel(gridRscData);
                String levels = getConfiguredLevels(masterLevel);
                levelValueStr = levels.split(",")[0];
            }
            levelConstraint.setConstraintValue(levelValueStr);
        }

        /* reload resource with new levels */
        try {
            AbstractTimeMatcher timeMatcher = descriptor.getTimeMatcher();
            timeMatcher.redoTimeMatching(rsc);
            timeMatcher.redoTimeMatching(descriptor);
            /*
             * Other panes need updating as well since this action is only
             * available when we are the time match basis
             */
            for (IDisplayPane pane : container.getDisplayPanes()) {
                IDescriptor paneDescriptor = pane.getDescriptor();
                if (paneDescriptor != descriptor) {
                    paneDescriptor.getTimeMatcher()
                            .redoTimeMatching(paneDescriptor);
                }
            }
        } catch (VizException e) {
            statusHandler.error(e.getLocalizedMessage(), e);
        }
    }

    /**
     * @param masterLevel
     * @return the configured vertical interaction levels for the specified
     *         master level or null if master level is null or has no levels
     *         configured
     */
    private String getConfiguredLevels(String masterLevel) {
        if (masterLevel == null) {
            return null;
        }

        synchronized (levelPropsLock) {
            if (levelProps.isEmpty()) {
                levelProps = loadLevels();
            }
            return levelProps.getProperty(masterLevel);
        }
    }

    private Properties loadLevels() {
        Map<LocalizationLevel, LocalizationFile> fileMap = pathMgr
                .getTieredLocalizationFile(LocalizationType.CAVE_STATIC,
                        CONFIG_PATH);

        List<LocalizationLevel> keyList = new ArrayList<>(fileMap.keySet());
        Collections.sort(keyList);
        Properties props = new Properties();
        for (LocalizationLevel key : keyList) {
            LocalizationFile lf = fileMap.get(key);
            try (InputStream is = lf.openInputStream()) {
                props.load(is);
            } catch (IOException | LocalizationException e) {
                statusHandler.error(e.getLocalizedMessage(), e);
            }
        }

        return props;
    }

    private boolean isResourceTimeMatchBasis() {
        IDescriptor descriptor = getDescriptor();
        if (descriptor != null) {
            AbstractTimeMatcher tm = descriptor.getTimeMatcher();
            /*
             * Should always be a D2D time matcher anyway since plugin.xml
             * specifies this is for D2DGridResources
             */
            if (tm instanceof D2DTimeMatcher) {
                if (getSelectedRsc() == ((D2DTimeMatcher) tm)
                        .getTimeMatchBasis()) {
                    return true;
                }
            }
        }
        return false;
    }
}