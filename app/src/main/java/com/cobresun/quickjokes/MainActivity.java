package com.cobresun.quickjokes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.cobresun.quickjokes.Presenter.CardPresenterImpl;
import com.cobresun.quickjokes.View.CardViewImpl;

public class MainActivity extends AppCompatActivity {

    private CardPresenterImpl cardPresenter;
    private CardViewImpl cardView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVieweer();
    }

    private void initVieweer(){
        cardPresenter = new CardPresenterImpl();

        TextView tv = findViewById(R.id.textView);
        cardView = new CardViewImpl(tv);

    }
}
