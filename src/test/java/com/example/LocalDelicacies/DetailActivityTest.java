package com.example.LocalDelicacies;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
public class DetailActivityTest {
    private DetailActivity detailActivity;
    private Intent intent;
    private Bundle extras;

    @Before
    public void setUp() throws Exception {
        intent = new Intent();

        ArrayList<BaseModel> items = new ArrayList<BaseModel>();

        items.add(new DelicacyModel("name", "asdfas","placeholder"));

        intent.putExtra("items", items);
        intent.putExtra("itemId", 0);

        detailActivity = Robolectric.buildActivity(DetailActivity.class)
                .withIntent(intent)
                .create()
                .start()
                .resume()
                .get();
    }

    @Test
    public void shouldNotBeNull() throws Exception {
        assertNotNull(detailActivity);
    }

    @Test
    public void shouldHaveIntent() throws Exception {
        assertEquals(detailActivity.getIntent(),
                intent);
    }

    @Test
    public void shouldHaveDescriptionTextView() throws Exception {
        assertNotNull(detailActivity.findViewById(R.id.detail_description));
    }
}