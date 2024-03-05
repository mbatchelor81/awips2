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
=======
import com.raytheon.uf.edex.database.dao.IDaoConfigFactory;

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.ExtrinsicObjectType;

/**
 * Data access object for retrieving ExtrinsicObject types
<<<<<<< HEAD
 * 
 * <pre>
 * 
 * SOFTWARE HISTORY
 * 
 * Date         Ticket#    Engineer    Description
 * ------------ ---------- ----------- --------------------------
 * 3/18/2013    1082       bphillip     Initial creation
 * 
 * </pre>
 * 
 * @author bphillip
 * @version 1.0
 */
public class ExtrinsicObjectDao extends
        RegistryObjectTypeDao<ExtrinsicObjectType> {

    public ExtrinsicObjectDao() {

=======
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 *
 * Date          Ticket#  Engineer  Description
 * ------------- -------- --------- --------------------------------------------
 * Mar 18, 2013  1082     bphillip  Initial creation
 * Apr 14, 2021  7849     mapeters  Add {@link IDaoConfigFactory} constructor arg
 *
 * </pre>
 *
 * @author bphillip
 */
public class ExtrinsicObjectDao
        extends RegistryObjectTypeDao<ExtrinsicObjectType> {

    public ExtrinsicObjectDao(IDaoConfigFactory daoConfigFactory) {
        super(daoConfigFactory);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    @Override
    protected Class<ExtrinsicObjectType> getEntityClass() {
        return ExtrinsicObjectType.class;
    }

}
