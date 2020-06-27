package com.weiyu.demoservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.weiyu.demoservice.conn.Main2Activity;

public class MainActivity extends AppCompatActivity {
    private Button btn_startmyservice;
    private Button btn_stopmyservice;
    private Button btn_bindmyservice;
    private Button btn_unbindmyservice;
    private Button btn_startmyintentservice;
    private Button btn_bindmyintentservice;
    private Button btn_startmain2activity;
    final String TAG = "MainActivity";

    MyService.MyBinder myBinder = new MyService.MyBinder();
    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //服务被绑定时执行该方法，利用IBinder对象可以进行Activity和Service通信
            Log.i(TAG, "onServiceConnected: MyService已绑定");
//            myBinder = (MyService.MyBinder) service;
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            //服务解除绑定执行，正常unbindService不会执行
            Log.i(TAG, "onServiceDisconnected: 方法被调用");
        }
    };
    ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i(TAG, "onServiceConnected: MyIntentService已绑定");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_startmyservice = (Button)findViewById(R.id.btn_startmyservice);
        btn_stopmyservice = (Button)findViewById(R.id.btn_stopmyservice);
        btn_bindmyservice = (Button)findViewById(R.id.btn_bindmyservice);
        btn_unbindmyservice = (Button)findViewById(R.id.btn_unbindmyservice);
        btn_startmyintentservice = (Button)findViewById(R.id.btn_startmyintentservice);
        btn_bindmyintentservice = (Button)findViewById(R.id.btn_bindmyintentservice);
        btn_startmain2activity = (Button)findViewById(R.id.btn_startmain2activity);

        class Click implements View.OnClickListener{
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btn_startmyservice:
                        startService(new Intent(MainActivity.this,MyService.class));
                        break;
                    case R.id.btn_stopmyservice:
                        stopService(new Intent(MainActivity.this,MyService.class));
                        break;
                    case R.id.btn_bindmyservice:
                        bindService(new Intent(MainActivity.this,MyService.class),serviceConnection,BIND_AUTO_CREATE);
                        break;
                    case R.id.btn_unbindmyservice:
                        unbindService(serviceConnection);
                        break;
                    case R.id.btn_startmyintentservice:
                        Intent intent = new Intent(MainActivity.this,MyIntentService.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("string","服务运行中");
                        intent.putExtras(bundle);
                        startService(intent);
                        startService(intent);
                        break;
                    case R.id.btn_bindmyintentservice:
                        Intent i = new Intent(MainActivity.this,MyIntentService.class);
                        Bundle b = new Bundle();
                        b.putString("string","服务运行中");
                        i.putExtras(b);
                        bindService(i,conn,BIND_AUTO_CREATE);
                        break;
                    case R.id.btn_startmain2activity:
                        startActivity(new Intent(MainActivity.this, Main2Activity.class));
                        break;
                }
            }
        }
        btn_stopmyservice.setOnClickListener(new Click());
        btn_startmyservice.setOnClickListener(new Click());
        btn_bindmyservice.setOnClickListener(new Click());
        btn_unbindmyservice.setOnClickListener(new Click());
        btn_bindmyintentservice.setOnClickListener(new Click());
        btn_startmyintentservice.setOnClickListener(new Click());
        btn_startmain2activity.setOnClickListener(new Click());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(new Intent(MainActivity.this,MyService.class));
    }
}
