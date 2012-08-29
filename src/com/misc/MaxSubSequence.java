package com.misc;

/**
 * Created with IntelliJ IDEA.
 * User: abyss
 * Date: 8/12/12
 * Time: 4:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class MaxSubSequence {
    static private int start = 0;
    static private int end = -1;

    private static int maxSubSeq(int a[])  {
        int i = 0;
        int sum = 0;
        int max = 0;
        for(int j=0; j < a.length; j++) {
            sum += a[j];
            if( sum > max) {
                max = sum;
                start = i;
                end = j;
            } else if (sum < 0) {
                i = j + 1;
                sum = 0;
            }
        }
        return max;
    }

    public static void main(String ...args) {
        int a[] = {1,-2,3,4,-3};
        System.out.println(maxSubSeq(a));
        System.out.print("start: " + start + " , end:" + end);

    }
}
