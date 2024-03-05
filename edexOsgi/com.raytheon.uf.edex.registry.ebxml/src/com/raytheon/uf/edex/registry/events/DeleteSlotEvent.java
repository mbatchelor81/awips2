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
package com.raytheon.uf.edex.registry.events;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
import oasis.names.tc.ebxml.regrep.xsd.rim.v4.SlotType;

import com.raytheon.uf.common.event.Event;
import com.raytheon.uf.common.util.CollectionUtil;

=======
import com.raytheon.uf.common.event.Event;
import com.raytheon.uf.common.util.CollectionUtil;

import oasis.names.tc.ebxml.regrep.xsd.rim.v4.SlotType;

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
/**
 * Event containing slots to be deleted by the registry garbage collector
 * 
 * <pre>
 * 
 * SOFTWARE HISTORY
 * 
 * Date         Ticket#     Engineer    Description
 * ------------ ----------  ----------- --------------------------
<<<<<<< HEAD
 * 4/11/2014    3011         bphillip    Initial Coding
 * 4/17/2014    3011        bphillip    Delete slot events now contain strings
 * </pre>
 * 
 * @author bphillip
 * @version 1
=======
 * 4/11/2014    3011        bphillip    Initial Coding
 * 4/17/2014    3011        bphillip    Delete slot events now contain strings
 * 5/11/2020    8161        bsteffen    Change slot id to a long
 * 
 * </pre>
 * 
 * @author bphillip
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 */
public class DeleteSlotEvent extends Event {

    private static final long serialVersionUID = -2818002679753482984L;

<<<<<<< HEAD
    private List<String> slotsToDelete;;
=======
    private List<Long> slotsToDelete;;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    public DeleteSlotEvent() {
        super();
    }

    public DeleteSlotEvent(List<SlotType> slotsToDelete) {
        if (CollectionUtil.isNullOrEmpty(slotsToDelete)) {
<<<<<<< HEAD
            slotsToDelete = new ArrayList<SlotType>();
        } else {
            this.slotsToDelete = new ArrayList<String>(slotsToDelete.size());
=======
            slotsToDelete = new ArrayList<>();
        } else {
            this.slotsToDelete = new ArrayList<>(slotsToDelete.size());
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            for (SlotType slot : slotsToDelete) {
                this.slotsToDelete.add(slot.getId());
            }
        }
    }

<<<<<<< HEAD
    public List<String> getSlotsToDelete() {
        return slotsToDelete;
    }

    public void setSlotsToDelete(List<String> slotsToDelete) {
=======
    public List<Long> getSlotsToDelete() {
        return slotsToDelete;
    }

    public void setSlotsToDelete(List<Long> slotsToDelete) {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        this.slotsToDelete = slotsToDelete;
    }

}
