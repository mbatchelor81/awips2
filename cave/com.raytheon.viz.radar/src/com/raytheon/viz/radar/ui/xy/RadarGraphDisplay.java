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
package com.raytheon.viz.radar.ui.xy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.swt.graphics.Rectangle;

import com.raytheon.uf.viz.core.IGraphicsTarget;
import com.raytheon.uf.viz.core.IView;
import com.raytheon.uf.viz.core.PixelExtent;
import com.raytheon.uf.viz.core.drawables.PaintProperties;
import com.raytheon.uf.viz.core.drawables.ResourcePair;
import com.raytheon.uf.viz.core.exception.VizException;
import com.raytheon.uf.viz.d2d.ui.AbstractNonMapDisplay;
import com.raytheon.viz.core.graphing.GraphProperties;
import com.raytheon.viz.core.graphing.xy.XYGraph;

/**
 * Display used for radar data that will be displayed on a graph
<<<<<<< HEAD
 * 
 * <pre>
 * 
=======
 *
 * <pre>
 *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 * SOFTWARE HISTORY
 * Date         Ticket#    Engineer    Description
 * ------------ ---------- ----------- --------------------------
 * Mar 19, 2009            askripsk    Initial creation
<<<<<<< HEAD
 * 
 * </pre>
 * 
 * @author askripsk
 * @version 1.0
 */

=======
 * Apr 22, 2022 8791       mapeters    Removed no-op code that threw class cast
 *                                     exc. when switching to multi-panel display
 * Oct 12, 2022 8946       mapeters    Added getScaleType()
 *
 * </pre>
 *
 * @author askripsk
 */
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public class RadarGraphDisplay extends AbstractNonMapDisplay {

    // The area that contains the displayed graphs
    protected XYGraph graphArea;

    public RadarGraphDisplay() {
        super(new PixelExtent(0, 1000, 0, 1000), new RadarGraphDescriptor());
    }

<<<<<<< HEAD
    /*
     * (non-Javadoc)
     * 
     * @see
     * com.raytheon.viz.core.drawables.IRenderable#paint(com.raytheon.viz.core
     * .IGraphicsTarget, com.raytheon.viz.core.drawables.PaintProperties)
     */
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    @Override
    public void paint(IGraphicsTarget target, PaintProperties paintProps)
            throws VizException {
        super.paint(target, paintProps);
        GraphProperties graphProps = new GraphProperties(paintProps);

<<<<<<< HEAD
        // Create the graphs for all of the resources
        if (graphArea == null) {
            if (descriptor.getResourceList().size() > 0) {
                this.initializeGraph((RadarGraphResource) descriptor
                        .getResourceList().get(0).getResource(), graphProps);
            }
        }

=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        // Paint the graphs
        paintSelectedResource(target, graphProps);
    }

    @Override
    public void calcPixelExtent(Rectangle clientArea) {
        IView view = getView();
        int[] dims = getDimensions();
        double[] center = view.getExtent().getCenter();
        double zoomLevel = view.recalcZoomLevel(dims);
        view.scaleToClientArea(clientArea, dims);
        view.zoom(zoomLevel);
        recenter(center);
    }

    private void paintSelectedResource(IGraphicsTarget target,
            GraphProperties graphProps) throws VizException {
        // Plot the resource data on the graph
        for (ResourcePair rp : getDescriptor().getResourceList()) {
            if (rp.getResource() != null) {
                graphProps = (GraphProperties) calcPaintDataTime(graphProps,
                        rp.getResource());
                rp.getResource().paint(target, graphProps);
            }
        }
    }

<<<<<<< HEAD
    private void initializeGraph(RadarGraphResource aRsc,
            GraphProperties graphProps) {
    }

=======
    @Override
    public ScaleType getScaleType() {
        return ScaleType.NONE;
    }
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
}
