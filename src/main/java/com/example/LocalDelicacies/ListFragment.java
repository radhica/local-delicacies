package com.example.LocalDelicacies;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by mlandaverde on 7/18/14.
 */
public class ListFragment extends Fragment {
    private ViewPagerAdapter viewPagerAdapter;
    private ListView listView;
    private View layout;
    private ListAdapter listAdapter;
    private ArrayList<BaseModel> items = new ArrayList<BaseModel>();
    private ArrayList<View> pages = new ArrayList<View>();
    private int currentPage;

    /**
     * Called when the activity is first created.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {
        final ActionBar actionBar = getActivity().getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        populateModels(items);
        //Log.d("Model Class: ", items.get(0).getClass().);

        layout = inflater.inflate(R.layout.list_fragment_layout, container, false);

        listView = new ListView(layout.getContext());
        listAdapter = new ListAdapter(getActivity(), items);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent detailView = new Intent(getActivity(), DetailActivity.class);
                detailView.putExtra("items", items);
                detailView.putExtra("itemId", position);
                startActivity(detailView);
            }
        });

        class PageListener extends ViewPager.SimpleOnPageChangeListener{
            public void onPageSelected(int position){
                actionBar.setSelectedNavigationItem(position);
            }
        }

        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
                    actionBar.selectTab(tab);
            }
            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
            }
            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
            }
        };

        setTabs(actionBar, tabListener);

        pages.add(listView);
        ViewPager viewPager = (ViewPager) layout.findViewById(R.id.view_pager);
        viewPagerAdapter = new ViewPagerAdapter(pages);
        viewPager.setAdapter(viewPagerAdapter);

        return layout;
    }

    private void setTabs(ActionBar actionBar, ActionBar.TabListener tabListener) {
        actionBar.removeAllTabs();
        if(items.get(0).getClass().getSimpleName().equals("CityModel")){
            actionBar.addTab(actionBar.newTab()
                    .setText("All Cities").setTabListener(tabListener));
            actionBar.addTab(actionBar.newTab()
                    .setText("Pinned Cities").setTabListener(tabListener));
        }
        else{
            actionBar.addTab(actionBar.newTab()
                    .setText("All Delicacies").setTabListener(tabListener));
            actionBar.addTab(actionBar.newTab()
                    .setText("Pinned Delicacies").setTabListener(tabListener));
            actionBar.addTab(actionBar.newTab()
                    .setText("Rated Delicacies").setTabListener(tabListener));
        }
    }

    public ListAdapter getListAdapter() {
        return listAdapter;
    }

    public void populateModels(ArrayList<BaseModel> items) {}
}
