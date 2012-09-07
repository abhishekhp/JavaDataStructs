package com.recursion;

import java.util.BitSet;

/**
 * Created with IntelliJ IDEA.
 * User: abyss
 * Date: 9/6/12
 * Time: 8:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class GrayCode {
    private static BitSet bitSet = new BitSet(3);

    public static void moves(int n, boolean forward) {
        if(n == 0)
            return;
        moves(n-1, true);
        if(forward)    {
            System.out.print("Enter " + n);
            bitSet.flip(n-1);
            System.out.print(bitSet.toString());
            System.out.println();

        } else {
            System.out.print("Exit " + n);
            bitSet.flip(n-1);
            System.out.print(bitSet.toString());
            System.out.println();
        }
        moves(n-1, false);
    }

    public static void main(String ... args) {
        moves(3, true);
    }
}
