package com.rku_21soeca1002.tutorial07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText edtUsername,edtPassword;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DBHelper(getApplicationContext());
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
    }

    public void login(View view) {
        String valUsername = edtUsername.getText().toString().trim();
        String valPassword = edtPassword.getText().toString();

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("student",new String[]{"username","password"},"username=? and password=?",new String[]{valUsername,valPassword},null,null,null);
        if(cursor.getCount()>0)
        {
            Intent intent = new Intent(MainActivity.this,Welcome.class);
            intent.putExtra("username",valUsername);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
        }
    }

    public void newUser(View view) {
        startActivity(new Intent(MainActivity.this,Registration.class));
    }
}