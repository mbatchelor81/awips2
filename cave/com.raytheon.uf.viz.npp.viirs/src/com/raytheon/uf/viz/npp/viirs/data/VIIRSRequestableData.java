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
package com.raytheon.uf.viz.npp.viirs.data;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Map;

import javax.measure.Unit;
import javax.measure.UnitConverter;
import javax.measure.quantity.Dimensionless;

import org.geotools.coverage.grid.GridEnvelope2D;
import org.geotools.coverage.grid.GridGeometry2D;
import org.opengis.geometry.Envelope;

import com.raytheon.uf.common.dataplugin.HDF5Util;
import com.raytheon.uf.common.dataplugin.level.Level;
import com.raytheon.uf.common.dataplugin.npp.viirs.VIIRSDataRecord;
import com.raytheon.uf.common.dataplugin.npp.viirs.VIIRSSpatialCoverage;
import com.raytheon.uf.common.datastorage.DataStoreFactory;
import com.raytheon.uf.common.datastorage.IDataStore;
import com.raytheon.uf.common.datastorage.Request;
import com.raytheon.uf.common.datastorage.records.FloatDataRecord;
import com.raytheon.uf.common.datastorage.records.IDataRecord;
import com.raytheon.uf.common.datastorage.records.ShortDataRecord;
import com.raytheon.uf.common.geospatial.data.UnitConvertingDataFilter;
import com.raytheon.uf.common.geospatial.interpolation.BilinearInterpolation;
import com.raytheon.uf.common.geospatial.interpolation.GridDownscaler;
import com.raytheon.uf.common.geospatial.interpolation.GridReprojection;
import com.raytheon.uf.common.inventory.data.AbstractRequestableData;
import com.raytheon.uf.common.inventory.exception.DataCubeException;
import com.raytheon.uf.common.numeric.DataUtilities;
import com.raytheon.uf.common.numeric.buffer.FloatBufferWrapper;
import com.raytheon.uf.common.numeric.buffer.ShortBufferWrapper;
import com.raytheon.uf.common.numeric.dest.DataDestination;
import com.raytheon.uf.common.numeric.filter.FillValueFilter;
import com.raytheon.uf.common.numeric.filter.InverseFillValueFilter;
import com.raytheon.uf.common.numeric.filter.UnsignedFilter;
import com.raytheon.uf.common.numeric.source.DataSource;
import com.raytheon.uf.viz.core.exception.VizException;

<<<<<<< HEAD
import tec.uom.se.AbstractUnit;
=======
import tech.units.indriya.AbstractUnit;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

/**
 * Object capable of requesting VIIRS data for base or derived displays. Can
 * also reproject into different coverages
<<<<<<< HEAD
 * 
 * <pre>
 * 
 * SOFTWARE HISTORY
 * 
 * Date          Ticket#  Engineer    Description
 * ------------- -------- ----------- --------------------------
 * Jan 19, 2012           mschenke    Initial creation
 * Mar 07, 2014  2791     bsteffen    Move Data Source/Destination to numeric
 *                                    plugin.
 * Apr 15, 2019  7596     lsingh      Updated units framework to JSR-363.
 *                                    Handled unit conversion.
 * 
 * </pre>
 * 
 * @author mschenke
 * @version 1.0
=======
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 *
 * Date          Ticket#  Engineer  Description
 * ------------- -------- --------- --------------------------------------------
 * Jan 19, 2012           mschenke  Initial creation
 * Mar 07, 2014  2791     bsteffen  Move Data Source/Destination to numeric
 *                                  plugin.
 * Apr 15, 2019  7596     lsingh    Updated units framework to JSR-363. Handled
 *                                  unit conversion.
 * Mar 29, 2021  8374     randerso  Renamed IDataRecord.get/setProperties to
 *                                  get/setProps
 *
 * </pre>
 *
 * @author mschenke
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 */

public class VIIRSRequestableData extends AbstractRequestableData {

    /**
     * The data request object, bounds of request, full coverage, and dataset to
     * request
     */
    public static class VIIRSRequest {
        public final Request request;

        public final String dataset;

        public final VIIRSSpatialCoverage coverage;

