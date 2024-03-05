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
package com.raytheon.viz.satellite.menu;

import java.util.Arrays;
<<<<<<< HEAD
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.ui.IWorkbenchWindow;
=======
import java.util.HashMap;
import java.util.Map;

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import org.geotools.coverage.grid.GeneralGridGeometry;

import com.raytheon.uf.common.localization.PathManagerFactory;
import com.raytheon.uf.common.menus.xml.CommonBundleMenuContribution;
import com.raytheon.uf.common.menus.xml.VariableSubstitution;
import com.raytheon.uf.common.serialization.SerializationException;
import com.raytheon.uf.common.status.IUFStatusHandler;
import com.raytheon.uf.common.status.UFStatus;
import com.raytheon.uf.common.status.UFStatus.Priority;
import com.raytheon.uf.common.time.DataTime;
import com.raytheon.uf.viz.core.IDisplayPaneContainer;
import com.raytheon.uf.viz.core.VizConstants;
import com.raytheon.uf.viz.core.drawables.IDescriptor;
import com.raytheon.uf.viz.core.drawables.IRenderableDisplay;
import com.raytheon.uf.viz.core.drawables.ResourcePair;
import com.raytheon.uf.viz.core.exception.VizException;
<<<<<<< HEAD
import com.raytheon.uf.viz.core.globals.IGlobalChangedListener;
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import com.raytheon.uf.viz.core.globals.VizGlobalsManager;
import com.raytheon.uf.viz.core.map.IMapDescriptor;
import com.raytheon.uf.viz.core.procedures.Bundle;
import com.raytheon.uf.viz.core.procedures.ProcedureXmlManager;
import com.raytheon.uf.viz.core.rsc.AbstractRequestableResourceData;
import com.raytheon.uf.viz.core.rsc.ResourceGroup;
import com.raytheon.uf.viz.core.rsc.URICatalog;
import com.raytheon.uf.viz.core.rsc.URICatalog.IURIRefreshCallback;
import com.raytheon.uf.viz.ui.menus.widgets.BundleContributionItem;
import com.raytheon.viz.satellite.rsc.SatBestResResourceData;
import com.raytheon.viz.satellite.rsc.SatBlendedResourceData;
import com.raytheon.viz.ui.EditorUtil;

/**
<<<<<<< HEAD
 * 
 * Custom bundle contribution item for satellite so it has the ability to
 * determine available times differently depending on scale by using a
 * {@link SatBestResResourceData} to determine which resources are best to load.
 * 
 * <pre>
 * 
 * SOFTWARE HISTORY
 * 
 * Date          Ticket#  Engineer    Description
 * ------------- -------- ----------- --------------------------
 * Aug 26, 2011           bsteffen    Initial creation
 * Oct 22, 2013  2491     bsteffen    Switch serialization to 
 *                                    ProcedureXmlManager
 * 
 * </pre>
 * 
 * @author bsteffen
 * @version 1.0
=======
 *
 * Custom bundle contribution item for satellite so it has the ability to
 * determine available times differently depending on scale by using a
 * {@link SatBestResResourceData} to determine which resources are best to load.
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 *
 * Date          Ticket#  Engineer    Description
 * ------------- -------- ----------- --------------------------
 * Aug 26, 2011           bsteffen    Initial creation
 * Oct 22, 2013  2491     bsteffen    Switch serialization to
 *                                    ProcedureXmlManager
 * Oct 12, 2022  8946     mapeters    Handle map scale property ID rename
 *
 * </pre>
 *
 * @author bsteffen
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 */
public class SatBundleContributionItem extends BundleContributionItem {
    private static final transient IUFStatusHandler statusHandler = UFStatus
            .getHandler(SatBundleContributionItem.class);

    private class QueryResourceJob implements IURIRefreshCallback {

        protected boolean queryPerformed;

        protected DataTime time;

        private final AbstractRequestableResourceData resourceData;

        public QueryResourceJob(AbstractRequestableResourceData resourceData) {
            this.queryPerformed = false;
            this.resourceData = resourceData;
            URICatalog.getInstance().catalogAndQueryDataURI(
                    resourceData.getMetadataMap(), this);
        }

        @Override
        public void updateTime(DataTime time) {
            try {
                // Clone the resource data, this ensures we get a fresh
                // resourceData with no cached times.
                AbstractRequestableResourceData resourceData = this.resourceData;
                ResourcePair pair = new ResourcePair();
                pair.setResourceData(resourceData);
                ResourceGroup group = new ResourceGroup();
                group.getResourceList().add(pair);
                ProcedureXmlManager jaxb = ProcedureXmlManager.getInstance();
                String xml = jaxb.marshal(group);
                group = jaxb.unmarshal(ResourceGroup.class, xml);
                resourceData = (AbstractRequestableResourceData) group
                        .getResourceList().get(0).getResourceData();
                // get the available times
                DataTime[] aTimes = resourceData.getAvailableTimes();
                if (aTimes == null || aTimes.length == 0) {
                    this.time = null;
                    queryPerformed = true;
                    updateMenuTextAsync();
                    return;
                }
                // sort the times.
<<<<<<< HEAD
                Arrays.sort(aTimes, new Comparator<DataTime>() {

                    @Override
                    public int compare(DataTime o1, DataTime o2) {
                        Long t1 = o1.getMatchValid();
                        Long t2 = o2.getMatchValid();
                        return t1.compareTo(t2);
                    }
                });
                // use the latest one.
                this.time = aTimes[aTimes.length - 1];
            } catch (VizException e) {
                statusHandler.handle(Priority.PROBLEM, e.getLocalizedMessage(),
                        e);
            } catch (SerializationException e) {
=======
                Arrays.sort(aTimes, (o1, o2) -> {
                    Long t1 = o1.getMatchValid();
                    Long t2 = o2.getMatchValid();
                    return t1.compareTo(t2);
                });
                // use the latest one.
                this.time = aTimes[aTimes.length - 1];
            } catch (VizException | SerializationException e) {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                statusHandler.handle(Priority.PROBLEM, e.getLocalizedMessage(),
                        e);
            }
            queryPerformed = true;
            updateMenuTextAsync();
        }

    }

