package com.weiyu.demorecycle.decoration;

import com.chad.library.adapter.base.entity.SectionEntity;

import java.util.ArrayList;
import java.util.List;

public class MySection extends SectionEntity<String> {
    private boolean isMore;
    public MySection(boolean isHeader,String header) {
        super(isHeader, header);
    }

    public MySection(String data) {
        super(data);
    }
    public static List<MySection> getData(){
        MyData myData = new MyData();
        List<MySection> data = new ArrayList<>();
        data.add(new MySection(true,"赣州市"));
        for (String string : myData.getItemList()) {
            data.add(new MySection(string));
        }
        data.add(new MySection(true,"南昌市"));
        for (String string : myData.getItemList1()) {
            data.add(new MySection(string));
        }
        data.add(new MySection(true,"景德镇市"));
        for (String string : myData.getItemList2()) {
            data.add(new MySection(string));
        }
        data.add(new MySection(true,"萍乡市"));
        for (String string : myData.getItemList3()) {
            data.add(new MySection(string));
        }
        data.add(new MySection(true,"鹰潭市"));
        for (String string : myData.getItemList4()) {
            data.add(new MySection(string));
        }
        data.add(new MySection(true,"九江市"));
        for (String string : myData.getItemList5()) {
            data.add(new MySection(string));
        }
        data.add(new MySection(true,"宜春市"));
        for (String string : myData.getItemList6()) {
            data.add(new MySection(string));
        }
        data.add(new MySection(true,"抚州市"));
        for (String string : myData.getItemList7()) {
            data.add(new MySection(string));
        }
        data.add(new MySection(true,"上饶市"));
        for (String string : myData.getItemList8()) {
            data.add(new MySection(string));
        }
        data.add(new MySection(true,"吉安市"));
        for (String string : myData.getItemList9()) {
            data.add(new MySection(string));
        }
        return data;
    }
}
