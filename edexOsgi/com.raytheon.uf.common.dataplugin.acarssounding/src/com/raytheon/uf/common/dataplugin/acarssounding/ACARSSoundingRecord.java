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
package com.raytheon.uf.common.dataplugin.acarssounding;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

<<<<<<< HEAD
import javax.measure.quantity.Angle;
import si.uom.NonSI;
import javax.measure.Unit;
=======
import javax.measure.Unit;
import javax.measure.quantity.Angle;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
<<<<<<< HEAD
=======
import javax.persistence.Index;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

<<<<<<< HEAD
import org.hibernate.annotations.Index;
=======
import org.locationtech.jts.geom.Geometry;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

import com.raytheon.uf.common.dataplugin.PluginDataObject;
import com.raytheon.uf.common.dataplugin.annotations.DataURI;
import com.raytheon.uf.common.geospatial.ISpatialEnabled;
import com.raytheon.uf.common.pointdata.spatial.SurfaceObsLocation;
import com.raytheon.uf.common.serialization.annotations.DynamicSerialize;
import com.raytheon.uf.common.serialization.annotations.DynamicSerializeElement;
<<<<<<< HEAD
import org.locationtech.jts.geom.Geometry;

/**
 * 
 * 
 * <pre>
 * 
=======

import si.uom.NonSI;

/**
 *
 *
 * <pre>
 *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 * SOFTWARE HISTORY
 * Date         Ticket#    Engineer    Description
 * ------------ ---------- ----------- --------------------------
 * Apr 03, 2009 1939       jkorman     Initial creation
 * Apr 04, 2013 1846       bkowal      Added an index on refTime and
 *                                     forecastTime
 * Apr 12, 2013 1857       bgonzale    Added SequenceGenerator annotation.
 * May 07, 2013 1869       bsteffen    Remove dataURI column from
 *                                     PluginDataObject.
 * Aug 30, 2013 2298       rjpeter     Make getPluginName abstract
 * Oct 22, 2013 2361       njensen     Remove XML annotations and IDecoderGettable
 * Feb 27, 2014 2638       njensen     Remove bad dataURI annotation
 * Jul 21, 2015 4360       rferrel     Add name to unique constraint.
<<<<<<< HEAD
 * 
 * </pre>
 * 
 * @author jkorman
 * @version 1.0
 */
@Entity
@SequenceGenerator(initialValue = 1, name = PluginDataObject.ID_GEN, sequenceName = "acarssoundingseq")
@Table(name = "acarssounding", uniqueConstraints = { @UniqueConstraint(name = "uk_acarssounding_datauri_fields", columnNames = { "dataURI" }) })
=======
 * Aug 08, 2022 8892       tjensen     Update indexes for Hibernate 5
 *
 * </pre>
 *
 * @author jkorman
 */

@Entity
@SequenceGenerator(initialValue = 1, name = PluginDataObject.ID_GEN, sequenceName = "acarssoundingseq")
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
/*
 * Both refTime and forecastTime are included in the refTimeIndex since
 * forecastTime is unlikely to be used.
 */
<<<<<<< HEAD
@org.hibernate.annotations.Table(appliesTo = "acarssounding", indexes = { @Index(name = "acarssounding_refTimeIndex", columnNames = {
        "refTime", "forecastTime" }) })
