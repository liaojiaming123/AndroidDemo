package com.weiyu.demorecycle.drag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import com.weiyu.demorecycle.DataBean;
import com.weiyu.demorecycle.R;

import java.util.ArrayList;
import java.util.List;

public class DragActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Context context;
    private List<String> mList = new ArrayList<>();
    private List<String> data = new ArrayList<>();
    private DragAdapter dragAdapter;
    DataBean dataBean = new DataBean();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag);
        data = dataBean.getContent();
        mList = dataBean.getTitle();
        context = getApplicationContext();
        recyclerView = (RecyclerView)findViewById(R.id.rv_drag);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setAdapter(groupAdapter);
        createAdapter();
        recyclerView.setAdapter(dragAdapter);
    }

    private void createAdapter(){
        dragAdapter = new DragAdapter(data,mList);
        ItemDragAndSwipeCallback callback = new ItemDragAndSwipeCallback(dragAdapter);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(recyclerView);
        dragAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(context,"当前列表项为"+position,Toast.LENGTH_SHORT).show();
            }
        });

        // 开启滑动删除
        dragAdapter.enableSwipeItem();
        dragAdapter.setOnItemSwipeListener(onItemSwipeListener);

        // 开启拖拽
        dragAdapter.enableDragItem(helper, R.id.tv_drag_content, true);
        dragAdapter.setOnItemDragListener(onItemDragListener);
    }
    OnItemDragListener onItemDragListener = new OnItemDragListener() {
        @Override
        public void onItemDragStart(RecyclerView.ViewHolder viewHolder, int pos){}
        @Override
        public void onItemDragMoving(RecyclerView.ViewHolder source, int from, RecyclerView.ViewHolder target, int to) {}
        @Override
        public void onItemDragEnd(RecyclerView.ViewHolder viewHolder, int pos) {}
    };

    OnItemSwipeListener onItemSwipeListener = new OnItemSwipeListener() {
        @Override
        public void onItemSwipeStart(RecyclerView.ViewHolder viewHolder, int pos) {}
        @Override
        public void clearView(RecyclerView.ViewHolder viewHolder, int pos) {}
        @Override
        public void onItemSwiped(RecyclerView.ViewHolder viewHolder, int pos) {}

        @Override
        public void onItemSwipeMoving(Canvas canvas, RecyclerView.ViewHolder viewHolder, float v, float v1, boolean b) {

        }
    };
}
