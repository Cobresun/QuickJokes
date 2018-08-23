package com.cobresun.quickjokes.View;

import com.cobresun.quickjokes.Presenter.CardFragment;

/**
 * Interface for the display of cards.
 *
 */
public interface CardView {

    /**
     *  Presents a card to the user.
     */
    public void displayCard(CardFragment cardFragment);

    /**
     *
     */
    public void displayGuide();

    /**
     *  Reacts to the card being tapped.
     */
    public void onTapCard();

    /**
     * Reacts to a card being dismissed.
     */
    public void dismissCard();

}
