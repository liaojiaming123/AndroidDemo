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

public class SharedPreferenceFragment extends Fragment {
    private Context context;
    private SharedPreferenceUtils utils;

    public SharedPreferenceFragment() {
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
        return inflater.inflate(R.layout.fragment_shared_preference, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        EditText name = (EditText)getView().findViewById(R.id.ev_sp_name);
        final EditText content = (EditText)getView().findViewById(R.id.ev_sp_content);
        utils = new SharedPreferenceUtils(context,name.getText().toString(),Context.MODE_PRIVATE);
        Button save = (Button)getView().findViewById(R.id.btn_sp_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utils.save("sp",content.getText().toString());
                Toast.makeText(context,"保存成功",Toast.LENGTH_SHORT).show();
            }
        });
        Button read = (Button)getView().findViewById(R.id.btn_sp_read);
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,utils.getString("sp","def"),Toast.LENGTH_SHORT).show();
            }
        });
        Button remove = (Button)getView().findViewById(R.id.btn_sp_remove);
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utils.remove("sp");
                Toast.makeText(context,"移除成功",Toast.LENGTH_SHORT).show();
            }
        });
    }
}