package com.weiyu.yui.recycler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.weiyu.yui.R;
import com.weiyu.yui.recycler.brvah.BrvahActivity;
import com.weiyu.yui.recycler.brvah.BrvahFragment;

public class RecyclerActivity extends AppCompatActivity implements View.OnClickListener {
    private Context context;
    private Button btnRecyclerViewSimple,btnBrvah;
    private FragmentManager fragmentManager;
    public ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        context = this;
        actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.fuchsia)));//设置actionbar背景
        actionBar.setTitle("列表视图");
        actionBar.setDisplayHomeAsUpEnabled(true);//设置是否显示返回按钮
        actionBar.setHomeAsUpIndicator(R.mipmap.close);//修改默认返回按钮图片
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().setStatusBarColor(getResources().getColor(R.color.fuchsia));//修改状态栏背景
        initView();
    }
    private void initView(){
        fragmentManager = getSupportFragmentManager();
        btnRecyclerViewSimple = (Button)findViewById(R.id.btn_recycler_view_simple);
        btnRecyclerViewSimple.setOnClickListener(this);
        btnBrvah = (Button)findViewById(R.id.btn_brvah);
        btnBrvah.setOnClickListener(this);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){ //设置返回按钮选择事件
            RecyclerActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_recycler_view_simple:
                fragmentManager.beginTransaction().add(R.id.frame_recycler_fragment,
                        new RecyclerSimpleFragment()).addToBackStack(null).commit();
                break;
            case R.id.btn_brvah:
                startActivity(new Intent(context,BrvahActivity.class));
//                fragmentManager.beginTransaction().add(R.id.frame_recycler_fragment,
//                        new BrvahFragment()).addToBackStack(null).commit();
                break;
        }
    }
}