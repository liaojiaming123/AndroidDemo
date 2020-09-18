package com.weiyu.yui.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.weiyu.yui.R;

public class MenuActivity extends AppCompatActivity {
    private Button btn_context_menu;
    private Button btn_popup_menu;
    private Toolbar toolbar_menu;
    private Spinner spinner_menu;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();//隐藏ActionBar
        init();
        createToolbar();
        createPopupMenu();
        createSpinner();
    }

    private void init(){
        //初始化控件
        context = this;
        btn_context_menu = (Button) findViewById(R.id.btn_context_menu);
        btn_popup_menu = (Button) findViewById(R.id.btn_popup_menu);
        toolbar_menu = (Toolbar)findViewById(R.id.toolbar_menu);
        spinner_menu = (Spinner)findViewById(R.id.spinner_menu);
        registerForContextMenu(btn_context_menu);//注册上下文菜单
    }
    private void createToolbar(){
//        setSupportActionBar(toolbar_menu); //该属性需要设置NoBar主题
//        toolbar_menu.setTitle("标题"); 设置标题 也可以在布局文件设置
//        toolbar_menu.setLogo(R.mipmap.ic_launcher); 设置图标
//        toolbar_menu.setNavigationIcon(R.mipmap.back); 设置导航图标
//        toolbar_menu.inflateMenu(R.menu.toolbar_menu); //设置菜单
        toolbar_menu.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuActivity.this.finish();
                //设置导航图标点击事件 关闭当前Activity
            }
        });
//        toolbar_menu.setMenu();
        toolbar_menu.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.tool_menu_1:
                        Toast.makeText(context,"点击了选项一",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.tool_menu_2:
                        Toast.makeText(context,"点击了选项二",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.tool_menu_3:
                        Toast.makeText(context,"点击了选项三",Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 重写该方法添加选项菜单 也可以在布局文件中设置
        MenuInflater menuInflater = new MenuInflater(context);
        menuInflater.inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        new MenuInflater(context).inflate(R.menu.context_menu,menu);
        //创建上下文菜单，加载菜单布局
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        //上下文菜单选项选择事件
        switch (item.getItemId()){
            case R.id.context1_menu:
                Toast.makeText(context,"点击了选项1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.context2_menu:
                Toast.makeText(context,"点击了选项2",Toast.LENGTH_SHORT).show();
                break;
            case R.id.context3_menu:
                Toast.makeText(context,"点击了选项3",Toast.LENGTH_SHORT).show();
                break;
            case R.id.context1_sub_menu:
                Toast.makeText(context,"点击了子菜单",Toast.LENGTH_SHORT).show();
                break;
            case R.id.context2_sub_menu:
                Toast.makeText(context,"点击了子选项1",Toast.LENGTH_SHORT).show();
                item.setCheckable(true);
                break;
            case R.id.context3_sub_menu:
                Toast.makeText(context,"点击了子选项2",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
    private void createPopupMenu(){
        //创建弹出菜单
        btn_popup_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(context,btn_popup_menu);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.popup1:
                                Toast.makeText(context,"点击了选项1",Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.popup2:
                                Toast.makeText(context,"点击了选项2",Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }
    private void createSpinner(){
        // 设置下拉菜单 选项事件
        spinner_menu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                        getWindow().setStatusBarColor(getResources().getColor(R.color.aqua));
                        toolbar_menu.setBackgroundColor(getResources().getColor(R.color.aqua));
                        break;
                    case 1:
                        getWindow().setStatusBarColor(getResources().getColor(R.color.red));
                        toolbar_menu.setBackgroundColor(getResources().getColor(R.color.red));
                        Toast.makeText(context,"选择了Red",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        getWindow().setStatusBarColor(getResources().getColor(R.color.mediumSpringGreen));
                        toolbar_menu.setBackgroundColor(getResources().getColor(R.color.mediumSpringGreen));
                        Toast.makeText(context,"选择了SpringGreen",Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        getWindow().setStatusBarColor(getResources().getColor(R.color.fuchsia));
                        toolbar_menu.setBackgroundColor(getResources().getColor(R.color.fuchsia));
                        Toast.makeText(context,"选择了Fuchsia",Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        getWindow().setStatusBarColor(getResources().getColor(R.color.purple));
                        toolbar_menu.setBackgroundColor(getResources().getColor(R.color.purple));
                        Toast.makeText(context,"选择了Purple",Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
