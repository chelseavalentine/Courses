package data_structures;

/**
 * Binary Search Tree Interface
 * @author Chelsea Valentine
 * @since 11/16/2015
 */
public interface BinarySearchTreeInterface<Key extends Comparable<Key>, Value> {
    Value get(Key key);
    void put(Key key, Value val);
    Key floor(Key key);
    int size();
    int rank(Key key);
}