    private class FindBestResJob implements Runnable {

        private final IDescriptor descriptor;

        private AbstractRequestableResourceData resourceData;

        public FindBestResJob(IDescriptor descriptor) {
            this.descriptor = descriptor;
            prepareBundleJobPool.schedule(this);
        }

        @Override
        public void run() {
            try {
                ResourcePair resourceToDraw = bestResData
                        .getResourceToDraw(descriptor);
                if (resourceToDraw != null) {
                    resourceData = (AbstractRequestableResourceData) resourceToDraw
                            .getResourceData();
                }
            } catch (VizException e) {
                statusHandler.handle(Priority.PROBLEM, e.getLocalizedMessage(),
                        e);
            }
            updateMenuTextAsync();
<<<<<<< HEAD
            return;
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        }

    }

    private SatBestResResourceData bestResData = null;

    private SatBlendedResourceData blendedData = null;

<<<<<<< HEAD
    private Map<GeneralGridGeometry, FindBestResJob> bestResResult = new HashMap<GeneralGridGeometry, FindBestResJob>();

    private Map<AbstractRequestableResourceData, QueryResourceJob> times = new HashMap<AbstractRequestableResourceData, QueryResourceJob>();
=======
    private Map<GeneralGridGeometry, FindBestResJob> bestResResult = new HashMap<>();

    private Map<AbstractRequestableResourceData, QueryResourceJob> times = new HashMap<>();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    public SatBundleContributionItem(CommonBundleMenuContribution contribution,
            VariableSubstitution[] includeSubstitutions) throws VizException {
        super(contribution, includeSubstitutions);
<<<<<<< HEAD
        VizGlobalsManager.addListener(VizConstants.SCALE_ID,
                new IGlobalChangedListener() {

                    @Override
                    public void updateValue(IWorkbenchWindow changedWindow,
                            Object value) {
                        updateMenuTextAsync();
                    }
                });
=======
        VizGlobalsManager.addListener(VizConstants.MAP_SCALE_ID,
                (changedWindow, value) -> updateMenuTextAsync());
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    @Override
    protected synchronized void updateMenuText() {
        AbstractRequestableResourceData resourceData = null;
        if (bestResData != null) {
            IDisplayPaneContainer container = EditorUtil
                    .getActiveVizContainer();
            IDescriptor descriptor = null;
            if (container != null) {
                descriptor = container.getActiveDisplayPane().getDescriptor();
            }
            if (descriptor instanceof IMapDescriptor) {
                lastUsedTime = null;
                GeneralGridGeometry gridGeom = descriptor.getGridGeometry();
                FindBestResJob job = bestResResult.get(gridGeom);
                if (job == null) {
                    job = new FindBestResJob(descriptor);
                    bestResResult.put(gridGeom, job);
                }
                resourceData = job.resourceData;
            }
        } else if (blendedData != null) {
            resourceData = blendedData;
        }
        if (resourceData != null) {
            QueryResourceJob job = times.get(resourceData);
            if (job == null) {
                job = new QueryResourceJob(resourceData);
                times.put(resourceData, job);
            }
            lastUsedTime = job.time;
            queryPerformed = job.queryPerformed;
        }
        super.updateMenuText();
    }

    @Override
    protected void onShow() {
        if (!shownBefore) {
            shownBefore = true;
            prepareBundleJobPool.schedule(new BundleParseJob());
        }

        if (widget != null
<<<<<<< HEAD
                && (widget.getText() == null || widget.getText().equals(""))) {
=======
                && (widget.getText() == null || widget.getText().isEmpty())) {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            updateMenuText();
        }
    }

    private class BundleParseJob implements Runnable {

        @Override
        public void run() {
            try {
<<<<<<< HEAD
                Bundle b = Bundle
                        .unmarshalBundle(
                                PathManagerFactory
                                        .getPathManager()
                                        .getStaticFile(
                                                menuContribution.xml.bundleFile),
                                substitutions);
=======
                Bundle b = Bundle.unmarshalBundle(
                        PathManagerFactory.getPathManager()
                                .getStaticFile(menuContribution.xml.bundleFile),
                        substitutions);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                for (IRenderableDisplay display : b.getDisplays()) {
                    for (ResourcePair rp : display.getDescriptor()
                            .getResourceList()) {
                        if (rp.getResourceData() instanceof SatBestResResourceData) {
                            bestResData = (SatBestResResourceData) rp
                                    .getResourceData();
                            updateMenuTextAsync();
                            return;
<<<<<<< HEAD
                        } else if (rp.getResourceData() instanceof SatBlendedResourceData) {
=======
                        } else if (rp
                                .getResourceData() instanceof SatBlendedResourceData) {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                            blendedData = (SatBlendedResourceData) rp
                                    .getResourceData();
                            updateMenuTextAsync();
                            return;
                        }
                    }
                }
            } catch (VizException e) {
                statusHandler.handle(Priority.PROBLEM, e.getLocalizedMessage(),
                        e);
            }
<<<<<<< HEAD
            return;
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        }
    }

}
