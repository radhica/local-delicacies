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
import com.google.gson.Gson;
import com.squareup.otto.Subscribe;
import events.DownloadEvent;

import java.util.ArrayList;

public class DelicacyListFragment extends Fragment {

    private ArrayList<DelicacyModel> items;
    private ArrayList<DelicacyModel> pinnedItems;
    protected ArrayList<View> pages = new ArrayList<View>();
    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;
    private View layout;
    private LocationList locationList;

    /**
     * Called when the activity is first created.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        new DownloadFileTask(container.getContext()).execute(getString(R.string.json_url));

        layout = inflater.inflate(R.layout.list_fragment_layout, container, false);
        populateListViews();

        ViewPager viewPager = getViewPager();
        viewPager.setAdapter(viewPagerAdapter);

        return layout;
    }

    public ArrayList<DelicacyModel> populateModels() {
        items = new ArrayList<DelicacyModel>();
        pinnedItems = new ArrayList<DelicacyModel>();

        return items;
    }

    protected void setTabs(ActionBar actionBar, ActionBar.TabListener tabListener) {
        actionBar.removeAllTabs();
        actionBar.addTab(actionBar.newTab()
                .setText("All").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab()
                .setText("Pinned").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab()
                .setText("Rated").setTabListener(tabListener));
    }

    @Subscribe
    public void onDownloadEvent(DownloadEvent downloadEvent) {
        locationList = downloadEvent.getResult();
        ArrayList<LocationModel> locationModels = locationList.getLocationModels();
        for(LocationModel i:locationModels){
            items.addAll(i.getDelicacies());
        }
        Log.d("Download complete; item size:\t", ""+items.size());
        populateListViews();
        viewPagerAdapter.notifyDataSetChanged();
    }

    private void populateListViews() {
        if (items == null)
            items = populateModels();

        ListView listView = createListView(items);
        pages.add(listView);

        checkedPinned();

        ListView pinnedListView = createListView(pinnedItems);
        pages.add(pinnedListView);
    }

    private void checkedPinned() {
        pinnedItems.clear();
        for (DelicacyModel i : items) {
            if (i.isChecked())
                pinnedItems.add(i);
        }
    }

    private ListView createListView(final ArrayList<DelicacyModel> items) {
        ListView allListView = new ListView(layout.getContext());
        ListAdapter allListAdapter = new ListAdapter(getActivity(), items);
        allListView.setAdapter(allListAdapter);
        allListView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent detailView = new Intent(getActivity(), DetailActivity.class);
                detailView.putExtra("items", items);
                detailView.putExtra("itemId", position);
                startActivity(detailView);
            }
        });
        return allListView;
    }

    private ViewPager getViewPager() {
        viewPager = (ViewPager) layout.findViewById(R.id.view_pager);
        viewPagerAdapter = new ViewPagerAdapter(pages);
        viewPager.setOffscreenPageLimit(2);
        return viewPager;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final ActionBar actionBar = getActivity().getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        class PageListener extends ViewPager.SimpleOnPageChangeListener {
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
                checkedPinned();
                ((ListAdapter) ((ListView) pages.get(position)).getAdapter()).notifyDataSetChanged();
            }
        }

        final PageListener pageListener = new PageListener();
        viewPager.setOnPageChangeListener(pageListener);

        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
                actionBar.selectTab(tab);
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
            }
        };

        setTabs(actionBar, tabListener);
    }
}