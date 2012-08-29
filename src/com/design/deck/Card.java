package com.design.deck;

/**
 * Created with IntelliJ IDEA.
 * User: abyss
 * Date: 8/11/12
 * Time: 9:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class Card implements  ICard {
    private final int rank;

    private final int suit;

    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    private String suitDesc[] = {"SPADES", "HEARTS", "CLUBS", "DIAMONDS"};

    private String rankDesc[] = {"JOKER", "ACE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN"
                                   , "JACK", "QUEEN", "KING"};

    public int getRank() {
        return rank;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int getSuit() {
        return suit;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int compareTo(Object o) {
        ICard other = (ICard)o;
        int rankDiff = this.getRank() - other.getRank();
        if(rankDiff == 0) {
            return this.getSuit() - other.getSuit();
        }
       return rankDiff;
    }

    public String toString() {
        return rankDesc[rank] + " of " + suitDesc[suit];
    }
}
