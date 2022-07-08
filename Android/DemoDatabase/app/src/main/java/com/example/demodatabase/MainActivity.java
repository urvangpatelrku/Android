package com.example.demodatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    TextInputEditText edtUsername, edtPassword;
    TextView txtData;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(getApplicationContext());
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        txtData = findViewById(R.id.txtData);

    }

    public void btnViewData(View view) {
        String valUsername = edtUsername.getText().toString().trim();
        String valPassword = edtPassword.getText().toString();

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", valUsername);
        values.put("password", valPassword);
        db.insert("student", null, values);

        displayData();
    }


    private void displayData() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
//        Cursor cursor = db.query("student", new String[]{"username", "password"}, "id<?", new String[]{"10"}, null, null, "id desc");
        Cursor cursor = db.query("student", new String[]{"username", "password"}, null,null, null, null, "id desc");
        if (cursor.getCount() > 0)
        {
            cursor.moveToFirst();
            String data = "";
            do
            {
                data = data +""+ cursor.getString(0) + " " + cursor.getString(1)+"\n";
            }while(cursor.moveToNext());

            txtData.setText(data);
        }
    }
}