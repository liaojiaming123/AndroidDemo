package com.weiyu.demorecycle.click;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.weiyu.demorecycle.R;

import java.util.List;

class InterfaceMyAdapter extends RecyclerView.Adapter {
    private List<String> list;
    private Context context;
    private OnItemClick onItemClick;
    public interface OnItemClick{
        void onItemClick(int i);
    }

    public InterfaceMyAdapter(){
    }
    public InterfaceMyAdapter(Context context, List<String> list,OnItemClick itemClick){
        this.context = context;
        this.list = list;
        this.onItemClick = itemClick;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.tv_horizontal);
        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horizontal,null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder)holder;
        viewHolder.textView.setText(list.get(position));
        //通过接口设置点击事件
        viewHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick.onItemClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
