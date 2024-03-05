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
package com.raytheon.viz.pointdata.thread;

import org.eclipse.core.runtime.jobs.Job;

<<<<<<< HEAD
import com.raytheon.uf.common.status.IUFStatusHandler;
=======
import com.raytheon.uf.common.status.IPerformanceStatusHandler;
import com.raytheon.uf.common.status.IUFStatusHandler;
import com.raytheon.uf.common.status.PerformanceStatus;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import com.raytheon.uf.common.status.UFStatus;
import com.raytheon.viz.pointdata.IPlotModelGeneratorCaller;

/**
 * Abstract job associated with one of the many details of plot creation.
<<<<<<< HEAD
 * 
 * <pre>
 * 
 * SOFTWARE HISTORY
 * 
 * Date         Ticket#    Engineer    Description
 * ------------ ---------- ----------- --------------------------
 * Mar 21, 2014 2868       njensen     Initial creation
 * 
 * </pre>
 * 
 * @author njensen
 * @version 1.0
=======
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 *
 * Date          Ticket#  Engineer  Description
 * ------------- -------- --------- --------------------------------------------
 * Mar 21, 2014  2868     njensen   Initial creation
 * Dec 07, 2021  8341     randerso  Move plot performance logging into perf log.
 *
 * </pre>
 *
 * @author njensen
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 */

public abstract class AbstractPlotCreationJob extends Job {

<<<<<<< HEAD
    protected static final transient IUFStatusHandler statusHandler = UFStatus
            .getHandler(PlotModelDataRequestJob.class);
=======
    protected final IUFStatusHandler statusHandler = UFStatus
            .getHandler(getClass());

    protected static final IPerformanceStatusHandler perfLog = PerformanceStatus
            .getHandler("PlotCreation");
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    protected PlotThreadOverseer overseer;

    protected IPlotModelGeneratorCaller listener;

    public AbstractPlotCreationJob(String name, PlotThreadOverseer parent,
            IPlotModelGeneratorCaller caller) {
        super(name);
        this.overseer = parent;
        this.listener = caller;
        this.setSystem(false);
    }

    public boolean isDone() {
        return getState() != Job.RUNNING && getState() != Job.WAITING;
    }

    public boolean shutdown() {
        return super.cancel();
    }

}
