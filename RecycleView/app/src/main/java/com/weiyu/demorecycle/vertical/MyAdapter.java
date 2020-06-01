package com.weiyu.demorecycle.vertical;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.weiyu.demorecycle.R;

import java.util.ArrayList;
import java.util.List;

class MyAdapter extends RecyclerView.Adapter {
    List<String> list = new ArrayList<>();
    Context context;

    public MyAdapter(){}
    public MyAdapter(Context context,List<String> list){
        this.context = context;
        this.list = list;

    }

    public void setList(List<String> list) {
        this.list = list;
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.cdv);
            textView = (TextView)itemView.findViewById(R.id.tv_vertical);
        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vertical,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder)holder;
        viewHolder.textView.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}