package com.weiyu.demoview.listview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.weiyu.demoview.R;

public class BaseListActivity extends AppCompatActivity {
    private ListView listView;
    private TextView textView;
    private EditText editText;
    String[] data = {"你与星河 皆可收藏","山高水長 一定再見","寒來暑往 秋收冬藏","晚晚皆安 夜夜皆空","滿眼醉意 山河皆你","你是迷途 但不知返","夜色匆忙 暮暮是你"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_list);
        MyAdapter adapter = new MyAdapter();
        listView = (ListView)findViewById(R.id.baselist);
        textView = (TextView)findViewById(R.id.tv_baselist);
        editText = (EditText)findViewById(R.id.etv_baselist);
        listView.setAdapter(adapter);

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.baselist_item,data);

    }
    class MyAdapter extends BaseAdapter{
        class ViewHolder extends RecyclerView.ViewHolder{
            private ImageView imageView;
            private TextView textView;
            private EditText editText;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
            }
        }

        @Override
        public int getCount() {
            return data.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            if (convertView == null){
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.baselist_item,parent,false);
                viewHolder = new ViewHolder(convertView);
                viewHolder.imageView = (ImageView)convertView.findViewById(R.id.image_baselist);
                viewHolder.textView = (TextView)convertView.findViewById(R.id.tv_baselist);
                viewHolder.editText = (EditText)convertView.findViewById(R.id.etv_baselist);
                convertView.setTag(viewHolder);
            }else {
                viewHolder = (ViewHolder)convertView.getTag();
            }
            viewHolder.textView.setText(data[position]);
            viewHolder.editText.setText("1390123456"+position);

            return convertView;
        }
    }

}
