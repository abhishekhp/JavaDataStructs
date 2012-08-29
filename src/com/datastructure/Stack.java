package com.datastructure;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: abyss
 * Date: 8/10/12
 * Time: 2:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class Stack <Item> implements Iterable <Item> {

    int N = 0;

    Node first;

    private class Node {
        Item  item;
        Node next;
    }

    /**
     * Create an empty stack.
     */
    public Stack() {
        first = null;
        N = 0;
    }

    /**
     * Is the stack empty?
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Return the number of items in the stack.
     */
    public int size() {
        return N;
    }

    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public Item pop() {
        if(isEmpty()) throw new RuntimeException("Stack empty");
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Item peek() {
        if(isEmpty()) throw new RuntimeException("Stack empty");
        return first.item;
    }

    /**
     * Return string representation.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements  Iterator <Item> {
        Node current = first;

        public boolean hasNext() {
            return current != null ;
        }

        public Item next() {
            if(!hasNext()) throw new UnsupportedOperationException();
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


}


