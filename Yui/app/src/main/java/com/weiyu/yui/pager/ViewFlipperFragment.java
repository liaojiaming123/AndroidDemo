package com.weiyu.yui.pager;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.weiyu.yui.R;

import java.util.ArrayList;
import java.util.List;

public class ViewFlipperFragment extends Fragment {
    private Context context;
    private LinearLayout linearLayout;
    private TextView tvf1, tvf2, tvf3, tvf4;
    private TextView tvfBack,tvfNext;
    private List<TextView> tvfs = new ArrayList<>();

    public ViewFlipperFragment() {
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
        return inflater.inflate(R.layout.fragment_view_flipper, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        linearLayout = (LinearLayout)getActivity().findViewById(R.id.linear_pager_activity);
        if (linearLayout.getVisibility() == View.VISIBLE){
            linearLayout.setVisibility(View.INVISIBLE);
        }
        final ViewFlipper viewFlipper = (ViewFlipper)getView().findViewById(R.id.view_flipper_simple);
        tvf1 = (TextView) getView().findViewById(R.id.vf_tv1);
        tvf2 = (TextView) getView().findViewById(R.id.vf_tv2);
        tvf3 = (TextView) getView().findViewById(R.id.vf_tv3);
        tvf4 = (TextView) getView().findViewById(R.id.vf_tv4);
        tvfBack = (TextView)getView().findViewById(R.id.vf_tv_back);
        tvfNext = (TextView)getView().findViewById(R.id.vf_tv_next);
        tvfs.add(tvf1);tvfs.add(tvf2);tvfs.add(tvf3);tvfs.add(tvf4);
        final View view1 = LayoutInflater.from(context).inflate(R.layout.viewflipper1,null);
        final View view2 = LayoutInflater.from(context).inflate(R.layout.viewflipper2,null);
        final View view3 = LayoutInflater.from(context).inflate(R.layout.viewflipper3,null);
        final View view4 = LayoutInflater.from(context).inflate(R.layout.viewflipper4,null);
//        views.add(view1);views.add(view2);views.add(view3);views.add(view4);
        ImageView vf1 = (ImageView)view1.findViewById(R.id.vf1);
        ImageView vf2 = (ImageView)view2.findViewById(R.id.vf2);
        ImageView vf3 = (ImageView)view3.findViewById(R.id.vf3);
        ImageView vf4 = (ImageView)view4.findViewById(R.id.vf4);
        vf1.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.raw.vf1));
        vf2.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.raw.vf2));
        vf3.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.raw.vf3));
        vf4.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.raw.vf4));
        vf1.setScaleType(ImageView.ScaleType.FIT_XY);
        vf2.setScaleType(ImageView.ScaleType.FIT_XY);
        vf3.setScaleType(ImageView.ScaleType.FIT_XY);
        vf4.setScaleType(ImageView.ScaleType.FIT_XY);
        viewFlipper.addView(view1);
        viewFlipper.addView(view2);
        viewFlipper.addView(view3);
        viewFlipper.addView(view4);
        viewFlipper.setInAnimation(context,R.anim.right_in);
        viewFlipper.setOutAnimation(context,R.anim.right_out);
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        viewFlipper.startFlipping();

        tvf1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.setDisplayedChild(viewFlipper.indexOfChild(view1));
                Toast.makeText(context,"第一页",Toast.LENGTH_SHORT).show();
            }
        });
        tvf2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.setDisplayedChild(viewFlipper.indexOfChild(view2));
                Toast.makeText(context,"第二页",Toast.LENGTH_SHORT).show();
            }
        });
        tvf3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.setDisplayedChild(viewFlipper.indexOfChild(view3));
                Toast.makeText(context,"第三页",Toast.LENGTH_SHORT).show();
            }
        });
        tvf4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.setDisplayedChild(viewFlipper.indexOfChild(view4));
                Toast.makeText(context,"第四页",Toast.LENGTH_SHORT).show();
            }
        });
        tvfNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.showNext();
                Toast.makeText(context,"后一页",Toast.LENGTH_SHORT).show();
            }
        });
        tvfBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.showPrevious();
                Toast.makeText(context,"前一页",Toast.LENGTH_SHORT).show();
            }
        });
        viewFlipper.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    tvfs.get(viewFlipper.getDisplayedChild()).setTextColor(getResources().getColor(R.color.hotPink));
                }
            }
        });
        viewFlipper.getInAnimation().setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                View currentView = viewFlipper.getCurrentView();
                if (currentView.isFocused()){
                    tvfs.get(viewFlipper.getDisplayedChild()).setTextColor(getResources().getColor(R.color.hotPink));
                }
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (linearLayout.getVisibility() == View.INVISIBLE || linearLayout.getVisibility() == View.GONE) {
            linearLayout.setVisibility(View.VISIBLE);
        }
    }
}