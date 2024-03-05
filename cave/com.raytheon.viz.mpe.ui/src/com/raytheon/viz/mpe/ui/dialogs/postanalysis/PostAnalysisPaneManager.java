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
package com.raytheon.viz.mpe.ui.dialogs.postanalysis;

import org.eclipse.swt.layout.GridLayout;

import com.raytheon.viz.ui.panes.PaneManager;

/**
 * Extension of the PaneManager class.
<<<<<<< HEAD
 * 
 * <pre>
 * 
 * SOFTWARE HISTORY
 * 
 * Date         Ticket#    Engineer    Description
 * ------------ ---------- ----------- --------------------------
 * Jun 15, 2011            lvenable     Initial creation
 * 
 * </pre>
 * 
 * @author lvenable
 * @version 1.0
 */

=======
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 *
 * Date         Ticket#    Engineer    Description
 * ------------ ---------- ----------- --------------------------
 * Jun 15, 2011            lvenable    Initial creation
 * Apr 06, 2022 8790       mapeters    Handle adjustPaneLayout refactor
 *
 * </pre>
 *
 * @author lvenable
 */
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
public class PostAnalysisPaneManager extends PaneManager {

    /**
     * Override on the adjustPaneLayout method to get the maps to display
     * side-by-side instead of on top of each other.
     */
    @Override
<<<<<<< HEAD
    protected void adjustPaneLayout(int paneCount) {
=======
    protected void adjustPaneLayout() {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        if (composite == null || composite.isDisposed()) {
            return;
        }

<<<<<<< HEAD
        int numColums = paneCount;
        int numRows = 1;

        GridLayout gl = new GridLayout(numColums, true);
        int width = composite.getBounds().width;
        int height = composite.getBounds().height;

        if (numColums > 0 && numRows > 0) {
            gl.horizontalSpacing = width % numColums == 0 ? 2 : 3;
=======
        int numColumns = displayedPaneCount();
        int numRows = 1;

        GridLayout gl = new GridLayout(numColumns, true);
        int width = composite.getBounds().width;
        int height = composite.getBounds().height;

        if (numColumns > 0 && numRows > 0) {
            gl.horizontalSpacing = width % numColumns == 0 ? 2 : 3;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            gl.verticalSpacing = height % numRows == 0 ? 2 : 3;
        }
        gl.marginHeight = 0;
        gl.marginWidth = 0;

        composite.setLayout(gl);
        composite.layout();
        composite.setFocus();
    }
}
