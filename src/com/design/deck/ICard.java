package com.design.deck;

/**
 * Created with IntelliJ IDEA.
 * User: abyss
 * Date: 8/11/12
 * Time: 9:21 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ICard extends  Comparable {
    public static int SPADES = 0;
    public static int HEARTS = 1;
    public static int CLUBS = 2;
    public static int DIAMONDS = 3;

    public int getRank();

    public int getSuit();
}
