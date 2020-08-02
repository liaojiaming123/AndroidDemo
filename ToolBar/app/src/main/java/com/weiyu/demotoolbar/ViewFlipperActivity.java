package com.weiyu.demotoolbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ViewFlipper;

import androidx.viewpager.widget.ViewPager;

public class ViewFlipperActivity extends AppCompatActivity {
    private ViewFlipper viewFlipper;

    private final static int MIN_MOVE = 200;   //最小距离
//    private MyGestureListener mgListener;
    private GestureDetector mDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flipper);
        viewFlipper = (ViewFlipper)findViewById(R.id.view_flipper);
        View view1 = LayoutInflater.from(this).inflate(R.layout.viewflipper1,null);
        View view2 = LayoutInflater.from(this).inflate(R.layout.viewflipper2,null);
        View view3 = LayoutInflater.from(this).inflate(R.layout.viewflipper3,null);
        View view4 = LayoutInflater.from(this).inflate(R.layout.viewflipper4,null);
        viewFlipper.addView(view1);
        viewFlipper.addView(view2);
        viewFlipper.addView(view3);
        viewFlipper.addView(view4);
        viewFlipper.setInAnimation(ViewFlipperActivity.this,R.anim.right_in);
        viewFlipper.setOutAnimation(ViewFlipperActivity.this,R.anim.right_out);
        viewFlipper.setFlipInterval(2000);
        viewFlipper.setAutoStart(true);

    }
    //重写onTouchEvent触发MyGestureListener里的方法
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        return mDetector.onTouchEvent(event);
//    }
//    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
//        @Override
//        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
//            if(e1.getX() - e2.getX() > MIN_MOVE){
//                viewFlipper.setInAnimation(ViewFlipperActivity.this,R.anim.right_in);
//                viewFlipper.setOutAnimation(ViewFlipperActivity.this, R.anim.right_out);
//                viewFlipper.showNext();
//            }else if(e2.getX() - e1.getX() > MIN_MOVE){
//                viewFlipper.setInAnimation(ViewFlipperActivity.this,R.anim.left_in);
//                viewFlipper.setOutAnimation(ViewFlipperActivity.this, R.anim.left_out);
//                viewFlipper.showPrevious();
//            }
//            return super.onFling(e1, e2, velocityX, velocityY);
//        }
//    }
}
