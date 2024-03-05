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

import com.raytheon.uf.common.dataplugin.grid.derivparam.data.SliceUtil;
import com.raytheon.uf.common.dataplugin.level.Level;
import com.raytheon.uf.common.datastorage.Request;
import com.raytheon.uf.common.datastorage.records.FloatDataRecord;
import com.raytheon.uf.common.gridcoverage.GridCoverage;
import com.raytheon.uf.common.inventory.data.AbstractRequestableData;
import com.raytheon.uf.common.inventory.exception.DataCubeException;
import com.raytheon.viz.radar.util.RadarAsGridUtil;

import si.uom.SI;
import javax.measure.MetricPrefix;

/**
 * Requestable Data that generates pressure at tilt heights.
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 *
 * Date          Ticket#  Engineer  Description
 * ------------- -------- --------- --------------------------------------------
 * Sep 08, 2021  8652     njensen   Initial creation
 *
 * </pre>
 *
 */
public class RcpRequestableData extends AbstractRequestableData {

    private String icao;

    public RcpRequestableData(String modelName, Level fhag,
            GridCoverage coverage) {
        this.source = modelName;
        this.icao = RadarAsGridUtil.getIcaoFromModelName(modelName);
        this.unit = MetricPrefix.HECTO(SI.PASCAL);
        this.parameter = RadarAsGridUtil.RCP;
        this.parameterName = "Radar Computed Pressure";
        this.level = fhag;
        this.space = coverage;
    }

    @Override
    public FloatDataRecord getDataValue(Object arg) throws DataCubeException {
        GridCoverage coverage = (GridCoverage) getSpace();
        double tilt = level.getLevelonevalue();
        FloatDataRecord fdr = TiltUtils.getInstance().getHgt2PresGrid(icao,
                coverage, tilt);
        if (fdr != null && arg instanceof Request) {
            return SliceUtil.slice(fdr, (Request) arg);
        } else {
            return fdr;
        }

    }

}
