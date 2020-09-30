package com.weiyu.yhelper.permission;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.weiyu.yhelper.R;

public class PermFragment extends Fragment {
    private Context context;
    private FragmentManager fragmentManager;

    public PermFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        fragmentManager = getFragmentManager();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_perm, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Button btnAndPerm = (Button)getView().findViewById(R.id.btn_and_perm_fragment);
        btnAndPerm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.frame_perm_fragment,
                        new AndPermFragment()).addToBackStack(null).commit();
            }
        });
        Button btnEasyPerm = (Button)getView().findViewById(R.id.btn_easy_perm_fragment);
        btnEasyPerm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.frame_perm_fragment,
                        new EasyPermFragment()).addToBackStack(null).commit();
            }
        });
        Button btnMyPerm = (Button)getView().findViewById(R.id.btn_my_perm_fragment);
        btnMyPerm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.frame_perm_fragment,
                        new MyPermFragment()).addToBackStack(null).commit();
            }
        });
    }
}