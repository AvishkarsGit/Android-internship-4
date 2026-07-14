package com.example.roomdatabse;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.roomdatabse.entity.TodoEntity;
import com.example.roomdatabse.helper.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //init database
        initDatabase();

        // insert values into the table

//        helper.todoDao().addTodo(
//                new TodoEntity("Create database",false)
//        );

        ArrayList<TodoEntity> todoList =  (ArrayList<TodoEntity>) helper.todoDao().getAllTodos();
        for (TodoEntity todoEntity: todoList) {
            Log.d("TODOS", "task :"+todoEntity.getTask());
        }






    }

    private void initDatabase() {
        helper = DatabaseHelper.getDatabase(MainActivity.this);
    }
}