package com.recursion;

/**
 * Created with IntelliJ IDEA.
 * User: abyss
 * Date: 9/5/12
 * Time: 9:23 PM
 * To change this template use File | Settings | File Templates.
 */

public class PermutationsK {

    public static void choose(char[] a, int R) { enumerate(a, a.length, R); }

    private static void enumerate(char[] a, int n, int r) {
        if (r == 0) {
            for (int i = n; i < a.length; i++)
                System.out.print(a[i]);
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            swap(a, i, n-1);
            enumerate(a, n-1, r-1);
            swap(a, i, n-1);
        }
    }

    // helper function that swaps a[i] and a[j]
    public static void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    // sample client
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        String elements = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        char[] a = new char[N];
        for (int i = 0; i < N; i++)
            a[i] = elements.charAt(i);
        choose(a, k);
    }

}
