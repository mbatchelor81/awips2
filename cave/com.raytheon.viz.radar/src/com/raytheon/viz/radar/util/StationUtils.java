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

<<<<<<< HEAD
=======
import java.util.HashMap;
import java.util.Map;

import org.locationtech.jts.geom.Coordinate;

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import com.raytheon.uf.common.dataplugin.radar.RadarStation;
import com.raytheon.uf.common.dataplugin.radar.request.GetRadarSpatialRequest;
import com.raytheon.uf.common.status.IUFStatusHandler;
import com.raytheon.uf.common.status.UFStatus;
import com.raytheon.uf.common.status.UFStatus.Priority;
import com.raytheon.uf.viz.core.requests.ThriftClient;
import com.raytheon.uf.viz.points.IPointChangedListener;
import com.raytheon.uf.viz.points.PointsDataManager;
<<<<<<< HEAD
import org.locationtech.jts.geom.Coordinate;

/**
 * Utility for looking up home radar.
 * 
 * <pre>
 * 
 * SOFTWARE HISTORY
 * Date         Ticket#    Engineer    Description
 * ------------ ---------- ----------- --------------------------
 * Mar 19, 2010 #4473      rjpeter     Initial creation
 * Feb 25, 2013 1659       bsteffen    Cache station in StationUtils
 * 
 * </pre>
 * 
 * @author rjpeter
 * @version 1.0
 */
public class StationUtils implements IPointChangedListener {
    private static final transient IUFStatusHandler statusHandler = UFStatus
=======

/**
 * Utility for looking up home radar.
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 *
 * Date          Ticket#  Engineer  Description
 * ------------- -------- --------- -----------------------------------------
 * Mar 19, 2010  4473     rjpeter   Initial creation
 * Feb 25, 2013  1659     bsteffen  Cache station in StationUtils
 * Jul 07, 2021  8576     randerso  Added method to get RadarStation by icao
 * Jan 27, 2022  8741     njensen   Added cache of RadarStations
 *
 * </pre>
 *
 * @author rjpeter
 */
public class StationUtils implements IPointChangedListener {

    private static final IUFStatusHandler statusHandler = UFStatus
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            .getHandler(StationUtils.class);

    private RadarStation station = null;

    private static StationUtils instance;

<<<<<<< HEAD
=======
    private final Map<String, RadarStation> radarStationCache = new HashMap<>();

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    public static synchronized StationUtils getInstance() {
        if (instance == null) {
            instance = new StationUtils();
        }

        return instance;
    }

    private StationUtils() {
        PointsDataManager.getInstance().addHomeChangedListener(this);
    }

    public synchronized RadarStation getHomeRadarStation() {
        if (station == null) {
            Coordinate home = PointsDataManager.getInstance().getHome();
            station = getClosestRadarStation(home.x, home.y);
        }

        return station;
    }

    public RadarStation getClosestRadarStation(double lon, double lat) {
        GetRadarSpatialRequest request = new GetRadarSpatialRequest();
        request.setLat(lat);
        request.setLon(lon);
        try {
            Object response = ThriftClient.sendRequest(request);

            if (response != null && response instanceof RadarStation) {
                return (RadarStation) response;
            }
        } catch (Exception e) {
            statusHandler.handle(Priority.PROBLEM,
                    "Unable to retrieve home radar", e);
        }
        return null;
    }

<<<<<<< HEAD
    /*
     * (non-Javadoc)
     * 
     * @see
     * com.raytheon.viz.awipstools.IHomeChangedListener#homeLocationChanged()
     */
=======
    public RadarStation getRadarStation(String icao) {
        RadarStation radarStation = radarStationCache.get(icao);
        if (radarStation == null) {
            GetRadarSpatialRequest request = new GetRadarSpatialRequest();
            request.setIcao(icao);
            try {
                Object response = ThriftClient.sendRequest(request);

                if (response != null && response instanceof RadarStation) {
                    radarStation = (RadarStation) response;
                    radarStationCache.put(icao, radarStation);
                }
            } catch (Exception e) {
                statusHandler.handle(Priority.PROBLEM,
                        "Unable to retrieve radar " + icao, e);
            }
        }
        return radarStation;
    }

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    @Override
    public void pointChanged() {
        station = null;
    }
}
