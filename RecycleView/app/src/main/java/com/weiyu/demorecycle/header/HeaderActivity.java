package com.weiyu.demorecycle.header;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.weiyu.demorecycle.DataBean;
import com.weiyu.demorecycle.R;

import java.util.ArrayList;
import java.util.List;

public class HeaderActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Context context;
    private View headerView;
    private View footerView;
    MyAdapter myAdapter;
    HeaderAdapter headerAdapter;
    DataBean dataBean = new DataBean();
    BrvahAdapter brvahAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header);
        context = HeaderActivity.this;
        List<String> data = dataBean.getList();
        myAdapter = new MyAdapter(context, data);
        headerAdapter = new HeaderAdapter(myAdapter);
        recyclerView = (RecyclerView) findViewById(R.id.btn_header);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        headerView = LayoutInflater.from(context).inflate(R.layout.header_view, recyclerView,false);
        footerView = LayoutInflater.from(context).inflate(R.layout.footer_view, recyclerView,false);

//        headerAdapter.addFooterView(footerView);
//        headerAdapter.addHeaderView(headerView);
//        recyclerView.setAdapter(headerAdapter);
        createAdapter();
    }
    private void createAdapter(){
        brvahAdapter = new BrvahAdapter(R.layout.item_header,dataBean.getContent(),dataBean.getTitle());
        brvahAdapter.addHeaderView(headerView);
        brvahAdapter.addFooterView(footerView);
        recyclerView.setAdapter(brvahAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        footerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                brvahAdapter.addHeaderView(footerView,1);
                Toast.makeText(context,"点击了footerView",Toast.LENGTH_SHORT).show();
            }
        });
        headerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                brvahAdapter.addHeaderView(headerView);
                Toast.makeText(context,"点击了headerView",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
