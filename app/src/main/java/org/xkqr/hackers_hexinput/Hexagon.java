package org.xkqr.hackers_hexinput;

public /*@ pure @*/ class Hexagon {

    public static final double width = Math.sqrt(3);
    public static final double height = 2;
/*
    //@ requires 0 <= i && i < 6;
    public static HexCoordinate corner(int i) {
        double firstCorner = Math.PI/6;
        //@ assert Arithmetic.isNumber(firstCorner);
        double rotation = Math.PI/3 * i;
        //@ assert Math.PI/3 > 0 && Math.PI/3 < 10;
        //@ assert Math.PI/3 > 0 && Math.PI/3 < 10 && 0 <= i && i < 6;
        //@ assert Math.PI/3 > 0 && Math.PI/3 < 10 && 0 <= i && i < 6 && 0 <= rotation && rotation < 60;
        //@ assert Arithmetic.isNumber(rotation);
        double angle = firstCorner + rotation;
        //@ assert Arithmetic.isNumber(angle);
        return HexCoordinate.fromCartesian(
                Math.cos(angle),
                Math.sin(angle)
        );
    }
    */
}
