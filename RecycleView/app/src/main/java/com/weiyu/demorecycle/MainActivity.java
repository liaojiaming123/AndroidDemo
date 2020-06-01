package com.weiyu.demorecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.weiyu.demorecycle.click.ClicklActivity;
import com.weiyu.demorecycle.click.InterfaceClickActivity;
import com.weiyu.demorecycle.grid.GridActivity;
import com.weiyu.demorecycle.horizontal.HorizontalActivity;
import com.weiyu.demorecycle.stagger.StaggerActivity;
import com.weiyu.demorecycle.vertical.VerticalActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_vertical;
    private Button btn_horizontal;
    private Button btn_grid;
    private Button btn_stagger;
    private Button btn_click,btn_iclick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_vertical = (Button)findViewById(R.id.btn_vertical);
        btn_horizontal = (Button)findViewById(R.id.btn_horizontal);
        btn_grid = (Button)findViewById(R.id.btn_grid);
        btn_stagger = (Button)findViewById(R.id.btn_stagger);
        btn_click = (Button)findViewById(R.id.btn_click);
        btn_iclick = (Button)findViewById(R.id.btn_iclick);

        btn_vertical.setOnClickListener(this);
        btn_horizontal.setOnClickListener(this);
        btn_grid.setOnClickListener(this);
        btn_stagger.setOnClickListener(this);
        btn_click.setOnClickListener(this);
        btn_iclick.setOnClickListener(this);

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
            case R.id.btn_click:
                startActivity(new Intent(MainActivity.this, ClicklActivity.class));
                break;
            case R.id.btn_iclick:
                startActivity(new Intent(MainActivity.this, InterfaceClickActivity.class));
                break;

        }

    }
}
