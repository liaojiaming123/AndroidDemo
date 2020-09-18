package com.weiyu.yui.dialog;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.widget.ListPopupWindow;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.weiyu.yui.R;

import java.util.ArrayList;
import java.util.List;

public class PopupWindowFragment extends Fragment {
    private PopupWindow popupWindow;
    private Context context;
    private ListPopupWindow listPopupWindow;
    private List<String> list = new ArrayList<>();

    public PopupWindowFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        list.add("Android");
        list.add("Java");
        list.add("JavaScript");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_popup_window, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        final View popupWindowSimple = LayoutInflater.from(context).inflate(R.layout.popup_window_simple,null,false);
        final Button btnPopupWindowSimple = (Button)getView().findViewById(R.id.popup_window_simple);
        btnPopupWindowSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow = new PopupWindow();
                popupWindow.setContentView(popupWindowSimple);
                popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.setOutsideTouchable(true);
                popupWindow.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.gainsboro)));
                popupWindow.setFocusable(true);
                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        Toast.makeText(context,"弹框已关闭",Toast.LENGTH_SHORT).show();
                    }
                });
                popupWindow.showAsDropDown(btnPopupWindowSimple);
            }
        });
        final Button btnPopupWindowList = (Button)getView().findViewById(R.id.popup_window_list);
        btnPopupWindowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listPopupWindow = new ListPopupWindow(context);
                listPopupWindow.setAdapter(new ArrayAdapter<String>(context,android.R.layout.simple_expandable_list_item_1,list));
                listPopupWindow.setAnchorView(btnPopupWindowList);
                listPopupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
                listPopupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
                listPopupWindow.setModal(true);
                listPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        Toast.makeText(context,"弹框已关闭",Toast.LENGTH_SHORT).show();
                    }
                });
                listPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(context,"点击了: "+list.get(position),Toast.LENGTH_SHORT).show();
                    }
                });
                listPopupWindow.show();
            }
        });
    }
}