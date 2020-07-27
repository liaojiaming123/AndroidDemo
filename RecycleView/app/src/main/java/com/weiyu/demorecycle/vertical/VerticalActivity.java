package com.weiyu.demorecycle.vertical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.weiyu.demorecycle.DataBean;
import com.weiyu.demorecycle.R;

import java.util.ArrayList;
import java.util.List;

public class VerticalActivity extends AppCompatActivity {
    List<String> data = new ArrayList<>();
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical);
        data = new DataBean().getList();
        adapter = new MyAdapter(this,data);
        brvahAdapter = new BrvahAdapter(R.layout.item_vertical, data);
        RecyclerView rv_vertical = (RecyclerView) findViewById(R.id.btn_vertical);
        rv_vertical.setLayoutManager(new LinearLayoutManager(this));
//        rv_vertical.setAdapter(adapter);
        rv_vertical.setAdapter(brvahAdapter);
    }

    BrvahAdapter brvahAdapter;
}
