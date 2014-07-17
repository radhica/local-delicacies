package com.example.LocalDelicacies;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class CityListActivity extends Activity {
    private ListView listView;
    private CityAdapter cityAdapter;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_list);

        listView = (ListView) findViewById(R.id.cityList);
        cityAdapter = new CityAdapter();
    }

    public CityAdapter getCityAdapter() {
        return cityAdapter;
    }
}
