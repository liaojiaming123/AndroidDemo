package com.weiyu.yhelper.permission;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.graphics.Camera;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.weiyu.yhelper.R;

import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;
import pub.devrel.easypermissions.PermissionRequest;

public class EasyPermFragment extends Fragment implements EasyPermissions.PermissionCallbacks {
    private Context context;
    public EasyPermFragment() {
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
        return inflater.inflate(R.layout.fragment_easy_perm, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Button button = (Button)getView().findViewById(R.id.btn_easy_perm_simple);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reqPerm();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);

    }
    public void reqPerm(){
        String[] perms = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
        EasyPermissions.requestPermissions(
                new PermissionRequest.Builder(this,1, perms)
                        .setRationale("软件需要相关权限才能使用")
                        .setPositiveButtonText("确定")
                        .setNegativeButtonText("取消")
                        .setTheme(R.style.Permission_Theme_Dialog)
                        .build());
    }
    EasyPermissions.RationaleCallbacks rationaleCallbacks = new EasyPermissions.RationaleCallbacks() {
        @Override
        public void onRationaleAccepted(int requestCode) {

        }

        @Override
        public void onRationaleDenied(int requestCode) {

        }
    };

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        String s = perms.get(0);
        Toast.makeText(context,"已获得权限"+s,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this).build().show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == AppSettingsDialog.DEFAULT_SETTINGS_REQ_CODE) {
            // Do something after user returned from app settings screen, like showing a Toast.
            Toast.makeText(context,"重新申请权限", Toast.LENGTH_SHORT).show();
        }
    }
}