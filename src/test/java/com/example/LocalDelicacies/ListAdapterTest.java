package com.example.LocalDelicacies;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by mlandaverde on 7/17/14.
 */

@RunWith(RobolectricTestRunner.class)

public class ListAdapterTest {
    private ListAdapter listAdapter;
    private ArrayList<BaseItem> items;

    @Before
    public void setUp() throws Exception {
        populateListOfItems();
        listAdapter = new ListAdapter(startActivity(), items);
    }

    private void populateListOfItems() {
        items = new ArrayList<BaseItem>();
        items.add(new BaseItem("Gainesville","imageUrl1",1));
        items.add(new BaseItem("Chicago","imageUrl2",2));
        items.add(new BaseItem("Miami","imageurl3",3));
    }

    private CityListActivity startActivity() {
        return Robolectric.buildActivity(CityListActivity.class)
                .create()
                .start()
                .resume()
                .get();
    }

    @Test
    public void shouldNotBeNull() throws Exception {
        assertNotNull(listAdapter);
    }

    @Test
    public void getCount_shouldReturnProperCount() throws Exception {
        assertEquals(listAdapter.getCount(), items.size());
    }

    @Test
    public void getItem_shouldReturnProperItem(){
        for(int index = 0; index < items.size(); index++)
            assertEquals(listAdapter.getItem(0),items.get(0));
    }

    @Test
    public void getItemId_shouldReturnProperId(){
        for(int index = 0; index < items.size(); index++)
            assertEquals(listAdapter.getItemId(index),index);
    }

}
