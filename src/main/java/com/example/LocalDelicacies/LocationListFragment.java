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
import com.squareup.otto.Subscribe;
import events.DownloadEvent;

import java.util.ArrayList;

public class LocationListFragment extends Fragment {

    private ArrayList<LocationModel> items;
    private ArrayList<LocationModel> pinnedItems;
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

    protected void setTabs(ActionBar actionBar, ActionBar.TabListener tabListener) {
        actionBar.removeAllTabs();
        actionBar.addTab(actionBar.newTab()
                .setText("All").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab()
                .setText("Pinned").setTabListener(tabListener));
    }

    @Subscribe
    public void onDownloadEvent(DownloadEvent downloadEvent) {
        populateListViews();
        viewPagerAdapter.notifyDataSetChanged();
    }

    private void populateListViews() {
        this.items = new LocationListLoader(this.getActivity()).loadInBackground();
        Log.d("Loading complete; item size:\t", "" + items.size());

        if (items == null)
            items = populateModels();

        ListView listView = createListView(items);
        pages.add(listView);

        checkedPinned();

        ListView pinnedListView = createListView(pinnedItems);
        pages.add(pinnedListView);
    }

    public ArrayList<LocationModel> populateModels() {
        items = new ArrayList<LocationModel>();
        pinnedItems = new ArrayList<LocationModel>();

        return items;
    }

    private void checkedPinned() {
        pinnedItems.clear();
        for (LocationModel i : items) {
            if (i.isPinned())
                pinnedItems.add(i);
        }
    }

    private ListView createListView(final ArrayList<LocationModel> items) {
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
    public void onResume() {
        AppBus.getInstance().getBus().register(this);
        super.onResume();
    }

    @Override
    public void onPause() {
        AppBus.getInstance().getBus().unregister(this);
        super.onPause();
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