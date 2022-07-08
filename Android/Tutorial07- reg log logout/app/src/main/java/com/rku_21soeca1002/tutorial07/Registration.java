package com.rku_21soeca1002.tutorial07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Registration extends AppCompatActivity {

    TextInputEditText edtFirstname,edtLastname,edtUsername,edtPassword;
    Spinner spinCity;
    RadioGroup rdoGroup;
    RadioButton rdoGender;
    CheckBox check;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        dbHelper = new DBHelper(getApplicationContext());

        edtFirstname = findViewById(R.id.edtFirstname);
        edtLastname = findViewById(R.id.edtLastname);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        spinCity = findViewById(R.id.spinCity);
        check = findViewById(R.id.check);
        rdoGroup = findViewById(R.id.rdoGender);


    }

    public void register(View view) {
        rdoGender = findViewById(rdoGroup.getCheckedRadioButtonId());

        String valFirstname = edtFirstname.getText().toString().trim();
        String valLastname = edtLastname.getText().toString().trim();
        String valUsername = edtUsername.getText().toString().trim();
        String valPassword = edtPassword.getText().toString();
        String valCity = spinCity.getSelectedItem().toString();
        String valGender = rdoGender.getText().toString();

        if(valFirstname.equals("") || valLastname.equals("") ||  valUsername.equals("") || valPassword.equals(""))
        {
            Toast.makeText(this, "Fill all values", Toast.LENGTH_SHORT).show();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(valUsername).matches())
        {
            Toast.makeText(this, "Username must be Email Address", Toast.LENGTH_SHORT).show();
            return;
        }

        if(valPassword.length() < 6)
        {
            Toast.makeText(this, "Password must be of 6 letters", Toast.LENGTH_SHORT).show();
            return;
        }

        if(!check.isChecked())
        {
            Toast.makeText(this, "Accept Terms & Condition", Toast.LENGTH_SHORT).show();
            return;
        }

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username",valUsername);
        values.put("firstname",valFirstname);
        values.put("lastname",valLastname);
        values.put("password",valPassword);
        values.put("gender",valGender);
        values.put("city",valCity);
        db.insert("student",null,values);

        Toast.makeText(this, "Registration successfull", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(Registration.this,MainActivity.class));
    }
}