package com.example.LocalDelicacies;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by bnegron on 7/17/14.
 */
public class ListAdapter extends BaseAdapter {
    private Activity activity;
    private ArrayList<BaseItem> items;

    public ListAdapter(Activity activity, ArrayList<BaseItem> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public BaseItem getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    public static class ViewHolder {
        public TextView name;
        public ImageView image;
        public Button symbol;

        public static ViewHolder createViewHolder(View view) {
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.name = (TextView) view.findViewById(R.id.base_item_name);
            viewHolder.image = (ImageView) view.findViewById(R.id.base_item_image);
            viewHolder.symbol = (Button) view.findViewById(R.id.base_item_symbol);
            return viewHolder;
        }

    }
}
