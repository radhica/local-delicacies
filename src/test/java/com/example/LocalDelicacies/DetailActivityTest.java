package com.example.LocalDelicacies;

import android.content.Intent;
import android.os.Bundle;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
public class DetailActivityTest {
    private DetailActivity detailActivity;
    private Intent intent;
    private Bundle extras;

    @Before
    public void setUp() throws Exception {
        intent = new Intent();
        extras = new Bundle();

        extras.putSerializable("Test", "test");
        intent.putExtras(extras);

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
}