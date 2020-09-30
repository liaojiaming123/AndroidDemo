package com.weiyu.yhelper.permission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.weiyu.yhelper.R;

public class PermActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perm);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorAccent)));//设置actionbar背景
        actionBar.setTitle("权限管理");
        actionBar.setDisplayHomeAsUpEnabled(true);//设置是否显示返回按钮
        actionBar.setHomeAsUpIndicator(R.mipmap.close);//修改默认返回按钮图片
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorAccent));//修改状态栏背景

        FragmentManager fragmentManager = getSupportFragmentManager();
        PermFragment baseFragment = new PermFragment();
        fragmentManager.beginTransaction().add(R.id.frame_perm_fragment,baseFragment).commit();//动态添加fragment
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){ //设置返回按钮选择事件
            PermActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

}