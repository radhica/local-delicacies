package com.example.LocalDelicacies;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static support.Assert.FragmentUtil.startFragment;

@RunWith(RobolectricTestRunner.class)
public class ViewPagerAdapterTest {
    ArrayList<View> testPages;
    private ViewPagerAdapter viewPagerAdapter;
    private LinearLayout linearLayout;

    @Before
    public void setUp() throws Exception {
        linearLayout = new LinearLayout(Robolectric.application.getApplicationContext());
        testPages = new ArrayList<View>();
        testPages.add(new View(Robolectric.application.getApplicationContext()));
        testPages.add(new View(Robolectric.application.getApplicationContext()));
        testPages.add(new View(Robolectric.application.getApplicationContext()));
        viewPagerAdapter = new ViewPagerAdapter(testPages);
    }

    private Activity startActivity() {
        ListFragment listFragment = new ListFragment();
        startFragment(listFragment);
        return listFragment.getActivity();
    }

    @Test
    public void shouldNotBeNull(){
        assertNotNull(viewPagerAdapter);

    }

    @Test
    public void instantiateItem_shouldAddViews() throws Exception {
        assertNotNull(linearLayout);
        viewPagerAdapter.instantiateItem(linearLayout,0);
        assertEquals(linearLayout.getChildAt(0), testPages.get(0));
    }

    @Test
    public void destroyItem_shouldRemoveViews() throws Exception {
        viewPagerAdapter.destroyItem(linearLayout,0,testPages.get(0));
        assertEquals(linearLayout.getChildCount(), 0);
    }

    @Test
    public void getCount_shouldReturnAccurateCount() throws Exception {
        assertEquals(viewPagerAdapter.getCount(),3);
    }

}