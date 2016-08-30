package com.example.host.simplepainttest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/**
 * Created by Host on 28.08.2016.
 */
public class DrawDarts extends View {
    Paint paint;
    float height, width, maxRadius, h, w;
    int rC, gC, bC, aC;

    public DrawDarts(Context context) {
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
        w = wi;
        h = he;

        if(w > h) maxRadius = h/2;
        else maxRadius = w/2;
        //maxRadius = 500;
    }

    @Override
    protected void onDraw(Canvas c) {

        //Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);

        //Перекрашиваем фон = стираем все содержимое
        paint.setColor(Color.WHITE);
        c.drawPaint(paint);


        // рисуем первый круг рандомного цвета
        paint.setAntiAlias(true);
        paint.setColor(setRandomColor());
        float radius = maxRadius;
        c.drawCircle(w/2, h/2, radius, paint);
        RectF oval1 = new RectF(w/2 - radius, h/2 - radius, w/2 + radius, h/2 + radius);
        //рисуем сектора случайного цвета
        int startAngle = 0, sweepAngle = 45;
        for (int i = 0; i<8; i++) {
            paint.setColor(setRandomColor());
            startAngle = 45*i;
            sweepAngle = startAngle + 45;
            c.drawArc(oval1, startAngle, sweepAngle, true, paint);
        }

        // рисуем второй круг рандомного цвета
        paint.setColor(setRandomColor());
        radius = (float) (maxRadius*0.66);
        c.drawCircle(w/2,h/2, radius, paint);
        RectF oval2 = new RectF(w/2 - radius, h/2 - radius, w/2 + radius, h/2 + radius);
        //рисуем сектора случайного цвета
        startAngle = 0; sweepAngle = 45;
        for (int i = 0; i<8; i++) {
            paint.setColor(setRandomColor());
            startAngle = 45*i;
            sweepAngle = startAngle + 45;
            c.drawArc(oval2, startAngle, sweepAngle, true, paint);
        }

        // рисуем третий круг рандомного цвета
        paint.setColor(setRandomColor());
        radius = (float) (maxRadius*0.33);
        c.drawCircle(w/2,h/2, radius, paint);
        RectF oval3 = new RectF(w/2 - radius, h/2 - radius, w/2 + radius, h/2 + radius);
        //рисуем сектора случайного цвета
        startAngle = 0; sweepAngle = 45;
        for (int i = 0; i<8; i++) {
            paint.setColor(setRandomColor());
            startAngle = 45*i;
            sweepAngle = startAngle + 45;
            c.drawArc(oval3, startAngle, sweepAngle, true, paint);
        }
        //и черные линии сверху
        paint.setColor(Color.BLACK);
        c.drawLine(w/2, 0, w/2, h, paint);
        c.drawLine(0, h/2, w, h/2, paint);
        c.drawLine(w/2 - maxRadius, h/2 - maxRadius, w/2 + maxRadius, h/2 + maxRadius, paint);
        c.drawLine(w/2 - maxRadius, h/2 + maxRadius, w/2 + maxRadius, h/2 - maxRadius, paint);

        super.onDraw(c);
    }

}
