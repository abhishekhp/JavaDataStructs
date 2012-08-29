package com.misc;

/**
 * Created with IntelliJ IDEA.
 * User: abyss
 * Date: 8/12/12
 * Time: 5:29 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.LinkedList;
import java.util.ListIterator;

public class CombinationsGenerator
{
    /**
     * Generates all combinations and returns them in a list of lists.
     */
    public static <T> LinkedList<LinkedList<T>> combinations( T[ ] array )
    {
        long count = 2 << array.length - 1;
        LinkedList<LinkedList<T>> totalCombinations = new LinkedList<LinkedList<T>>( );

        for( int i = 0; i < count; i++ )
        {
            LinkedList<T> combinations = new LinkedList<T>( );

            for( int j = 0; j < array.length; j++ )
            {
                System.out.println("i: " + i + ",j:" + j + "=" + (i & ( 1 << j )));
                if( ( i & ( 1 << j ) ) != 0 )
                {
                    combinations.add( array[ j ] );
                }
            }

            totalCombinations.add( combinations );
        }

        return totalCombinations;
    }

    /**
     * Prints all combinations.
     */
    public static <T> void printCombinations( LinkedList<LinkedList<T>> totalCombinations )
    {
        ListIterator<LinkedList<T>> totalCombinationsItr = totalCombinations.listIterator( );

        while( totalCombinationsItr.hasNext( ) )
        {
            LinkedList<T> combinations = totalCombinationsItr.next( );
            ListIterator<T> combinationsItr = combinations.listIterator( );

            while( combinationsItr.hasNext( ) )
            {
                System.out.print( combinationsItr.next( ) + ( combinationsItr.hasNext( ) ? ", " : "\n" ));
            }
        }
    }

    /**
     * Test Method
     */
    public static void main( String[ ] args )
    {
        //printCombinations( combinations( new String[ ] { "A", "B", "C" } ) );
        printCombinations( combinations( new Integer[ ] { 1, 2, 3 } ) );
    }
}
