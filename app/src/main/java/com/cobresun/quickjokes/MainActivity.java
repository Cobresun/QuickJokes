package com.cobresun.quickjokes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cobresun.quickjokes.Model.Impl.RedditAPIFetcher;
import com.cobresun.quickjokes.Presenter.CardPresenterImpl;
import com.cobresun.quickjokes.View.CardViewImpl;

public class MainActivity extends AppCompatActivity {

    private CardPresenterImpl cardPresenter;
    private CardViewImpl cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViewer();
    }

    private void initViewer(){
        // Creates an instance of cardView with the current context of the MainActivity
        CardViewImpl cardViewImpl = new CardViewImpl(this);
    }
}
