package com.weiyu.demorecycle.stagger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.weiyu.demorecycle.DataBean;
import com.weiyu.demorecycle.R;

import java.util.ArrayList;
import java.util.List;

public class StaggerActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    List<String> data = new ArrayList<>();
    DataBean dataBean = new DataBean();
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stagger);
        context = getApplicationContext();
        data = dataBean.getList();
        recyclerView = (RecyclerView)findViewById(R.id.btn_stagger);
        RecyclerView.Adapter adapter = new MyAdapter(this,data);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
//        recyclerView.setAdapter(adapter);
        createAdapter();
    }
    private void createAdapter(){
        BrvahAdapter brvahAdapter = new BrvahAdapter(R.layout.item_stagger, data);
        brvahAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(context,"当前列表项为"+position,Toast.LENGTH_SHORT).show();
            }
        });
        brvahAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(context,"图片点击事件被触发",Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(brvahAdapter);
    }
}
