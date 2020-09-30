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

public class InternalStoreFragment extends Fragment {
    private Context context;
    private InternalStoreUtils utils;

    public InternalStoreFragment() {
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
        return inflater.inflate(R.layout.fragment_internal_store, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        utils = new InternalStoreUtils(context);
        final EditText name = (EditText)getView().findViewById(R.id.ev_internal_name);
        final EditText content = (EditText)getView().findViewById(R.id.ev_internal_content);
        Button save = (Button)getView().findViewById(R.id.btn_internal_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    utils.saveFile(name.getText().toString(),content.getText().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(context,"保存成功",Toast.LENGTH_SHORT).show();
            }
        });
        Button read = (Button)getView().findViewById(R.id.btn_internal_read);
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String s = utils.readFile(name.getText().toString());
                    Toast.makeText(context,s,Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Button remove = (Button)getView().findViewById(R.id.btn_internal_remove);
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utils.deleteFile(name.getText().toString());
                Toast.makeText(context,"删除成功",Toast.LENGTH_SHORT).show();
            }
        });
    }
}