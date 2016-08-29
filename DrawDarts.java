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
    protected void onDraw(Canvas c) {

        //width = c.getWidth();
        //height = c.getHeight();
        width = this.getWidth();
        height = this.getHeight();
        if(width > height) {maxRadius = height; h = width; w = height;}
        else {maxRadius = width; h = height; w = width;}


        //Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);

        //Перекрашиваем фон = стираем все содержимое
        paint.setColor(Color.WHITE);
        c.drawPaint(paint);


        // рисуем первый круг рандомного цвета
        paint.setAntiAlias(true);
        paint.setColor(setRandomColor());
        float radius = maxRadius;
        c.drawCircle(width/2, height/2, radius, paint);
        RectF oval1 = new RectF(w/2 - radius, h/2 - radius, w/2 + radius, h/2 + radius);
        //рисуем сектора случайного цвета
        int startAngle = 0, sweepAngle = 45;
        for (int i = 0; i<9; i++) {
            paint.setColor(setRandomColor());
            startAngle += 45;
            sweepAngle += 45;
            c.drawArc(oval1, startAngle, sweepAngle, false, paint);
        }

        // рисуем второй круг рандомного цвета
        paint.setColor(setRandomColor());
        radius = (float) (maxRadius*0.66);
        c.drawCircle(width/2,height/2, radius, paint);
        RectF oval2 = new RectF(w/2 - radius, h/2 - radius, w/2 + radius, h/2 + radius);
        //рисуем сектора случайного цвета
        startAngle = 0; sweepAngle = 45;
        for (int i = 0; i<9; i++) {
            paint.setColor(setRandomColor());
            startAngle += 45;
            sweepAngle += 45;
            c.drawArc(oval2, startAngle, sweepAngle, false, paint);
        }

        // рисуем третий круг рандомного цвета
        paint.setColor(setRandomColor());
        radius = (float) (maxRadius*0.33);
        c.drawCircle(width/2,height/2, radius, paint);
        RectF oval3 = new RectF(w/2 - radius, h/2 - radius, w/2 + radius, h/2 + radius);
        //рисуем сектора случайного цвета
        startAngle = 0; sweepAngle = 45;
        for (int i = 0; i<9; i++) {
            paint.setColor(setRandomColor());
            startAngle += 45;
            sweepAngle += 45;
            c.drawArc(oval3, startAngle, sweepAngle, false, paint);
        }
        //и черные линии сверху
        paint.setColor(Color.BLACK);
        c.drawLine(width/2, 0, width/2, height, paint);
        c.drawLine(0, height/2, width, height/2, paint);
        c.drawLine(w/2 - maxRadius, h/2 - maxRadius, w/2 + maxRadius, h/2 + maxRadius, paint);
        c.drawLine(w/2 - maxRadius, h/2 + maxRadius, w/2 + maxRadius, h/2 - maxRadius, paint);

        super.onDraw(c);
    }

}
