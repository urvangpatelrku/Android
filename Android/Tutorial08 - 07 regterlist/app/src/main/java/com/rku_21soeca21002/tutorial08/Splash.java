package com.rku_21soeca21002.tutorial08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        preferences = getSharedPreferences("login",MODE_PRIVATE);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if(preferences.getString("username","").equals(""))
                {
                    startActivity(new Intent(Splash.this,MainActivity.class));
                    finish();
                }
                else
                {
                    startActivity(new Intent(Splash.this,Welcome.class));
                    finish();
                }
            }
        }, 1000);

    }
}