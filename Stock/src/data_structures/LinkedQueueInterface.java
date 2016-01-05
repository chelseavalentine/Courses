package data_structures;

/**
 * Linked Queue Interface
 * Created by chelsea on 12/17/15.
 */
public interface LinkedQueueInterface<E> extends Iterable<E> {
    int size();
    boolean isEmpty();
    void enqueue(Object o);
    E dequeue();
    E peek();
}