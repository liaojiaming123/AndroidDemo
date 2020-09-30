package com.weiyu.yhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.weiyu.yhelper.data.DataActivity;
import com.weiyu.yhelper.location.LocationActivity;
import com.weiyu.yhelper.net.NetActivity;
import com.weiyu.yhelper.permission.PermActivity;
import com.weiyu.yhelper.sensor.SensorActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnPermActivity,btnLocationActivity,btnSensorActivity;
    private Button btnDataActivity,btnNetActivity;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        btnPermActivity = (Button)findViewById(R.id.btn_perm_activity);
        btnLocationActivity = (Button)findViewById(R.id.btn_location_activity);
        btnSensorActivity = (Button)findViewById(R.id.btn_sensor_activity);
        btnDataActivity = (Button)findViewById(R.id.btn_data_activity);
        btnNetActivity = (Button)findViewById(R.id.btn_internet_activity);
        btnDataActivity.setOnClickListener(this);
        btnNetActivity.setOnClickListener(this);
        btnPermActivity.setOnClickListener(this);
        btnLocationActivity.setOnClickListener(this);
        btnSensorActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_perm_activity:
                startActivity(new Intent(context, PermActivity.class));
                break;
            case R.id.btn_location_activity:
                startActivity(new Intent(context, LocationActivity.class));
                break;
            case R.id.btn_sensor_activity:
                startActivity(new Intent(context, SensorActivity.class));
                break;
            case R.id.btn_data_activity:
                startActivity(new Intent(context, DataActivity.class));
                break;
            case R.id.btn_internet_activity:
                startActivity(new Intent(context, NetActivity.class));
                break;
        }
    }
}