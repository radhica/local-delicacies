package com.example.LocalDelicacies;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.google.gson.Gson;
import events.DownloadEvent;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


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

        AppBus.getInstance().postToBus(new DownloadEvent(locationList));
        progressDialog.dismiss();
        super.onPostExecute(result);
    }
}
