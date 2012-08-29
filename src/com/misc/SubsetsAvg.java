package com.misc;

/**
 * Created with IntelliJ IDEA.
 * User: abyss
 * Date: 8/12/12
 * Time: 5:02 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.*;

public class SubsetsAvg
{
    public double average( int[ ] numList )
    {
        double totalAverage = 0;
        int totalCount = 0;

        long combinations = 2 << numList.length - 1;

        for( int i = 0; i < combinations; i++ )
        {
            double average = 0;
            int count = 0;

            for( int j = 0; j < numList.length; j++ )
            {
                if( ( i & ( 1 << j ) ) != 0 )
                {
                    average += numList[ j ];
                    count++;
                }
            }

            if( count > 0 )
            {
                totalAverage += ( average / count );
                totalCount++;
            }
        }

        return totalAverage / totalCount;
    }

    /** Test Method */
    public static void main( String[ ] args )
    {
        SubsetsAvg averageCalculator = new SubsetsAvg( );

        int[ ][ ] inputs = { { 1, 2, 3 }, { 42 }, { -1, 0, 1 } };

        for( int[ ] input : inputs )
        {
            System.out.println( Arrays.toString( input ) +
                    " => " + averageCalculator.average( input ) );
        }
    }
}
