package com.example.LocalDelicacies;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertNotNull;
import static support.Assert.FragmentUtil.startFragment;

@RunWith(RobolectricTestRunner.class)

public class ListFragmentTest {
    private ListFragment listFragment;

    @Before
    public void setUp() {
        listFragment = new ListFragment();
        startFragment(listFragment);
    }

    @Test
    public void shouldNotBeNull() throws Exception {
        assertNotNull(listFragment);
    }

    @Test
    public void shouldHaveListView() throws Exception {
//        assertNotNull(listFragment.getView().findViewById(R.id.content_list));
    }

    @Test
    public void shouldHaveAdapter() throws Exception{
        assertNotNull(listFragment.getListAdapter());
    }
}