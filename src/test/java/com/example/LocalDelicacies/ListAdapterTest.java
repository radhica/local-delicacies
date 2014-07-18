package com.example.LocalDelicacies;

import com.example.LocalDelicacies.ListAdapter;
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
    private ArrayList<InventoryItem> items;

    @Before
    public void setUp() throws Exception {
        listAdapter = new ListAdapter(startActivity(), items);
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

}
