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

package com.raytheon.uf.common.dataplugin.satellite.units.ir;

<<<<<<< HEAD
import java.math.BigDecimal;
import java.math.MathContext;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import tec.uom.se.AbstractConverter;
=======
import javax.measure.UnitConverter;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import tech.units.indriya.function.AbstractConverter;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

/**
 * Converts a temperature value in Kelvin to a pixel value.
 * 
 * <pre>
 * SOFTWARE HISTORY
 * Date          Ticket#  Engineer    Description
 * ------------- -------- ----------- --------------------------
 * Aug 29, 2007           njensen     Initial creation
 * Nov 20, 2013  2492     bsteffen    Make conversion unbounded.
<<<<<<< HEAD
 * Apr 15, 2019   7596    lsingh      Updated units framework to JSR-363.
 *                                    Overrided additional methods
=======
 * Apr 15, 2019  7596     lsingh      Updated units framework to JSR-363.
 *                                    Overrided additional methods
 * Aug 05, 2022  8905     lsingh      Updated units framework to 2.0.2.
 *                                    Renamed methods, and overrided additional methods.
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
 * 
 * </pre>
 * 
 * @author njensen
 */
public class IRTempToPixelConverter extends AbstractConverter {

    private static final long serialVersionUID = 1L;

    @Override
<<<<<<< HEAD
    public double convert(double aTemperature) {
        double result = 0.0;
=======
    public Number convertWhenNotIdentity(Number temperature) {
        double result = 0.0;
        double aTemperature = temperature.doubleValue();
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11

        if (aTemperature < 238.15) {
            result = 418.15 - aTemperature;
        } else {
            result = 656.3 - (2.0 * aTemperature);
        }

        return result;
    }

    @Override
    public boolean equals(Object aConverter) {
        return (aConverter instanceof IRTempToPixelConverter);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
<<<<<<< HEAD
    public AbstractConverter inverse() {
=======
    public AbstractConverter inverseWhenNotIdentity() {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        return new IRPixelToTempConverter();
    }

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
