package com.example.LocalDelicacies;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import events.BaseEvent;
import events.CityEvent;
import events.FoodEvent;

/**
 * Created by bnegron on 7/21/14.
 */
public class MainActivity extends Activity {
    private static final String CITY_LIST = "City List";
    private static final String FOOD_LIST = "Food List";
    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawerLayout;
    private String[] titles;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        registerWithBus();
        setContentView(R.layout.activity_main);

        titles = getResources().getStringArray(R.array.titles);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        drawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                R.drawable.ic_navigation_drawer,
                R.string.drawer_open,
                R.string.drawer_close) {

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                //invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View view) {
                super.onDrawerOpened(view);
                getActionBar().setTitle(R.string.app_name);
                //invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        drawerLayout.setDrawerListener(drawerToggle);

        getActionBar().setDisplayShowHomeEnabled(false);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
    }

    private void select(final int position) {
        Fragment fragment;
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

        switch (position) {
            case 0:
                fragment = getFragmentManager().findFragmentByTag(CITY_LIST);
                if(fragment == null) {
                    fragment = new CityListFragment();
                    fragmentTransaction.replace(R.id.content_frame, fragment, CITY_LIST);
                }
                break;
            case 1:
                fragment = getFragmentManager().findFragmentByTag(FOOD_LIST);
                if(fragment == null) {
                    fragment = new FoodListFragment();
                    fragmentTransaction.replace(R.id.content_frame, fragment, FOOD_LIST);
                }
                break;
            default:
                fragment = new ListFragment();
                break;
        }

        fragmentTransaction.commit();
        drawerLayout.closeDrawer(Gravity.START);

        setTitle(titles[position]);
    }

    @Subscribe
    public void onCityEvent(CityEvent cityEvent){
        select(0);
    }

    @Subscribe
    public void onFoodEvent(FoodEvent foodEvent){
        select(1);
    }

    public void setTitle(CharSequence title) {
        getActionBar().setTitle(title);
    }

    protected static Bus getBus() {
        return AppBus.getInstance().getBus();
    }

    public static void postToBus(BaseEvent event){
        AppBus.getInstance().postToBus(event);
    }

    private void registerWithBus() {
        getBus().register(this);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        unregisterWithBus();
    }

    private void unregisterWithBus() {
        getBus().unregister(this);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        //boolean drawerOpen = drawerLayout.isDrawerOpen((ListView) findViewById(R.id.left_drawer));
        //menu.findItem(R.id.action_websearch).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }
}