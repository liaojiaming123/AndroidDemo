package com.weiyu.demotoolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn_context;
    private Button btn_popup;
    private Button btn_dialog;
    private Button btn_progressbar;
    private Button btn_toast;
    private Button btn_view_flipper;
    private Spinner spinner;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_context = findViewById(R.id.btn_context);
        btn_popup = findViewById(R.id.btn_popup);
        btn_dialog = findViewById(R.id.btn_dialog);
        btn_progressbar = findViewById(R.id.btn_progressbar);
        btn_toast = findViewById(R.id.btn_toast);
        btn_view_flipper = findViewById(R.id.btn_view_flipper);


        final Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("标题");//设置标题，没有会报错
        TextView textView = (TextView)toolbar.getChildAt(1);//主标题
        textView.getLayoutParams().width = LinearLayout.LayoutParams.MATCH_PARENT;//填充父类
        textView.setGravity(Gravity.CENTER);//居中，CENTER，即水平也垂直，自选
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"点击了标题",Toast.LENGTH_SHORT).show();
            }
        });
        setSupportActionBar(toolbar);// 需要放在setNavigation前面
        toolbar.setNavigationIcon(R.mipmap.right);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"点击了返回键",Toast.LENGTH_SHORT).show();
            }
        });

        spinner = findViewById(R.id.change_color);
        spinner.setDropDownHorizontalOffset(32);
        spinner.setDropDownVerticalOffset(32);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        //清单文件中要设置主题为NoActionBar
                        StatusBarUtils.with(MainActivity.this)
                                .setColor(getResources().getColor(R.color.aqua))
                                .init();
                        toolbar.setBackgroundColor(getResources().getColor(R.color.aqua));
                        break;
                    case 1:
                        StatusBarUtils.with(MainActivity.this)
                                .setColor(getResources().getColor(R.color.red))
                                .init();
                        toolbar.setBackgroundColor(getResources().getColor(R.color.red));
                        Toast.makeText(MainActivity.this,"选择了Red",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        StatusBarUtils.with(MainActivity.this)
                                .setColor(getResources().getColor(R.color.mediumSpringGreen))
                                .init();
                        toolbar.setBackgroundColor(getResources().getColor(R.color.mediumSpringGreen));
                        Toast.makeText(MainActivity.this,"选择了SpringGreen",Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        StatusBarUtils.with(MainActivity.this)
                                .setColor(getResources().getColor(R.color.fuchsia))
                                .init();
                        toolbar.setBackgroundColor(getResources().getColor(R.color.fuchsia));
                        Toast.makeText(MainActivity.this,"选择了Fuchsia",Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        StatusBarUtils.with(MainActivity.this)
                                .setColor(getResources().getColor(R.color.purple))
                                .init();
                        toolbar.setBackgroundColor(getResources().getColor(R.color.purple));
                        Toast.makeText(MainActivity.this,"选择了Purple",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this,"啥也没选。",Toast.LENGTH_SHORT).show();
            }
        });


        registerForContextMenu(btn_context);//注册上下文事件

        btn_context.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"点击了按钮 长按触发菜单",Toast.LENGTH_SHORT).show();
            }
        });
        btn_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this,btn_popup);
                popupMenu.getMenuInflater().inflate(R.menu.popup,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.popup1:
                                Toast.makeText(MainActivity.this,"点击了选项1",Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.popup2:
                                Toast.makeText(MainActivity.this,"点击了选项2",Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
        btn_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,DialogActivity.class));
            }
        });

        btn_progressbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ProgressBarActivity.class));
            }
        });
        btn_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ToastActivity.class));
            }
        });
        btn_view_flipper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ViewFlipperActivity.class));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //重写onCreateOptionMenu 设置菜单
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //重写onOptionItemSelected 设置选项事件 返回false则不设置
        switch (item.getItemId()){
            case R.id.change_color:
                Toast.makeText(MainActivity.this,"点击了spinner",Toast.LENGTH_SHORT).show();
                break;
            case R.id.more:
                Toast.makeText(MainActivity.this,"点击了more",Toast.LENGTH_SHORT).show();
                break;
            case R.id.login:
                Toast.makeText(MainActivity.this,"点击了login",Toast.LENGTH_SHORT).show();
                break;
            case R.id.setting:
                Toast.makeText(MainActivity.this,"点击了setting",Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        // 设置上下文事件
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.context,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.context1:
                Toast.makeText(MainActivity.this,"点击了选项1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.context2:
                Toast.makeText(MainActivity.this,"点击了选项2",Toast.LENGTH_SHORT).show();
                break;
            case R.id.context3:
                Toast.makeText(MainActivity.this,"点击了选项3",Toast.LENGTH_SHORT).show();
                break;
            case R.id.context1_sub:
                Toast.makeText(MainActivity.this,"点击了子菜单",Toast.LENGTH_SHORT).show();
                break;
            case R.id.context2_sub:
                Toast.makeText(MainActivity.this,"点击了子选项1",Toast.LENGTH_SHORT).show();
                item.setCheckable(true);
                break;
            case R.id.context3_sub:
                Toast.makeText(MainActivity.this,"点击了子选项2",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }


}
