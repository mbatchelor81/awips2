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

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IEditorPart;

import com.raytheon.uf.viz.core.IDisplayPaneContainer;
import com.raytheon.viz.ui.EditorUtil;
import com.raytheon.viz.ui.actions.MultiPanelEditor;
<<<<<<< HEAD
import com.raytheon.viz.ui.actions.MultiPanes;
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import com.raytheon.viz.ui.editor.IMultiPaneEditor;
import com.raytheon.viz.ui.tools.AbstractTool;

/**
<<<<<<< HEAD
 *
 * Handles entering multi-pane mode
=======
 * Handles entering multi-pane mode when the "End" key is pressed during rotate.
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 * Date         Ticket#    Engineer    Description
 * ------------ ---------- ----------- --------------------------
 * Nov 5,  2009            bsteffen     Initial creation
<<<<<<< HEAD
 * Feb 17, 2020   74164    ksunil       changed name to MultiPanelLayoutHandler 
 *                                       and use MultiPanelEditor
 * Dec 21, 2020   86204    Robert.Blum  Added support for any number of panes.
=======
 * Feb 17, 2020   74164    ksunil       changed name to MultiPanelLayoutHandler
 *                                       and use MultiPanelEditor
 * Dec 21, 2020   86204    Robert.Blum  Added support for any number of panes.
 * May 11, 2023   2029803  mapeters     Support horizontal panel layouts
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 *
 * </pre>
 *
 * @author bsteffen
 */
public class MultiPanelLayoutHandler extends AbstractTool {

<<<<<<< HEAD
    /*
     * MultiPanel layout handler is used with/for the "End" key during rotate.
     *
     */
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    @Override
    public Object execute(ExecutionEvent arg0) throws ExecutionException {
        // There might be a better way to merge these two actions.
        IEditorPart curEditor = EditorUtil.getActiveEditor();
        if (curEditor == null) {
<<<<<<< HEAD
            new MultiPanelEditor(MultiPanes.Four).execute(null);
=======
            new MultiPanelEditor().execute(null);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        } else if (curEditor instanceof IDisplayPaneContainer) {
            IDisplayPaneContainer container = EditorUtil
                    .getActiveVizContainer();
            if (container == null || !(container instanceof IMultiPaneEditor)) {
                return null;
            }

            // Get editor and panes
            IMultiPaneEditor editor = (IMultiPaneEditor) container;
<<<<<<< HEAD
            MultiPanelLayoutMenuAction menuAction = null;
            menuAction = new MultiPanelLayoutMenuAction(
                    editor.getNumberofPanes());
=======
            MultiPanelLayoutMenuAction menuAction = new MultiPanelLayoutMenuAction(
                    editor.getNumberofPanes(), editor.isHorizontalLayout());
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            menuAction.setContainer((IDisplayPaneContainer) curEditor);
            menuAction.run();
        }
        return null;
    }
}
