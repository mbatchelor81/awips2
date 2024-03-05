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
package com.raytheon.viz.radar.rsc.image;

import java.awt.Rectangle;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
<<<<<<< HEAD
import java.util.Date;
=======
import java.util.Objects;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

import com.raytheon.uf.common.colormap.prefs.ColorMapParameters;
import com.raytheon.uf.common.dataplugin.radar.RadarRecord;
import com.raytheon.uf.common.dataplugin.radar.util.RadarRecordUtil;
import com.raytheon.uf.common.datastorage.StorageException;
<<<<<<< HEAD
import com.raytheon.uf.common.time.SimulatedTime;
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import com.raytheon.uf.viz.core.DrawableImage;
import com.raytheon.uf.viz.core.IGraphicsTarget;
import com.raytheon.uf.viz.core.drawables.IImage;
import com.raytheon.uf.viz.core.drawables.ext.colormap.IColormappedImageExtension;
import com.raytheon.uf.viz.core.exception.VizException;
import com.raytheon.uf.viz.core.rsc.LoadProperties;
import com.raytheon.viz.awipstools.IToolChangedListener;
import com.raytheon.viz.awipstools.ToolsDataManager;
<<<<<<< HEAD
import com.raytheon.viz.awipstools.common.StormTrackData;
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import com.raytheon.viz.radar.IRadarConfigListener;
import com.raytheon.viz.radar.RadarHelper;
import com.raytheon.viz.radar.VizRadarRecord;
import com.raytheon.viz.radar.interrogators.IRadarInterrogator;
import com.raytheon.viz.radar.rsc.RadarResourceData;
<<<<<<< HEAD
import com.raytheon.viz.radar.ui.RadarDisplayControls;
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import com.raytheon.viz.radar.ui.RadarDisplayManager;

/**
 * For the derived product, SRM8
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
 * Jul 2, 2010             mnash       Initial creation
 * 03/07/2012   DR 14660   D. Friedman Use getSTIDataForRadarRecord
<<<<<<< HEAD
 * 
 * </pre>
 * 
 * @author mnash
 * @version 1.0
 */

