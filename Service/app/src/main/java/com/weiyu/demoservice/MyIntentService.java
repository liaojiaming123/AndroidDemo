package com.weiyu.demoservice;

import android.app.IntentService;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class MyIntentService extends IntentService {
    final String TAG = "MyIntentService";
    public MyIntentService(){
        super("MyIntentService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate: 方法被调用");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        //onHandleIntent方法可以执行队列任务,执行完后自动销毁服务，bindService启动服务不会触发
        Log.i(TAG, "onHandleIntent: 方法被调用");
        Bundle bundle = intent.getExtras();
        String string = bundle.getString("string");
        Toast.makeText(getApplication(),string,Toast.LENGTH_SHORT).show();
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){e.printStackTrace();}

    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand: 方法被调用");
        return super.onStartCommand(intent, flags, startId);
    }

    class MyBinder extends Binder{}

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind: 方法被调用");
        Bundle bundle = intent.getExtras();
        String string = bundle.getString("string");
        Toast.makeText(getApplication(),string,Toast.LENGTH_SHORT).show();
        return new MyBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "onUnbind: 方法被调用");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: 方法被调用");
    }

}
