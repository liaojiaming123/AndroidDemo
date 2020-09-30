package com.weiyu.yhelper.data;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.WindowManager;

import com.weiyu.yhelper.R;

public class DataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorAccent)));//设置actionbar背景
        actionBar.setTitle("数据存储");
        actionBar.setDisplayHomeAsUpEnabled(true);//设置是否显示返回按钮
        actionBar.setHomeAsUpIndicator(R.mipmap.close);//修改默认返回按钮图片
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorAccent));//修改状态栏背景
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.frame_data_fragment,new DataFragment()).commit();
    }
}