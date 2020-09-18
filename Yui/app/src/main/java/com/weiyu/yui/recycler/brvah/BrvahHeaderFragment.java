package com.weiyu.yui.recycler.brvah;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.weiyu.yui.R;

import java.util.ArrayList;
import java.util.List;

public class BrvahHeaderFragment extends Fragment {
    private Context context;
    private RecyclerView recyclerView;
    private BaseQuickAdapter adapter;
    private View headerView,footerView;
    private DataBean dataBean = new DataBean();

    public BrvahHeaderFragment() {
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
        return inflater.inflate(R.layout.fragment_brvah_header, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        recyclerView = (RecyclerView)getView().findViewById(R.id.rv_brvah_header);
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
        adapter = new BrvahHeaderAdapter(R.layout.item_recycle_simple,dataBean.getStrings(),context);
        headerView = LayoutInflater.from(context).inflate(R.layout.brvah_header_view,null,false);
        footerView = LayoutInflater.from(context).inflate(R.layout.brvah_footer_view,null,false);
        headerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"点击了HeaderView",Toast.LENGTH_SHORT).show();
            }
        });
        footerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"点击了FooterView",Toast.LENGTH_SHORT).show();
            }
        });
        adapter.addHeaderView(headerView);
        adapter.addFooterView(footerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);
    }
    private void createGrid(){
        adapter = new BrvahHeaderAdapter(R.layout.item_recycle_simple,dataBean.getStrings(),context);
        headerView = LayoutInflater.from(context).inflate(R.layout.brvah_header_view,null,false);
        footerView = LayoutInflater.from(context).inflate(R.layout.brvah_footer_view,null,false);
        headerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"点击了HeaderView",Toast.LENGTH_SHORT).show();
            }
        });
        footerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"点击了FooterView",Toast.LENGTH_SHORT).show();
            }
        });
        adapter.addHeaderView(headerView);
        adapter.addFooterView(footerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,2));
        recyclerView.setAdapter(adapter);
    }
    private void createStagger(){
        adapter = new BrvahHeaderAdapter(R.layout.item_recycle_simple,dataBean.getStrings(),context);
        headerView = LayoutInflater.from(context).inflate(R.layout.brvah_header_view,null,false);
        footerView = LayoutInflater.from(context).inflate(R.layout.brvah_footer_view,null,false);
        headerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"点击了HeaderView",Toast.LENGTH_SHORT).show();
            }
        });
        footerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"点击了FooterView",Toast.LENGTH_SHORT).show();
            }
        });
        adapter.addHeaderView(headerView);
        adapter.addFooterView(footerView);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        setHasOptionsMenu(false);
    }
}