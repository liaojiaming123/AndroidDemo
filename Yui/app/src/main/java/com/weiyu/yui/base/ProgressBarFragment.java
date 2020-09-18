package com.weiyu.yui.base;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.weiyu.yui.R;

public class ProgressBarFragment extends Fragment {
    private ImageView img_progressBar;
    private AnimationDrawable animationDrawable;

    public ProgressBarFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_progress_bar, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        img_progressBar = (ImageView) getView().findViewById(R.id.img_progress);
        animationDrawable = (AnimationDrawable) img_progressBar.getDrawable();
        running();
        img_progressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (animationDrawable.isRunning()){
                    animationDrawable.stop();
                } else {
                    running();
                }
            }
        });
    }
    private void running() {
        img_progressBar.postDelayed(new Runnable() {
            @Override
            public void run() {
                animationDrawable.start();
            }
        }, 100);
    }
}