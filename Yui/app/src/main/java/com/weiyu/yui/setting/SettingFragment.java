package com.weiyu.yui.setting;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.weiyu.yui.R;

import java.io.IOException;

public class SettingFragment extends Fragment {
    private FragmentManager fragmentManager;
    private Context context;


    public SettingFragment() {
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
        return inflater.inflate(R.layout.fragment_setting, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        LinearLayout perm = (LinearLayout)getView().findViewById(R.id.linear_app_perm);
        perm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri = Uri.fromParts("package", context.getPackageName(), null);
                intent.setData(uri);
                try {
                    startActivity(intent);
                }catch (Exception e){
                    Toast.makeText(context,"没有找到相关页面",Toast.LENGTH_SHORT).show();
                }

            }
        });
        LinearLayout process = (LinearLayout)getView().findViewById(R.id.linear_app_proce);
        process.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Settings.ACTION_MANAGE_ALL_APPLICATIONS_SETTINGS);
                try {
                    startActivity(intent);
                }catch (Exception e){
                    Toast.makeText(context,"没有找到相关页面",Toast.LENGTH_SHORT).show();
                }
            }
        });
        LinearLayout update = (LinearLayout)getView().findViewById(R.id.linear_app_update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"update",Toast.LENGTH_SHORT).show();
                AppDownload appDownload = new AppDownload(context);
                try {
                    appDownload.saveFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        LinearLayout about = (LinearLayout)getView().findViewById(R.id.linear_app_about);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.frame_setting_fragment,
                        new AppAboutFragment()).addToBackStack(null).commit();
            }
        });
        LinearLayout yhelp = (LinearLayout)getView().findViewById(R.id.linear_app_y_help);
        yhelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "下载Y助手", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse("http://www.liaojiaming.com/"));
                startActivity(intent);
            }
        });
    }
}