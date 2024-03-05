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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

<<<<<<< HEAD
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.AssociationType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.PersonType;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.raytheon.uf.common.registry.constants.AssociationTypes;
import com.raytheon.uf.edex.registry.ebxml.exception.EbxmlRegistryException;

/**
 * Data Access object for interacting with persons in the registry
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

import oasis.names.tc.ebxml.regrep.xsd.rim.v4.AssociationType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.PersonType;

/**
 * Data Access object for interacting with persons in the registry
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
public class PersonDao extends RegistryObjectTypeDao<PersonType> {

    private static final String GET_BY_FIRST_NAME_QUERY = "select obj from PersonType obj where lower(obj.personName.firstName) like :firstName order by obj.personName.lastName asc, obj.personName.firstName asc";

    private static final String GET_BY_LAST_NAME_QUERY = "select obj from PersonType obj where lower(obj.personName.lastName) like :lastName order by obj.personName.lastName asc, obj.personName.firstName asc";

    private static final String GET_BY_FIRST_AND_LAST_NAME_QUERY = "select obj from PersonType obj where lower(obj.personName.firstName) like :firstname and lower(obj.personName.lastName) like :lastName order by obj.personName.lastName asc, obj.personName.firstName asc";

    private static final String GET_ALL_USER_NAMES_QUERY = "select obj.id, obj.personName.firstName, obj.personName.lastName from PersonType obj "
            + "order by obj.personName.lastName asc, obj.personName.firstName asc";

    private AssociationDao associationDao;

    /**
     * Creates a new Person data access object
     */
<<<<<<< HEAD
    public PersonDao() {
=======
    public PersonDao(IDaoConfigFactory daoConfigFactory) {
        super(daoConfigFactory);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * Gets all users matching the given first name using a case insensitive
     * like query
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param firstName
     *            The first name
     * @return The matching users
     */
<<<<<<< HEAD
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    public List<PersonType> getByFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            return Collections.emptyList();
        }
<<<<<<< HEAD
        return this.executeHQLQuery(GET_BY_FIRST_NAME_QUERY, ":firstName", "%"
                + firstName.toLowerCase() + "%");

=======
        return this.executeHQLQuery(GET_BY_FIRST_NAME_QUERY, ":firstName",
                "%" + firstName.toLowerCase() + "%");
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * Gets all users matching the given last name using a case insensitive like
     * query
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param lastName
     *            The last name
     * @return The matching users
     */
<<<<<<< HEAD
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    public List<PersonType> getByLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            return Collections.emptyList();
        }
<<<<<<< HEAD
        return this.executeHQLQuery(GET_BY_LAST_NAME_QUERY, "lastName", "%"
                + lastName.toLowerCase() + "%");
=======
        return this.executeHQLQuery(GET_BY_LAST_NAME_QUERY, "lastName",
                "%" + lastName.toLowerCase() + "%");
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    }

    /**
     * Gets all users matching the given first and last name using a case
     * insensitive like query
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param firstName
     *            The first name
     * @param lastName
     *            The last name
     * @return The matching users
     */
<<<<<<< HEAD
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<PersonType> getByFirstAndLastName(String firstName,
            String lastName) {
        if (firstName.trim().isEmpty() && lastName.trim().isEmpty()) {
            return this.executeHQLQuery("from PersonType");
        }
        if (firstName == null || firstName.trim().isEmpty()) {
            return getByLastName(lastName);
        } else if (lastName == null || lastName.trim().isEmpty()) {
            return getByFirstName(firstName);
        }
        return this.executeHQLQuery(GET_BY_FIRST_AND_LAST_NAME_QUERY,
                "firstName", "%" + firstName.toLowerCase() + "%", "lastName",
                "%" + lastName.toLowerCase() + "%");

=======
    public List<PersonType> getByFirstAndLastName(String firstName,
            String lastName) {
        return supplyInTransaction(requiredReadOnlyTransactionDef, () -> {
            if (firstName.trim().isEmpty() && lastName.trim().isEmpty()) {
                return this.executeHQLQuery("from PersonType");
            }
            if (firstName == null || firstName.trim().isEmpty()) {
                return getByLastName(lastName);
            } else if (lastName == null || lastName.trim().isEmpty()) {
                return getByFirstName(firstName);
            }
            return this.executeHQLQuery(GET_BY_FIRST_AND_LAST_NAME_QUERY,
                    "firstName", "%" + firstName.toLowerCase() + "%",
                    "lastName", "%" + lastName.toLowerCase() + "%");

        });
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * Gets all users who are associated with the given organization
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param orgId
     *            The organization ID
     * @return The users associated with the organization
     */
<<<<<<< HEAD
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<PersonType> getEmployeesOfOrganization(String orgId) {
        List<PersonType> employees = new ArrayList<PersonType>();
        List<AssociationType> associations = associationDao.getByTargetAndType(
                orgId, AssociationTypes.EMPLOYEE_OF);
        for (AssociationType association : associations) {
            employees.add((PersonType) getById(association.getSourceObject()));
        }
        return employees;
=======
    public List<PersonType> getEmployeesOfOrganization(String orgId) {
        return supplyInTransaction(requiredReadOnlyTransactionDef, () -> {
            List<PersonType> employees = new ArrayList<>();
            List<AssociationType> associations = associationDao
                    .getByTargetAndType(orgId, AssociationTypes.EMPLOYEE_OF);
            for (AssociationType association : associations) {
                employees.add(getById(association.getSourceObject()));
            }
            return employees;
        });
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * Gets the id, first name, and last name for all PersonType objects in the
     * registry
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @return List of object arrays (List<Object[]>) Each object array contains
     *         the id, first name, and last name for each PersonType object in
     *         the registry
     */
<<<<<<< HEAD
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Object getAllUserNames() throws EbxmlRegistryException {
=======
    public Object getAllUserNames() {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        return this.executeHQLQuery(GET_ALL_USER_NAMES_QUERY);

    }

    /**
     * Gets all PersonType objects in the registry
<<<<<<< HEAD
     * 
     * @return All personType objects in the registry
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<PersonType> getAllUsers() throws EbxmlRegistryException {
=======
     *
     * @return All personType objects in the registry
     */
    public List<PersonType> getAllUsers() {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        return getByFirstAndLastName("", "");
    }

    /**
     * Gets a specific user given the object ID
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param userId
     *            The ID of the person
     * @return The person with the given ID
     */
<<<<<<< HEAD
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    public PersonType getByUserId(String userId) {
        return this.getById(userId);
    }

    public void setAssociationDao(AssociationDao associationDao) {
        this.associationDao = associationDao;
    }

    @Override
    protected Class<PersonType> getEntityClass() {
        return PersonType.class;
    }

}
