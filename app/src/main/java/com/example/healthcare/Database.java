package com.example.healthcare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database  extends SQLiteOpenHelper {

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // when the table is not there then it will be created
        String sql1 = "CREATE TABLE users (username TEXT, email TEXT, password TEXT)";
        db.execSQL(sql1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // used when we change the structure of the database, eg adding tables, removing etc
    }

    public void registerNewUser(String username, String email, String password) {
        ContentValues cv = new ContentValues();

        cv.put("username", username); // first parameter is the column name and second is the value for that column
        cv.put("email", email);
        cv.put("password", password);

        SQLiteDatabase db = getWritableDatabase();
        db.insert("users", null, cv);
        db.close();
    }

    // returns 1 if at-least 1 user is found, else 0
    public int loginUser(String username, String password) {
        int result = 0;

        SQLiteDatabase db = getReadableDatabase();

        String[] args = {username, password};
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE username = ? AND password = ?", args);

        // checking if there is at-least one record in the table
        if (cursor.moveToFirst()) {
            result = 1;
        }
        // freeing up the resources
        cursor.close();
        db.close();

        return result;
    }
}
