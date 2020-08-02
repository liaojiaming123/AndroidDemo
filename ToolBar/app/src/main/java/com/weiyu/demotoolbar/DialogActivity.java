package com.weiyu.demotoolbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_alert_simple;
    private Button btn_alert_list;
    private Button btn_alert_single;
    private Button btn_alert_multi;
    private Button btn_alert_custom;
    private AlertDialog.Builder builder;
    private AlertDialog alertDialog;
    private Toolbar toolbar;
    private Button btn_progress_simple;
    private Button btn_progress_hr;
    private Button btn_progress_pro;
    private Button btn_dialog_date,btn_dialog_time,btn_popup_window;
    private final static int MAXVALUE = 100;
    private int progressStart = 0;
    private int add = 0;
    private TextView pop_win_tv1,pop_win_tv2;
    private ProgressDialog progressDialog,progressDialogHr,progressDialogPro;
    private ScrollView scrollView;
    private PopupWindow popupWindow;

    //定义一个用于更新进度的Handler,因为只能由主线程更新界面,所以要用Handler传递信息
    @SuppressLint("HandlerLeak")
    private final Handler hand = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            //这里的话如果接受到信息码是123
            if(msg.what == 123)
            {
                //设置进度条的当前值
                progressDialogPro.setProgress(progressStart);
            }
            //如果当前大于或等于进度条的最大值,调用dismiss()方法关闭对话框
            if(progressStart >= MAXVALUE)
            {
                progressDialogPro.dismiss();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        toolbar = findViewById(R.id.toolbar2);
        toolbar.setTitle("Title");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.right);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogActivity.this.finish();
            }
        });

        btn_alert_simple = findViewById(R.id.btn_alert_simple);
        btn_alert_list = findViewById(R.id.btn_alert_list);
        btn_alert_single = findViewById(R.id.btn_alert_single);
        btn_alert_multi = findViewById(R.id.btn_alert_multi);
        btn_alert_custom = findViewById(R.id.btn_custom_alert);
        btn_progress_simple = findViewById(R.id.btn_progress_simple);
        btn_progress_hr = findViewById(R.id.btn_progress_hr);
        btn_progress_pro = findViewById(R.id.btn_progress_pro);
        btn_dialog_time = findViewById(R.id.btn_dialog_time);
        btn_dialog_date = findViewById(R.id.btn_dialog_date);
        btn_popup_window = findViewById(R.id.btn_popup_window);

        btn_popup_window.setOnClickListener(this);
        btn_dialog_date.setOnClickListener(this);
        btn_dialog_time.setOnClickListener(this);
        btn_progress_pro.setOnClickListener(this);
        btn_progress_hr.setOnClickListener(this);
        btn_progress_simple.setOnClickListener(this);
        btn_alert_simple.setOnClickListener(this);
        btn_alert_list.setOnClickListener(this);
        btn_alert_single.setOnClickListener(this);
        btn_alert_multi.setOnClickListener(this);
        btn_alert_custom.setOnClickListener(this);

        StatusBarUtils.with(this)
                .setColor(getResources().getColor(R.color.mediumSpringGreen))
                .init();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_alert_simple:
                builder = new AlertDialog.Builder(DialogActivity.this);
                alertDialog = builder.setIcon(R.mipmap.ic_launcher)
                        .setMessage("这是内容")
                        .setTitle("标题")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(DialogActivity.this,"点击了确定",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNeutralButton("返回", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(DialogActivity.this,"点击了返回",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(DialogActivity.this,"点击了取消",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .create();
                alertDialog.show();
                break;
            case R.id.btn_alert_list:
                final CharSequence[] items = {"Java","JavaScript","Python","C/C++","PHP"};
                builder = new AlertDialog.Builder(DialogActivity.this);
                alertDialog = builder.setIcon(R.mipmap.ic_launcher)
                        .setTitle("列表框")
                        .setItems(items, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(DialogActivity.this,"点击了"+items[which],Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setCancelable(true)
                        .setOnCancelListener(new DialogInterface.OnCancelListener() {
                            @Override
                            public void onCancel(DialogInterface dialog) {
                                Toast.makeText(DialogActivity.this,"点击了取消",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNeutralButton("返回", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(DialogActivity.this,"点击了返回",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .create();
                alertDialog.show();
                break;
            case R.id.btn_alert_single:
                final CharSequence[] single = {"Apple","Banana","Lemon","Orange","Watermelon"};
                builder = new AlertDialog.Builder(DialogActivity.this);
                alertDialog = builder.setIcon(R.mipmap.ic_launcher)
                        .setTitle("单选框")
                        .setSingleChoiceItems(single,0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(DialogActivity.this,"点击了"+single[which],Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(DialogActivity.this,"选择了"+single[which],Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(DialogActivity.this,"点击了"+single[which],Toast.LENGTH_SHORT).show();
                            }
                        })
                        .create();
                alertDialog.show();
                break;
            case R.id.btn_alert_multi:
                final CharSequence[] multi = {"Apple","Banana","Lemon","Orange","Watermelon"};
                builder = new AlertDialog.Builder(DialogActivity.this);
                final boolean[] checkItems = new boolean[]{false, false, false, false,false};
                alertDialog = builder.setIcon(R.mipmap.ic_launcher)
                        .setTitle("多选框")
                        .setMultiChoiceItems(multi, checkItems, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                checkItems[which] = isChecked;
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String result = "";
                                for (int i = 0; i < checkItems.length; i++) {
                                    if (checkItems[i])
                                        result += multi[i] + " ";
                                }
                                Toast.makeText(getApplicationContext(), "选择了:" + result, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "点击了取消", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .create();
                alertDialog.show();
                break;
            case R.id.btn_custom_alert:
                final LayoutInflater inflater = DialogActivity.this.getLayoutInflater();
                final View view = inflater.inflate(R.layout.layout, null,false);
                //加载自定义的那个View,同时设置下
                builder = new AlertDialog.Builder(DialogActivity.this);//
                builder.setView(view);
                builder.setCancelable(false);
                final AlertDialog alert = builder.create();
                view.findViewById(R.id.btn_cancle).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alert.dismiss();
                    }
                });
                view.findViewById(R.id.btn_confirm).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "点击了确定", Toast.LENGTH_SHORT).show();
                        alert.dismiss();
                    }
                });
                view.findViewById(R.id.btn_close).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "对话框已关闭~", Toast.LENGTH_SHORT).show();
                        alert.dismiss();
                    }
                });
                alert.show();
                break;
            case R.id.btn_progress_simple:
                //这里的话参数依次为,上下文,标题,内容,是否显示进度,是否可以用取消按钮关闭
//                ProgressDialog.show(DialogActivity.this,"资源加载中", "资源加载中,请稍后...",false,true);
                progressDialog = new ProgressDialog(DialogActivity.this);
                progressDialog.setIcon(R.mipmap.ic_launcher_round);
                progressDialog.setTitle("资源加载中");
                progressDialog.setMessage("资源加载中,请稍后...");
                progressDialog.setIndeterminate(false);
                progressDialog.setCancelable(true);
                progressDialog.show();
                break;
            case R.id.btn_progress_hr:
                progressDialogHr = new ProgressDialog(DialogActivity.this);
                progressDialogHr.setTitle("软件更新中");
                progressDialogHr.setMessage("软件更新中，请稍后...");
                progressDialogHr.setIndeterminate(true);
                progressDialogHr.setCancelable(true);
                progressDialogHr.setIcon(R.mipmap.ic_launcher);
                progressDialogHr.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialogHr.show();
                break;
            case R.id.btn_progress_pro:
                progressDialogPro = new ProgressDialog(DialogActivity.this);
                progressDialogPro.setMax(MAXVALUE);
                progressDialogPro.setTitle("文件读取中");
                progressDialogPro.setMessage("文件读取中，请稍后...");
                progressDialogPro.setIndeterminate(false);
                progressDialogPro.setCancelable(true);
                progressDialogPro.setIcon(R.mipmap.ic_launcher);
                progressDialogPro.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialogPro.show();
                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        while(progressStart < MAXVALUE)
                        {
                            //这里的算法是决定进度条变化的,可以按需要写
                            progressStart = 2 * usetime() ;
                            //把信息码发送给handle让更新界面
                            hand.sendEmptyMessage(123);
                        }
                    }
                }.start();
                break;
            case R.id.btn_dialog_date:
                DatePickerDialog datePickerDialog = new DatePickerDialog(DialogActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        int mon = month+1;
                        Toast.makeText(DialogActivity.this,"选择的日期是："+year+"-"+mon+"-"+dayOfMonth,Toast.LENGTH_SHORT).show();
                    }
                },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
                break;
            case R.id.btn_dialog_time:
