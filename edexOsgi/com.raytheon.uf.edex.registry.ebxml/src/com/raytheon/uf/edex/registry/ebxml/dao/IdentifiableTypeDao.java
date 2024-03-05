/**
 * This software was developed and / or modifieimport java.util.Arrays;
import java.util.List;

import oasis.names.tc.ebxml.regrep.xsd.rim.v4.IdentifiableType;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;

import com.raytheon.uf.edex.database.DataAccessLayerException;
import com.raytheon.uf.edex.database.dao.SessionManagedDao;
import com.raytheon.uf.edex.registry.ebxml.exception.EbxmlRegistryException;
import com.raytheon.uf.edex.registry.ebxml.services.query.QueryConstants;
 B8
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

import java.util.Arrays;
import java.util.List;

<<<<<<< HEAD
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.IdentifiableType;

import org.hibernate.criterion.Property;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.raytheon.uf.edex.registry.ebxml.exception.EbxmlRegistryException;
import com.raytheon.uf.edex.registry.ebxml.services.query.QueryConstants;

/**
 * Data access object for retrieving IdentifiableType objects
 * 
 * <pre>
 * 
 * SOFTWARE HISTORY
 * 
=======
import org.hibernate.criterion.Property;

import com.raytheon.uf.edex.database.dao.IDaoConfigFactory;
import com.raytheon.uf.edex.registry.ebxml.services.query.QueryConstants;

import oasis.names.tc.ebxml.regrep.xsd.rim.v4.IdentifiableType;

/**
 * Data access object for retrieving IdentifiableType objects
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 * Date         Ticket#    Engineer    Description
 * ------------ ---------- ----------- --------------------------
 * 3/18/2013    1082       bphillip     Initial creation
 * 4/9/2013     1802       bphillip    Removed exception catching
 * 10/08/2013   1682       bphillip    Added the id like query
 * 12/2/2013    1829       bphillip    Now extends ExtensibleObjectTypeDao
 * 2/13/2014    2769       bphillip    Added read only flags to query methods
<<<<<<< HEAD
 * 
 * </pre>
 * 
 * @author bphillip
 * @version 1.0
 */
public class IdentifiableTypeDao<ENTITY extends IdentifiableType> extends
        ExtensibleObjectTypeDao<ENTITY> {

    public IdentifiableTypeDao() {

=======
 * Dec 09, 2021 7849       mapeters    Refactor to use TransactionTemplate.execute instead of
 *                                     Transactional annotations
 *
 *
 * </pre>
 *
 * @author bphillip
 */
public class IdentifiableTypeDao<ENTITY extends IdentifiableType>
        extends ExtensibleObjectTypeDao<ENTITY> {

    public IdentifiableTypeDao(IDaoConfigFactory daoConfigFactory) {
        this(daoConfigFactory, false);
    }

    public IdentifiableTypeDao(IDaoConfigFactory daoConfigFactory,
            boolean admin) {
        super(daoConfigFactory, admin);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * Retrieves registry objects based on id values
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param <T>
     *            A class type extending RegistryObjectType
     * @param ids
     *            The array of ids to query for
     * @return The list of registry objects;
<<<<<<< HEAD
     * @throws EbxmlRegistryException
     *             If the query encounters errors
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<ENTITY> getById(String... ids) throws EbxmlRegistryException {
        return getById(Arrays.asList(ids));
=======
     */
    public List<ENTITY> getById(String... ids) {
        return supplyInTransaction(requiredReadOnlyTransactionDef, () -> {
            return getById(Arrays.asList(ids));
        });
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * Retrieves registry objects based on id values
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param <T>
     *            A class type extending RegistryObjectType
     * @param ids
     *            The list of ids to query for
     * @return The list of registry objects;
<<<<<<< HEAD
     * @throws EbxmlRegistryException
     *             If the query encounters errors
     */
    @SuppressWarnings("unchecked")
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<ENTITY> getById(List<String> ids) throws EbxmlRegistryException {
        return createCriteria()
                .add(Property.forName(QueryConstants.ID).in(ids)).list();
=======
     */
    @SuppressWarnings("unchecked")
    public List<ENTITY> getById(List<String> ids) {
        return supplyInTransaction(requiredReadOnlyTransactionDef, () -> {
            return createCriteria()
                    .add(Property.forName(QueryConstants.ID).in(ids)).list();
        });
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    /**
     * Gets all IdentifiableType objects matching (using like) the given id.
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param id
     *            The id to query for
     * @return All IdentifiableType objects matching the given id
     */
    @SuppressWarnings("unchecked")
<<<<<<< HEAD
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<ENTITY> getByIdUsingLike(String id) {
        return createCriteria().add(
                Property.forName(QueryConstants.ID).like(id)).list();
    }

=======
    public List<ENTITY> getByIdUsingLike(String id) {
        return supplyInTransaction(requiredReadOnlyTransactionDef, () -> {
            return createCriteria()
                    .add(Property.forName(QueryConstants.ID).like(id)).list();
        });
    }
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
}
