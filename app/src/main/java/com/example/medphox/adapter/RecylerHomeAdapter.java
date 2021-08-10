package com.example.medphox.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class RecyclerHomeAdapter extends RecyclerView.Adapter<RecyclerHomeAdapter.MyviewHolder>{
    ArrayList

    @NonNull
    @Override
    public RecyclerHomeAdapter.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHomeAdapter.MyviewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MyviewHolder extends RecyclerView.ViewHolder{

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
