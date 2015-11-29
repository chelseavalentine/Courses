package data_structures;

/**
 * Priority Queue on an Unordered Array
 *
 * Created by chelsea on 11/27/15.
 */
public class UnorderedPriorityQueue<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;

    public UnorderedPriorityQueue(int capacity) {
        pq = (Key[]) new Comparable[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Key x) {
        pq[N++] = x;
    }

    public Key delMax() {
        int max = 0;
        for (int i = 1; i < N; i++) {
            if (less(max, i)) max = i;
        }
        exchange(max, N-1);
        return pq[--N]; // you could null out entry to prevent loitering
    }

    private void exchange(int pos, int newPos) {
        Key temp = pq[pos];
        pq[pos] = pq[newPos];
        pq[newPos] = temp;
    }

    private static boolean less(Comparable o1, Comparable o2) {
        return o1.compareTo(o2) < 0;
    }
}
