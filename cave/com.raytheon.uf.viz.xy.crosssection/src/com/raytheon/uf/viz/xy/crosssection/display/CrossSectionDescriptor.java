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
package com.raytheon.uf.viz.xy.crosssection.display;

<<<<<<< HEAD
=======
import java.util.ArrayList;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

<<<<<<< HEAD
=======
import org.eclipse.jface.action.IMenuManager;
import org.locationtech.jts.geom.LineString;

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import com.raytheon.uf.common.geospatial.adapter.GeometryAdapter;
import com.raytheon.uf.common.time.DataTime;
import com.raytheon.uf.viz.core.PixelExtent;
import com.raytheon.uf.viz.core.drawables.IDescriptor;
import com.raytheon.uf.viz.core.drawables.ResourcePair;
import com.raytheon.uf.viz.core.rsc.AbstractVizResource;
import com.raytheon.uf.viz.d2d.core.procedures.IBaseLinesContainer;
import com.raytheon.uf.viz.xy.crosssection.graph.CrossSectionGraph;
import com.raytheon.uf.viz.xy.crosssection.rsc.AbstractCrossSectionResource;
<<<<<<< HEAD
=======
import com.raytheon.uf.viz.xy.crosssection.rsc.UpdateBaselineAction;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import com.raytheon.uf.viz.xy.graph.IGraph;
import com.raytheon.uf.viz.xy.graph.XyGraphDescriptor;
import com.raytheon.uf.viz.xy.map.rsc.IGraphableResource;
import com.raytheon.uf.viz.xy.scales.HeightScale;
<<<<<<< HEAD
import org.locationtech.jts.geom.LineString;

/**
 * An IDescriptor for cross sections
 * 
 * <pre>
 * 
 * SOFTWARE HISTORY
 * Date         Ticket#    Engineer    Description
 * ------------ ---------- ----------- --------------------------
 * Jun 28, 2010            bsteffen    Initial creation
 * Jul 22, 2015  4669      njensen     Fixed isCompatible()
 * 
 * </pre>
 * 
 * @author bsteffen
 * @version 1.0
 */

