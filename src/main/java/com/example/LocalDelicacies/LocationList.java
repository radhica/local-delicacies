
package com.example.LocalDelicacies;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Generated("org.jsonschema2pojo")
public class LocationList {

    private List<LocationModel> locationModels = new ArrayList<LocationModel>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<LocationModel> getLocationModels() {
        return locationModels;
    }

    public void setLocationModels(List<LocationModel> locationModels) {
        this.locationModels = locationModels;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
