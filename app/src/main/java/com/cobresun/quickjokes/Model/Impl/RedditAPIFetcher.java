package com.cobresun.quickjokes.Model.Impl;

import android.os.AsyncTask;

import com.cobresun.quickjokes.Model.APIFetcher;

import org.json.JSONArray;
import org.json.JSONObject;

public class RedditAPIFetcher implements APIFetcher {

    private static String BASE_URL = "https://www.reddit.com/";
    private static String SUBREDDIT = "r/jokes/";
    private static String POST_SOURCE = "top/";

    private static String[] valuesToFetch = {"title", "selftext", "author"};

    private String lastFetched = "";

    private JSONResponceFetcher fetcher;

    public RedditAPIFetcher(){
        fetcher = new JSONResponceFetcher();
    }

    private static String getJSON(String targetUrl){
        // i'm very confused about what to do with this
        return null;
    }

    @Override
    public String[][] getCardData(int numCards) {

        String suffix = ".json";                            // Create suffix to add on options

        suffix += "?limit=" + String.valueOf(numCards);     // Request amount of posts

        String targetUrl = BASE_URL + SUBREDDIT + POST_SOURCE + suffix;

        System.out.println("SUNY: getting card data from: "+targetUrl);
        fetcher = new JSONResponceFetcher();
        try {
            if (numCards > 1) {
                fetcher.execute(targetUrl).get();
            } else {
                fetcher.execute(targetUrl).get();
            }
        }catch (Exception e){
            fetcher.getStatus();
            e.printStackTrace();
            //fetcher.execute();
        }

        try {
            JSONObject data = new JSONObject(fetcher.getJSONResponce());
            data = data.getJSONObject("data");
            JSONArray posts = data.getJSONArray("children");

            lastFetched = data.getString("after");

            String[][] parsedCardData = new String[numCards][valuesToFetch.length];
            System.out.println("SUNY: Num of jokes "+posts.length());

            for(int i=0; i<posts.length(); i++){
                System.out.println("SUNY: Getting joke: "+i);
                JSONObject jsonPost = posts.getJSONObject(i).getJSONObject("data");

                for(int x=0; x<valuesToFetch.length; x++) {
                    parsedCardData[i][x] = jsonPost.optString(valuesToFetch[x]);
                    System.out.println("SUNY: card["+i+"] "+valuesToFetch[x]+": "+parsedCardData[i][x]);
                }
            }

            return parsedCardData;


        } catch (Exception e){
            System.out.println("Error");
            e.printStackTrace();
            return new String[0][];
        }
    }
}
