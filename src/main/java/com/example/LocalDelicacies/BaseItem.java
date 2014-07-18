package com.example.LocalDelicacies;

/**
 * Created by mlandaverde on 7/18/14.
 */
public class BaseItem {
    private String name;
    private String imageUrl;
    private int id;

    public BaseItem(String name, String imageUrl, int id) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.id = id;
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
}
