package com.weiyu.demorecycle.stagger;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
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
        helper.addOnClickListener(R.id.img_stagger);
        TextView textView = (TextView)helper.getView(R.id.tv_stagger);
        textView.setText(data.get(position));
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,data.get(position),Toast.LENGTH_SHORT).show();
            }
        });
    }

}

