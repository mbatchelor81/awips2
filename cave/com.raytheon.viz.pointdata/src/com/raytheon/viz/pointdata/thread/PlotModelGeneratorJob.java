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
package com.raytheon.viz.pointdata.thread;

import java.awt.image.BufferedImage;
<<<<<<< HEAD
import java.awt.image.RenderedImage;
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import java.util.Map;

import org.apache.commons.collections.map.LRUMap;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.raytheon.uf.viz.core.IGraphicsTarget;
import com.raytheon.uf.viz.core.data.IRenderedImageCallback;
import com.raytheon.uf.viz.core.drawables.IImage;
import com.raytheon.uf.viz.core.drawables.ext.ISingleColorImageExtension;
<<<<<<< HEAD
import com.raytheon.uf.viz.core.exception.VizException;
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import com.raytheon.viz.pointdata.IPlotModelFactory;
import com.raytheon.viz.pointdata.IPlotModelGeneratorCaller;
import com.raytheon.viz.pointdata.PlotInfo;

/**
 * Job that generates plot images using a PlotModelFactory2.
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 *
<<<<<<< HEAD
 * Date          Ticket#    Engineer    Description
 * ------------- -------- ----------- --------------------------
 * Apr 22, 2011           njensen     Initial creation
 * Mar 21, 2014  2868     njensen     Major refactor
 * Jun 06, 2014  2061     bsteffen    Remove old PlotResource
 * Jun 12, 2017  6303     bsteffen    Provide color when creating image.
 * Nov 01, 2019  71272    ksunil      tweaks to accommodate new plot
 *                                     customization changes
=======
 * Date          Ticket#  Engineer  Description
 * ------------- -------- --------- --------------------------------------------
 * Apr 22, 2011           njensen   Initial creation
 * Mar 21, 2014  2868     njensen   Major refactor
 * Jun 06, 2014  2061     bsteffen  Remove old PlotResource
 * Jun 12, 2017  6303     bsteffen  Provide color when creating image.
 * Nov 01, 2019  71272    ksunil    tweaks to accommodate new plot customization
 *                                  changes
 * Dec 07, 2021  8341     randerso  Move plot performance logging into perf log.
 *                                  Add additional info to performance logging.
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 *
 * </pre>
 *
 * @author njensen
 */

public class PlotModelGeneratorJob extends AbstractPlotCreationJob {

    private IPlotModelFactory plotCreator;

    private IGraphicsTarget target;

    @SuppressWarnings("unchecked")
    private Map<BufferedImage, IImage> imageCache = new LRUMap(1000);

    protected PlotModelGeneratorJob(PlotThreadOverseer parent,
            IPlotModelGeneratorCaller caller, IPlotModelFactory plotCreator,
            IGraphicsTarget target) {
        super("Creating plots", parent, caller);
        this.plotCreator = plotCreator;
        this.target = target;
    }

<<<<<<< HEAD
    /*
     * (non-Javadoc)
     *
     * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.
     * IProgressMonitor)
     */
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    @Override
    protected IStatus run(IProgressMonitor monitor) {
        long t0 = System.currentTimeMillis();
        long count = 0;
        while (!overseer.imageCreationQueue.isEmpty()) {
            try {
                PlotInfo[] infos = overseer.imageCreationQueue.poll();
                if (infos == null) {
<<<<<<< HEAD
                    // possibility another thread got it first
=======
                    /* possibility another thread got it first */
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                    continue;
                }
                final BufferedImage bImage = plotCreator.getStationPlot(
                        infos[0].pdv, infos[0].latitude, infos[0].longitude);
                IImage image = null;
                if (bImage != null) {
                    if (imageCache.containsKey(bImage)) {
                        image = imageCache.get(bImage);
                        if (image.getStatus() == IImage.Status.FAILED
                                || image.getStatus() == IImage.Status.INVALID
                                || image.getStatus() == IImage.Status.UNLOADED) {
                            image = null;
                        }
                    }
                    if (image == null) {
                        if (!plotCreator.isSingleColor()) {
<<<<<<< HEAD
                            IRenderedImageCallback callback = new IRenderedImageCallback() {
                                @Override
                                public RenderedImage getImage()
                                        throws VizException {
                                    return bImage;
                                }
                            };
=======
                            IRenderedImageCallback callback = () -> bImage;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                            image = target.initializeRaster(callback);

                        } else {
                            image = target
                                    .getExtension(
                                            ISingleColorImageExtension.class)
<<<<<<< HEAD
                                    .constructImage(
                                            new IRenderedImageCallback() {
                                                @Override
                                                public RenderedImage getImage()
                                                        throws VizException {
                                                    return bImage;
                                                }
                                            }, plotCreator.getColor());
=======
                                    .constructImage(() -> bImage,
                                            plotCreator.getColor());
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

                        }
                        if (plotCreator.isCachingImages()) {
                            imageCache.put(bImage, image);
                        }
                    }
                }
                synchronized (this) {
                    if (monitor.isCanceled()) {
                        if (image != null) {
                            image.dispose();
                        }
                        break;
                    }
                    count++;
                    listener.modelGenerated(infos, image);
                }
            } catch (Exception e) {
                statusHandler.error("Error creating plot with plotModel "
                        + plotCreator.getPlotModelFilename(), e);
            }
        }

        if (count > 0) {
            /*
             * if count is zero it means by the time this job was scheduled and
             * run, a different job took care of everything on the queue
             */
<<<<<<< HEAD
            System.out.println("Time spent creating " + count + " plots: "
                    + (System.currentTimeMillis() - t0));
=======

            perfLog.logDuration(
                    String.format("Creating [%d] plots for [%s] [%s]", count,
                            plotCreator.getPlugin(),
                            plotCreator.getPlotModelFilename()),
                    (System.currentTimeMillis() - t0));
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        }
        return Status.OK_STATUS;
    }

    protected void clearImageCache() {
<<<<<<< HEAD
        // We weren't disposing before...shouldn't we?
=======
        /* We weren't disposing before...shouldn't we? */
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        imageCache.values().forEach(IImage::dispose);
        imageCache.clear();
    }

    @Override
    public boolean shutdown() {
        boolean result = super.shutdown();
        clearImageCache();
        plotCreator.dispose();
        return result;
    }
}
