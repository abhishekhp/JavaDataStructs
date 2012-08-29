package com.datastructure;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: abyss
 * Date: 8/10/12
 * Time: 3:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class Queue <Item> implements  Iterable<Item> {
    int N = 0;
    Node first;
    Node last;

    private class Node {
        Item item;
        Node next;
    }
    /**
     * Create an empty queue.
     */
    public Queue() {
        first = null;
        last  = null;
        N = 0;
    }

    /**
     * Is the queue empty?
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Return the number of items in the queue.
     */
    public int size() {
        return N;
    }

    public Item peek() {
        if(isEmpty()) throw  new RuntimeException("Quueue is empty");
        return first.item;
    }

    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()) first = last;
        else oldlast.next = last;
        N++;
    }

    public Item dequeue() {
        if(isEmpty()) throw  new RuntimeException("Queue is empty");
        Item item = first.item;
        if(N == 1) {
            first = last = null;
        } else {
            first = first.next;
        }
        N--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();  //To change body of implemented methods use File | Settings | File Templates.
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if(!hasNext()) throw  new UnsupportedOperationException();
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw  new UnsupportedOperationException();
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }



}
