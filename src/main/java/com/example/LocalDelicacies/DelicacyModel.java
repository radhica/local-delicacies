
package com.example.LocalDelicacies;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@Generated("org.jsonschema2pojo")
public class DelicacyModel extends BaseModel{

    private int rating;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public DelicacyModel(String title, String description, String imageUrl){
        super(title, description, imageUrl);
    }

    public DelicacyModel(String title, String description, String imageUrl, int rating) {
        super(title, description, imageUrl);
        this.rating = rating;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
