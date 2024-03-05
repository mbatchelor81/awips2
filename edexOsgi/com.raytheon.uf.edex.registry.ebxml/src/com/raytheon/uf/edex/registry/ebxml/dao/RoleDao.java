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
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.RoleType;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.raytheon.uf.common.registry.constants.AssociationTypes;
import com.raytheon.uf.edex.registry.ebxml.exception.EbxmlRegistryException;

/**
 * Data Access object for interacting with roles in the registry
 * 
 * <pre>
 * 
 * SOFTWARE HISTORY
 * 
 * Date         Ticket#    Engineer    Description
 * ------------ ---------- ----------- --------------------------
 * 7/30/2012    724        bphillip     Initial creation
 * 3/13/2013    1082       bphillip    Modified to use spring injection and transaction boundaries
 * 4/9/2013     1802       bphillip    Removed exception catching
 * 2/13/2014    2769       bphillip    Added read only flags to query methods
 * 
 * </pre>
 * 
 * @author bphillip
 * @version 1.0
=======
import com.raytheon.uf.common.registry.constants.AssociationTypes;
import com.raytheon.uf.edex.database.dao.IDaoConfigFactory;
import com.raytheon.uf.edex.registry.ebxml.exception.EbxmlRegistryException;

import oasis.names.tc.ebxml.regrep.xsd.rim.v4.AssociationType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.RoleType;

/**
 * Data Access object for interacting with roles in the registry
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 *
 * Date          Ticket#  Engineer   Description
 * ------------- -------- ---------- ---------------------------------------------------------------
 * Jul 30, 2012  724      bphillip   Initial creation
 * Mar 13, 2013  1082     bphillip   Modified to use spring injection and transaction boundaries
 * Apr 09, 2013  1802     bphillip   Removed exception catching
 * Feb 13, 2014  2769     bphillip   Added read only flags to query methods
 * Apr 14, 2021  7849     mapeters   Refactor to use TransactionTemplate.execute instead of
 *                                   Transactional annotations
 *
 * </pre>
 *
 * @author bphillip
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 */
public class RoleDao extends RegistryObjectTypeDao<RoleType> {

    private AssociationDao associationDao;

    /**
     * Creates a new Role data access object
     */
<<<<<<< HEAD
    public RoleDao() {

=======
    public RoleDao(IDaoConfigFactory daoConfigFactory) {
        super(daoConfigFactory);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * Gets the role of the given user
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param user
     *            The ID of the user to get the role for
     * @return The role of the user
     * @throws EbxmlRegistryException
     *             If errors occur during interaction with the database
     */
<<<<<<< HEAD
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public RoleType getUserRole(String user) throws EbxmlRegistryException {
        List<AssociationType> associations = associationDao.getBySourceAndType(
                user, AssociationTypes.HAS_ROLE);
        if (associations.isEmpty()) {
            return null;
        }
        AssociationType roleAssociation = associations.get(0);
        return this.getById(roleAssociation.getTargetObject());
=======
    public RoleType getUserRole(String user) {
        return supplyInTransaction(requiredReadOnlyTransactionDef, () -> {
            List<AssociationType> associations = associationDao
                    .getBySourceAndType(user, AssociationTypes.HAS_ROLE);
            if (associations.isEmpty()) {
                return null;
            }
            AssociationType roleAssociation = associations.get(0);
            return this.getById(roleAssociation.getTargetObject());
        });
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    public void setAssociationDao(AssociationDao associationDao) {
        this.associationDao = associationDao;
    }

    @Override
    protected Class<RoleType> getEntityClass() {
        return RoleType.class;
    }

}
