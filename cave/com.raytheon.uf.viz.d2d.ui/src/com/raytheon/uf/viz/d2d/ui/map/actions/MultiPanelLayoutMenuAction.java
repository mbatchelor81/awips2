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
package com.raytheon.uf.viz.d2d.ui.map.actions;

import java.util.List;

import com.raytheon.uf.viz.core.IDisplayPane;
import com.raytheon.uf.viz.core.drawables.IRenderableDisplay;
import com.raytheon.uf.viz.d2d.core.ID2DRenderableDisplay;
import com.raytheon.uf.viz.d2d.core.legend.D2DLegendResource;
import com.raytheon.uf.viz.d2d.core.legend.D2DLegendResource.LegendMode;
<<<<<<< HEAD
=======
import com.raytheon.viz.ui.UiUtil;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import com.raytheon.viz.ui.cmenu.AbstractRightClickAction;
import com.raytheon.viz.ui.editor.IMultiPaneEditor;

/**
 * Switch to a Multi Panel layout in the editor pane. There are two variations
 * of the switch. First, when there was a prior multi panel layout and the user
 * selected rotate panes. In this case, the other panes are preserved and will
 * be redisplayed in a four panel layout. The second when only viewing a multi
 * panel, and the user selects another multi panel layout. In this case, panes
 * are added/deleted as needed.
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 *
<<<<<<< HEAD
 * Date            Ticket#     Engineer      Description
 * ------------    ----------  -----------   --------------------------
 * Feb 13, 2020    74164       ksunil        Initial Creation. Borrowed from
 *                                            FourPanelLayoutMenuAction
 * Dec 21, 2020    86204       Robert.Blum   Added support for any number of panes.
=======
 * Date          Ticket#  Engineer     Description
 * ------------- -------- ------------ -----------------------------------------
 * Feb 13, 2020  74164    ksunil       Initial Creation. Borrowed from
 *                                     FourPanelLayoutMenuAction
 * Sep 03, 2020  79555    tjensen      Fix focus errors when swapping between
 *                                     panel layouts
 * Dec 21, 2020  86204    Robert.Blum  Added support for any number of panes.
 * May 11, 2023  2029803  mapeters     Support horizontal panel layouts
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 *
 * </pre>
 *
 * @author ksunil
 */
public class MultiPanelLayoutMenuAction extends AbstractRightClickAction {

<<<<<<< HEAD
    private int numPanes;

    /**
     * Default constructor.
     */

    public MultiPanelLayoutMenuAction(int numPanes) {
        super(numPanes + " Panel Layout");
        this.numPanes = numPanes;
=======
    private final int numPanes;

    private final boolean horizontal;

    /**
     * Constructor.
     *
     * @param numPanes
     *            number of panels in the layout
     * @param horizontal
     *            true for horizontal panel layout, false for vertical
     */
    public MultiPanelLayoutMenuAction(int numPanes, boolean horizontal) {
        super(generateName(numPanes, horizontal));
        this.numPanes = numPanes;
        this.horizontal = horizontal;
    }

    private static String generateName(int numPanes, boolean horizontal) {
        // Generate something like "4 Panel Layout" or "2 Panel Layout (1x2)"
        StringBuilder name = new StringBuilder().append(numPanes)
                .append(" Panel Layout");
        int[] rowsColumns = UiUtil.getNumRowsColumns(numPanes, horizontal);
        int rows = rowsColumns[0];
        int columns = rowsColumns[1];
        if (rows != columns) {
            name.append(" (").append(columns).append("x").append(rows)
                    .append(")");
        }
        return name.toString();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    @Override
    public void run() {

<<<<<<< HEAD
        if (getContainer() instanceof IMultiPaneEditor == false
                || getContainer().getDisplayPanes()[0]
                        .getRenderableDisplay() instanceof ID2DRenderableDisplay == false) {
=======
        if (!(getContainer() instanceof IMultiPaneEditor)
                || !(getContainer().getDisplayPanes()[0]
                        .getRenderableDisplay() instanceof ID2DRenderableDisplay)) {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            return;
        }
        IMultiPaneEditor editor = (IMultiPaneEditor) getContainer();
        IRenderableDisplay definiteDisplay = getContainer().getDisplayPanes()[0]
                .getRenderableDisplay();

<<<<<<< HEAD
=======
        editor.setHorizontalLayout(horizontal);

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        IDisplayPane[] currentPanes = getContainer().getDisplayPanes();
        // go from "n" panels to "n++"
        if (currentPanes.length < numPanes) {
            for (IDisplayPane pane : getContainer().getDisplayPanes()) {
                editor.showPane(pane);
            }
            for (int i = currentPanes.length; i < numPanes; ++i) {
                editor.addPane(definiteDisplay.createNewDisplay());
            }
            // go from "n" panels to "n--"
        } else if (currentPanes.length > numPanes) {
            for (int i = numPanes; i < currentPanes.length; ++i) {
                editor.removePane(currentPanes[i]);
            }
<<<<<<< HEAD
        } else if (currentPanes.length == numPanes) {
            for (IDisplayPane pane : getContainer().getDisplayPanes()) {
                editor.showPane(pane);
            }
=======
        }

        // When switching number of panes in layout, show all panes.
        for (IDisplayPane pane : getContainer().getDisplayPanes()) {
            editor.showPane(pane);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        }

        for (IDisplayPane pane : editor.getDisplayPanes()) {
            List<D2DLegendResource> rscs = pane.getDescriptor()
                    .getResourceList()
                    .getResourcesByTypeAsType(D2DLegendResource.class);
            for (D2DLegendResource rsc : rscs) {
                rsc.setLegendMode(LegendMode.PRODUCT);
            }
        }
        editor.setSelectedPane(IMultiPaneEditor.IMAGE_ACTION, null);
        editor.setSelectedPane(IMultiPaneEditor.VISIBLE_PANE, null);
        editor.setSelectedPane(IMultiPaneEditor.LOAD_ACTION, null);

        editor.refresh();

    }
}
