package com.misc;

/**
 * Created with IntelliJ IDEA.
 * User: abyss
 * Date: 8/12/12
 * Time: 5:29 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
     * Utility to convert integer array to string
     * @param array
     * @return
     */
    private static  String array2str(Integer [] array) {

        StringBuilder str = new StringBuilder();
        for(Integer arr: array) {
            str.append(arr);
        }
        return str.toString();
    }

    /**
     * All combinations of individuals characters in a string.
     * @param prefix
     * @param str
     * @param combinations
     */
    private static void strcombinations(String prefix, String str, List combinations) {

        combinations.add(prefix);

        for(int i = 0; i < str.length(); i++)
            strcombinations(prefix + str.charAt(i), str.substring(i+1), combinations);

    }

    /**
     * All combinations of a given length in a string.
     * @param prefix
     * @param str
     * @param combinations
     * @param len
     */
    private static void strlencombinations(String prefix, String str, List combinations, int len) {
        if(len == 0)
            combinations.add(prefix);

        for(int i = 0; i < str.length(); i++)
            strlencombinations(prefix + str.charAt(i), str.substring(i+1), combinations, len-1);

    }

    /**
     * Test Method
     */
    public static void main( String[ ] args )
    {
        //printCombinations( combinations( new String[ ] { "A", "B", "C" } ) );
        printCombinations( combinations( new Integer[ ] { 1, 2, 3 } ) );

        List<String> strCombinations = new ArrayList<String>();
        // all combinations of chars in a string
        strcombinations("", array2str(new Integer[ ] { 1, 2, 3 } ), strCombinations);

        System.out.println("all combinations of chars in a string");
        for(String str: strCombinations)  {
            System.out.println(str);
        }

        // combinations of length 2
        System.out.println("combinations of length 2");
        strCombinations = new ArrayList<String>();
        strlencombinations("", array2str(new Integer[ ] { 1, 2, 3 } ), strCombinations, 2);

        for(String str: strCombinations)  {
            System.out.println(str);
        }
    }
}
