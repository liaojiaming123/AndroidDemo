package com.weiyu.yui.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.widget.Toast;

import com.weiyu.yui.MainActivity;
import com.weiyu.yui.R;

public class NotificationService extends Service {
    private Context context;
    public NotificationService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        createForegroundNotification();
        Toast.makeText(context,"服务已启动",Toast.LENGTH_SHORT).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void createForegroundNotification(){
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder builder;
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("10","前台服务",NotificationManager.IMPORTANCE_HIGH);
            assert notificationManager != null;
            notificationManager.createNotificationChannel(channel);
            builder = new Notification.Builder(context,"10");
        }else {
            builder = new Notification.Builder(context);
            builder.setPriority(Notification.PRIORITY_MAX);//通过builder设置优先级-2~~~2
        }
        Notification notification = builder.setSmallIcon(R.mipmap.ic_launcher)//设置小图标
                .setContentText("服务正在运行...")//设置通知内容
                .setContentTitle("前台服务")//设置标题
                .setContentIntent(PendingIntent.getActivity(context,2,
                        new Intent(context, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK),0))
                //跳转目标
                .build();
        startForeground(10,notification);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopForeground(true);
        Toast.makeText(context,"服务已终止",Toast.LENGTH_SHORT).show();
    }
}