@DynamicSerialize
public class ACARSSoundingRecord extends PluginDataObject implements
        ISpatialEnabled {
=======
@Table(name = "acarssounding", uniqueConstraints = {
        @UniqueConstraint(name = "uk_acarssounding_datauri_fields", columnNames = {
                "dataURI" }) }, indexes = {
                        @Index(name = "%TABLE%_refTimeIndex", columnList = "refTime, forecastTime"),
                        @Index(name = "%TABLE%_stationIndex", columnList = "stationId") })

@DynamicSerialize
public class ACARSSoundingRecord extends PluginDataObject
        implements ISpatialEnabled {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    private static final long serialVersionUID = 1L;

    public static final Unit<Angle> LOCATION_UNIT = NonSI.DEGREE_ANGLE;

    // Time of the observation.
    @Column
    @DynamicSerializeElement
    private Calendar timeObs;

    @Embedded
    @DataURI(position = 1, embedded = true)
    @DynamicSerializeElement
    private SurfaceObsLocation location;

    @Column(length = 32)
    @DynamicSerializeElement
    private String tailNumber;

    // Flight phase (A[scending] D[escending])
    @Column(length = 1)
    @DynamicSerializeElement
    private String phase = null;

    // oldest observation time in this sounding
    @Column
    @DynamicSerializeElement
    private Long oldestTime = Long.MAX_VALUE;

    // newest observation time in this sounding
    @Column
    @DynamicSerializeElement
    private Long newestTime = Long.MIN_VALUE;

    // The level data for this observation.
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent", fetch = FetchType.EAGER)
    @DynamicSerializeElement
    private Set<ACARSSoundingLayer> levels;

    /**
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    public ACARSSoundingRecord() {
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
     */
    public ACARSSoundingRecord(String uri) {
        super(uri);
    }

    /**
     * @return the timeObs
     */
    public Calendar getTimeObs() {
        return timeObs;
    }

    /**
     * @param timeObs
     *            the timeObs to set
     */
    public void setTimeObs(Calendar timeObs) {
        this.timeObs = timeObs;
    }

    /**
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     */
    @Override
    public SurfaceObsLocation getSpatialObject() {
        return location;
    }

    /**
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @return
     */
    public SurfaceObsLocation getLocation() {
        return location;
    }

    /**
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param location
     */
    public void setLocation(SurfaceObsLocation location) {
        this.location = location;
    }

    /**
     * Get the airport identifier for this sounding
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @return The airport identifier.
     */
    public String getStationId() {
        return location.getStationId();
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
     * Is the location for this profile defined?
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @return Is the location for this profile defined?
     */
    public Boolean getLocationDefined() {
        return location.getLocationDefined();
    }

    /**
     * @return the tailNumber
     */
    public String getTailNumber() {
        return tailNumber;
    }

    /**
     * @param tailNumber
     *            the tailNumber to set
     */
    public void setTailNumber(String tailNumber) {
        this.tailNumber = tailNumber;
    }

    /**
     * @return the phase
     */
    public String getPhase() {
        return phase;
    }

    /**
     * @param phase
     *            the phase to set
     */
    public void setPhase(String phase) {
        this.phase = phase;
    }

    /**
     * @return the oldestTime
     */
    public Long getOldestTime() {
        return oldestTime;
    }

    /**
     * @param oldestTime
     *            the oldestTime to set
     */
    public void setOldestTime(Long oldestTime) {
        this.oldestTime = oldestTime;
    }

    /**
     * @return the newestTime
     */
    public Long getNewestTime() {
        return newestTime;
    }

    /**
     * @param newestTime
     *            the newestTime to set
     */
    public void setNewestTime(Long newestTime) {
        this.newestTime = newestTime;
    }

    /**
     * Get the set of levels for this observation.
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @return The level data.
     */
    public Set<ACARSSoundingLayer> getLevels() {
        return levels;
    }

    /**
     * Set the set of levels for this observation.
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param levels
     *            the levels to set
     */
    public void setLevels(Set<ACARSSoundingLayer> levels) {
        this.levels = levels;
    }

    /**
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param cloud
     */
    public void addLevel(ACARSSoundingLayer level) {
        if (level != null) {
            level.setParent(this);
            if (levels == null) {
<<<<<<< HEAD
                levels = new HashSet<ACARSSoundingLayer>();
=======
                levels = new HashSet<>();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            }
            levels.add(level);
            long cTime = level.getTimeObs().getTimeInMillis();
            if (cTime < oldestTime) {
                oldestTime = cTime;
            }
            if (cTime > newestTime) {
                newestTime = cTime;
            }
        }
    }

    @Override
    @Column
    @Access(AccessType.PROPERTY)
    public String getDataURI() {
        return super.getDataURI();
    }

    @Override
    public String getPluginName() {
        return "acarssounding";
    }
}
