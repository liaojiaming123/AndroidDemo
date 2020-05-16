package com.weiyu.demopermission;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

public class ReqPermission implements EasyPermissions.PermissionCallbacks{

    Context context;
    AppCompatActivity activity;
    public final String[] perms = {Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.CAMERA};

   public void reqPerms() {
       if (EasyPermissions.hasPermissions(context, perms)) {

       } else {
           EasyPermissions.requestPermissions(activity, "", 100, perms);
       }
   }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        EasyPermissions.onRequestPermissionsResult(requestCode,permissions,grantResults,this);
    }


    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        if (EasyPermissions.somePermissionPermanentlyDenied(activity, perms)) {
            new AppSettingsDialog.Builder(activity).build().show();
        }
    }

    @AfterPermissionGranted(100)
    public void onPermissionsSuccess() {
        Toast.makeText(context,"",Toast.LENGTH_SHORT).show();
    }


}
