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
package com.raytheon.uf.viz.xy.crosssection.adapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
<<<<<<< HEAD
import java.util.Comparator;
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import java.util.Iterator;
import java.util.List;

import javax.measure.Unit;

import org.geotools.coverage.grid.GridGeometry2D;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

import com.raytheon.uf.common.dataplugin.PluginDataObject;
import com.raytheon.uf.common.geospatial.MapUtil;
import com.raytheon.uf.common.time.DataTime;
import com.raytheon.uf.viz.core.exception.VizException;
import com.raytheon.uf.viz.xy.crosssection.display.CrossSectionDescriptor;
import com.raytheon.uf.viz.xy.crosssection.graph.CrossSectionGraph;
import com.raytheon.uf.viz.xy.crosssection.rsc.CrossSectionResourceData;
import com.raytheon.viz.core.graphing.xy.XYData;

/**
 * TODO Add Description
<<<<<<< HEAD
 * 
 * <pre>
 * 
 * SOFTWARE HISTORY
 * Date         Ticket#    Engineer    Description
 * ------------ ---------- ----------- --------------------------
 * Nov 23, 2009            mschenke     Initial creation
 * 
 * </pre>
 * 
 * @author mschenke
 * @version 1.0
 */

=======
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 * Date         Ticket#    Engineer    Description
 * ------------ ---------- ----------- --------------------------
 * Nov 23, 2009            mschenke    Initial creation
 * Dec 20, 2023 2036519    mapeters    Add dispose()
 *
 * </pre>
 *
 * @author mschenke
 */
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
public abstract class AbstractCrossSectionAdapter<T extends PluginDataObject>
        implements Serializable {

    private static final long serialVersionUID = 1L;

    protected CrossSectionResourceData resourceData;

    protected CrossSectionDescriptor descriptor;

<<<<<<< HEAD
    protected List<T> records = new ArrayList<T>();
=======
    protected List<T> records = new ArrayList<>();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

    /**
     * @param resourceData
     *            the resourceData to set
     */
    public void setResourceData(CrossSectionResourceData resourceData) {
        this.resourceData = resourceData;
    }

    /**
     * @param descriptor
     *            the descriptor to set
     */
    public void setDescriptor(CrossSectionDescriptor descriptor) {
        this.descriptor = descriptor;
    }

    public abstract List<float[]> loadData(DataTime currentTime,
            CrossSectionGraph graph, GridGeometry2D geometry)
            throws VizException;

    public abstract Unit<?> getUnit();

    public abstract String getParameterName();

    @SuppressWarnings("unchecked")
    public void addRecord(PluginDataObject pdo) {
        synchronized (records) {
            records.add((T) pdo);
        }
    }

    public void remove(DataTime time) {
        Iterator<T> itr = records.iterator();
        while (itr.hasNext()) {
            if (itr.next().getDataTime().equals(time)) {
                itr.remove();
            }
        }
    }

    public void sortData(List<XYData> data) {
<<<<<<< HEAD
        Collections.sort(data, new Comparator<XYData>() {

            @Override
            public int compare(XYData o1, XYData o2) {
                return Float.compare((Float) o1.getY(), (Float) o2.getY());
            }

        });
=======
        Collections.sort(data, (o1, o2) -> Float.compare((Float) o1.getY(),
                (Float) o2.getY()));
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

    public CoordinateReferenceSystem getDataCoordinateReferenceSystem() {
        return MapUtil.LATLON_PROJECTION;
    }

<<<<<<< HEAD
=======
    public void dispose() {
        records.clear();
    }
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
}
