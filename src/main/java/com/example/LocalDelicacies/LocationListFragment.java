package com.example.LocalDelicacies;

import android.app.ActionBar;

import java.util.ArrayList;

/**
 * Created by mlandaverde on 7/21/14.
 */
public class LocationListFragment extends ListFragment {

    @Override
    public ArrayList<BaseModel> populateModels() {
        items = new ArrayList<BaseModel>();
        pinnedItems = new ArrayList<BaseModel>();

        items.add(new LocationModel("Gainesville", "This is Gainesville.","gville"));
        items.add(new LocationModel("Chicago", "This is Chicago.","gville"));
        items.add(new LocationModel("Miami", "This is Miami.","gville"));
        items.add(new LocationModel("New York", "This is New York.","gville"));
        items.add(new LocationModel("Atlanta", "This is Atlanta.","gville"));
        items.add(new LocationModel("Philadelphia", "This is Philadelphia.","gville"));
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
