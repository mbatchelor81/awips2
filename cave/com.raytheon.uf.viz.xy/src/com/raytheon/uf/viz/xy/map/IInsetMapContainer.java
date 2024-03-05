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
package com.raytheon.uf.viz.xy.map;

<<<<<<< HEAD
import java.io.File;

import org.eclipse.swt.layout.FormData;

import com.raytheon.uf.common.localization.PathManagerFactory;
import com.raytheon.uf.common.status.IUFStatusHandler;
import com.raytheon.uf.common.status.UFStatus;
import com.raytheon.uf.common.status.UFStatus.Priority;
=======
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.swt.layout.FormData;

import com.raytheon.uf.common.localization.ILocalizationFile;
import com.raytheon.uf.common.localization.IPathManager;
import com.raytheon.uf.common.localization.PathManagerFactory;
import com.raytheon.uf.common.localization.exception.LocalizationException;
import com.raytheon.uf.common.status.IUFStatusHandler;
import com.raytheon.uf.common.status.UFStatus;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import com.raytheon.uf.viz.core.PixelExtent;
import com.raytheon.uf.viz.core.drawables.IRenderableDisplay;
import com.raytheon.uf.viz.core.exception.VizException;
import com.raytheon.uf.viz.core.procedures.Bundle;

/**
 * Interface renderable displays who contain an inset map should implement
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
 * Date          Ticket#  Engineer    Description
 * ------------- -------- ----------- --------------------------
 * Oct 08, 2009           mschenke    Initial creation
 * Oct 22, 2013  2491     bsteffen    Unmarshal with Bundle.unmarshalBundle.
<<<<<<< HEAD
 * 
 * 
 * </pre>
 * 
 * @author mschenke
 * @version 1.0
 */

=======
 * Apr 22, 2022  8791     mapeters    Moved isInsetMapDisplay here from
 *                                    XyPaneManager
 *
 * </pre>
 *
 * @author mschenke
 */
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
public interface IInsetMapContainer {

    /**
     * Return the location of where the inset map should be placed using an swt
     * FormData object
<<<<<<< HEAD
     * 
     * @return the location
     */
    public FormData getInsetMapLocation();
=======
     *
     * @return the location
     */
    FormData getInsetMapLocation();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /** Utility class for loading the inset map from a bundle */
    public static class InsetMapUtil {

<<<<<<< HEAD
        private static final transient IUFStatusHandler statusHandler = UFStatus
=======
        private static final IUFStatusHandler statusHandler = UFStatus
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                .getHandler(IInsetMapContainer.class);

        public static IRenderableDisplay loadInsetMap(
                IRenderableDisplay parentDisplay) {
<<<<<<< HEAD
            File bundle = PathManagerFactory.getPathManager().getStaticFile(
                    "insetmap" + File.separator + "inset.xml");
            try {
                Bundle b = Bundle.unmarshalBundle(bundle);
=======
            ILocalizationFile bundleLocFile = PathManagerFactory
                    .getPathManager().getStaticLocalizationFile(
                            "insetmap" + IPathManager.SEPARATOR + "inset.xml");
            try (InputStream is = bundleLocFile.openInputStream()) {
                Bundle b = Bundle.unmarshalBundle(is);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                InsetMapRenderableDisplay display = (InsetMapRenderableDisplay) b
                        .getDisplays()[0];
                display.getDescriptor().getResourceList()
                        .instantiateResources(display.getDescriptor(), true);
                display.setExtent(new PixelExtent(0, 1000, 0, 1000));
                display.setParentDisplay(parentDisplay);
                return display;
<<<<<<< HEAD
            } catch (VizException e) {
                statusHandler.handle(Priority.PROBLEM, e.getLocalizedMessage(),
=======
            } catch (VizException | IOException | LocalizationException e) {
                statusHandler.error(
                        "Error loading inset map from bundle: " + bundleLocFile,
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                        e);
            }
            return null;
        }
<<<<<<< HEAD
=======

        /**
         * Check to see if the renderable display supports the attachment of an
         * inset map
         *
         * @param display
         *            the renderable display of the main canvas to check
         * @return true if display supports an inset map, false otherwise
         */
        public static boolean isInsetMapDisplay(IRenderableDisplay display) {
            return (display instanceof IInsetMapContainer)
                    && ((IInsetMapContainer) display)
                            .getInsetMapLocation() != null;
        }
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }
}
