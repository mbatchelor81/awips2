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
package com.raytheon.uf.edex.management.handler;

import com.raytheon.uf.common.management.request.ChangeContextRequest;
import com.raytheon.uf.common.serialization.comm.IRequestHandler;
<<<<<<< HEAD
import com.raytheon.uf.edex.core.EDEXUtil;
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import com.raytheon.uf.edex.core.IContextAdmin;

/**
 * Adjust a context as requested
<<<<<<< HEAD
 * 
 * <pre>
 * 
 * SOFTWARE HISTORY
 * 
 * Date         Ticket#    Engineer    Description
 * ------------ ---------- ----------- --------------------------
 * Dec 8, 2010            njensen     Initial creation
 * 
 * </pre>
 * 
 * @author njensen
 * @version 1.0
 */

public class ChangeContextHandler implements
        IRequestHandler<ChangeContextRequest> {

    @Override
    public Object handleRequest(ChangeContextRequest request) throws Exception {
        IContextAdmin admin = EDEXUtil.getContextAdmin();
        String name = request.getContextName();
        switch (request.getAction()) {
        case RESTART:
            admin.stopContext(name);
            admin.startContext(name);
            break;
        case START:
            admin.startContext(name);
            break;
        case STOP:
            admin.stopContext(name);
            break;
        }

        return null; // TODO
    }

=======
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 *
 * Date          Ticket#  Engineer  Description
 * ------------- -------- --------- -----------------
 * Dec 08, 2010           njensen   Initial creation
 * Apr 21, 2021  7849     mapeters  Add {@link IContextAdmin} constructor arg
 *
 * </pre>
 *
 * @author njensen
 */
public class ChangeContextHandler
        implements IRequestHandler<ChangeContextRequest> {

    private final IContextAdmin contextAdmin;

    public ChangeContextHandler(IContextAdmin contextAdmin) {
        this.contextAdmin = contextAdmin;
    }

    @Override
    public Object handleRequest(ChangeContextRequest request) throws Exception {
        String name = request.getContextName();
        switch (request.getAction()) {
        case RESTART:
            contextAdmin.stopContext(name);
            contextAdmin.startContext(name);
            break;
        case START:
            contextAdmin.startContext(name);
            break;
        case STOP:
            contextAdmin.stopContext(name);
            break;
        }

        return null;
    }
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
}
