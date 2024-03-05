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

package com.raytheon.uf.edex.registry.ebxml.dao;

import java.util.List;

<<<<<<< HEAD
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.AssociationType;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.raytheon.uf.edex.registry.ebxml.exception.EbxmlRegistryException;

/**
 * Data Access object for interacting with associations
 * 
 * <pre>
 * 
 * SOFTWARE HISTORY
 * 
 * Date         Ticket#    Engineer    Description
 * ------------ ---------- ----------- --------------------------
 * 7/30/2012    724        bphillip     Initial creation
 * 3/18/2013    1802         bphillip    Modified to use transaction boundaries and spring injection
 * 4/9/2013     1802        bphillip     Removed exception catching
 * 2/13/2014    2769        bphillip     Added read only flags to query methods
 * 
 * </pre>
 * 
 * @author bphillip
 * @version 1.0
 */
public class AssociationDao extends RegistryObjectTypeDao<AssociationType> {

    /**
     * Gets associations based on the association target and type
     * 
=======
import com.raytheon.uf.edex.database.dao.IDaoConfigFactory;
import com.raytheon.uf.edex.registry.ebxml.exception.EbxmlRegistryException;

import oasis.names.tc.ebxml.regrep.xsd.rim.v4.AssociationType;

/**
 * Data Access object for interacting with associations
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 *
 * Date          Ticket#  Engineer  Description
 * ------------- -------- --------- --------------------------------------------
 * Jul 30, 2012  724      bphillip  Initial creation
 * Mar 18, 2013  1802     bphillip  Modified to use transaction boundaries and
 *                                  spring injection
 * Apr 09, 2013  1802     bphillip  Removed exception catching
 * Feb 13, 2014  2769     bphillip  Added read only flags to query methods
 * Apr 14, 2021  7849     mapeters  Refactor to use TransactionTemplate.execute
 *                                  instead of Transactional annotations
 *
 * </pre>
 *
 * @author bphillip
 */
public class AssociationDao extends RegistryObjectTypeDao<AssociationType> {

    public AssociationDao(IDaoConfigFactory daoConfigFactory) {
        super(daoConfigFactory);
    }

    /**
     * Gets associations based on the association target and type
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param target
     *            The target of the association
     * @param type
     *            The type of the association
     * @return Associations matching the given criteria
     * @throws EbxmlRegistryException
     *             If errors occur during interaction with the database
     */
<<<<<<< HEAD
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<AssociationType> getByTargetAndType(String target, String type) {
        return executeHQLQuery("from AssociationType obj where obj.targetObject='"
                + target + "' and obj.type='" + type + "'");
=======
    public List<AssociationType> getByTargetAndType(String target,
            String type) {
        return executeHQLQuery(
                "from AssociationType obj where obj.targetObject='" + target
                        + "' and obj.type='" + type + "'");
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * Gets associations based on the association source and type
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param source
     *            The source of the association
     * @param type
     *            The type of the association
     * @return Associations matching the given criteria
     * @throws EbxmlRegistryException
     *             If errors occur during interaction with the database
     */
<<<<<<< HEAD
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<AssociationType> getBySourceAndType(String source, String type) {
        return executeHQLQuery("from AssociationType obj where obj.sourceObject='"
                + source + "' and obj.type='" + type + "'");
=======
    public List<AssociationType> getBySourceAndType(String source,
            String type) {
        return executeHQLQuery(
                "from AssociationType obj where obj.sourceObject='" + source
                        + "' and obj.type='" + type + "'");
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * Gest associations based on the source, target and type of association
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param source
     *            The association source
     * @param target
     *            The association target
     * @param type
     *            The association type
     * @return Associations matching the given criteria
     * @throws EbxmlRegistryException
     *             If errors occur during interaction with the database
     */
<<<<<<< HEAD
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<AssociationType> getBySourceTargetAndType(String source,
            String target, String type) {
        return executeHQLQuery("from AssociationType obj where obj.sourceObject='"
                + source
                + "' and obj.type='"
                + type
                + "' and obj.targetObject='" + target + "'");
=======
    public List<AssociationType> getBySourceTargetAndType(String source,
            String target, String type) {
        return executeHQLQuery(
                "from AssociationType obj where obj.sourceObject='" + source
                        + "' and obj.type='" + type + "' and obj.targetObject='"
                        + target + "'");
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * Gets all associations referencing the provided object ID
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param objReferenced
     *            The id of the object being referenced by an association
     * @return The assocations referencing the given object ID
     * @throws EbxmlRegistryException
     *             If errors occur during interaction with the database
     */
<<<<<<< HEAD
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<AssociationType> getAllAssociations(String objReferenced) {
        return executeHQLQuery("from AssociationType obj where obj.sourceObject='"
                + objReferenced
                + "' or obj.targetObject='"
                + objReferenced
                + "'");
=======
    public List<AssociationType> getAllAssociations(String objReferenced) {
        return executeHQLQuery(
                "from AssociationType obj where obj.sourceObject='"
                        + objReferenced + "' or obj.targetObject='"
                        + objReferenced + "'");
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * Gets all associations with the target specified as the given object ID
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param objReferenced
     *            The object ID
     * @return All associations with the target specified as the given object ID
     * @throws EbxmlRegistryException
     *             If errors occur during interaction with the database
     */
<<<<<<< HEAD
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<AssociationType> getAssociationsTo(String objReferenced) {
        return executeHQLQuery("from AssociationType obj where obj.targetObject='"
                + objReferenced + "'");
=======
    public List<AssociationType> getAssociationsTo(String objReferenced) {
        return executeHQLQuery(
                "from AssociationType obj where obj.targetObject='"
                        + objReferenced + "'");
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * Gets all associations with the source specified as the given object ID
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param objReferenced
     *            The object ID
     * @return All associations with the target specified as the given object ID
     * @throws EbxmlRegistryException
     *             If errors occur during interaction with the database
     */
<<<<<<< HEAD
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<AssociationType> getAssociationsFrom(String objReferenced) {
        return executeHQLQuery("from AssociationType obj where obj.sourceObject='"
                + objReferenced + "'");
=======
    public List<AssociationType> getAssociationsFrom(String objReferenced) {
        return executeHQLQuery(
                "from AssociationType obj where obj.sourceObject='"
                        + objReferenced + "'");
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * Deletes all associations referencing the given object ID
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param objReferenced
     *            The object ID
     * @throws EbxmlRegistryException
     *             If errors occur during interaction with the database
     */
    public void deleteAssociationsForObj(String objReferenced) {
<<<<<<< HEAD
        List<AssociationType> associations = getAllAssociations(objReferenced);
        if (!associations.isEmpty()) {
            for (AssociationType association : associations) {
                this.delete(association);
            }
        }
=======
        runInTransaction(() -> {
            List<AssociationType> associations = getAllAssociations(
                    objReferenced);
            if (!associations.isEmpty()) {
                for (AssociationType association : associations) {
                    this.delete(association);
                }
            }
        });
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    @Override
    protected Class<AssociationType> getEntityClass() {
        return AssociationType.class;
    }
}
