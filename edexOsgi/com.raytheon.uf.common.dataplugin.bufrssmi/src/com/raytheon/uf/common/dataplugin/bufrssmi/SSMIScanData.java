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
package com.raytheon.uf.common.dataplugin.bufrssmi;

import java.util.Calendar;

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
import javax.xml.bind.annotation.XmlAttribute;

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
import com.raytheon.uf.common.time.util.TimeUtil;
<<<<<<< HEAD
import org.locationtech.jts.geom.Geometry;

/**
 * PluginDataObject for Special Sensor Microwave/Imager data.
 * 
 * <pre>
 * 
=======

/**
 * PluginDataObject for Special Sensor Microwave/Imager data.
 *
 * <pre>
 *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 * SOFTWARE HISTORY
 * Date         Ticket#    Engineer    Description
 * ------------ ---------- ----------- --------------------------
 * Jun 18, 2009            jkorman     Initial creation
 * Apr 04, 2013 1846       bkowal      Added an index on refTime and
 *                                     forecastTime
 * Apr 12, 2013 1857       bgonzale    Added SequenceGenerator annotation.
 * May 07, 2013 1869       bsteffen    Remove dataURI column from
 *                                     PluginDataObject.
 * May 17, 2013 1869       bsteffen    Remove DataURI column from sat plot
 *                                     types.
 * Aug 30, 2013 2298       rjpeter     Make getPluginName abstract
 * May 12, 2014 3133       njensen     Use TimeUtil instead of TimeTools
 * Jul 17, 2015 4360       rferrel     Named unique constraint and satIde no longer nullable.
<<<<<<< HEAD
 * 
 * </pre>
 * 
 * @author jkorman
 * @version 1.0
 */
@Entity
@SequenceGenerator(initialValue = 1, name = PluginDataObject.ID_GEN, sequenceName = "bufrssmiseq")
@Table(name = "bufrssmi", uniqueConstraints = { @UniqueConstraint(name = "uk_bufrssmi_datauri_fields", columnNames = {
        "stationid", "refTime", "satId", "latitude", "longitude" }) })
=======
 * Aug 08, 2022 8892       tjensen     Update indexes for Hibernate 5
 *
 * </pre>
 *
 * @author jkorman
 */

@Entity
@SequenceGenerator(initialValue = 1, name = PluginDataObject.ID_GEN, sequenceName = "bufrssmiseq")
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
/*
 * Both refTime and forecastTime are included in the refTimeIndex since
 * forecastTime is unlikely to be used.
 */
<<<<<<< HEAD
@org.hibernate.annotations.Table(appliesTo = "bufrssmi", indexes = { @Index(name = "bufrssmi_refTimeIndex", columnNames = {
        "refTime", "forecastTime" }) })
@DynamicSerialize
public class SSMIScanData extends PersistablePluginDataObject implements
        ISpatialEnabled, IPointData, IPersistable {
=======
@Table(name = "bufrssmi", uniqueConstraints = {
        @UniqueConstraint(name = "uk_bufrssmi_datauri_fields", columnNames = {
                "stationid", "refTime", "satId", "latitude",
                "longitude" }) }, indexes = {
                        @Index(name = "%TABLE%_refTimeIndex", columnList = "refTime, forecastTime"),
                        @Index(name = "%TABLE%_stationIndex", columnList = "stationId") })

@DynamicSerialize
public class SSMIScanData extends PersistablePluginDataObject
        implements ISpatialEnabled, IPointData, IPersistable {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    private static final long serialVersionUID = 1L;

    @DataURI(position = 1)
    @NullString
    @Column(nullable = false)
    @XmlAttribute
    @DynamicSerializeElement
    private int satId;

    @Embedded
    @DataURI(position = 2, embedded = true)
    @DynamicSerializeElement
    private SurfaceObsLocation location;

    @DynamicSerializeElement
    @Transient
    private Integer orbitNumber;

    @DynamicSerializeElement
    @Transient
    private Integer scanNumber;

    @DynamicSerializeElement
    @Transient
    private Integer posNumber;

    // The profiler observation time.
    @Column
    @DynamicSerializeElement
    private Calendar timeObs;

    @Embedded
    @DynamicSerializeElement
    private PointDataView pointDataView;

    // Text of the WMO header
    @Column(length = 32)
    @DynamicSerializeElement
    private String wmoHeader;

    /**
     * Empty constructor.
     */
    public SSMIScanData() {
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
    public SSMIScanData(String uri) {
        super(uri);
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
     * @return the satId
     */
    public int getSatId() {
        return satId;
    }

    /**
     * @param satId
     *            the satId to set
     */
    public void setSatId(int satId) {
        this.satId = satId;
    }

    /**
     * @return the orbitNumber
     */
    public Integer getOrbitNumber() {
        return orbitNumber;
    }

    /**
     * @param orbitNumber
     *            the orbitNumber to set
     */
    public void setOrbitNumber(Integer orbitNumber) {
        this.orbitNumber = orbitNumber;
    }

    /**
     * @return the scanNumber
     */
    public Integer getScanNumber() {
        return scanNumber;
    }

    /**
     * @param scanNumber
     *            the scanNumber to set
     */
    public void setScanNumber(Integer scanNumber) {
        this.scanNumber = scanNumber;
    }

    /**
     * @return the posNumber
     */
    public Integer getPosNumber() {
        return posNumber;
    }

    /**
     * @param posNumber
     *            the posNumber to set
     */
    public void setPosNumber(Integer posNumber) {
        this.posNumber = posNumber;
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
        return timeObs;
    }

    /**
     * Set the observation time for this data.
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param timeObs
     *            The data observation time.
     */
    public void setTimeObs(Calendar timeObs) {
        this.timeObs = timeObs;
    }

    /**
     * @return the wmoHeader
     */
    public String getWmoHeader() {
        return wmoHeader;
    }

    /**
     * @param wmoHeader
     *            the wmoHeader to set
     */
    public void setWmoHeader(String wmoHeader) {
        this.wmoHeader = wmoHeader;
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

    /**
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    @Override
    public PointDataView getPointDataView() {
        return pointDataView;
    }

    /**
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    @Override
    public void setPointDataView(PointDataView pointDataView) {
        this.pointDataView = pointDataView;
    }

    /**
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @return
     */
    public final SSMIScanData copyObs() {
        SSMIScanData obs = new SSMIScanData();

        obs.dataTime = dataTime.clone();
        obs.timeObs = TimeUtil.newCalendar(timeObs);
        obs.orbitNumber = orbitNumber;
        obs.satId = satId;
        obs.scanNumber = scanNumber;
        obs.wmoHeader = wmoHeader;

        return obs;
    }

    /**
     * Returns the hashCode for this object. This implementation returns the
     * hashCode of the generated dataURI.
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result)
                + ((getDataURI() == null) ? 0 : getDataURI().hashCode());
        return result;
    }

    /**
     * Checks if this record is equal to another by checking the generated
     * dataURI.
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param obj
     * @see java.lang.Object#equals(java.lang.Object)
     */
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
        SSMIScanData other = (SSMIScanData) obj;
        if (getDataURI() == null) {
            if (other.getDataURI() != null) {
                return false;
            }
        } else if (!getDataURI().equals(other.getDataURI())) {
            return false;
        }
        return true;
    }

    @Override
    public String getPluginName() {
        return "bufrssmi";
    }
}
