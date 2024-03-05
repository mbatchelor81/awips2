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

<<<<<<< HEAD
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.ExtensibleObjectType;

import com.raytheon.uf.edex.database.dao.SessionManagedDao;

/**
 * <pre>
 * 
 * Data access object for interactions with ExtensibleObjectType objects
 * 
 * SOFTWARE HISTORY
 * 
 * Date         Ticket#     Engineer    Description
 * ------------ ----------  ----------- --------------------------
 * 12/2/2013    1829        bphillip    Initial Creation
 * </pre>
 * 
 * @author bphillip
 * @version 1
=======
import java.util.List;

import org.hibernate.criterion.Property;

import com.raytheon.uf.edex.database.dao.IDaoConfigFactory;
import com.raytheon.uf.edex.database.dao.SessionManagedDao;
import com.raytheon.uf.edex.registry.ebxml.services.query.QueryConstants;

import oasis.names.tc.ebxml.regrep.xsd.rim.v4.ExtensibleObjectType;

/**
 * <pre>
 *
 * Data access object for interactions with ExtensibleObjectType objects
 *
 * SOFTWARE HISTORY
 *
 * Date          Ticket#  Engineer   Description
 * ------------- -------- ---------- -------------------------------------------
 * Dec 02, 2013  1829     bphillip   Initial Creation
 * Apr 14, 2021  7849     mapeters   Refactor to use TransactionTemplate.execute
 *                                   instead of Transactional annotations
 *
 * </pre>
 *
 * @author bphillip
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 **/
public class ExtensibleObjectTypeDao<ENTITY extends ExtensibleObjectType>
        extends SessionManagedDao<String, ENTITY> {

<<<<<<< HEAD
=======
    public ExtensibleObjectTypeDao(IDaoConfigFactory daoConfigFactory) {
        this(daoConfigFactory, false);
    }

    public ExtensibleObjectTypeDao(IDaoConfigFactory daoConfigFactory,
            boolean admin) {
        super(daoConfigFactory, admin);
    }

    /**
     * Gets all ExtensibleObjectType objects matching (using like) the given
     * lid.
     *
     * @param lid
     *            The lid to query for
     * @return All ExtensibleObjectType objects matching the given lid
     */
    @SuppressWarnings("unchecked")
    public List<ENTITY> getByLidUsingLike(String lid) {
        return supplyInTransaction(requiredReadOnlyTransactionDef, () -> {
            return createCriteria()
                    .add(Property.forName(QueryConstants.LID).like(lid)).list();
        });
    }

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    @SuppressWarnings("unchecked")
    @Override
    protected Class<ENTITY> getEntityClass() {
        return (Class<ENTITY>) ExtensibleObjectType.class;
    }

}
