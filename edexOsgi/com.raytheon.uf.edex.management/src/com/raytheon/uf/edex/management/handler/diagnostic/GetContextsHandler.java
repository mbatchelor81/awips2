/**
 * This software was developed and / or modified by Raytheon Company,
 * pursuant to Contract DG133W-05-CQ-1067 with the US Government.
 *
 * U.S. EXPORT CONTROLLED TECHNICAL DATA
 * This software product contains export-restricted data whose
 * export/transfer/disclosure is restricted by U.S. law. Dissemination
 * to non-U.S. persons whether in the United States or abroad requires
 * an export license or other authorization.
 *
 * Contractor Name:        Raytheon Company
 * Contractor Address:     6825 Pine Street, Suite 340
 *                         Mail Stop B8
 *                         Omaha, NE 68106
 *                         402.291.0100
 *
 * See the AWIPS II Master Rights File ("Master Rights File.pdf") for
 * further licensing information.
 **/
package com.raytheon.uf.edex.management.handler.diagnostic;

import com.raytheon.uf.common.management.request.diagnostic.GetContextsRequest;
import com.raytheon.uf.common.management.request.diagnostic.GetContextsRequest.ContextState;
import com.raytheon.uf.common.management.response.diagnostic.ContextsResponse;
import com.raytheon.uf.common.serialization.comm.IRequestHandler;
import com.raytheon.uf.edex.core.IContextAdmin;

/**
 * Returns the list of contexts
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
        ContextState state = request.getContextState();
        result.setContextState(state);
        if (state != null) {
            switch (request.getContextState()) {
            case ACTIVE:
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
        }

        return result;
    }

}