//                Calendar calendar1 = Calendar.getInstance();
                TimePickerDialog timePickerDialog = new TimePickerDialog(DialogActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Toast.makeText(DialogActivity.this,"选择的时间是: "+hourOfDay+": "+minute,Toast.LENGTH_SHORT).show();
                    }
                },calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false);
                timePickerDialog.show();
                break;
            case R.id.btn_popup_window:
                break;
                /**final View popWinView = LayoutInflater.from(DialogActivity.this).inflate(R.layout.popup_window,null,false);
                pop_win_tv1 = (TextView) popWinView.findViewById(R.id.pop_win_tv1);
                pop_win_tv2 = (TextView) popWinView.findViewById(R.id.pop_win_tv2);
                popupWindow = new PopupWindow(DialogActivity.this);
                popupWindow.setContentView(popWinView);
                popupWindow.setAnimationStyle(R.anim.nav_default_enter_anim);
                popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
                popupWindow.setTouchable(true);
                popupWindow.setTouchInterceptor(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        return false;
                        // 这里如果返回true的话，touch事件将被拦截
                        // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
                    }
                });

                btn_popup_window.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(DialogActivity.this,"点击了PopupWindow",Toast.LENGTH_SHORT).show();
                        pop_win_tv1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(DialogActivity.this,"点击了TextView1",Toast.LENGTH_SHORT).show();
                                popupWindow.dismiss();
                            }
                        });
                        pop_win_tv2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(DialogActivity.this,"点击了TextView2",Toast.LENGTH_SHORT).show();
                                popupWindow.dismiss();
                            }
                        });
                    }
                });
                break;*/
        }
    }
    Calendar calendar = Calendar.getInstance();
    //这里设置一个耗时的方法:
    private int usetime() {
        add++;
        try{
            Thread.sleep(100);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        return add;
    }
}
