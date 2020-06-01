package com.weiyu.demorecycle.click;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.weiyu.demorecycle.R;

import java.util.ArrayList;
import java.util.List;

class MyAdapter extends RecyclerView.Adapter {
    List<String> list = new ArrayList<>();
    Context context;

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
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        final ViewHolder viewHolder = (ViewHolder)holder;

        //直接在Adapter内部对控件做点击事件
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"这是列表"+position,Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,viewHolder.textView.getText(),Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.textView.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}