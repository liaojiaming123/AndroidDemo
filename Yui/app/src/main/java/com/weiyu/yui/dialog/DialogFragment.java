package com.weiyu.yui.dialog;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.weiyu.yui.R;

public class DialogFragment extends Fragment {
    private FragmentManager fragmentManager;
    public DialogFragment() {
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
        return inflater.inflate(R.layout.fragment_dialog, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        //AlertDialog Fragment
        Button btn_alert_dialog_fragment = (Button) getView().findViewById(R.id.btn_alert_dialog_fragment);
        btn_alert_dialog_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.frame_layout_dialog_fragment,
                        new AlertDialogFragment()).addToBackStack(null).commit();
            }
        });
        //ProgressBarDialog Fragment
        Button btn_progress_bar_dialog_fragment = (Button)getView().findViewById(R.id.btn_progress_dialog_fragment);
        btn_progress_bar_dialog_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.frame_layout_dialog_fragment,
                        new ProgressDialogFragment()).addToBackStack(null).commit();
            }
        });
        //PopupWindow Fragment
        Button btn_popup_window_fragment = (Button) getView().findViewById(R.id.btn_popup_window_fragment);
        btn_popup_window_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.frame_layout_dialog_fragment,
                        new PopupWindowFragment()).addToBackStack(null).commit();
            }
        });
        //DatePickerDialog Button
        Button btn_date_picker_dialog_fragment = (Button) getView().findViewById(R.id.btn_date_dialog_fragment);
        btn_date_picker_dialog_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.frame_layout_dialog_fragment,
                        new DatePickerDialogFragment()).addToBackStack(null).commit();
            }
        });
    }
}