package com.example.LocalDelicacies;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static support.Assert.Assert.assertViewIsVisible;

/**
 * Created by bnegron on 7/28/14.
 */

@RunWith(RobolectricTestRunner.class)
public class CoverViewTest {
    private CoverView coverView;

    @Before
    public void setUp() throws Exception{
        coverView = new CoverView(Robolectric.application.getApplicationContext());
    }

    @Test
    public void viewShouldNotBeNull() throws Exception{
        assertNotNull(coverView);
    }

    @Test
    public void viewShouldBeVisible() throws Exception{
        assertEquals(coverView.getVisibility(), View.VISIBLE);
    }

    @Test
    public void shouldHaveTitle() throws Exception {
        assertViewIsVisible(coverView.findViewById(R.id.base_item_title));
    }

    @Test
    public void shouldHaveImage() throws Exception {
        assertViewIsVisible(coverView.findViewById(R.id.base_item_image));
    }

    @Test
    public void shouldHaveSymbol() throws Exception {
        assertViewIsVisible(coverView.findViewById(R.id.base_item_symbol));
    }
}
