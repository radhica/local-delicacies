package com.example.LocalDelicacies;

/**
 * Created by mlandaverde on 7/18/14.
 */
public class BaseModel {

    private int id;
    private boolean isChecked;

    private String name;
    private String imageUrl;
    private String description;

    // Only for local testing purposes
    public BaseModel(String name, String imageUrl, int id) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.id = id;
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
