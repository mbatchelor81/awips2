/*****************************************************************************************
 * COPYRIGHT (c), 2007, RAYTHEON COMPANY
<<<<<<< HEAD
 * ALL RIGHTS RESERVED, An Unpublished Work 
=======
 * ALL RIGHTS RESERVED, An Unpublished Work
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 *
 * RAYTHEON PROPRIETARY
 * If the end user is not the U.S. Government or any agency thereof, use
 * or disclosure of data contained in this source code file is subject to
 * the proprietary restrictions set forth in the Master Rights File.
 *
 * U.S. GOVERNMENT PURPOSE RIGHTS NOTICE
 * If the end user is the U.S. Government or any agency thereof, this source
 * code is provided to the U.S. Government with Government Purpose Rights.
 * Use or disclosure of data contained in this source code file is subject to
 * the "Government Purpose Rights" restriction in the Master Rights File.
 *
 * U.S. EXPORT CONTROLLED TECHNICAL DATA
 * Use or disclosure of data contained in this source code file is subject to
 * the export restrictions set forth in the Master Rights File.
 ******************************************************************************************/
package com.raytheon.viz.awipstools.ui.layer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.swt.graphics.RGB;
<<<<<<< HEAD
=======
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.LineString;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

import com.raytheon.uf.viz.core.DrawableCircle;
import com.raytheon.uf.viz.core.DrawableLine;
import com.raytheon.uf.viz.core.DrawableString;
import com.raytheon.uf.viz.core.IDisplayPaneContainer;
import com.raytheon.uf.viz.core.IGraphicsTarget;
import com.raytheon.uf.viz.core.IGraphicsTarget.LineStyle;
import com.raytheon.uf.viz.core.drawables.IFont;
import com.raytheon.uf.viz.core.drawables.PaintProperties;
import com.raytheon.uf.viz.core.exception.VizException;
import com.raytheon.uf.viz.core.map.MapDescriptor;
import com.raytheon.uf.viz.core.rsc.AbstractResourceData;
import com.raytheon.uf.viz.core.rsc.AbstractVizResource;
import com.raytheon.uf.viz.core.rsc.IResourceDataChanged;
import com.raytheon.uf.viz.core.rsc.LoadProperties;
import com.raytheon.uf.viz.core.rsc.capabilities.ColorableCapability;
import com.raytheon.uf.viz.core.rsc.capabilities.EditableCapability;
import com.raytheon.uf.viz.core.rsc.capabilities.MagnificationCapability;
import com.raytheon.uf.viz.core.rsc.capabilities.OutlineCapability;
import com.raytheon.uf.viz.core.rsc.tools.GenericToolsResourceData;
<<<<<<< HEAD
import com.raytheon.viz.awipstools.IToolChangedListener;
import com.raytheon.viz.awipstools.ToolsDataManager;
import com.raytheon.viz.ui.cmenu.IContextMenuContributor;
import com.raytheon.viz.ui.cmenu.IContextMenuProvider;
import com.raytheon.viz.ui.input.EditableManager;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.LineString;

/**
 * Interactive baselines tool layer. Based on A1 "Interactive Baselines"
 * 
 * <pre>
 * 
 * SOFTWARE HISTORY
 * 
 * Date         Ticket#    Engineer    Description
 * ------------ ---------- ----------- --------------------------
 * 
 * 
 * </pre>
 * 
 * @author mschenke
 * @version 1.0
 */

