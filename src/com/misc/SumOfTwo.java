package com.misc;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: abyss
 * Date: 9/10/12
 * Time: 4:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class SumOfTwo {
    static int a[] = {0, 1,3, 2, 4, 8, 10, 4};
    public static void main(String ... args) {
        findsum2(10);
    }

    private static void findsum(int sum) {

        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a.length; j++) {
                if(a[i] + a[j] == sum) {
                    System.out.print(i + ", " + j + " - " + a[i]+ ", " + a[j]);
                }

            }
        }
    }

    private  static void findsum2(int sum) {
        // assumes array is sorted.
        Arrays.sort(a);
        int i = 0;
        int j = a.length - 1;
        while( i < j) {
           if(sum - a[i] > a[j])
               i++;
           else if(sum - a[i] < a[j])
               j--;
           else {
               System.out.println(i + ", " + j + " - " + a[i]+ ", " + a[j]);
               i++;
               j--;
           }
        }

    }
}
