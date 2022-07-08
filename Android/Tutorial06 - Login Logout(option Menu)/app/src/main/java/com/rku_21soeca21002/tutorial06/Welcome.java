package com.rku_21soeca21002.tutorial06;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {
    TextView txtWelcome;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        txtWelcome = findViewById(R.id.txtWelcome);

        preferences = getSharedPreferences("login",MODE_PRIVATE);
        editor = preferences.edit();
        String username = preferences.getString("username","");
        txtWelcome.setText("Welcome, "+username);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.menuLogout)
        {
            editor.remove("username");
            editor.commit();
            startActivity(new Intent(Welcome.this,MainActivity.class));
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}