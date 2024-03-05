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
package com.raytheon.uf.common.dataplugin.radar.request;

import com.raytheon.uf.common.serialization.annotations.DynamicSerialize;
import com.raytheon.uf.common.serialization.annotations.DynamicSerializeElement;
import com.raytheon.uf.common.serialization.comm.IServerRequest;

/**
 * Request for the DataTree associated with the given rda_id
<<<<<<< HEAD
 * 
 * <pre>
 * 
 * SOFTWARE HISTORY
 * Date         Ticket#    Engineer    Description
 * ------------ ---------- ----------- --------------------------
 * Mar 26, 2010 #4473      rjpeter     Initial creation
 * 
 * </pre>
 * 
 * @author rjpeter
 * @version 1.0
=======
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 *
 * Date          Ticket#  Engineer  Description
 * ------------- -------- --------- --------------------------------------------
 * Mar 26, 2010  4473     rjpeter   Initial creation
 * Jul 07, 2021  8576     randerso  Added siteId field to request data for all
 *                                  local radars defined in radarsInUse.txt
 *
 * </pre>
 *
 * @author rjpeter
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 */
@DynamicSerialize
public class GetRadarDataTreeRequest implements IServerRequest {

    @DynamicSerializeElement
    private String rdaId;

<<<<<<< HEAD
=======
    @DynamicSerializeElement
    private String siteId;

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    public String getRdaId() {
        return rdaId;
    }

    /**
     * Sets the rdaId to retrieve the data tree for. If null will return a
<<<<<<< HEAD
     * DataTree for all Radar data currently stored.
     * 
=======
     * DataTree for all Local Radars configured in radarsInUse.txt for the
     * specified site ID.
     *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
     * @param rdaId
     */
    public void setRdaId(String rdaId) {
        this.rdaId = rdaId;
    }

<<<<<<< HEAD
=======
    public String getSiteId() {
        return siteId;
    }

    /**
     * Sets the site ID. If rdaId is null will return a DataTree for all Local
     * Radars configured in radarsInUse.txt for the specified site ID.
     *
     * @param siteId
     */
    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
}
