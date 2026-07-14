package com.example.roomdatabse.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.roomdatabse.entity.TodoEntity;

import java.util.List;

@Dao
public interface TodoDao {
    @Query("SELECT * FROM todos")
    List<TodoEntity> getAllTodos();

    @Insert
    void addTodo(TodoEntity todoEntity);

}
