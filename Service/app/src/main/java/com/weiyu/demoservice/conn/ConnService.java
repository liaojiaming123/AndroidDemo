package com.weiyu.demoservice.conn;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class ConnService extends Service {
    final String TAG = "ConnService";
    public ConnService() {
    }
    public class MyBinder extends Binder{
        public MyBinder(){}
        public void getService(){
            Toast.makeText(getApplication(),"来自ConnService的提示",Toast.LENGTH_SHORT).show();
        }
        public String getData(){
            return "来自ConnService的数据";
        }
        public void setData(String string){
            Log.d(TAG, string);
        }
    }

    MyBinder myBinder = new MyBinder();
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myBinder;
    }

    @Override
    public void onCreate() {
        Log.i(TAG, "onCreate: ");
        super.onCreate();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }
}
