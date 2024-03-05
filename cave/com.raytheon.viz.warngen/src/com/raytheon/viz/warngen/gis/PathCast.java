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
package com.raytheon.viz.warngen.gis;

import java.util.Date;
<<<<<<< HEAD
=======
import org.locationtech.jts.geom.Geometry;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

/**
 * 
 * PathCast
 * 
 * Describes the pathcast of the storm
 * 
 * <pre>
 * 
 *    SOFTWARE HISTORY
 *   
 *    Date         Ticket#     Engineer    Description
 *    ------------ ----------  ----------- --------------------------
 *    Dec 7, 2007              chammack    Initial Creation.
 *    Jul 29, 2020 ASM #21988  dhaines     Added copy constructor, part of fix for DR#21988
<<<<<<< HEAD
 * 
=======
 *    Nov 29, 2021 ASM #22724  dhaines     Changes for DR 22724 - Some Cities Can't be Added to Pathcasts
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 * </pre>
 * 
 * @author chammack
 * @version 1
 */
public class PathCast implements Comparable<PathCast> {

    protected ClosestPoint[] points;
    
    protected String area;

    protected String areaNotation;

    protected String parentArea;

    protected String timeZone;

    protected Date time;
<<<<<<< HEAD
=======

    protected int index;

    protected Geometry pcGeom;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    
    /**
     * constructor
     */
    public PathCast() {
        
    }
    
    /** 
     * copy constructor
     * @param pc
     */
    public PathCast (PathCast pc) {
        this.points = pc.getPoints();
        this.area = pc.getArea();
        this.areaNotation = pc.getAreaNotation();
        this.parentArea = pc.getParentArea();
        this.timeZone = pc.getTimeZone();
        this.time = pc.getTime();
<<<<<<< HEAD
=======
        this.index = pc.getIndex();
        this.pcGeom = pc.getPcGeom();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }
    
    /**
     * @return the points
     */
    public ClosestPoint[] getPoints() {
        return points;
    }

    /**
     * @return the area
     */
    public String getArea() {
        return area;
    }

    /**
     * @return the parentArea
     */
    public String getParentArea() {
        return parentArea;
    }

    /**
     * @return the areaNotation
     */
    public String getAreaNotation() {
        return areaNotation;
    }

    /**
     * @return the time
     */
    public Date getTime() {
        return time;
    }
    
    public String getTimeZone() {
        return timeZone;
    }

<<<<<<< HEAD
=======
    public Geometry getPcGeom() {
        return pcGeom;
    }

    public int getIndex() {
        return index;
    }

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    @Override
    public int compareTo(PathCast o) {
        if (o == null)
            return 1;
        return this.time.compareTo(o.time);
    }

<<<<<<< HEAD
}
=======
}
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
