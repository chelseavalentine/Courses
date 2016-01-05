package data_structures;

import data_structures.ArrayStackInterface;

import java.util.Iterator;

/**
 * ArrayStack
 * @author: Chelsea Valentine
 * @date: 10/20/2015

 * A generic array implementation of a stack.
 */
public class ArrayStack<E> implements ArrayStackInterface<E> {
    private E[] stack;
    private int size = 0;
    private int capacity;

    public ArrayStack (int capacity) {
        this.capacity = capacity;
        // cast Object to E since Java doesn't allow generic array creation
        stack = (E[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public E peek() {
        return stack[size - 1];
    }

    @Override
    public void push(Object o) {
        if (isFull()) resize();
        stack[size++] = (E) o;
    }

    public E pop() {
        return stack[--size];
    }

    @Override
    public int search(Object o) {
        for (int i = 0; i < size; i++) {
            if (stack[i] == o || stack[i].equals(o)) return i;
        }
        return -1;
    }

    public void resize() {
        E[] oldStack = stack;
        capacity *= 2;
        stack = (E[]) new Object[capacity];

        for (int i = 0; i < size; i++) {
            stack[i] = oldStack[i];
        }
    }

    public Iterator<E> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<E> {
        int i = size;

        public boolean hasNext() {
            return i > 0;
        }

        public E next() {
            return stack[--i];
        }

        @Override
        public void remove() {
            //
        }
    }
}
