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
package com.raytheon.viz.radar.util;

/**
 * Utilities for displaying radar as grid
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 *
 * Date         Ticket#    Engineer    Description
 * ------------ ---------- ----------- --------------------------
 * Sep 15, 2021 8652       njensen     Initial creation
 * Jun 24, 2022 8869       mapeters    Moved from com.raytheon.uf.viz.grid.radar,
 *                                     added more methods.
 *
 * </pre>
 *
 * @author njensen
 */

public class RadarAsGridUtil {

    public static final String RCP = "RCP";

    public static final String RADAR_MODEL_PREFIX = "radar-";

    /**
     * Extracts the radar icao from a model name field
     *
     * @param modelName
     * @return the radar icao
     */
    public static String getIcaoFromModelName(String modelName) {
        if (modelName.startsWith(RADAR_MODEL_PREFIX)) {
            return modelName.substring(RADAR_MODEL_PREFIX.length());
        }

        return null;
    }

    /**
     * Builds a model name for the given radar icao.
     *
     * @param icao
     * @return the radar model name
     */
    public static String getModelNameForIcao(String icao) {
        return RADAR_MODEL_PREFIX + icao;
    }

    /**
     * Determine if the given model name is for radar data.
     *
     * @param modelName
     * @return true if the model name is for radar, false otherwise
     */
    public static boolean isRadarModelName(String modelName) {
        return modelName.startsWith(RADAR_MODEL_PREFIX);
    }
}
