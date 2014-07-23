package com.example.LocalDelicacies;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by bnegron on 7/23/14.
 */
public class ViewPagerAdapter extends PagerAdapter {
    ArrayList<View> pages;

    public ViewPagerAdapter(ArrayList<View> pages) {
        this.pages = pages;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(pages.get(position));
        return pages.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return pages.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
}
