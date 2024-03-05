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
package com.raytheon.uf.edex.registry.ebxml.init;

import com.raytheon.uf.edex.registry.ebxml.exception.EbxmlRegistryException;

/**
 * Interface that classes may implement to execute code that must be executed
 * after the database is initialzed. DbInit will load all classes implementing
 * this interface and will execute the executeAfterRegistryInit method.
<<<<<<< HEAD
 * 
 * <pre>
 * 
 * SOFTWARE HISTORY
 * 
 * Date         Ticket#    Engineer    Description
 * ------------ ---------- ----------- --------------------------
 * 3/13/2013    1082       bphillip    Initial creation
 * 
 * </pre>
 * 
 * @author bphillip
 * @version 1.0
=======
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 *
 * Date         Ticket#    Engineer    Description
 * ------------ ---------- ----------- --------------------------
 * 3/13/2013    1082       bphillip    Initial creation
 *
 * </pre>
 *
 * @author bphillip
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 * @see com.raytheon.uf.edex.registry.ebxml.dao.DbInit
 */
public interface RegistryInitializedListener {

    /**
     * Executes code that must be executed after the ebxml database is
<<<<<<< HEAD
     * initialized
     */
    public void executeAfterRegistryInit() throws EbxmlRegistryException;
=======
     * initialized. This method is called from within a non-admin transactional
     * context. If anything in this method requires an admin transaction, that
     * needs to be handled within this method.
     */
    void executeAfterRegistryInit() throws EbxmlRegistryException;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
}
