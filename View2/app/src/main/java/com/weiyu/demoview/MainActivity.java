package com.weiyu.demoview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.weiyu.demoview.listview.BaseListActivity;
import com.weiyu.demoview.listview.ListviewActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_listview_simple;
    private Button btn_base_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_listview_simple = (Button)findViewById(R.id.btn_listview_simple);
        btn_base_list = (Button)findViewById(R.id.btn_baselist);
        btn_base_list.setOnClickListener(this);
        btn_listview_simple.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_listview_simple:
                startActivity(new Intent(MainActivity.this, ListviewActivity.class));
            case R.id.btn_baselist:
                startActivity(new Intent(MainActivity.this, BaseListActivity.class));
        }
    }
}
