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
package com.raytheon.viz.gfe.core;

import java.util.List;

import com.raytheon.uf.common.dataplugin.gfe.db.objects.DatabaseID;
import com.raytheon.uf.common.dataplugin.gfe.db.objects.GridLocation;
import com.raytheon.uf.common.dataplugin.gfe.db.objects.GridParmInfo;
import com.raytheon.uf.common.dataplugin.gfe.db.objects.ParmID;
import com.raytheon.uf.common.dataplugin.gfe.slice.IGridSlice;
<<<<<<< HEAD
=======
import com.raytheon.uf.common.site.notify.SiteActivationNotification;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import com.raytheon.uf.common.time.TimeRange;
import com.raytheon.uf.viz.core.jobs.JobPool;
import com.raytheon.viz.gfe.core.msgs.IAvailableSourcesChangedListener;
import com.raytheon.viz.gfe.core.msgs.IDisplayedParmListChangedListener;
import com.raytheon.viz.gfe.core.msgs.ILockTableChangedListener;
import com.raytheon.viz.gfe.core.msgs.INewModelAvailableListener;
import com.raytheon.viz.gfe.core.msgs.IParmIDChangedListener;
import com.raytheon.viz.gfe.core.msgs.IParmInventoryChangedListener;
import com.raytheon.viz.gfe.core.msgs.IParmListChangedListener;
import com.raytheon.viz.gfe.core.msgs.ISystemTimeRangeChangedListener;
import com.raytheon.viz.gfe.core.parm.Parm;
import com.raytheon.viz.gfe.core.parm.vcparm.VCModuleJobPool;

/**
 * ParmManager Interface
 *
 * <pre>
 * SOFTWARE HISTORY
 *
 * Date          Ticket#  Engineer  Description
 * ------------- -------- --------- --------------------------------------------
 * Jan 28, 2008           chammack  Initial creation of skeleton.
 * Jun 25, 2012  766      dgilling  Added getVCModulePool().
 * Aug 20, 2012  1082     randerso  Moved calcStepTimes to AbstractParmManager
 *                                  for use in PngWriter
 * Aug 13, 2015  4749     njensen   Extends DisposableManager
 * Jan 04, 2018  7178     randerso  Removed deallocateUnusedGrids. Javadoc
 *                                  cleanup
<<<<<<< HEAD
=======
 * Mar 25, 2021  8380     mapeters  Added {@link #resetCaches} and
 *                                  {@link #handleSiteActivationNotification}
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 *
 * </pre>
 *
 * @author chammack
 */
