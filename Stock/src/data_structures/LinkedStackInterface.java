package data_structures;

/**
 * Linked Stack Interface
 * @author: Chelsea Valentine
 * @date: 11/16/2015
 */
public interface LinkedStackInterface<E> extends Iterable<E> {
    boolean isEmpty();
    E peek();
    void push(Object o);
    E pop();
    int search(Object o);
}
