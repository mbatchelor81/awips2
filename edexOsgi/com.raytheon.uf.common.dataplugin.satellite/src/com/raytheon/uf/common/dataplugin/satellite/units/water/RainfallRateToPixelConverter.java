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

package com.raytheon.uf.common.dataplugin.satellite.units.water;

<<<<<<< HEAD
import java.math.BigDecimal;
import java.math.MathContext;

=======
import javax.measure.MetricPrefix;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import javax.measure.UnitConverter;
import javax.measure.quantity.Speed;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import si.uom.SI;
<<<<<<< HEAD
import tec.uom.se.AbstractConverter;
import tec.uom.se.unit.MetricPrefix;
import tec.uom.se.unit.ProductUnit;
import tec.uom.se.unit.Units;
=======
import tech.units.indriya.function.AbstractConverter;
import tech.units.indriya.unit.ProductUnit;
import tech.units.indriya.unit.Units;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

/**
 * Converts a rainfall rate of mm/hr to a pixel value
 * 
 * <pre>
 * SOFTWARE HISTORY
 * Date         Ticket#    Engineer    Description
 * ------------ ---------- ----------- --------------------------
 * Aug 30, 2007                 njensen     Initial creation
 * Mar 25, 2009     2086        jsanchez    Added UnitConverter.
 * Apr 15, 2019     7596        lsingh      Updated units framework to JSR-363.
 *                                          Overrided additional methods
<<<<<<< HEAD
=======
 * Aug 05, 2022     8905        lsingh      Updated units framework to 2.0.2.
 *                                          Renamed methods, and overrided additional methods.
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 * 
 * </pre>
 * 
 * @author njensen
 */
public class RainfallRateToPixelConverter extends AbstractConverter {

    private static final long serialVersionUID = 1L;

    private static UnitConverter mtrPerSecToMilimtrPerHr = 
            new ProductUnit<Speed>((SI.METRE).divide(SI.SECOND))
                    .getConverterTo(new ProductUnit<Speed>((MetricPrefix.MILLI(SI.METRE)).divide(Units.HOUR)) );

<<<<<<< HEAD
    /*
     * (non-Javadoc)
     * 
     * @see tec.uom.se.AbstractConverter#convert(double)
     */
    @Override
    public double convert(double aRate) {
        double result = 0.0;
=======
    @Override
    public Number convertWhenNotIdentity(Number rate) {
        double result = 0.0;
        double aRate = rate.doubleValue();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

        aRate = mtrPerSecToMilimtrPerHr.convert(aRate);
        if (aRate == 0) {
            result = 0.0;
        } else if (aRate <= 6.0) {
            result = (aRate * 25.0 / 6.0) + 108.0;
        } else if (aRate <= 20.0) {
            result = 133.0 + (35.0 / 14.0 * (aRate - 6.0));
        } else {
            result = 2.0 * (aRate + 64.0);
        }

        if (result < 0) {
            result = 0.0;
        } else if (result > 255) {
            result = 255.0;
        }

        return result;
    }

<<<<<<< HEAD
    /*
     * (non-Javadoc)
     * 
     * @see tec.uom.se.AbstractConverter#equals(java.lang.Object)
     */
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    @Override
    public boolean equals(Object aConverter) {
        return (aConverter instanceof RainfallRateToPixelConverter);
    }

<<<<<<< HEAD
    /*
     * (non-Javadoc)
     * 
     * @see tec.uom.se.AbstractConverter#hashCode()
     */
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

<<<<<<< HEAD
    /*
     * (non-Javadoc)
     * 
     * @see tec.uom.se.AbstractConverter#inverse()
     */
    @Override
    public AbstractConverter inverse() {
        return new RainfallPixelToRateConverter();
    }

    /*
     * (non-Javadoc)
     * 
     * @see tec.uom.se.AbstractConverter#isLinear()
     */
=======
    @Override
    public AbstractConverter inverseWhenNotIdentity() {
        return new RainfallPixelToRateConverter();
    }

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    @Override
    public boolean isLinear() {
        return false;
    }
<<<<<<< HEAD
    
    @Override
    public BigDecimal convert(BigDecimal value, MathContext ctx)
            throws ArithmeticException {
        return BigDecimal.valueOf(convert(value.doubleValue()));
=======

    @Override
    public boolean isIdentity() {
        return false;
    }

    @Override
    public int compareTo(UnitConverter arg0) {
     // This method hasn't been implemented yet since it's unused
        return 0;
    }

    @Override
    protected String transformationLiteral() {
     // This method hasn't been implemented yet since it's unused
        return null;
    }

    @Override
    protected boolean canReduceWith(AbstractConverter that) {
     // This method hasn't been implemented yet since it's unused
        return false;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    }

}
