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
package com.raytheon.uf.common.dataplugin.modelsounding;

<<<<<<< HEAD
import static com.raytheon.uf.common.dataplugin.modelsounding.ModelSoundingParameters.CLOUD_PRESS;
import static com.raytheon.uf.common.dataplugin.modelsounding.ModelSoundingParameters.CONV_PRECIP;
import static com.raytheon.uf.common.dataplugin.modelsounding.ModelSoundingParameters.FREEZING_RAIN_TYPE;
import static com.raytheon.uf.common.dataplugin.modelsounding.ModelSoundingParameters.HIGH_CLOUD;
import static com.raytheon.uf.common.dataplugin.modelsounding.ModelSoundingParameters.ICE_TYPE;
import static com.raytheon.uf.common.dataplugin.modelsounding.ModelSoundingParameters.LOW_CLOUD;
import static com.raytheon.uf.common.dataplugin.modelsounding.ModelSoundingParameters.MAX_TEMP;
import static com.raytheon.uf.common.dataplugin.modelsounding.ModelSoundingParameters.MID_CLOUD;
import static com.raytheon.uf.common.dataplugin.modelsounding.ModelSoundingParameters.MIN_TEMP;
import static com.raytheon.uf.common.dataplugin.modelsounding.ModelSoundingParameters.NUM_LEVELS;
import static com.raytheon.uf.common.dataplugin.modelsounding.ModelSoundingParameters.RAIN_TYPE;
import static com.raytheon.uf.common.dataplugin.modelsounding.ModelSoundingParameters.SEA_LEVEL_PRESS;
import static com.raytheon.uf.common.dataplugin.modelsounding.ModelSoundingParameters.SENS_HEAT;
import static com.raytheon.uf.common.dataplugin.modelsounding.ModelSoundingParameters.SFC_PRESS;
import static com.raytheon.uf.common.dataplugin.modelsounding.ModelSoundingParameters.SKIN_TEMP;
import static com.raytheon.uf.common.dataplugin.modelsounding.ModelSoundingParameters.SNOW_FALL;
import static com.raytheon.uf.common.dataplugin.modelsounding.ModelSoundingParameters.SNOW_FLUX;
import static com.raytheon.uf.common.dataplugin.modelsounding.ModelSoundingParameters.SNOW_MELT;
import static com.raytheon.uf.common.dataplugin.modelsounding.ModelSoundingParameters.SNOW_TYPE;
import static com.raytheon.uf.common.dataplugin.modelsounding.ModelSoundingParameters.SNOW_WATER;
import static com.raytheon.uf.common.dataplugin.modelsounding.ModelSoundingParameters.SPEC_HUM_10M;
import static com.raytheon.uf.common.dataplugin.modelsounding.ModelSoundingParameters.SPEC_HUM_2M;
import static com.raytheon.uf.common.dataplugin.modelsounding.ModelSoundingParameters.STORM_REL_HELI;
import static com.raytheon.uf.common.dataplugin.modelsounding.ModelSoundingParameters.SUB_SFC_HEAT;
import static com.raytheon.uf.common.dataplugin.modelsounding.ModelSoundingParameters.TEMP_2M;
import static com.raytheon.uf.common.dataplugin.modelsounding.ModelSoundingParameters.THETA_10M;
import static com.raytheon.uf.common.dataplugin.modelsounding.ModelSoundingParameters.TOTAL_PRECIP;
import static com.raytheon.uf.common.dataplugin.modelsounding.ModelSoundingParameters.U_COMP_10M;
import static com.raytheon.uf.common.dataplugin.modelsounding.ModelSoundingParameters.U_STORM;
import static com.raytheon.uf.common.dataplugin.modelsounding.ModelSoundingParameters.VISIBILITY;
import static com.raytheon.uf.common.dataplugin.modelsounding.ModelSoundingParameters.V_COMP_10M;
import static com.raytheon.uf.common.dataplugin.modelsounding.ModelSoundingParameters.V_STORM;

=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
<<<<<<< HEAD
=======
import javax.persistence.Index;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

<<<<<<< HEAD
import org.hibernate.annotations.Index;
=======
import org.locationtech.jts.geom.Geometry;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

