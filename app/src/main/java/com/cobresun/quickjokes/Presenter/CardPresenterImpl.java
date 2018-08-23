package com.cobresun.quickjokes.Presenter;

import com.cobresun.quickjokes.Model.Impl.RedditAPIFetcher;
import com.cobresun.quickjokes.View.CardViewImpl;

public class CardPresenterImpl implements CardPresenter {

    private LimitedQueue<CardFragment> mCardQueue; // Makes sure we only have 3 cards at a time
    private RedditAPIFetcher mRedditAPIFetcher;
    private CardViewImpl mCardViewImpl;

    public CardPresenterImpl(CardViewImpl cardViewImpl) {
        mCardViewImpl = cardViewImpl;
        mCardQueue = new LimitedQueue<>(3);
        mRedditAPIFetcher = new RedditAPIFetcher();
    }

    /**
     *  Loads 3 cards from the model and makes 3 cards (adds them to a queue)
     */
    private void loadInitialCards() {
        String[][] initCardsData = mRedditAPIFetcher.getCardData(3);
        for (String[] cardData : initCardsData) {
            CardFragment cardFragment = CardFragment.newInstance(cardData[0], cardData[1], cardData[2]);
            mCardQueue.add(cardFragment);
        }
    }

    /**
     *  Loads the next card from the model and adds it to the queue
     */
    @Override
    public void loadCard() {
        if (mCardQueue.isEmpty()) {
            loadInitialCards();
        }

        // Displays next card in queue
        mCardViewImpl.displayCard(mCardQueue.poll());

        // Fetches another card
        String[][] oneCardData = mRedditAPIFetcher.getCardData(1);
        for (String[] cardData : oneCardData) {
            CardFragment cardFragment = CardFragment.newInstance(cardData[0], cardData[1], cardData[2]);
            mCardQueue.add(cardFragment);
        }
    }
}
