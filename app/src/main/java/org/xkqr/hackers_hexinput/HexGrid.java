package org.xkqr.hackers_hexinput;

import java.util.Iterator;

public class HexGrid implements Iterable<HexCoordinate> {
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

    private int firstQ(int r) { return r/2; }
    private int lastQ(int r) { return _cols - 1 + (r+1)/2; };

    public Iterator<HexCoordinate> iterator() {
        return new Iterator<HexCoordinate>() {
            private int _r = 0;
            private int _q = firstQ(0);

            public boolean hasNext() {
                return _r < _rows && _q <= lastQ(_r);
            }

            public HexCoordinate next() {
                HexCoordinate p = new HexCoordinate(_q, _r);

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
