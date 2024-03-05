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
package com.raytheon.uf.viz.xy.varheight.util;

import java.util.HashSet;
import java.util.Set;

<<<<<<< HEAD
=======
import org.locationtech.jts.geom.Coordinate;

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import com.raytheon.uf.viz.core.IDisplayPaneContainer;
import com.raytheon.uf.viz.core.drawables.IRenderableDisplay;
import com.raytheon.uf.viz.core.drawables.ResourcePair;
import com.raytheon.uf.viz.xy.graph.IGraph;
import com.raytheon.uf.viz.xy.graph.XyGraphDescriptor;
import com.raytheon.uf.viz.xy.map.rsc.IGraphableResource;
import com.raytheon.uf.viz.xy.util.AbstractGraphZoomHandler;
import com.raytheon.viz.ui.cmenu.ZoomMenuAction;
import com.raytheon.viz.ui.input.PanHandler;
<<<<<<< HEAD
import org.locationtech.jts.geom.Coordinate;

/**
 * 
 * Zoom handler for var height displays
 * 
 * <pre>
 * 
=======

/**
 *
 * Zoom handler for var height displays
 *
 * <pre>
 *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 * SOFTWARE HISTORY
 * Date         Ticket#    Engineer    Description
 * ------------ ---------- ----------- --------------------------
 * Jul 3, 2010             bsteffen    Initial creation
 * Dec 11, 2013 DR 16795   D. Friedman Transform pixel coordinate for zoom
 * Jun 18, 2014 3242       njensen     Null safety checks
 * Jul 16, 2015 4220       mapeters    Abstract out functionality to AbstractGraphZoomHandler,
 *                                     set this as each zoomed graph's zoomHandler
<<<<<<< HEAD
 * 
 * </pre>
 * 
 * @author bsteffen
 * @version 1.0
=======
 * Jan 04, 2023 8989       mapeters    Handle ZoomMenuAction.ZOOM_LEVELS being made private
 *
 * </pre>
 *
 * @author bsteffen
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 */
public class VarHeightZoomHandler extends AbstractGraphZoomHandler {

    public VarHeightZoomHandler(IRenderableDisplay display) {
        super(display);
    }

    @Override
    protected boolean zoom(String pref, int x, int y) {
        Coordinate grid = translateClick(x, y);

        if (grid == null) {
            return false;
        }

        if (pref.equals(PanHandler.ZOOMOUT_PREF) && zoomIndex > 0) {
            zoomIndex -= 1;
        } else if (pref.equals(PanHandler.ZOOMIN_PREF)
<<<<<<< HEAD
                && zoomIndex < ZoomMenuAction.ZOOM_LEVELS.length - 1) {
=======
                && zoomIndex < ZoomMenuAction.getNumZoomLevels() - 1) {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            zoomIndex += 1;
        } else {
            return true;
        }

        for (IGraph graph : getGraphs()) {
            if (graphContainsCoordinate(graph, grid)) {
                int zoomLevel = (int) Math.pow(2, zoomIndex);
                performZoom(graph, zoomLevel, grid);
                graph.setZoomHandler(this);
            }

        }
        return true;
    }

    private Set<IGraph> getGraphs() {
        Set<IGraph> graphs = new HashSet<>();

        IDisplayPaneContainer editor = display.getContainer();
        XyGraphDescriptor desc = (XyGraphDescriptor) editor
                .getActiveDisplayPane().getDescriptor();
        for (ResourcePair rsc : desc.getResourceList()) {
            if (rsc.getResource() instanceof IGraphableResource<?, ?>) {
<<<<<<< HEAD
                IGraph graph = desc.getGraph((IGraphableResource<?, ?>) rsc
                        .getResource());
=======
                IGraph graph = desc
                        .getGraph((IGraphableResource<?, ?>) rsc.getResource());
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                if (graph != null) {
                    graphs.add(graph);
                }
            }
        }

        return graphs;
    }
}
