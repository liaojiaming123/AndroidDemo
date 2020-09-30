package com.weiyu.yhelper.data;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.weiyu.yhelper.R;

import java.io.IOException;

public class ExternalStoreFragment extends Fragment {
    private Context context;
    private ExternalStoreUtils utils;

    public ExternalStoreFragment() {
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
        return inflater.inflate(R.layout.fragment_external_store, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        utils = new ExternalStoreUtils(context);
        final EditText name = (EditText)getView().findViewById(R.id.ev_external_name);
        final EditText content = (EditText)getView().findViewById(R.id.ev_external_content);
        Button save = (Button)getView().findViewById(R.id.btn_external_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String f = utils.getFilePath(name.getText().toString());
                    utils.saveFile(f,content.getText().toString());
                    Toast.makeText(context,"保存成功",Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        Button read = (Button)getView().findViewById(R.id.btn_external_read);
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String f = utils.getFilePath(name.getText().toString());
                    Toast.makeText(context,utils.readFile(f),Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Button remove = (Button)getView().findViewById(R.id.btn_external_remove);
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String f = utils.getFilePath(name.getText().toString());
                utils.deleteFile(f);
                Toast.makeText(context,"删除成功",Toast.LENGTH_SHORT).show();
            }
        });
        Button cache = (Button)getView().findViewById(R.id.btn_external_cache);
        cache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    utils.saveCacheFile(name.getText().toString(),content.getText().toString());
                    Toast.makeText(context,"保存成功",Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}