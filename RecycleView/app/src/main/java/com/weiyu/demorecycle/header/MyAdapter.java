package com.weiyu.demorecycle.header;

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

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {
    Context context;
    private List<String> list;
    public MyAdapter(Context context, List<String> list){
        this.context = context;
        this.list = list;
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        private TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.cdv_header);
            textView = (TextView)itemView.findViewById(R.id.tv_header);
        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final MyViewHolder myViewHolder = (MyViewHolder)holder;
        myViewHolder.textView.setText(list.get(position));
        final int num = position+1;
        myViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"点击了"+num+"项",Toast.LENGTH_SHORT).show();
            }
        });
        myViewHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,list.get(position),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
