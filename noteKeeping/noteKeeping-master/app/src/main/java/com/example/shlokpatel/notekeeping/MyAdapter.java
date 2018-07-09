package com.example.shlokpatel.notekeeping;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder>{
    ArrayList<field> arrayList;
    Context context;
    public MyAdapter(ArrayList<field> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater lif = LayoutInflater.from(context);
        View inflatedView = lif.inflate(R.layout.itemlayout,parent,false);
        return new MyHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, int position) {
        final field current=arrayList.get(position);
        holder.textView.setText(current.getText());
        holder.date.setText(current.getDate());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(current.getPrior()){

                    case 0:
                        holder.itemView.setBackgroundColor(Color.parseColor("#BDBDBD")); //grey
                    case 1:
                        holder.itemView.setBackgroundColor(Color.parseColor("#FF8A65")); //red
                    case 2:
                        holder.itemView.setBackgroundColor(Color.parseColor("#FFF176")); //yellow
                    case 3:
                        holder.itemView.setBackgroundColor(Color.parseColor("#81C784")); //green

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        TextView textView,date;

        int counter=0;
        public MyHolder(final View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.text);
            date=itemView.findViewById(R.id.date);
            if(counter==0) {
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        counter++;
                        arrayList.get(getAdapterPosition()).getPrior()=counter;
                        ((CardView) itemView).setCardBackgroundColor(Color.parseColor("#FF8A65"));
                        notifyDataSetChanged();
                    }
                });
            }
            else if(counter==1){
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        counter++;
                        arrayList.get(getAdapterPosition()).getPrior()=counter;
                        ((CardView)itemView).setCardBackgroundColor(Color.parseColor("#FFF176"));
                        notifyDataSetChanged();
                    }
                });
            }
            else if(counter==2){
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        counter=0;
                        arrayList.get(getAdapterPosition()).getPrior()=counter;
                        ((CardView)itemView).setCardBackgroundColor(Color.parseColor("#81C784"));
                        notifyDataSetChanged();
                    }
                });
            }


            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    arrayList.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                    notifyItemRangeChanged(getAdapterPosition(),arrayList.size());
                    return true;
                }
            });
        }
    }
}
