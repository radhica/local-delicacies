package com.example.LocalDelicacies;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.util.Log;
import com.google.gson.Gson;
import events.DownloadEvent;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by bnegron on 7/24/14.
 */
public class DownloadFileTask extends AsyncTask<String, Void, String> {
    ProgressDialog progressDialog;
    Context context;

    public DownloadFileTask(Context context){
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
    }

    @Override
    protected String doInBackground(String... urls) {
        return downloadUrl(urls);
    }

    private String downloadUrl(String[] urls) {
        InputStream in = null;

        for(String i:urls){
            try{
                URL url = new URL(i);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setReadTimeout(10000);
                connection.setConnectTimeout(15000);
                connection.setRequestMethod("GET");
                connection.setDoInput(true);

                connection.connect();
                in = connection.getInputStream();
            } catch (Exception e){Log.d("Exception downloading:\t", e.toString());}
        }
        return readInput(in);
    }

    private String readInput(InputStream in) {
        BufferedReader streamReader = new BufferedReader(new InputStreamReader(in));
        StringBuilder responseStrBuilder = new StringBuilder();
        String input = "";

        try {
            while ((input = streamReader.readLine()) != null)
                responseStrBuilder.append(input);
        } catch (Exception e) { Log.d("Exception reading input:\t", "" + e);}

        input = responseStrBuilder.toString();
        return input;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
        progressDialog.setMessage("" + progressDialog.getProgress() + "% complete.");
    }

    @Override
    protected void onPostExecute(String result) {
        Gson gson = new Gson();
        LocationList locationList = gson.fromJson(result, LocationList.class);

        populateTables(locationList);

        AppBus.getInstance().postToBus(new DownloadEvent());
        progressDialog.dismiss();
        super.onPostExecute(result);
    }

    private void populateTables(LocationList locationList) {
        SQLiteDatabase sqLite = new DBHelper(context).getWritableDatabase();
        ContentValues values = new ContentValues();
        List<Location> locations = locationList.getLocations();
        ArrayList<Delicacy> delicacies = new ArrayList<Delicacy>();

        for(int i = 0; i < locations.size(); i++){
            delicacies.addAll(locations.get(i).getDelicacies());

            values.put(DBContract.DBEntry._ID, i);
            values.put(DBContract.DBEntry.LOCATION_COLUMN_NAME, locations.get(i).getTitle());
            values.put(DBContract.DBEntry.LOCATION_COLUMN_DESCRIPTION, locations.get(i).getDescription());
            values.put(DBContract.DBEntry.LOCATION_COLUMN_IMAGE_URL, locations.get(i).getImageUrl());
            values.put(DBContract.DBEntry.LOCATION_COLUMN_PINNED, locations.get(i).isPinned());

            sqLite.insertWithOnConflict(DBContract.DBEntry.LOCATION_TABLE_NAME, null, values, SQLiteDatabase.CONFLICT_REPLACE);
        }

        for(int i = 0; i < delicacies.size(); i++){
            values.put(DBContract.DBEntry._ID, i);
            values.put(DBContract.DBEntry.DELICACY_COLUMN_NAME, delicacies.get(i).getTitle());
            values.put(DBContract.DBEntry.DELICACY_COLUMN_DESCRIPTION, delicacies.get(i).getDescription());
            values.put(DBContract.DBEntry.DELICACY_COLUMN_IMAGE_URL, delicacies.get(i).getImageUrl());
            values.put(DBContract.DBEntry.DELICACY_COLUMN_PINNED, delicacies.get(i).isPinned());
            values.put(DBContract.DBEntry.DELICACY_COLUMN_RATING, delicacies.get(i).getRating());

            sqLite.insertWithOnConflict(DBContract.DBEntry.DELICACY_TABLE_NAME, null, values, SQLiteDatabase.CONFLICT_REPLACE);
        }

        sqLite.close();
    }
}
