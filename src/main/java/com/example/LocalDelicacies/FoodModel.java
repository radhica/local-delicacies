package com.example.LocalDelicacies;

/**
 * Created by mlandaverde on 7/18/14.
 */
public class FoodModel extends BaseModel {
    private int rating;

    public FoodModel(String name, String imageUrl, int id){
        super(name, imageUrl,id);
    }

    public FoodModel(String name, String imageUrl, int id, boolean isChecked, String description, int rating) {
        super(name, imageUrl, id, description, isChecked);
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
