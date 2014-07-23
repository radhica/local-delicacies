package com.example.LocalDelicacies;

import android.app.ActionBar;

import java.util.ArrayList;

public class FoodListFragment extends ListFragment {
    @Override
    public ArrayList<BaseModel> populateModels() {
        items = new ArrayList<BaseModel>();
        pinnedItems = new ArrayList<BaseModel>();

        super.items.add(new FoodModel("Tacos","rolls",0, "Tacos are delicious."));
        super.items.add(new FoodModel("Gator Tail","rolls",1, "Gator is delicious."));
        super.items.add(new FoodModel("Satchel's Pizza","rolls",2, "Pizza is delicious."));
        super.items.add(new FoodModel("Some other food","rolls",3, "Food in general is delicious."));
        super.items.add(new FoodModel("Suddenly more food","rolls",4, "Surprises are delicious."));
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
