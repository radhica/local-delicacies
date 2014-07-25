
package com.example.LocalDelicacies;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Generated("org.jsonschema2pojo")
public class Location extends BaseModel{

    private ArrayList<Delicacy> delicacies = new ArrayList<Delicacy>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Location(String title, String description, String imageUrl) {
        super(title, description, imageUrl );
    }

    public Location(String title, String description, String imageUrl, boolean isChecked) {
        super(title, description, imageUrl, isChecked);
    }
    
    public ArrayList<Delicacy> getDelicacies() {
        return delicacies;
    }

    public void setDelicacies(ArrayList<Delicacy> delicacies) {
        this.delicacies = delicacies;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String title, Object value) {
        this.additionalProperties.put(title, value);
    }

}