public class RadarSRMResource extends RadarRadialResource implements
        IRadarConfigListener, IToolChangedListener {
=======
 * Feb 22, 2023 9021       mapeters    Move loadSRMVelocity() to RadarHelper,
 *                                     update RadarSRMDataRetrievalAdapter
 *                                     hashCode/equals
 *
 * </pre>
 *
 * @author mnash
 */
public class RadarSRMResource extends RadarRadialResource
        implements IRadarConfigListener, IToolChangedListener {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    protected SimpleDateFormat hhmmFormat = new SimpleDateFormat("HH:mm");

    public enum SRMSource {
        WARNGEN, STI, CUSTOM
<<<<<<< HEAD
    };
=======
    }
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * @param rrd
     * @param loadProps
     * @throws VizException
     */
    public RadarSRMResource(RadarResourceData rrd, LoadProperties loadProps,
            IRadarInterrogator interrogator) throws VizException {
        super(rrd, loadProps, interrogator);
        RadarDisplayManager.getInstance().addListener(this);
        ToolsDataManager.getInstance().addStormTrackChangedListener(this);
    }

    @Override
    protected void disposeInternal() {
        super.disposeInternal();
        RadarDisplayManager.getInstance().removeListener(this);
        ToolsDataManager.getInstance().removeStormTrackChangedListener(this);
    }

<<<<<<< HEAD
    /*
     * (non-Javadoc)
     * 
     * @see com.raytheon.viz.radar.IRadarConfigListener#updateConfig()
     */
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    @Override
    public void updateConfig() {
        clearData();
    }

<<<<<<< HEAD
    /*
     * (non-Javadoc)
     * 
     * @see com.raytheon.viz.awipstools.IToolChangedListener#toolChanged()
     */
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    @Override
    public void toolChanged() {
        clearData();
    }

    private void clearData() {
        synchronized (this.images) {
            for (DrawableImage image : this.images.values()) {
                if (image != null) {
                    image.dispose();
                }
            }
        }
        images.clear();
        upperTextMap.clear();
        issueRefresh();
    }

<<<<<<< HEAD
    /*
     * (non-Javadoc)
     * 
     * @see
     * com.raytheon.viz.radar.rsc.RadarResource#createTile(com.raytheon.uf.viz
     * .core.IGraphicsTarget,
     * com.raytheon.viz.radar.RadarTimeRecord.RadarTiltRecord)
     */
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    @Override
    protected void createTile(IGraphicsTarget target,
            VizRadarRecord populatedRecord) throws StorageException,
            IOException, ClassNotFoundException, VizException {
<<<<<<< HEAD
        loadSRMVelocity(populatedRecord);
=======
        RadarHelper.loadSRMVelocity(populatedRecord);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        super.createTile(target, populatedRecord);
        upperTextMap.remove(populatedRecord.getDataTime());
    }

<<<<<<< HEAD
    private void loadSRMVelocity(RadarRecord record) throws VizException {
        RadarDisplayControls currentSettings = RadarDisplayManager
                .getInstance().getCurrentSettings();
        SRMSource srmSource = currentSettings.getSrmSource();

        double direction = 0;
        double speed = 0;
        Date movementTime = null;
        String sourceName = null;

        // for custom direction/speed as set in the Radar Display Controls
        // dialog
        if (srmSource.equals(SRMSource.WARNGEN)) {
            sourceName = "TRK";
            StormTrackData stormTrackData = ToolsDataManager.getInstance()
                    .getStormTrackData();
            if (stormTrackData != null && stormTrackData.isValid()
                    && stormTrackData.getMotionSpeed() < 100.0) {
                direction = (stormTrackData.getMotionDirection() + 180) % 360;
                speed = stormTrackData.getMotionSpeed();
                movementTime = stormTrackData.getDate();
            } else {
                // If no warngen, then try STI
                srmSource = SRMSource.STI;
            }
        }
        if (srmSource.equals(SRMSource.STI)) {
            sourceName = "STI";
            StormTrackData stormTrackData = RadarHelper.getSTIDataForRadarRecord(record);
            if (stormTrackData != null && stormTrackData.isValid()) {
                direction = stormTrackData.getMotionDirection();
                speed = stormTrackData.getMotionSpeed();
                movementTime = stormTrackData.getDate();
            } else {
                // if no STI, use custom
                srmSource = SRMSource.CUSTOM;
            }
        }
        if (srmSource.equals(SRMSource.CUSTOM)) {
            sourceName = "USR";
            direction = currentSettings.getSrmDir();
            speed = currentSettings.getSrmSpeed();
            movementTime = SimulatedTime.getSystemTime().getTime();
        }

        RadarRecordUtil.setSRMData(record, direction, speed, movementTime,
                sourceName);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.raytheon.viz.radar.rsc.image.RadarRadialResource#toImageData(com.
     * raytheon.uf.viz.core.IGraphicsTarget,
     * com.raytheon.uf.viz.core.drawables.ColorMapParameters,
     * com.raytheon.uf.common.dataplugin.radar.RadarRecord, java.awt.Rectangle)
     */
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    @Override
    protected IImage createImage(IGraphicsTarget target,
            ColorMapParameters params, RadarRecord record, Rectangle rect)
            throws VizException {
        byte[] table = createConversionTable(params, record);
        return target.getExtension(IColormappedImageExtension.class)
                .initializeRaster(
                        new RadarSRMDataRetrievalAdapter(record, table, rect),
                        params);
    }

<<<<<<< HEAD
    protected static class RadarSRMDataRetrievalAdapter extends
            RadarRadialDataRetrievalAdapter {
=======
    protected static class RadarSRMDataRetrievalAdapter
            extends RadarRadialDataRetrievalAdapter {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

        public RadarSRMDataRetrievalAdapter(RadarRecord record, byte[] table,
                Rectangle rect) {
            super(record, table, rect);
        }

        @Override
        public byte[] convertData() {
            byte[] imageData = new byte[record.getNumBins()
                    * record.getNumRadials()];
            int i = 0;
            for (int h = 0; h < record.getNumRadials(); ++h) {
                for (int w = 0; w < record.getNumBins(); ++w) {
<<<<<<< HEAD
                    imageData[i] = table[RadarRecordUtil.getSRMDataValue(
                            record, h, w) & 0xFF];
=======
                    imageData[i] = table[RadarRecordUtil.getSRMDataValue(record,
                            h, w) & 0xFF];
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                    ++i;
                }
            }
            return imageData;
        }

<<<<<<< HEAD
        /**
         * Overide equals to force records to == eachother so that srm will not
         * share unless records are same object to prevent issues when srm speed
         * and direction change.
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
=======
        @Override
        protected int initHashCode() {
            final int prime = 31;
            int hashCode = 1;
            hashCode = prime * hashCode + System.identityHashCode(record);
            hashCode = prime * hashCode + Arrays.hashCode(table);
            hashCode = prime * hashCode + rect.hashCode();
            return hashCode;
        }

        /**
         * Override equals to force records to == each other so that SRM will
         * not share unless records are same object to prevent issues when SRM
         * speed and direction change.
         *
         * We suppress SonarQube's warning to override hashCode() as well. The
         * hash code is pre-computed in the superclass, and our initHashCode()
         * override makes it match this equals() override.
         */
        @SuppressWarnings("squid:S1206")
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            RadarSRMDataRetrievalAdapter other = (RadarSRMDataRetrievalAdapter) obj;
            if (record != other.record) {
                return false;
            }
<<<<<<< HEAD
            if (!Arrays.equals(table, other.table))
                return false;
            return true;
        }

    }

=======
            if (!Arrays.equals(table, other.table)) {
                return false;
            }
            if (!Objects.equals(rect, other.rect)) {
                return false;
            }
            return true;
        }
    }
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
}
