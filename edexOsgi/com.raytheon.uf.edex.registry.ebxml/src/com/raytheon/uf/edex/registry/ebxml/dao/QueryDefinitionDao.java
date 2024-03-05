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
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.ParameterType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.QueryDefinitionType;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * Data access object for QueryDefinitionType objects
 * 
 * <pre>
 * 
 * SOFTWARE HISTORY
 * 
 * Date         Ticket#     Engineer    Description
 * ------------ ----------  ----------- --------------------------
 * 10/8/2013    1682        bphillip    Initial implementation
 * 12/2/2013    1829        bphillip    Changed get parameters for query method
 * 2/13/2014    2769       bphillip    Added read only flags to query methods
 * </pre>
 * 
 * @author bphillip
 * @version 1
 */
public class QueryDefinitionDao extends
        RegistryObjectTypeDao<QueryDefinitionType> {
=======
import com.raytheon.uf.edex.database.dao.IDaoConfigFactory;

import oasis.names.tc.ebxml.regrep.xsd.rim.v4.ParameterType;
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.QueryDefinitionType;

/**
 *
 * Data access object for QueryDefinitionType objects
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 *
 * Date          Ticket#  Engineer   Description
 * ------------- -------- ---------- ---------------------------------------------------------------
 * Oct 08, 2013  1682     bphillip   Initial implementation
 * Dec 02, 2013  1829     bphillip   Changed get parameters for query method
 * Feb 13, 2014  2769     bphillip   Added read only flags to query methods
 * Apr 14, 2021  7849     mapeters   Refactor to use TransactionTemplate.execute instead of
 *                                   Transactional annotations
 *
 * </pre>
 *
 * @author bphillip
 */
public class QueryDefinitionDao
        extends RegistryObjectTypeDao<QueryDefinitionType> {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * Query used to get the query Ids of all the query definitions contained in
     * the registry
     */
    private static final String GET_QUERY_IDS_QUERY = "SELECT obj.id FROM QueryDefinitionType obj order by obj.id asc";

<<<<<<< HEAD
    /**
     * Gets the ids of all the query definitions contained in the registry
     * 
     * @return The ids of the query definitions in the registry
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
=======
    public QueryDefinitionDao(IDaoConfigFactory daoConfigFactory) {
        super(daoConfigFactory);
    }

    /**
     * Gets the ids of all the query definitions contained in the registry
     *
     * @return The ids of the query definitions in the registry
     */
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    public List<String> getQueryIds() {
        return executeHQLQuery(GET_QUERY_IDS_QUERY);
    }

    /**
     * Gets the parameters for the given query
<<<<<<< HEAD
     * 
=======
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param queryId
     *            The query id to get the parameters for
     * @return The parameters for the specified query
     */
<<<<<<< HEAD
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    public List<ParameterType> getParametersForQuery(String queryId) {
        return this.getById(queryId).getParameter();
    }

    @Override
    protected Class<QueryDefinitionType> getEntityClass() {
        return QueryDefinitionType.class;
    }

}
