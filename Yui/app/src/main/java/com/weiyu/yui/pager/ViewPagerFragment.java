package com.weiyu.yui.pager;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.weiyu.yui.R;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerFragment extends Fragment {
    private Context context;
    private LinearLayout linearLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private List<View> views = new ArrayList<>();
    private List<CharSequence> charSequences = new ArrayList<>();
    private TextView tvp1, tvp2, tvp3, tvp4;
    private ImageView ivp1, ivp2, ivp3, ivp4;

    public ViewPagerFragment() {
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
        View view1 = LayoutInflater.from(context).inflate(R.layout.viewflipper1,null);
        View view2 = LayoutInflater.from(context).inflate(R.layout.viewflipper2,null);
        View view3 = LayoutInflater.from(context).inflate(R.layout.viewflipper3,null);
        View view4 = LayoutInflater.from(context).inflate(R.layout.viewflipper4,null);
        views.add(view1);
        views.add(view2);
        views.add(view3);
        views.add(view4);
        ivp1 = (ImageView)view1.findViewById(R.id.vf1);
        ivp2 = (ImageView)view2.findViewById(R.id.vf2);
        ivp3 = (ImageView)view3.findViewById(R.id.vf3);
        ivp4 = (ImageView)view4.findViewById(R.id.vf4);
        ivp1.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.raw.vf1));
        ivp2.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.raw.vf2));
        ivp3.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.raw.vf3));
        ivp4.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.raw.vf4));
        ivp1.setScaleType(ImageView.ScaleType.FIT_XY);
        ivp2.setScaleType(ImageView.ScaleType.FIT_XY);
        ivp3.setScaleType(ImageView.ScaleType.FIT_XY);
        ivp4.setScaleType(ImageView.ScaleType.FIT_XY);

        return inflater.inflate(R.layout.fragment_view_pager, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        linearLayout = (LinearLayout) getActivity().findViewById(R.id.linear_pager_activity);
        if (linearLayout.getVisibility() == View.VISIBLE) {
            linearLayout.setVisibility(View.INVISIBLE);
        }
        tvp1 = (TextView) getView().findViewById(R.id.vp_tv1);
        tvp2 = (TextView) getView().findViewById(R.id.vp_tv2);
        tvp3 = (TextView) getView().findViewById(R.id.vp_tv3);
        tvp4 = (TextView) getView().findViewById(R.id.vp_tv4);
        charSequences.add(tvp1.getText());
        charSequences.add(tvp2.getText());
        charSequences.add(tvp3.getText());
        charSequences.add(tvp4.getText());
        viewPagerAdapter = new ViewPagerAdapter(views, charSequences, context);
        viewPager = (ViewPager) getView().findViewById(R.id.view_pager_simple);
        viewPager.setAdapter(viewPagerAdapter);

        viewPager.setPageTransformer(true, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                switch (position) {
                    case 0:
                        tvp1.setTextColor(getResources().getColor(R.color.orange));
                        tvp2.setTextColor(getResources().getColor(R.color.colorPrimary));
                        tvp3.setTextColor(getResources().getColor(R.color.colorPrimary));
                        tvp4.setTextColor(getResources().getColor(R.color.colorPrimary));
                        break;
                    case 1:
                        tvp2.setTextColor(getResources().getColor(R.color.orange));
                        tvp1.setTextColor(getResources().getColor(R.color.colorPrimary));
                        tvp3.setTextColor(getResources().getColor(R.color.colorPrimary));
                        tvp4.setTextColor(getResources().getColor(R.color.colorPrimary));
                        break;
                    case 2:
                        tvp3.setTextColor(getResources().getColor(R.color.orange));
                        tvp2.setTextColor(getResources().getColor(R.color.colorPrimary));
                        tvp1.setTextColor(getResources().getColor(R.color.colorPrimary));
                        tvp4.setTextColor(getResources().getColor(R.color.colorPrimary));
                        break;
                    case 3:
                        tvp4.setTextColor(getResources().getColor(R.color.orange));
                        tvp2.setTextColor(getResources().getColor(R.color.colorPrimary));
                        tvp3.setTextColor(getResources().getColor(R.color.colorPrimary));
                        tvp1.setTextColor(getResources().getColor(R.color.colorPrimary));
                        break;
                }
            }
            @Override
            public void onPageSelected(int position) {
                Toast.makeText(context,charSequences.get(position).toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tvp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0,true);
            }
        });
        tvp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1,true);
            }
        });
        tvp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(2,true);
            }
        });
        tvp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(3,true);
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