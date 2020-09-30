package com.weiyu.yhelper.net;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.weiyu.yhelper.R;
import com.weiyu.yhelper.data.ExternalStoreUtils;

import java.io.IOException;
import java.text.BreakIterator;

public class ConnectionFragment extends Fragment {
    private Context context;
    private HttpConnectionUtils utils;
    private FragmentActivity activity;
    private EditText content;
    String string;

    public ConnectionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        activity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_connection, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        utils = new HttpConnectionUtils(context);
        final TextView textView = (TextView)getView().findViewById(R.id.tv_conn);
        final EditText name = (EditText)getView().findViewById(R.id.ev_conn_name);
        content = (EditText)getView().findViewById(R.id.ev_conn_content);
        Button load = (Button)getView().findViewById(R.id.btn_conn_load);
        string = getData();
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(string);
                        Toast.makeText(context,"加载成功",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        Button save = (Button)getView().findViewById(R.id.btn_conn_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExternalStoreUtils utils = new ExternalStoreUtils(context);
                try {
                    utils.saveCacheFile(name.getText().toString(),string);
                    Toast.makeText(context,"保存成功",Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Button remove = (Button)getView().findViewById(R.id.btn_conn_remove);
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    private String getData(){
        final String[] str = {"123"};

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    str[0] = utils.getStringSync(content.getText().toString(),5000,5000);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        return str[0];
    }
}