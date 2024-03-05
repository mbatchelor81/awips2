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
package com.raytheon.viz.radar.textcontributors;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;

import com.raytheon.uf.common.dataplugin.radar.RadarRecord;

/**
<<<<<<< HEAD
 * 
 * Join several Text contribution on a single line
 * 
 * <pre>
 * 
 * SOFTWARE HISTORY
 * 
=======
 *
 * Join several Text contribution on a single line
 *
 * <pre>
 *
 * SOFTWARE HISTORY
 *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 * Date          Ticket#  Engineer  Description
 * ------------- -------- --------- -----------------
 * Sep 07, 2010           bsteffen  Initial creation
 * Jun 04, 2018  6725     bsteffen  Add DUA Duration
<<<<<<< HEAD
 * 
 * </pre>
 * 
=======
 * Jun 16, 2021  22695    jdynina   ADD VAD Height
 *
 * </pre>
 *
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 * @author bsteffen
 */
public class JoinTextContributor implements IRadarTextContributor {

    @XmlElements({ @XmlElement(name = "vcp", type = VCPTextContributor.class),
            @XmlElement(name = "resolution", type = ResolutionTextContributor.class),
            @XmlElement(name = "elevation", type = ElevationTextContributor.class),
            @XmlElement(name = "layer", type = LayerTextContributor.class),
            @XmlElement(name = "join", type = JoinTextContributor.class),
            @XmlElement(name = "nullPrecip", type = NullPrecipTextContributor.class),
            @XmlElement(name = "blank", type = BlankTextContributor.class),
            @XmlElement(name = "productDependent", type = ProdDepTextContributor.class),
            @XmlElement(name = "productDependentDate", type = ProdDepDateTextContributor.class),
            @XmlElement(name = "productDependentUSPMax", type = USPMaxTextContributor.class),
            @XmlElement(name = "productDependentDVLMax", type = DigitalVilMaxTextContributor.class),
            @XmlElement(name = "productDependentDUADuration", type = DUADurationTextContributor.class),
<<<<<<< HEAD
=======
            @XmlElement(name = "productDependentVADHeight", type = VADHeightTextContributor.class),
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            @XmlElement(name = "srmMovement", type = SrmMovementTextContributor.class),
            @XmlElement(name = "srmSource", type = SrmSourceTextContributor.class) })
    protected List<IRadarTextContributor> lines = new ArrayList<>();

    @Override
    public String contributeText(RadarRecord record) {
        StringBuilder result = new StringBuilder();
        for (IRadarTextContributor line : lines) {
            result.append(line.contributeText(record));
        }
        return result.toString();
    }
}