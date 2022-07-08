package com.rku_21soeca21002.booksmanagementcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class BookForm extends AppCompatActivity {

    DBHelper dbHelper;
    EditText edtTitle,edtAuthor,edtPrice;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_form);
        edtTitle = findViewById(R.id.edtTitle);
        edtAuthor = findViewById(R.id.edtAuthor);
        edtPrice = findViewById(R.id.edtPrice);
        dbHelper = new DBHelper(getApplicationContext());
        intent = getIntent();
        edtTitle.setText(intent.getStringExtra("title"));
        edtAuthor.setText(intent.getStringExtra("author"));
        edtPrice.setText(intent.getStringExtra("price"));
    }

    public void btnSubmit(View view) {
        String valTitle = edtTitle.getText().toString().trim();
        String valAuthor = edtAuthor.getText().toString().trim();
        String valPrice = edtPrice.getText().toString().trim();
        if(valTitle.equals("") || valAuthor.equals("") || valPrice.equals(""))
        {
            Toast.makeText(this, "Fill All", Toast.LENGTH_SHORT).show();
            return;
        }
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title",valTitle);
        values.put("author",valAuthor);
        values.put("price",valPrice);
        int id = intent.getIntExtra("id",0);
        if(id == 0)
        {
            db.insert(DBHelper.DB_TABLE,null,values);
        }
        else
        {
            db.update(DBHelper.DB_TABLE,values,"id=?",new String[]{""+id});
        }
        startActivity(new Intent(BookForm.this,MainActivity.class));
        finish();
    }

    public void btnCancle(View view) {
        startActivity(new Intent(BookForm.this,MainActivity.class));
        finish();
    }
}