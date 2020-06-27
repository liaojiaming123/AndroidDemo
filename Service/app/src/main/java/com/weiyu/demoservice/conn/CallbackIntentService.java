package com.weiyu.demoservice.conn;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class CallbackIntentService extends IntentService {
    final String TAG = "CallbackIntentService";
    private String data = "默认消息";
    public Callback callback;
    boolean serviceRunning = false;

    public CallbackIntentService() {
        super("CallbackIntentService");
    }
    class Binder extends android.os.Binder {
        public void setData(String data){}
        public CallbackIntentService getService(){
            Toast.makeText(getApplication(),"来自CallbackIntentService的消息",Toast.LENGTH_SHORT).show();
            return CallbackIntentService.this;
        }
    }
    Binder binder = new Binder();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind: ");
        data = intent.getStringExtra("string");
        Log.i(TAG, data);
        return binder;
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.i(TAG, "onHandleIntent: ");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate: ");
        serviceRunning = true;
        new Thread() {
            @Override
            public void run() {
                int n = 0;
                while (serviceRunning) {
                    n++;
                    String str = n + data;
                    Log.i(TAG, str);
                    if (callback != null) {
                        callback.dataChanged(str);
                    }
                    try {
                        sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
        }.start();
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onStart(@Nullable Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.i(TAG, "onStart: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }
    public interface Callback {
        void dataChanged(String data);
    }
    public Callback getCallback() {
        return callback;
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

}