import com.raytheon.uf.common.dataplugin.PluginDataObject;
import com.raytheon.uf.common.dataplugin.annotations.DataURI;
import com.raytheon.uf.common.dataplugin.annotations.NullString;
import com.raytheon.uf.common.dataplugin.persist.IPersistable;
import com.raytheon.uf.common.dataplugin.persist.PersistablePluginDataObject;
import com.raytheon.uf.common.geospatial.ISpatialEnabled;
import com.raytheon.uf.common.pointdata.IPointData;
import com.raytheon.uf.common.pointdata.PointDataView;
import com.raytheon.uf.common.pointdata.spatial.SurfaceObsLocation;
import com.raytheon.uf.common.serialization.annotations.DynamicSerialize;
import com.raytheon.uf.common.serialization.annotations.DynamicSerializeElement;
<<<<<<< HEAD
import org.locationtech.jts.geom.Geometry;
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

/**
 * The SoundingSite class encapsulates the location and time information for a
 * model sounding forecast as well as providing a container for the vertical
 * level data above the location.
<<<<<<< HEAD
 * 
=======
 *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 * <pre>
 * SOFTWARE HISTORY
 * Date          Ticket#  Engineer    Description
 * ------------- -------- ----------- -----------------------------------------
 * Mar 03, 2008  1026     jkorman     Initial implementation.
 * Apr 04, 2013  1846     bkowal      Added an index on refTime and
 *                                    forecastTime
 * Apr 12, 2013  1857     bgonzale    Added SequenceGenerator annotation.
 * May 07, 2013  1869     bsteffen    Remove dataURI column from
 *                                    PluginDataObject.
 * Aug 30, 2013  2298     rjpeter     Make getPluginName abstract
 * Dec 02, 2013  2537     bsteffen    Move to common, remove IDecoderGettable,
 *                                    remove unnecessary fields.
 * Jul 27, 2015  4360     rferrel     Named unique constraint. Made reportType non-nullable.
<<<<<<< HEAD
 * 
 * </pre>
 * 
 * @author jkorman
 * @version 1.0
 */
@Entity
@SequenceGenerator(initialValue = 1, name = PluginDataObject.ID_GEN, sequenceName = "modelsoundingseq")
@Table(name = "modelsounding", uniqueConstraints = { @UniqueConstraint(name = "uk_modelsounding_datauri_fields", columnNames = { "dataURI" }) })
=======
 * Aug 08, 2022  8892     tjensen     Update indexes for Hibernate 5
 *
 * </pre>
 *
 * @author jkorman
 */
@Entity
@SequenceGenerator(initialValue = 1, name = PluginDataObject.ID_GEN, sequenceName = "modelsoundingseq")
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
/*
 * Both refTime and forecastTime are included in the refTimeIndex since
 * forecastTime is unlikely to be used.
 */
<<<<<<< HEAD
@org.hibernate.annotations.Table(appliesTo = "modelsounding", indexes = { @Index(name = "modelsounding_refTimeIndex", columnNames = {
        "refTime", "forecastTime" }) })
