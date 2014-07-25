package com.example.LocalDelicacies;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rsampath on 7/25/14.
 */
public class DBHelper extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "LD_DATABASE.db";
    public static final String TYPE_NAME = " TEXT";
    public static final String COMMA_SEP = ",";

    public static final String CREATE_ENTRIES_LOCATION = "CREATE TABLE " + DBContract.DBEntry.LOCATION_TABLE_NAME + " (" +
    DBContract.DBEntry._ID + " INTEGER PRIMARY KEY," +
    DBContract.DBEntry.LOCATION_COLUMN_NAME + TYPE_NAME + COMMA_SEP +
    DBContract.DBEntry.LOCATION_COLUMN_DESCRIPTION+ TYPE_NAME + COMMA_SEP +
    DBContract.DBEntry.LOCATION_COLUMN_IMAGE_URL+ TYPE_NAME + COMMA_SEP +
    DBContract.DBEntry.LOCATION_COLUMN_PINNED+ TYPE_NAME + COMMA_SEP + " )";

    private static final String DELETE_ENTRIES_LOCATION =
            "DROP TABLE IF EXISTS " + DBContract.DBEntry.LOCATION_TABLE_NAME;

    public static final String CREATE_ENTRIES_DELICACY = "CREATE TABLE " + DBContract.DBEntry.DELICACY_TABLE_NAME + " (" +
    DBContract.DBEntry._ID + " INTEGER PRIMARY KEY," +
    DBContract.DBEntry.DELICACY_COLUMN_NAME + TYPE_NAME + COMMA_SEP +
    DBContract.DBEntry.DELICACY_COLUMN_DESCRIPTION+ TYPE_NAME + COMMA_SEP +
    DBContract.DBEntry.DELICACY_COLUMN_IMAGE_URL+ TYPE_NAME + COMMA_SEP +
    DBContract.DBEntry.DELICACY_COLUMN_PINNED+ TYPE_NAME + COMMA_SEP +
    DBContract.DBEntry.DELICACY_COLUMN_RATING + TYPE_NAME + COMMA_SEP +" )";

    private static final String DELETE_ENTRIES_DELICACY =
            "DROP TABLE IF EXISTS " + DBContract.DBEntry.LOCATION_TABLE_NAME;


    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_ENTRIES_LOCATION);
        db.execSQL(CREATE_ENTRIES_DELICACY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DELETE_ENTRIES_LOCATION);
        db.execSQL(DELETE_ENTRIES_DELICACY);
        onCreate(db);
    }
}
