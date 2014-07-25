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
                int response = connection.getResponseCode();
                Log.d("Response code:\t", ""+response);

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
        Log.d("Download complete; result:\t", result);
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
        ArrayList<LocationModel> locationModels = locationList.getLocationModels();
        ArrayList<DelicacyModel> delicacyModels = new ArrayList<DelicacyModel>();

        for(LocationModel i:locationModels){
            delicacyModels.addAll(i.getDelicacies());

            values.put(DBContract.DBEntry.LOCATION_COLUMN_NAME, i.getTitle());
            values.put(DBContract.DBEntry.LOCATION_COLUMN_DESCRIPTION, i.getDescription());
            values.put(DBContract.DBEntry.LOCATION_COLUMN_IMAGE_URL, i.getImageUrl());
            values.put(DBContract.DBEntry.LOCATION_COLUMN_PINNED, i.isPinned());

            sqLite.insert(DBContract.DBEntry.LOCATION_TABLE_NAME, null, values);
        }

        for(DelicacyModel i:delicacyModels){
            values.put(DBContract.DBEntry.DELICACY_COLUMN_NAME, i.getTitle());
            values.put(DBContract.DBEntry.DELICACY_COLUMN_DESCRIPTION, i.getDescription());
            values.put(DBContract.DBEntry.DELICACY_COLUMN_IMAGE_URL, i.getImageUrl());
            values.put(DBContract.DBEntry.DELICACY_COLUMN_PINNED, i.isPinned());
            values.put(DBContract.DBEntry.DELICACY_COLUMN_RATING, i.getRating());

            sqLite.insert(DBContract.DBEntry.DELICACY_TABLE_NAME, null, values);
        }
    }
}
