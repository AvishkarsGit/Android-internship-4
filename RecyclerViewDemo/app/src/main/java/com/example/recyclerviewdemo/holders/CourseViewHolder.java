package com.example.recyclerviewdemo.holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewdemo.R;

public class CourseViewHolder extends RecyclerView.ViewHolder {

    public TextView tvTitle, tvPrice;
    public ImageView courseIv;
    public CourseViewHolder(@NonNull View itemView) {
        super(itemView);
        tvTitle = itemView.findViewById(R.id.tvCourseTitle);
        tvPrice = itemView.findViewById(R.id.tvCoursePrice);
        courseIv = itemView.findViewById(R.id.courseIv);
    }
}
