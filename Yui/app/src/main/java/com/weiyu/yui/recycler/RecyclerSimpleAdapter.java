package com.weiyu.yui.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.weiyu.yui.R;

import java.util.List;

public class RecyclerSimpleAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<String> strings;
    public RecyclerSimpleAdapter(Context context,List<String> strings){
        this.context = context;
        this.strings = strings;
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.cardview_recycler_simple);
            textView = (TextView)itemView.findViewById(R.id.tv_item_recycler_simple);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recycle_simple,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.textView.setText(strings.get(position));
        viewHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,strings.get(position),Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"当前列表项为："+position,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return strings.size();
    }
}
