package com.example.LocalDelicacies;

import android.app.Activity;
import android.view.View;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertNotNull;
import static support.Assert.FragmentUtil.startFragment;

@RunWith(RobolectricTestRunner.class)
public class ViewPagerAdapterTest {
    View view;

    @Before
    public void setUp() throws Exception {
        view = View.inflate(startActivity(),R.layout.list_fragment_layout,null);
    }

    private Activity startActivity() {
        ListFragment listFragment = new ListFragment();
        startFragment(listFragment);
        return listFragment.getActivity();
    }

    @Test
    public void viewShouldNotBeNull(){
        assertNotNull(view);

    }

    @Test
    public void testInstantiateItem() throws Exception {

    }

    @Test
    public void testDestroyItem() throws Exception {

    }

    @Test
    public void testGetCount() throws Exception {

    }

    @Test
    public void testIsViewFromObject() throws Exception {

    }
}