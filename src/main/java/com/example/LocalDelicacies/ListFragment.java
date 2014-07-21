package com.example.LocalDelicacies;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * Created by mlandaverde on 7/18/14.
 */
public class ListFragment extends Fragment {
    private ListView listView;
    private View layout;
    private ListAdapter listAdapter;
    private ArrayList<BaseModel> items = new ArrayList<BaseModel>();

    /**
     * Called when the activity is first created.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {
        populateModels(items);

        layout = inflater.inflate(R.layout.list, container, false);

        listView = (ListView) layout.findViewById(R.id.content_list);
        listAdapter = new ListAdapter(getActivity(), items);
        listView.setAdapter(listAdapter);

        return layout;
    }

    public ListAdapter getListAdapter() {
        return listAdapter;
    }

    public void populateModels(ArrayList<BaseModel> items) {}
}
