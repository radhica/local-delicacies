package com.example.LocalDelicacies;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by bnegron on 7/17/14.
 */
public class ListAdapter extends BaseAdapter {
    private Activity activity;
    private ArrayList<InventoryItem> items;

    public ListAdapter(Activity activity, ArrayList<InventoryItem> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return 0;
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
        return null;
    }
}