        public VIIRSRequest(Request request, String dataset,
                VIIRSSpatialCoverage coverage) {
            this.request = request;
            this.dataset = dataset;
            this.coverage = coverage;
        }
    }

    /** Data record this object requests for */
    private VIIRSDataRecord dataRecord;

    public VIIRSRequestableData(VIIRSDataRecord dataRecord, Level level) {
        this.dataRecord = dataRecord;
        setDataTime(dataRecord.getDataTime());
        setLevel(level);
        setParameter(dataRecord.getParameter());
        setParameterName(VIIRSDynamicParameters.createParameter(
                dataRecord.getWavelength(), dataRecord.getParameter()));
        setSource(dataRecord.getChannelType());
        setUnit(AbstractUnit.ONE);
    }

    /**
     * Gets the raw data records without converting to floats/applying scale and
     * offset. Will ensure returned data is projected into request's coverage.
     * Can be directly called if data is desired to stay in "short" format.
     * Otherwise calling {@link #getDataValue(Object)} will cause data to be
     * converted to "float" by having scale/offset applied
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param request
     * @return
     * @throws VizException
     */
    public IDataRecord[] getRawDataValue(VIIRSRequest request)
            throws DataCubeException {
<<<<<<< HEAD
        IDataStore store = DataStoreFactory.getDataStore(HDF5Util
                .findHDF5Location(dataRecord));
        try {
            VIIRSSpatialCoverage recordCoverage = dataRecord.getCoverage();
            VIIRSSpatialCoverage requestCoverage = request.coverage;
            if (recordCoverage.equals(requestCoverage) == false) {
=======
        IDataStore store = DataStoreFactory
                .getDataStore(HDF5Util.findHDF5Location(dataRecord));
        try {
            VIIRSSpatialCoverage recordCoverage = dataRecord.getCoverage();
            VIIRSSpatialCoverage requestCoverage = request.coverage;
            if (!recordCoverage.equals(requestCoverage)) {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                // Data coverages are different, reprojection is required
                GridGeometry2D requestGeometry = requestCoverage
                        .getGridGeometry();
                GridGeometry2D recordGeometry = recordCoverage
                        .getGridGeometry();

                // Grab the downscale rectangles for the geomerties
                Rectangle[] requestSizes = GridDownscaler
                        .getDownscaleSizes(requestGeometry);
                Rectangle[] recordSizes = GridDownscaler
                        .getDownscaleSizes(recordGeometry);

                // Figure out what level we are requesting for
                int length = Math.min(requestSizes.length, recordSizes.length);
                int level;
                for (level = 0; level < length; ++level) {
<<<<<<< HEAD
                    if (VIIRSDataRecord.getDataSet(level).equals(
                            request.dataset)) {
=======
                    if (VIIRSDataRecord.getDataSet(level)
                            .equals(request.dataset)) {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                        break;
                    }
                }
                Rectangle requestLevelRect = requestSizes[level];
                Rectangle recordLevelRect = recordSizes[level];

                // Calculate ratio based on request level sizes
                double diffRatioX = recordLevelRect.getWidth()
                        / requestLevelRect.getWidth();
                double diffRatioY = recordLevelRect.getHeight()
                        / requestLevelRect.getHeight();

                GridGeometry2D requestSliceGeometry = null;
                GridGeometry2D recordSliceGeometry = null;

                Request req = request.request;
                Request recordRequest = req;
                switch (request.request.getType()) {
                case POINT:
                    Point[] points = req.getPoints();
                    Point[] newPoints = new Point[points.length];
                    for (int i = 0; i < points.length; ++i) {
<<<<<<< HEAD
                        newPoints[i] = new Point((int) Math.max(points[i].x
                                * diffRatioX, requestLevelRect.width - 1),
=======
                        newPoints[i] = new Point(
                                (int) Math.max(points[i].x * diffRatioX,
                                        requestLevelRect.width - 1),
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                                (int) Math.max(points[i].x * diffRatioX,
                                        requestLevelRect.height - 1));
                    }
                    recordRequest = Request.buildPointRequest(newPoints);
                    break;
                case SLAB:
                    int[] min = req.getMinIndexForSlab();
                    int[] max = req.getMaxIndexForSlab();
<<<<<<< HEAD
                    GridEnvelope2D reqGrid = new GridEnvelope2D(0, 0, max[0]
                            - min[0], max[1] - min[1]);
=======
                    GridEnvelope2D reqGrid = new GridEnvelope2D(0, 0,
                            max[0] - min[0], max[1] - min[1]);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                    requestSliceGeometry = new GridGeometry2D(reqGrid,
                            (Envelope) requestGeometry.gridToWorld(reqGrid));
                    recordRequest = Request.buildSlab(
                            new int[] { (int) (min[0] * diffRatioX),
                                    (int) (min[1] * diffRatioY) },
                            new int[] {
                                    (int) Math.min(max[0] * diffRatioX,
                                            recordLevelRect.getMaxX()),
                                    (int) Math.min(max[1] * diffRatioY,
                                            recordLevelRect.getMaxY()) });
                    min = recordRequest.getMinIndexForSlab();
                    max = recordRequest.getMaxIndexForSlab();
<<<<<<< HEAD
                    GridEnvelope2D recGrid = new GridEnvelope2D(0, 0, max[0]
                            - min[0], max[1] - min[1]);
=======
                    GridEnvelope2D recGrid = new GridEnvelope2D(0, 0,
                            max[0] - min[0], max[1] - min[1]);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                    recordSliceGeometry = new GridGeometry2D(recGrid,
                            (Envelope) recordGeometry.gridToWorld(recGrid));
                    break;
                case ALL:
                    requestSliceGeometry = requestGeometry;
                    recordSliceGeometry = recordGeometry;
                    break;
                }

                IDataRecord record = store.retrieve(dataRecord.getDataURI(),
                        request.dataset, recordRequest);
<<<<<<< HEAD
                if (requestSliceGeometry != null && recordSliceGeometry != null) {
                    // Slice geometries are set, we need to reproject into
                    // request space
                    double noData = Double.NaN;
                    if (record.getDataAttributes().containsKey(
                            VIIRSDataRecord.MISSING_VALUE_ID)) {
                        noData = ((Number) record.getDataAttributes().get(
                                VIIRSDataRecord.MISSING_VALUE_ID))
                                .doubleValue();
=======
                if (requestSliceGeometry != null
                        && recordSliceGeometry != null) {
                    // Slice geometries are set, we need to reproject into
                    // request space
                    double noData = Double.NaN;
                    if (record.getDataAttributes()
                            .containsKey(VIIRSDataRecord.MISSING_VALUE_ID)) {
                        noData = ((Number) record.getDataAttributes()
                                .get(VIIRSDataRecord.MISSING_VALUE_ID))
                                        .doubleValue();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                    }

                    GridReprojection reprojection = new GridReprojection(
                            recordSliceGeometry, requestSliceGeometry);
                    ShortBufferWrapper rawDest = new ShortBufferWrapper(
                            requestSliceGeometry.getGridRange2D());
<<<<<<< HEAD
                    DataDestination dest = InverseFillValueFilter.apply(
                            (DataDestination) rawDest, noData);
=======
                    DataDestination dest = InverseFillValueFilter
                            .apply((DataDestination) rawDest, noData);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                    ShortBufferWrapper rawSource = new ShortBufferWrapper(
                            ((ShortDataRecord) record).getShortData(),
                            recordSliceGeometry.getGridRange2D());
                    DataSource source = UnsignedFilter.apply(rawSource);

                    source = FillValueFilter.apply(source, noData);
                    reprojection.reprojectedGrid(new BilinearInterpolation(),
                            source, dest);

                    ShortDataRecord scaled = new ShortDataRecord(
                            record.getName(), record.getGroup(),
                            rawDest.getArray());
                    copyRecord(scaled, record);
                    // set correct sizes after copying attributes
                    scaled.setIntSizes(new int[] {
                            requestSliceGeometry.getGridRange().getSpan(0),
                            requestSliceGeometry.getGridRange().getSpan(1) });
                    record = scaled;
                }
                return new IDataRecord[] { record };
            } else {
<<<<<<< HEAD
                return new IDataRecord[] { store.retrieve(
                        dataRecord.getDataURI(), request.dataset,
                        request.request) };
            }
        } catch (Exception e) {
            throw new DataCubeException("Error retrieving viirs data: "
                    + e.getLocalizedMessage(), e);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.raytheon.uf.viz.derivparam.data.AbstractRequestableData#getDataValue
     * (java.lang.Object)
     */
=======
                return new IDataRecord[] {
                        store.retrieve(dataRecord.getDataURI(), request.dataset,
                                request.request) };
            }
        } catch (Exception e) {
            throw new DataCubeException(
                    "Error retrieving viirs data: " + e.getLocalizedMessage(),
                    e);
        }
    }

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    @Override
    public IDataRecord[] getDataValue(Object arg) throws DataCubeException {
        VIIRSRequest request = (VIIRSRequest) arg;
        // Get raw data
        IDataRecord[] records = getRawDataValue(request);
        for (int i = 0; i < records.length; ++i) {
            IDataRecord record = records[i];
            Map<String, Object> attrs = record.getDataAttributes();
            double noDataValue = Double.NaN;
            if (attrs.containsKey(VIIRSDataRecord.MISSING_VALUE_ID)) {
                // Replace no data value with NaN while assigning noDataValue
<<<<<<< HEAD
                noDataValue = ((Number) attrs.put(
                        VIIRSDataRecord.MISSING_VALUE_ID, noDataValue))
                        .doubleValue();
=======
                noDataValue = ((Number) attrs
                        .put(VIIRSDataRecord.MISSING_VALUE_ID, noDataValue))
                                .doubleValue();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            }

            Unit<Dimensionless> dataUnit = AbstractUnit.ONE;
            // Remove scale/offset since we are applying them now
            Float offset = (Float) attrs.remove(VIIRSDataRecord.OFFSET_ID);
            Float scale = (Float) attrs.remove(VIIRSDataRecord.SCALE_ID);

            if (offset != null && offset != 0.0) {
                dataUnit = dataUnit.shift(offset);
            }
            if (scale != null && scale != 0.0) {
                dataUnit = dataUnit.multiply(scale);
            }

            long[] sizes = record.getSizes();
            int width = (int) sizes[0], height = 1;
            if (sizes.length > 1) {
                height = (int) sizes[1];
            }
            float[] floatData = new float[width * height];
<<<<<<< HEAD
            final UnitConverter converter = dataUnit.getConverterTo(AbstractUnit.ONE);
            DataDestination destination = new FloatBufferWrapper(floatData,
                    width, height);
            destination = UnitConvertingDataFilter
                    .apply(destination, converter);
=======
            final UnitConverter converter = dataUnit
                    .getConverterTo(AbstractUnit.ONE);
            DataDestination destination = new FloatBufferWrapper(floatData,
                    width, height);
            destination = UnitConvertingDataFilter.apply(destination,
                    converter);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            ShortBufferWrapper shortData = new ShortBufferWrapper(
                    ((ShortDataRecord) record).getShortData(), width, height);
            DataSource source = UnsignedFilter.apply(shortData);
            source = FillValueFilter.apply(source, noDataValue);

            DataUtilities.copy(source, destination, width, height);

            // Create float data record from converted data
            FloatDataRecord fdr = new FloatDataRecord(record.getName(),
                    record.getGroup(), floatData);
            copyRecord(fdr, record);
            records[i] = fdr;
        }
        return records;
    }

    /**
     * @return the dataRecord
     */
    public VIIRSDataRecord getDataRecord() {
        return dataRecord;
    }

    /**
     * Copies one {@link IDataRecord} into another
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param to
     * @param from
     */
    public static void copyRecord(IDataRecord to, IDataRecord from) {
        to.setCorrelationObject(from.getCorrelationObject());
        to.setDataAttributes(from.getDataAttributes());
        to.setDimension(from.getDimension());
        to.setFillValue(from.getFillValue());
        to.setMaxChunkSize(from.getMaxChunkSize());
        to.setMaxSizes(from.getMaxSizes());
        to.setMinIndex(from.getMinIndex());
<<<<<<< HEAD
        to.setProperties(from.getProperties());
=======
        to.setProps(from.getProps());
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        to.setSizes(from.getSizes());
    }
}
