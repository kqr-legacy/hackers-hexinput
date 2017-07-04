package org.xkqr.testing;

public class Hexagon {

    public static double width() {
        return Math.sqrt(3);
    }

    public static double height() {
        return 2;
    }

    public static HexCoordinate corner(int i) {
        return HexCoordinate.fromCartesian(
                Math.cos(Math.PI/6 + Math.PI/3 * i),
                Math.sin(Math.PI/6 + Math.PI/3 * i)
        );
    }
}
