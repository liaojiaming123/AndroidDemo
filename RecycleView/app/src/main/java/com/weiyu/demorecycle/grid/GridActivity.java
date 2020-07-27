package com.weiyu.demorecycle.grid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.weiyu.demorecycle.R;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<String> data =new ArrayList<>();
    private void initData(){
        data.add("好事多磨 平安喜乐");
        data.add("幸与不幸 都有尽头");
        data.add("出言有尺 嬉闹有度");
        data.add("山河拱手 为君一笑");
        data.add("春晓酒醒 芬芳何寻");
        data.add("顾眸流盼 几许缠绵");
        data.add("静水流深 沧笙踏歌");
        data.add("繁星落城 慢若浮光");
        data.add("向来缘浅 奈何情深");
        data.add("扶摇万里 笑对流年");
        data.add("浮生若梦 一晌贪欢");
        data.add("红尘初妆 山河无疆");
        data.add("无快无乐 无趣无你");
        data.add("山水万程 皆要好运");
        data.add("死心塌地 一败糊涂");
        data.add("迷途漫漫 终有一归");
        data.add("山中有眠 枕的是月");
        data.add("人的慣性 太過期待");
        data.add("生而为人 喜善并存");
        data.add("往日不悔 來日可期");
        data.add("难满是欲 难遇是你");
        data.add("昨日种种 皆成今我");
        data.add("保持分寸 时常理性");
        data.add("煎雪落雨 心上有你");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        recyclerView = (RecyclerView)findViewById(R.id.btn_grid);
        initData();
        RecyclerView.Adapter adapter = new MyAdapter(this,data);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        brvahAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(GridActivity.this,"当前列表项为"+position,Toast.LENGTH_SHORT).show();
            }
        });
//        recyclerView.setAdapter(adapter);
        recyclerView.setAdapter(brvahAdapter);
    }
    BrvahAdapter brvahAdapter = new BrvahAdapter(R.layout.item_grid,data);
}
