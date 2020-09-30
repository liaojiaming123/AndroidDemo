package com.weiyu.yhelper.data;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.weiyu.yhelper.R;

public class DataFragment extends Fragment {
    private FragmentManager fragmentManager;
    public DataFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentManager = getFragmentManager();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_data, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Button btnSp = (Button)getView().findViewById(R.id.btn_sp_fragment);
        btnSp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.frame_data_fragment,
                        new SharedPreferenceFragment()).addToBackStack(null).commit();
            }
        });
        Button btnInternal = (Button)getView().findViewById(R.id.btn_internal_fragment);
        btnInternal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.frame_data_fragment,
                        new InternalStoreFragment()).addToBackStack(null).commit();
            }
        });
        Button btnExternal = (Button)getView().findViewById(R.id.btn_external_fragment);
        btnExternal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.frame_data_fragment,
                        new ExternalStoreFragment()).addToBackStack(null).commit();
            }
        });
    }
}