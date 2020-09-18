package com.weiyu.yui.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.weiyu.yui.R;

public class AlertDialogFragment extends Fragment implements View.OnClickListener {
    private Context context;
    private AlertDialog alertDialog;
    private AlertDialog.Builder builder;
    public AlertDialogFragment() {
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
        return inflater.inflate(R.layout.fragment_alert_dialog, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Button alert_dialog_simple = (Button)getView().findViewById(R.id.alert_dialog_simple);
        alert_dialog_simple.setOnClickListener(this);
        Button alert_dialog_list = (Button)getView().findViewById(R.id.alert_dialog_list);
        alert_dialog_list.setOnClickListener(this);
        Button alert_dialog_single = (Button)getView().findViewById(R.id.alert_dialog_single);
        alert_dialog_single.setOnClickListener(this);
        Button alert_dialog_multi = (Button)getView().findViewById(R.id.alert_dialog_multi);
        alert_dialog_multi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.alert_dialog_simple:
                builder = new AlertDialog.Builder(context);
                alertDialog = builder.setIcon(R.mipmap.ic_launcher)
                        .setMessage("这是内容")
                        .setTitle("标题")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(context,"点击了确定",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNeutralButton("返回", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(context,"点击了返回",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(context,"点击了取消",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .create();
                alertDialog.show();
                break;
            case R.id.alert_dialog_list:
                final CharSequence[] items = {"Java","JavaScript","Python","C/C++","PHP"};
                builder = new AlertDialog.Builder(context);
                alertDialog = builder.setIcon(R.mipmap.ic_launcher)
                        .setTitle("列表框")
                        .setItems(items, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(context,"点击了"+items[which],Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setCancelable(true)
                        .setOnCancelListener(new DialogInterface.OnCancelListener() {
                            @Override
                            public void onCancel(DialogInterface dialog) {
                                Toast.makeText(context,"点击了取消",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNeutralButton("返回", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(context,"点击了返回",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .create();
                alertDialog.show();
                break;
            case R.id.alert_dialog_single:
                final CharSequence[] single = {"Apple","Banana","Lemon","Orange","Watermelon"};
                builder = new AlertDialog.Builder(context);
                final int[] position = new int[1];
                alertDialog = builder.setIcon(R.mipmap.ic_launcher)
                        .setTitle("单选框")
                        .setSingleChoiceItems(single,0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                position[0] = which;
                                Toast.makeText(context,"点击了"+single[which],Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                which = position[0];
                                Toast.makeText(context,"选择了"+single[which],Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(context,"点击了取消",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .create();
                alertDialog.show();
                break;
            case R.id.alert_dialog_multi:
                final CharSequence[] multi = {"Apple","Banana","Lemon","Orange","Watermelon"};
                builder = new AlertDialog.Builder(context);
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
                                Toast.makeText(context, "选择了:" + result, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(context, "点击了取消", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .create();
                alertDialog.show();
                break;
        }
    }
}