/**
 * This software was developed andimport com.raytheon.uf.common.datastorage.Request;
Contract DG133W-05-CQ-1067 with the US Government.
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
package com.raytheon.uf.viz.grid.radar;

<<<<<<< HEAD
import com.raytheon.uf.common.datastorage.Request;
import org.locationtech.jts.geom.Coordinate;

/**
 * 
 * This class provides a way for resources to pass a point to the GribDataCube
 * adapter that will be used as the center of all TILT levels.
 * 
 * TODO I dont like this class because it causes problems if one of these
 * Requests gets inadvertently sent over to PyPies/HDF5. We need a better way to
 * communicate with the GribDataCubeAdapter
 * 
 * <pre>
 * 
 * SOFTWARE HISTORY
 * 
 * Date          Ticket#  Engineer  Description
 * ------------- -------- --------- ------------------------------
 * Nov 09, 2011           bsteffen  Initial creation
 * Aug 15, 2017  6332     bsteffen  Move to viz.grid.radar plugin
 * Jul 17, 2020  17574    smoorthy  added true elevation angle to extract 
 *                                  later for radar height calculations
 * 
 * </pre>
 * 
=======
import org.locationtech.jts.geom.Coordinate;

import com.raytheon.uf.common.datastorage.Request;

/**
 *
 * This class provides a way for resources to pass a point to the GribDataCube
 * adapter that will be used as the center of all TILT levels.
 *
 * TODO I dont like this class because it causes problems if one of these
 * Requests gets inadvertently sent over to PyPies/HDF5. We need a better way to
 * communicate with the GribDataCubeAdapter
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 *
 * Date          Ticket#  Engineer  Description
 * ------------- -------- --------- --------------------------------------------
 * Nov 09, 2011           bsteffen  Initial creation
 * Aug 15, 2017  6332     bsteffen  Move to viz.grid.radar plugin
 * Jul 17, 2020  17574    smoorthy  added true elevation angle to extract later
 *                                  for radar height calculations
 * Mar 29, 2021  8374     randerso  Updated for changes to Request constructors
 *
 * </pre>
 *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 * @author bsteffen
 */
public class TiltRequest extends Request {

    private Coordinate tiltLocation;

    private double trueElevationAngle;

<<<<<<< HEAD
=======
    public TiltRequest() {
        super(Request.Type.ALL);
    }

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    public Coordinate getTiltLocation() {
        return tiltLocation;
    }

    public void setTiltLocation(Coordinate tiltLocation) {
        this.tiltLocation = tiltLocation;
    }

<<<<<<< HEAD
    public double getTrueElevationAngle(){
        return trueElevationAngle;
    }

    public void setTrueElevationAngle(double trueElevationAngle){
=======
    public double getTrueElevationAngle() {
        return trueElevationAngle;
    }

    public void setTrueElevationAngle(double trueElevationAngle) {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        this.trueElevationAngle = trueElevationAngle;
    }
}
