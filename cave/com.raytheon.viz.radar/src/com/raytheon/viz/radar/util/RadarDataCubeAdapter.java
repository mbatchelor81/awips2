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
package com.raytheon.viz.radar.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

<<<<<<< HEAD
=======
import com.raytheon.uf.common.dataplugin.radar.util.RadarUtil;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import com.raytheon.uf.common.dataquery.requests.DbQueryRequest;
import com.raytheon.uf.common.dataquery.requests.DbQueryRequestSet;
import com.raytheon.uf.common.dataquery.requests.RequestConstraint;
import com.raytheon.uf.common.dataquery.requests.TimeQueryRequest;
import com.raytheon.uf.common.dataquery.responses.DbQueryResponse;
import com.raytheon.uf.common.dataquery.responses.DbQueryResponseSet;
import com.raytheon.uf.common.derivparam.library.DerivedParameterGenerator;
import com.raytheon.uf.common.inventory.exception.DataCubeException;
import com.raytheon.uf.common.pointdata.PointDataContainer;
import com.raytheon.uf.common.serialization.comm.RequestRouter;
import com.raytheon.uf.common.status.IUFStatusHandler;
import com.raytheon.uf.common.status.UFStatus;
import com.raytheon.uf.common.status.UFStatus.Priority;
import com.raytheon.uf.common.time.BinOffset;
import com.raytheon.uf.common.time.DataTime;
import com.raytheon.uf.common.time.SimulatedTime;
import com.raytheon.uf.viz.core.exception.VizException;
import com.raytheon.viz.pointdata.util.AbstractPointDataInventory;
import com.raytheon.viz.pointdata.util.PointDataCubeAdapter;
import com.raytheon.viz.radar.frame.RadarDataTime;

/**
<<<<<<< HEAD
 * 
 * DataCubeAdapter for Radar Data. Passes the work for point data to radar point
 * data adapters
 * 
 * <pre>
 * 
 * SOFTWARE HISTORY
 * 
=======
 *
 * DataCubeAdapter for Radar Data. Passes the work for point data to radar point
 * data adapters
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 * Date          Ticket#  Engineer  Description
 * ------------- -------- --------- ----------------------------------------
 * Oct 08, 2009           bsteffen  Initial creation
 * Nov 21, 2009  3576     rjpeter   Refactored use of DerivParamDesc.
 * May 13, 2015  4461     bsteffen  Generate radar times from time queries.
 * Nov 02, 2015  5071     bsteffen  Fix NPE when time query of Unit Status
<<<<<<< HEAD
 * 
 * </pre>
 * 
 * @author bsteffen
 * @version 1.0
=======
 * Oct 29, 2022  8959     mapeters  Update how data time levels are set
 *
 * </pre>
 *
 * @author bsteffen
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 */
public class RadarDataCubeAdapter extends PointDataCubeAdapter {
    private static final transient IUFStatusHandler statusHandler = UFStatus
            .getHandler(RadarDataCubeAdapter.class);

    private static final String DATA_TIME_FIELD = "dataTime";

    private static final String LATEST_DATA_TIME_FIELD = "dataTime.refTime";

    private static final String LEVEL_FIELD = "primaryElevationAngle";

    private static final String ELEVATION_FIELD = "elevationNumber";

    private static final String VOLUME_FIELD = "volumeScanNumber";

    @Override
    public String[] getSupportedPlugins() {
        return new String[] { "radar" };
    }

    @Override
    public void initInventory() {
        if (inventory == null) {
            AbstractPointDataInventory pointInventory = new VwpInventory();
            try {
<<<<<<< HEAD
                pointInventory.initTree(DerivedParameterGenerator
                        .getDerParLibrary());
=======
                pointInventory
                        .initTree(DerivedParameterGenerator.getDerParLibrary());
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                this.inventory = pointInventory;
            } catch (DataCubeException e) {
                statusHandler.handle(Priority.PROBLEM, e.getLocalizedMessage(),
                        e);
            }
        }
    }

    /**
     * @param queryParams
     * @return
     * @throws VizException
     */
    @Override
    public String getType(Map<String, RequestConstraint> queryParams)
            throws VizException {
        String type = super.getType(queryParams);
        if (VwpInventory.ProductCode.toString().equals(type)) {
            return VwpInventory.Mnemonic;
        }
        return type;
    }

