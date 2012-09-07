package com.recursion;

/**
 * Created with IntelliJ IDEA.
 * User: abyss
 * Date: 9/6/12
 * Time: 8:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class TowersOfHanoi {
    public static void moves(int n, boolean left) {
        if(n == 0)
            return;
        moves(n-1, !left);
        if(left)
            System.out.println("Move " + n + " to the left");
        else
            System.out.println("Move " + n + " to the right");
        moves(n-1, !left);
    }

    public static void main(String ... args) {
        moves(3, true);
    }
}
