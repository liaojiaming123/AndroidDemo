package com.weiyu.demorecycle.decoration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.weiyu.demorecycle.R;

import java.util.ArrayList;
import java.util.List;

public class DecorationActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Context context;

    private MyAdapter adapter;
    SectionAdapter sectionAdapter;
//    private List<MySection> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decoration);
        context = getApplicationContext();
//        data = MySection.getData();
        recyclerView = (RecyclerView)findViewById(R.id.rv_decoration);
//        adapter = new MyAdapter(context,list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(adapter);
//        recyclerView.addItemDecoration(Divider.builder().color(getResources().getColor(R.color.colorPrimary)).width(200).height(3).build());
        createAdapter();
    }
    private void createAdapter(){
        sectionAdapter = new SectionAdapter(R.layout.item_decoration_item,R.layout.item_decoration_city, MySection.getData());
        recyclerView.addItemDecoration(new DividerItemDecoration(context,1));
        recyclerView.setAdapter(sectionAdapter);
    }

}
