package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    private Chronometer chronometer;
    private boolean running;
    private long pauseoffset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer=findViewById(androidx.core.R.id.chronometer);

    }
    public void startChronometer(View v ){
     if(!running){
         chronometer.setBase(SystemClock.elapsedRealtime()-pauseoffset);
         chronometer.start();
         running=true;
     }
    }
    public void stopChronometer(View v ){
        if(running){
            chronometer.stop();
            pauseoffset=SystemClock.elapsedRealtime()-chronometer.getBase();
            running=false;
        }
    }
    public void resetChronometer(View v ){
      chronometer.setBase(SystemClock.elapsedRealtime());
      pauseoffset=0;
    }

}