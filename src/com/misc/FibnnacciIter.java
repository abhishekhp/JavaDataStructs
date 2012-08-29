package com.misc;

/**
 * Created with IntelliJ IDEA.
 * User: abyss
 * Date: 8/12/12
 * Time: 10:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class FibnnacciIter {

    private static int fibonacci(int n) {
        if(n == 0)
            return  0;
        if(n == 1)
            return 1;
        int [] store = new int[n];
        store[0] = 0;
        store[1] = 1;
        for(int i = 2; i < n; i++) {
            store[i] = store[i-1] + store[i-2];
        }
        return store[n-1];
    }

    public static  void main(String ... args) {
        for(int n = 1; n < 10; n++)
            System.out.println(fibonacci(n));
    }
}
