package com.weiyu.demorecycle.horizontal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.weiyu.demorecycle.R;

import java.util.ArrayList;
import java.util.List;

public class HorizontalActivity extends AppCompatActivity {
    private RecyclerView rv_horizontal;
    private Context context;
    List<String> data = new ArrayList<>();
    RecyclerView.Adapter adapter = new MyAdapter(this, data, new MyAdapter.ItemClick() {
        @Override
        public void onItemClick(int i) {
            String string = data.get(i);
            Toast.makeText(context,string,Toast.LENGTH_SHORT).show();
        }
    });
    private void initData(){
        data.add("首页");
        data.add("电影");
        data.add("电视剧");
        data.add("音乐");
        data.add("短视频");
        data.add("新闻");
        data.add("游戏");
        data.add("专题");
    }

    BrvahAdapter brvahAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal);
        context = getApplicationContext();
        initData();
        brvahAdapter = new BrvahAdapter(R.layout.item_horizontal, (ArrayList<String>) data);
        rv_horizontal = (RecyclerView)findViewById(R.id.btn_horizontal);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);//水平布局
        rv_horizontal.setLayoutManager(linearLayoutManager);
//        rv_horizontal.setAdapter(adapter);
        rv_horizontal.setAdapter(brvahAdapter);
    }

}
