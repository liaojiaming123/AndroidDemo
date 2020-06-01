package com.weiyu.demorecycle.stagger;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.weiyu.demorecycle.R;

import java.util.Arrays;
import java.util.List;

class MyAdapter extends RecyclerView.Adapter {
    private List<String> list;
    private Context context;

    public MyAdapter(Context context){
        this.context = context;
    }

    public MyAdapter(Context context,List<String> list){
        this.context = context;
        this.list = list;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private Layout layout;
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.image_stagger);
            textView = (TextView)itemView.findViewById(R.id.tv_stagger);
//            layout = (Layout)itemView.findViewById(R.layout.item_stagger);
        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_stagger,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
//        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_stagger,parent,false));
    }
    int random = (int) Math.round(Math.random()*100);
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ViewHolder viewHolder = (ViewHolder)holder;
        viewHolder.textView.setHeight(random);

    }

    @Override
    public int getItemCount() {
        return 50;
    }
}