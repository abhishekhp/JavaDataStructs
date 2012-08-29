package com.misc;

/**
 * Created with IntelliJ IDEA.
 * User: abyss
 * Date: 8/12/12
 * Time: 10:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class FibonacciIter1
{
    /* Calculate nth fibonacci number via bottom-up dynamic programming */
    public static int calculate( int n )
    {
        if( n == 0 )
        {
            return n;
        }
        else
        {
            int previous = 1;
            int previousPrevious = 0;
            int current = 1;

            while( --n > 0 )
            {
                current = previous + previousPrevious;
                previousPrevious = previous;
                previous = current;
            }

            return current;
        }
    }

    /** Test Method */
    public static void main( String[ ] args )
    {
        for( int i = 0; i <= 30; i++ )
        {
            System.out.printf( "%3d\t%,7d\n", i, FibonacciIter1.calculate( i ) );
        }
    }
}
