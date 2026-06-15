package com.example.todo;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.todo.helper.DatabaseHelper;
import com.example.todo.utils.Utils;

import java.util.UUID;

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

        //init comp
        initComp();
        String id = Utils.generateUUID();
        boolean isCreated = helper.addTodo(id,"Create todo", false);
        if (isCreated) {
            Toast.makeText(this, "Todo Created", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Failed to create todo", Toast.LENGTH_SHORT).show();
        }


    }

    private void initComp()
    {
        helper = new DatabaseHelper(MainActivity.this);

    }
}