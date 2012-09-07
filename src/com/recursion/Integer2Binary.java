package com.recursion;

/**
 * Created with IntelliJ IDEA.
 * User: abyss
 * Date: 9/6/12
 * Time: 9:07 AM
 * To change this template use File | Settings | File Templates.
 */
public class Integer2Binary {
    public static void convert(int n) {
        if(n == 0) return;
        convert(n/2);
        System.out.print(n % 2);
    }

    public static void main(String ... args) {
        convert(4);
    }

}
