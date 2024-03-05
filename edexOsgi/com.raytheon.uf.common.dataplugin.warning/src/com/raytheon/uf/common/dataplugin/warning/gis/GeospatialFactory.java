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
package com.raytheon.uf.common.dataplugin.warning.gis;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

<<<<<<< HEAD
=======
import org.locationtech.jts.geom.prep.PreparedGeometryFactory;

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import com.raytheon.uf.common.dataplugin.warning.WarningConstants;
import com.raytheon.uf.common.dataplugin.warning.config.AreaSourceConfiguration;
import com.raytheon.uf.common.dataplugin.warning.config.GeospatialConfiguration;
import com.raytheon.uf.common.dataplugin.warning.config.WarngenConfiguration;
import com.raytheon.uf.common.geospatial.SpatialException;
import com.raytheon.uf.common.localization.ILocalizationFile;
import com.raytheon.uf.common.localization.IPathManager;
import com.raytheon.uf.common.localization.LocalizationContext;
import com.raytheon.uf.common.localization.LocalizationContext.LocalizationLevel;
import com.raytheon.uf.common.localization.LocalizationContext.LocalizationType;
import com.raytheon.uf.common.localization.PathManagerFactory;
import com.raytheon.uf.common.localization.exception.LocalizationException;
import com.raytheon.uf.common.serialization.SerializationException;
import com.raytheon.uf.common.serialization.SerializationUtil;
import com.raytheon.uf.common.serialization.SingleTypeJAXBManager;
import com.raytheon.uf.common.serialization.comm.RequestRouter;
<<<<<<< HEAD
import com.raytheon.uf.common.status.IUFStatusHandler;
import com.raytheon.uf.common.status.UFStatus;
import com.raytheon.uf.common.status.UFStatus.Priority;
import org.locationtech.jts.geom.prep.PreparedGeometryFactory;
=======
import com.raytheon.uf.common.status.IPerformanceStatusHandler;
import com.raytheon.uf.common.status.IUFStatusHandler;
import com.raytheon.uf.common.status.PerformanceStatus;
import com.raytheon.uf.common.status.UFStatus;
import com.raytheon.uf.common.status.UFStatus.Priority;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

/**
 * Retrieves geospatial data from disk if present, otherwise forwards request to
 * maps database
<<<<<<< HEAD
 * 
 * <pre>
 * 
 * SOFTWARE HISTORY
 * 
 * Date         Ticket#    Engineer    Description
 * ------------ ---------- ----------- --------------------------
 * Jul 18, 2011            rjpeter     Initial creation
 * Mar 29, 2012  #14691    Qinglu Lin  Added returned value of getFeAreaField() of 
 *                                     AreaSourceConfiguration to areaFields List.
 * Apr 11, 2012  #14691    Qinglu Lin  For marine warnings, getFeAreaField() returns null.
 *                                     So, do not add the returned value of getFeAreaField() 
 *                                     to areaFields.
 * Jan  9, 2013   15600    Qinglu Lin  Execute "timezones = myTimeZones;" even if timezones != null.
 * Oct 22, 2013   2361     njensen     Use JAXBManager for XML
 * Jun 17, 2014  DR 17390  Qinglu Lin  Updated getMetaDataMap() for lonField and latField.
 * Aug 21, 2014   3353     rferrel     Generating Geo Spatial data set no longer on the UI thread.
 * Feb 24, 2015   3978     njensen     Use openInputStream() for reading file contents
 * Dec  9, 2015 ASM #18209 D. Friedman Support cwaStretch.
 * Jan 12, 2016 5244       njensen     Replaced calls to deprecated LocalizationFile methods
 * 
 * </pre>
 * 
 * @author rjpeter
 * @version 1.0
=======
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 *
 * Date          Ticket#  Engineer     Description
 * ------------- -------- ------------ -----------------------------------------
 * Jul 18, 2011           rjpeter      Initial creation
 * Mar 29, 2012  14691    Qinglu Lin   Added returned value of getFeAreaField()
 *                                     of AreaSourceConfiguration to areaFields
 *                                     List.
 * Apr 11, 2012  14691    Qinglu Lin   For marine warnings, getFeAreaField()
 *                                     returns null. So, do not add the returned
 *                                     value of getFeAreaField() to areaFields.
 * Jan 09, 2013  15600    Qinglu Lin   Execute "timezones = myTimeZones;" even
 *                                     if timezones != null.
 * Oct 22, 2013  2361     njensen      Use JAXBManager for XML
 * Jun 17, 2014  17390    Qinglu Lin   Updated getMetaDataMap() for lonField and
 *                                     latField.
 * Aug 21, 2014  3353     rferrel      Generating Geo Spatial data set no longer
 *                                     on the UI thread.
 * Feb 24, 2015  3978     njensen      Use openInputStream() for reading file
 *                                     contents
 * Dec 09, 2015  18209    D. Friedman  Support cwaStretch.
 * Jan 12, 2016  5244     njensen      Replaced calls to deprecated
 *                                     LocalizationFile methods
 * Dec 16, 2021  8341     randerso     Changed to use performance logging
 *
 * </pre>
 *
 * @author rjpeter
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 */

