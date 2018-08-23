package com.cobresun.quickjokes.View;

/**
 * Interface for the display of cards.
 *
 */
public interface CardView {

    /**
     *  Presents a card to the user.
     */
    public void displayCard();

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
