package com.example.recyclerviewdemo;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewdemo.adapters.CourseAdapter;
import com.example.recyclerviewdemo.models.CourseModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    private RecyclerView recyclerView;

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

        //init component;
        initComp();

        //getAllList
        getAllList();
    }

    private void getAllList() {
        ArrayList<CourseModel> courseList = new ArrayList<>();
        // data 1
//        CourseModel model = new CourseModel();
//        model.setCourseTitle("C Language");
//        model.setCoursePrice("299");
//
//        //data 2
//        CourseModel model2 = new CourseModel();
//        model2.setCourseTitle("C++ Language");
//        model2.setCoursePrice("399");
//        courseList.add(model);

        courseList.add(new CourseModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSwYBiL19nAM-JCIlG0RY0NKpUmg6f0mQyA5ELUWmDEkg&s=10","C Lang","299"));
        courseList.add(new CourseModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9ZrmsGwJYfYs_2ltjr0288zORq27l0AipBQwkbdtvMQ&s=10","C++ Lang","399"));
        courseList.add(new CourseModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQClSrSy94fg7Y6VBv-HfVvCjzl17kfQTea2fOVE5oDAuSUA4wrpvxTEMY&s=10","Java Lang","499"));

        CourseAdapter courseAdapter =new CourseAdapter(MainActivity.this,courseList);
        recyclerView.setAdapter(courseAdapter);
    }
    private void initComp() {
        fab = findViewById(R.id.fabAdd);
        recyclerView = findViewById(R.id.courseRv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
    }
}