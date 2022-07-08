package com.rku_21soeca1002.tutorial07;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    static final String DB_NAME = "rku";
    static final int DB_VERSION = 1;
    static final String DB_TABLE = "student";

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS "+DB_TABLE+"(id INTEGER PRIMARY KEY AUTOINCREMENT, firstname TEXT, lastname TEXT, username TEXT, password TEXT, city TEXT, gender TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
