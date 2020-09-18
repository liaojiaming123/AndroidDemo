package com.weiyu.yui.base;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.weiyu.yui.R;

public class ScrollViewFragment extends Fragment {
    private Context context;
    public ScrollViewFragment() {
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
        return inflater.inflate(R.layout.fragment_scroll_view, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        HorizontalScrollView scrollView_h = (HorizontalScrollView)getView().findViewById(R.id.scroll_view_simple_h);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            scrollView_h.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                    Toast.makeText(context,"滚动条值发生改变 "+scrollX+"改变前"+oldScrollX,Toast.LENGTH_SHORT).show();
                }
            });
        }
        ScrollView scrollView_v = (ScrollView)getView().findViewById(R.id.scroll_view_simple_v);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            scrollView_v.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                    Toast.makeText(context,"滚动条值发生改变 "+scrollY+"改变前"+oldScrollY,Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}