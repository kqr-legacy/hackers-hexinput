package org.xkqr.testing;

import java.util.Objects;

public class HexCoordinate {
    // Note on coordinates:
    // Cartesian coordinates count from the upper-left corner, while
    // hex coordinates count from the middle of the hexagon
    private double _q;
    private double _r;

    public HexCoordinate(double q, double r) {
        _q = q;
        _r = r;
    }
    public static HexCoordinate fromCartesian(double x, double y) {
        // See note on coordinates
        x -= Hexagon.width()/2;
        y -= Hexagon.height()/2;
        return new HexCoordinate((Math.sqrt(3)*x + y)/3, 2 * y/3);
    }

    public double qf() {
        return _q;
    }
    public double rf() {
        return _r;
    }
    public double x() {
        return Hexagon.width()/2 + Math.sqrt(3) * (_q - _r/2); // See note on coordinates
    }
    public double y() {
        return Hexagon.height()/2 + 3 * _r/2; // See note on coordinates
    }
    public int q() {
        return (int) Math.round(discrete().qf());
    }
    public int r() {
        return (int) Math.round(discrete().rf());
    }

    private HexCoordinate discrete() {
        // First guess at discrete coordinates by simply rounding the continuous ones.
        // This may end up not being a valid hexagon, if q+r+s /= 0. However, this has
        // not proven to be a problem so far, so we'll roll with it for the time being.
        // More details at http://www.redblobgames.com/grids/hexagons/#rounding
        return new HexCoordinate(Math.round(_q), Math.round(_r));
    }

    @Override
    public boolean equals(Object other) {
        // Note that this is only for comparing discrete coordinates. Don't even bother
        // with floating point coordinates...
        if (this.getClass() != other.getClass()) return false;
        HexCoordinate coord = (HexCoordinate) other;
        return this.q() == coord.q() && this.r() == coord.r();
    }

    @Override
    public int hashCode() {
        return Objects.hash(q(), r());
    }
}
