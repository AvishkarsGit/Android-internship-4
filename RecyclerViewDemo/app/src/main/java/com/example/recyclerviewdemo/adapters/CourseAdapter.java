package com.example.recyclerviewdemo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewdemo.R;
import com.example.recyclerviewdemo.holders.CourseViewHolder;
import com.example.recyclerviewdemo.models.CourseModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseViewHolder> {

    private Context context;
    private ArrayList<CourseModel> courseList;

    public CourseAdapter(Context context, ArrayList<CourseModel> courseList) {
        this.context = context;
        this.courseList = courseList;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //attach layout to your adapter
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.course_row_layout,parent, false);
        CourseViewHolder viewHolder = new CourseViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        //bind data to your layout
        String title = courseList.get(position).getCourseTitle();
        String price = courseList.get(position).getCoursePrice();
        String image = courseList.get(position).getCourseImage();
        holder.tvTitle.setText(title);
        holder.tvPrice.setText(price);
        try {
            Picasso.get().load(image).placeholder(R.drawable.ic_launcher_background).into(holder.courseIv);
        } catch (Exception e) {
            Toast.makeText(context, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public int getItemCount() {
        int size = courseList.size();
        return size;
    }
}
