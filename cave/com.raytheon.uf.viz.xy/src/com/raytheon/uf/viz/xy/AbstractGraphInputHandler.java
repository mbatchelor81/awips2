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
package com.raytheon.uf.viz.xy;

<<<<<<< HEAD
import com.raytheon.uf.viz.core.drawables.IRenderableDisplay;
import com.raytheon.uf.viz.xy.graph.IGraph;
import com.raytheon.viz.ui.input.InputAdapter;
import org.locationtech.jts.geom.Coordinate;
=======
import org.locationtech.jts.geom.Coordinate;

import com.raytheon.uf.viz.core.drawables.IRenderableDisplay;
import com.raytheon.uf.viz.xy.graph.IGraph;
import com.raytheon.viz.ui.UiUtil;
import com.raytheon.viz.ui.input.InputAdapter;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

/**
 * Abstract class for graph input handlers, get constructed at the editor level
 * since each graph type has their own editor currently
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
 * Oct 01, 2009            mschenke    Initial creation
 * Jun 14, 2014 3242       njensen     Added graphContainsCoordinate()
<<<<<<< HEAD
 * 
 * </pre>
 * 
 * @author mschenke
 * @version 1.0
 */

=======
 * Sep 12, 2022 8792       mapeters    Added isTargetDescriptorTypeActive()
 *
 * </pre>
 *
 * @author mschenke
 */
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
public abstract class AbstractGraphInputHandler extends InputAdapter {

    protected IRenderableDisplay display;

    public AbstractGraphInputHandler(IRenderableDisplay display) {
        this.display = display;
    }

    public IRenderableDisplay getRenderableDisplay() {
        return display;
    }

    public void setRenderableDisplay(IRenderableDisplay display) {
        this.display = display;
    }

    /**
     * Checks whether or not the coordinate is in the extent of a graph
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param graph
     * @param coord
     * @return
     */
    protected boolean graphContainsCoordinate(IGraph graph, Coordinate coord) {
        return (graph != null && graph.getExtent() != null && graph.getExtent()
                .contains(new double[] { coord.x, coord.y }));
    }
<<<<<<< HEAD
=======

    /**
     * Determine if the active descriptor is the type of descriptor that this
     * handler is supposed to handle events for.
     *
     * @return true if target descriptor type is active, false otherwise
     */
    protected boolean isTargetDescriptorTypeActive() {
        return UiUtil.isDescriptorCompatibleWithActive(display.getDescriptor(),
                display.getContainer());
    }
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
}
