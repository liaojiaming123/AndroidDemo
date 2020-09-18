package com.weiyu.yui.recycler.brvah;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.weiyu.yui.R;

public class BrvahFragment extends Fragment {
    private Context context;
    private LinearLayout linearLayout;
    private FragmentManager fragmentManager;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        fragmentManager = getFragmentManager();
    }
    public BrvahFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_brvah, container, false);
    }
    @Override
    public void onStart() {
        super.onStart();
        linearLayout = (LinearLayout)getActivity().findViewById(R.id.linear_recycler_activity);
        if (linearLayout.getVisibility() == View.VISIBLE){
            linearLayout.setVisibility(View.INVISIBLE);
        }
        Button btnBrvahSimple = (Button)getView().findViewById(R.id.btn_brvah_simple);
        btnBrvahSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.frame_recycler_fragment,
                        new BrvahSimpleFragment()).addToBackStack(null).commit();
            }
        });
        Button btnBrvahHeader = (Button)getView().findViewById(R.id.btn_brvah_header);
        btnBrvahHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.frame_recycler_fragment,
                        new BrvahHeaderFragment()).addToBackStack(null).commit();
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