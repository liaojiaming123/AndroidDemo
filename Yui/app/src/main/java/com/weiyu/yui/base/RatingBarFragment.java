package com.weiyu.yui.base;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.Toast;

import com.weiyu.yui.R;

public class RatingBarFragment extends Fragment {
    private Context context;

    public RatingBarFragment() {
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
        return inflater.inflate(R.layout.fragment_rating_bar, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        RatingBar ratingBar = (RatingBar)getView().findViewById(R.id.rating_bar_simple);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(context,"当前评分值"+rating,Toast.LENGTH_SHORT).show();
            }
        });
    }
}