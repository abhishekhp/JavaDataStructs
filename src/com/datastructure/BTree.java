package com.datastructure;

/**
 * Created with IntelliJ IDEA.
 * User: abyss
 * Date: 8/10/12
 * Time: 5:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class BTree <K extends Comparable<K>, V> {

    private Node root;

    private class Node {
        private K key;
        private V val;
        private Node left;
        private Node right;
        private int N;

        public Node(K key, V val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    // is the symbol table empty?
    public boolean isEmpty() {
        return size() == 0;
    }

    // return number of key-value pairs in BST
    public int size() {
        return size(root);
    }

    // return number of key-value pairs in BST rooted at x
    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    private boolean contains(K key) {
       return get(key) != null;
    }

    public V get(K key) {
        return get(root, key);
    }

    private V get(Node x, K key) {
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0)
            return get(x.left, key);
        else if (cmp >0)
            return get(x.right, key);
        else
            return x.val;

    }

    public void put(K key, V val) {
        root = put(root, key, val);
    }

    private Node put(Node x, K key, V val) {
        if(x == null)
           return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if(cmp < 0)
             x.left = put(x.left, key, val);
        else if (cmp >0)
             x.right = put(x.right, key, val);
        else
            x.val  = val;
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }



    public K min() {
        if (isEmpty()) return null;
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        else                return min(x.left);
    }

    public K max() {
        if (isEmpty()) return null;
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) return x;
        else                 return max(x.right);
    }

    public void deleteMin() {
        if (isEmpty()) throw new RuntimeException("Symbol table underflow");
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void deleteMax() {
        if(isEmpty()) throw new RuntimeException("Symbol table underflow");
        root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if(x.right == null) return  x.left;
        x.right = deleteMax(x.right);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(K key) {
        delete(root, key);
    }

    private Node delete(Node x, K key) {
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0)
            x.left  = delete(x.left,  key);
        else if (cmp > 0)
            x.right = delete(x.right, key);
        else  {
            if(x.right == null) return  x.left;
            if(x.left == null) return x.right;
            Node t = x;
            System.out.println("t- key" + t.key);
            x = min(t.right);
            System.out.println("x- key" + x.key);
            x.right = deleteMin(t.right);
            System.out.println("x right- key" + x.right.key);
            x.left = t.left;
            System.out.println("x left- key" + x.left.key);
        }
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }

    // height of this BST (one-node tree has height 0)
    public int height() { return height(root); }
    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }

    // does this binary tree satisfy symmetric order?
    // Note: this test also ensures that data structure is a binary tree since order is strict
    private boolean isBST() {
        return isBST(root, null, null);
    }

    private boolean isBST(Node x, K min, K max) {
        if(x == null) return true;
        if(min != null && x.key.compareTo(min) <= 0) return false;
        if(max != null && x.key.compareTo(max) >= 0) return false;
        return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);

    }

    //TODO: Create custom LinkedList to store the keys instead of queues below

    // level order traversal
    public Iterable<K> levelOrder() {
        Queue<K> keys = new Queue<K>();
        Queue<Node> queue = new Queue<Node>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node x = queue.dequeue();
            if (x == null) continue;
            keys.enqueue(x.key);
            queue.enqueue(x.left);
            queue.enqueue(x.right);
        }
        return keys;
    }

    //TODO: Non-recursive versions of pre, in and post order traversal using stacks

    public Iterable<K> preOrder() {
        Queue<K> keys = new Queue<K>();
        preOrder(root, keys);
        return keys;
    }

    private void preOrder(Node x, Queue keys) {
        if(x == null) return;
        keys.enqueue(x.key);
        preOrder(x.left, keys);
        preOrder(x.right, keys);
    }

    public Iterable<K> postOrder() {
        Queue<K> keys = new Queue<K>();
        postOrder(root, keys);
        return keys;
    }

    private void postOrder(Node x, Queue keys) {
        if(x == null) return;
        postOrder(x.left, keys);
        postOrder(x.right, keys);
        keys.enqueue(x.key);
    }

    public Iterable<K> inOrder() {
        Queue<K> keys = new Queue<K>();
        inOrder(root, keys);
        return keys;
    }

    private void inOrder(Node x, Queue keys) {
        if(x == null) return;
        inOrder(x.left, keys);
        keys.enqueue(x.key);
        inOrder(x.right, keys);
    }

    /** Iteratively traverses the binary tree in pre-order */
    public Iterable<K> preorder( ) {

        Queue<K> keys = new Queue<K>();
        if( root == null ) return keys;

        Stack<Node> stack = new Stack<Node>( );
        stack.push( root );

        while( ! stack.isEmpty( ) ) {
            Node current = stack.pop( );
            if( current.right != null ) stack.push( current.right );
            if( current.left != null ) stack.push( current.left );
            keys.enqueue(current.key);
        }
        return keys;
    }

    /** Iteratively traverses the binary tree in in-order */
    public Iterable<K> inorder( ) {
        Node current = root;
        Queue<K> keys = new Queue<K>();
        Stack<Node> stack = new Stack<Node>( );
        while( ! stack.isEmpty( ) || current != null ) {
            if( current != null ) {
                stack.push( current );
                current = current.left;
            } else {
                current = stack.pop( );
                keys.enqueue(current.key);
                current = current.right;
            }
        }
        return keys;
    }

    /** Iteratively traverses the binary tree in post-order */
    public Iterable<K> postorder( ) {
        Queue<K> keys = new Queue<K>();
        if( root == null ) return keys;

        Stack<Node> stack = new Stack<Node>( );
        Node current = root;

        while( true ) {

            if( current != null ) {
                if( current.right != null ) stack.push( current.right );
                stack.push( current );
                current = current.left;
                continue;
            }

            if( stack.isEmpty( ))  return  keys;
            current = stack.pop( );

            if( current.right != null && ! stack.isEmpty( ) && current.right == stack.peek( ) ) {
                stack.pop( );
                stack.push( current );
                current = current.right;
            } else {
                keys.enqueue(current.key);
                current = null;
            }
        }

    }

}
