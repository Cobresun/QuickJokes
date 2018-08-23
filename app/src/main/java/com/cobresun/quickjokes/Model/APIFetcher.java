package com.cobresun.quickjokes.Model;

import android.os.AsyncTask;

public interface APIFetcher {

    String[][] getCardData(int numCards);

}
