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
package com.raytheon.viz.radar.ui;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
=======
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

import com.raytheon.uf.common.dataplugin.radar.util.RadarsInUseUtil;
import com.raytheon.uf.common.dataquery.requests.RequestConstraint;
import com.raytheon.uf.viz.core.drawables.AbstractRenderableDisplay;
import com.raytheon.uf.viz.core.drawables.ResourcePair;
import com.raytheon.uf.viz.core.localization.LocalizationConstants;
import com.raytheon.uf.viz.core.localization.LocalizationManager;
import com.raytheon.uf.viz.core.procedures.Bundle;
import com.raytheon.uf.viz.core.rsc.AbstractRequestableResourceData;
import com.raytheon.uf.viz.core.rsc.AbstractResourceData;
import com.raytheon.uf.viz.core.rsc.IResourceGroup;
import com.raytheon.uf.viz.core.rsc.ResourceList;
import com.raytheon.uf.viz.core.rsc.groups.BestResResourceData;
import com.raytheon.uf.viz.d2d.core.procedures.AlterBundleContributorAdapter;
<<<<<<< HEAD
import com.raytheon.viz.radar.rsc.RadarResourceData;

/**
 * Class to handle alter bundles for radar.
 * 
 * <pre>
 * 
 * SOFTWARE HISTORY
 * Date         Ticket#    Engineer    Description
 * ------------ ---------- ----------- --------------------------
 * Jan 4, 2010            mschenke     Initial creation
 * Oct 3, 2012  #1248      rferrel     Change to use adapter.
 * 
 * </pre>
 * 
 * @author mschenke
 * @version 1.0
 */

=======
import com.raytheon.viz.radar.util.RadarAsGridUtil;

/**
 * Class to handle alter bundles for radar.
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 * Date         Ticket#    Engineer    Description
 * ------------ ---------- ----------- --------------------------
 * Jan 04, 2010            mschenke    Initial creation
 * Oct 03, 2012 1248       rferrel     Change to use adapter.
 * Jun 24, 2022 8869       mapeters    Alter "info.datasetId" constraint,
 *                                     prevent listing duplicate sites
 *
 * </pre>
 *
 * @author mschenke
 */
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
public class RadarAlterBundleContributor extends AlterBundleContributorAdapter {

    private static final String RADAR_KEY = "Radar";

    private void alterResourceList(ResourceList list, String selectedString) {
        for (ResourcePair rp : list) {
            AbstractResourceData rData = rp.getResourceData();
<<<<<<< HEAD
            if (rData instanceof RadarResourceData) {
                alterResource((RadarResourceData) rData, selectedString);
=======
            if (rData instanceof AbstractRequestableResourceData) {
                alterResource((AbstractRequestableResourceData) rData,
                        selectedString);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            } else if (rData instanceof IResourceGroup) {
                alterResourceList(((IResourceGroup) rData).getResourceList(),
                        selectedString);
            } else if (rData instanceof BestResResourceData) {
                alterResourceList(
                        ((BestResResourceData) rData).getResourceList(),
                        selectedString);
                alterResource((BestResResourceData) rData, selectedString);
            }
        }
    }

    private void alterResource(AbstractRequestableResourceData data,
            String selectedString) {
        Map<String, RequestConstraint> reqMap = data.getMetadataMap();
<<<<<<< HEAD
        RequestConstraint rc = reqMap.get("icao");
=======
        RequestConstraint rc = reqMap.get("info.datasetId");
        if (rc != null
                && RadarAsGridUtil.isRadarModelName(rc.getConstraintValue())) {
            rc.setConstraintValue(
                    RadarAsGridUtil.getModelNameForIcao(selectedString));
        }
        rc = reqMap.get("icao");
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        if (rc != null) {
            rc.setConstraintValue(selectedString);
        }
    }

<<<<<<< HEAD
    /*
     * (non-Javadoc)
     * 
     * @see
     * com.raytheon.uf.viz.core.procedures.IAlterBundleContributor#getAlterables
     * ()
     */
    @Override
    public Map<String, String[]> getAlterables() {
        Map<String, String[]> alterables = new HashMap<String, String[]>();

        String site = LocalizationManager.getInstance().getLocalizationStore()
                .getString(LocalizationConstants.P_LOCALIZATION_SITE_NAME);
        List<String> radars = new ArrayList<String>(RadarsInUseUtil.getSite(
                site, RadarsInUseUtil.LOCAL_CONSTANT));
        radars.addAll(RadarsInUseUtil.getSite(site,
                RadarsInUseUtil.DIAL_CONSTANT));
        radars.addAll(RadarsInUseUtil.getSite(site,
                RadarsInUseUtil.ARSR_CONSTANT));
        radars.addAll(RadarsInUseUtil.getSite(site,
                RadarsInUseUtil.ASR_CONSTANT));
        Collections.sort(radars);
=======
    @Override
    public Map<String, String[]> getAlterables() {
        Map<String, String[]> alterables = new HashMap<>();

        String site = LocalizationManager.getInstance().getLocalizationStore()
                .getString(LocalizationConstants.P_LOCALIZATION_SITE_NAME);
        SortedSet<String> radars = new TreeSet<>(
                RadarsInUseUtil.getSite(site, RadarsInUseUtil.LOCAL_CONSTANT));
        radars.addAll(
                RadarsInUseUtil.getSite(site, RadarsInUseUtil.DIAL_CONSTANT));
        radars.addAll(
                RadarsInUseUtil.getSite(site, RadarsInUseUtil.ARSR_CONSTANT));
        radars.addAll(
                RadarsInUseUtil.getSite(site, RadarsInUseUtil.ASR_CONSTANT));
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

        alterables.put(RADAR_KEY, radars.toArray(new String[radars.size()]));

        return alterables;
    }

<<<<<<< HEAD
    /*
     * (non-Javadoc)
     * 
     * @see
     * com.raytheon.uf.viz.core.procedures.IAlterBundleContributor#alterBundle
     * (com.raytheon.uf.viz.core.procedures.Bundle, java.lang.String,
     * java.lang.String)
     */
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    @Override
    public void alterBundle(Bundle bundleToAlter, String alterKey,
            String alterValue) {
        if (RADAR_KEY.equals(alterKey)) {
            for (AbstractRenderableDisplay display : bundleToAlter
                    .getDisplays()) {
                alterResourceList(display.getDescriptor().getResourceList(),
                        alterValue);
            }
        }
    }
}
