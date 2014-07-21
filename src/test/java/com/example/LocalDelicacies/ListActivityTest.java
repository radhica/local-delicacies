package com.example.LocalDelicacies;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)

public class ListActivityTest {
    private ListActivity listActivity;

    @Before
    public void setUp() {
        listActivity = Robolectric.buildActivity(ListActivity.class)
                            .create()
                            .start()
                            .resume()
                            .get();
    }

    @Test
    public void shouldNotBeNull() throws Exception {
        assertNotNull(listActivity);
    }

    @Test
    public void shouldHaveListView() throws Exception {
        assertNotNull(listActivity.findViewById(R.id.content_list));
    }

    @Test
    public void shouldHaveCityAdapter() throws Exception{
        assertNotNull(listActivity.getListAdapter());
    }
}