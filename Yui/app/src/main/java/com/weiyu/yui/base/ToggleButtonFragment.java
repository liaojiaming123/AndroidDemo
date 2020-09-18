package com.weiyu.yui.base;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.weiyu.yui.R;

public class ToggleButtonFragment extends Fragment {
    private Context context;
    public ToggleButtonFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_toggle_button, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        //ToggleButton 开关按钮
        ToggleButton tgb_on = (ToggleButton)getView().findViewById(R.id.tgb_on);
        tgb_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(context,"已开启",Toast.LENGTH_SHORT).show();
                }else Toast.makeText(context,"已关闭",Toast.LENGTH_SHORT).show();
            }
        });
        ToggleButton tgb_off = (ToggleButton)getView().findViewById(R.id.tgb_off);
        tgb_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(context,"已开启",Toast.LENGTH_SHORT).show();
                }else Toast.makeText(context,"已关闭",Toast.LENGTH_SHORT).show();
            }
        });
        ToggleButton tgb_disable = (ToggleButton)getView().findViewById(R.id.tgb_disable);
        tgb_disable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(context,"已开启",Toast.LENGTH_SHORT).show();
                }else Toast.makeText(context,"已关闭",Toast.LENGTH_SHORT).show();
            }
        });
        ToggleButton tgb_on_c = (ToggleButton)getView().findViewById(R.id.tgb_on_c);
        tgb_on_c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(context,"已开启",Toast.LENGTH_SHORT).show();
                }else Toast.makeText(context,"已关闭",Toast.LENGTH_SHORT).show();
            }
        });
        ToggleButton tgb_off_c = (ToggleButton)getView().findViewById(R.id.tgb_off_c);
        tgb_off_c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(context,"已开启",Toast.LENGTH_SHORT).show();
                }else Toast.makeText(context,"已关闭",Toast.LENGTH_SHORT).show();
            }
        });
        ToggleButton tgb_disable_c = (ToggleButton)getView().findViewById(R.id.tgb_disable_c);
        tgb_disable_c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(context,"已开启",Toast.LENGTH_SHORT).show();
                }else Toast.makeText(context,"已关闭",Toast.LENGTH_SHORT).show();
            }
        });
        //Switch 开关
        Switch swh_on = (Switch)getView().findViewById(R.id.switch_on);
        swh_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(context,"已开启",Toast.LENGTH_SHORT).show();
                }else Toast.makeText(context,"已关闭",Toast.LENGTH_SHORT).show();
            }
        });
        Switch swh_off = (Switch)getView().findViewById(R.id.switch_off);
        swh_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(context,"已开启",Toast.LENGTH_SHORT).show();
                }else Toast.makeText(context,"已关闭",Toast.LENGTH_SHORT).show();
            }
        });
        Switch swh_disable = (Switch)getView().findViewById(R.id.switch_disable);
        swh_disable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(context,"已开启",Toast.LENGTH_SHORT).show();
                }else Toast.makeText(context,"已关闭",Toast.LENGTH_SHORT).show();
            }
        });
        Switch swh_on_c = (Switch)getView().findViewById(R.id.switch_on_c);
        swh_on_c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(context,"已开启",Toast.LENGTH_SHORT).show();
                }else Toast.makeText(context,"已关闭",Toast.LENGTH_SHORT).show();
            }
        });
        Switch swh_off_c = (Switch)getView().findViewById(R.id.switch_off_c);
        swh_off_c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(context,"已开启",Toast.LENGTH_SHORT).show();
                }else Toast.makeText(context,"已关闭",Toast.LENGTH_SHORT).show();
            }
        });
        Switch swh_disable_c = (Switch)getView().findViewById(R.id.switch_disable_c);
        swh_disable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(context,"已开启",Toast.LENGTH_SHORT).show();
                }else Toast.makeText(context,"已关闭",Toast.LENGTH_SHORT).show();
            }
        });
    }
}