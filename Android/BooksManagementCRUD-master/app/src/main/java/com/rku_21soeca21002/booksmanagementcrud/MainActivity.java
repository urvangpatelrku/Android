package com.rku_21soeca21002.booksmanagementcrud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DBHelper dbHelper;
    BooksAdapter adapter;
    ArrayList<Books> books;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(getApplicationContext());
        recyclerView = findViewById(R.id.recyclerView);
        books = fetchData();
        adapter = new BooksAdapter(books,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private ArrayList<Books> fetchData() {
        ArrayList<Books> book = new ArrayList<Books>();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query(DBHelper.DB_TABLE,null,null,null,null,null,null);
        if(cursor.getCount()>0)
        {
            cursor.moveToFirst();
            do{
                int id = cursor.getInt(0);
                String title = cursor.getString(1);
                String price = cursor.getString(2);
                String author = cursor.getString(3);
                book.add(new Books(id,title,price,author));
            }while (cursor.moveToNext());
        }
        return book;
    }

    public void addNewBook(View view) {
        startActivity(new Intent(MainActivity.this, BookForm.class));
        finish();
    }
}