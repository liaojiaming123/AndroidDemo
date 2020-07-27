package com.weiyu.demorecycle.header;

import android.content.Context;
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
    private ArrayList<String> list;
    private Context context;
    public BrvahAdapter(int layoutResId, List<String> data,List<String> list) {
        super(layoutResId,data);
        this.data = (ArrayList<String>) data;
        this.list = (ArrayList<String>) list;
        context = MyApplication.getContext();
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, Object item) {
        final int position = helper.getLayoutPosition()-1;
        final int num = helper.getLayoutPosition();
        CardView cardView = (CardView)helper.getView(R.id.cdv_header);
        TextView textView = (TextView)helper.getView(R.id.tv_header);
        TextView title = (TextView)helper.getView(R.id.tv_header_title);
        textView.setText(position+". "+data.get(position));
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,data.get(position),Toast.LENGTH_SHORT).show();
            }
        });
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"当前列表项为"+num,Toast.LENGTH_SHORT).show();
            }
        });
        title.setText("--"+list.get(position));
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,list.get(position),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }
}
