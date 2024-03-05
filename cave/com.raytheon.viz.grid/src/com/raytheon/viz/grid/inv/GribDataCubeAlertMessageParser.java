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
package com.raytheon.viz.grid.inv;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

<<<<<<< HEAD
import com.raytheon.uf.common.dataplugin.grid.derivparam.GridMapKey;
import com.raytheon.uf.common.dataplugin.grid.derivparam.cache.GridTimeCache;
=======
import com.raytheon.uf.common.dataplugin.PluginDataObject;
import com.raytheon.uf.common.dataplugin.grid.GridConstants;
import com.raytheon.uf.common.dataplugin.grid.derivparam.GridMapKey;
import com.raytheon.uf.common.dataplugin.grid.derivparam.cache.GridTimeCache;
import com.raytheon.uf.common.time.DataTime;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import com.raytheon.uf.viz.core.alerts.AlertMessage;
import com.raytheon.uf.viz.core.alerts.DataCubeAlertMessageParser;
import com.raytheon.uf.viz.core.exception.VizException;
import com.raytheon.uf.viz.core.rsc.AbstractRequestableResourceData;
<<<<<<< HEAD

/**
 * 
 * A class for parsing alerts which retrieves the data using the data cube,
 * which makes it work well for anything which may have derived parameters
 * 
 * <pre>
 * 
 * SOFTWARE HISTORY
 * Date         Ticket#    Engineer    Description
 * ------------ ---------- ----------- --------------------------
 * Nov 16, 2009            bsteffen     Initial creation
 * 
 * </pre>
 * 
 * @author bsteffen
 * @version 1.0
=======
import com.raytheon.viz.grid.rsc.GridResourceData;

/**
 *
 * A class for parsing alerts which retrieves the data using the data cube,
 * which makes it work well for anything which may have derived parameters
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 *
 * Date          Ticket#  Engineer  Description
 * ------------- -------- --------- --------------------------------------------
 * Nov 16, 2009           bsteffen  Initial creation
 * Jul 28, 2021  8611     randerso  Set level in DataTimes when resource data is
 *                                  spatial.
 * Oct 29, 2022  8959     mapeters  Update how data time levels are set
 *
 * </pre>
 *
 * @author bsteffen
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 */
@XmlAccessorType(XmlAccessType.NONE)
public class GribDataCubeAlertMessageParser extends DataCubeAlertMessageParser {

    public GribDataCubeAlertMessageParser() {

    }

    @Override
    public Object parseAlertMessage(AlertMessage message,
            AbstractRequestableResourceData reqResourceData)
            throws VizException {
<<<<<<< HEAD
        Map<String, Object> attribs = new HashMap<String, Object>(
                message.decodedAlert);
=======
        Map<String, Object> attribs = new HashMap<>(message.decodedAlert);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

        // remove cache'd entry from grib time cache
        GridMapKey mapKey = new GridMapKey(attribs);
        GridTimeCache.getInstance().clearTimes(mapKey);

<<<<<<< HEAD
=======
        if (reqResourceData instanceof GridResourceData) {
            GridResourceData gridResourceData = (GridResourceData) reqResourceData;
            if (gridResourceData.isSpatial()) {
                DataTime dataTime = (DataTime) attribs
                        .get(PluginDataObject.DATATIME_ID);
                dataTime.setLevel((Double) attribs.get(GridConstants.LEVEL_ONE),
                        (String) attribs.get(GridConstants.MASTER_LEVEL_NAME));
            }
        }

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        return super.parseAlertMessage(message, reqResourceData);
    }

}
