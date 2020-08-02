package com.weiyu.demotoolbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity {
    private Button btn_toast1,btn_toast2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        btn_toast1 = findViewById(R.id.btn_toast1);
        btn_toast2 = findViewById(R.id.btn_toast2);
        btn_toast1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(ToastActivity.this,"这个是自定义Toast1",Toast.LENGTH_SHORT);
            }
        });
        btn_toast2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast2(ToastActivity.this,"这个是自定义Toast2",Toast.LENGTH_SHORT);
            }
        });
    }
    private void showToast(Context context, String str, int showTime){
        Toast toast = Toast.makeText(context, str, showTime);
        toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL , 0, 0);  //设置显示位置
        TextView v = toast.getView().findViewById(android.R.id.message);
        v.setBackgroundColor(getResources().getColor(R.color.aqua));
        v.setTextColor(Color.WHITE);     //设置字体颜色
        toast.show();
    }
    private void showToast2(Context context,String str, int showTime)
    {
        Toast toast = Toast.makeText(context, str, showTime);
        toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.BOTTOM , 0, 0);  //设置显示位置
        LinearLayout layout = (LinearLayout) toast.getView();
        layout.setBackgroundColor(Color.WHITE);
        ImageView image = new ImageView(this);
        image.setImageResource(R.mipmap.ic_launcher_round);
        layout.addView(image, 0);
        TextView v = toast.getView().findViewById(android.R.id.message);
        v.setBackgroundColor(getResources().getColor(R.color.aqua));
        v.setTextColor(Color.WHITE);     //设置字体颜色
        toast.show();
    }
}
