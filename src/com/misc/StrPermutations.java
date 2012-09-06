package com.misc;

/**
 * Created with IntelliJ IDEA.
 * User: abyss
 * Date: 8/12/12
 * Time: 7:42 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.LinkedList;
import java.util.List;
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


    private static void permute2(String prefix, String str, List permutations) {
        int N = str.length();
        if(N == 0) {
            permutations.add(prefix);
            return;
        }
        for(int i = 0; i < N; i++) {
            permute2(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, N), permutations);
        }

    }

    /** Test Method */
    public static void main( String[ ] args ) {

        String s = "ABC";
        //LinkedList<String> permutations = StrPermutations.permutations( s );
        List<String> permutations = new LinkedList<String>();
        StrPermutations.permute2("", s, permutations);

        ListIterator<String> listItr = permutations.listIterator( );
        while( listItr.hasNext( ) ) {
            System.out.println( listItr.next( ) );
        }
    }
}
