package com.weiyu.demorecycle.vertical;

import android.content.Context;
import android.os.TokenWatcher;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.weiyu.demorecycle.MyApplication;
import com.weiyu.demorecycle.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 通过继承开源库BRVAH实现的适配器
 * 导入包 implementation 'com.github.CymChad:BaseRecyclerViewAdapterHelper:2.9.47'
 *  maven { url "https://jitpack.io" }
 * */
public class BrvahAdapter extends BaseQuickAdapter {
    private ArrayList<String> data;
    private Context context;
    public BrvahAdapter(int layoutResId, List<String> data) {
        super(layoutResId,data);
        this.data = (ArrayList<String>) data;
        context = MyApplication.getContext();
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, Object item) {
        final int position = helper.getLayoutPosition();
        CardView cardView = (CardView)helper.getView(R.id.cdv);
        TextView textView = (TextView)helper.getView(R.id.tv_vertical);
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
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }
}
