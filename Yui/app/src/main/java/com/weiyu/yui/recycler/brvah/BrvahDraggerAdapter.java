package com.weiyu.yui.recycler.brvah;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.weiyu.yui.R;

import java.util.List;

public class BrvahDraggerAdapter extends BaseItemDraggableAdapter<String, BaseViewHolder> {
    private List<String> data;
    private Context context;
    public BrvahDraggerAdapter(int layoutResId, List<String> data,Context context) {
        super(layoutResId, data);
        this.context = context;
        this.data = data;
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, String item) {
        final int position = helper.getLayoutPosition();
        CardView cardView = (CardView)helper.getView(R.id.cardview_recycler_simple);
        TextView textView = (TextView)helper.getView(R.id.tv_item_recycler_simple);
        textView.setText(position+" ."+data.get(position));
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
}
