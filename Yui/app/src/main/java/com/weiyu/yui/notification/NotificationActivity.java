package com.weiyu.yui.notification;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.weiyu.yui.MainActivity;
import com.weiyu.yui.R;
import com.weiyu.yui.dialog.DialogActivity;

public class NotificationActivity extends AppCompatActivity implements View.OnClickListener {
    private Context context;
    private NotificationManager notificationManager;
    private Notification.Builder builder;
    private Notification notification;
    private Button btnNotificationCheck,btnNotificationSimple;
    private Button btnNotificationText,btnNotificationImage;
    private Button btnNotificationPd,btnNotificationService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        context = this;
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.lightPurple)));//设置actionbar背景
        actionBar.setTitle("状态通知栏");
        actionBar.setDisplayHomeAsUpEnabled(true);//设置是否显示返回按钮
        actionBar.setHomeAsUpIndicator(R.mipmap.back);//修改默认返回按钮图片
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().setStatusBarColor(getResources().getColor(R.color.lightPurple));//修改状态栏背景

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        initView();
        initBuilder();
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){ //设置返回按钮选择事件
            NotificationActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
    private void initView(){
        btnNotificationSimple = (Button)findViewById(R.id.notification_simple);
        btnNotificationSimple.setOnClickListener(this);
        btnNotificationCheck = (Button)findViewById(R.id.notification_check);
        btnNotificationCheck.setOnClickListener(this);
        btnNotificationText = (Button)findViewById(R.id.notification_text);
        btnNotificationText.setOnClickListener(this);
        btnNotificationImage = (Button)findViewById(R.id.notification_image);
        btnNotificationImage.setOnClickListener(this);
        btnNotificationPd = (Button)findViewById(R.id.notification_ped);
        btnNotificationPd.setOnClickListener(this);
        btnNotificationService = (Button)findViewById(R.id.notification_service);
        btnNotificationService.setOnClickListener(this);
        btnNotificationService.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                stopService(new Intent(context,NotificationService.class));
                return true;
            }
        });
    }

    private void initBuilder(){
        //初始化Notification.Builder Android8.0前后方式不同
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O){
//            AudioAttributes attributes = new AudioAttributes.Builder()
//                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
//                    .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
//                    .build();
//            Uri uri = RingtoneManager.getDefaultUri(Notification.DEFAULT_SOUND);
            NotificationChannel channel = new NotificationChannel("1","消息推送",NotificationManager.IMPORTANCE_HIGH);
//            channel.setSound(uri,attributes); //通过channel设置通知铃声 优先级 id等
            notificationManager.createNotificationChannel(channel);
            builder = new Notification.Builder(context,"1");
        }else {
//            AudioAttributes attributes = new AudioAttributes.Builder()
//                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
//                    .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
//                    .build();
//            Uri uri = RingtoneManager.getDefaultUri(Notification.DEFAULT_SOUND);
            builder = new Notification.Builder(context);
            builder.setPriority(Notification.PRIORITY_MAX);//通过builder设置优先级-2~~~2
//            builder.setSound(uri,attributes);// 通过builder设置通知铃声
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.notification_check:
                if (notificationManager.areNotificationsEnabled()){
                    Toast.makeText(context,"通知权限已打开",Toast.LENGTH_SHORT).show();
                } else {
                    new AlertDialog.Builder(context)
                            .setIcon(R.mipmap.ic_launcher)
                            .setTitle("提示")
                            .setMessage("通知权限未打开，是否去开启？")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    try {
                                        // 根据通知栏开启权限判断结果，判断是否需要提醒用户跳转系统通知管理页面
                                        Intent intent = new Intent();
                                        intent.setAction(Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS);
                                        //这种方案适用于 API 26, 即8.0（含8.0）以上可以用
                                        intent.putExtra(Settings.EXTRA_APP_PACKAGE, context.getPackageName());
                                        intent.putExtra(Settings.EXTRA_CHANNEL_ID, context.getApplicationInfo().uid);
                                        //这种方案适用于 API21——25，即 5.0——7.1 之间的版本可以使用
                                        intent.putExtra("app_package", getPackageName());
                                        intent.putExtra("app_uid", context.getApplicationInfo().uid);
                                        startActivityForResult(intent,1);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        // 出现异常则跳转到应用设置界面
                                        Intent intent = new Intent();
                                        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                        Uri uri = Uri.fromParts("package", context.getPackageName(), null);
                                        intent.setData(uri);
                                        startActivityForResult(intent,1);
                                    }


                                }
                            })
                            .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(context,"已取消",Toast.LENGTH_SHORT).show();
                                }
                            })
                            .create().show();
                }
                break;
            case R.id.notification_simple:
                notification = builder.setSmallIcon(R.mipmap.ic_launcher)//设置小图标
                        .setContentText("通知内容")//设置通知内容
                        .setContentTitle("标题")//设置标题
                        .setTicker("消息推送")//设置推报
                        .setShowWhen(true)//是否显示推送时间
                        .build();
                notificationManager.notify(1,notification);//发送通知 相同的id会覆盖前面的通知
                Toast.makeText(context,"发送通知成功",Toast.LENGTH_SHORT).show();
