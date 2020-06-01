package com.weiyu.demorecycle.vertical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.weiyu.demorecycle.R;

import java.util.ArrayList;
import java.util.List;

public class VerticalActivity extends AppCompatActivity {
    private RecyclerView rv_vertical;
    List<String> data = new ArrayList<>();
    RecyclerView.Adapter adapter = new MyAdapter(this,data);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical);
        init();
        rv_vertical = (RecyclerView)findViewById(R.id.btn_vertical);
        rv_vertical.setLayoutManager(new LinearLayoutManager(this));
        rv_vertical.setAdapter(adapter);

    }

    void init(){
        data.add("与其安慰自己平凡可贵，不如拼尽全力活得漂亮。");
        data.add("这世界总有人在笨拙地爱着你，想把全部的温柔都给你。");
        data.add("陪伴本来就是这世界上最了不起的安慰。");
        data.add("长不过执念，短不过善变。");
        data.add("无论多么艰难的现在，终会翻篇。朝未来大步向前吧，别丧，别止步。");
        data.add("希望下一次，能喜欢上一个也喜欢自己的人。");
        data.add("这个世界上，有些人有多冷漠，有些人就有多温暖，希望你总会遇到那些温暖对你的人。");
        data.add("以前对你的喜欢，是见你，念你，陪伴你。现在对你的喜欢，是不问，不看，不叨扰。");
        data.add("只要结局是喜剧，过程你要我怎么哭都行，幸福可以来的慢一些，只要它是真的，如果最后能在一起，晚点我真的无所谓的。");
        data.add("若不是情深似海，思念又怎会泛滥成灾。");
        data.add("与其安慰自己平凡可贵，不如拼尽全力活得漂亮。");
        data.add("这世界总有人在笨拙地爱着你，想把全部的温柔都给你。");
        data.add("陪伴本来就是这世界上最了不起的安慰。");
        data.add("长不过执念，短不过善变。");
        data.add("无论多么艰难的现在，终会翻篇。朝未来大步向前吧，别丧，别止步。");
        data.add("希望下一次，能喜欢上一个也喜欢自己的人。");
        data.add("这个世界上，有些人有多冷漠，有些人就有多温暖，希望你总会遇到那些温暖对你的人。");
        data.add("以前对你的喜欢，是见你，念你，陪伴你。现在对你的喜欢，是不问，不看，不叨扰。");
        data.add("只要结局是喜剧，过程你要我怎么哭都行，幸福可以来的慢一些，只要它是真的，如果最后能在一起，晚点我真的无所谓的。");
        data.add("若不是情深似海，思念又怎会泛滥成灾。");
    }


}
