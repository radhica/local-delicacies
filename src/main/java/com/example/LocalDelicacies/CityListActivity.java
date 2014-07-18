package com.example.LocalDelicacies;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CityListActivity extends Activity {
    private ListView listView;
    private ListAdapter listAdapter;
    private ArrayList<InventoryItem> items;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_list);

        listView = (ListView) findViewById(R.id.cityList);
        listAdapter = new ListAdapter(this, items);
    }

    public ListAdapter getListAdapter() {
        return listAdapter;
    }
}
