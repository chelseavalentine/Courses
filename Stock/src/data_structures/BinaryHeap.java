package data_structures;

/**
 * Binary Heaps
 * This is a max PQ.
 *
 * Binary heaps are an array representation of a heap ordered complete binary tree, where indices start at 1.
 *
 * Properties of a heap-ordered binary tree:
 *      - keys are in nodes
 *      - a parent's key isn't smaller than its children's keys
 *
 * A binary tree is empty or it's a node with links to left and right binary trees.
 *
 * Created by chelsea on 11/28/15.
 *
 * //TODO: Don't trust that this class actually works in most cases w/o fail. Check it for sure!
 */
public class BinaryHeap <Key extends Comparable<Key>>{
    private Key[] pq;
    private int N = 0;

    public BinaryHeap(int capacity) {
        pq = (Key[]) new Comparable[capacity + 1];
    }

    public void insert(Key x) {
        pq[++N] = x;
        swim(N);
    }

    /**
     * Promotion within a heap
     * When there's a violation in the heap due to a child's key being greater than the parent's, "swim" the child's
     * key up by exchanging it with the parent's
     *
     * @param k the child's key
     */
    private void swim(int k) {
        // the parent node at k is k/2
        while (k > 1 && less(k/2, k)) {
            exchange(k, k/2);
            k = k/2;
        }
    }

    /**
     * Demotion within a heap
     * When the paren'ts key becomes smaller than its child/ren, exchange the parent key w/ the larger child & repeat
     * until order is restored
     *
     * @param k the parent's key
     */
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j+1)) j++;
            if (!less(k, j)) break;
            exchange(k, j);
            k = j;
        }
    }

    /**
     * Delete the maximum key in a heap
     * Exchange the root with the node at the end of the tree, and then sink it down.
     * This takes less than or equal to 2logN compares.
     *
     * @return the maximum key in the heap
     */
    public Key delMax() {
        Key max = pq[1];
        exchange(1, N--);
        sink(1);
        pq[N + 1] = null; // prevent loitering
        return max;
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
