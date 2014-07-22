package com.example.LocalDelicacies;

import android.app.Activity;

import java.io.Serializable;

import static java.security.AccessController.getContext;

/**
 * Created by mlandaverde on 7/18/14.
 */
public class BaseModel implements Serializable{

    private int id;
    private boolean isChecked;

    private String name;
    private String imageUrl;
    private String description;

    // Only for local testing purposes
    public BaseModel(String name, String imageUrl, int id, String description) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.id = id;
        this.description = description;
    }

    public BaseModel(String name, String imageUrl, int id, String description, boolean isChecked) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.id = id;
        this.description = description;
        this.isChecked = isChecked;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getImageId(){
        return R.drawable.gville;
    }

    public int getId() {
        return id;
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
