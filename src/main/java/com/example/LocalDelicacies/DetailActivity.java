package com.example.LocalDelicacies;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by bnegron on 7/22/14.
 */
public class DetailActivity extends Activity{

    private BaseModel detailItem;
    private RatingBar ratingBar;
    private int itemId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        ratingBar = (RatingBar) findViewById(R.id.locale_rating_bar);
        Bundle detailInfo = getIntent().getExtras();
        this.detailItem = (BaseModel) detailInfo.getSerializable("item");
        this.itemId = detailInfo.getInt("itemId");
        toggleRatingBarView();

        if(detailItem != null)
            populateDetails();

        getActionBar().setDisplayShowHomeEnabled(false);
    }

    private void populateDetails() {
        TextView detailName = (TextView) findViewById(R.id.base_item_name);
        detailName.setText(detailItem.getTitle());

        ImageView detailImage = (ImageView) findViewById(R.id.base_item_image);
        Picasso.with(this)
                .load(detailItem.getImageUrl())
                .placeholder(R.drawable.placeholder)
                .centerCrop()
                .resizeDimen(R.dimen.image_width,R.dimen.image_height)
                .into(detailImage);

        TextView detailDesc = (TextView) findViewById(R.id.detail_description);
        detailDesc.setText(detailItem.getDescription());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() { }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.base_item, container, false);
            return rootView;
        }
    }

    private void toggleRatingBarView() {
        if (detailItem instanceof Delicacy) {
            ratingBar.setVisibility(View.VISIBLE);
        } else {
            ratingBar.setVisibility(View.GONE);
        }
    }
}