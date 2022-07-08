package com.rku_21soeca21002.exampractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    TextView txtCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

//        Hide Action Bar
        getSupportActionBar().hide();


//        For count application
        txtCount = findViewById(R.id.txtCount);
        preferences = getSharedPreferences("count",MODE_PRIVATE);
        editor = preferences.edit();
        int c = preferences.getInt("c",1);
        editor.putInt("c",c+1);
        editor.commit();
        txtCount.setText(""+c);

//      Timer of Splash screen
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(Splash.this,MainActivity.class));
                finish();
            }
        },1000);
    }
}