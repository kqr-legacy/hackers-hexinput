package org.xkqr.testing;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.widget.TextView;

public class TestingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);
        TextView tv = (TextView)findViewById(R.id.textView);
        HexGrid hg = new HexGrid(2, 5);
        String str = "";
        for (Point p : hg) {
            str += "q = " + p.x + ", r = " + p.y + "\n";
        }
        tv.setText(str);
    }
}