public interface IParmManager extends IParmInventoryChangedListener,
        ILockTableChangedListener, IParmIDChangedListener, DisposableManager {

    /**
     * This function creates a new parm - of type database or virtual
     * calculated.
     *
     * @param pid
     * @param mutableParm
     * @param displayable
     * @return the new parm
     */
<<<<<<< HEAD
    public Parm addParm(ParmID pid, boolean mutableParm, boolean displayable);
=======
    Parm addParm(ParmID pid, boolean mutableParm, boolean displayable);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * This function creates a new virtual parm with the specified
     * characteristics. If the parm already exists, a null will be returned and
     * no action takes place.
     *
     * @param pid
     * @param gpi
     * @param data
     * @param mutableParm
     * @param displayable
     * @return the virtual parm
     */
<<<<<<< HEAD
    public Parm createVirtualParm(ParmID pid, GridParmInfo gpi,
            IGridSlice[] data, boolean mutableParm, boolean displayable);
=======
    Parm createVirtualParm(ParmID pid, GridParmInfo gpi, IGridSlice[] data,
            boolean mutableParm, boolean displayable);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * Deletes a known parm(s). Will not delete a parm that is modified.
     *
     * @param parms
     *            parms to delete
     */
<<<<<<< HEAD
    public void deleteParm(Parm... parms);
=======
    void deleteParm(Parm... parms);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * Deletes all parms that are marked temporary.
     *
     */
<<<<<<< HEAD
    public void deleteTemporaryParms();
=======
    void deleteTemporaryParms();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * Returns a list of all parms
     *
     * @return the list of all parms
     */
<<<<<<< HEAD
    public Parm[] getAllParms();
=======
    Parm[] getAllParms();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * Returns the list of currently displayed databases. Displayed databases
     * are defined by displayed parms.
     *
     * @return the list of displayed databases
     */
<<<<<<< HEAD
    public List<DatabaseID> getDisplayedDbs();
=======
    List<DatabaseID> getDisplayedDbs();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * Returns the list of currently undisplayed databases. Undisplayed
     * databases are defined by undisplayed parms.
     *
     * @return the list of undisplayed databases
     */
<<<<<<< HEAD
    public List<DatabaseID> getUndisplayedDbs();
=======
    List<DatabaseID> getUndisplayedDbs();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * Returns a list of available databases.
     *
     * @return the available databases, which is the sum of server+VParm, but no
     *         duplicates.
     */
<<<<<<< HEAD
    public List<DatabaseID> getAvailableDbs();
=======
    List<DatabaseID> getAvailableDbs();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * Returns a list of available parameters based on the database ID. If an
     * invalid or unknown database ID is provided, an empty list is returned.
     *
     * @param dbID
     *            the database ID
     * @return the parm IDs available
     */
<<<<<<< HEAD
    public ParmID[] getAvailableParms(DatabaseID dbID);
=======
    ParmID[] getAvailableParms(DatabaseID dbID);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * Returns a list of all available parameters in all databases
     *
     * @return the available parms
     */
<<<<<<< HEAD
    public ParmID[] getAllAvailableParms();
=======
    ParmID[] getAllAvailableParms();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * Returns a list of displayed parms
     *
     * @return the list of displayed parms
     */
<<<<<<< HEAD
    public Parm[] getDisplayedParms();
=======
    Parm[] getDisplayedParms();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * NOTE: In the legacy system this was getModified() but the underlying
     * implementation was not checking for modifications, it was checking for
     * locks. It has been renamed to better match the implementation.
     *
     * @return an array of params that are currently locked
     */
<<<<<<< HEAD
    public Parm[] getLockedParms();
=======
    Parm[] getLockedParms();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * Returns a list of parms that have been modified.
     *
     * @return the modified parms
     */
<<<<<<< HEAD
    public Parm[] getModifiedParms();
=======
    Parm[] getModifiedParms();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * Returns the mutable database
     *
     * @return the mutable database
     */
<<<<<<< HEAD
    public DatabaseID getMutableDatabase();
=======
    DatabaseID getMutableDatabase();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * Returns the original mutable database
     *
     * @return the original mutable database
     */
<<<<<<< HEAD
    public DatabaseID getOrigMutableDatabase();
=======
    DatabaseID getOrigMutableDatabase();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * Return the parm for a parm ID
     *
     * @param parmID
     *            the parm ID
     * @return the parm
     */
<<<<<<< HEAD
    public Parm getParm(ParmID parmID);
=======
    Parm getParm(ParmID parmID);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * Return a list of Parms for a list of ParmIDs with nulls in place of parms
     * that are not loaded.
     *
     * @param parmIDs
     * @return see above
     */
<<<<<<< HEAD
    public Parm[] getParms(ParmID[] parmIDs);
=======
    Parm[] getParms(ParmID[] parmIDs);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * Gets the ParmID from each Parm.
     *
     * @param parms
     *            this list of Parms
     * @return the list of ParmIDs
     */
<<<<<<< HEAD
    public ParmID[] getParmIDs(Parm[] parms);
=======
    ParmID[] getParmIDs(Parm[] parms);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * This function returns a parm pointer given an expression name for a parm.
     * If exprName is "variableElement", the variableParm is returned If
     * enableTopo is on and Topo is not available, it is enabled and the parm
     * pointer is returned. All available databases are searched for all
     * available parms. The expression name is checked first for an exact match
     * with the model time, then for an exact match without the model time. If
     * no match, then this routine returns null.
     *
     * @param exprName
     *            the expression name
     * @param enableTopo
     *            whether to enable topo
     * @param variableParm
     *            the variable parm
     * @return the parm or null if none matches the expression
     */
<<<<<<< HEAD
    public Parm getParmInExpr(final String exprName, boolean enableTopo,
=======
    Parm getParmInExpr(final String exprName, boolean enableTopo,
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            Parm variableParm);

    /**
     * Calls getParmInExpr with the active parm as the last argument
     *
     * @param exprName
     *            the expression name
     * @param enableTopo
     *            whether to enable topo
     * @return the parm or null if none matches the expression
     */
<<<<<<< HEAD
    public Parm getParmInExpr(final String exprName, boolean enableTopo);
=======
    Parm getParmInExpr(final String exprName, boolean enableTopo);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * Returns a list of regular parms that are selected.
     *
     * @return a list of all selected parms
     */
<<<<<<< HEAD
    public Parm[] getSelectedParms();
=======
    Parm[] getSelectedParms();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * Returns the system time range (a time range that contains all grids of
     * all active parms)
     *
     * @return the system time range
     */
<<<<<<< HEAD
    public TimeRange getSystemTimeRange();
=======
    TimeRange getSystemTimeRange();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * Returns a list of undisplayed parms
     *
     * @return the list of undisplayed parms
     */
<<<<<<< HEAD
    public Parm[] getUndisplayedParms();
=======
    Parm[] getUndisplayedParms();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * Returns a unique parm ID that cannot conflict with existing parm IDs nor
     * possible parm IDs from the database. Intended for use with transient
     * parameters. The nameHint is used to modify the parmname.
     *
     * @param pid
     * @param nameHint
     * @param categoryHint
     * @return the unique parm ID
     */
<<<<<<< HEAD
    public ParmID getUniqueParmID(final ParmID pid, final String nameHint,
=======
    ParmID getUniqueParmID(final ParmID pid, final String nameHint,
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            final String categoryHint);

    /**
     * Returns true if the given parm is in the system. "In the system" means
     * that it is a valid parm, but may or may not be displayed at present.
     *
     * @param parmId
     *            the parm ID to look for
     * @return whether the parm is in the system
     */
<<<<<<< HEAD
    public boolean isParmInDatabase(ParmID parmId);
=======
    boolean isParmInDatabase(ParmID parmId);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * Save modified data for the specified parameter
     *
     * @param parm
     * @return true if successful
     */
<<<<<<< HEAD
    public boolean saveParm(Parm parm);
=======
    boolean saveParm(Parm parm);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * Save modified data for the specified parameter over the specified time
     * ranges
     *
     * @param parm
     * @param timeRanges
     * @return true if successful
     */
<<<<<<< HEAD
    public boolean saveParm(Parm parm, TimeRange[] timeRanges);
=======
    boolean saveParm(Parm parm, TimeRange[] timeRanges);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * This function adds or removes parms such that the displayed list matches
     * the specified parm list. This function prevents the unloading of a
     * parameter that is modified. The list is a series of ParmIDs.
     *
     * @param parmList
     *            the list of parm IDs
     */
<<<<<<< HEAD
    public void setDisplayedParms(ParmID[] parmList);
=======
    void setDisplayedParms(ParmID[] parmList);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * Controls the displayable characteristic of the parm. A displayable parm
     * cannot be made non-displayable if it is modified.
     *
     * @param parm
     *            the parm to set
     * @param displayable
     *            whether the parm is displayable or not
     */
<<<<<<< HEAD
    public void setParmDisplayable(Parm parm, boolean displayable);
=======
    void setParmDisplayable(Parm parm, boolean displayable);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * Register an available sources changed listener with the parm manager
     *
     * Notifies the recipient of when the available sources list has changed
     *
     * @param listener
     *            the available sources change listener
     */
<<<<<<< HEAD
    public void addAvailableSourcesChangedListener(
=======
    void addAvailableSourcesChangedListener(
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            IAvailableSourcesChangedListener listener);

    /**
     * Unregister an available sources changed listener from the parm manager
     *
     * @param listener
     *            the available sources change listener
     */
<<<<<<< HEAD
    public void removeAvailableSourcesChangedListener(
=======
    void removeAvailableSourcesChangedListener(
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            IAvailableSourcesChangedListener listener);

    /**
     * Register a displayed parm change listener with the parm manager
     *
     * Notifies the recipient of when the displayed parm list has changed
     *
     * @param listener
     *            the displayed parm change listener
     */
<<<<<<< HEAD
    public void addDisplayedParmListChangedListener(
=======
    void addDisplayedParmListChangedListener(
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            IDisplayedParmListChangedListener listener);

    /**
     * Unregister a displayed parm change listener from the parm manager
     *
     * @param listener
     *            the displayed parm change listener
     */
<<<<<<< HEAD
    public void removeDisplayedParmListChangedListener(
=======
    void removeDisplayedParmListChangedListener(
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            IDisplayedParmListChangedListener listener);

    /**
     * Register a new model available listener with the parm manager
     *
     * Notifies the recipient of when a new model has arrived.
     *
     * @param listener
     *            the new model available listener
     */
<<<<<<< HEAD
    public void addNewModelAvailableListener(
            INewModelAvailableListener listener);
=======
    void addNewModelAvailableListener(INewModelAvailableListener listener);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * Unregister a new model available listener from the parm manager
     *
     * @param listener
     *            the new model available listener
     */
<<<<<<< HEAD
    public void removeNewModelAvailableListener(
            INewModelAvailableListener listener);
=======
    void removeNewModelAvailableListener(INewModelAvailableListener listener);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * Register a ParmID change listener with the parm manager
     *
     * Notifies the recipient of when a Parm has had its ParmID changed.
     *
     * @param listener
     *            the ParmID change listener
     */
<<<<<<< HEAD
    public void addParmIDChangedListener(IParmIDChangedListener listener);
=======
    void addParmIDChangedListener(IParmIDChangedListener listener);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * Unregister a ParmID change listener from the parm manager
     *
     * @param listener
     *            the ParmID change listener
     */
<<<<<<< HEAD
    public void removeParmIDChangedListener(IParmIDChangedListener listener);
=======
    void removeParmIDChangedListener(IParmIDChangedListener listener);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * Register a parm change listener with the parm manager
     *
     * Notifies the recipient of when the parm list has changed
     *
     * @param listener
     *            the parm change listener
     */
<<<<<<< HEAD
    public void addParmListChangedListener(IParmListChangedListener listener);
=======
    void addParmListChangedListener(IParmListChangedListener listener);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * Unregister a parm change listener from the parm manager
     *
     * @param listener
     *            the parm change listener
     */
<<<<<<< HEAD
    public void removeParmListChangedListener(
            IParmListChangedListener listener);
=======
    void removeParmListChangedListener(IParmListChangedListener listener);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * Unregister a sytem time range change listener with the parm manager
     *
     * @param listener
     *            the system time range change listener
     */
<<<<<<< HEAD
    public void addSystemTimeRangeChangedListener(
=======
    void addSystemTimeRangeChangedListener(
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            ISystemTimeRangeChangedListener listener);

    /**
     * Register a sytem time range change listener with the parm manager
     *
     * Notifies the recipient of when the system time range has changed
     *
     * @param listener
     *            the system time range change listener
     */
<<<<<<< HEAD
    public void removeSystemTimeRangeChangedListener(
=======
    void removeSystemTimeRangeChangedListener(
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            ISystemTimeRangeChangedListener listener);

    /**
     * Returns the grid location which is a composite of all of the mutable
     * parameters, or if no mutable parameters, a typical grid location.
     *
     * @return the grid location
     */
<<<<<<< HEAD
    public GridLocation compositeGridLocation();
=======
    GridLocation compositeGridLocation();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * Command to enable or disable the topography parm.
     *
     * Makes assumption that topography is a vparm.
     *
     * @param wanted
     * @param forceVisibility
     */
<<<<<<< HEAD
    public void enableDisableTopoParm(boolean wanted, boolean forceVisibility);
=======
    void enableDisableTopoParm(boolean wanted, boolean forceVisibility);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * Returns a DatabaseID that represents the dbName string and the relative
     * version number. For singleton databases, the version number is ignored.
     * If no database exists, then a default DatabaseID() is returned to the
     * user. The format of the dbName field is modelName, such as "NAM12", if
     * the database has no optional type, or optType_modelName, such as
     * "D2D_NAM12", if the database has an optional type.
     *
     * @param databaseName
     *            the db name
     * @param version
     *            the version of the db
     * @return the DatabaseID
     */
<<<<<<< HEAD
    public DatabaseID findDatabase(String databaseName, int version);
=======
    DatabaseID findDatabase(String databaseName, int version);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * Returns the corresponding ISC parmID based on the incoming parmID. Does
     * not load the parm <br>
     *
     * Attempts to match the incoming parmname and level. Goes through each of
     * the isc databases for the match. The first one is taken.
     *
     * @param pid
     *            The parm ID to load the corresponding ISC parmID for
     * @return The ISC parmID
     */
<<<<<<< HEAD
    public ParmID getISCParmID(ParmID pid);
=======
    ParmID getISCParmID(ParmID pid);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * @return the isc databases
     */
<<<<<<< HEAD
    public List<DatabaseID> getIscDatabases();
=======
    List<DatabaseID> getIscDatabases();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * Returns true if we are in isc mode, false if in normal mode.
     *
     * @return true if we are in isc mode, false if in normal mode.
     */
<<<<<<< HEAD
    public boolean iscMode();
=======
    boolean iscMode();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * Returns the product database as a DatabaseID.
     *
     * @return the product database ID
     */
<<<<<<< HEAD
    public DatabaseID getProductDB();
=======
    DatabaseID getProductDB();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * Replace displayed parms that represent old model data with new model
     * data. It is taken as given the model identifier passed to this routine is
     * the newest version of this model.
     *
     * @param modelIdentifier
     *            The identifier of the new model.
     */
<<<<<<< HEAD
    public void updateModel(DatabaseID modelIdentifier);

    /**
     * Purges the parmIDCacheServer of all database IDs for the given site
     *
     * @param site
     *            The site to purge
     */
    public void purgeDbCacheForSite(String site);
=======
    void updateModel(DatabaseID modelIdentifier);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * Create a parm
     *
     * @param pid
     * @param mutableParm
     * @param displayable
     * @return the created parm
     */
<<<<<<< HEAD
    public Parm createParm(ParmID pid, boolean mutableParm,
            boolean displayable);
=======
    Parm createParm(ParmID pid, boolean mutableParm, boolean displayable);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * Create a ParmID from an expression
     *
     * @param parmName
     * @return the ParmID
     */
<<<<<<< HEAD
    public ParmID fromExpression(String parmName);
=======
    ParmID fromExpression(String parmName);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * @return the notification pool
     */
<<<<<<< HEAD
    public JobPool getNotificationPool();
=======
    JobPool getNotificationPool();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * @return the VDModule pool
     */
<<<<<<< HEAD
    public VCModuleJobPool getVCModulePool();
=======
    VCModuleJobPool getVCModulePool();

    /**
     * Refresh all necessary caches to match the DB.
     */
    void refreshCaches();

    /**
     * Handle a site activation change notification.
     *
     * @param notification
     *            the site activation notification
     */
    void handleSiteActivationNotification(
            SiteActivationNotification notification);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
}
