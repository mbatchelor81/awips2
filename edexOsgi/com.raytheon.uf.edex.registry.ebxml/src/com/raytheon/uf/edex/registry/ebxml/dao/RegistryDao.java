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
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.RegistryType;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * Data access object for RegistryType objects
 * 
 * <pre>
 * 
 * SOFTWARE HISTORY
 * 
 * Date         Ticket#     Engineer    Description
 * ------------ ----------  ----------- --------------------------
 * 5/21/2013    2022        bphillip    Initial implementation
  * </pre>
 * 
 * @author bphillip
 * @version 1
=======
import org.springframework.transaction.TransactionDefinition;

import com.raytheon.uf.edex.database.dao.IDaoConfigFactory;

import oasis.names.tc.ebxml.regrep.xsd.rim.v4.RegistryType;

/**
 *
 * Data access object for RegistryType objects
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 *
 * Date          Ticket#  Engineer  Description
 * ------------- -------- --------- ----------------------------------------------------------------
 * May 21, 2013  2022     bphillip  Initial implementation
 * Apr 14, 2021  7849     mapeters  Refactor to use TransactionTemplate.execute instead of
 *                                  Transactional annotations
 *
 * </pre>
 *
 * @author bphillip
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 */
public class RegistryDao extends RegistryObjectTypeDao<RegistryType> {

    private static final String QUERY_BY_BASE_URL = "FROM RegistryType reg where reg.baseURL=:baseURL";

<<<<<<< HEAD
    @Transactional(propagation = Propagation.MANDATORY, readOnly = true)
    public RegistryType getRegistryByBaseURL(String baseURL) {
        return this.uniqueResult(QUERY_BY_BASE_URL, "baseURL", baseURL);
=======
    public RegistryDao(IDaoConfigFactory daoConfigFactory) {
        super(daoConfigFactory);
    }

    public RegistryType getRegistryByBaseURL(String baseURL) {
        TransactionDefinition transactionDef = getTransactionDef(true);
        return supplyInTransaction(transactionDef, () -> {
            return this.uniqueResult(QUERY_BY_BASE_URL, "baseURL", baseURL);
        });
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    @Override
    protected Class<RegistryType> getEntityClass() {
        return RegistryType.class;
    }

}
