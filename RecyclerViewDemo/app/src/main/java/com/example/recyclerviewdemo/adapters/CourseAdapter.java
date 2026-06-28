package com.example.recyclerviewdemo.adapters;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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
        final CourseModel model = courseList.get(position);
        String title = model.getCourseTitle();
        String price = model.getCoursePrice();
        String image = model.getCourseImage();
        holder.tvTitle.setText(title);
        holder.tvPrice.setText(price);


        try {
            Picasso.get().load(image).placeholder(R.drawable.ic_launcher_background).into(holder.courseIv);
        } catch (Exception e) {
            Toast.makeText(context, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        /*
            item click for update
         */
        holder.itemView.setOnClickListener(v->{
            openDialog(model, position);
        });

        // item long click for delete
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Delete Item");
                builder.setMessage("Do you want to delete this item?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        courseList.remove(position);
                        //notify adapter that we have removed item
                        notifyItemRemoved(position);
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();


                return true;
            }
        });


    }

    @Override
    public int getItemCount() {
        int size = courseList.size();
        return size;
    }


    private void openDialog(CourseModel model, int position) {
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.add_course_layout);

        initDialogComp(dialog, model,position);

        dialog.show();
    }

    private void initDialogComp(Dialog dialog, CourseModel model, int position) {
        EditText edtCourseImage = dialog.findViewById(R.id.edtCourseImage);
        EditText edtCourseTitle = dialog.findViewById(R.id.edtCourseTitle);
        EditText edtCoursePrice = dialog.findViewById(R.id.edtCoursePrice);
        Button btnAddAndEdit = dialog.findViewById(R.id.btnAddAndEdit);

        //set data
        edtCourseTitle.setText(model.getCourseTitle());
        edtCoursePrice.setText(model.getCoursePrice());
        edtCourseImage.setText(model.getCourseImage());
        btnAddAndEdit.setText("Edit");

        btnAddAndEdit.setOnClickListener(v->{
            String image, title, price;
            image = edtCourseImage.getText().toString();
            title = edtCourseTitle.getText().toString();
            price = edtCoursePrice.getText().toString();

            CourseModel update = new CourseModel(image, title, price);
            courseList.set(position,update);

            notifyItemChanged(position);
            // it will notify the adapter that where it has changed on which index

            dialog.dismiss();
        });

    }
}
