package com.example.todo.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.todo.utils.Queries;
import com.example.todo.utils.Utils;


public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, Utils.DATABASE_NAME,null,Utils.DATABASE_VERSION);
    }

    @Override
    public void onCreate (SQLiteDatabase db) {
        db.execSQL(Queries.CREATE_TABLE_TODO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Queries.DROP_TABLE_TODO);
        onCreate(db);
    }

    public boolean addTodo(String id,String task, boolean isCompleted) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Utils.COL_ID,id);
        cv.put(Utils.COL_TASK,task);
        cv.put(Utils.COL_IS_COMPLETED,isCompleted ? 1 : 0);
        long result = db.insert(Utils.TABLE_NAME,null,cv);
        return result != -1;
    }
}
