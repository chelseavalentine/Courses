package data_structures;

/**
 * Queue Interface
 * @author Chelsea Valentine
 * @since 11/16/2015
 */
public interface LinkedQueueInterface<E> extends Iterable<E> {
    int size();
    boolean isEmpty();
    void enqueue(Object o);
    E dequeue();
    E peek();
}
