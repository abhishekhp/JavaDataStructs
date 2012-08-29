package com.datastructure;

/**
 * Created with IntelliJ IDEA.
 * User: abyss
 * Date: 8/13/12
 * Time: 12:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class BinTreeTest {
    private Node root;

    private class Node {
        private int data;
        private Node left;
        private Node right;
        private int N;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node createNode(int data) {
        return new Node(data);
    }
    private boolean isBST() {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(Node x, int min, int max) {
        if(x == null) return true;
        if(x.data <= min) return false;
        if (x.data >= max) return false;
        return isBST(x.left, min, x.data) && isBST(x.right, x.data, max);

    }

    public static void main (String ...args) {
        BinTreeTest bt = new BinTreeTest();
        Node a = bt.createNode(10);
        Node b1 = bt.createNode(5);
        Node b2 = bt.createNode(15);
        a.left = b1;
        a.right = b2;
        Node c3 = bt.createNode(11);
        b1.right = c3;

        System.out.print(bt.isBST(a, Integer.MIN_VALUE, Integer.MAX_VALUE));




    }
}


