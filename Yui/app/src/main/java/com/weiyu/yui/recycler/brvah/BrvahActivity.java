package com.weiyu.yui.recycler.brvah;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.WindowManager;

import com.weiyu.yui.R;
import com.weiyu.yui.recycler.RecyclerActivity;

public class BrvahActivity extends AppCompatActivity {
    private Context context;
    private FragmentManager fragmentManager;
    public ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brvah);
        context = this;
        actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.fuchsia)));//设置actionbar背景
        actionBar.setTitle("BRVAH");
        actionBar.setDisplayHomeAsUpEnabled(true);//设置是否显示返回按钮
        actionBar.setHomeAsUpIndicator(R.mipmap.back);//修改默认返回按钮图片
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().setStatusBarColor(getResources().getColor(R.color.fuchsia));//修改状态栏背景
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.frame_brvah,new BrvahSimpleFragment()).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.brvah_activity,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                BrvahActivity.this.finish();
                break;
            case R.id.brvah_layout:
                fragmentManager.beginTransaction().replace(R.id.frame_brvah,new BrvahSimpleFragment()).commit();
                break;
            case R.id.brvah_header:
                fragmentManager.beginTransaction().replace(R.id.frame_brvah,new BrvahHeaderFragment()).commit();
                break;
            case R.id.brvah_refresh:
                fragmentManager.beginTransaction().replace(R.id.frame_brvah,new BrvahRefreshFragment()).commit();
                break;
            case R.id.brvah_dragger:
                fragmentManager.beginTransaction().replace(R.id.frame_brvah,new BrvahDraggerFragment()).commit();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}