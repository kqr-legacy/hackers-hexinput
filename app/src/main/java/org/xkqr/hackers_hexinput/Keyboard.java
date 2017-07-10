package org.xkqr.hackers_hexinput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Keyboard {
    private HexGrid _grid;
    private Map<HexCoordinate, List<String>> _keys;

    public Keyboard() {
        _grid = new HexGrid(7, 6);
        _keys = new HashMap<>();

        String[] layout = "A\nB\nC\nD\nE\nF\nG\nH\nI\nJ\nK\nL\nM\nN\nO\nP\nQ\nR\nS\nT\nU\nV\nX\nY\nZ".split("\n");

        int i = 0;
        for (HexCoordinate coordinate :_grid) {
            _keys.put(coordinate, new ArrayList<String>());
            _keys.get(coordinate).add(i < layout.length ? layout[i++] : " ");
        }
    }

    public HexGrid grid() {
        return _grid;
    }

    public String primary(HexCoordinate coordinate) {
        if (_keys.get(coordinate) == null || _keys.get(coordinate).isEmpty()) {
            return " ";
        } else {
            return _keys.get(coordinate).get(0);
        }
    }
}
