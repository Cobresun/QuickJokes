package com.cobresun.quickjokes.Model.Impl;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JSONResponceFetcher extends AsyncTask<String, Void, Void> {

    private String JSONResponce;

    public String getJSONResponce() {
        return JSONResponce;
    }

    @Override
    protected Void doInBackground(String... params) {
        String targetUrl = params[0];
        HttpURLConnection con = null;
        try {
            URL url = new URL(targetUrl);
            con = (HttpURLConnection) url.openConnection();

            //con.connect();


            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();
            JSONResponce = sb.toString();

        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.disconnect();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        return null;
    }
}
