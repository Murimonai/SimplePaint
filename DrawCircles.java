package com.example.host.simplepainttest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/**
 * Created by Host on 28.08.2016.
 */
public class DrawCircles extends View {
    Paint paint;
    float height, width, maxRadius;
    int rC, gC, bC, aC;

    public DrawCircles(Context context) {
        super(context);
        paint = new Paint();
    }

    public int setRandomColor () {
        rC = (int) (Math.random()*255);
        gC = (int) (Math.random()*255);
        bC = (int) (Math.random()*255);
        aC = (int) (Math.random()*255);
        int randomColor = Color.argb(aC,rC, gC, bC);
        return randomColor;
    }

    @Override
    public void onSizeChanged (int wi, int he, int oldw, int oldh)
    {
        super.onSizeChanged(wi, he, oldw, oldh);
        width = wi;
        height = he;

        if(width > height) maxRadius = height/2;
        else maxRadius = width/2;
        //maxRadius = 500;
    }

    @Override
    protected void onDraw(Canvas c) {
        super.onDraw(c);


        //Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);

        paint.setColor(Color.WHITE);
        c.drawPaint(paint);

        paint.setAntiAlias(true);
        paint.setColor(setRandomColor());
        c.drawCircle(width/2,height/2, maxRadius, paint);

        paint.setAntiAlias(true);
        paint.setColor(setRandomColor());
        c.drawCircle(width/2,height/2, (float) (maxRadius*0.66), paint);

        paint.setAntiAlias(true);
        paint.setColor(setRandomColor());
        c.drawCircle(width/2,height/2, (float) (maxRadius*0.33), paint);

        paint.setColor(Color.BLACK);
        c.drawLine(width/2, 0, width/2, height, paint);
        c.drawLine(0, height/2, width, height/2, paint);

    }

}
