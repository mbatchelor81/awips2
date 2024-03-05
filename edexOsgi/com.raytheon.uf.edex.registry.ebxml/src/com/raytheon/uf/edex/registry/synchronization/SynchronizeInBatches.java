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

package com.raytheon.uf.edex.registry.synchronization;

import java.util.List;
<<<<<<< HEAD
=======
import java.util.concurrent.TimeUnit;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.raytheon.uf.common.event.EventBus;
import com.raytheon.uf.common.util.CollectionUtil;
import com.raytheon.uf.edex.registry.ebxml.dao.RegistryObjectDao;
<<<<<<< HEAD
import com.raytheon.uf.edex.registry.events.DeleteSlotEvent;

import oasis.names.tc.ebxml.regrep.wsdl.registry.services.v4.LifecycleManager;
import oasis.names.tc.ebxml.regrep.wsdl.registry.services.v4.MsgRegistryException;
=======
import com.raytheon.uf.edex.registry.ebxml.exception.EbxmlRegistryException;
import com.raytheon.uf.edex.registry.events.DeleteSlotEvent;

import oasis.names.tc.ebxml.regrep.wsdl.registry.services.v4.LifecycleManager;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import oasis.names.tc.ebxml.regrep.xsd.lcm.v4.Mode;
import oasis.names.tc.ebxml.regrep.xsd.lcm.v4.RemoveObjectsRequest;
import oasis.names.tc.ebxml.regrep.xsd.lcm.v4.SubmitObjectsRequest;
import oasis.names.tc.ebxml.regrep.xsd.query.v4.QueryResponse;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.ExtrinsicObjectType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.ObjectRefListType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.ObjectRefType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.RegistryObjectListType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.RegistryObjectType;

/**
 * A Helper class used to perform synchronization in batches
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 *
 * Date          Ticket#   Engineer    Description
 * ------------- -------- --------- -----------------------
 * 12-31-2018    7238      skabasele   Initial creation
 * 07-09-2019    7889      skabasele   Added call to DeleteSlotEvent
<<<<<<< HEAD
=======
 * 11-02-2020    8261      ksuni       changed logic to return boolean in case of an exception.
 * 04-01-2022    8789      mapeters    Retry forever on failure, make retry delay
 *                                     configurable, improve exception handling
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 *
 * </pre>
 *
 * @author skabasele
 */
<<<<<<< HEAD

=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
public class SynchronizeInBatches {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    /** Batch size for registry synchronization queries */
<<<<<<< HEAD
    protected static final int SYNC_BATCH_SIZE = Integer
            .parseInt(System.getProperty("ebxml-notification-batch-size"));
=======
    private static final int SYNC_BATCH_SIZE = Integer
            .getInteger("ebxml-notification-batch-size");

    /**
     * Number of seconds to wait before retrying a failed batch sync
     */
    private static final int SYNC_RETRY_DELAY_SECS = Integer
            .getInteger("ebxml.federation.sync.retry.delay.secs");
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    private TransactionTemplate txTemplate;

    public enum PersistType {
        ADD_OR_UPDATE_TO_LOCAL_PROCESS,

        REMOVE_FROM_LOCAL_PROCESS,

        ADD_OR_UPDATE_TO_REMOTE_PROCESS,

        REMOVE_FROM_REMOTE_PROCESS;
    }

    private LifecycleManager remoteLifeCycleManager;

    private RegistryObjectDao localRegistryObjectDao;

    private QueryRemoteRegistryHelper queryRemoteRegistryHelper;

    private QueryLocalRegistryHelper queryLocalRegistryHelper;

    private String objectType;

    public SynchronizeInBatches(LifecycleManager remoteLifeCycleManager,
            RegistryObjectDao localRegistryObjectDao,
            TransactionTemplate txTemplate,
            QueryRemoteRegistryHelper queryRemoteRegistryHelper,
<<<<<<< HEAD
            String objectType) {
        this.remoteLifeCycleManager = remoteLifeCycleManager;
        this.localRegistryObjectDao = localRegistryObjectDao;
        this.txTemplate = txTemplate;
        this.queryRemoteRegistryHelper = queryRemoteRegistryHelper;
        this.objectType = objectType;

    }

    public SynchronizeInBatches(LifecycleManager remoteLifeCycleManager,
            RegistryObjectDao localRegistryObjectDao,
            TransactionTemplate txTemplate,
            QueryRemoteRegistryHelper queryRemoteRegistryHelper,
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            String objectType,
            QueryLocalRegistryHelper queryLocalRegistryHelper) {
        this.remoteLifeCycleManager = remoteLifeCycleManager;
        this.localRegistryObjectDao = localRegistryObjectDao;
        this.txTemplate = txTemplate;
        this.queryRemoteRegistryHelper = queryRemoteRegistryHelper;
        this.objectType = objectType;
        this.queryLocalRegistryHelper = queryLocalRegistryHelper;
<<<<<<< HEAD

    }