    @Override
<<<<<<< HEAD
    public PointDataContainer getBaseRecords(
            Collection<String> baseParameters,
=======
    public PointDataContainer getBaseRecords(Collection<String> baseParameters,
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            Map<String, RequestConstraint> queryParams)
            throws DataCubeException {
        return ((VwpInventory) inventory).getBaseRecords(baseParameters,
                queryParams);
    }

    private Collection<DataTime> processTimeQueryResponse(
            DbQueryResponse response, boolean latestOnly, BinOffset binOffset) {
        String dataTimefield = DATA_TIME_FIELD;
        if (latestOnly) {
            dataTimefield = LATEST_DATA_TIME_FIELD;
        }
<<<<<<< HEAD
        Collection<DataTime> results = new HashSet<DataTime>();
=======
        Collection<DataTime> results = new HashSet<>();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        int i = 0;
        for (Map<String, Object> map : response.getResults()) {
            DataTime time = null;
            if (latestOnly) {
                time = new DataTime((Date) map.get(dataTimefield), 0);
            } else {
                time = (DataTime) map.get(dataTimefield);
<<<<<<< HEAD
                RadarDataTime radarTime = new RadarDataTime(time);
                Number level = (Number) map.get(LEVEL_FIELD);
                radarTime.setLevelValue(level.doubleValue());
                Number elevation = (Number) map.get(ELEVATION_FIELD);
                if (elevation == null) {
                    /*
                     * Certain products such as Unit Status do not apply to a
                     * particular elevation.
                     */
                    time.setLevelValue(level.doubleValue());
                } else {
=======
                Number elevation = (Number) map.get(ELEVATION_FIELD);
                /*
                 * Certain products such as Unit Status do not apply to a
                 * particular elevation.
                 */
                if (elevation != null) {
                    RadarDataTime radarTime = new RadarDataTime(time);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                    radarTime.setElevationNumber(elevation.intValue());
                    Number volume = (Number) map.get(VOLUME_FIELD);
                    radarTime.setVolumeScanNumber(volume.intValue());
                    time = radarTime;
                }
<<<<<<< HEAD
            }
            // Best res requests need this because they span a time period
            if (time.getRefTime().before(
                    SimulatedTime.getSystemTime().getTime())) {
=======
                Number level = (Number) map.get(LEVEL_FIELD);
                time.setLevel(level.doubleValue(), RadarUtil.TILT);
            }
            // Best res requests need this because they span a time period
            if (time.getRefTime()
                    .before(SimulatedTime.getSystemTime().getTime())) {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                results.add(time);
                ++i;
            }
        }

        if (binOffset != null) {
<<<<<<< HEAD
            Set<DataTime> scaledDates = new TreeSet<DataTime>();
=======
            Set<DataTime> scaledDates = new TreeSet<>();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            for (DataTime dt : results) {
                scaledDates.add(binOffset.getNormalizedTime(dt));
            }
            results = scaledDates;
        }

        return results;
    }

    private DbQueryRequest getTimeQueryRequest(
            Map<String, RequestConstraint> queryParams, boolean latestOnly) {
        DbQueryRequest request = new DbQueryRequest();
        request.setConstraints(queryParams);

        String dataTimefield = DATA_TIME_FIELD;
        if (latestOnly) {
            dataTimefield = LATEST_DATA_TIME_FIELD;
        }
        request.addRequestField(dataTimefield, latestOnly);
        if (!latestOnly) {
            request.addRequestField(LEVEL_FIELD);
            request.addRequestField(ELEVATION_FIELD);
            request.addRequestField(VOLUME_FIELD);
        }
        request.setDistinct(true);
        return request;
    }

    @Override
    public List<List<DataTime>> timeQuery(List<TimeQueryRequest> requests)
            throws DataCubeException {
<<<<<<< HEAD
        List<DbQueryRequest> dbRequests = new ArrayList<DbQueryRequest>(
                requests.size());
=======
        List<DbQueryRequest> dbRequests = new ArrayList<>(requests.size());
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        for (TimeQueryRequest request : requests) {
            dbRequests.add(getTimeQueryRequest(request.getQueryTerms(),
                    request.isMaxQuery()));
        }
        DbQueryRequestSet requestSet = new DbQueryRequestSet();
        requestSet.setQueries(dbRequests.toArray(new DbQueryRequest[0]));
        DbQueryResponseSet responseSet;
        try {
            responseSet = (DbQueryResponseSet) RequestRouter.route(requestSet);
        } catch (Exception e) {
            throw new DataCubeException(e);
        }
<<<<<<< HEAD
        List<List<DataTime>> result = new ArrayList<List<DataTime>>(
                requests.size());
=======
        List<List<DataTime>> result = new ArrayList<>(requests.size());
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        for (int i = 0; i < requests.size(); i++) {
            DbQueryResponse response = responseSet.getResults()[i];
            TimeQueryRequest request = requests.get(i);
            Collection<DataTime> times = processTimeQueryResponse(response,
                    request.isMaxQuery(), request.getBinOffset());

<<<<<<< HEAD
            result.add(new ArrayList<DataTime>(times));
=======
            result.add(new ArrayList<>(times));
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        }
        return result;
    }
}
