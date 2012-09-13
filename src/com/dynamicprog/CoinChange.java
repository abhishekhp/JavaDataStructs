package com.dynamicprog;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: abyss
 * Date: 9/12/12
 * Time: 6:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class CoinChange {
    private final static int d[] = {4, 5};
    // 1, 5, 10, 25 - tender any both return same
    // 1, 3, 4, 5 - tender 7
    // 3, 4, 5 - tender 11
    // 4, 5 tender 11

    public static void main(String ... args) {
        makeChangeGreedy(11);
        System.out.println("--------");
        makeChangeDynamicProg(11);
    }

    private static void makeChangeGreedy(int amount) {
       int count[] = new int[d.length];
       for(int i = d.length-1; i>=0; i--) {
           while(amount >= d[i]) {
               amount = amount - d[i];
               count[i]++;
           }
           if(amount == 0)
               break;
       }
       if(amount > 0)
           System.out.println("Amount remaining: " + amount);
       for(int i = count.length-1; i >=0; i--) {
             System.out.println("# of denomination: " + d[i] + " = " + count[i]);
       }


    }

    private static void makeChangeDynamicProg(int amount) {
        int count[] = new int[amount+1];
        int num[] = new int[amount+1];
        for(int p = 1; p <= amount; p++) {
            int min = Integer.MAX_VALUE;
            int coin = 1;
            for(int i = 0; i < d.length; i++) {
                if(d[i] <= p)  {
                   if(count[p-d[i]] < min) {
                       min = 1 + count[p-d[i]];
                       coin = i;
                   }
                }
            count[p] = min;
            num[p] = coin;
            }
        }
        System.out.println("# coins: " + count[amount]);
        while (amount > 0) {
            System.out.print(d[num[amount]]);
            amount = amount - d[num[amount]];
        }

    }
}