//              notificationManager.cancel(1);//取消通知
                break;
            case R.id.notification_text:
                Notification.BigTextStyle style = new Notification.BigTextStyle()//大文本样式
                        .setBigContentTitle("标题")
                        .bigText("通知内容 通知内容 通知内容 通知内容 通知内容 通知内容 通知内容 通知内容 通知内容 通知内容 通知内容 通知内容 通知内容 通知内容 通知内容");
                notification = builder.setSmallIcon(R.mipmap.ic_launcher)
                        .setContentText("通知内容 通知内容 通知内容 通知内容 通知内容 通知内容")
                        .setContentTitle("标题")
                        .setShowWhen(true)
                        .setStyle(style)
                        .build();
                notificationManager.notify(2,notification);
                Toast.makeText(context,"发送通知成功",Toast.LENGTH_SHORT).show();
                break;
            case R.id.notification_image:
                Notification.BigPictureStyle style2 = new Notification.BigPictureStyle()//大图片样式
                        .bigLargeIcon(BitmapFactory.decodeResource(context.getResources(),R.mipmap.ic_launcher))
                        .bigPicture(BitmapFactory.decodeResource(context.getResources(),R.raw.notification_image))
                        .setBigContentTitle("标题")
                        .setSummaryText("查看通知详情");
                notification = builder.setSmallIcon(R.mipmap.ic_launcher)
                        .setContentText("通知内容 通知内容 通知内容 通知内容 通知内容 通知内容")
                        .setContentTitle("标题")
                        .setShowWhen(true)
                        .setStyle(style2)
                        .build();
                notificationManager.notify(3,notification);
                Toast.makeText(context,"发送通知成功",Toast.LENGTH_SHORT).show();
                break;
            case R.id.notification_ped:
                notification = builder.setSmallIcon(R.mipmap.ic_launcher)//设置小图标
                        .setContentText("点击跳转页面")//设置通知内容
                        .setContentTitle("PendingIntent")//设置标题
                        .setContentIntent(PendingIntent.getActivity(context,2,
                                new Intent(context, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK),0))
                        //跳转目标
                        .setShowWhen(true)//是否显示推送时间
                        .build();
                notificationManager.notify(4,notification);//发送通知 相同的id会覆盖前面的通知
                Toast.makeText(context,"发送通知成功",Toast.LENGTH_SHORT).show();
                break;
            case R.id.notification_service:
                // 需要权限android.permission.FOREGROUND_SERVICE
                if (Build.VERSION.SDK_INT>Build.VERSION_CODES.O){
                    startForegroundService(new Intent(context,NotificationService.class));
                }else{startService(new Intent(context,NotificationService.class));}
                break;
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            if (notificationManager.areNotificationsEnabled()){
                Toast.makeText(context,"通知权限已打开",Toast.LENGTH_SHORT).show();
            } else {Toast.makeText(context,"通知权限未开启",Toast.LENGTH_SHORT).show();}
        }
    }
}