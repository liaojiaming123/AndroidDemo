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

import com.weiyu.yui.R;

import java.util.ArrayList;
import java.util.List;

public class BrvahSimpleFragment extends Fragment {
    private Context context;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private DataBean dataBean = new DataBean();

    public BrvahSimpleFragment() {
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
        return inflater.inflate(R.layout.fragment_brvah_simple, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        recyclerView = (RecyclerView)getView().findViewById(R.id.rv_brvah_simple);
        createVertical();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        MenuInflater menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.recycler_simple_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.recycler_simple_orientation:
                Toast.makeText(context,"请选择布局",Toast.LENGTH_SHORT).show();
                break;
            case R.id.vertical:
                createVertical();
                break;
            case R.id.horizontal:
                createHorizontal();
                break;
            case R.id.grid:
                createGrid();
                break;
            case R.id.stagger:
                createStagger();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
    private void createVertical(){
        adapter = new BrvahSimpleAdapter(R.layout.item_recycle_simple,dataBean.getStrings(),context);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);
    }
    private void createHorizontal(){
        adapter = new BrvahSimpleAdapter(R.layout.item_recycle_simple,dataBean.getChars(),context);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
    private void createGrid(){
        adapter = new BrvahSimpleAdapter(R.layout.item_recycle_simple,dataBean.getStrings(),context);
        recyclerView.setLayoutManager(new GridLayoutManager(context,2));
        recyclerView.setAdapter(adapter);
    }
    private void createStagger(){
        adapter = new BrvahSimpleAdapter(R.layout.item_recycle_simple,dataBean.getStrings(),context);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        setHasOptionsMenu(false);
    }
}