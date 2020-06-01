package com.weiyu.demoview.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.weiyu.demoview.R;

public class ListviewActivity extends AppCompatActivity {
    private ListView listView;
    String[] data = {"你与星河 皆可收藏","山高水長 一定再見","寒來暑往 秋收冬藏","晚晚皆安 夜夜皆空","滿眼醉意 山河皆你","你是迷途 但不知返","夜色匆忙 暮暮是你"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,data);
        listView = (ListView)findViewById(R.id.listview_simple);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),data[position],Toast.LENGTH_SHORT).show();
            }
        });
    }

}
