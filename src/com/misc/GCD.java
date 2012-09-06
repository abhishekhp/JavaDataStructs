package com.misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: abyss
 * Date: 9/5/12
 * Time: 6:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class GCD {

    // recursive implementation
    public static int gcd(int p, int q) {
        if (q == 0) return p;
        else return gcd(q, p % q);
    }

    // non-recursive implementation
    public static int gcd2(int p, int q) {
        while (q != 0) {
            int temp = q;
            q = p % q;
            p = temp;
        }
        return p;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new
                InputStreamReader(System.in));
        String str;
        int p = 0, q = 0;
        try {
            System.out.println("Enter two integers for which you want to compute gcd.");
            int i = 0;
            do {
                System.out.print("Number " + i+1 + ":");
                str = br.readLine();
                if( i == 0)
                   p = Integer.parseInt(str);
                else
                   q = Integer.parseInt(str);
                System.out.println("You entered: " + str);
                i++;
            } while(i < 2);
        } catch(IOException exc) {
            System.out.println(exc);
        }

        int d  = gcd(p, q);
        int d2 = gcd2(p, q);
        System.out.println("gcd(" + p + ", " + q + ") = " + d);
        System.out.println("gcd(" + p + ", " + q + ") = " + d2);
    }
}
