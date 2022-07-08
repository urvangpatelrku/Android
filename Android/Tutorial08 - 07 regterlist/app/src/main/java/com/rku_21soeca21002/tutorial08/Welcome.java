package com.rku_21soeca21002.tutorial08;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class Welcome extends AppCompatActivity {

    MyAdapter adapter;
    ListView lstData;
    DBHelper dbHelper;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        preferences = getSharedPreferences("login",MODE_PRIVATE);
        editor = preferences.edit();
        lstData = findViewById(R.id.lstData);
        dbHelper = new DBHelper(getApplicationContext());
        ArrayList<Users> items = new ArrayList<Users>();
        adapter = new MyAdapter(this, generateData());
        lstData.setAdapter(adapter);

        lstData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(Welcome.this,Details.class);
                intent.putExtra("id",position);
                startActivity(intent);
                finish();
            }
        });
    }

    private ArrayList<Users> generateData() {
        ArrayList<Users> user = new ArrayList<Users>();

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("student", null, null, null, null, null, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                user.add(new Users(cursor.getString(3)));
            } while (cursor.moveToNext());
        }
        return user;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.logout:
                editor.remove("username");
                editor.commit();
                Toast.makeText(this, "Logout Successfull", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Welcome.this, MainActivity.class));
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}