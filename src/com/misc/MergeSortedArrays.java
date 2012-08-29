package com.misc;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: abyss
 * Date: 8/11/12
 * Time: 1:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class MergeSortedArrays {
    static int first [] = {1, 3, 5, 7, 9};
    static int second [] = {2, 4, 6, 8, 10};


    public  static  void main(String ... args) {
        int c[] = new int[first.length + second.length];
        int i = 0, j = 0, k = 0;
        while (i < first.length && j < second.length) {
            if(first[i] < second[j]) {
                c[k++] = first[i++];
            } else {
                c[k++] = second[j++];
            }
        }

        while( i < first.length) {
            c[k++] = first[i++];
        }

        while(j < second.length) {
            c[k++] = second[j++];
        }

        for(int n: c) {
            System.out.print(n + " ");
        }

    }

}
