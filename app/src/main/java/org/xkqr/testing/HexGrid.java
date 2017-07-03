package org.xkqr.testing;

import android.graphics.Point;

import java.util.Iterator;

public class HexGrid implements Iterable<Point> {
    private int _cols;
    private int _rows;

    public HexGrid(int cols, int rows) {
        assert cols > 1;
        assert rows > 0;
        _cols = cols;
        _rows = rows;
    }

    public double width() {
        return Math.sqrt(3) * (_cols - _rows/2);
    }

    public double height() {
        return 3 * _rows/2;
    }

    public static double toX(double q, double r) {
        return Math.sqrt(3) * (q - r/2);
    }

    public static double toY(double q, double r) {
        return 3 * r/2;
    }

    public static double offsetX() {
        return Hexagon.width()/2;
    }
    
    public static double offsetY() {
        return Hexagon.height()/2;
    }


    private int firstQ(int r) { return (r+1)/2; }
    private int lastQ(int r) { return _cols - 1 + r/2; };

    public Iterator<Point> iterator() {
        return new Iterator<Point>() {
            private int _r = 0;
            private int _q = firstQ(0);

            public boolean hasNext() {
                return _r < _rows && _q <= lastQ(_r);
            }

            public Point next() {
                Point p = new Point(_q, _r);

                _q++;
                if (_q > lastQ(_r)) {
                    _r++;
                    _q = firstQ(_r);
                }

                return p;
            }
        };
    }
}
