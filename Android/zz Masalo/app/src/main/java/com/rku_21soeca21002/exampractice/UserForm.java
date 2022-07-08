package com.rku_21soeca21002.exampractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UserForm extends AppCompatActivity {

    DBHelper dbHelper;
    EditText edtName,edtBranch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_form);
        edtBranch = findViewById(R.id.edtBranch);
        edtName = findViewById(R.id.edtName);
        dbHelper = new DBHelper(getApplicationContext());
    }

//    Insert into Database
    public void btnAddUser(View view) {
        String name = edtName.getText().toString().trim();
        String branch = edtBranch.getText().toString().trim();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("branch",branch);
        db.insert(DBHelper.DB_TABLE,null,values);
        Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(UserForm.this,MainActivity.class));
        finish();
    }
}