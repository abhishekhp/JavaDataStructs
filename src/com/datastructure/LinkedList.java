package com.datastructure;

/**
 * Created with IntelliJ IDEA.
 * User: abyss
 * Date: 8/25/12
 * Time: 3:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class LinkedList <Item>
{
    // reference to the head node.
    private Node head;
    private int listCount;

    private class Node
    {
        // reference to the next node in the chain,
        // or null if there isn't one.
        Node next;
        // data carried by this node.
        // could be of any type you need.
        Item data;


        // Node constructor
        public Node(Item _data)
        {
            next = null;
            data = _data;
        }

        // another Node constructor if we want to
        // specify the node to point to.
        public Node(Item _data, Node _next)
        {
            next = _next;
            data = _data;
        }
    }

    // LinkedList constructor
    public LinkedList()
    {
        // this is an empty list, so the reference to the head node
        // is set to a new node with no data
        head = new Node(null);
        listCount = 0;
    }

    public void add(Item data)
    // post: appends the specified element to the end of this list.
    {
        Node temp = new Node(data);
        Node current = head;
        // starting at the head node, crawl to the end of the list
        while(current.next != null)
        {
            current = current.next;
        }
        // the last node's "next" reference set to our new node
        current.next = temp;
        listCount++;// increment the number of elements variable
    }

    public void add(Item data, int index)
    // post: inserts the specified element at the specified position in this list.
    {
        Node temp = new Node(data);
        Node current = head;
        // crawl to the requested index or the last element in the list,
        // whichever comes first
        for(int i = 1; i < index && current.next != null; i++)
        {
            current = current.next;
        }
        // set the new node's next-node reference to this node's next-node reference
        temp.next = current.next;
        // now set this node's next-node reference to the new node
        current.next = temp;
        listCount++;// increment the number of elements variable
    }

    public Object get(int index)
    // post: returns the element at the specified position in this list.
    {
        // index must be 1 or higher
        if(index <= 0)
            return null;

        Node current = head.next;
        for(int i = 1; i < index; i++)
        {
            if(current.next == null)
                return null;

            current = current.next;
        }
        return current.data;
    }

    public boolean remove(int index)
    // post: removes the element at the specified position in this list.
    {
        // if the index is out of range, exit
        if(index < 1 || index > size())
            return false;

        Node current = head;
        for(int i = 1; i < index; i++)
        {
            if(current.next == null)
                return false;

            current = current.next;
        }
        current = current.next.next;
        listCount--; // decrement the number of elements variable
        return true;
    }

    public int size()
    // post: returns the number of elements in this list.
    {
        return listCount;
    }

    public String toString()
    {
        Node current = head.next;
        String output = "";
        while(current != null)
        {
            output += "[" + current.data.toString() + "]";
            current = current.next;
        }
        return output;
    }


}
