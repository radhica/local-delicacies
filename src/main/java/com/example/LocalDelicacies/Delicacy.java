
package com.example.LocalDelicacies;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@Generated("org.jsonschema2pojo")
public class Delicacy extends BaseModel{

    private int rating;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Delicacy(String title, String description, String imageUrl){
        super(title, description, imageUrl);
    }

    public Delicacy(String title, String description, String imageUrl, boolean pinned) {
        super(title, imageUrl, description, pinned);
    }

    public Delicacy(String title, String description, String imageUrl, boolean pinned, int rating) {
        super(title, description, imageUrl, pinned);
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
