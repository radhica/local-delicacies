package com.example.LocalDelicacies;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
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

    /**
     * Called when the activity is first created.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {
        populateModels(items);

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

//        class PageListener extends ViewPager.SimpleOnPageChangeListener{
//            public void onPageSelected(int position){
//                currentPage = position;
//            }
//        }

        pages.add(listView);
        ViewPager viewPager = (ViewPager) layout.findViewById(R.id.view_pager);
        viewPagerAdapter = new ViewPagerAdapter(pages);
        viewPager.setAdapter(viewPagerAdapter);

        return layout;
    }

    public ListAdapter getListAdapter() {
        return listAdapter;
    }

    public void populateModels(ArrayList<BaseModel> items) {}
}
