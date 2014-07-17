package com.example.LocalDelicacies;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)

public class CityListActivityTest {
    private CityListActivity cityListActivity;

    @Before
    public void setUp() {
        cityListActivity = new CityListActivity();
    }

    @Test
    public void shouldNotBeNull() throws Exception {
        assertNotNull(cityListActivity);
    }

    @Test
    public void shouldHaveListView() throws Exception {
        assertNotNull(cityListActivity.listView);
    }
}