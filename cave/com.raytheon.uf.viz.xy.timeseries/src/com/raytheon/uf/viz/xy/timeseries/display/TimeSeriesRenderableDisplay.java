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
package com.raytheon.uf.viz.xy.timeseries.display;

import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

<<<<<<< HEAD
import com.raytheon.uf.common.status.IUFStatusHandler;
import com.raytheon.uf.common.status.UFStatus;
import com.raytheon.uf.common.status.UFStatus.Priority;
import com.raytheon.uf.viz.core.PixelExtent;
import com.raytheon.uf.viz.core.VizConstants;
import com.raytheon.uf.viz.core.drawables.ResourcePair;
import com.raytheon.uf.viz.core.exception.VizException;
=======
import com.raytheon.uf.viz.core.PixelExtent;
import com.raytheon.uf.viz.core.VizConstants;
import com.raytheon.uf.viz.core.drawables.ResourcePair;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import com.raytheon.uf.viz.core.rsc.LoadProperties;
import com.raytheon.uf.viz.core.rsc.ResourceList;
import com.raytheon.uf.viz.core.rsc.ResourceProperties;
import com.raytheon.uf.viz.d2d.ui.AbstractNonMapDisplay;
<<<<<<< HEAD
import com.raytheon.uf.viz.xy.map.rsc.GraphResource;
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import com.raytheon.uf.viz.xy.map.rsc.GraphResourceData;
import com.raytheon.uf.viz.xy.map.rsc.GraphResourceData.OverlayMode;

/**
 * Time series renderable display, plugs in the time series graph factory,
 * descriptor and sets the graph resource
<<<<<<< HEAD
 * 
 * <pre>
 * 
 * SOFTWARE HISTORY
 * Date         Ticket#    Engineer    Description
 * ------------ ---------- ----------- --------------------------
 * Oct 16, 2009            mschenke     Initial creation
 * 
 * </pre>
 * 
 * @author mschenke
 * @version 1.0
=======
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 * Date         Ticket#    Engineer    Description
 * ------------ ---------- ----------- --------------------------
 * Oct 16, 2009            mschenke    Initial creation
 * Oct 12, 2022 8946       mapeters    Add getScaleType()
 * Dec 20, 2023 2036519    mapeters    Don't construct the graph resource in
 *                                     customizeResourceList()
 *
 * </pre>
 *
 * @author mschenke
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public class TimeSeriesRenderableDisplay extends AbstractNonMapDisplay {
<<<<<<< HEAD
    private static final transient IUFStatusHandler statusHandler = UFStatus
            .getHandler(TimeSeriesRenderableDisplay.class);
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    public TimeSeriesRenderableDisplay() {
        this(new PixelExtent(0, 1000, 0, 1000));
    }

    public TimeSeriesRenderableDisplay(PixelExtent aPixelExtent) {
        super(aPixelExtent, new TimeSeriesDescriptor(aPixelExtent));
    }

    @Override
    public TimeSeriesDescriptor getDescriptor() {
        return (TimeSeriesDescriptor) super.getDescriptor();
    }

    @Override
    protected void customizeResourceList(ResourceList resourceList) {
        super.customizeResourceList(resourceList);

        // Add time series graph resource
        GraphResourceData grd = new GraphResourceData("Time series background");
<<<<<<< HEAD
        GraphResource gr = null;
        LoadProperties lprops = new LoadProperties();
        ResourceProperties rprops = new ResourceProperties();
        rprops.setMapLayer(true);
        try {
            gr = grd.construct(lprops, getDescriptor());
            grd.setOverlayMode(OverlayMode.VERTICAL);
            ResourcePair rp = new ResourcePair();
            rp.setResourceData(grd);
            rp.setResource(gr);
            rp.setProperties(rprops);
            rp.setLoadProperties(lprops);
            resourceList.add(rp);
        } catch (VizException e) {
            statusHandler.handle(Priority.PROBLEM,
                    "Error constructing time series Graph", e);
        }
=======
        LoadProperties lprops = new LoadProperties();
        ResourceProperties rprops = new ResourceProperties();
        rprops.setMapLayer(true);
        grd.setOverlayMode(OverlayMode.VERTICAL);
        ResourcePair rp = new ResourcePair();
        rp.setResourceData(grd);
        rp.setProperties(rprops);
        rp.setLoadProperties(lprops);
        resourceList.add(rp);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    @Override
    public Map<String, Object> getGlobalsMap() {
        Map<String, Object> globals = super.getGlobalsMap();
<<<<<<< HEAD
        if (globals
                .get(VizConstants.FRAMES_ID)
                .equals(TimeSeriesDescriptor.REAL_FRAME_COUNT_TO_USE_WHEN_FRAME_COUNT_IS_ONE)) {
=======
        if (globals.get(VizConstants.FRAMES_ID).equals(
                TimeSeriesDescriptor.REAL_FRAME_COUNT_TO_USE_WHEN_FRAME_COUNT_IS_ONE)) {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            globals.put(VizConstants.FRAMES_ID, 1);
        }
        return globals;
    }

<<<<<<< HEAD
=======
    @Override
    public ScaleType getScaleType() {
        return ScaleType.NONE;
    }
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
}
