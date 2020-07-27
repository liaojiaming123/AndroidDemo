package com.weiyu.demorecycle.loader;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.weiyu.demorecycle.MyApplication;
import com.weiyu.demorecycle.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 通过继承开源库BRVAH实现的适配器
 * 导入包 implementation 'com.github.CymChad:BaseRecyclerViewAdapterHelper:2.9.47'
 *  maven { url "https://jitpack.io" }
 * */
public class BrvahAdapter extends BaseQuickAdapter implements BaseQuickAdapter.RequestLoadMoreListener{
    private ArrayList<String> data;
    private ArrayList<String> list;
    private Context context;
    public BrvahAdapter(int layoutResId, List<String> data, List<String> list) {
        super(layoutResId,data);
        this.data = (ArrayList<String>) data;
        this.list = (ArrayList<String>) list;
        context = MyApplication.getContext();
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, Object item) {
        final int position = helper.getLayoutPosition();
        TextView textView = (TextView)helper.getView(R.id.tv_loader_content);
//        TextView title = (TextView)helper.getView(R.id.tv_loader_title);
        textView.setText(position+". "+data.get(position));
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,data.get(position),Toast.LENGTH_SHORT).show();
            }
        });
//        title.setText("--"+list.get(position));
//        title.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context,list.get(position),Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public void onLoadMoreRequested() {

    }
}
