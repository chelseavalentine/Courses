package data_structures;

import java.util.Iterator;

/**
 * Linked List Interface
 * Created by Chelsea on 11/16/2015.
 */
public interface LinkedListInterface<E> {
    int size();
    boolean isEmpty();
    boolean contains(E item);
    void add(E item);
    void remove();
    Iterator<E> iterator();
}
