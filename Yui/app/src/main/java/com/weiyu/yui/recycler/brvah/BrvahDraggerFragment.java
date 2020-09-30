package com.weiyu.yui.recycler.brvah;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import com.weiyu.yui.R;

public class BrvahDraggerFragment extends Fragment {
    private Context context;
    private RecyclerView recyclerView;
    private BrvahDraggerAdapter adapter;
    private DataBean dataBean = new DataBean();
    public BrvahDraggerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_brvah_dragger, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        recyclerView = (RecyclerView)getView().findViewById(R.id.rv_brvah_dragger);
        createVertical();
    }
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        MenuInflater menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.brvah_header,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.brvah_:
                break;
            case R.id.brvah_vertical:
                createVertical();
                break;
            case R.id.brvah_grid:
                createGrid();
                break;
            case R.id.brvah_stagger:
                createStagger();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void createVertical(){
        adapter = new BrvahDraggerAdapter(R.layout.item_recycle_simple,dataBean.getStrings(),context);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        ItemDragAndSwipeCallback callback = new ItemDragAndSwipeCallback(adapter);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(recyclerView);
        // 开启滑动删除
        adapter.enableSwipeItem();
        adapter.setOnItemSwipeListener(onItemSwipeListener);
        // 开启拖拽
        adapter.enableDragItem(helper, R.id.tv_item_recycler_simple, true);
        adapter.setOnItemDragListener(onItemDragListener);
        recyclerView.setAdapter(adapter);
    }
    private void createGrid(){
        adapter = new BrvahDraggerAdapter(R.layout.item_recycle_simple,dataBean.getStrings(),context);
        recyclerView.setLayoutManager(new GridLayoutManager(context,2));
        ItemDragAndSwipeCallback callback = new ItemDragAndSwipeCallback(adapter);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(recyclerView);
        // 开启拖拽
        adapter.enableDragItem(helper, R.id.tv_item_recycler_simple, true);
        adapter.setOnItemDragListener(onItemDragListener);
        recyclerView.setAdapter(adapter);
    }
    private void createStagger(){
        adapter = new BrvahDraggerAdapter(R.layout.item_recycle_simple,dataBean.getStrings(),null);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        ItemDragAndSwipeCallback callback = new ItemDragAndSwipeCallback(adapter);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(recyclerView);
        // 开启拖拽
        adapter.enableDragItem(helper, R.id.tv_item_recycler_simple, true);
        adapter.setOnItemDragListener(onItemDragListener);
        recyclerView.setAdapter(adapter);
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        setHasOptionsMenu(false);
    }
}