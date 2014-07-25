package com.example.LocalDelicacies;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import events.DownloadEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        char[] input = new char[1000000];
        try {
            reader.read(input);
        } catch (IOException e) { Log.d("Exception reading input:\t", "" + e);}

        return String.valueOf(input);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
        progressDialog.setMessage("" + progressDialog.getProgress() + "% complete.");
    }

    @Override
    protected void onPostExecute(String result) {
        AppBus.getInstance().postToBus(new DownloadEvent(result));
        progressDialog.dismiss();
        super.onPostExecute(result);
    }
}
