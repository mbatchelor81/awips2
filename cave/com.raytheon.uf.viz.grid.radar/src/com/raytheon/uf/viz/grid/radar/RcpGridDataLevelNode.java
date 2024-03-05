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
package com.raytheon.uf.viz.grid.radar;

import com.raytheon.uf.common.dataplugin.grid.derivparam.tree.StaticGridDataLevelNode;
import com.raytheon.uf.common.dataplugin.level.Level;
import com.raytheon.uf.common.gridcoverage.GridCoverage;
import com.raytheon.uf.common.inventory.data.AbstractRequestableData;
import com.raytheon.viz.radar.util.RadarAsGridUtil;

/**
 * A LevelNode for the pressure at the height of a radar tilt. The data will be
 * centered on a specific radar site.
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 *
 * Date          Ticket#  Engineer  Description
 * ------------- -------- --------- ----------------------------------------
 * Sep 08, 2021  8652     njensen   Initial creation
 *
 * </pre>
 *
 */
public class RcpGridDataLevelNode extends StaticGridDataLevelNode {

    public RcpGridDataLevelNode(String source, String dataType, Level level) {
        super(source, dataType, level);
    }

    @Override
    protected AbstractRequestableData createRequestableData(
            GridCoverage coverage) {
        if (RadarAsGridUtil.RCP.equals(dataType)) {
            return new RcpRequestableData(source, level, coverage);
        }
        return super.createRequestableData(coverage);
    }

    @Override
    public String toString() {
        return "RcpGridDataLevelNode [dataType=" + dataType + ", source="
                + source + ", level=" + level + "]";
    }

}
