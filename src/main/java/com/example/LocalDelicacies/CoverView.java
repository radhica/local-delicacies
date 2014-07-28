package com.example.LocalDelicacies;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import java.lang.reflect.Type;

/**
 * Created by bnegron on 7/28/14.
 */
public class CoverView extends RelativeLayout {
    boolean showRatingBar;
    int placeHolder;

    public CoverView(Context context) {
        super(context);
        initView(context);
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
    }

    public CoverView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(context);
    }

    private View initView(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.cover_view, this, true);
    }


}
