package com.example.host.simplepainttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public boolean flag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final DrawCircles firstScreen = new DrawCircles(this);
        final DrawDarts secondScreen = new DrawDarts(this);
        setContentView(firstScreen);
        firstScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag) {flag = false; setContentView(secondScreen);}
            }
        });
        secondScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!flag) {flag = true; setContentView(firstScreen);}
            }
        });
        //setContentView(R.layout.activity_main);
    }
}