@DynamicSerialize
public class SoundingSite extends PersistablePluginDataObject implements
        ISpatialEnabled, IPointData, IPersistable {

    public static String PLUGIN_ID = "modelsounding";
=======
@Table(name = "modelsounding", uniqueConstraints = {
        @UniqueConstraint(name = "uk_modelsounding_datauri_fields", columnNames = {
                "dataURI" }) }, indexes = {
                        @Index(name = "%TABLE%_refTimeIndex", columnList = "refTime, forecastTime"),
                        @Index(name = "%TABLE%_stationIndex", columnList = "stationId") })

@DynamicSerialize
public class SoundingSite extends PersistablePluginDataObject
        implements ISpatialEnabled, IPointData, IPersistable {

    public static final String PLUGIN_ID = "modelsounding";
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    private static final long serialVersionUID = 1L;

    // These site ids are not strictly ICAO ids!
    @Column
    @DynamicSerializeElement
    private String siteId;

    @DataURI(position = 1)
    @NullString
    @Column(nullable = false)
    @DynamicSerializeElement
    private String reportType;

    @Embedded
    @DataURI(position = 2, embedded = true)
    @DynamicSerializeElement
    private SurfaceObsLocation location;

    @Embedded
    @DynamicSerializeElement
    private PointDataView pointDataView;

    // Text of the WMO header
    @Column
    @DynamicSerializeElement
    private String wmoHeader;

    // the level data
    @Transient
    private Set<SoundingLevel> levels;

    /**
     * Create an empty ProfilerObs object.
     */
    public SoundingSite() {
    }

    /**
     * Constructor for DataURI construction through base class. This is used by
     * the notification service.
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param uri
     *            A data uri applicable to this class.
     * @param tableDef
     *            The table definitions for this class.
     */
    public SoundingSite(String uri) {
        super(uri);
    }

    /**
     * Get the observation time for this data.
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @return The data observation time.
     */
    public Calendar getTimeObs() {
        return dataTime.getRefTimeAsCalendar();
    }

    /**
     * @return the fcstSeconds
     */
    public Long getFcstSeconds() {
        return (long) dataTime.getFcstTime();
    }

    /**
     * Get this observation's geometry.
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @return The geometry for this observation.
     */
    public Geometry getGeometry() {
        return location.getGeometry();
    }

    /**
     * Get the geometry latitude.
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @return The geometry latitude.
     */
    public double getLatitude() {
        return location.getLatitude();
    }

    /**
     * Get the geometry longitude.
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @return The geometry longitude.
     */
    public double getLongitude() {
        return location.getLongitude();
    }

    /**
     * Get the station identifier for this observation.
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @return the stationId
     */
    public String getStationId() {
        return location.getStationId();
    }

    /**
     * Get the elevation, in meters, of the observing platform or location.
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @return The observation elevation, in meters.
     */
    public Integer getElevation() {
        return location.getElevation();
    }

    /**
     * Was this location defined from the station catalog? False if not.
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @return Was this location defined from the station catalog?
     */
    public Boolean getLocationDefined() {
        return location.getLocationDefined();
    }

    /**
     * Set the WMOHeader of the file that contained this data.
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @return The wmoHeader
     */
    public String getWmoHeader() {
        return wmoHeader;
    }

    /**
     * Get the WMOHeader of the file that contained this data.
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param wmoHeader
     *            The WMOHeader to set
     */
    public void setWmoHeader(String wmoHeader) {
        this.wmoHeader = wmoHeader;
    }

    private void populateLevels() {
        if (levels == null) {
<<<<<<< HEAD
            int count = pointDataView.getInt(NUM_LEVELS);
            if (count < 0) {
                count = 0;
            }
            levels = new HashSet<SoundingLevel>(count, 1.0f);
=======
            int count = pointDataView
                    .getInt(ModelSoundingParameters.NUM_LEVELS);
            if (count < 0) {
                count = 0;
            }
            levels = new HashSet<>(count, 1.0f);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            for (int i = 0; i < count; i += 1) {
                levels.add(new SoundingLevel(pointDataView, i));
            }
        }
    }

    public SoundingLevel addLevel() {
        populateLevels();
        SoundingLevel level = new SoundingLevel(pointDataView, levels.size());
        levels.add(level);
<<<<<<< HEAD
        pointDataView.setInt(NUM_LEVELS, levels.size());
=======
        pointDataView.setInt(ModelSoundingParameters.NUM_LEVELS, levels.size());
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        return level;
    }

    /**
     * Get all levels contained by this object.
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @return the levels
     */
    public Set<SoundingLevel> getLevels() {
        populateLevels();
        return Collections.unmodifiableSet(levels);
    }

    /**
     * @return the siteId
     */
    public String getSiteId() {
        return siteId;
    }

    /**
     * @param siteId
     *            the siteId to set
     */
    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    /**
     * @return the reportType
     */
    public String getReportType() {
        return reportType;
    }

    /**
     * @param reportType
     *            the reportType to set
     */
    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    /** @return the pressSLP */
    public float getPressSLP() {
<<<<<<< HEAD
        return pointDataView.getFloat(SEA_LEVEL_PRESS);
=======
        return pointDataView.getFloat(ModelSoundingParameters.SEA_LEVEL_PRESS);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * @param pressSLP
     *            the pressSLP to set
     */
    public void setPressSLP(float pressSLP) {
<<<<<<< HEAD
        pointDataView.setFloat(SEA_LEVEL_PRESS, pressSLP);
=======
        pointDataView.setFloat(ModelSoundingParameters.SEA_LEVEL_PRESS,
                pressSLP);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /** @return the pressSfc */
    public float getPressSfc() {
<<<<<<< HEAD
        return pointDataView.getFloat(SFC_PRESS);
=======
        return pointDataView.getFloat(ModelSoundingParameters.SFC_PRESS);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * @param pressSfc
     *            the pressSfc to set
     */
    public void setPressSfc(float pressSfc) {
<<<<<<< HEAD
        pointDataView.setFloat(SFC_PRESS, pressSfc);
=======
        pointDataView.setFloat(ModelSoundingParameters.SFC_PRESS, pressSfc);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /** @return the cldAmtLo */
    public float getCldAmtLo() {
<<<<<<< HEAD
        return pointDataView.getFloat(LOW_CLOUD);
=======
        return pointDataView.getFloat(ModelSoundingParameters.LOW_CLOUD);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * @param cldAmtLo
     *            the cldAmtLo to set
     */
    public void setCldAmtLo(float cldAmtLo) {
<<<<<<< HEAD
        pointDataView.setFloat(LOW_CLOUD, cldAmtLo);
=======
        pointDataView.setFloat(ModelSoundingParameters.LOW_CLOUD, cldAmtLo);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /** @return the cldAmtMd */
    public float getCldAmtMd() {
<<<<<<< HEAD
        return pointDataView.getFloat(MID_CLOUD);
=======
        return pointDataView.getFloat(ModelSoundingParameters.MID_CLOUD);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * @param cldAmtMd
     *            the cldAmtMd to set
     */
    public void setCldAmtMd(float cldAmtMd) {
<<<<<<< HEAD
        pointDataView.setFloat(MID_CLOUD, cldAmtMd);
=======
        pointDataView.setFloat(ModelSoundingParameters.MID_CLOUD, cldAmtMd);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /** @return the cldAmtHi */
    public float getCldAmtHi() {
<<<<<<< HEAD
        return pointDataView.getFloat(HIGH_CLOUD);
=======
        return pointDataView.getFloat(ModelSoundingParameters.HIGH_CLOUD);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * @param cldAmtHi
     *            the cldAmtHi to set
     */
    public void setCldAmtHi(float cldAmtHi) {
<<<<<<< HEAD
        pointDataView.setFloat(HIGH_CLOUD, cldAmtHi);
=======
        pointDataView.setFloat(ModelSoundingParameters.HIGH_CLOUD, cldAmtHi);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /** @return the pressCldBase */
    public float getPressCldBase() {
<<<<<<< HEAD
        return pointDataView.getFloat(CLOUD_PRESS);
=======
        return pointDataView.getFloat(ModelSoundingParameters.CLOUD_PRESS);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * @param pressCldBase
     *            the pressCldBase to set
     */
    public void setPressCldBase(float pressCldBase) {
<<<<<<< HEAD
        pointDataView.setFloat(CLOUD_PRESS, pressCldBase);
=======
        pointDataView.setFloat(ModelSoundingParameters.CLOUD_PRESS,
                pressCldBase);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /** @return the uc10Meter */
    public float getUc10M() {
<<<<<<< HEAD
        return pointDataView.getFloat(U_COMP_10M);
=======
        return pointDataView.getFloat(ModelSoundingParameters.U_COMP_10M);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * @param uc10Meter
     *            the uc10Meter to set
     */
    public void setUc10M(float uc10M) {
<<<<<<< HEAD
        pointDataView.setFloat(U_COMP_10M, uc10M);
=======
        pointDataView.setFloat(ModelSoundingParameters.U_COMP_10M, uc10M);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /** @return the vc10M */
    public float getVc10M() {
<<<<<<< HEAD
        return pointDataView.getFloat(V_COMP_10M);
=======
        return pointDataView.getFloat(ModelSoundingParameters.V_COMP_10M);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * @param vc10M
     *            the vc10M to set
     */
    public void setVc10M(float vc10M) {
<<<<<<< HEAD
        pointDataView.setFloat(V_COMP_10M, vc10M);
=======
        pointDataView.setFloat(ModelSoundingParameters.V_COMP_10M, vc10M);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /** @return the sensHeat */
    public float getSensHeat() {
<<<<<<< HEAD
        return pointDataView.getFloat(SENS_HEAT);
=======
        return pointDataView.getFloat(ModelSoundingParameters.SENS_HEAT);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * @param sensHeat
     *            the sensHeat to set
     */
    public void setSensHeat(float sensHeat) {
<<<<<<< HEAD
        pointDataView.setFloat(SENS_HEAT, sensHeat);
=======
        pointDataView.setFloat(ModelSoundingParameters.SENS_HEAT, sensHeat);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /** @return the subSfcHeat */
    public float getSubSfcHeat() {
<<<<<<< HEAD
        return pointDataView.getFloat(SUB_SFC_HEAT);
=======
        return pointDataView.getFloat(ModelSoundingParameters.SUB_SFC_HEAT);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * @param subSfcHeat
     *            the subSfcHeat to set
     */
    public void setSubSfcHeat(float subSfcHeat) {
<<<<<<< HEAD
        pointDataView.setFloat(SUB_SFC_HEAT, subSfcHeat);
=======
        pointDataView.setFloat(ModelSoundingParameters.SUB_SFC_HEAT,
                subSfcHeat);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /** @return the minTemp */
    public float getMinTemp() {
<<<<<<< HEAD
        return pointDataView.getFloat(MIN_TEMP);
=======
        return pointDataView.getFloat(ModelSoundingParameters.MIN_TEMP);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * @param minTemp
     *            the minTemp to set
     */
    public void setMinTemp(float minTemp) {
<<<<<<< HEAD
        pointDataView.setFloat(MIN_TEMP, minTemp);
=======
        pointDataView.setFloat(ModelSoundingParameters.MIN_TEMP, minTemp);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /** @return the maxTemp */
    public float getMaxTemp() {
<<<<<<< HEAD
        return pointDataView.getFloat(MAX_TEMP);
=======
        return pointDataView.getFloat(ModelSoundingParameters.MAX_TEMP);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * @param maxTemp
     *            the maxTemp to set
     */
    public void setMaxTemp(float maxTemp) {
<<<<<<< HEAD
        pointDataView.setFloat(MAX_TEMP, maxTemp);
=======
        pointDataView.setFloat(ModelSoundingParameters.MAX_TEMP, maxTemp);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /** @return the skinTemp */
    public float getSkinTemp() {
<<<<<<< HEAD
        return pointDataView.getFloat(SKIN_TEMP);
=======
        return pointDataView.getFloat(ModelSoundingParameters.SKIN_TEMP);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * @param skinTemp
     *            the skinTemp to set
     */
    public void setSkinTemp(float skinTemp) {
<<<<<<< HEAD
        pointDataView.setFloat(SKIN_TEMP, skinTemp);
=======
        pointDataView.setFloat(ModelSoundingParameters.SKIN_TEMP, skinTemp);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /** @return the temp2M */
    public float getTemp2M() {
<<<<<<< HEAD
        return pointDataView.getFloat(TEMP_2M);
=======
        return pointDataView.getFloat(ModelSoundingParameters.TEMP_2M);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * @param temp2M
     *            the temp2M to set
     */
    public void setTemp2M(float temp2M) {
<<<<<<< HEAD
        pointDataView.setFloat(TEMP_2M, temp2M);
=======
        pointDataView.setFloat(ModelSoundingParameters.TEMP_2M, temp2M);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /** @return the specHum2M */
    public float getSpecHum2M() {
<<<<<<< HEAD
        return pointDataView.getFloat(SPEC_HUM_2M);
=======
        return pointDataView.getFloat(ModelSoundingParameters.SPEC_HUM_2M);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * @param specHum2M
     *            the specHum2M to set
     */
    public void setSpecHum2M(float specHum2M) {
<<<<<<< HEAD
        pointDataView.setFloat(SPEC_HUM_2M, specHum2M);
=======
        pointDataView.setFloat(ModelSoundingParameters.SPEC_HUM_2M, specHum2M);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /** @return the specHum10M */
    public float getSpecHum10M() {
<<<<<<< HEAD
        return pointDataView.getFloat(SPEC_HUM_10M);
=======
        return pointDataView.getFloat(ModelSoundingParameters.SPEC_HUM_10M);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * @param specHum10M
     *            the specHum10M to set
     */
    public void setSpecHum10M(float specHum10M) {
<<<<<<< HEAD
        pointDataView.setFloat(SPEC_HUM_10M, specHum10M);
=======
        pointDataView.setFloat(ModelSoundingParameters.SPEC_HUM_10M,
                specHum10M);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /** @return the theta10M */
    public float getTheta10M() {
<<<<<<< HEAD
        return pointDataView.getFloat(THETA_10M);
=======
        return pointDataView.getFloat(ModelSoundingParameters.THETA_10M);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * @param theta10M
     *            the theta10M to set
     */
    public void setTheta10M(float theta10M) {
<<<<<<< HEAD
        pointDataView.setFloat(THETA_10M, theta10M);
=======
        pointDataView.setFloat(ModelSoundingParameters.THETA_10M, theta10M);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /** @return the snowType */
    public int getSnowType() {
<<<<<<< HEAD
        return pointDataView.getInt(SNOW_TYPE);
=======
        return pointDataView.getInt(ModelSoundingParameters.SNOW_TYPE);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * @param snowType
     *            the snowType to set
     */
    public void setSnowType(int snowType) {
<<<<<<< HEAD
        pointDataView.setInt(SNOW_TYPE, snowType);
=======
        pointDataView.setInt(ModelSoundingParameters.SNOW_TYPE, snowType);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /** @return the iceType */
    public int getIceType() {
<<<<<<< HEAD
        return pointDataView.getInt(ICE_TYPE);
=======
        return pointDataView.getInt(ModelSoundingParameters.ICE_TYPE);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * @param iceType
     *            the iceType to set
     */
    public void setIceType(int iceType) {
<<<<<<< HEAD
        pointDataView.setInt(ICE_TYPE, iceType);
=======
        pointDataView.setInt(ModelSoundingParameters.ICE_TYPE, iceType);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /** @return the fzRainType */
    public int getFzRainType() {
<<<<<<< HEAD
        return pointDataView.getInt(FREEZING_RAIN_TYPE);
=======
        return pointDataView.getInt(ModelSoundingParameters.FREEZING_RAIN_TYPE);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * @param fzRainType
     *            the fzRainType to set
     */
    public void setFzRainType(int fzRainType) {
<<<<<<< HEAD
        pointDataView.setInt(FREEZING_RAIN_TYPE, fzRainType);
=======
        pointDataView.setInt(ModelSoundingParameters.FREEZING_RAIN_TYPE,
                fzRainType);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /** @return the rainType */
    public int getRainType() {
<<<<<<< HEAD
        return pointDataView.getInt(RAIN_TYPE);
=======
        return pointDataView.getInt(ModelSoundingParameters.RAIN_TYPE);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * @param rainType
     *            the rainType to set
     */
    public void setRainType(int rainType) {
<<<<<<< HEAD
        pointDataView.setInt(RAIN_TYPE, rainType);
=======
        pointDataView.setInt(ModelSoundingParameters.RAIN_TYPE, rainType);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /** @return the horzVis */
    public float getHorzVis() {
<<<<<<< HEAD
        return pointDataView.getFloat(VISIBILITY);
=======
        return pointDataView.getFloat(ModelSoundingParameters.VISIBILITY);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * @param horzVis
     *            the horzVis to set
     */
    public void setHorzVis(float horzVis) {
<<<<<<< HEAD
        pointDataView.setFloat(VISIBILITY, horzVis);
=======
        pointDataView.setFloat(ModelSoundingParameters.VISIBILITY, horzVis);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /** @return the stormUComp */
    public float getStormUComp() {
<<<<<<< HEAD
        return pointDataView.getFloat(U_STORM);
=======
        return pointDataView.getFloat(ModelSoundingParameters.U_STORM);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * @param stormUComp
     *            the stormUComp to set
     */
    public void setStormUComp(float stormUComp) {
<<<<<<< HEAD
        pointDataView.setFloat(U_STORM, stormUComp);
=======
        pointDataView.setFloat(ModelSoundingParameters.U_STORM, stormUComp);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /** @return the stormVComp */
    public float getStormVComp() {
<<<<<<< HEAD
        return pointDataView.getFloat(V_STORM);
=======
        return pointDataView.getFloat(ModelSoundingParameters.V_STORM);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * @param stormVComp
     *            the stormVComp to set
     */
    public void setStormVComp(float stormVComp) {
<<<<<<< HEAD
        pointDataView.setFloat(V_STORM, stormVComp);
=======
        pointDataView.setFloat(ModelSoundingParameters.V_STORM, stormVComp);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /** @return the stormRelHeli */
    public float getStormRelHeli() {
<<<<<<< HEAD
        return pointDataView.getFloat(STORM_REL_HELI);
=======
        return pointDataView.getFloat(ModelSoundingParameters.STORM_REL_HELI);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * @param stormRelHeli
     *            the stormRelHeli to set
     */
    public void setStormRelHeli(float stormRelHeli) {
<<<<<<< HEAD
        pointDataView.setFloat(STORM_REL_HELI, stormRelHeli);
=======
        pointDataView.setFloat(ModelSoundingParameters.STORM_REL_HELI,
                stormRelHeli);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /** @return the totPrecip */
    public float getTotPrecip() {
<<<<<<< HEAD
        return pointDataView.getFloat(TOTAL_PRECIP);
=======
        return pointDataView.getFloat(ModelSoundingParameters.TOTAL_PRECIP);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * @param totPrecip
     *            the totPrecip to set
     */
    public void setTotPrecip(float totPrecip) {
<<<<<<< HEAD
        pointDataView.setFloat(TOTAL_PRECIP, totPrecip);
=======
        pointDataView.setFloat(ModelSoundingParameters.TOTAL_PRECIP, totPrecip);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /** @return the precipConv */
    public float getPrecipConv() {
<<<<<<< HEAD
        return pointDataView.getFloat(CONV_PRECIP);
=======
        return pointDataView.getFloat(ModelSoundingParameters.CONV_PRECIP);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * @param precipConv
     *            the precipConv to set
     */
    public void setPrecipConv(float precipConv) {
<<<<<<< HEAD
        pointDataView.setFloat(CONV_PRECIP, precipConv);
=======
        pointDataView.setFloat(ModelSoundingParameters.CONV_PRECIP, precipConv);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /** @return the snowWaterEquiv */
    public float getSnowWaterEquiv() {
<<<<<<< HEAD
        return pointDataView.getFloat(SNOW_WATER);
=======
        return pointDataView.getFloat(ModelSoundingParameters.SNOW_WATER);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * @param snowWaterEquiv
     *            the snowWaterEquiv to set
     */
    public void setSnowWaterEquiv(float snowWaterEquiv) {
<<<<<<< HEAD
        pointDataView.setFloat(SNOW_WATER, snowWaterEquiv);
=======
        pointDataView.setFloat(ModelSoundingParameters.SNOW_WATER,
                snowWaterEquiv);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /** @return the snowFall */
    public float getSnowFall() {
<<<<<<< HEAD
        return pointDataView.getFloat(SNOW_FALL);
=======
        return pointDataView.getFloat(ModelSoundingParameters.SNOW_FALL);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * @param snowFall
     *            the snowFall to set
     */
    public void setSnowFall(float snowFall) {
<<<<<<< HEAD
        pointDataView.setFloat(SNOW_FALL, snowFall);
=======
        pointDataView.setFloat(ModelSoundingParameters.SNOW_FALL, snowFall);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * @param snowMelt
     *            the snowMelt to set
     */
    public void setSnowMelt(float snowMelt) {
<<<<<<< HEAD
        pointDataView.setFloat(SNOW_MELT, snowMelt);
=======
        pointDataView.setFloat(ModelSoundingParameters.SNOW_MELT, snowMelt);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /** @return the snowFlux */
    public float getSnowMFlux() {
<<<<<<< HEAD
        return pointDataView.getFloat(SNOW_FLUX);
=======
        return pointDataView.getFloat(ModelSoundingParameters.SNOW_FLUX);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * @param snowFlux
     *            the snowFlux to set
     */
    public void setSnowFlux(float snowFlux) {
<<<<<<< HEAD
        pointDataView.setFloat(SNOW_FLUX, snowFlux);
=======
        pointDataView.setFloat(ModelSoundingParameters.SNOW_FLUX, snowFlux);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /** @return the snowMelt */
    public float getSnowMelt() {
<<<<<<< HEAD
        return pointDataView.getFloat(SNOW_MELT);
=======
        return pointDataView.getFloat(ModelSoundingParameters.SNOW_MELT);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    @Override
    public SurfaceObsLocation getSpatialObject() {
        return location;
    }

    public SurfaceObsLocation getLocation() {
        return location;
    }

    public void setLocation(SurfaceObsLocation location) {
        this.location = location;
    }

    @Override
    public PointDataView getPointDataView() {
        return this.pointDataView;
    }

    @Override
    public void setPointDataView(PointDataView pointDataView) {
        this.pointDataView = pointDataView;
    }

    @Override
    @Column
    @Access(AccessType.PROPERTY)
    public String getDataURI() {
        return super.getDataURI();
    }

    @Override
    public String getPluginName() {
        return PLUGIN_ID;
    }
}
