package EffectiveJava;

import java.util.DoubleSummaryStatistics;

/**
 * Created by rarshion on 16/11/7.
 */
public final class Complex {
    private final double re;
    private final double im;

    public Complex(double re, double im) {
        this.re =re;
        this.im = im;
    }

    public double realPart() {return re;}
    public double imaginaryPart() {return im;}

    public Complex add(Complex c) {
        return new Complex(re + c.re, im + c.im);
    }

    public Complex subtract(Complex c) {
        return new Complex(re - c.re, im - c.im);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Complex)) {
            return false;
        }
        Complex c = (Complex) o;
        return Double.compare(re, c.re) == 0 &&
                Double.compare(im, c.im) == 0;
    }
}
