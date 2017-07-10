package org.xkqr.hackers_hexinput;

public class Hexagon {

    public static final double width = Math.sqrt(3);
    public static final double height = 2;

    //@ requires 0 <= i && i < 6;
    public static HexCoordinate corner(int i) {
        return HexCoordinate.fromCartesian(
                Math.cos(Math.PI/6 + Math.PI/3 * i),
                Math.sin(Math.PI/6 + Math.PI/3 * i)
        );
    }
}
