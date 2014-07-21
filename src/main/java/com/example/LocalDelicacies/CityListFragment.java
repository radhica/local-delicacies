package com.example.LocalDelicacies;

import java.util.ArrayList;

/**
 * Created by mlandaverde on 7/21/14.
 */
public class CityListFragment extends ListFragment {

    @Override
    public void populateModels(ArrayList<BaseModel> items) {
        items.add(new CityModel("Gainesville","imageUrl1",1));
        items.add(new CityModel("Chicago","imageUrl2",2));
        items.add(new CityModel("Miami","imageurl3",3));
        items.add(new CityModel("Gainesville","imageUrl1",4));
        items.add(new CityModel("Chicago","imageUrl2",5));
        items.add(new CityModel("Miami","imageurl3",6));
        items.add(new CityModel("Gainesville","imageUrl1",7));
        items.add(new CityModel("Chicago","imageUrl2",8));
        items.add(new CityModel("Miami","imageurl3",9));
        items.add(new CityModel("Miami","imageurl3",10));
        items.add(new CityModel("Gainesville","imageUrl1",11));
        items.add(new CityModel("Chicago","imageUrl2",12));
        items.add(new CityModel("Miami","imageurl3",13));
        items.add(new CityModel("Gainesville","imageUrl1",14));
    }
}
