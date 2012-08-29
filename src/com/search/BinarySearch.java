package com.search;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: abyss
 * Date: 8/10/12
 * Time: 12:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class BinarySearch {
    public int search(int[] search, int find) {
        int start, end, midPt;
        start = 0;
        end = search.length - 1;
        while (start <= end) {
            midPt = (start + end) / 2;
            if (search[midPt] == find) {
                return midPt;
            } else if (search[midPt] < find) {
                start = midPt + 1;
            } else {
                end = midPt - 1;
            }
        }
        return -1;
    }


    public static void main(String ... args) {
        BinarySearch bs = new BinarySearch();
        int a[] = {3,7,8,5,2,1,9,5,4};
        Arrays.sort(a);
        System.out.println(bs.search(a, 8));
        System.out.println(bs.search(a, 6));

    }
}
