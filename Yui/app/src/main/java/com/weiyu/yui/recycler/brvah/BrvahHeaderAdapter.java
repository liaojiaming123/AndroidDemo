package com.weiyu.yui.recycler.brvah;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.weiyu.yui.R;

import java.util.ArrayList;
import java.util.List;

public class BrvahHeaderAdapter extends BaseQuickAdapter {

    private ArrayList<String> data;
    private Context context;
    public BrvahHeaderAdapter(int layoutResId, List<String> data, Context context) {
        super(layoutResId,data);
        this.data = (ArrayList<String>) data;
        this.context = context;
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, Object item) {
        final int position = helper.getLayoutPosition()-1;
        final int num = helper.getLayoutPosition();
        CardView cardView = (CardView)helper.getView(R.id.cardview_recycler_simple);
        TextView textView = (TextView)helper.getView(R.id.tv_item_recycler_simple);
        textView.setText(data.get(position));
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,data.get(position),Toast.LENGTH_SHORT).show();
            }
        });
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"当前列表项为"+position,Toast.LENGTH_SHORT).show();
            }
        });
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"当前列表项为"+num,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }
}

