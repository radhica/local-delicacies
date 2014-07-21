package com.example.LocalDelicacies;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by mlandaverde on 7/18/14.
 */
public class ListActivity extends Activity {
    private ListView listView;
    private ListAdapter listAdapter;
    private ArrayList<BaseModel> items = new ArrayList<BaseModel>();

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        populateModels(items);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        listView = (ListView) findViewById(R.id.content_list);
        listAdapter = new ListAdapter(this, items);

        listView.setAdapter(listAdapter);
    }

    public ListAdapter getListAdapter() {
        return listAdapter;
    }

    public void populateModels(ArrayList<BaseModel> items) {
    }
}
