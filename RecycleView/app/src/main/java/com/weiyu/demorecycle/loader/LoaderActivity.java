package com.weiyu.demorecycle.loader;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.weiyu.demorecycle.DataBean;
import com.weiyu.demorecycle.R;

import java.util.HashMap;

import static android.nfc.tech.MifareUltralight.PAGE_SIZE;

public class LoaderActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private HashMap<String,String> hashMap;
    private MyAdapter adapter;
    private LoaderAdapter loaderAdapter;
    Context context;
    DataBean dataBean = new DataBean();
    private BrvahAdapter brvahAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader);
        hashMap = new DataBean().getMap();
        recyclerView = (RecyclerView)findViewById(R.id.rv_loader);
        adapter = MyAdapter.getAdapter(this,hashMap);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(adapter);
        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.layout_swipe_refresh);
        createAdapter();
    }
    private void createAdapter(){
        brvahAdapter = new BrvahAdapter(R.layout.item_loader,dataBean.getContent(),dataBean.getTitle());
        brvahAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(context,"当前列表项为"+position,Toast.LENGTH_SHORT).show();
            }
        });
        brvahAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override public void onLoadMoreRequested() {
                final int TOTAL_COUNTER = 40;
                recyclerView.postDelayed(new Runnable() {
                    int mCurrentCounter = dataBean.getContent().size();
                    boolean isErr= true;
                    @Override
                    public void run() {
                        if (mCurrentCounter >= TOTAL_COUNTER) {
                            //数据全部加载完毕
                            brvahAdapter.loadMoreEnd();
                        } else {
                            if (isErr) {
                                //成功获取更多数据
                                brvahAdapter.addData(dataBean.getList());
                                mCurrentCounter = brvahAdapter.getData().size();
                                brvahAdapter.loadMoreComplete();
                            } else {
                                //获取更多数据失败
                                isErr = true;
                                Toast.makeText(context, "加载失败", Toast.LENGTH_LONG).show();
                                brvahAdapter.loadMoreFail();

                            }
                        }
                    }

                }, 5000);
            }
        }, recyclerView);
        recyclerView.setAdapter(brvahAdapter);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                brvahAdapter.addData(0,dataBean.getList());
                brvahAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
//        recyclerView.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                swipeRefreshLayout.setRefreshing(true);
//                int num = 1;
//                brvahAdapter.addData(dataBean.getList());
//                brvahAdapter.notifyDataSetChanged();
//            }
//        },5000);
    }
}
