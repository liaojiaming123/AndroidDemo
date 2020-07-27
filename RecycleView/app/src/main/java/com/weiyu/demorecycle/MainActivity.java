package com.weiyu.demorecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.weiyu.demorecycle.decoration.DecorationActivity;
import com.weiyu.demorecycle.grid.GridActivity;
import com.weiyu.demorecycle.header.HeaderActivity;
import com.weiyu.demorecycle.horizontal.HorizontalActivity;
import com.weiyu.demorecycle.loader.LoaderActivity;
import com.weiyu.demorecycle.drag.DragActivity;
import com.weiyu.demorecycle.stagger.StaggerActivity;
import com.weiyu.demorecycle.vertical.VerticalActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_vertical;
    private Button btn_horizontal;
    private Button btn_grid;
    private Button btn_stagger;
    private Button btn_header, btn_loader;
    private Button btn_decoration, btn_sort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_vertical = (Button)findViewById(R.id.btn_vertical);
        btn_horizontal = (Button)findViewById(R.id.btn_horizontal);
        btn_grid = (Button)findViewById(R.id.btn_grid);
        btn_stagger = (Button)findViewById(R.id.btn_stagger);
        btn_header = (Button)findViewById(R.id.btn_header);
        btn_loader = (Button)findViewById(R.id.btn_loader);
        btn_decoration = (Button)findViewById(R.id.btn_decoration);
        btn_sort = (Button)findViewById(R.id.btn_group);

        btn_vertical.setOnClickListener(this);
        btn_horizontal.setOnClickListener(this);
        btn_grid.setOnClickListener(this);
        btn_stagger.setOnClickListener(this);
        btn_header.setOnClickListener(this);
        btn_loader.setOnClickListener(this);
        btn_decoration.setOnClickListener(this);
        btn_sort.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_vertical:
                startActivity(new Intent(MainActivity.this, VerticalActivity.class));
                break;
            case R.id.btn_horizontal:
                startActivity(new Intent(MainActivity.this, HorizontalActivity.class));
                break;
            case R.id.btn_grid:
                startActivity(new Intent(MainActivity.this, GridActivity.class));
                break;
            case R.id.btn_stagger:
                startActivity(new Intent(MainActivity.this, StaggerActivity.class));
                break;
            case R.id.btn_header:
                startActivity(new Intent(MainActivity.this, HeaderActivity.class));
                break;
            case R.id.btn_loader:
                startActivity(new Intent(MainActivity.this, LoaderActivity.class));
                break;
            case R.id.btn_decoration:
                startActivity(new Intent(MainActivity.this, DecorationActivity.class));
                break;
            case R.id.btn_group:
                startActivity(new Intent(MainActivity.this, DragActivity.class));
                break;

        }

    }
}
