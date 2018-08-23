package com.cobresun.quickjokes.Model.Impl;

import com.cobresun.quickjokes.Model.APIFetcher;

public class RedditAPIFetcher implements APIFetcher{

    private static String BASE_URL = "https://www.reddit.com/";
    private static String SUBREDDIT = "r/jokes";

    private static String getJSON(String targetUrl){
        return null;
    }

    @Override
    public String[][] getCardData(int numCards) {
        return new String[0][];
    }
}
