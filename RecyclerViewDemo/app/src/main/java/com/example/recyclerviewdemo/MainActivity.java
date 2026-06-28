package com.example.recyclerviewdemo;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

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
    private  ArrayList<CourseModel> courseList;
    private CourseAdapter courseAdapter;

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

        fab.setOnClickListener(v->{
            openDialog();
        });
    }

    private void getAllList() {
        courseList = new ArrayList<>();
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

        courseList.add(new CourseModel("https://cdn.jsdelivr.net/gh/devicons/devicon/icons/python/python-original.svg","Python","599"));
        courseList.add(new CourseModel("https://cdn.jsdelivr.net/gh/devicons/devicon/icons/javascript/javascript-original.svg","JavaScript","549"));
        courseList.add(new CourseModel("https://cdn.jsdelivr.net/gh/devicons/devicon/icons/typescript/typescript-original.svg","TypeScript","649"));
        courseList.add(new CourseModel("https://cdn.jsdelivr.net/gh/devicons/devicon/icons/csharp/csharp-original.svg","C#","699"));
        courseList.add(new CourseModel("https://cdn.jsdelivr.net/gh/devicons/devicon/icons/php/php-original.svg","PHP","449"));
        courseList.add(new CourseModel("https://cdn.jsdelivr.net/gh/devicons/devicon/icons/go/go-original.svg","Go","749"));
        courseList.add(new CourseModel("https://cdn.jsdelivr.net/gh/devicons/devicon/icons/rust/rust-original.svg","Rust","899"));
        courseList.add(new CourseModel("https://cdn.jsdelivr.net/gh/devicons/devicon/icons/kotlin/kotlin-original.svg","Kotlin","799"));
        courseList.add(new CourseModel("https://cdn.jsdelivr.net/gh/devicons/devicon/icons/swift/swift-original.svg","Swift","849"));
        courseList.add(new CourseModel("https://cdn.jsdelivr.net/gh/devicons/devicon/icons/dart/dart-original.svg","Dart","699"));

        courseList.add(new CourseModel("https://cdn.jsdelivr.net/gh/devicons/devicon/icons/r/r-original.svg","R Programming","599"));
        courseList.add(new CourseModel("https://cdn.jsdelivr.net/gh/devicons/devicon/icons/ruby/ruby-original.svg","Ruby","649"));
        courseList.add(new CourseModel("https://cdn.jsdelivr.net/gh/devicons/devicon/icons/perl/perl-original.svg","Perl","499"));
        courseList.add(new CourseModel("https://cdn.jsdelivr.net/gh/devicons/devicon/icons/scala/scala-original.svg","Scala","799"));
        courseList.add(new CourseModel("https://cdn.jsdelivr.net/gh/devicons/devicon/icons/elixir/elixir-original.svg","Elixir","849"));
        courseList.add(new CourseModel("https://cdn.jsdelivr.net/gh/devicons/devicon/icons/haskell/haskell-original.svg","Haskell","899"));
        courseList.add(new CourseModel("https://cdn.jsdelivr.net/gh/devicons/devicon/icons/lua/lua-original.svg","Lua","549"));
        courseList.add(new CourseModel("https://cdn.jsdelivr.net/gh/devicons/devicon/icons/matlab/matlab-original.svg","MATLAB","999"));
        courseList.add(new CourseModel("https://cdn.jsdelivr.net/gh/devicons/devicon/icons/objectivec/objectivec-plain.svg","Objective-C","749"));
        courseList.add(new CourseModel("https://cdn.jsdelivr.net/gh/devicons/devicon/icons/clojure/clojure-original.svg","Clojure","799"));


        courseAdapter =new CourseAdapter(MainActivity.this,courseList);
        recyclerView.setAdapter(courseAdapter);
    }

    private void openDialog(){
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.add_course_layout);

        EditText edtCourseImage = dialog.findViewById(R.id.edtCourseImage);
        EditText edtCourseTitle = dialog.findViewById(R.id.edtCourseTitle);
        EditText edtCoursePrice = dialog.findViewById(R.id.edtCoursePrice);
        Button btnAddAndEdit = dialog.findViewById(R.id.btnAddAndEdit);

        btnAddAndEdit.setText("Save");

        btnAddAndEdit.setOnClickListener(v ->  {
            String image, title, price;
            image = edtCourseImage.getText().toString();
            title = edtCourseTitle.getText().toString();
            price = edtCoursePrice.getText().toString();

            CourseModel model = new CourseModel(image,title,price);
            courseList.add(model);

            courseAdapter.notifyItemInserted(courseList.size());
            recyclerView.scrollToPosition(courseList.size()-1);


            dialog.dismiss();

        });

        dialog.show();

    }
    private void initComp() {
        fab = findViewById(R.id.fabAdd);
        recyclerView = findViewById(R.id.courseRv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
    }
}