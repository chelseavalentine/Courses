package data_structures;

import java.util.Queue;

/**
 * Binary Search Tree
 * Created by Chelsea on 11/16/2015.
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> implements BinarySearchTreeInterface<Key, Value> {
    private Key key;
    Value val;
    Node left, right, root;
    int count;

    @Override
    public Object get(Comparable comparable) {
        return null;
    }

    @Override
    public void put(Comparable comparable, Object val) {

    }

    @Override
    public Key floor(Key key) {
        return null;
    }

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);
        Node t = floor (x.right, key);
        if (t != null) return t;
        else return x;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.count;
    }

    @Override
    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node x) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(key, x.left);
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
        else return size(x.left);
    }

    public Iterable<Key> keys() {
        Queue<Key> q = new Queue<Key>();
        inorder(root, q);
        return q;
    }

    private void inorder(Node x, Queue<Key> q) {
        if (x == null) return;
        inorder(x.left, q);
        q.add(x.key);
        inorder(x.right, q);
    }

    private class Node {
        private Key key;
        Value val;
        Node left, right;
        int count;

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
    }
}
