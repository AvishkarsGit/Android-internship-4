package com.example.miniproduct.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 4;
    private static final String DATABASE_NAME = "products_db";
    private static final String TABLE_NAME = "register";
    private static final String COL_ID = "id";

    private static final String COL_NAME = "name";

    private static final String COL_USER = "username";

    private static final String COL_PASSWORD = "password";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_NAME + " TEXT," + COL_USER + " TEXT," + COL_PASSWORD + " TEXT" + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("DATABASE_ONUPGRADE", "OLD DB VERSION:"+oldVersion);
        Log.d("DATABASE_ONUPGRADE", "NEW DB VERSION:"+newVersion);
       if (oldVersion < 4) {
           db.execSQL("CREATE TABLE PRODUCTS (id TEXT PRIMARY KEY,name TEXT, price TEXT);");
       }
    }

    //INSERT INTO register (id, name, username, password) VALUES (`$1`
    // SELECT id FROM register WHERE id=$1;
    public boolean register(String name, String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("username", username);
        values.put("password", password);
        long result = db.insert(TABLE_NAME, null, values);
        return result != -1;
    }

    public boolean login(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT " + COL_USER + "," + COL_PASSWORD + " FROM " + TABLE_NAME + " WHERE " + COL_USER + " = ? AND " + COL_PASSWORD + " = ?", new String[]{username, password});
        return cursor.getCount() > 0;
        //SELECT username, password FROM register WHERE username=admin AND password=admin@123
    }

    public boolean isUserExists(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT " + COL_USER + " FROM " + TABLE_NAME + " WHERE " + COL_USER + " = ?", new String[]{username});
        return cursor.getCount() > 0;
        //SELECT username FROM register WHERE username=admin;
    }

    /**
     * if (isUserExists(username)){
     *     if (login(username, password)) {
     *
     *     }
     *     else {
     *
     *      Toast('Invalid creadentials");
     *     }
     * }
     * else {
     *     Toast('User does not exists with this username");
     * }
     */

}
