package com.weiyu.yui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.weiyu.yui.base.BaseActivity;
import com.weiyu.yui.dialog.DialogActivity;
import com.weiyu.yui.menu.MenuActivity;
import com.weiyu.yui.notification.NotificationActivity;
import com.weiyu.yui.pager.PagerActivity;
import com.weiyu.yui.recycler.RecyclerActivity;
import com.weiyu.yui.setting.SettingActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Context context;
    private Button btn_base_activity,btn_menu_activity,btn_dialog_activity;
    private Button btn_notification_activity,btn_pager_activity,btn_recycler_activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        btn_base_activity = (Button)findViewById(R.id.btn_base_activity);
        btn_base_activity.setOnClickListener(this);
        btn_menu_activity = (Button)findViewById(R.id.btn_menu_activity);
        btn_menu_activity.setOnClickListener(this);
        btn_dialog_activity = (Button)findViewById(R.id.btn_dialog_activity);
        btn_dialog_activity.setOnClickListener(this);
        btn_notification_activity = (Button)findViewById(R.id.btn_notification_activity);
        btn_notification_activity.setOnClickListener(this);
        btn_pager_activity = (Button)findViewById(R.id.btn_pager_activity);
        btn_pager_activity.setOnClickListener(this);
        btn_recycler_activity = (Button)findViewById(R.id.btn_recycler_activity);
        btn_recycler_activity.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_base_activity:
                startActivity(new Intent(context, BaseActivity.class));
                break;
            case R.id.btn_menu_activity:
                startActivity(new Intent(context, MenuActivity.class));
                break;
            case R.id.btn_dialog_activity:
                startActivity(new Intent(context, DialogActivity.class));
                break;
            case R.id.btn_notification_activity:
                startActivity(new Intent(context, NotificationActivity.class));
                break;
            case R.id.btn_pager_activity:
                startActivity(new Intent(context, PagerActivity.class));
                break;
            case R.id.btn_recycler_activity:
                startActivity(new Intent(context, RecyclerActivity.class));
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.main_activity_setting) {
            startActivity(new Intent(context,SettingActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }


}