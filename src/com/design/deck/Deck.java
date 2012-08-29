package com.design.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: abyss
 * Date: 8/11/12
 * Time: 9:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class Deck implements Iterator<ICard> {

    protected  ArrayList<ICard> cards;

    protected  int index = 0;

    public Deck() {

        cards = new ArrayList<ICard>();

        for(int rank = 1; rank <= 13; rank++)
            for(int suit = ICard.SPADES; suit <= ICard.DIAMONDS; suit++)
                cards.add(new Card(rank, suit));

        shuffle();
    }

    public boolean hasNext() {
        return index < cards.size();
    }

    public ICard next() {
        return cards.get(index++);
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

}
