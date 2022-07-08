package com.rku_21soeca21002.booksmanagementcrud;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BooksViewHolder> {
    ArrayList<Books> books;
    Context context;
    DBHelper dbHelper;
    AlertDialog.Builder builder;
    public BooksAdapter(ArrayList<Books> books,Context context) {
        this.books = books;
        this.context = context;
        dbHelper = new DBHelper(context);
        builder = new AlertDialog.Builder(context);
    }

    @NonNull
    @Override
    public BooksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.booklist,parent,false);
        return new BooksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BooksViewHolder holder, int position) {
        holder.txtTitle.setText(books.get(position).getTitle());
        holder.txtPrice.setText(books.get(position).getPrice());
        holder.txtAuthor.setText(books.get(position).getAuthor());

        holder.btnEditBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = books.get(position).getId();
                String title = books.get(position).getTitle();
                String price = books.get(position).getPrice();
                String author = books.get(position).getAuthor();
                Intent intent = new Intent(context,BookForm.class);
                intent.putExtra("id",id);
                intent.putExtra("title",title);
                intent.putExtra("price",price);
                intent.putExtra("author",author);
                context.startActivity(intent);
                ((Activity)context).finish();
            }
        });

        holder.btnDeleteBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                builder.setMessage("Are you sure you want to delete?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int id = books.get(position).getId();
                                SQLiteDatabase db = dbHelper.getWritableDatabase();
                                db.delete(DBHelper.DB_TABLE,"id=?",new String[]{""+id});
                                Toast.makeText(context,"Deleted",Toast.LENGTH_SHORT).show();
                                context.startActivity(new Intent(context,context.getClass()));
                                ((Activity)context).finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });

                AlertDialog alert = builder.create();
                alert.setTitle("Delete Book");
                alert.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    class BooksViewHolder extends RecyclerView.ViewHolder{
        TextView txtTitle,txtPrice,txtAuthor;
        ImageButton btnEditBook,btnDeleteBook;
        public BooksViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            txtAuthor = itemView.findViewById(R.id.txtAuthor);
            btnEditBook = itemView.findViewById(R.id.btnEditBook);
            btnDeleteBook = itemView.findViewById(R.id.btnDeleteBook);
        }
    }
}
