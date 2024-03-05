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
package com.raytheon.uf.viz.d2d.ui.map.actions;

<<<<<<< HEAD
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
=======
import java.util.ArrayList;
import java.util.List;

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import com.raytheon.uf.viz.core.IDisplayPane;
import com.raytheon.uf.viz.core.IDisplayPaneContainer;
<<<<<<< HEAD
import com.raytheon.uf.viz.core.drawables.ResourcePair;
import com.raytheon.uf.viz.core.rsc.capabilities.BlendableCapability;
import com.raytheon.uf.viz.d2d.core.legend.D2DLegendResource;
import com.raytheon.uf.viz.xy.VizXyEditor;
import com.raytheon.viz.ui.EditorUtil;
import com.raytheon.viz.ui.actions.MultiPanes;
=======
import com.raytheon.uf.viz.core.IPane.CanvasType;
import com.raytheon.uf.viz.core.drawables.ResourcePair;
import com.raytheon.uf.viz.core.rsc.capabilities.BlendableCapability;
import com.raytheon.uf.viz.d2d.core.legend.D2DLegendResource;
import com.raytheon.viz.ui.EditorUtil;
import com.raytheon.viz.ui.UiUtil;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import com.raytheon.viz.ui.editor.IMultiPaneEditor;
import com.raytheon.viz.ui.tools.AbstractTool;

/**
<<<<<<< HEAD
 * 
 * Contains logic for rotating panels
 * 
 * <pre>
 * 
 * SOFTWARE HISTORY
 * 
=======
 *
 * Contains logic for rotating panels
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 * Date         Ticket#    Engineer    Description
 * ------------ ---------- ----------- --------------------------
 * Jan 30, 2013            mschenke    Initial creation
 * Feb 19, 2018 7060       njensen     Don't rotate on inset maps
<<<<<<< HEAD
 * 
 * </pre>
 * 
=======
 * Feb 13, 2020 74164      ksunil      2, 9 and 16 panel support
 * May 10, 2020 78468      ksunil      Map ALT+Ctrl+(0-6) keys for 16 panel setup.
 * May 11, 2023 2029803    mapeters    Support additional panel counts
 *
 * </pre>
 *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 * @author mschenke
 */
public class RotatePanelsHandler extends AbstractTool {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        IDisplayPaneContainer container = EditorUtil.getActiveVizContainer();
<<<<<<< HEAD
        if (container == null || !(container instanceof IMultiPaneEditor)) {
            return null;
        }

        // Get editor and panes
        IMultiPaneEditor editor = (IMultiPaneEditor) container;
        IDisplayPane[] panes = getEditorPanes(editor);
        int numOfPanes = panes.length;

        if (editor instanceof VizXyEditor) {
            VizXyEditor xyEditor = (VizXyEditor) editor;
            IDisplayPane active = xyEditor.getActiveDisplayPane();
            IDisplayPane[] insets = xyEditor.getInsetPanes();
            for (IDisplayPane inset : insets) {
                if (inset == active) {
                    // it's an inset pane, ignore the rotate command
                    return null;
                }
            }
        }

=======
        if (!(container instanceof IMultiPaneEditor)) {
            return null;
        }

        IMultiPaneEditor editor = (IMultiPaneEditor) container;

        if (editor.getActiveDisplayPane().getType() != CanvasType.MAIN) {
            // Ignore the rotate command for inset canvases
            return null;
        }

        IDisplayPane[] panes = getCanvasesInRotationOrder(editor);
        int numPanes = panes.length;

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        // Get direction to rotate
        String dirStr = event.getParameter("direction");
        int direction = Integer.parseInt(dirStr);

        Integer hideIndex = null;
        String hideIndexStr = event.getParameter("hideIndex");
        if (hideIndexStr != null) {
            hideIndex = Integer.parseInt(hideIndexStr);
        }

