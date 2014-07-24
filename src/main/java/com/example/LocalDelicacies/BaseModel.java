package com.example.LocalDelicacies;

import android.app.Activity;

import java.io.Serializable;

import static java.security.AccessController.getContext;

/**
 * Created by mlandaverde on 7/18/14.
 */
public class BaseModel implements Serializable{

    
    private String title;
    private String description;
    private String imageUrl;
    private boolean isChecked;
    
    // Only for local testing purposes
    public BaseModel(String title, String imageUrl, String description) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public BaseModel(String title, String imageUrl, String description, boolean isChecked) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.description = description;
        this.isChecked = isChecked;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getImageId(){
        return R.drawable.placeholder;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public String getDescription() {
        return description;
    }
}
