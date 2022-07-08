package com.rku_21soeca21002.tutorial08;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    TextView txtID;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        dbHelper = new DBHelper(getApplicationContext());
        txtID = findViewById(R.id.txtID);
        Bundle bundle = getIntent().getExtras();
        int id = bundle.getInt("id");
        String newid = ""+(id+1);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("student", null, "id=?",new String[]{newid}, null, null, null);
        if (cursor.getCount() > 0)
        {
            cursor.moveToFirst();
            String data = "";
            do
            {
                data = data +"Name : "+ cursor.getString(1) + " " + cursor.getString(2)+"\n"+"Username : "+ cursor.getString(3)+"\nPassword : "+cursor.getString(4)+"\nCity : "+cursor.getString(5)+"\nGender : "+cursor.getString(6);
            }while(cursor.moveToNext());
            txtID.setText(data);
        }
    }
}