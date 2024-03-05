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
package com.raytheon.uf.common.dataplugin.satellite.units.counts;

<<<<<<< HEAD
import java.math.BigDecimal;
import java.math.MathContext;

=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import javax.measure.UnitConverter;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import si.uom.SI;
<<<<<<< HEAD
import tec.uom.se.AbstractConverter;
=======
import tech.units.indriya.function.AbstractConverter;

/**
 * 
 * 
 * <pre>
 * 
 * SOFTWARE HISTORY
 * 
 * Date         Ticket#    Engineer    Description
 * ------------ ---------- ----------- --------------------------
 * Aug 05, 2022     8905   lsingh       Updated units framework to 2.0.2.
 *                                      Renamed methods, and overrided additional methods.
 * 
 * </pre>
 * 
 */
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

public class DerivedTempToWVPixelConverter extends AbstractConverter {

    private static final long serialVersionUID = 1L;

    private static UnitConverter kelvinToCelsius = SI.KELVIN
            .getConverterTo(SI.CELSIUS);

<<<<<<< HEAD
    /*
     * (non-Javadoc)
     * 
     * @see tec.uom.se.AbstractConverter#convert(double)
     */
    @Override
    public double convert(double aTemp) {
        aTemp = kelvinToCelsius.convert(aTemp);
=======
    @Override
    public Number convertWhenNotIdentity(Number temp) {
        double aTemp = kelvinToCelsius.convert(temp.doubleValue());
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

        double result = 145 - aTemp;

        if (result < 0) {
            result = 0;
        } else if (result > 255) {
            result = 255;
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
        return (aConverter instanceof DerivedTempToWVPixelConverter);
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
        return new DerivedWVPixelToTempConverter();
    }

    /*
     * (non-Javadoc)
     * 
     * @see tec.uom.se.AbstractConverter#isLinear()
     */
=======
    @Override
    public AbstractConverter inverseWhenNotIdentity() {
        return new DerivedWVPixelToTempConverter();
    }

>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
    @Override
    public boolean isLinear() {
        return false;
    }

    @Override
<<<<<<< HEAD
    public BigDecimal convert(BigDecimal value, MathContext ctx)
            throws ArithmeticException {
        return BigDecimal.valueOf(convert(value.doubleValue()));
=======
    public boolean isIdentity() {
        return false;
    }

    @Override
    public int compareTo(UnitConverter o) {
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
