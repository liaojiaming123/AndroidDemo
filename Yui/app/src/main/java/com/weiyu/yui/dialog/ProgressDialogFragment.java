package com.weiyu.yui.dialog;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.weiyu.yui.R;

import java.lang.ref.WeakReference;

public class ProgressDialogFragment extends Fragment implements View.OnClickListener {
    private Context context;
    private ProgressDialog progressDialog;
    private int progressStart = 0;
    private int add = 0;
    public ProgressDialogFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_progress_bar_dialog, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Button progress_dialog_round = (Button)getView().findViewById(R.id.progress_dialog_round);
        progress_dialog_round.setOnClickListener(this);
        Button progress_dialog_react = (Button)getView().findViewById(R.id.progress_dialog_react);
        progress_dialog_react.setOnClickListener(this);
        Button progress_dialog_loading = (Button)getView().findViewById(R.id.progress_dialog_loading);
        progress_dialog_loading.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.progress_dialog_round:
                progressDialog = new ProgressDialog(context);
                progressDialog.setIcon(R.mipmap.ic_launcher_round);
                progressDialog.setTitle("资源加载中");
                progressDialog.setMessage("资源加载中,请稍后...");
                progressDialog.setIndeterminate(false);
                progressDialog.setCancelable(true);
                progressDialog.show();
                break;
            case R.id.progress_dialog_react:
                progressDialog = new ProgressDialog(context);
                progressDialog.setTitle("软件更新中");
                progressDialog.setMessage("软件更新中，请稍后...");
                progressDialog.setIndeterminate(true);
                progressDialog.setCancelable(true);
                progressDialog.setIcon(R.mipmap.ic_launcher);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.show();
                break;
            case R.id.progress_dialog_loading:
                final MyHandler myHandler = new MyHandler(this);
                progressDialog = new ProgressDialog(context);
                progressDialog.setMax(100);
                progressDialog.setTitle("文件读取中");
                progressDialog.setMessage("文件读取中，请稍后...");
                progressDialog.setIndeterminate(false);
                progressDialog.setCancelable(true);
                progressDialog.setIcon(R.mipmap.ic_launcher);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.show();
                myHandler.progressDialog = progressDialog;
                myHandler.progressStart = progressStart;
                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        while(myHandler.progressStart < 100){
                            myHandler.progressStart = 2 * usetime() ;
                            myHandler.sendEmptyMessage(123);
                        }
                    }
                }.start();
                break;
        }
    }
//    private MyHandler handler = new MyHandler(this);
//    static class MyHandler extends Handler {
//        WeakReference weakReference;
//        public MyHandler(ProgressDialogFragment fragment) {
//            weakReference = new WeakReference(fragment);
//        }
//        @Override
//        public void handleMessage(Message msg) {
//        }
//    }
    private static class MyHandler extends Handler{
        private WeakReference<ProgressDialogFragment> weakReference;
        private ProgressDialog progressDialog;
        private int progressStart;
        public MyHandler(ProgressDialogFragment fragment){
                weakReference = new WeakReference<ProgressDialogFragment>(fragment);
            }
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(msg.what == 123) {progressDialog.setProgress(progressStart);}
            //如果当前大于或等于进度条的最大值,调用dismiss()方法关闭对话框
            if(progressStart >= 100){progressDialog.dismiss();}
        }
}

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