package com.weiyu.yhelper.net;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.weiyu.yhelper.R;
import com.weiyu.yhelper.data.ExternalStoreFragment;
import com.weiyu.yhelper.data.InternalStoreFragment;
import com.weiyu.yhelper.data.SharedPreferenceFragment;

public class NetFragment extends Fragment {
    private FragmentManager fragmentManager;

    public NetFragment() {
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
        return inflater.inflate(R.layout.fragment_net, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Button btnConnection = (Button)getView().findViewById(R.id.btn_connection_fragment);
        btnConnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.frame_net_fragment,
                        new ConnectionFragment()).addToBackStack(null).commit();
            }
        });
        Button btnOkHttp = (Button)getView().findViewById(R.id.btn_okhttp_fragment);
        btnOkHttp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.frame_net_fragment,
                        new OkHttpFragment()).addToBackStack(null).commit();
            }
        });
        Button btnVolley = (Button)getView().findViewById(R.id.btn_volley_fragment);
        btnVolley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.frame_net_fragment,
                        new VolleyFragment()).addToBackStack(null).commit();
            }
        });
    }
}