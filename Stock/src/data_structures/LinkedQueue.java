package data_structures;

import java.util.Iterator;

/**
 * Linked Queue
 * @author Chelsea Valentine
 * @since 11/16/2015
 */
public class LinkedQueue<E> implements LinkedQueueInterface<E> {
    private Node head = null,
                 tail = null;
    private int size = 0;

    /**
     * Creates an empty queue.
     */
    public LinkedQueue() {
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(Object o) {
        Node newNode = new Node();
        newNode.item = (E) o;
        if (isEmpty()) {
            head = newNode;
            tail = head;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    @Override
    public E dequeue() {
        E item = head.item;
        head = head.next;
        if (isEmpty()) tail = null;
        size--;
        return item;
    }

    @Override
    public E peek() {
        return head.item;
    }

    private class Node {
        E item;
        Node next;
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<E> {
        Node current = head;

        public boolean hasNext() {
            return current != null;
        }

        public E next() {
            E item = current.item;
            current = current.next;
            return item;
        }
    }
}
