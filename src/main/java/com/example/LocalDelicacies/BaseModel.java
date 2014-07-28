package com.example.LocalDelicacies;

import java.io.Serializable;

/**
 * Created by mlandaverde on 7/18/14.
 */
public class BaseModel implements Serializable{

    private int id;
    private String title;
    private String description;
    private String imageUrl;
    private boolean pinned;
    
    // Only for local testing purposes
    public BaseModel(String title, String description, String imageUrl) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public BaseModel(String title, String description, String imageUrl, boolean pinned) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.pinned = pinned;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public boolean isPinned() {
        return pinned;
    }

    public void setPinned(boolean pinned) {
        this.pinned = pinned;
    }
}
