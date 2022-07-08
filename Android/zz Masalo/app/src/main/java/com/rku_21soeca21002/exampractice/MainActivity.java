package com.rku_21soeca21002.exampractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    UserAdapter adapter;
    ArrayList<User> users;
    DBHelper dbHelper;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("User List");
        getSupportActionBar().setSubtitle("Users");

        dbHelper = new DBHelper(getApplicationContext());
        recyclerView = findViewById(R.id.recyclerView);
        users = generateDate();
        adapter = new UserAdapter(users);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private ArrayList<User> generateDate() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(DBHelper.DB_TABLE,null,null,null,null,null,null);
        ArrayList<User> tempUser = new ArrayList<User>();

        if(cursor.getCount()>0){
            cursor.moveToFirst();
            do{
                String name = cursor.getString(1);
                String branch = cursor.getString(2);
                tempUser.add(new User(name,branch));
            }while (cursor.moveToNext());
        }
        return tempUser;
    }

    public void btnAdd(View view) {
        startActivity(new Intent(MainActivity.this,UserForm.class));
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
            case R.id.validation:
                startActivity(new Intent(MainActivity.this,Validation.class));
                break;
            case R.id.api:
                startActivity(new Intent(MainActivity.this,ApiIntegration.class));
                break;
            case R.id.logout:
                builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Are you sure?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "YES", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });

                AlertDialog dialog = builder.create();
                dialog.setTitle("Logout");
                dialog.show();

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}