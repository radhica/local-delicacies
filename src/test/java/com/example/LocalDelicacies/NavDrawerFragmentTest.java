package com.example.LocalDelicacies;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.*;
import static support.Assert.FragmentUtil.startFragment;

@RunWith(RobolectricTestRunner.class)

public class NavDrawerFragmentTest {
    private NavDrawerFragment navDrawerFragment;

    @Before
    public void setUp() throws Exception {
        navDrawerFragment = new NavDrawerFragment();
        startFragment(navDrawerFragment);
    }

    @Test
    public void shouldNotBeNull() throws Exception {
        assertNotNull(navDrawerFragment);
    }

    @Test
    public void shouldContainDrawer() throws Exception {
        assertNotNull(navDrawerFragment.getView().findViewById(R.id.left_drawer));
    }
}