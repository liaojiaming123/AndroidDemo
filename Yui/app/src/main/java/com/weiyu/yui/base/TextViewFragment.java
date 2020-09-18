package com.weiyu.yui.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ViewAnimator;

import com.weiyu.yui.MyApplication;
import com.weiyu.yui.R;

public class TextViewFragment extends Fragment {
    private Context context;
    public TextViewFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_text_view, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
    }

    @Override
    public void onStart() {
        super.onStart();
        //LinearGradient实现文本渐变
        TextView tv_base_fragment_text_gradient = (TextView) getView().findViewById(R.id.tv_base_fragment_text_gradient);
        LinearGradient mLinearGradient = new LinearGradient(0, 0, tv_base_fragment_text_gradient.getPaint().getTextSize()* tv_base_fragment_text_gradient.getText().length(), 0, Color.parseColor("#FFFF68FF"), Color.parseColor("#FFFED732"), Shader.TileMode.CLAMP);
        tv_base_fragment_text_gradient.getPaint().setShader(mLinearGradient);
        tv_base_fragment_text_gradient.invalidate();
        //多种颜色渐变
        TextView textView = (TextView)getView().findViewById(R.id.tv_base_fragment_text_gradient_multi);
        setTextViewStyles(textView);
        //跑马灯
        TextView textView_marquee = (TextView)getView().findViewById(R.id.tv_base_fragment_marquee);
        textView_marquee.setFocusable(true);
        textView_marquee.setSelected(true);
        textView_marquee.setFocusableInTouchMode(true);
        //ViewAnimator实现文本上下滚动
//        final ViewAnimator viewAnimator = (ViewAnimator)getView().findViewById(R.id.view_animator_base_fragment);
//        viewAnimator.setOutAnimation(context,R.anim.slide_out_up);
//        viewAnimator.setInAnimation(context,R.anim.slide_in_down);
//        @SuppressLint("HandlerLeak")
//        Handler handler = new Handler(){
//            @Override
//            public void handleMessage(@NonNull Message msg) {
//                super.handleMessage(msg);
//                while (true){viewAnimator.showNext();}
//
//            }
//        };
//        handler.sendMessageDelayed(new Message(),2000);

    }
    private void setTextViewStyles(TextView textView) {
        //多种颜色文本渐变
        int[] colors = {Color.RED, Color.GREEN, Color.BLUE};//颜色的数组
        float[] position = {0f, 0.7f, 1.0f};//颜色渐变位置的数组
        LinearGradient linearGradient = new LinearGradient(0, 0, textView.getPaint().getTextSize() * textView.getText().length(), 0, colors, position, Shader.TileMode.CLAMP);
        textView.getPaint().setShader(linearGradient);
        textView.invalidate();
    }

}