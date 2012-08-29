package com.datastructure;

/**
 * Created with IntelliJ IDEA.
 * User: abyss
 * Date: 8/12/12
 * Time: 10:24 AM
 * To change this template use File | Settings | File Templates.
 */


public class CircularLinkedList<Item> {

    private class Node {

        Item data;
        Node next;

        public Node( Item data ) {
            this.data = data;
        }

        public Node( Item data, Node next ) {
            this.data = data;
            this.next = next;
        }
    }

    Node entryNode;

    /**
     * Adds a node to the circular linked-list via the entry node.
     */
    public void add( Item data ) {

        if( entryNode == null ) {

            // Initialize the entry node.
            //
            entryNode = new Node( data );

            // Link entry node to self, as there is only one node on the list.
            //
            entryNode.next = entryNode;

        } else {

            // Add the node to the circular linked-list.
            //
            entryNode.next = new Node( data, entryNode.next );
        }
    }

    /**
     * Removes the first occurrence of the node (as specified by the data).
     */
    public void remove( Item data ) {

        if( entryNode != null ) {

            Node itr = entryNode;

            do {

                if( itr.next.data.equals( data ) ) {

                    if( itr.next == entryNode && entryNode != entryNode.next ) {

                        // There are still nodes left in the list, but the node
                        // that we need to remove is the entryNode; so we need
                        // to reassign the field to the next node in line.
                        //
                        itr.next = itr.next.next;
                        entryNode = entryNode.next;

                    } else if( itr.next == itr.next.next ) {

                        // This condition will only be true if there is only one
                        // node left in the list, which will be the entryNode.
                        //
                        entryNode = null;

                    } else {

                        // The node that we need to remove is a regular node,
                        // i.e. not an entryNode.
                        //
                        itr.next = itr.next.next;
                    }

                    // Done!
                    //
                    return;
                }

                // Move to the next available node in the list.
                //
                itr = itr.next;

            } while( itr != entryNode );
        }
    }

    /**
     * Returns the first occurrence of the node that matches the specified
     * data or null if not found. Has a O(n) run-time complexity.
     */
    public Node get( Item data ) {

        if( entryNode != null ) {

            Node itr = entryNode;

            do {

                if( itr.data.equals( data ) ) {
                    return itr;
                }

                itr = itr.next;

            } while( itr != entryNode );
        }

        return null;
    }

    /**
     * Does a full iteration starting and ending at the entry node.
     */
    public void iterate( ) {

        if( entryNode != null ) {

            Node itr = entryNode;

            do {

                System.out.print( itr.data + " " );
                itr = itr.next;

            } while( itr != entryNode );

            System.out.println( );
        }
    }



    /**
     * Test Method
     */
    public static void main( String[ ] args ) {

        // Initialize and populate the circular linked-list
        //
        CircularLinkedList list = new CircularLinkedList( );

        for( int i = 1; i <= 5; i++ ) {
            list.add( i );
        }

        // Prints: 5 4 3 2 1
        //
        list.iterate( );

        // Remove nodes 3, 2, 1 from the circular list.
        //
        for( int i = 1; i <= 3; i++ ) {
            list.remove( list.get( i ).data );
        }

        // Prints: 5 4
        //
        list.iterate( );

        // Get and remove node 4
        //
        //Node node4 = list.get( 4 );
        list.remove( 4 );

        // Prints: 5
        //
        list.iterate( );
    }
}
