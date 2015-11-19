package data_structures;

import java.util.Iterator;

/**
 * Linked List
 * @author Chelsea Valentine
 * @since 11/16/2015
 */
public class LinkedList<E> implements LinkedListInterface<E> {
    private Node head;
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(E o) {
        Node current = head;

        while (current != null) {
            if (o == current.item) return true;
            if (o.equals(current.item)) return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public void add(E o) {
        Node node = new Node();
        node.item = o;

        head.next = node;
        head = node;
        size++;
    }

    @Override
    public void remove() {
        Node current = head;

        while (current != null) {
            if (current.next.next == null) {
                current.next = null;
            }
        }
        size--;
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<E> {
        Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E item = current.item;
            current = current.next;
            return item;
        }
    }

    private class Node {
        Node next;
        E item;
    }
}
