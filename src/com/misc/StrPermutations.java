package com.misc;

/**
 * Created with IntelliJ IDEA.
 * User: abyss
 * Date: 8/12/12
 * Time: 7:42 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.LinkedList;
import java.util.ListIterator;

public class StrPermutations {

    /** Returns a linked list of all permutations of a given string */
    public static LinkedList<String> permutations( String s ) {
        LinkedList<String> permutations = new LinkedList<String>( );

        if( s.length( ) <= 1 ) {
            permutations.add( s );
        } else {

            char firstChar = s.charAt( 0 );
            String rest = s.substring( 1 ); // Don't need to specify upper-limit

            // Get all permutations of the rest of the string
            LinkedList<String> restPermutations = permutations( rest );
            for( String restPermutation : restPermutations ) {
                // Add the first character in all possible positions
                permutations.addAll( insertAtAllPositions( firstChar, restPermutation ) );
            }
        }

        return permutations;
    }

    /** Helper method for permutations( String ) */
    private static LinkedList<String> insertAtAllPositions( char firstChar, String s ) {
        LinkedList<String> permutations = new LinkedList<String>( );
        for( int i = 0; i <= s.length( ); i++ ) {
            permutations.add( s.substring( 0, i ) + firstChar + s.substring( i ) );
        }
        return permutations;
    }

    /** Test Method */
    public static void main( String[ ] args ) {

        String s = "ABC";
        LinkedList<String> permutations = StrPermutations.permutations( s );

        ListIterator<String> listItr = permutations.listIterator( );
        while( listItr.hasNext( ) ) {
            System.out.println( listItr.next( ) );
        }
    }
}