@XmlAccessorType(XmlAccessType.NONE)
public class CrossSectionDescriptor extends XyGraphDescriptor implements
        IBaseLinesContainer {

    public static final String LINE_PREFIX = "Line";
=======
import com.raytheon.viz.awipstools.ToolsDataManager;
import com.raytheon.viz.ui.cmenu.AbstractRightClickAction;
import com.raytheon.viz.ui.cmenu.IContextMenuContributor;

/**
 * An IDescriptor for cross sections
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 *
 * Date          Ticket#  Engineer  Description
 * ------------- -------- --------- --------------------------------------------
 * Jun 28, 2010           bsteffen  Initial creation
 * Jul 22, 2015  4669     njensen   Fixed isCompatible()
 * May 17, 2021  8452     randerso  Changed getBaseline() to return value set by
 *                                  setBaseline(). Added updateBaseline().
 * Apr 25, 2022  8791     mapeters  Update getCurrentLine() to prevent NPE with
 *                                  new combo editor
 * Oct 29, 2022  8959     mapeters  Add getLevelType()
 * Nov 02, 2022  8958     mapeters  Determine lines in setLineID for baselines
 *
 * </pre>
 *
 * @author bsteffen
 */
@XmlAccessorType(XmlAccessType.NONE)
public class CrossSectionDescriptor extends XyGraphDescriptor
        implements IBaseLinesContainer, IContextMenuContributor {

    private static final String LINE_PREFIX = "Line";
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    @XmlElement
    private HeightScale heightScale;

    @XmlJavaTypeAdapter(value = GeometryAdapter.class)
    @XmlElement(name = "line")
    private List<LineString> lines;

<<<<<<< HEAD
    @XmlAttribute
=======
    /*
     * XML annotation on lineID setter down below so that the setter gets called
     * during unmarshalling to update lines if need be.
     */
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    private String lineID;

    public CrossSectionDescriptor() {
        super();
    }

    /**
     * Constructor
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param pixelExtent
     */
    public CrossSectionDescriptor(PixelExtent pixelExtent) {
        super(pixelExtent);
    }

    @Override
    public IGraph constructGraph() {
        return new CrossSectionGraph(this);
    }

    /**
     * @return the heightScale
     */
    public HeightScale getHeightScale() {
        return heightScale;
    }

    /**
     * @param heightScale
     *            the heightScale to set
     */
    public void setHeightScale(HeightScale heightScale) {
        if (heightScale != this.heightScale) {
            this.heightScale = heightScale;
            for (ResourcePair rp : this.resourceList) {
                AbstractVizResource<?, ?> rsc = rp.getResource();
                if (rsc instanceof IGraphableResource<?, ?>) {
                    this.getGraph((IGraphableResource<?, ?>) rsc).reconstruct();
                    if (rsc instanceof AbstractCrossSectionResource) {
                        ((AbstractCrossSectionResource) rsc)
                                .setDescriptor(this);
                    }
                }
            }
            if (renderableDisplay != null) {
                ((CrossSectionRenderableDisplay) renderableDisplay)
                        .setTabTitle(getTitle());
            }
        }
    }

    public String getTitle() {
        if (lineID == null && heightScale == null) {
            return "Cross Section";
        } else if (lineID == null) {
            return String.format("Cross Section : %s", heightScale.getName());
        } else if (heightScale == null) {
            return String.format("Cross Section @ %s", lineID);
        } else {
            return String.format("Cross Section @ %s : %s", lineID,
                    heightScale.getName());
        }
    }

    /**
     * @return the lines
     */
    public List<LineString> getLines() {
        return lines;
    }

    /**
     * @param lines
     *            the lines to set
     */
    public void setLines(List<LineString> lines) {
        this.lines = lines;
    }

    /**
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @return the line
     */
    public LineString getLine(DataTime time) {
        return lines.get(time.getLevelValue().intValue());
    }

    public LineString getCurrentLine() {
        FramesInfo info = getFramesInfo();
<<<<<<< HEAD
        int index = info.getFrameIndex();
        DataTime[] frames = info.getFrameTimes();
        if (frames == null || index < 0 || index >= frames.length) {
            return null;
        }
        return lines.get(frames[index].getLevelValue().intValue());
=======
        List<AbstractVizResource<?, ?>> csRscs = getResourceList()
                .getResourcesByType(AbstractCrossSectionResource.class);

        DataTime time = null;
        for (AbstractVizResource<?, ?> csRsc : csRscs) {
            time = info.getTimeForResource(csRsc);
            if (time != null) {
                break;
            }
        }

        if (time == null) {
            return null;
        }
        return lines.get(time.getLevelValue().intValue());
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * @return the lineID
     */
    public String getLineID() {
        return lineID;
    }

    /**
<<<<<<< HEAD
     * @param lineID
     *            the lineID to set
     */
    public void setLineID(String lineID) {
        this.lineID = lineID;
=======
     * Get the level type of the cross section, for setting on its data times.
     *
     * @return the level type
     */
    public String getLevelType() {
        /*
         * Line ID doesn't make the most sense as the level type, but the level
         * values aren't very meaningful either since they are just line
         * indices. This at least prevents All Lats and All Lons from being
         * spatially matched with each other.
         */
        return getLineID();
    }

    /**
     * @param lineID
     *            the lineID to set
     */
    @XmlAttribute
    public void setLineID(String lineID) {
        this.lineID = lineID;
        if (lineID.startsWith(LINE_PREFIX) && lines == null
                || lines.isEmpty()) {
            // This is specifically for XML unmarshalling
            ToolsDataManager dataManager = ToolsDataManager.getInstance();
            LineString line = dataManager.getBaseline(getBaseLine());
            if (line != null) {
                List<LineString> lines = new ArrayList<>();
                lines.add(line);
                this.lines = lines;
            }
        }
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        if (renderableDisplay != null) {
            ((CrossSectionRenderableDisplay) renderableDisplay)
                    .setTabTitle(getTitle());
        }
    }

    @Override
    public boolean isCompatible(IDescriptor other) {
        if (other instanceof CrossSectionDescriptor) {
            CrossSectionDescriptor csOther = (CrossSectionDescriptor) other;
            if (!csOther.lines.equals(this.lines)) {
                return false;
            }
            return csOther.heightScale.equals(this.heightScale);
        }
        return false;
    }

    @Override
    public void setBaseLine(String baseLine) {
        setLineID(LINE_PREFIX + baseLine);
    }

    @Override
    public void setBaseLineString(LineString baseLineString) {
        setLines(Arrays.asList(baseLineString));
    }

    @Override
    public String getBaseLine() {
<<<<<<< HEAD
        return getLineID();
    }

=======
        String lineName = getLineID();
        if (lineName.startsWith(LINE_PREFIX)) {
            lineName = lineName.substring(LINE_PREFIX.length());
        }
        return lineName;
    }

    @Override
    public void addContextMenuItems(IMenuManager menuManager, int x, int y) {
        AbstractRightClickAction action = new UpdateBaselineAction();
        action.setContainer(getRenderableDisplay().getContainer());
        menuManager.add(action);
    }
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
}
