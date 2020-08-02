package com.weiyu.demotoolbar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ProgressBarActivity extends AppCompatActivity {
    private AnimationDrawable animationDrawable;
    private ImageView img_progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        img_progressBar = findViewById(R.id.img_progress);
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
    private void running(){
        img_progressBar.postDelayed(new Runnable() {
            @Override
            public void run() {
                animationDrawable.start();
            }
        },100);
    }
}
