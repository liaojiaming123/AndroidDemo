package com.weiyu.yui.recycler.brvah;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.weiyu.yui.R;

public class BrvahRefreshFragment extends Fragment {
    private Context context;
    private RecyclerView recyclerView;
    private BrvahRefreshAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private DataBean dataBean = new DataBean();

    public BrvahRefreshFragment() {
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
        return inflater.inflate(R.layout.fragment_brvah_refresh, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        recyclerView = (RecyclerView)getView().findViewById(R.id.rv_brvah_refresh);
        swipeRefreshLayout = (SwipeRefreshLayout)getView().findViewById(R.id.refresh_swipe_refresh);
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        setHasOptionsMenu(false);
    }
    private void createVertical(){
        adapter = new BrvahRefreshAdapter(R.layout.item_recycle_simple,dataBean.getStrings(),context);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override public void onLoadMoreRequested() {
                final int TOTAL_COUNTER = 40;
                recyclerView.postDelayed(new Runnable() {
                    int mCurrentCounter = dataBean.getStrings().size();
                    boolean isErr= true;
                    @Override
                    public void run() {
                        if (mCurrentCounter >= TOTAL_COUNTER) {
                            //数据全部加载完毕
                            adapter.loadMoreEnd();
                            Toast.makeText(context, "更新数据"+mCurrentCounter+"条", Toast.LENGTH_LONG).show();
                        } else {
                            if (isErr) {
                                //成功获取更多数据
                                adapter.addData(dataBean.getStrings());
//                                mCurrentCounter = adapter.getData().size();
                                mCurrentCounter = 20;
                                adapter.loadMoreComplete();
                            } else {
                                //获取更多数据失败
                                isErr = true;
                                Toast.makeText(context, "加载失败", Toast.LENGTH_LONG).show();
                                adapter.loadMoreFail();

                            }
                        }
                    }

                }, 5000);
            }
        }, recyclerView);
        recyclerView.setAdapter(adapter);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                adapter.addData(dataBean.getStrings().size(),dataBean.getStrings());
                adapter.notifyDataSetChanged();
                Toast.makeText(context, "加载数据"+dataBean.getStrings().size()+"条", Toast.LENGTH_LONG).show();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
    private void createGrid(){
        adapter = new BrvahRefreshAdapter(R.layout.item_recycle_simple,dataBean.getStrings(),context);
        recyclerView.setLayoutManager(new GridLayoutManager(context,2));
        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override public void onLoadMoreRequested() {
                final int TOTAL_COUNTER = 40;
                recyclerView.postDelayed(new Runnable() {
                    int mCurrentCounter = dataBean.getStrings().size();
                    boolean isErr= true;
                    @Override
                    public void run() {
                        if (mCurrentCounter >= TOTAL_COUNTER) {
                            //数据全部加载完毕
                            adapter.loadMoreEnd();
                            Toast.makeText(context, "更新数据"+mCurrentCounter+"条", Toast.LENGTH_LONG).show();
                        } else {
                            if (isErr) {
                                //成功获取更多数据
                                adapter.addData(dataBean.getStrings());
//                                mCurrentCounter = adapter.getData().size();
                                mCurrentCounter = 20;
                                adapter.loadMoreComplete();
                            } else {
                                //获取更多数据失败
                                isErr = true;
                                Toast.makeText(context, "加载失败", Toast.LENGTH_LONG).show();
                                adapter.loadMoreFail();

                            }
                        }
                    }

                }, 5000);
            }
        }, recyclerView);
        recyclerView.setAdapter(adapter);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                adapter.addData(dataBean.getStrings().size(),dataBean.getStrings());
                adapter.notifyDataSetChanged();
                Toast.makeText(context, "加载数据"+dataBean.getStrings().size()+"条", Toast.LENGTH_LONG).show();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
    private void createStagger(){
        adapter = new BrvahRefreshAdapter(R.layout.item_recycle_simple,dataBean.getStrings(),context);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override public void onLoadMoreRequested() {
                final int TOTAL_COUNTER = 40;
                recyclerView.postDelayed(new Runnable() {
                    int mCurrentCounter = dataBean.getStrings().size();
                    boolean isErr= true;
                    @Override
                    public void run() {
                        if (mCurrentCounter >= TOTAL_COUNTER) {
                            //数据全部加载完毕
                            adapter.loadMoreEnd();
                            Toast.makeText(context, "更新数据"+mCurrentCounter+"条", Toast.LENGTH_LONG).show();
                        } else {
                            if (isErr) {
                                //成功获取更多数据
                                adapter.addData(dataBean.getStrings());
//                                mCurrentCounter = adapter.getData().size();
                                mCurrentCounter = 20;
                                adapter.loadMoreComplete();
                            } else {
                                //获取更多数据失败
                                isErr = true;
                                Toast.makeText(context, "加载失败", Toast.LENGTH_LONG).show();
                                adapter.loadMoreFail();

                            }
                        }
                    }

                }, 5000);
            }
        }, recyclerView);
        recyclerView.setAdapter(adapter);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                adapter.addData(dataBean.getStrings().size(),dataBean.getStrings());
                adapter.notifyDataSetChanged();
                Toast.makeText(context, "加载数据"+dataBean.getStrings().size()+"条", Toast.LENGTH_LONG).show();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
}