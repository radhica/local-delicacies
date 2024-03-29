package com.example.LocalDelicacies;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by bnegron on 7/25/14.
 */
public class DelicacyListLoader extends AsyncTaskLoader<ArrayList<Delicacy>> {
    private final Context context;
    private ArrayList<Delicacy> delicacies;

    public DelicacyListLoader(Context context) {
        super(context);
        this.context = context;
        delicacies = new ArrayList<Delicacy>();
    }

    @Override
    public ArrayList<Delicacy> loadInBackground() {
        populateDelicacyModelsFromDb();
        return delicacies;
    }

    private void populateDelicacyModelsFromDb() {
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        String projection[] = {DBContract.DBEntry._ID,
                                DBContract.DBEntry.DELICACY_COLUMN_NAME,
                                DBContract.DBEntry.DELICACY_COLUMN_DESCRIPTION,
                                DBContract.DBEntry.DELICACY_COLUMN_IMAGE_URL,
                                DBContract.DBEntry.DELICACY_COLUMN_PINNED,
                                DBContract.DBEntry.DELICACY_COLUMN_RATING};
        String sortOrder = DBContract.DBEntry.DELICACY_COLUMN_NAME + " DESC";

        Cursor cursor = sqLiteDatabase.query(DBContract.DBEntry.DELICACY_TABLE_NAME,    //table name
                projection,                                                             //columns to select
                null,                                                                   //columns for WHERE clause
                null,                                                                   //values for WHERE clause
                null,                                                                   //group by rows
                null,                                                                   //filter by row groups
                sortOrder);                                                             //sort order

        if(cursor.moveToFirst()) {
            do {
                Delicacy newDelicacy = new Delicacy(cursor.getString(1),     //title
                        cursor.getString(2),                                                //desc
                        cursor.getString(3),                                                //imageUrl
                        getBoolean(cursor.getInt(4)),                                       //pinned
                        cursor.getInt(5));                                                  //rating
                delicacies.add(newDelicacy);
            } while (cursor.moveToNext());
        }

        sqLiteDatabase.close();
    }

    private boolean getBoolean(int i) {return i == 1;}
}
