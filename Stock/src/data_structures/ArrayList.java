package data_structures;

/**
 * ArrayList
 *
 * Created by Chelsea on 11/10/2015.
 */
public class ArrayList<E> implements ArrayListInterface {
    private E[] list;
    private int capacity;
    private int size = 0;

    public ArrayList(int capacity) {
        this.capacity = capacity;
        list = (E[])(new Object[capacity]);
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
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) if (list[i] == o || list[i].equals(o)) return true;
        return false;
    }

    @Override
    public boolean add(Object o) {
        if (isFull()) resize();
        list[size] = (E) o;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (list[i] == o || list[i].equals(o)) {
                list[i] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int index) {
        if (index < 0) return null;
        if (list[index] != null) return list[index];
        return null;
    }

    @Override
    public void resize() {
        capacity *= 2;
        E[] oldList = list;
        list = (E[]) new Object[capacity];

        for (int i = 0; i < oldList.length; i++) {
            list[i] = oldList[i];
        }
    }
}
