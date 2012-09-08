package com.dynamicprog;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: abyss
 * Date: 9/8/12
 * Time: 11:19 AM
 * To change this template use File | Settings | File Templates.
 */
public class Fibonacci {

    public static void main(String[] args) {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        try {
        String str = "";
        int N = 0;
        while ( !(str = br.readLine()).equals("q")) {
            N = Integer.parseInt(str);
        }

        System.out.println("N: " + N);
        int[] fibonacci = new int[N+1];

        for (int n = 0; n <= N; n++)
            fibonacci[n] = -1;

        fibonacci[0] = 0;
        fibonacci[1] = 1;

        // fibonacci using memoization - top recursion
        fibmemo(N, fibonacci);

        // fibonacci using iteration - bottom up compute
        //fibiter(N, fibonacci);


        for (int n = 0; n <= N; n++)
            System.out.println(fibonacci[n]);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void fibiter(int n, int[] fibcache) {
        // bottom-up dynamic programming
        for (int i = 2; i <= n; i++)
            fibcache[i] = fibcache[i-1] + fibcache[i-2];
    }

    public static int fibmemo(int n, int[] fibcache) {

        int result = fibcache[n];


        if(result == -1) {

            if(n == 0) {
                return 0;
            }
            if(n == 1)
                return 1;
            result =  fibmemo(n-1, fibcache) + fibmemo(n-2, fibcache);

            fibcache[n] = result;
            return result;
        }
        return result;
    }
}
