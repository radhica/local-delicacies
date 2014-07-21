package com.example.LocalDelicacies;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import events.BaseEvent;
import events.CityEvent;
import events.FoodEvent;

import static com.example.LocalDelicacies.MainActivity.postToBus;

/**
 * Created by mlandaverde on 7/21/14.
 */
public class NavDrawerFragment extends Fragment {
    private String[] titles;
    private ListView drawerList;
    private View layout;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.navdrawer, container, false);

        drawerList = (ListView) layout.findViewById(R.id.left_drawer);

        drawerList.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.drawer_list_item, getResources().getStringArray(R.array.titles)));
        drawerList.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                selectItem(position);
                drawerList.setItemChecked(position, true);
            }
        });
        return layout;
    }

    private void selectItem(int position) {
        switch (position){
            case 0:
                postToBus(new CityEvent());
                break;
            case 1:
                postToBus(new FoodEvent());
                break;
            default:
                postToBus(new BaseEvent());
                break;
        }
    }
}
