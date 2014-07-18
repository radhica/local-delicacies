package com.example.LocalDelicacies;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class CityListActivity extends Activity {
    private ListView listView;
    private ListAdapter listAdapter;
    private ArrayList<BaseItem> items;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        items = new ArrayList<BaseItem>();
        items.add(new BaseItem("Gainesville","imageUrl1",1));
        items.add(new BaseItem("Chicago","imageUrl2",2));
        items.add(new BaseItem("Miami","imageurl3",3));
        items.add(new BaseItem("Gainesville","imageUrl1",4));
        items.add(new BaseItem("Chicago","imageUrl2",5));
        items.add(new BaseItem("Miami","imageurl3",6));
        items.add(new BaseItem("Gainesville","imageUrl1",7));
        items.add(new BaseItem("Chicago","imageUrl2",8));
        items.add(new BaseItem("Miami","imageurl3",9));
        items.add(new BaseItem("Miami","imageurl3",10));
        items.add(new BaseItem("Gainesville","imageUrl1",11));
        items.add(new BaseItem("Chicago","imageUrl2",12));
        items.add(new BaseItem("Miami","imageurl3",13));
        items.add(new BaseItem("Gainesville","imageUrl1",14));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_list);

        listView = (ListView) findViewById(R.id.cityList);
        listAdapter = new ListAdapter(this, items);

        listView.setAdapter(listAdapter);
    }

    public ListAdapter getListAdapter() {
        return listAdapter;
    }

}