public class InteractiveBaselinesLayer extends
        AbstractVizResource<AbstractResourceData, MapDescriptor> implements
        IResourceDataChanged, IToolChangedListener, IContextMenuContributor,
        IContextMenuProvider {
=======
import com.raytheon.viz.awipstools.IBaselineChangedListener;
import com.raytheon.viz.awipstools.ToolsDataManager;
import com.raytheon.viz.ui.UiUtil;
import com.raytheon.viz.ui.cmenu.IContextMenuContributor;
import com.raytheon.viz.ui.cmenu.IContextMenuProvider;
import com.raytheon.viz.ui.input.EditableManager;

/**
 * Interactive baselines tool layer. Based on A1 "Interactive Baselines"
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 *
 * Date          Ticket#  Engineer  Description
 * ------------- -------- --------- -----------------------------
 * May 13, 2021  8451     randerso  Use IBaseLineChangedListener
 * Sep 13, 2022  8792     mapeters  Only handle input events in the pane this
 *                                  layer is in
 *
 * </pre>
 *
 * @author mschenke
 */
public class InteractiveBaselinesLayer
        extends AbstractVizResource<AbstractResourceData, MapDescriptor>
        implements IResourceDataChanged, IBaselineChangedListener,
        IContextMenuContributor, IContextMenuProvider {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    public static class Baseline {
        public LineString line;

        public String name;

        public Baseline(LineString line, String name) {
            this.line = line;
            this.name = name;
        }
    }

<<<<<<< HEAD
    static final int CIRCLE_RADIUS_PIX = 3;
=======
    protected static final int CIRCLE_RADIUS_PIX = 3;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    private static final RGB GRAY = new RGB(175, 175, 175);

    private static final ToolsDataManager dataManager = ToolsDataManager
            .getInstance();

    private IFont font;

    /** The baseline currently in motion */
    private Baseline inMotion = null;

<<<<<<< HEAD
    private Set<String> doNotDraw = new HashSet<String>();
=======
    private Set<String> doNotDraw = new HashSet<>();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    private InteractiveBaselineUIManager manager = new InteractiveBaselineUIManager(
            this);

    /**
     * @param resourceData
     * @param loadProperties
     */
    public InteractiveBaselinesLayer(
            GenericToolsResourceData<InteractiveBaselinesLayer> resourceData,
            LoadProperties loadProperties) {
        super(resourceData, loadProperties);
        getCapability(EditableCapability.class).setEditable(true);
    }

<<<<<<< HEAD
    /*
     * (non-Javadoc)
     * 
     * @see
     * com.raytheon.uf.viz.core.rsc.AbstractVizResource#initInternal(com.raytheon
     * .uf.viz.core.IGraphicsTarget)
     */
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    @Override
    protected void initInternal(IGraphicsTarget target) throws VizException {
        EditableManager.makeEditable(this, isEditable());

        resourceData.addChangeListener(this);
        dataManager.addBaselinesChangedListener(this);

<<<<<<< HEAD
        font = target.getDefaultFont().deriveWithSize(
                target.getDefaultFont().getFontSize());
=======
        font = target.getDefaultFont()
                .deriveWithSize(target.getDefaultFont().getFontSize());
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

        IDisplayPaneContainer container = getResourceContainer();
        if (container != null) {
            container.registerMouseHandler(manager);
        }
    }

<<<<<<< HEAD
    /*
     * (non-Javadoc)
     * 
     * @see
     * com.raytheon.uf.viz.core.rsc.AbstractVizResource#paintInternal(com.raytheon
     * .uf.viz.core.IGraphicsTarget,
     * com.raytheon.uf.viz.core.drawables.PaintProperties)
     */
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    @Override
    protected void paintInternal(IGraphicsTarget target,
            PaintProperties paintProps) throws VizException {
        target.clearClippingPlane();

        try {
            // Get circle radius in screen grid space
            double pixelRatio = paintProps.getView().getExtent().getWidth()
                    / paintProps.getCanvasBounds().width;
            double circleRadius = CIRCLE_RADIUS_PIX * pixelRatio;

            boolean editable = isEditable();

            // Get up our current capabilities
            font.setMagnification(getCapability(MagnificationCapability.class)
                    .getMagnification().floatValue());
            RGB color = getCapability(ColorableCapability.class).getColor();
            LineStyle lineStyle = getCapability(OutlineCapability.class)
                    .getLineStyle();
            float width = getCapability(OutlineCapability.class)
                    .getOutlineWidth();

            Baseline[] baselines = getCurrentBaselines();
<<<<<<< HEAD
            List<DrawableString> strings = new ArrayList<DrawableString>(
                    baselines.length * 2);
            List<DrawableCircle> circles = new ArrayList<DrawableCircle>();
            List<DrawableLine> lines = new ArrayList<DrawableLine>(
                    baselines.length);
=======
            List<DrawableString> strings = new ArrayList<>(
                    baselines.length * 2);
            List<DrawableCircle> circles = new ArrayList<>();
            List<DrawableLine> lines = new ArrayList<>(baselines.length);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

            for (Baseline line : baselines) {
                RGB colorToUse = color;
                float widthToUse = width;
                LineStyle styleToUse = lineStyle;
                if (inMotion != null && line.name.equals(inMotion.name)) {
                    // Change if inMotion line
                    colorToUse = GRAY;
                    widthToUse = Math.max(2.0f, width);
                    styleToUse = LineStyle.SOLID;
                }
<<<<<<< HEAD
                applyBaseline(target, paintProps, lines, circles, strings,
                        line, colorToUse, widthToUse, styleToUse, circleRadius,
=======
                applyBaseline(target, paintProps, lines, circles, strings, line,
                        colorToUse, widthToUse, styleToUse, circleRadius,
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                        editable);
            }

            // We have a line in motion, draw it special!
            if (inMotion != null) {
                applyBaseline(target, paintProps, lines, circles, strings,
                        inMotion, color, 1.0f, LineStyle.DASHED, circleRadius,
                        editable);
            }

            target.drawLine(lines.toArray(new DrawableLine[lines.size()]));
<<<<<<< HEAD
            target.drawCircle(circles.toArray(new DrawableCircle[circles.size()]));
=======
            target.drawCircle(
                    circles.toArray(new DrawableCircle[circles.size()]));
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            target.drawStrings(strings);
        } finally {
            target.setupClippingPlane(paintProps.getClippingPane());
        }
    }

<<<<<<< HEAD
    /*
     * (non-Javadoc)
     * 
     * @see com.raytheon.uf.viz.core.rsc.AbstractVizResource#disposeInternal()
     */
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    @Override
    protected void disposeInternal() {
        resourceData.removeChangeListener(this);
        dataManager.removeBaselinesChangedListener(this);

        if (font != null) {
            font.dispose();
        }

        IDisplayPaneContainer container = getResourceContainer();
        if (container != null) {
            container.unregisterMouseHandler(manager);
        }
    }

    private void applyBaseline(IGraphicsTarget target,
            PaintProperties paintProps, List<DrawableLine> lines,
            List<DrawableCircle> circles, List<DrawableString> strings,
            Baseline baseline, RGB color, float width, LineStyle lineStyle,
            double radius, boolean editable) throws VizException {
        Coordinate[] coords = baseline.line.getCoordinates();
        DrawableLine line = new DrawableLine();
        line.lineStyle = lineStyle;
        line.basics.color = color;
        line.width = width;

        for (int i = 0; i < coords.length; ++i) {
            Coordinate c = coords[i];
            double[] location = descriptor
                    .worldToPixel(new double[] { c.x, c.y });

            // Add point to line
            line.addPoint(location[0], location[1]);

            if (editable) {
                // Create circle for point
                DrawableCircle circle = new DrawableCircle();
                circle.setCoordinates(location[0], location[1], location[2]);
                circle.radius = radius;
                circle.filled = false;
                circle.numberOfPoints = 16;
                circle.basics.color = color;
                circles.add(circle);
            }

            if (i == 0 || i == coords.length - 1) {
                // Get string to draw for first/last point
<<<<<<< HEAD
                String text = baseline.name;
                if (i != 0) {
                    text += "'";
                }
                DrawableString string = new DrawableString(text, color);
=======
                StringBuilder textBuilder = new StringBuilder(baseline.name);
                if (i != 0) {
                    textBuilder.append("'");
                }
                DrawableString string = new DrawableString(
                        textBuilder.toString(), color);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                double[] strPoint = target.getPointOnCircle(location[0],
                        location[1], 0.0, radius, 0.0);
                string.setCoordinates(strPoint[0], strPoint[1]);
                string.font = font;
                strings.add(string);
            }
        }
        lines.add(line);
    }

    /**
<<<<<<< HEAD
     * Check if the resource is currently editable
     * 
     * @return editable
=======
     * Get whether or not this layer is currently interactive, that is, whether
     * or not current mouse/key inputs should interact with it.
     *
     * @return true if interactive, false otherwise
     * @see #isEditable()
     */
    public boolean isInteractive() {
        // Editable, visible, and in the active canvas
        return isEditable() && getProperties().isVisible() && UiUtil
                .isDescriptorActive(descriptor, getResourceContainer());
    }

    /**
     * Get whether this layer's editable capability is toggled on or off.
     *
     * @return true if editable, false otherwise
     * @see #isInteractive()
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    public boolean isEditable() {
        return getCapability(EditableCapability.class).isEditable();
    }

<<<<<<< HEAD
    /*
     * (non-Javadoc)
     * 
     * @see
     * com.raytheon.uf.viz.core.rsc.IResourceDataChanged#resourceChanged(com
     * .raytheon.uf.viz.core.rsc.IResourceDataChanged.ChangeType,
     * java.lang.Object)
     */
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    @Override
    public void resourceChanged(ChangeType type, Object object) {
        issueRefresh();
    }

<<<<<<< HEAD
    /*
     * (non-Javadoc)
     * 
     * @see com.raytheon.viz.awipstools.IToolChangedListener#toolChanged()
     */
    @Override
    public void toolChanged() {
=======
    @Override
    public void baselineChanged(String name, LineString baseline) {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        issueRefresh();
    }

    /**
     * Get an array of the currently available baselines, there may be null
     * entries in the array if a baselines was deleted after all the names were
     * gotten but before it was retrieved or if "Delete Entire Element" was
     * selected
<<<<<<< HEAD
     * 
     * @return
     */
    public Baseline[] getCurrentBaselines() {
        List<String> names = new ArrayList<String>(
                dataManager.getBaselineNames());
        List<Baseline> baselines = new ArrayList<Baseline>(names.size());
        for (int i = 0; i < names.size(); ++i) {
            String name = names.get(i);
            if (doNotDraw.contains(name) == false) {
=======
     *
     * @return
     */
    public Baseline[] getCurrentBaselines() {
        List<String> names = new ArrayList<>(dataManager.getBaselineNames());
        List<Baseline> baselines = new ArrayList<>(names.size());
        for (String name : names) {
            if (!doNotDraw.contains(name)) {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                LineString line = dataManager.getBaseline(name);
                if (line != null && line.getNumPoints() > 1) {
                    baselines.add(new Baseline(line, name));
                }
            }
        }
        return baselines.toArray(new Baseline[baselines.size()]);
    }

    /**
     * Get the baseline in motion
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @return
     */
    public Baseline getLineInMotion() {
        return inMotion;
    }

    /**
     * Set the baseline in motion
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param inMotion
     */
    public void setLineInMotion(Baseline inMotion) {
        this.inMotion = inMotion;
    }

    /**
     * Mark a baseline to not be drawn anymore
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param baseline
     */
    public void doNotDraw(String baseline) {
        doNotDraw.add(baseline);
    }

<<<<<<< HEAD
    /*
     * (non-Javadoc)
     * 
     * @see
     * com.raytheon.viz.ui.cmenu.IContextMenuProvider#provideContextMenuItems
     * (org.eclipse.jface.action.IMenuManager, int, int)
     */
    @Override
    public void provideContextMenuItems(IMenuManager menuManager, int x, int y) {
        manager.provideContextMenuItems(menuManager, x, y);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.raytheon.viz.ui.cmenu.IContextMenuContributor#addContextMenuItems
     * (org.eclipse.jface.action.IMenuManager, int, int)
     */
=======
    @Override
    public void provideContextMenuItems(IMenuManager menuManager, int x,
            int y) {
        manager.provideContextMenuItems(menuManager, x, y);
    }

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    @Override
    public void addContextMenuItems(IMenuManager menuManager, int x, int y) {
        manager.addContextMenuItems(menuManager, x, y);
    }
}
