package com.raytheon.uf.common.dataplugin.radar.units;

<<<<<<< HEAD
import java.math.BigDecimal;
import java.math.MathContext;
=======
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
import java.util.Map;

import javax.measure.Dimension;
import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.UnitConverter;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import si.uom.SI;
<<<<<<< HEAD
import tec.uom.se.AbstractConverter;
import tec.uom.se.AbstractUnit;
import tec.uom.se.unit.ProductUnit;

=======
import tech.units.indriya.AbstractUnit;
import tech.units.indriya.function.AbstractConverter;
import tech.units.indriya.unit.ProductUnit;

/**
 * 
 * Unit and converters used to process VIL units from a radar record
 * <pre>
 * 
 * SOFTWARE HISTORY
 * Date         Ticket#    Engineer    Description
 * ------------ ---------- ----------- --------------------------
 * Aug 16, 2022   8905       lsingh     Renamed methods, and overrided new required methods
 *                                      as part of the javax.measure 2.0.2 upgrade
 * 
 * </pre>
 * 
 */
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
public class DigitalVilUnit<Q extends Quantity<Q>> extends AbstractUnit<Q> {

    private static final long serialVersionUID = 1L;

    private final float linearScale;

    private final float linearOffset;

    private final short logStart;

    private final float logScale;

    private final float logOffset;

    public DigitalVilUnit(short[] thresholds) {
        linearScale = vilShortToFloat(thresholds[0]);
        linearOffset = vilShortToFloat(thresholds[1]);
        logStart = thresholds[2];
        logScale = vilShortToFloat(thresholds[3]);
        logOffset = vilShortToFloat(thresholds[4]);
    }

    @Override
    public Unit<Q> toSystemUnit() {
        return new ProductUnit<Q>(SI.KILOGRAM.divide(SI.SQUARE_METRE));
    }

    @Override
    public UnitConverter getSystemConverter() {
        return new VilToStdConverter(this);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Float.floatToIntBits(linearOffset);
        result = prime * result + Float.floatToIntBits(linearScale);
        result = prime * result + Float.floatToIntBits(logOffset);
        result = prime * result + Float.floatToIntBits(logScale);
        result = prime * result + logStart;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
<<<<<<< HEAD
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DigitalVilUnit<Q> other = (DigitalVilUnit<Q>) obj;
        if (Float.floatToIntBits(linearOffset) != Float
                .floatToIntBits(other.linearOffset))
            return false;
        if (Float.floatToIntBits(linearScale) != Float
                .floatToIntBits(other.linearScale))
            return false;
        if (Float.floatToIntBits(logOffset) != Float
                .floatToIntBits(other.logOffset))
            return false;
        if (Float.floatToIntBits(logScale) != Float
                .floatToIntBits(other.logScale))
            return false;
        if (logStart != other.logStart)
            return false;
=======
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        }

        DigitalVilUnit<Q> other = (DigitalVilUnit<Q>) obj;

        if (Float.floatToIntBits(linearOffset) != Float
                .floatToIntBits(other.linearOffset)) {
            return false;
        } else if (Float.floatToIntBits(linearScale) != Float
                .floatToIntBits(other.linearScale)) {
            return false;
        } else if (Float.floatToIntBits(logOffset) != Float
                .floatToIntBits(other.logOffset)) {
            return false;
        } else if (Float.floatToIntBits(logScale) != Float
                .floatToIntBits(other.logScale)) {
            return false;
        } else if (logStart != other.logStart) {
            return false;
        }
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
        return true;
    }

    public static float vilShortToFloat(short x) {
        int s = (x >> 15) & 0x1;
        int e = (x >> 10) & 0x1f;
        int f = x & 0x3ff;

        float value;
        if (e == 0) {
            value = (float) (Math.pow(-1, s) * 2 * (f / Math.pow(2, 10)));
        } else {
            value = (float) ((Math.pow(-1, s) * Math.pow(2, e - 16) * (1 + f
                    / Math.pow(2, 10))));
        }
        return value;
    }
    
    @Override
    public Map<? extends Unit<?>, Integer> getBaseUnits() {
        return this.toSystemUnit().getBaseUnits();
    }

    @Override
    public Dimension getDimension() {
        return this.getSystemUnit().getDimension();
    }

    private static class VilToStdConverter<Q extends Quantity<Q>> extends AbstractConverter {

        private static final long serialVersionUID = 1L;

        private final DigitalVilUnit<Q> vilUnit;

        public VilToStdConverter(DigitalVilUnit<Q> vilUnit) {
            this.vilUnit = vilUnit;
        }

        @Override
<<<<<<< HEAD
        public AbstractConverter inverse() {
=======
        public AbstractConverter inverseWhenNotIdentity() {
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            return new StdToVilConverter<Q>(vilUnit);
        }

        @Override
<<<<<<< HEAD
        public double convert(double x) {
            if (x < vilUnit.logStart) {
                return (x - vilUnit.linearOffset) / vilUnit.linearScale;
            } else {
                return Math.exp((x - vilUnit.logOffset) / vilUnit.logScale);
=======
        public Number convertWhenNotIdentity(Number x) {
            if (x.doubleValue() < vilUnit.logStart) {
                return (x.doubleValue() - vilUnit.linearOffset) / vilUnit.linearScale;
            } else {
                return Math.exp((x.doubleValue() - vilUnit.logOffset) / vilUnit.logScale);
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
            }
        }

        @Override
        public boolean isLinear() {
            return false;
        }

        @Override
        public boolean equals(Object cvtr) {
<<<<<<< HEAD
            if (cvtr != null && cvtr instanceof StdToVilConverter
                    && ((StdToVilConverter<?>) cvtr).vilUnit.getSystemUnit()
=======
            if (cvtr != null && cvtr instanceof VilToStdConverter
                    && ((VilToStdConverter<?>) cvtr).vilUnit.getSystemUnit()
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                            .equals(this.vilUnit.getSystemUnit())) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            return HashCodeBuilder.reflectionHashCode(this);
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

    private static class StdToVilConverter<Q extends Quantity<Q>> extends AbstractConverter {

        private static final long serialVersionUID = 1L;

        private final DigitalVilUnit<Q> vilUnit;

        public StdToVilConverter(DigitalVilUnit<Q> vilUnit) {
            this.vilUnit = vilUnit;
        }

        @Override
<<<<<<< HEAD
        public AbstractConverter inverse() {
            return new VilToStdConverter(vilUnit);
        }

        @Override
        public double convert(double x) {
            if (x < inverse().convert(vilUnit.logStart)) {
                return Math.round(x * vilUnit.linearScale
                        + vilUnit.linearOffset);
            } else {
                return Math.round(vilUnit.logScale * Math.log(x)
=======
        public AbstractConverter inverseWhenNotIdentity() {
            return new VilToStdConverter<Q>(vilUnit);
        }

        @Override
        public Number convertWhenNotIdentity(Number x) {
            if (x.doubleValue() < inverse().convert(vilUnit.logStart)) {
                return Math.round(x.doubleValue() * vilUnit.linearScale
                        + vilUnit.linearOffset);
            } else {
                return Math.round(vilUnit.logScale * Math.log(x.doubleValue())
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
                        + vilUnit.logOffset);
            }
        }

        @Override
        public boolean isLinear() {
            return false;
        }


        @Override
        public boolean equals(Object cvtr) {
            if (cvtr != null && cvtr instanceof StdToVilConverter
                    && ((StdToVilConverter<?>) cvtr).vilUnit.getSystemUnit()
                            .equals(this.vilUnit.getSystemUnit())) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            return HashCodeBuilder.reflectionHashCode(this);
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
}
