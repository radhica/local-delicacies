package com.example.LocalDelicacies;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by mlandaverde on 7/21/14.
 */
public class NavDrawerFragment extends Fragment {
    private String[] titles;
    private View layout;
    private ListView drawerList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.navdrawer, container, false);

        titles = getResources().getStringArray(R.array.titles);
        drawerList = (ListView) layout.findViewById(R.id.left_drawer);

        drawerList.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.drawer_list_item, titles));
        drawerList.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                FragmentManager fragment = getFragmentManager();

                switch (position) {
                    case 0:
                        break;
                    case 1:
                        break;
                }
            }
        });

        return layout;
    }
}
