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
import events.DelicacyEvent;
import events.LocationEvent;

/**
 * Created by mlandaverde on 7/21/14.
 */
public class NavDrawerFragment extends Fragment {
    private String[] titles;
    private ListView drawerList;
    private View layout;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.nav_drawer, container, false);

        drawerList = (ListView) layout.findViewById(R.id.left_drawer);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.drawer_list_item, getResources().getStringArray(R.array.titles));
        drawerList.setAdapter(arrayAdapter);
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
                AppBus.getInstance().postToBus(new LocationEvent());
                break;
            case 1:
                AppBus.getInstance().postToBus(new DelicacyEvent());
                break;
            default:
                AppBus.getInstance().postToBus(new BaseEvent());
                break;
        }
    }
}
