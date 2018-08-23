package com.cobresun.quickjokes.View;

import android.widget.TextView;

import com.cobresun.quickjokes.Presenter.CardFragment;

public class CardViewImpl implements CardView {


    private TextView textView;


    public CardViewImpl(TextView textView){
        this.textView = textView;

    }

    /**
     *  Takes a card and then displays the
     */
    @Override
    public void displayCard(CardFragment cardFragment){

        textView.setText(cardFragment.toString());
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
