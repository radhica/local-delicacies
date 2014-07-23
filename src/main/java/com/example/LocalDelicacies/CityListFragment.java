package com.example.LocalDelicacies;

import android.app.ActionBar;

import java.util.ArrayList;

/**
 * Created by mlandaverde on 7/21/14.
 */
public class CityListFragment extends ListFragment {

    @Override
    public ArrayList<BaseModel> populateModels() {
        items = new ArrayList<BaseModel>();
        pinnedItems = new ArrayList<BaseModel>();

        items.add(new CityModel("Gainesville","gville",0, "This is Gainesville."));
        items.add(new CityModel("Chicago","gville",1, "This is Chicago."));
        items.add(new CityModel("Miami","gville",2, "This is Miami."));
        items.add(new CityModel("New York","gville",3, "This is New York."));
        items.add(new CityModel("Atlanta","gville",4, "This is Atlanta."));
        items.add(new CityModel("Philadelphia","gville",5, "This is Philadelphia."));
        return items;
    }


    @Override
    protected void setTabs(ActionBar actionBar, ActionBar.TabListener tabListener) {
        actionBar.removeAllTabs();
        actionBar.addTab(actionBar.newTab()
                .setText("All").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab()
                .setText("Pinned").setTabListener(tabListener));
    }
}
