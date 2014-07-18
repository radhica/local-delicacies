package com.example.LocalDelicacies;

/**
 * Created by mlandaverde on 7/18/14.
 */
public class CityModel extends BaseModel {
    private long latitude;
    private long longitude;

    // Only for local testing purposes
    public CityModel(String name, String imageUrl, int id) {
        super(name, imageUrl, id);
    }

    public CityModel(String name, String imageUrl, int id, boolean isChecked, String description, long latitude, long longitude) {
        super(name, imageUrl, id, description, isChecked);
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public long getLatitude() {
        return latitude;
    }

    public long getLongitude() {
        return longitude;
    }
}
