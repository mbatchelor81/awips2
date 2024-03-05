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
package com.raytheon.uf.viz.grid.radar;

<<<<<<< HEAD
import si.uom.SI;
=======
import org.locationtech.jts.geom.Coordinate;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

import com.raytheon.uf.common.dataplugin.grid.derivparam.data.SliceUtil;
import com.raytheon.uf.common.dataplugin.level.Level;
import com.raytheon.uf.common.datastorage.Request;
import com.raytheon.uf.common.datastorage.records.FloatDataRecord;
import com.raytheon.uf.common.gridcoverage.GridCoverage;
import com.raytheon.uf.common.inventory.data.AbstractRequestableData;
import com.raytheon.uf.common.inventory.exception.DataCubeException;
<<<<<<< HEAD
import org.locationtech.jts.geom.Coordinate;

/**
 * Requestable Data that generated tilt elevation.
 * 
 * <pre>
 * 
 * SOFTWARE HISTORY
 * 
 * Date          Ticket#  Engineer  Description
 * ------------- -------- --------- ------------------------------
 * Jan 15, 2010           rjpeter   Initial creation
 * Aug 15, 2017  6332     bsteffen  Move to viz.grid.radar plugin
 * Jul 17, 2020  17574    smoorthy  Have tilt requests use trueElevationAngle for height calculation
 * 
 * </pre>
 * 
 * @author rjpeter
 */
public class TiltRequestableData extends AbstractRequestableData {
=======
import com.raytheon.viz.radar.util.RadarAsGridUtil;

import si.uom.SI;

/**
 * Requestable Data that generated tilt elevation.
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 *
 * Date          Ticket#  Engineer  Description
 * ------------- -------- --------- --------------------------------------------
 * Jan 15, 2010           rjpeter   Initial creation
 * Aug 15, 2017  6332     bsteffen  Move to viz.grid.radar plugin
 * Jul 17, 2020  17574    smoorthy  Have tilt requests use trueElevationAngle
 *                                  for height calculation
 * Jul 14, 2021  8576     randerso  Changed RadarAdapter to support multiple
 *                                  local radars as defined in radarsInUse.txt
 * Sep 15, 2021  8652     njensen   Find icao through util method
 *
 * </pre>
 *
 * @author rjpeter
 */
public class TiltRequestableData extends AbstractRequestableData {
    private String icao;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    public TiltRequestableData(String modelName, Level tiltAngle,
            GridCoverage coverage) {
        this.source = modelName;
<<<<<<< HEAD
=======
        this.icao = RadarAsGridUtil.getIcaoFromModelName(modelName);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        this.unit = SI.METRE;
        this.parameter = "TILT";
        this.parameterName = "TILT";
        this.level = tiltAngle;
        this.space = coverage;
    }

    @Override
    public FloatDataRecord getDataValue(Object arg) throws DataCubeException {

        GridCoverage coverage = (GridCoverage) getSpace();
        FloatDataRecord fdr = null;
        if (arg instanceof TiltRequest) {
            Coordinate tiltLoc = ((TiltRequest) arg).getTiltLocation();
<<<<<<< HEAD
            double trueElevationAngle = ((TiltRequest)arg).getTrueElevationAngle();
            fdr = TiltUtils.getInstance().getHeightGrid(tiltLoc, coverage,
                    trueElevationAngle);
        } else {
            fdr = TiltUtils.getInstance().getHeightGrid(coverage,
=======
            double trueElevationAngle = ((TiltRequest) arg)
                    .getTrueElevationAngle();
            fdr = TiltUtils.getInstance().getHeightGrid(tiltLoc, coverage,
                    trueElevationAngle);
        } else {
            fdr = TiltUtils.getInstance().getHeightGrid(icao, coverage,
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                    level.getLevelonevalue());
        }
        if (fdr != null && arg instanceof Request) {
            return SliceUtil.slice(fdr, (Request) arg);
        } else {
            return fdr;
        }
    }

}
