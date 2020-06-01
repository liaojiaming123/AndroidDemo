package com.weiyu.demorecycle.grid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.weiyu.demorecycle.R;

import java.util.List;

class MyAdapter extends RecyclerView.Adapter {
    private List<String> list;
    private Context context;

    public MyAdapter(Context context,List<String> list){
        this.context = context;
        this.list = list;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.tv_grid);
        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid,parent,false));
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
