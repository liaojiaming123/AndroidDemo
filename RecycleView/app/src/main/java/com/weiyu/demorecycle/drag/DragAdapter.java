package com.weiyu.demorecycle.drag;

import android.content.Context;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import com.weiyu.demorecycle.DataBean;
import com.weiyu.demorecycle.MyApplication;
import com.weiyu.demorecycle.R;

import java.util.ArrayList;
import java.util.List;

public class DragAdapter extends BaseItemDraggableAdapter<String, BaseViewHolder>{
    private Context mContext;
    private List<String> data = new ArrayList<>();
    private List<String> list = new ArrayList<>();

    public DragAdapter(List data,List list) {
        super(R.layout.item_drag,data);
        this.data = data;
        this.list = list;
        this.mContext = MyApplication.getContext();
    }
    @Override
    protected void convert(@NonNull BaseViewHolder helper, String item) {
        final int position = helper.getLayoutPosition();
        TextView textView = helper.getView(R.id.tv_drag_content);
        TextView title = helper.getView(R.id.tv_drag_title);
        title.setText("--"+list.get(position));
        textView.setText(position+". "+data.get(position));
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,data.get(position),Toast.LENGTH_SHORT).show();
            }
        });
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,list.get(position),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
