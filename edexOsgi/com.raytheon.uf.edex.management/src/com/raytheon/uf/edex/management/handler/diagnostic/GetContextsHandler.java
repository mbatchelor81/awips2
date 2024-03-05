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
package com.raytheon.uf.edex.management.handler.diagnostic;

import com.raytheon.uf.common.management.request.diagnostic.GetContextsRequest;
import com.raytheon.uf.common.management.request.diagnostic.GetContextsRequest.ContextState;
import com.raytheon.uf.common.management.response.diagnostic.ContextsResponse;
import com.raytheon.uf.common.serialization.comm.IRequestHandler;
<<<<<<< HEAD
import com.raytheon.uf.edex.core.EDEXUtil;
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import com.raytheon.uf.edex.core.IContextAdmin;

/**
 * Returns the list of contexts
<<<<<<< HEAD
 * 
 * <pre>
 * 
 * SOFTWARE HISTORY
 * 
 * Date         Ticket#    Engineer    Description
 * ------------ ---------- ----------- --------------------------
 * Dec 7, 2010            njensen     Initial creation
 * 
 * </pre>
 * 
 * @author njensen
 * @version 1.0
 */

public class GetContextsHandler implements IRequestHandler<GetContextsRequest> {

    @Override
    public Object handleRequest(GetContextsRequest request) throws Exception {
        ContextsResponse result = new ContextsResponse();
        IContextAdmin admin = EDEXUtil.getContextAdmin();
=======
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 *
 * Date          Ticket#  Engineer  Description
 * ------------- -------- --------- ------------------------------------------
 * Dec 07, 2010           njensen   Initial creation
 * Apr 21, 2021  7849     mapeters  Add {@link IContextAdmin} constructor arg
 *
 * </pre>
 *
 * @author njensen
 */
public class GetContextsHandler implements IRequestHandler<GetContextsRequest> {

    private final IContextAdmin contextAdmin;

    public GetContextsHandler(IContextAdmin contextAdmin) {
        this.contextAdmin = contextAdmin;
    }

    @Override
    public Object handleRequest(GetContextsRequest request) throws Exception {
        ContextsResponse result = new ContextsResponse();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        ContextState state = request.getContextState();
        result.setContextState(state);
        if (state != null) {
            switch (request.getContextState()) {
            case ACTIVE:
<<<<<<< HEAD
                result.setContexts(admin.getActiveContexts());
                break;
            case INACTIVE:
                result.setContexts(admin.getInactiveContexts());
                break;
            default:
                result.setContexts(admin.getAllContexts());
                break;
            }
        } else {
            result.setContexts(admin.getAllContexts());
=======
                result.setContexts(contextAdmin.getActiveContexts());
                break;
            case INACTIVE:
                result.setContexts(contextAdmin.getInactiveContexts());
                break;
            default:
                result.setContexts(contextAdmin.getAllContexts());
                break;
            }
        } else {
            result.setContexts(contextAdmin.getAllContexts());
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        }

        return result;
    }

}
