package data_structures;

import java.util.Iterator;

/**
 * Linked List
 * @author Chelsea Valentine
 * @since 11/16/2015
 */
public class LinkedList<E> implements LinkedListInterface<E> {
    private Node head = null;
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
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public Node get(int index) {
        if (head == null) return null;
        Node curr = head;
        while (index > 0 && curr != null) {
            curr = curr.next;
            index--;
        }
        return curr;
    }

    public void partition(int val) {
        if (head == null) return;
        Node curr = head, lower;
        while (curr != null) {
            if ((Integer)curr.item >= val) {
                lower = curr.next;
                while (lower != null) {
                    if ((Integer)lower.item < val) {
                        swap(curr, lower);
                        break;
                    }
                    else {
                        lower = lower.next;
                    }
                }
            }
            curr = curr.next;
        }
    }

    private void swap(Node n1, Node n2) {
        Node temp = new Node();
        temp.item = n1.item;
        n1.item = n2.item;
        n2.item = temp.item;
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

        @Override
        public void remove() {
            //
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Node curr = head;
        while (curr != null) {
            if (curr.next != null) sb.append(curr.item + ", ");
            else sb.append(curr.item);
            curr = curr.next;
        }
        sb.append(']');
        return sb.toString();
    }

    private class Node {
        Node next;
        E item;

        @Override
        public String toString() {
            return item.toString();
        }
    }
}
