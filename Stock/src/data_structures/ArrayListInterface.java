package data_structures;

import java.util.ArrayList;

/**
 * ArrayList Interface
 *
 * Created by Chelsea on 11/10/2015.
 */
public interface ArrayListInterface<E> {
    int size();
    boolean isEmpty();
    boolean isFull();
    boolean contains(Object o);
    boolean add(Object o);
    boolean remove(Object o);
    boolean equals(Object o);
    E get(int index);
    void resize();
}
