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

<<<<<<< HEAD
import java.util.HashMap;

import org.opengis.referencing.crs.CoordinateReferenceSystem;

import com.raytheon.uf.common.dataquery.requests.RequestConstraint;
=======
import java.util.Map;

import org.locationtech.jts.geom.Envelope;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

import com.raytheon.uf.common.dataquery.requests.RequestConstraint;
import com.raytheon.uf.common.status.IPerformanceStatusHandler;
import com.raytheon.uf.common.status.IUFStatusHandler;
import com.raytheon.uf.common.status.PerformanceStatus;
import com.raytheon.uf.common.status.UFStatus;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import com.raytheon.uf.common.time.DataTime;
import com.raytheon.uf.viz.core.exception.VizException;
import com.raytheon.uf.viz.core.rsc.IResourceDataChanged;
import com.raytheon.viz.pointdata.PlotInfo;
import com.raytheon.viz.pointdata.rsc.PlotResource;
<<<<<<< HEAD
import org.locationtech.jts.geom.Envelope;
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

/**
 * Base class for all objects which can retrieve {@link PlotInfo} objects for
 * use in {@link PlotResource}. For most applications the
 * {@link PointDataPlotInfoRetriever} should be used however other instances can
 * provide more advanced features such as incremental loading or retrieving
 * additional data.
<<<<<<< HEAD
 * 
 * <pre>
 * 
 * SOFTWARE HISTORY
 * 
 * Date          Ticket#  Engineer    Description
 * ------------- -------- ----------- --------------------------
 * Oct 23, 2013  2491     bsteffen    Remove ISerializableObject
 * Jun 06, 2014  2061     bsteffen    Remove old PlotResource
 * 
 * </pre>
 * 
 * @author unknown
 * @version 1.0
 */
public abstract class AbstractPlotInfoRetriever {

    public abstract void getStations(IResourceDataChanged listener,
            DataTime time, HashMap<String, RequestConstraint> metadataMap)
=======
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 *
 * Date          Ticket#  Engineer  Description
 * ------------- -------- --------- --------------------------------------------
 * Oct 23, 2013  2491     bsteffen  Remove ISerializableObject
 * Jun 06, 2014  2061     bsteffen  Remove old PlotResource
 * Dec 07, 2021  8341     randerso  Move plot performance logging into perf log.
 *
 * </pre>
 *
 * @author unknown
 */
public abstract class AbstractPlotInfoRetriever {
    protected final IUFStatusHandler statusHandler = UFStatus
            .getHandler(getClass());

    protected static final IPerformanceStatusHandler perfLog = PerformanceStatus
            .getHandler("PlotInfoRetrieval");

    public abstract void getStations(IResourceDataChanged listener,
            DataTime time, Map<String, RequestConstraint> metadataMap)
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            throws VizException;

    public void updateActiveFrame(DataTime time, Envelope envelope,
            CoordinateReferenceSystem coordinateReferenceSystem) {
<<<<<<< HEAD
        ;// Do nothing by default
    }

    public void cancel() {
        ;// Do nothing by default
=======
        // Do nothing by default
    }

    public void cancel() {
        // Do nothing by default
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

}
