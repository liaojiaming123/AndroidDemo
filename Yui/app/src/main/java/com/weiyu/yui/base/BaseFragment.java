package com.weiyu.yui.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.weiyu.yui.R;

public class BaseFragment extends Fragment {
    private FragmentManager fragmentManager;
    public BaseFragment(){
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentManager = getFragmentManager();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_base, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        //TextView Fragment
        Button btn_base_fragment_tv_simple = (Button) getView().findViewById(R.id.btn_base_fragment_tv_simple);
        btn_base_fragment_tv_simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.frame_layout_base_fragment,
                        new TextViewFragment()).addToBackStack(null).commit();
            }
        });
        //EditText Fragment
        Button btn_base_fragment_ev_simple = (Button)getView().findViewById(R.id.btn_base_fragment_ev_simple);
        btn_base_fragment_ev_simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.frame_layout_base_fragment,
                        new EditTextFragment()).addToBackStack(null).commit();
            }
        });
        //ImageView Fragment
        Button btn_base_fragment_iv_simple = (Button) getView().findViewById(R.id.btn_base_fragment_iv_simple);
        btn_base_fragment_iv_simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.frame_layout_base_fragment,
                        new ImageViewFragment()).addToBackStack(null).commit();
            }
        });
        //ImageButton Button
        Button btn_base_fragment_btn_simple = (Button) getView().findViewById(R.id.btn_base_fragment_btn_simple);
        btn_base_fragment_btn_simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.frame_layout_base_fragment,
                        new ButtonFragment()).addToBackStack(null).commit();
            }
        });
        //RadioButton CheckBox
        Button btn_base_fragment_check_simple = (Button) getView().findViewById(R.id.btn_base_fragment_check_simple);
        btn_base_fragment_check_simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.frame_layout_base_fragment,
                        new CheckFragment()).addToBackStack(null).commit();
            }
        });
        //ToggleButton Switch
        Button btn_base_fragment_toggle_simple = (Button) getView().findViewById(R.id.btn_base_fragment_toggle_simple);
        btn_base_fragment_toggle_simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.frame_layout_base_fragment,
                        new ToggleButtonFragment()).addToBackStack(null).commit();
            }
        });
        //ProgressBar
        Button btn_base_fragment_progress_simple = (Button) getView().findViewById(R.id.btn_base_fragment_progress_simple);
        btn_base_fragment_progress_simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.frame_layout_base_fragment,
                        new ProgressBarFragment()).addToBackStack(null).commit();
            }
        });
        //SeekBar
        Button btn_base_fragment_seek_simple = (Button) getView().findViewById(R.id.btn_base_fragment_seek_simple);
        btn_base_fragment_seek_simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.frame_layout_base_fragment,
                        new SeekBarFragment()).addToBackStack(null).commit();
            }
        });
        //ScrollView
        Button btn_scroll_view_simple = (Button) getView().findViewById(R.id.btn_scroll_view_simple);
        btn_scroll_view_simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.frame_layout_base_fragment,
                        new ScrollViewFragment()).addToBackStack(null).commit();
            }
        });
        //RatingBar
        Button btn_rating_bar_simple = (Button) getView().findViewById(R.id.btn_rating_bar_simple);
        btn_rating_bar_simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.frame_layout_base_fragment,
                        new RatingBarFragment()).addToBackStack(null).commit();
            }
        });
        //TimePicker
        Button btn_time_picker_simple = (Button) getView().findViewById(R.id.btn_time_picker_simple);
        btn_time_picker_simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.frame_layout_base_fragment,
                        new TimePickerFragment()).addToBackStack(null).commit();
            }
        });
        //DatePicker
        Button btn_date_picker_simple = (Button) getView().findViewById(R.id.btn_date_picker_simple);
        btn_date_picker_simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.frame_layout_base_fragment,
                        new DatePickerFragment()).addToBackStack(null).commit();
            }
        });
    }
}