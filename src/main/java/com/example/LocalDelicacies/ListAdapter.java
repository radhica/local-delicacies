package com.example.LocalDelicacies;

import android.content.Context;
import android.view.LayoutInflater;
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
    private Context context;
    private ArrayList<BaseItem> items;

    public ListAdapter(Context context, ArrayList<BaseItem> items) {
        this.context = context;
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
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        final ViewHolder viewHolder;

        if(convertView == null){
            convertView = inflater.inflate(R.layout.base_item, parent, false);
            viewHolder = ViewHolder.createViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        configureImage(items.get(position), viewHolder);
        configureText(items.get(position), viewHolder);
        configureSymbol(items.get(position), viewHolder);

        return convertView;
    }

    private void configureImage(BaseItem baseItem, ViewHolder viewHolder) {
        viewHolder.image.setImageResource(baseItem.getImageId());
    }

    private void configureText(BaseItem baseItem, ViewHolder viewHolder) {
        viewHolder.name.setText(baseItem.getName());
    }

    private void configureSymbol(BaseItem baseItem, ViewHolder viewHolder) {
        //set drawable here
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
