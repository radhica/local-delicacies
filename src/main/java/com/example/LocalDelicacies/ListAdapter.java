package com.example.LocalDelicacies;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.squareup.picasso.Picasso;
import events.ItemSelectedEvent;

import java.util.ArrayList;

/**
 * Created by bnegron on 7/17/14.
 */
public class ListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<? extends BaseModel> items;

    public ListAdapter(Context context, ArrayList<? extends BaseModel> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public BaseModel getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).getId();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        final ViewHolder viewHolder;

        if(convertView == null){
            convertView = inflater.inflate(R.layout.list_item, parent, false);
            viewHolder = ViewHolder.createViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.symbol.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                boolean on = ((ToggleButton) view).isChecked();
                items.get(position).setChecked(on);
            }
        });

        configureImage(items.get(position), viewHolder);
        configureText(items.get(position), viewHolder);
        configureSymbol(items.get(position), viewHolder);

        return convertView;
    }

    //public for testing
    public void configureImage(BaseModel baseModel, ViewHolder viewHolder) {
        int imageId = context.getResources().getIdentifier(baseModel.getImageUrl(),"drawable",context.getPackageName());

        Picasso.with(context)
               .load(imageId)
               .placeholder(R.drawable.placeholder)
               .centerCrop()
               .resizeDimen(R.dimen.image_width,R.dimen.image_height)
               .into(viewHolder.image);

    }

    private void configureText(BaseModel baseModel, ViewHolder viewHolder) {
        viewHolder.name.setText(baseModel.getName());
    }

    private void configureSymbol(BaseModel baseModel, ViewHolder viewHolder) {
        viewHolder.symbol.setChecked(baseModel.isChecked());
    }

    public static class ViewHolder {
        public TextView name;
        public ImageView image;
        public ToggleButton symbol;

        public static ViewHolder createViewHolder(View view) {
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.name = (TextView) view.findViewById(R.id.base_item_name);
            viewHolder.image = (ImageView) view.findViewById(R.id.base_item_image);
            viewHolder.symbol = (ToggleButton) view.findViewById(R.id.base_item_symbol);
            return viewHolder;
        }

    }
}
