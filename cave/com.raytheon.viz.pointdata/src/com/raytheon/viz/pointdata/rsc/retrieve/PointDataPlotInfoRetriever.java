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
package com.raytheon.viz.pointdata.rsc.retrieve;

import java.util.Date;
<<<<<<< HEAD
import java.util.HashMap;
import java.util.List;
=======
import java.util.List;
import java.util.Map;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.raytheon.uf.common.dataquery.requests.RequestConstraint;
<<<<<<< HEAD
import com.raytheon.uf.common.status.IUFStatusHandler;
import com.raytheon.uf.common.status.UFStatus;
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import com.raytheon.uf.common.status.UFStatus.Priority;
import com.raytheon.uf.common.time.DataTime;
import com.raytheon.uf.common.time.DataTime.FLAG;
import com.raytheon.uf.viz.core.catalog.DbQuery;
import com.raytheon.uf.viz.core.exception.VizException;
import com.raytheon.uf.viz.core.rsc.IResourceDataChanged;
import com.raytheon.uf.viz.core.rsc.IResourceDataChanged.ChangeType;
import com.raytheon.viz.pointdata.PlotInfo;
import com.raytheon.viz.pointdata.rsc.PlotResourceData;

/**
<<<<<<< HEAD
 * 
 * A plotInfoRetriever for all pointData types
 * 
 * <pre>
 * 
 * SOFTWARE HISTORY
 * Date         Ticket#    Engineer    Description
 * ------------ ---------- ----------- --------------------------
 * Oct 09, 2009            bsteffen    Initial creation
 * May 14, 2013 1869       bsteffen    Get plots working without dataURI
 * Jul 23, 2014 3410       bclement    location changed to floats
 * Aug 08, 2014 3477       bclement    changed plot info locations to floats
 * Aug 05, 2015 4486       rjpeter     Changed Timestamp to Date.
 * </pre>
 * 
 * @author bsteffen
 * @version 1.0
=======
 *
 * A plotInfoRetriever for all pointData types
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 *
 * Date          Ticket#  Engineer  Description
 * ------------- -------- --------- --------------------------------------
 * Oct 09, 2009           bsteffen  Initial creation
 * May 14, 2013  1869     bsteffen  Get plots working without dataURI
 * Jul 23, 2014  3410     bclement  location changed to floats
 * Aug 08, 2014  3477     bclement  changed plot info locations to floats
 * Aug 05, 2015  4486     rjpeter   Changed Timestamp to Date.
 * Dec 07, 2021  8341     randerso  Code cleanup
 *
 * </pre>
 *
 * @author bsteffen
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 */
@XmlAccessorType(XmlAccessType.NONE)
public class PointDataPlotInfoRetriever extends AbstractDbPlotInfoRetriever {

<<<<<<< HEAD
    private static final transient IUFStatusHandler statusHandler = UFStatus
            .getHandler(PointDataPlotInfoRetriever.class);

=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    protected Object onlyRefTimeFlagLock = new Object();

    protected boolean onlyRefTime = false;

    protected boolean needsDataUri = true;

    @Override
    protected void addColumns(DbQuery dq) {
        dq.addColumn("location.latitude");
        dq.addColumn("location.longitude");
        dq.addColumn("location.stationId");
        if (onlyRefTime) {
            // refTime retrieval is much faster
            dq.addColumn("dataTime.refTime");
        } else {
            dq.addColumn("dataTime");
        }
        if (needsDataUri) {
            dq.addColumn("dataURI");
        }
    }

    @Override
    protected PlotInfo getPlotInfo(Object[] data) {
        PlotInfo stationInfo = new PlotInfo();
        stationInfo.latitude = ((Number) data[0]).floatValue();
        stationInfo.longitude = ((Number) data[1]).floatValue();
        stationInfo.stationId = (String) data[2];
        if (stationInfo.stationId == null) {
            stationInfo.stationId = "" + stationInfo.latitude + "#"
                    + stationInfo.longitude;
        }

        if (data[3] instanceof DataTime) {
            stationInfo.dataTime = (DataTime) data[3];
        } else if (data[3] instanceof Date) {
            stationInfo.dataTime = new DataTime((Date) data[3]);
        } else {
            String message = "Incorrect dataTime class type from database, expected "
<<<<<<< HEAD
                    + DataTime.class.getName()
                    + " or "
                    + Date.class.getName()
                    + " but recieved a " + data[4].getClass().getName();
            statusHandler.handle(Priority.CRITICAL, message, new Exception(
                    message));
=======
                    + DataTime.class.getName() + " or " + Date.class.getName()
                    + " but received a " + data[4].getClass().getName();
            statusHandler.handle(Priority.CRITICAL, message,
                    new Exception(message));
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        }
        if (data.length > 4) {
            stationInfo.dataURI = (String) data[4];
        }
        return stationInfo;
    }

    @Override
    public void getStations(IResourceDataChanged listener, DataTime time,
<<<<<<< HEAD
            HashMap<String, RequestConstraint> metadataMap) throws VizException {
        DbQuery dq = null;
        synchronized (onlyRefTimeFlagLock) {
            onlyRefTime = !time.getUtilityFlags().contains(FLAG.FCST_USED);
            needsDataUri = !PlotResourceData.getPluginProperties(metadataMap).hasDistinctStationId;
=======
            Map<String, RequestConstraint> metadataMap) throws VizException {
        DbQuery dq = null;
        synchronized (onlyRefTimeFlagLock) {
            onlyRefTime = !time.getUtilityFlags().contains(FLAG.FCST_USED);
            needsDataUri = !PlotResourceData
                    .getPluginProperties(metadataMap).hasDistinctStationId;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            dq = getQueryObject(metadataMap);
        }
        List<PlotInfo> info = runStationQuery(dq);
        listener.resourceChanged(ChangeType.DATA_UPDATE,
                info.toArray(new PlotInfo[0]));
    }
}
