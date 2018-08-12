package com.example.sambhav.firebasechat;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MyRecyAdapter extends RecyclerView.Adapter<MyRecyAdapter.MyViewHolder>

{
    private ArrayList<Task> taskArrayList;
    private Context context;

    public  MyRecyAdapter(ArrayList<Task>tasks,Context ctx){
        taskArrayList  = tasks;
        context = ctx;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater lif = LayoutInflater.from(context);
        View inflatedView = lif.inflate(R.layout.item_row,parent,false);
        return new MyViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Task currentTask = taskArrayList.get(position);
        holder.

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View itemView) {
            super(itemView);



        }
    }
}
