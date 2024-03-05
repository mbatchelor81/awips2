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
package com.raytheon.uf.viz.xy.graph;

import java.util.List;

<<<<<<< HEAD
=======
import org.locationtech.jts.geom.Coordinate;

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import com.raytheon.uf.viz.core.IExtent;
import com.raytheon.uf.viz.core.drawables.IRenderable;
import com.raytheon.uf.viz.xy.map.rsc.IGraphableResource;
import com.raytheon.uf.viz.xy.util.AbstractGraphZoomHandler;
<<<<<<< HEAD
import org.locationtech.jts.geom.Coordinate;

/**
 * Interface for a graphing object
 * 
 * <pre>
 * 
=======

/**
 * Interface for a graphing object
 *
 * <pre>
 *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 * SOFTWARE HISTORY
 * Date         Ticket#    Engineer    Description
 * ------------ ---------- ----------- --------------------------
 * Sep 29, 2009            mschenke     Initial creation
 * Feb 10, 2011 8244       bkowal       Keep track of the current
 *                                      magnification settings.
 * Jul 21, 2015 4220       mapeters     Added getZoomHandler/setZoomHandler
<<<<<<< HEAD
 * 
 * </pre>
 * 
 * @author mschenke
 * @version 1.0
 */

=======
 * Apr 22, 2022 8791       mapeters     Added setDescriptor()
 *
 * </pre>
 *
 * @author mschenke
 */
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
public interface IGraph extends IRenderable {

    /**
     * Plot an x,y value on the graph to actual screen location
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param x
     *            the x value, ie time, distance, etc
     * @param y
     *            the y value, similar to x but y
     * @return
     */
<<<<<<< HEAD
    public double[] getGridLocation(double x, double y);

    /**
     * Plot a grid coordinate to graph value
     * 
=======
    double[] getGridLocation(double x, double y);

    /**
     * Plot a grid coordinate to graph value
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param x
     * @param y
     * @return
     */
<<<<<<< HEAD
    public double[] getVirtualLocation(double x, double y);

    /**
     * Update the graphs extent, should only be called by the graph resource
     * 
     * @param extent
     *            the new graph extent
     */
    public void updateExtent(IExtent extent);

    /**
     * Update the graphs virtual extent
     * 
     * @param extent
     */
    public void updateVirtualExtent();

    /**
     * Add a graphable resource to the graph
     * 
     * @param rsc
     *            the graphable resource to add
     */
    public void addGraphResource(IGraphableResource<?, ?> rsc);

    /**
     * Remove the graph resource from the graph
     * 
     * @param rsc
     */
    public void removeGraphResource(IGraphableResource<?, ?> rsc);

    /**
     * Return the extent of the graph, a subset of the display's extent
     * 
     * @return the graph's extent
     */
    public IExtent getExtent();
=======
    double[] getVirtualLocation(double x, double y);

    /**
     * Update the graphs extent, should only be called by the graph resource
     *
     * @param extent
     *            the new graph extent
     */
    void updateExtent(IExtent extent);

    /**
     * Update the graphs virtual extent
     *
     * @param extent
     */
    void updateVirtualExtent();

    /**
     * Add a graphable resource to the graph
     *
     * @param rsc
     *            the graphable resource to add
     */
    void addGraphResource(IGraphableResource<?, ?> rsc);

    /**
     * Remove the graph resource from the graph
     *
     * @param rsc
     */
    void removeGraphResource(IGraphableResource<?, ?> rsc);

    /**
     * Return the extent of the graph, a subset of the display's extent
     *
     * @return the graph's extent
     */
    IExtent getExtent();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * Tells whether the graph is ready to be plotted to yet, use this method in
     * the resoures paint method to determine if execution should continue or
     * not. Currently a hack to make sure the resources are waiting for their
     * graphs to be constructed before attempting to plot to them
<<<<<<< HEAD
     * 
     * @return if the graph is ready
     */
    public boolean isReady();

    /**
     * Get the number of resources loaded in the graph
     * 
     * @return
     */
    public int getResourceCount();

    /**
     * check to see if the graph is being drawn or not
     * 
     * @return true if drawn, false if not
     */
    public boolean isDisplayed();

    /**
     * Set if the graph should be drawn or not
     * 
     * @param displayed
     */
    public void setDisplayed(boolean displayed);

    /**
     * Zoom in the graph, 0 indexed
     * 
     * @param index
     */
    public void zoom(int index, Coordinate gridCoord);

    /**
     * Pan to the given extent
     * 
     * @param panToExtent
     */
    public void pan(double xDist, double yDist, boolean panning);

    /**
     * Get the loaded resources on the graph
     * 
     * @return
     */
    public List<?> getResources();
=======
     *
     * @return if the graph is ready
     */
    boolean isReady();

    /**
     * Get the number of resources loaded in the graph
     *
     * @return
     */
    int getResourceCount();

    /**
     * check to see if the graph is being drawn or not
     *
     * @return true if drawn, false if not
     */
    boolean isDisplayed();

    /**
     * Set if the graph should be drawn or not
     *
     * @param displayed
     */
    void setDisplayed(boolean displayed);

    /**
     * Zoom in the graph, 0 indexed
     *
     * @param index
     */
    void zoom(int index, Coordinate gridCoord);

    /**
     * Pan to the given extent
     *
     * @param panToExtent
     */
    void pan(double xDist, double yDist, boolean panning);

    /**
     * Get the loaded resources on the graph
     *
     * @return
     */
    List<?> getResources();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * Dispose of the graph
     */
<<<<<<< HEAD
    public void dispose();
=======
    void dispose();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * Reconstructs the graph
     */
<<<<<<< HEAD
    public void reconstruct();

    public void setCurrentMagnification(Double currentMagnification);

    public AbstractGraphZoomHandler getZoomHandler();

    public void setZoomHandler(AbstractGraphZoomHandler zoomHandler);
=======
    void reconstruct();

    void setCurrentMagnification(Double currentMagnification);

    AbstractGraphZoomHandler getZoomHandler();

    void setZoomHandler(AbstractGraphZoomHandler zoomHandler);

    void setDescriptor(XyGraphDescriptor descriptor);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
}