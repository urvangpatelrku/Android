package com.rku_21soeca21002.tutorial08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText edtUsername,edtPassword;
    DBHelper dbHelper;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DBHelper(getApplicationContext());
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        preferences = getSharedPreferences("login",MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void newUser(View view) {
        startActivity(new Intent(MainActivity.this,Registration.class));
    }

    public void login(View view) {
        String valUsername = edtUsername.getText().toString().trim();
        String valPassword = edtPassword.getText().toString();

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("student",new String[]{"username","password"},"username=? and password=?",new String[]{valUsername,valPassword},null,null,null);
        if(cursor.getCount()>0)
        {
            editor.putString("username",valUsername);
            editor.commit();
            startActivity(new Intent(MainActivity.this,Welcome.class));
            finish();
        }
        else
        {
            Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
        }
    }
}