        // Get pane to start rotation on
        IDisplayPane startPane = null;
        String startStr = event.getParameter("startIndex");
        if (startStr != null) {
            int startIdx = Integer.parseInt(startStr);

<<<<<<< HEAD
            // Adjust the startIndex for 2, 9 and 16 panels. These panels do not
            // honor left/right as the (already existing code for) 4 panels.
            // Which means direction and hideIndex
            // are always 1.

            // we can safely access the key pressed. It will map to 0..9
            org.eclipse.swt.widgets.Event ev = (org.eclipse.swt.widgets.Event) event
                    .getTrigger();
            int keyPressed = Character.getNumericValue(ev.character);

            if (numOfPanes != MultiPanes.Four.numPanes()) {
=======
            // we can safely access the key pressed. It will map to 0..9
            org.eclipse.swt.widgets.Event ev = (org.eclipse.swt.widgets.Event) event
                    .getTrigger();

            int keyPressed = Character.getNumericValue(ev.character);

            /*
             * sixteenPanelKey is available only in the bindings for 10-16 panel
             * rotation setup.
             */
            String ten2sixteen = event.getParameter("sixteenPanelKey");
            if (ten2sixteen != null) {
                keyPressed = Integer.parseInt(ten2sixteen);
            }

            /*
             * Adjust values for non-4 panel layouts. These panels do not honor
             * left/right as the (already existing code for) 4 panels. Which
             * means direction and hideIndex are always 1.
             */
            if (numPanes != 4) {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                direction = 1;
                if (hideIndex != null) {
                    hideIndex = 1;
                }
            }

<<<<<<< HEAD
            // Now do some startIdx correction for 2, 9 and 16 panels.
            switch (numOfPanes) {
=======
            // Now do some startIdx correction
            switch (numPanes) {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            case 2:
                startIdx = keyPressed % 2;
                break;
            case 4:
                if (keyPressed == 9) {
                    startIdx = 3;
                }
                break;
<<<<<<< HEAD
            case 9:
                if (keyPressed == 1) {
                    startIdx = 8;
                } else {
                    startIdx = keyPressed - 2;
                }
                break;
            case 16:
                if (keyPressed == 1) {
                    startIdx = 15;
                } else {
                    startIdx = keyPressed - 2;
                }
                break;
            default:
                break;
=======
            default:
                if (keyPressed == 1) {
                    /*
                     * Last pane so that rotating forward gets us to the 1st
                     * pane.
                     */
                    startIdx = numPanes - 1;
                } else {
                    /*
                     * -1 to convert to 0-based, and another -1 to get the pane
                     * before so that rotating forward gets us to the desired
                     * pane.
                     */
                    startIdx = keyPressed - 2;
                }
                break;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            }

            if (editor.displayedPaneCount() > 1) {
                // more than one pane so we want to start on resulting pane
                startPane = panes[getNextIndex(panes, startIdx, direction)];
            } else {
                // Get pane specified by startIdx
                startPane = panes[getNextIndex(panes, startIdx, 0)];
            }
        } else {
            // No startStr, get first visible pane
            for (IDisplayPane pane : panes) {
                if (pane.isVisible()) {
                    startPane = pane;
                    break;
                }
            }
        }

        if (startPane != null) {

            rotateToNextPane(editor, startPane, direction, hideIndex);
        }
        return null;
    }

    /**
     * Rotates to next pane in container. If container has > 1 pane displayed,
     * will rotate to pane passed in, otherwise to next in line
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param editor
     * @param pane
     */
    public static void rotateToNextPane(IMultiPaneEditor editor,
            IDisplayPane pane) {
        rotateToNextPane(editor, pane, 1, 0);
    }

    /**
     * Rotates to the next panel given the direction
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param editor
     * @param pane
     * @param direction
     */
    private static void rotateToNextPane(IMultiPaneEditor editor,
            IDisplayPane pane, int direction, Integer hideIndex) {
        boolean wrapped = false;
        IDisplayPane paneToRotateTo = pane;
        if (editor.displayedPaneCount() == 1) {
<<<<<<< HEAD
            IDisplayPane[] panes = getEditorPanes(editor);
=======
            IDisplayPane[] panes = getCanvasesInRotationOrder(editor);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            int paneIdx = -1;
            for (int i = 0; i < panes.length; ++i) {
                if (panes[i] == pane) {
                    paneIdx = i;
                    break;
                }
            }

            if (paneIdx >= 0) {
                int idxToCheck = paneIdx;
                boolean done = false;
                do {
                    int tmpIdx = idxToCheck + direction;
                    idxToCheck = getNextIndex(panes, idxToCheck, direction);
                    if (idxToCheck != tmpIdx) {
                        wrapped = true;
                    }
                    IDisplayPane next = panes[idxToCheck];
                    List<D2DLegendResource> rscs = next.getDescriptor()
                            .getResourceList()
                            .getResourcesByTypeAsType(D2DLegendResource.class);
                    for (D2DLegendResource rsc : rscs) {
                        if (rsc.hasProducts()) {
                            paneToRotateTo = next;
                            done = true;
                            break;
                        }
                    }
                } while (idxToCheck != paneIdx && !done);
            }
        }
        rotateToPane(editor, paneToRotateTo, hideIndex, wrapped);
    }

    /**
     * Sets container so pane passed in is the only visible pane
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param container
     * @param pane
     */
    private static void rotateToPane(IMultiPaneEditor editor, IDisplayPane pane,
            Integer hideIndex, boolean wrapped) {
<<<<<<< HEAD
        IDisplayPane[] panes = getEditorPanes(editor);
=======
        IDisplayPane[] panes = getCanvasesInRotationOrder(editor);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        boolean found = false;
        for (IDisplayPane editorPane : panes) {
            if (editorPane == pane) {
                found = true;
                break;
            }
        }
        if (found) {
            for (IDisplayPane editorPane : panes) {
                if (editorPane != pane) {
                    editor.hidePane(editorPane);
                }
            }
            editor.showPane(pane);
            editor.setSelectedPane(IMultiPaneEditor.VISIBLE_PANE, pane);
            editor.setSelectedPane(IMultiPaneEditor.IMAGE_ACTION, null);

            if (hideIndex == null) {
                // Search pane for current resource index
                hideIndex = 0;
                for (ResourcePair rp : pane.getDescriptor().getResourceList()) {
                    if (rp.getResource() != null && rp.getResource()
                            .hasCapability(BlendableCapability.class)) {
                        hideIndex = rp.getResource()
                                .getCapability(BlendableCapability.class)
                                .getResourceIndex();
                    }
                }
                if (wrapped) {
                    // If we wrapped, switch index
                    if (hideIndex == 0) {
                        hideIndex = 1;
                    } else {
                        hideIndex = 0;
                    }
                }
            }

            // Toggle displayed resource
            for (IDisplayPane p : panes) {
                for (ResourcePair rp : p.getDescriptor().getResourceList()) {
                    if (rp.getResource() != null && rp.getResource()
                            .hasCapability(BlendableCapability.class)) {
                        rp.getResource()
                                .getCapability(BlendableCapability.class)
                                .toggle(hideIndex);
                    }
                }
            }
        }
    }

    /**
<<<<<<< HEAD
     * Gets the editor panes. Will reorder panes to special A1 ordering of
     * UL,UR,LR,LL if number of panes is 4
     * 
     * @param editor
     * @return
     */
    private static IDisplayPane[] getEditorPanes(IMultiPaneEditor editor) {
        IDisplayPane[] panes = editor.getDisplayPanes();

        if (panes.length == 4) {
            panes = rotatePanes(panes, 2);
        } else if (panes.length == 9) {
            panes = rotatePanes(panes, 3);
        } else if (panes.length == 16) {
            panes = rotatePanes(panes, 4);
        }
        return panes;
    }

    // {0,1,2, 3,4,5, 6,7,8} becomes
    // {0,1,2, 5,4,3, 6,7,8}. Rotation snakes around
    private static IDisplayPane[] rotatePanes(IDisplayPane[] panes, int width) {
        IDisplayPane[] retArray = {};
        IDisplayPane dest[] = new IDisplayPane[width];
        for (int i = 0; i < width; i++) {
            System.arraycopy(panes, i * width, dest, 0, width);
            if (i % 2 == 0) {
                retArray = (IDisplayPane[]) ArrayUtils.addAll(retArray, dest);
            } else {
                ArrayUtils.reverse(dest);
                retArray = (IDisplayPane[]) ArrayUtils.addAll(retArray, dest);
            }
        }
        return retArray;
=======
     * Gets the editor's main canvases in "snake" order to match A1 rotation
     * ordering. For example, {0,1,2, 3,4,5, 6,7,8} becomes {0,1,2, 5,4,3,
     * 6,7,8}.
     *
     * @param editor
     *            editor to get canvases from
     * @return main editor canvases in order that they should be rotated through
     */
    private static IDisplayPane[] getCanvasesInRotationOrder(
            IMultiPaneEditor editor) {
        IDisplayPane[] canvases = editor.getMainCanvases();

        int[] numRowsColumns = UiUtil.getNumRowsColumns(canvases.length,
                editor.isHorizontalLayout());
        int numRows = numRowsColumns[0];
        int numColumns = numRowsColumns[1];

        List<IDisplayPane> rotateCanvases = new ArrayList<>(canvases.length);
        for (int r = 0; r < numRows; ++r) {
            int rowStartIndex = r * numColumns;
            int rowEndIndex = rowStartIndex + numColumns - 1;
            if (r % 2 == 0) {
                // Add row in normal order
                for (int i = rowStartIndex; i <= rowEndIndex; ++i) {
                    rotateCanvases.add(canvases[i]);
                }
            } else {
                // Add row in reverse order
                for (int i = rowEndIndex; i >= rowStartIndex; --i) {
                    rotateCanvases.add(canvases[i]);
                }
            }
        }

        return rotateCanvases.toArray(new IDisplayPane[0]);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * Gets the next index in line for rotation given panes, curIdx, and
     * direction
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param panes
     * @param curIdx
     * @param direction
     * @return
     */
    private static int getNextIndex(IDisplayPane[] panes, int curIdx,
            int direction) {
        int idxToCheck = curIdx + direction;
        if (idxToCheck < 0) {
            idxToCheck = panes.length - 1;
        } else if (idxToCheck >= panes.length) {
            idxToCheck = 0;
        }
        return idxToCheck;
    }
}
