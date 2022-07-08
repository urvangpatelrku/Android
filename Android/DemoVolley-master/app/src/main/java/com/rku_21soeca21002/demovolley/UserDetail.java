package com.rku_21soeca21002.demovolley;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class UserDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        Intent intent = getIntent();
        Toast.makeText(this, ""+intent.getIntExtra("userid",0), Toast.LENGTH_SHORT).show();
    }
}