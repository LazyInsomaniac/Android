package com.example.sambhav.pokeapi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {
    ArrayList<item> arrayList;
    Context context;

    public MyAdapter(ArrayList<item> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_view,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        item curr=arrayList.get(position);
        holder.tid.setText("ID : "+""+curr.getId());
        holder.tName.setText("Name : "+curr.getName());
        holder.tBexp.setText("Base Experience : "+curr.getBase_experience());
        holder.tHght.setText("Height :"+curr.getHeight());
        holder.tWght.setText("Weight"+curr.getWeight());
        Picasso.get().load(curr.getUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView tid,tName,tBexp,tHght,tWght;

        public MyHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image);
            tid=itemView.findViewById(R.id.ID);
            tName=itemView.findViewById(R.id.name);
            tBexp=itemView.findViewById(R.id.tbexp);
            tHght=itemView.findViewById(R.id.thgt);
            tWght=itemView.findViewById(R.id.twght);
        }
    }
}
