package com.example.LocalDelicacies;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class CityListActivity extends Activity {
    private ListView listView;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_list);

        listView = (ListView) findViewById(R.id.cityList);
    }
}
