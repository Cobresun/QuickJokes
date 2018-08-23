package com.cobresun.quickjokes.Model.Impl;

import com.cobresun.quickjokes.Model.APIFetcher;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.prefs.BackingStoreException;

import javax.net.ssl.HttpsURLConnection;

public class RedditAPIFetcher implements APIFetcher{

    private static String BASE_URL = "https://www.reddit.com/";
    private static String SUBREDDIT = "r/jokes/";
    private static String POST_SOURCE = "top/";

    private static String[] valuesToFetch = {"title", "selftext"};

    private String lastFetched = "";


    private static String getJSON(String targetUrl){
        HttpsURLConnection con = null;
        try {
            URL url = new URL(targetUrl);
            con = (HttpsURLConnection) url.openConnection();

            con.connect();


            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();
            return sb.toString();

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

    @Override
    public String[][] getCardData(int numCards) {

        String suffix = ".json";                            // Create suffix to add on options

        suffix += "?count=" + String.valueOf(numCards);     // Request amount of posts

        String targetUrl = BASE_URL + SUBREDDIT + POST_SOURCE + suffix;

        try {
            JSONObject data = new JSONObject(getJSON(targetUrl));
            JSONArray posts = data.getJSONArray("children");

            lastFetched = data.getString("after");

            String[][] parsedCardData = new String[numCards][valuesToFetch.length];

            for(int i=0; i<posts.length(); i++){
                JSONObject jsonPost = posts.getJSONObject(i).getJSONObject("data");

                for(int x=0; x<valuesToFetch.length; x++)
                    parsedCardData[i][x] = jsonPost.optString(valuesToFetch[x]);
            }

            return parsedCardData;


        } catch (Exception e){
            System.out.println("Error");
            return new String[0][];
        }
    }
}
