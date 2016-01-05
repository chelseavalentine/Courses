package data_structures;

import java.util.Iterator;

/**
 * LinkedStack
 * @author: Chelsea Valentine
 * @date: 10/20/2015

 * A generic linked list implementation of a stack.
 */
public class LinkedStack<E> implements LinkedStackInterface<E> {
    private Node first = null;

    /**
     * Creates an empty stack.
     */
    public LinkedStack() {
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public E peek() {
        return first.item;
    }

    @Override
    public void push(Object o) {
        Node oldFirst = first;
        first = new Node();
        first.item = (E) o;
        first.next = oldFirst;
    }

    @Override
    public E pop() {
        E item = first.item;
        first = first.next;
        return item;
    }

    /**
     * Returns te 1-based position indicating where an object is on the stack
     * @param o the object to look for
     * @return an int >= 0 if it exists, -1 if it doesn't exist
     */
    @Override
    public int search(Object o) {
        Node current = first;
        int index = 1;

        while (current != null) {
            if (current.item == o || current.item.equals(o)) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    private class Node {
        E item;
        Node next;
    }

    public Iterator<E> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<E> {
        Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public E next() {
            E item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            // not supported
        }
    }
}
