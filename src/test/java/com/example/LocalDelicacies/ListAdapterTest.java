package com.example.LocalDelicacies;

import android.app.Activity;
import android.view.View;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.util.ArrayList;

import static com.example.LocalDelicacies.ListAdapter.ViewHolder.createViewHolder;
import static org.junit.Assert.*;
import static support.Assert.Assert.assertViewIsVisible;
import static support.Assert.FragmentUtil.startFragment;

/**
 * Created by mlandaverde on 7/17/14.
 */

@RunWith(RobolectricTestRunner.class)

public class ListAdapterTest {
    private ListAdapter listAdapter;
    private ArrayList<BaseModel> items;

    @Before
    public void setUp() throws Exception {
        populateListOfItems();
        listAdapter = new ListAdapter(startActivity(), items);
    }

    private void populateListOfItems() {
        items = new ArrayList<BaseModel>();
        items.add(new Location("Item0","dcss","placeholder"));
        items.add(new Location("Item1","dcss","placeholder"));
    }

    private Activity startActivity() {
        LocationListFragment listFragment = new LocationListFragment();
        startFragment(listFragment);
        return listFragment.getActivity();
    }

    private View getViewAtIndex(int index) {
        return listAdapter.getView(index, getRecycleView(), null);
    }

    private View getRecycleView() {
        View recycleView = View.inflate(startActivity(), R.layout.list_item, null);
        ListAdapter.ViewHolder viewHolder = createViewHolder(recycleView);
        recycleView.setTag(viewHolder);
        return recycleView;
    }

    @Test
    public void shouldNotBeNull() throws Exception {
        assertNotNull(listAdapter);
    }

    @Test
    public void getCount_shouldReturnProperCount() throws Exception {
        assertEquals(listAdapter.getCount(), items.size());
    }

    @Test
    public void getItem_shouldReturnProperItem() throws Exception {
        for(int index = 0; index < items.size(); index++)
            assertEquals(listAdapter.getItem(0),items.get(0));
    }

    @Test
    public void getItemId_shouldReturnProperId() throws Exception {
        for(int index = 0; index < items.size(); index++)
            assertEquals(listAdapter.getItemId(index), index);
    }

    @Test
    public void getView_shouldReturnView() throws Exception {
        for(int index = 0; index < items.size(); index++) {
            assertNotNull(getViewAtIndex(index));
        }
    }

    @Test
    public void getView_viewReturnedShouldHaveName() throws Exception{
        for(int index = 0; index < items.size(); index++){
            View view = getViewAtIndex(index);
            assertViewIsVisible(view.findViewById(R.id.base_item_title));
        }
    }

    @Test
    public void getView_viewReturnedShouldHaveImage() throws Exception{
        for(int index = 0; index < items.size(); index++){
            View view = getViewAtIndex(index);
            assertViewIsVisible(view.findViewById(R.id.base_item_image));
        }
    }

    @Test
    public void getView_viewReturnedShouldHaveSymbol() throws Exception{
        for(int index = 0; index < items.size(); index++){
            View view = getViewAtIndex(index);
            assertViewIsVisible(view.findViewById(R.id.base_item_symbol));
        }
    }

    @Test
    public void shouldRecycleViews() throws Exception{
        for(int index = 0; index < items.size(); index++){
            View recycleView = getRecycleView();
            View listItemView = listAdapter.getView(index,recycleView,null);

            assertSame(recycleView, listItemView);
        }
    }
}
