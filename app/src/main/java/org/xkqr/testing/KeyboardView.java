package org.xkqr.testing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.v4.content.ContextCompat;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

public class KeyboardView extends View {
    public KeyboardView(Context context) {
        super(context);
    }
    public KeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public KeyboardView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();

        int contentWidth = getWidth() - paddingLeft - paddingRight;
        int contentHeight = getHeight() - paddingTop - paddingBottom;

        Paint rect = new Paint();
        rect.setColor(ContextCompat.getColor(getContext(), R.color.colorAccent));

//        float sz = (float)Math.min(h / (2.0 * hexrs), w / Math.sqrt(3) / hexqs);

        HexGrid hg = new HexGrid(8,5);
        double scale = 50;

        // create pathshapes for the hexagons?
        for (Point p : hg) {
            int q = p.x;
            int r = p.y;
            double x = HexGrid.toX(q, r) + HexGrid.offsetX();
            double y = HexGrid.toY(q, r) + HexGrid.offsetY();
            float hexpts[] = new float[6*4];
            for (int i = 0; i < 6; i++) {
                hexpts[4*i+0] = (float) (scale*(x + Hexagon.corner_x(i)));
                hexpts[4*i+1] = (float) (scale*(y + Hexagon.corner_y(i)));
                hexpts[4*i+2] = (float) (scale*(x + Hexagon.corner_x(i+1)));
                hexpts[4*i+3] = (float) (scale*(y + Hexagon.corner_y(i+1)));
            }
            canvas.drawLines(hexpts, rect);
            canvas.drawText(r + "," + q, (float)(scale*x), (float)(scale*y), rect);

        }
    }

}
