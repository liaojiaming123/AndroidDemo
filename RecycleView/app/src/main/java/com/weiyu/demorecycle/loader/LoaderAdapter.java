package com.weiyu.demorecycle.loader;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.weiyu.demorecycle.DataBean;
import com.weiyu.demorecycle.R;

import java.util.List;

public class LoaderAdapter extends BaseQuickAdapter<DataBean , BaseViewHolder> {
    public LoaderAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }

    @Override
    public boolean setOnItemLongClick(View v, int position) {
        return super.setOnItemLongClick(v, position);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, DataBean item) {
        int position = helper.getLayoutPosition();
        helper.setText(R.id.tv_loader_title,item.getContent().get(position));
        helper.setText(R.id.tv_loader_content,item.getTitle().get(position));
//        Glide.with(context).load(item.getImage()).into(view);
        helper.addOnClickListener(R.id.tv_loader_content);    //添加子元素点击事件
    }

    @Override
    public void setOnItemClick(View v, int position) {
        super.setOnItemClick(v, position);
    }

}