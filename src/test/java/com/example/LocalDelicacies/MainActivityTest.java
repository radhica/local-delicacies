package com.example.LocalDelicacies;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {
    private MainActivity mainActivity;

    @Before
    public void setUp() throws Exception {
        mainActivity = Robolectric.buildActivity(MainActivity.class)
                .create()
                .start()
                .resume()
                .get();
    }

    @Test
    public void shouldNotBeNotNull(){
        assertNotNull(mainActivity);
    }

    @Test
    public void shouldHaveNavDrawerFragment(){
        assertNotNull(mainActivity.getFragmentManager().findFragmentById(R.id.navdrawer_fragment));
    }
}