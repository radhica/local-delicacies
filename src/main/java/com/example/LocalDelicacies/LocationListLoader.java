package com.example.LocalDelicacies;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by bnegron on 7/25/14.
 */
public class LocationListLoader extends AsyncTaskLoader<ArrayList<Location>> {
    private final Context context;
    private ArrayList<Location> locations;

    public LocationListLoader(Context context) {
        super(context);
        this.context = context;
        locations = new ArrayList<Location>();
    }

    @Override
    public ArrayList<Location> loadInBackground() {
        populateLocationModelsFromDb();
        return locations;
    }

    private void populateLocationModelsFromDb() {
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        String projection[] = {DBContract.DBEntry._ID,
                                DBContract.DBEntry.LOCATION_COLUMN_NAME,
                                DBContract.DBEntry.LOCATION_COLUMN_DESCRIPTION,
                                DBContract.DBEntry.LOCATION_COLUMN_IMAGE_URL,
                                DBContract.DBEntry.LOCATION_COLUMN_PINNED};
        String sortOrder = DBContract.DBEntry.LOCATION_COLUMN_NAME + " DESC";

        Cursor cursor = sqLiteDatabase.query(DBContract.DBEntry.LOCATION_TABLE_NAME,    //table name
                projection,                                                             //columns to select
                null,                                                                   //columns for WHERE clause
                null,                                                                   //values for WHERE clause
                null,                                                                   //group by rows
                null,                                                                   //filter by row groups
                sortOrder);                                                             //sort order

        if(cursor.moveToFirst()) {
            do {
                Location newLocation = new Location(cursor.getString(1),     //title
                        cursor.getString(2),                                                //desc
                        cursor.getString(3),                                                //imageurl
                        getBoolean(cursor.getInt(4)));                                      //pinned
                locations.add(newLocation);
            } while (cursor.moveToNext());
        }
    }

    private boolean getBoolean(int i) {return i == 1;}
}
