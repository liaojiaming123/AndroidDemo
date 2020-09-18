package com.weiyu.yui.pager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import com.weiyu.yui.R;

public class PagerActivity extends AppCompatActivity implements View.OnClickListener {
    private Context context;
    private Button btnViewFlipperSimple,btnViewPagerSimple;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);
        context = this;
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.hotPink)));//设置actionbar背景
        actionBar.setTitle("翻页视图");
        actionBar.setDisplayHomeAsUpEnabled(true);//设置是否显示返回按钮
        actionBar.setHomeAsUpIndicator(R.mipmap.close);//修改默认返回按钮图片
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().setStatusBarColor(getResources().getColor(R.color.hotPink));//修改状态栏背景
        initView();
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){ //设置返回按钮选择事件
            PagerActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
    private void initView(){
        btnViewFlipperSimple = (Button)findViewById(R.id.btn_view_flipper_simple);
        btnViewFlipperSimple.setOnClickListener(this);
        btnViewPagerSimple = (Button)findViewById(R.id.btn_view_pager_simple);
        btnViewPagerSimple.setOnClickListener(this);
        fragmentManager = getSupportFragmentManager();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_view_flipper_simple:
                fragmentManager.beginTransaction().add(R.id.frame_pager_fragment,
                        new ViewFlipperFragment()).addToBackStack(null).commit();
                break;
            case R.id.btn_view_pager_simple:
                fragmentManager.beginTransaction().add(R.id.frame_pager_fragment,
                        new ViewPagerFragment()).addToBackStack(null).commit();
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}