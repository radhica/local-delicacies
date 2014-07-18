package com.example.LocalDelicacies;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
public class FoodListActivityTest {
    private FoodListActivity foodListActivity;

    @Before
    public void setUp() {
        foodListActivity = Robolectric.buildActivity(FoodListActivity.class)
                            .create()
                            .start()
                            .resume()
                            .get();
    }

    @Test
    public void shouldNotBeNull() throws Exception {
        assertNotNull(foodListActivity);
    }

    @Test
    public void shouldHaveListView() throws Exception {

        assertNotNull(foodListActivity.findViewById(R.id.foodList));
    }

    @Test
    public void shouldHaveCityAdapter() throws Exception{
        assertNotNull(foodListActivity.getListAdapter());
    }
}