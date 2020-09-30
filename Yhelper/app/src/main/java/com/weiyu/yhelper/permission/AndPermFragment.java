package com.weiyu.yhelper.permission;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.weiyu.yhelper.R;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RequestExecutor;
import com.yanzhenjie.permission.runtime.Permission;

import java.util.List;

public class AndPermFragment extends Fragment {
    private Context context;

    public AndPermFragment() {
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
        return inflater.inflate(R.layout.fragment_and_perm, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Button btnAndPermSimple = (Button)getView().findViewById(R.id.btn_and_perm_simple);
        btnAndPermSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AndPermission.with(context)
                        .runtime()
                        .permission(Permission.ACCESS_FINE_LOCATION)
                        .rationale(mRationale)
                        .onGranted(new Action<List<String>>() {
                            @Override
                            public void onAction(List<String> data) {
                                Toast.makeText(context, "已获得权限", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .onDenied(new Action<List<String>>() {
                            @Override
                            public void onAction(List<String> data) {
                                Toast.makeText(context, "未获得权限", Toast.LENGTH_SHORT).show();

                                if (AndPermission.hasAlwaysDeniedPermission(context, data)) {
                                    // 这些权限被用户总是拒绝。
                                    new AlertDialog.Builder(context)
                                            .setCancelable(false)
                                            .setTitle("提示")
                                            .setMessage("您已禁止弹出权限申请框，请在设置页同意")
                                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    AndPermission.with(context)
                                                            .runtime()
                                                            .setting()
                                                            .start(10);
                                                }
                                            })
                                            .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    Toast.makeText(context, "已取消", Toast.LENGTH_SHORT).show();
                                                }
                                            })
                                            .show();
                                }
                            }
                        })
                        .start();
            }

        });
    }

    private Rationale mRationale = new Rationale() {
        @Override
        public void showRationale(Context context, Object data, final RequestExecutor executor) {
            List<String> permissionNames = Permission.transformText(context,data.toString());
            String message = "请授权该下的权限" + "\n" + permissionNames +"\n" + "不给权限你就看不到附近的小姐姐啦";

            new AlertDialog.Builder(context)
                    .setCancelable(false)
                    .setTitle("提示")
                    .setMessage(message)
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            executor.execute();
                        }
                    })
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            executor.cancel();
                        }
                    })
                    .show();
        }
    };
}