package com.cobresun.quickjokes.View;

import android.app.Activity;
import android.widget.TextView;

import com.cobresun.quickjokes.Presenter.CardFragment;
import com.cobresun.quickjokes.Presenter.CardPresenterImpl;
import com.cobresun.quickjokes.R;

public class CardViewImpl implements CardView {

    private Activity mActivity;
    private final CardPresenterImpl cardPresenter;

    public CardViewImpl(Activity activity){
        mActivity = activity;
        cardPresenter = new CardPresenterImpl(this);


        cardPresenter.loadCard();
    }

    /**
     *  Takes a card and then displays the
     */
    @Override
    public void displayCard(CardFragment cardFragment){
        TextView textView = mActivity.findViewById(R.id.textView);

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
