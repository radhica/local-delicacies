package com.example.LocalDelicacies;

import android.app.ActionBar;

import java.util.ArrayList;

public class DelicacyListFragment extends ListFragment {
    @Override
    public ArrayList<BaseModel> populateModels() {
        items = new ArrayList<BaseModel>();
        pinnedItems = new ArrayList<BaseModel>();

        items.add(new DelicacyModel("Tacos","Tacos are delicious.","rolls" ));
        items.add(new DelicacyModel("Gator Tail","Gator is delicious.","rolls" ));
        items.add(new DelicacyModel("Satchel's Pizza","Pizza is delicious.","rolls"));
        items.add(new DelicacyModel("Some other food","Food in general is delicious.","rolls"));
        items.add(new DelicacyModel("Suddenly more food","Surprises are delicious.","rolls"));
        return items;
    }

    @Override
    protected void setTabs(ActionBar actionBar, ActionBar.TabListener tabListener) {
        actionBar.removeAllTabs();
        actionBar.addTab(actionBar.newTab()
                .setText("All").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab()
                .setText("Pinned").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab()
                .setText("Rated").setTabListener(tabListener));
    }

    //add rated listview to pages
}
