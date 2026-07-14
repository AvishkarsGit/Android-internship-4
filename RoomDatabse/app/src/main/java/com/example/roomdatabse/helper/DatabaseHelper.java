package com.example.roomdatabse.helper;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.roomdatabse.dao.TodoDao;
import com.example.roomdatabse.entity.TodoEntity;

@Database(entities = TodoEntity.class,exportSchema = false,version = 1)
public abstract class DatabaseHelper extends RoomDatabase {

    private static String DB_NAME="todo_db";
    private static DatabaseHelper instance;

    public static DatabaseHelper getDatabase(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context,DatabaseHelper.class,DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    /**  give access to the DAO (interface) */
    public abstract TodoDao todoDao();


}
