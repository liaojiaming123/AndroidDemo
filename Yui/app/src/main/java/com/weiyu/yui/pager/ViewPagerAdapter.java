package com.weiyu.yui.pager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {
    private List<View> views;
    private Context context;
    private List<CharSequence> charSequences;

    public ViewPagerAdapter(List<View> views,List<CharSequence> charSequences,Context context){
        this.views = views;
        this.charSequences = charSequences;
        this.context = context;
    }

    @Override
    public int getCount() {
        return views.size();
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(views.get(position));
        return views.get(position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        super.destroyItem(container, position, object);
        container.removeView((View) object);

    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return super.getItemPosition(views);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        Toast.makeText(context,charSequences.get(position).toString(),Toast.LENGTH_SHORT).show();
        return charSequences.get(position);
    }
}
