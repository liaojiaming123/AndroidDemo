package com.weiyu.yhelper.permission;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.weiyu.yhelper.R;

public class MyPermFragment extends Fragment {
    private Context context;

    public MyPermFragment() {
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
        return inflater.inflate(R.layout.fragment_my_perm, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Button button = (Button) getView().findViewById(R.id.btn_my_perm_simple);
        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                reqPerm();
            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void reqPerm(){
        if (context.checkSelfPermission(Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED){
            Toast.makeText(context,"已获得权限",Toast.LENGTH_SHORT).show();
        }else {
            getActivity().requestPermissions(new String[]{Manifest.permission.CAMERA},5);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==5){
        }
    }
}