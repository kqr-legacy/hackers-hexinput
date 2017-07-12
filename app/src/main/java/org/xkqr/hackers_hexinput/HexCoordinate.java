package org.xkqr.hackers_hexinput;

import java.util.Objects;


public /*@ pure @*/ class HexCoordinate {

    private final double _q;
    private final double _r;

    private static final double sqrt3 = 1.7321; // sqrt(3)
    private static final double inv3 = 0.3333; // 1/3.0

    public HexCoordinate(double q, double r) {
        _q = q;
        _r = r;
    }

    // Note on coordinates:
    // Cartesian coordinates count from the upper-left corner, while
    // hex coordinates count from the middle of the hexagon

    public static HexCoordinate fromCartesian(double x, double y) {
        x -= Hexagon.width*0.5;
        y -= Hexagon.height*0.5;
        double q = sqrt3*x*inv3 + y*inv3;
        double r = 2.0 * y*inv3;
        return new HexCoordinate(q, r);
    }

    public double x() {
        return Hexagon.width*0.5 + sqrt3 * (_q - _r*0.5);
    }

    public double y() {
        return Hexagon.height*0.5 + 3.0 * _r*0.5;
    }

    // First guess at discrete coordinates by simply rounding the continuous ones.
    // This may end up not being a valid hexagon, if q+r+s /= 0. However, this has
    // not proven to be a problem so far, so we'll roll with it for the time being.
    // More details at http://www.redblobgames.com/grids/hexagons/#rounding

    public int q() {
        // TODO: ensure this is within range and all that stuff. preferably as invariant
        return (int) Math.round(_q);
    }

    public int r() {
        return (int) Math.round(_r);
    }

    /*
    public boolean equals(Object other) {
        // Note that this is only for comparing discrete coordinates. Don't even bother
        // with floating point coordinates...
        if (this.getClass() != other.getClass()) return false;
        HexCoordinate coord = (HexCoordinate) other;
        return this.q() == coord.q() && this.r() == coord.r();
    }

    public int hashCode() {
        return Objects.hash(q(), r());
    }



*/

}
