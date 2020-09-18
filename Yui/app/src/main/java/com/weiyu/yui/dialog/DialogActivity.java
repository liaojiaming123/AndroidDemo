package com.weiyu.yui.dialog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.weiyu.yui.R;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
//        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorAccent)));//设置actionbar背景
        actionBar.setTitle("对话框");
        actionBar.setDisplayHomeAsUpEnabled(true);//设置是否显示返回按钮
        actionBar.setHomeAsUpIndicator(R.mipmap.close);//修改默认返回按钮图片

        FragmentManager fragmentManager = getSupportFragmentManager();
        DialogFragment fragment = new DialogFragment();
        fragmentManager.beginTransaction().add(R.id.frame_layout_dialog_fragment,fragment).commit();//动态添加fragment
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){ //设置返回按钮选择事件
            DialogActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}