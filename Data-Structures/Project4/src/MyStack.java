/**
 * MyStack
 * @author Chelsea
 * @since 11/3/2015
 *
 * The class that provides a reference based implementation of the interface provided in
 * the assignment details
 */
public class MyStack<E> implements StackInterface<E> {
    private Node first = null;
    private int size = 0;

    /**
     * Creates an empty stack
     */
    public MyStack() {}

    /**
     * Checks whether the stack is empty
     * @return true or false respective to whether the stack is or is not empty
     */
    @Override
    public boolean empty() {
        return size == 0;
    }

    /**
     * Returns the value of the element at the top of the stack.
     * @return The element at the top of the stack.
     */
    @Override
    public E peek() {
        return first.item;
    }

    /**
     * Returns and removes the element at the top of the stack.
     * @return The element at the top of the stack.
     */
    @Override
    public E pop() {
        // Get the item at the top of the stack
        E item = first.item;

        // Make the second item in the stack the new top of the stack
        first = first.next;

        size--;
        return item;
    }

    /**
     * Adds an element to the top of the stack.
     * @param item The value of the node to be added.
     * @return The value of the node that was added.
     */
    @Override
    public E push(E item) {
        // Save the current top element of the stack
        Node oldFirst = first;

        // Create a new node for the item and put it at the top of the stack
        first = new Node();
        first.item = item;

        // Assign the previous top of the stack to be the second element in the stack
        first.next = oldFirst;

        size++;
        return null;
    }

    /**
     * Returns te 1-based position indicating where an object is on the stack
     * @param o the object to look for
     * @return an int >= 0 if it exists, -1 if it doesn't exist
     */
    @Override
    public int search(Object o) {
        // Create a copy of a reference to iterate through the stack
        Node current = first;
        int index = 1;

        while (current != null) {
            if (current == o || current.equals(o)) return index;
            current = current.next;
            index++;
        }

        return -1;
    }

    private class Node {
        Node next;
        E item;
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";
        StringBuilder sb = new StringBuilder();
        Node copy = first;

        sb.append('[');

        while (copy != null) {
            sb.append(copy.item);
            if (copy.next != null) sb.append(',');
            copy = copy.next;
        }

        sb.append(']');
        return sb.toString();
    }
}
