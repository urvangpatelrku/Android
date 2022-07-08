package com.rku_21soeca1002.tutorial07;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class Welcome extends AppCompatActivity {

    TextView txtUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        txtUsername = findViewById(R.id.txtUsername);

        Bundle bundle = getIntent().getExtras();
        String username = bundle.getString("username");


        txtUsername.setText("Welcome, "+username);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id)
        {
            case R.id.logout:
                Toast.makeText(this, "Logout Successfull", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Welcome.this,MainActivity.class));
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}