package data_structures;

/**
 * Array Stack Interface
 * @author: Chelsea
 * @since 11/16/2015
 */
public interface ArrayStackInterface<E> extends Iterable<E> {
    boolean isEmpty();
    boolean isFull();
    E peek();
    void push(Object o);
    E pop();
    int search(Object o);
    void resize();
}
