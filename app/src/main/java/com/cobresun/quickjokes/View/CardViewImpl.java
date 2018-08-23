package com.cobresun.quickjokes.View;

import android.widget.TextView;

public class CardViewImpl implements CardView {


    private TextView textView;


    public CardViewImpl(TextView textView){
        this.textView = textView;

    }

    /**
     *  Takes a card and then displays the
     */
    @Override
    public void displayCard(){
        textView.setText("Brian likes cheese just like me!!!!");
    }

    /**
     *
     */
    @Override
    public void displayGuide(){

    }

    /**
     *  Reacts to the card being tapped.
     */
    @Override
    public void onTapCard(){

    }

    /**
     * Reacts to a card being dismissed.
     */
    @Override
    public void dismissCard(){

    }
}
