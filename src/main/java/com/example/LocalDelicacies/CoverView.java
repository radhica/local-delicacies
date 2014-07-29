package com.example.LocalDelicacies;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RatingBar;
import android.widget.RelativeLayout;

/**
 * Created by bnegron on 7/28/14.
 */
public class CoverView extends RelativeLayout {
    private boolean showRatingBar;
    private int placeHolder;

    private RatingBar ratingBar;

    public CoverView(Context context) {
        super(context);
        initView(context);
        initRatingBar();
    }

    public CoverView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);

        TypedArray attrArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CoverView, 0, 0);
        try{
            showRatingBar = attrArray.getBoolean(R.styleable.CoverView_showRatingBar, false);
            placeHolder = attrArray.getResourceId(R.styleable.CoverView_placeHolder, R.drawable.placeholder);
        } finally {
            attrArray.recycle();
        }

        initRatingBar();
    }

    private void initRatingBar() {
        ratingBar = (RatingBar) findViewById(R.id.rating_bar);

        if(showRatingBar)
            ratingBar.setVisibility(View.VISIBLE);
        else
            ratingBar.setVisibility(View.GONE);
    }

    public CoverView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(context);
        initRatingBar();
    }

    private View initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.cover_view, this, true);
        initRatingBar();
        return view;
    }

    public int getPlaceHolder() {
        return placeHolder;
    }

    public void setPlaceHolder(int placeHolder) {
        this.placeHolder = placeHolder;
        invalidate();
        requestLayout();
    }

    public boolean getShowRatingBar() {
        return showRatingBar;
    }

    public void setShowRatingBar(boolean showRatingBar) {
        this.showRatingBar = showRatingBar;
        initRatingBar();
        invalidate();
        requestLayout();
    }
}
