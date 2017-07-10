package org.xkqr.hackers_hexinput;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class TestingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);
        TextView tv = (TextView) findViewById(R.id.textView);
        IMEView imev = (IMEView) findViewById(R.id.keyboardView);
        imev.setTv(tv);

        /*
        HexGrid hg = new HexGrid(2, 5);
        String str = "";
        for (HexCoordinate p : hg) {
            str += "q = " + p.q() + ", r = " + p.r() + "\n";
        }
        tv.setText(str);
        */
    }
}
