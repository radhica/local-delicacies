
package com.example.LocalDelicacies;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Generated("org.jsonschema2pojo")
public class LocationModel extends BaseModel{

    private ArrayList<DelicacyModel> delicacies = new ArrayList<DelicacyModel>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public LocationModel(String title, String description, String imageUrl) {
        super(title, description, imageUrl );
    }

    public LocationModel(String title, String description, String imageUrl, boolean isChecked) {
        super(title, description, imageUrl, isChecked);
    }
    
    public ArrayList<DelicacyModel> getDelicacies() {
        return delicacies;
    }

    public void setDelicacies(ArrayList<DelicacyModel> delicacies) {
        this.delicacies = delicacies;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String title, Object value) {
        this.additionalProperties.put(title, value);
    }

}
