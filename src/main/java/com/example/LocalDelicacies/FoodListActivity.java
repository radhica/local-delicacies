package com.example.LocalDelicacies;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FoodListActivity extends Activity {
    private ListView listView;
    private ListAdapter listAdapter;
    private ArrayList<FoodModel> items;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        items = new ArrayList<FoodModel>();
        items.add(new FoodModel("Tacos","imageUrl1",1));
        items.add(new FoodModel("Gator Tail","imageUrl2",2));
        items.add(new FoodModel("Satchel's Pizza","imageurl3",3));
        items.add(new FoodModel("Some other food","imageUrl1",4));
        items.add(new FoodModel("Suddenly more food","imageUrl2",5));
        items.add(new FoodModel("I love food so much","imageurl3",6));
        items.add(new FoodModel("Gainesville","imageUrl1",7));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_list);

        listView = (ListView) findViewById(R.id.foodList);
        listAdapter = new ListAdapter(this, items);

        listView.setAdapter(listAdapter);
    }

    public ListAdapter getListAdapter() {
        return listAdapter;
    }

}