    public SynchronizeInBatches(RegistryObjectDao localRegistryObjectDao,
            String objectType) {

        this.objectType = objectType;
        this.localRegistryObjectDao = localRegistryObjectDao;

=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * Method used to process the synchronization steps in batches
<<<<<<< HEAD
     * 
     * @param objectType
     * @param queryRemoteRegistryHelper
     * @param registryObjects
     * @param processType
     * @param remoteIds
     */
    private void processInBatches(List<String> ids, PersistType persistType) {

        int batches = (int) Math.ceil(((float) ids.size()) / SYNC_BATCH_SIZE);
        int sIndex = 0;
        int tries = 0;
        boolean retry = false;
        for (int currentBatch = 1; currentBatch <= batches; currentBatch++) {
            tries = 0;
=======
     *
     * @param ids
     *            registry object IDs to process
     * @param persistType
     *            type of processing to do for the given IDs
     */
    private void processInBatches(List<String> ids, PersistType persistType) {
        int batches = (int) Math.ceil(((float) ids.size()) / SYNC_BATCH_SIZE);
        int sIndex = 0;
        for (int currentBatch = 1; currentBatch <= batches; currentBatch++) {
            int attemptNum = 1;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            logger.info("Processing batch " + currentBatch + "/" + batches);
            int eIndex = sIndex + SYNC_BATCH_SIZE;
            if (eIndex > ids.size()) {
                eIndex = ids.size();
            }

<<<<<<< HEAD
            do {
                retry = false;
=======
            // Retry forever until we succeed
            boolean success = false;
            while (!success) {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                try {
                    if (persistType == PersistType.ADD_OR_UPDATE_TO_LOCAL_PROCESS) {
                        batchLocalInsertOrUpdate(ids.subList(sIndex, eIndex));
                    } else if (persistType == PersistType.REMOVE_FROM_LOCAL_PROCESS) {
                        batchLocalDelete(ids.subList(sIndex, eIndex));
                    } else if (persistType == PersistType.ADD_OR_UPDATE_TO_REMOTE_PROCESS) {
                        batchRemoteInsertOrUpdate(ids.subList(sIndex, eIndex));
<<<<<<< HEAD

                    } else if (persistType == PersistType.REMOVE_FROM_REMOTE_PROCESS) {
                        batchRemoteDelete(ids.subList(sIndex, eIndex));
                    }
                } catch (Exception e) {
                    if (tries < 1) {
                        logger.error(
                                "Error occurred synchronizing batch for objectType ["
                                        + objectType + "], retrying...",
                                e);
                        tries++;
                        retry = true;
                    } else {
                        logger.error(
                                "Error occurred synchronizing batch for objectType ["
                                        + objectType + "], skipping batch...",
                                e);
                    }
                }
            } while (retry);
=======
                    } else if (persistType == PersistType.REMOVE_FROM_REMOTE_PROCESS) {
                        batchRemoteDelete(ids.subList(sIndex, eIndex));
                    }

                    success = true;
                } catch (Exception e) {
                    logger.error(
                            "Error occurred synchronizing batch for objectType ["
                                    + objectType + "] on attempt " + attemptNum
                                    + ", retrying in " + SYNC_RETRY_DELAY_SECS
                                    + " seconds...",
                            e);
                    attemptNum++;
                    try {
                        TimeUnit.SECONDS.sleep(SYNC_RETRY_DELAY_SECS);
                    } catch (InterruptedException e1) {
                        // Ignore
                    }
                }
            }
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            sIndex = eIndex;
        }

    }

    /**
     * Creates a RemoveObjectsRequest object based on the passed List of
     * RegistryObjectType
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param objs
     * @return
     */
    private RemoveObjectsRequest createRemoveObjectsRequest(
            List<RegistryObjectType> objs) {
        ObjectRefListType refList = new ObjectRefListType();
        RemoveObjectsRequest req = new RemoveObjectsRequest();
        for (RegistryObjectType obj : objs) {
            refList.getObjectRef().add(new ObjectRefType(obj.getId()));
        }

        req.setId("Removing registry objects");
        req.setComment("Remove request to remove registry objects");
        req.setDeleteChildren(true);
        req.setObjectRefList(refList);

        return req;
    }

    /**
     * Creates a SubmitObjectsRequest object based on the passed List of
     * RegistryObjectType
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param objs
     * @return
     */
    private SubmitObjectsRequest createSubmitObjectsRequest(
            List<RegistryObjectType> objs) {

        SubmitObjectsRequest submitObjectsRequest = new SubmitObjectsRequest(
                "Adding registry objects", "Submit registry objects", null,
                new RegistryObjectListType(objs), false,
                Mode.CREATE_OR_REPLACE);

        return submitObjectsRequest;
    }

    /**
     * Get the registry objects from remote to insert/update local database
<<<<<<< HEAD
     * 
     * @param remoteIdsSubList
     */
    private void batchLocalInsertOrUpdate(List<String> remoteIdsSubList) {
=======
     *
     * @param remoteIdsSubList
     * @throws EbxmlRegistryException
     */
    private void batchLocalInsertOrUpdate(List<String> remoteIdsSubList)
            throws EbxmlRegistryException {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

        QueryResponse remoteQueryResponse = queryRemoteRegistryHelper
                .getQueryResponse(remoteIdsSubList);
        List<RegistryObjectType> listRemote = remoteQueryResponse
                .getRegistryObjects();

        try {

            txTemplate.execute(new TransactionCallbackWithoutResult() {
                @Override
                protected void doInTransactionWithoutResult(
                        TransactionStatus status) {
<<<<<<< HEAD

=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                    if (!CollectionUtil.isNullOrEmpty(listRemote)) {

                        for (RegistryObjectType objectToSubmit : listRemote) {
                            RegistryObjectType existingObject = localRegistryObjectDao
                                    .getById(objectToSubmit.getId());
                            if (existingObject == null) {
                                localRegistryObjectDao.create(objectToSubmit);
                            } else {

                                removeRepositoryItem(existingObject);
                                localRegistryObjectDao
                                        .deleteWithoutMerge(existingObject);
                                DeleteSlotEvent deleteEvent = new DeleteSlotEvent(
                                        existingObject.getSlot());
                                EventBus.publish(deleteEvent);

                                objectToSubmit
                                        .setSlot(objectToSubmit.getSlot());
                                localRegistryObjectDao.create(objectToSubmit);
                            }

                        }
                        localRegistryObjectDao.flushAndClearSession();
                    }
                    logger.info(
<<<<<<< HEAD
                            "Local insert/update performed successfully for batch ");
=======
                            "Local insert/update performed successfully for batch");
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                }

            });

        } catch (Exception e) {
<<<<<<< HEAD
            logger.info("Error occured while persisting objects ", e);
=======
            throw new EbxmlRegistryException(
                    "Error occured while persisting objects", e);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        }

    }

    /**
     * Get the registry objects to be deleted from the local database
<<<<<<< HEAD
     * 
     * @param remoteIdsSubList
     */
    private void batchLocalDelete(List<String> remoteIdsSubList) {
=======
     *
     * @param remoteIdsSubList
     * @throws EbxmlRegistryException
     */
    private void batchLocalDelete(List<String> remoteIdsSubList)
            throws EbxmlRegistryException {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        /*
         * Note that because of the need to query the local database to retrieve
         * the local objects. This method will require a separate session hence
         * the call to queryLocalRegistryHelper. Otherwise, we would be
         * subjected to LazyInitializationExceptions given the way the
         * RegistryObject's slots are fetched coupled with the fact that
         * Hibernate's sessions are not meant to be shared amongst different
         * threads especially in the retrieval and deletion process.
         */
        List<RegistryObjectType> listLocal = queryLocalRegistryHelper
                .getRegistryObjectByIds(remoteIdsSubList);

        try {

            if (!CollectionUtil.isNullOrEmpty(listLocal)) {
                for (RegistryObjectType obj : listLocal) {
                    DeleteSlotEvent deleteEvent = new DeleteSlotEvent(
                            obj.getSlot());
                    if (queryLocalRegistryHelper.deleteWithoutMerge(obj)) {
                        EventBus.publish(deleteEvent);
                    }

                }
<<<<<<< HEAD
                logger.info("Local delete performed successfully for batch ");
            }

        } catch (Exception e) {
            logger.info("Error occured while deleting registry objects. ", e);
=======
                logger.info("Local delete performed successfully for batch");
            }

        } catch (Exception e) {
            throw new EbxmlRegistryException(
                    "Error occured while deleting registry objects", e);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        }

    }

    /**
     * Get the registry objects from local to insert/update remote database
<<<<<<< HEAD
     * 
     * @param localIdsSubList
     */
    private void batchRemoteInsertOrUpdate(List<String> localIdsSubList) {

        try {

=======
     *
     * @param localIdsSubList
     * @throws EbxmlRegistryException
     */
    private void batchRemoteInsertOrUpdate(List<String> localIdsSubList)
            throws EbxmlRegistryException {

        try {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            List<RegistryObjectType> listLocal = queryLocalRegistryHelper
                    .getRegistryObjectByIds(localIdsSubList);

            if (!CollectionUtil.isNullOrEmpty(listLocal)) {
<<<<<<< HEAD

                try {

                    SubmitObjectsRequest submitObjectsRequest = createSubmitObjectsRequest(
                            listLocal);

                    remoteLifeCycleManager.submitObjects(submitObjectsRequest);
                    logger.info(
                            "Remote insert/update performed successfully for batch ");

                } catch (MsgRegistryException e) {
                    logger.error(
                            "Error occurred during adding registry objects to remote server",
                            e);
                }

            }

        } catch (Exception e) {
            logger.info("Error occured while persisting objects ", e);
=======
                SubmitObjectsRequest submitObjectsRequest = createSubmitObjectsRequest(
                        listLocal);

                remoteLifeCycleManager.submitObjects(submitObjectsRequest);
                logger.info(
                        "Remote insert/update performed successfully for batch");
            }
        } catch (Exception e) {
            throw new EbxmlRegistryException(
                    "Error occured while persisting objects", e);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        }

    }

    /**
     * Get the registry objects from local to delete from remote database
<<<<<<< HEAD
     * 
     * @param localIdsSubList
     */
    private void batchRemoteDelete(List<String> localIdsSubList) {

        try {

=======
     *
     * @param localIdsSubList
     * @throws EbxmlRegistryException
     */
    private void batchRemoteDelete(List<String> localIdsSubList)
            throws EbxmlRegistryException {

        try {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            QueryResponse remoteQueryResponse = queryRemoteRegistryHelper
                    .getQueryResponse(localIdsSubList);
            List<RegistryObjectType> listLocal = remoteQueryResponse
                    .getRegistryObjects();

            if (!CollectionUtil.isNullOrEmpty(listLocal)) {
<<<<<<< HEAD

                try {

                    RemoveObjectsRequest req = createRemoveObjectsRequest(
                            listLocal);
                    remoteLifeCycleManager.removeObjects(req);
                    logger.info(
                            "Remote delete performed successfully for batch ");
                } catch (MsgRegistryException e) {
                    logger.error(
                            "Error occurred during removing registry objects from remote server",
                            e);
                }

            }

        } catch (Exception e) {
            logger.info("Error occured while deleting registry objects. ", e);
=======
                RemoveObjectsRequest req = createRemoveObjectsRequest(
                        listLocal);
                remoteLifeCycleManager.removeObjects(req);
                logger.info("Remote delete performed successfully for batch");
            }
        } catch (Exception e) {
            throw new EbxmlRegistryException(
                    "Error occured while deleting registry objects. ", e);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        }

    }

    /**
     * Method used to initiate local Insert/Update synchronization
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param localObjectIdsToAddToRemote
     */
    public void localInsertOrUpdate(
            List<String> remoteObjectIdsToAddOrUpdateToLocal) {
        processInBatches(remoteObjectIdsToAddOrUpdateToLocal,
                PersistType.ADD_OR_UPDATE_TO_LOCAL_PROCESS);
    }

    /**
     * Method used to initiate local delete synchronization
<<<<<<< HEAD
     * 
     * @param localObjectIdsToAddToRemote
     */
    public void localDelete(List<String> remoteObjectsIdsToRemoveFromLocal) {

=======
     *
     * @param localObjectIdsToAddToRemote
     */
    public void localDelete(List<String> remoteObjectsIdsToRemoveFromLocal) {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        processInBatches(remoteObjectsIdsToRemoveFromLocal,
                PersistType.REMOVE_FROM_LOCAL_PROCESS);
    }

    /**
     * Method used to remote Insert/Update synchronization
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param localObjectIdsToAddToRemote
     */
    public void remoteInsertOrUpdate(
            List<String> localObjectIdsToAddOrUpdateToRemote) {
        processInBatches(localObjectIdsToAddOrUpdateToRemote,
                PersistType.ADD_OR_UPDATE_TO_REMOTE_PROCESS);
    }

    /**
     * Method used to remote delete synchronization
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param localObjectIdsToAddToRemote
     */
    public void remoteDelete(List<String> localobjectIdsToRemoveFromRemote) {
        processInBatches(localobjectIdsToRemoveFromRemote,
                PersistType.REMOVE_FROM_REMOTE_PROCESS);
    }

    /**
     * This method removes the repository item for the specified registry
     * object.
     * <p>
     * This method will have to be expanded to handle remove objects that are
     * linked to. Right now, the assumption is that the repository item is
     * contained in the repositoryItem field of the object
     *
     * @param obj
     */
    private void removeRepositoryItem(RegistryObjectType obj) {
        if (obj instanceof ExtrinsicObjectType) {
            ExtrinsicObjectType extrinsicObject = (ExtrinsicObjectType) obj;
            extrinsicObject.setRepositoryItem(null);
            localRegistryObjectDao.update(obj);
        }

    }

}
