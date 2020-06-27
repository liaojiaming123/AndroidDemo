package com.weiyu.demoservice.conn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.weiyu.demoservice.R;
import com.weiyu.demoservice.conn.ConnService.MyBinder;

public class Main2Activity extends AppCompatActivity{
    final String TAG = "Main2Activity";
    private Button btn_serviceconnect;
    private Button btn_servicecallback;

    MyBinder myBinder;

    ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i(TAG, "onServiceConnected: ");
            myBinder = (MyBinder) service;
            myBinder.getService();//执行ConnService中MyBinder的方法
            myBinder.setData("来自Main2Activity的数据");
            String string = myBinder.getData();
            Log.d(TAG, string);

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG, "onServiceDisconnected: ");
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn_serviceconnect = (Button)findViewById(R.id.btn_serviceconnect);
        btn_servicecallback = (Button)findViewById(R.id.btn_servicecallbackt);
        btn_serviceconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindService(new Intent(Main2Activity.this,ConnService.class),conn,BIND_AUTO_CREATE);
            }
        });
        btn_servicecallback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this,CallbackIntentService.class);
                intent.putExtra("string","来自Main2ActivityIntent");
                bindService(intent,serviceConn,BIND_AUTO_CREATE);
            }
        });
    }
    class ServiceConn implements ServiceConnection{
        CallbackIntentService.Binder binder;
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i(TAG, "onServiceConnected: CallbackIntentService");
            binder = (CallbackIntentService.Binder) service;
            binder.getService().setCallback(new CallbackIntentService.Callback() {
                @Override
                public void dataChanged(String data) {
                    Log.i(TAG, data);                }
            });
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG, "onServiceDisconnected: ");

        }
    }
    final ServiceConn serviceConn = new ServiceConn();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(serviceConn);
        Log.i(TAG, "onDestroy: ");
    }
}
