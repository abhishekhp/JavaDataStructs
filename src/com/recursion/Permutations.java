package com.recursion;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: abyss
 * Date: 9/5/12
 * Time: 6:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class Permutations {

    // print N! permutation of the characters of the string s (in order)
    public  static void perm1(String s) { perm1("", s); }
    private static void perm1(String prefix, String s) {
        int N = s.length();
        if (N == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < N; i++)
                perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, N));
        }

    }

    // print N! permutation of the elements of array a (not in order)
    public static void perm2(String s) {
        int N = s.length();
        char[] a = new char[N];
        for (int i = 0; i < N; i++)
            a[i] = s.charAt(i);
        perm2(a, N);
    }

    private static void perm2(char[] a, int n) {
        if (n == 1) {
            System.out.println(a);
            return;
        }
        for (int i = 0; i < n; i++) {
            swap(a, i, n-1);
            perm2(a, n-1);
            swap(a, i, n-1);
        }
    }

    // swap the characters at indices i and j
    private static void swap(char[] a, int i, int j) {
        char c;
        c = a[i]; a[i] = a[j]; a[j] = c;
    }

    public static void perm2unique(String s) {
        int N = s.length();
        char[] a = new char[N];
        for (int i = 0; i < N; i++)
            a[i] = s.charAt(i);
        // sort the char array
        Arrays.sort(a);
        perm2unique(a, N);
    }

    private static void perm2unique(char[] a, int n) {
        if (n == 1) {
            System.out.println(a);
            return;
        }
        char lastSwap = ' ';
        for (int i = 0; i < n; i++) {
            if(lastSwap == a[i])
                continue;
            else
                lastSwap = a[i];

            swap(a, i, n-1);
            perm2unique(a, n - 1);
            swap(a, i, n-1);
        }
    }
    public static void main(String[] args) {
        //int N = Integer.parseInt(args[0]);
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //String elements = alphabet.substring(0, N);
        String elements = "aba";

        //perm1(elements);
        System.out.println();
        perm2unique(elements);
        System.out.println();
        perm2(elements);
    }
}

