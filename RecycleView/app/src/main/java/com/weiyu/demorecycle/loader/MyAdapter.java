package com.weiyu.demorecycle.loader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.weiyu.demorecycle.DataBean;
import com.weiyu.demorecycle.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MyAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<String> title = new ArrayList<>();
    private List<String> content = new ArrayList<>();
    private HashMap<String,String> hashMap;
    public static MyAdapter getAdapter(Context context, HashMap<String,String> hashMap){
        return new MyAdapter(context, hashMap);
    }
    private void init(){
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            content.add(entry.getValue());
            title.add(entry.getKey());
        }
    }
    public void add(HashMap<String,String> hashMap){
        this.hashMap.putAll(hashMap);
//        notifyDataSetChanged();
    }
    public void add(String title,String content){
        hashMap.put(title,content);
//        notifyDataSetChanged();
    }

    public MyAdapter(Context context, HashMap<String,String> hashMap){
        this.context = context;
        this.hashMap = hashMap;
        init();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_content;
        private TextView tv_title;
        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_content = (TextView)itemView.findViewById(R.id.tv_loader_content);
            tv_title = (TextView)itemView.findViewById(R.id.tv_loader_title);
        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loader,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final MyViewHolder myViewHolder = (MyViewHolder)holder;
        int num = position+1;
        myViewHolder.tv_title.setText("--"+title.get(position));
        myViewHolder.tv_content.setText(num+content.get(position));
        myViewHolder.tv_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,content.get(position),Toast.LENGTH_SHORT).show();
            }
        });
        myViewHolder.tv_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,title.get(position),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return content.size();
    }
}

