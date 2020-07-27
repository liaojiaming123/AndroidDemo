package com.weiyu.demorecycle.decoration;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.weiyu.demorecycle.MyApplication;
import com.weiyu.demorecycle.R;

import java.util.ArrayList;
import java.util.List;

public class SectionAdapter extends BaseSectionQuickAdapter<MySection,BaseViewHolder> {
//    ArrayList<MyData> data;
//    private MySection MySection;
    private Context context;
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param layoutResId      The layout resource id of each item.
     * @param sectionHeadResId The section head layout id for each item
     * @param data             A new list is created out of this one to avoid mutable list
     */
    public SectionAdapter(int layoutResId, int sectionHeadResId, List<MySection> data) {
        super(layoutResId, sectionHeadResId, data);
        this.context = MyApplication.getContext();
    }

    @Override
    protected void convertHead(BaseViewHolder helper, final MySection item) {
        TextView textView = helper.getView(R.id.tv_decoration_city);
        final int position = helper.getLayoutPosition();
        textView.setText(item.header);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,item.header+position,Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, final MySection item) {
        final int position = helper.getLayoutPosition();
        TextView textView = helper.getView(R.id.tv_decoration_item);
//        textView.setText(item.t.getItemList().get(position));
        textView.setText(item.t);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,item.t+position,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
