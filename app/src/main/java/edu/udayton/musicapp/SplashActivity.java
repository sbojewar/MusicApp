package edu.udayton.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {
    private static final long DELAY=6000; //6 sec delay

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // timer task

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                finish();
                Intent  intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
            }
        };
        //timer

        Timer opening = new Timer();
        opening.schedule(task, DELAY);
    } //end on create method
} //end splashactivity