public class GeospatialFactory {

<<<<<<< HEAD
    private static final transient IUFStatusHandler statusHandler = UFStatus
            .getHandler(GeospatialFactory.class);

=======
    private static final IUFStatusHandler statusHandler = UFStatus
            .getHandler(GeospatialFactory.class);

    private static final IPerformanceStatusHandler perfLog = PerformanceStatus
            .getHandler("GeospatialFactory");

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    public static final String GEO_DIR = "warngen/geoms/";

    public static final String METADATA_FILE = "warngen/geomMetaData.xml";

    private static GeospatialData[] timezones;

    private static SingleTypeJAXBManager<GeospatialTimeSet> jaxb = SingleTypeJAXBManager
            .createWithoutException(GeospatialTimeSet.class);

    /**
     * Get existing geospatial data set or null if it does not exist.
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param site
     * @param metaData
     * @return dataSet
     * @throws Exception
     */
    public static GeospatialDataSet getGeoSpatialDataSet(String site,
            GeospatialMetadata metaData) throws Exception {
        GenerateGeospatialTimeSetRequest request = new GenerateGeospatialTimeSetRequest();
        request.setSite(site);
<<<<<<< HEAD
        GeospatialTimeSet timeset = null;

        timeset = (GeospatialTimeSet) RequestRouter.route(request);

        Map<GeospatialMetadata, GeospatialTime> lastRunTimeMap = loadLastRunGeoTimeSet(timeset);
        GeospatialTime lastRunTime = lastRunTimeMap.get(metaData);
        GeospatialDataSet dataSet = null;
        if (lastRunTime != null) {
            System.out.println("Loading areas from disk");
=======
        GeospatialTimeSet timeset;

        timeset = (GeospatialTimeSet) RequestRouter.route(request);

        Map<GeospatialMetadata, GeospatialTime> lastRunTimeMap = loadLastRunGeoTimeSet(
                timeset);
        GeospatialTime lastRunTime = lastRunTimeMap.get(metaData);
        GeospatialDataSet dataSet = null;
        if (lastRunTime != null) {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            // load from disk
            try {
                long t0 = System.currentTimeMillis();
                dataSet = loadAreaGeoData(site, lastRunTime);
<<<<<<< HEAD
                System.out.println("Loading areas from disk took "
                        + (System.currentTimeMillis() - t0) + "ms");
=======
                perfLog.logDuration(String.format(
                        "Loading GeoSpatialDatasets for site [%s]", site),
                        (System.currentTimeMillis() - t0));
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            } catch (Exception e) {
                statusHandler.handle(Priority.WARN,
                        "Failed to load area geometry files from disk", e);
            }
        }
        return dataSet;
    }

    /**
     * Force creation of the desired geospatial data set.
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param site
     * @param metaData
     * @return dataSet
     * @throws SpatialException
     */
    public static GeospatialDataSet generateGeospatialDataSet(String site,
            GeospatialMetadata metaData) throws SpatialException {
        // send request to server
        GenerateGeospatialDataRequest request = new GenerateGeospatialDataRequest();
        request.setMetaData(metaData);
        request.setSite(site);
        GeospatialDataSet dataSet;
        try {
            dataSet = (GeospatialDataSet) RequestRouter.route(request);
        } catch (Exception e) {
            throw new SpatialException(
                    "Server failed to generate area geometry files.", e);
        }
        return dataSet;
    }

    /**
     * Convert the geospatial data set into arrays of geospatial data.
<<<<<<< HEAD
     * <p>The first array contains the primary features (i.e., those inside
     * the CWA.)  The second array, if not null, contains the extra
     * (outside the CWA) features.
     * 
=======
     * <p>
     * The first array contains the primary features (i.e., those inside the
     * CWA.) The second array, if not null, contains the extra (outside the CWA)
     * features.
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param dataSet
     * @param metaData
     * @return areas
     */
<<<<<<< HEAD
    public static GeospatialData[][] getGeoSpatialList(GeospatialDataSet dataSet,
            GeospatialMetadata metaData) {
=======
    public static GeospatialData[][] getGeoSpatialList(
            GeospatialDataSet dataSet, GeospatialMetadata metaData) {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

        GeospatialData[] primaryAreas = dataSet.getAreas();
        GeospatialData[] stretchAreas = dataSet.getCwaStretchAreas();
        GeospatialData[] areas;
        if (stretchAreas == null) {
            areas = primaryAreas;
        } else {
<<<<<<< HEAD
            areas = Arrays.copyOf(primaryAreas, primaryAreas.length + stretchAreas.length);
            System.arraycopy(stretchAreas, 0, areas, primaryAreas.length, stretchAreas.length);
=======
            areas = Arrays.copyOf(primaryAreas,
                    primaryAreas.length + stretchAreas.length);
            System.arraycopy(stretchAreas, 0, areas, primaryAreas.length,
                    stretchAreas.length);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        }
        GeospatialData[] parentAreas = dataSet.getParentAreas();
        GeospatialData[] myTimeZones = dataSet.getTimezones();
        if (myTimeZones != null && myTimeZones.length > 0) {
<<<<<<< HEAD
            timezones = myTimeZones;

            for (GeospatialData tz : myTimeZones) {
                tz.prepGeom = PreparedGeometryFactory.prepare(tz.geometry);
=======
            synchronized (GeospatialFactory.class) {
                timezones = myTimeZones;

                for (GeospatialData tz : myTimeZones) {
                    tz.prepGeom = PreparedGeometryFactory.prepare(tz.geometry);
                }
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            }
        }

        // process parent regions
        if (parentAreas != null) {
<<<<<<< HEAD
            Map<String, GeospatialData> parentMap = new HashMap<String, GeospatialData>(
=======
            Map<String, GeospatialData> parentMap = new HashMap<>(
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                    (int) (parentAreas.length * 1.25) + 1);
            String areaNotationField = metaData.getAreaNotationField();

            for (GeospatialData pArea : parentAreas) {
<<<<<<< HEAD
                parentMap
                        .put(String.valueOf(pArea.attributes
                                .get(areaNotationField)), pArea);
            }

            for (GeospatialData data : areas) {
                GeospatialData parentArea = parentMap.get(String
                        .valueOf(data.attributes.get(areaNotationField)));
=======
                parentMap.put(
                        String.valueOf(pArea.attributes.get(areaNotationField)),
                        pArea);
            }

            for (GeospatialData data : areas) {
                GeospatialData parentArea = parentMap.get(
                        String.valueOf(data.attributes.get(areaNotationField)));
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                data.parent = parentArea;
            }
        }

        // Prepare the geometries
        for (GeospatialData data : areas) {
            data.prepGeom = PreparedGeometryFactory.prepare(data.geometry);
        }

        return new GeospatialData[][] { primaryAreas, stretchAreas };
    }

    public static GeospatialData[] getTimezones() {
        return timezones;
    }

    /**
     * Convert the set's data into a map. When no data return empty map.
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param timeSet
     * @return geospatialTimeMap
     */
    public static Map<GeospatialMetadata, GeospatialTime> loadLastRunGeoTimeSet(
            GeospatialTimeSet timeSet) {
        Map<GeospatialMetadata, GeospatialTime> rval = timeSet.getDataAsMap();
        if (rval == null) {
<<<<<<< HEAD
            rval = new HashMap<GeospatialMetadata, GeospatialTime>();
=======
            rval = new HashMap<>();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        }
        return rval;
    }

    /**
     * Unmarshal the GeospatialTimeset in the site's metadata file.
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param site
     * @return geospatialTimeset
     */
    public static GeospatialTimeSet getGeospatialTimeSet(String site) {
        IPathManager pathMgr = PathManagerFactory.getPathManager();
        LocalizationContext context = pathMgr.getContext(
                LocalizationType.COMMON_STATIC, LocalizationLevel.CONFIGURED);
        context.setContextName(site);

        ILocalizationFile lf = pathMgr.getLocalizationFile(context,
                METADATA_FILE);
        if (lf.exists()) {
            try (InputStream is = lf.openInputStream()) {
                return jaxb.unmarshalFromInputStream(is);
            } catch (Exception e) {
                statusHandler.handle(Priority.PROBLEM, e.getLocalizedMessage(),
                        e);
            }
        }
        return new GeospatialTimeSet();
    }

    public static Map<String, GeospatialMetadata> getMetaDataMap(
            WarngenConfiguration template) {
        GeospatialConfiguration geoConfig = template.getGeospatialConfig();
<<<<<<< HEAD
        Map<String, GeospatialMetadata> rval = new HashMap<String, GeospatialMetadata>();
        AreaSourceConfiguration[] ascs = template.getAreaSources();

        for (AreaSourceConfiguration asc : ascs) {
            List<String> areaFields = new ArrayList<String>();
=======
        Map<String, GeospatialMetadata> rval = new HashMap<>();
        AreaSourceConfiguration[] ascs = template.getAreaSources();

        for (AreaSourceConfiguration asc : ascs) {
            List<String> areaFields = new ArrayList<>();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            String feAreaField = asc.getFeAreaField();
            String timeZoneField = asc.getTimeZoneField();
            areaFields.add(WarningConstants.GID);
            areaFields.add(asc.getAreaField());
            if (feAreaField != null) {
                areaFields.add(feAreaField);
            }

            areaFields.add("LON");
            areaFields.add("LAT");

            if (timeZoneField != null) {
                areaFields.add(timeZoneField);
            }
            areaFields.add(asc.getFipsField());
            areaFields.add(asc.getAreaNotationField());

            GeospatialMetadata gmd = new GeospatialMetadata();
            gmd.setAreaSource(asc.getAreaSource());
            gmd.setFipsField(asc.getFipsField());
            gmd.setAreaFields(areaFields);
            gmd.setTimeZoneSource(geoConfig.getTimezoneSource());
            gmd.setTimeZoneField(geoConfig.getTimezoneField());
            gmd.setParentAreaSource(geoConfig.getParentAreaSource());
            gmd.setAreaNotationField(asc.getAreaNotationField());
            gmd.setParentAreaField(asc.getParentAreaField());
            gmd.setCwaStretch(asc.getCwaStretch());

            rval.put(asc.getAreaSource(), gmd);
        }

        return rval;
    }

    public static GeospatialDataSet loadAreaGeoData(String site,
<<<<<<< HEAD
            GeospatialTime curTime) throws SerializationException,
            LocalizationException {
=======
            GeospatialTime curTime)
            throws SerializationException, LocalizationException {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        String fileName = curTime.getFileName();

        IPathManager pathMgr = PathManagerFactory.getPathManager();
        LocalizationContext context = pathMgr.getContext(
                LocalizationType.COMMON_STATIC, LocalizationLevel.CONFIGURED);
        context.setContextName(site);

<<<<<<< HEAD
        ILocalizationFile lf = pathMgr.getLocalizationFile(context, GEO_DIR
                + fileName);

        if (lf.exists()) {
            try (InputStream is = lf.openInputStream()) {
                return SerializationUtil.transformFromThrift(
                        GeospatialDataSet.class, is);
            } catch (IOException e) {
                throw new SerializationException("Error reading file "
                        + lf.getPath(), e);
=======
        ILocalizationFile lf = pathMgr.getLocalizationFile(context,
                GEO_DIR + fileName);

        if (lf.exists()) {
            try (InputStream is = lf.openInputStream()) {
                return SerializationUtil
                        .transformFromThrift(GeospatialDataSet.class, is);
            } catch (IOException e) {
                throw new SerializationException(
                        "Error reading file " + lf.getPath(), e);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            }
        } else {
            statusHandler.info("Attempted to load: " + lf.getPath()
                    + " for site " + site + ", but file does not exist.");
        }

        return null;
    }

}
