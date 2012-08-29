package com.misc;

/**
 * Created with IntelliJ IDEA.
 * User: abyss
 * Date: 8/12/12
 * Time: 5:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReverseNum {
    private static int reverse( int number )
    {
        int reversed = 0;
        while( number > 0 )
        {
            // Get the right-most digit
            int digit = number % 10;
            // Shift the number so we can get the right-most digit next time
            number = number / 10;

            // Make room for an additional digit
            reversed = reversed * 10;
            // Add the additional digit
            reversed = reversed + digit;
        }

        return reversed;
    }

    public static  void main(String ...args) {
        System.out.print(reverse(2132));
    }

}
