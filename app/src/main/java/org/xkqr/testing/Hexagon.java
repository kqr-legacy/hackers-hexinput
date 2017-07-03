package org.xkqr.testing;

public class Hexagon {

    public static double width() {
        return Math.sqrt(3);
    }

    public static double height() {
        return 2;
    }

    public static double corner_x(int i) {
        return Math.cos(Math.PI/6 + Math.PI/3 * i);
    }

    public static double corner_y(int i) {
        return Math.sin(Math.PI/6 + Math.PI/3 * i);
    }

}
