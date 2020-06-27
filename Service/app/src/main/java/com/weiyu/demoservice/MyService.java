package com.weiyu.demoservice;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    final String TAG = "MyService";
    public MyService() {
    }
    static class MyBinder extends Binder {}

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return new MyBinder();
    }
    @Override
    public void onCreate() {
        super.onCreate();
        //服务创建时调用OnCreate方法，多次startService只调用一次
        Log.i(TAG, "onCreate: 方法被调用");
        Toast.makeText(getApplication(),"MyService 已启动",Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //startService 时调用onStartCommand方法, 多次startService多次调用
        Log.i(TAG, "onStartCommand: 方法被调用");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //服务被销毁时调用onDestroy，unbindService解除所有组件绑定后，服务自动销毁
        // startService启动的服务当组件销毁时，服务不会自动销毁
        Log.i(TAG, "onDestroy: 方法被调用");
        Toast.makeText(getApplication(),"MyService 已停止",Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "onUnbind: 方法被调用");
        Toast.makeText(getApplication(),"MyService已解绑",Toast.LENGTH_LONG).show();
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.i(TAG, "onRebind: 方法被调用");
        super.onRebind(intent);
    }
}
