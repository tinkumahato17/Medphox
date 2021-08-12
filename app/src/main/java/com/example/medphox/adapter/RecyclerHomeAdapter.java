package com.example.medphox.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medphox.R;
import com.example.medphox.model.ItemModel;

import java.util.ArrayList;

public class RecyclerHomeAdapter extends RecyclerView.Adapter<RecyclerHomeAdapter.MyViewHolder> {
    ArrayList<ItemModel> list;

    public RecyclerHomeAdapter(ArrayList<ItemModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new MyViewHolder(view);
    }


    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ItemModel model = list.get(position);
        holder.name.setText(model.getName());
        holder.price.setText(model.getPrice());
        holder.desc.setText(model.getDescription());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,price,desc;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            desc = itemView.findViewById(R.id.desc);
        }
    }
}

