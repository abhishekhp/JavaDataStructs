package com.misc;

/**
 * Created with IntelliJ IDEA.
 * User: abyss
 * Date: 9/7/12
 * Time: 8:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReverseStr {

    // iterative
    public static String reverse(String str)   {
        String reverse = "";
        for(int i = str.length()-1; i>=0; i--) {
            reverse += str.charAt(i);
        }
        return reverse;
    }

    // recursive
    public static String reverseStr(String str) {
        int n = str.length();
        if (n == 0)
            return "";
        return str.charAt(n-1) + reverseStr(str.substring(0, n-1));
    }

    public static void main(String ... args) {
        System.out.println(reverse("hello"));
        System.out.println(reverseStr("hello"));
    }
}
