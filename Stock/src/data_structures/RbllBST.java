package data_structures;

/**
 * Red-Black Left-Leaning Balanced Search Tree
 * (1) Represent a 2-3 Tree as a BST
 * (2) Use "internal" left-leaning links as "glue" for 3-nodes
 *
 * Properties of a Red-Black BST:
 *      - No node has 2 red links connected to it
 *      - Every path from the root to null link has "perfect black balance" (same number of black links)
 *      - Red links lean left
 *      - each LLRB BST corresponds to a 2-3 tree
 *
 * What is a 2-3 tree?
 * A tree where you allow 1-2 keys per node, which gives you:
 *      2-node: one key w/ 2 children
 *      3-node: two keys w/ 3 children
 *
 * Characteristics of a 2-3 Tree:
 *      - perfect balance: every path from the root to a null link has the same length
 *      - symmetric order: in-order traversal yields keys in ascending order
 *
 * Created by chelsea on 11/28/15.
 * //TODO: Complete this class
 */
public class RbllBST<K extends Comparable<K>, V extends Comparable<V>> {
    private Node root;

    private final static boolean RED = true;
    private final static boolean BLACK = false;

    public V get(K key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.val;
        }
        return null;
    }

    private Node put(Node h, K key, V val) {
        if (h == null) return new Node(key, val, RED);
        int cmp = key.compareTo(h.key);

        if (cmp < 0) h.left = put(h.left, key, val);
        else if (cmp > 0) h.right = put(h.right, key, val);
        else h.val = val;

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h); // balance a 4-node
        if (isRed(h.left) && isRed(h.right)) flipColors(h); //split a 4 node;

        return h;
    }

    /**
     * Rotate a temporarily right-leaning red link left.
     * @param h
     * @return
     */
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    /**
     * Rotate a temporarily left-leaning black(?) link right
     * (This occurs when there're 2 red links in a row)
     * @param h
     * @return
     */
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    /**
     * Recolor a sub-tree to split temporary 4-nodes
     * @param h
     */
    private void flipColors(Node h) {
        h.color = RED;
        h.right.color = BLACK;
        h.left.color = BLACK;
    }

    private class Node {
        K key;
        V val;
        Node left, right;
        boolean color;

        Node(K key, V val, boolean isRED) {
            this.key = key;
            this.val = val;
            this.color = isRED;
        }
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }
}
