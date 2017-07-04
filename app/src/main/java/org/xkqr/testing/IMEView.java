package org.xkqr.testing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class IMEView extends View {
    double _scale = 200;
    HexGrid _grid = new HexGrid(5, 3);
    ArrayList<HexCoordinate> _lastPressed = null;

    public IMEView(Context context) {
        super(context);
    }
    public IMEView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public IMEView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    TextView tv; // TODO: remove this + its import later
    public void setTv(TextView tv) {
        this.tv = tv;
    }

    private void registerTouches(MotionEvent event) {
        if (_lastPressed == null) {
            _lastPressed = new ArrayList<>();
        }

        for (int h = 0; h < event.getHistorySize(); h++) {
            // TODO: Something here may be broken as well. I get the wrong coordinates...
            HexCoordinate on = HexCoordinate.fromCartesian(
                    event.getHistoricalX(0, h)/_scale,
                    event.getHistoricalY(0, h)/_scale
            );
            // TODO: This is broken. Returns a long list of the same key
            if (_lastPressed.size() == 0 || on != _lastPressed.get(_lastPressed.size() - 1)) {
                _lastPressed.add(on);
            }
        }
        HexCoordinate on = HexCoordinate.fromCartesian(event.getX(0)/_scale, event.getY(0)/_scale);
        if (_lastPressed.size() == 0 || on != _lastPressed.get(_lastPressed.size() - 1)) {
            _lastPressed.add(on);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (_lastPressed == null) {
            _lastPressed = new ArrayList<>();
        }

        // TODO: Look into calling performClick and onClickListener on the individual buttons and such
        int action = event.getAction() & MotionEvent.ACTION_MASK;
        String text = "";

        switch (action) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                registerTouches(event);
                for (HexCoordinate coord : _lastPressed) {
                    text = text + "[" + coord.q() + "," + coord.r() + "] ";
                }
                tv.setText("Pressed: " + text);
                return true;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_OUTSIDE:
            case MotionEvent.ACTION_UP:
                _lastPressed.clear();
                return true;
            default:
                return super.onTouchEvent(event);
        }
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


        // create pathshapes for the hexagons?
        for (HexCoordinate coord : _grid) {
            double x = coord.x();
            double y = coord.y();
            float hexpts[] = new float[6*4];
            for (int i = 0; i < 6; i++) {
                hexpts[4*i+0] = (float) (_scale*(x + Hexagon.corner(i).x()));
                hexpts[4*i+1] = (float) (_scale*(y + Hexagon.corner(i).y()));
                hexpts[4*i+2] = (float) (_scale*(x + Hexagon.corner(i+1).x()));
                hexpts[4*i+3] = (float) (_scale*(y + Hexagon.corner(i+1).y()));
            }
            canvas.drawLines(hexpts, rect);
            canvas.drawText(coord.r() + "," + coord.q(), (float)(_scale*x), (float)(_scale*y), rect);

        }
    }

}
