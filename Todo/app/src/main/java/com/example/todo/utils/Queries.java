package com.example.todo.utils;

public class Queries {

    public static final String CREATE_TABLE_TODO =
    "CREATE TABLE "+Utils.TABLE_NAME+"("+Utils.COL_ID+" TEXT PRIMARY KEY,"
            +Utils.COL_TASK+" TEXT,"+Utils.COL_IS_COMPLETED+" INTEGER DEFAULT 0"+
            ");";
    // create table todos(id text primary key,task text,isCompleted integer default 0);

    public static final String DROP_TABLE_TODO=
            "DROP TABLE IF EXISTS "+Utils.TABLE_NAME;
}
