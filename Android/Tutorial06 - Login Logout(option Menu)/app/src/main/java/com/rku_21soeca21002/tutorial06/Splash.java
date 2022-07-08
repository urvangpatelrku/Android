package com.rku_21soeca21002.tutorial06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        setTitle(getResources().getString(R.string.splash));

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {



                startActivity(new Intent(Splash.this,MainActivity.class));
                finish();
            }
        },2000);

    }
}