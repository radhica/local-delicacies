package com.example.LocalDelicacies;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by bnegron on 7/22/14.
 */
public class DetailActivity extends Activity{

    private ArrayList<BaseModel> items = new ArrayList<BaseModel>();
    private int itemId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        Bundle detailInfo = getIntent().getExtras();
        this.items = (ArrayList<BaseModel>) detailInfo.getSerializable("items");
        this.itemId = detailInfo.getInt("itemId");

        if(items != null)
            populateDetails();
    }

    private void populateDetails() {
        BaseModel detailItem = this.items.get(itemId);

        TextView detailName = (TextView) findViewById(R.id.detail_name);
        detailName.setText(detailItem.getName());

        ImageView detailImage = (ImageView) findViewById(R.id.detail_image);
        detailImage.setImageResource(detailItem.getImageId());

        TextView detailDesc = (TextView) findViewById(R.id.detail_description);
        detailDesc.setText(detailItem.getName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() { }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.base_item,
                    container, false);
            return rootView;
        }
    }
}