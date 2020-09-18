package com.weiyu.yui.base;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.weiyu.yui.R;

public class CheckFragment extends Fragment {
    private Context context;
    public CheckFragment() {
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
        return inflater.inflate(R.layout.fragment_check, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        //单选按钮组
        RadioGroup radioGroup = (RadioGroup)getView().findViewById(R.id.radio_group_fruit);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioButton:
                        Toast.makeText(context,"选择了苹果",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton2:
                        Toast.makeText(context,"选择了西瓜",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton3:
                        Toast.makeText(context,"选择了樱桃",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        //多选按钮
        CheckBox checkBox = (CheckBox)getView().findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(context,"选择了苹果",Toast.LENGTH_SHORT).show();
                }else Toast.makeText(context,"取消了苹果",Toast.LENGTH_SHORT).show();
            }
        });
        CheckBox checkBox2 = (CheckBox)getView().findViewById(R.id.checkBox2);
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(context,"选择了西瓜",Toast.LENGTH_SHORT).show();
                }else Toast.makeText(context,"取消了西瓜",Toast.LENGTH_SHORT).show();
            }
        });
        CheckBox checkBox3 = (CheckBox)getView().findViewById(R.id.checkBox3);
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(context,"选择了樱桃",Toast.LENGTH_SHORT).show();
                }else Toast.makeText(context,"取消了樱桃",Toast.LENGTH_SHORT).show();
            }
        });
        //单选按钮组
        RadioGroup radioGroup_c = (RadioGroup)getView().findViewById(R.id.radio_group_fruit_c);
        radioGroup_c.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioButton_c:
                        Toast.makeText(context,"选择了苹果",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton2_c:
                        Toast.makeText(context,"选择了西瓜",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton3_c:
                        Toast.makeText(context,"选择了樱桃",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        //多选按钮
        CheckBox checkBox_c = (CheckBox)getView().findViewById(R.id.checkBox_c);
        checkBox_c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(context,"选择了苹果",Toast.LENGTH_SHORT).show();
                }else Toast.makeText(context,"取消了苹果",Toast.LENGTH_SHORT).show();
            }
        });
        CheckBox checkBox2_c = (CheckBox)getView().findViewById(R.id.checkBox2_c);
        checkBox2_c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(context,"选择了西瓜",Toast.LENGTH_SHORT).show();
                }else Toast.makeText(context,"取消了西瓜",Toast.LENGTH_SHORT).show();
            }
        });
        CheckBox checkBox3_c = (CheckBox)getView().findViewById(R.id.checkBox3_c);
        checkBox3_c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(context,"选择了樱桃",Toast.LENGTH_SHORT).show();
                }else Toast.makeText(context,"取消了樱桃",Toast.LENGTH_SHORT).show();
            }
        });
    }
}