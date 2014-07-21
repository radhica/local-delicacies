package com.example.LocalDelicacies;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by bnegron on 7/21/14.
 */
public class MainActivity extends Activity{
    private String[] titles;
    private DrawerLayout drawerLayout;
    private ListView drawerList;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //define new vars
        titles = getResources().getStringArray(R.array.titles);
        drawerLayout = (DrawerLayout) findViewById(R.layout.main);
        drawerList = (ListView) findViewById(R.id.left_drawer);

        //set adapter for list view
        drawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, titles));

        //set onclick listener
        drawerList.setOnItemClickListener(new DrawerItemClickListener());
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener{

        public void onItemClick(AdapterView parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int position) {

    }
}
