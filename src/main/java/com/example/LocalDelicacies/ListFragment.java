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
    protected ArrayList<BaseModel> items;
    protected ArrayList<BaseModel> pinnedItems;
    protected ArrayList<View> pages = new ArrayList<View>();
    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;
    private View layout;

    /**
     * Called when the activity is first created.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {

        layout = inflater.inflate(R.layout.list_fragment_layout, container, false);
        populateListViews();

        ViewPager viewPager = getViewPager();
        viewPager.setAdapter(viewPagerAdapter);

        return layout;
    }

    private void populateListViews() {
        if(items == null)
            items = populateModels();

        ListView listView = createListView(items);
        pages.add(listView);

        checkedPinned();

        ListView pinnedListView = createListView(pinnedItems);
        pages.add(pinnedListView);
    }

    private void checkedPinned() {
        pinnedItems.clear();
        for(BaseModel i : items){
            if(i.isChecked())
                pinnedItems.add(i);
        }
    }

    private ListView createListView(final ArrayList<BaseModel> items) {
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

        class PageListener extends ViewPager.SimpleOnPageChangeListener{
            public void onPageSelected(int position){
                actionBar.setSelectedNavigationItem(position);
                checkedPinned();
                ((ListAdapter) ((ListView) pages.get(position)).getAdapter()).notifyDataSetChanged();
            }
        }

        final PageListener pageListener = new PageListener();
        viewPager.setOnPageChangeListener(pageListener);

        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction){
                actionBar.selectTab(tab);
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {}
            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {}
        };

        setTabs(actionBar, tabListener);
    }

    protected void setTabs(ActionBar actionBar, ActionBar.TabListener tabListener) {}

    public ArrayList<BaseModel> populateModels() {return null;}
}
