package sorting_algorithms;

/**
 * Heap sort (in-place)
 *
 *
 * (1) Creates a max-heap with all N keys
 * (2) Repeatedly removes the maximum key
 *
 * Created by chelsea on 11/28/15.
 */
public class Heap {
    private Heap() {}

    public static void sort(Comparable[] pq) {
        int N = pq.length;
        for (int k = N/2; k >= 1; k--) {
            sink(pq, k, N);
        }

        while(N > 1) {
            exchange(pq, 1, N);
            sink(pq, 1, --N);
        }
    }

    /**
     * Demotion within a heap
     * When the paren'ts key becomes smaller than its child/ren, exchange the parent key w/ the larger child & repeat
     * until order is restored
     *
     * @param k the parent's key
     */
    private static void sink(Comparable[] pq, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j+1)) j++;
            if (!less(k, j)) break;
            exchange(pq, k, j);
            k = j;
        }
    }

    //TODO: Less & exchange methods should convert from 1-based to 0-based indexing

    private static void exchange(Comparable[] pq, int pos, int newPos) {
        Comparable temp = pq[pos];
        pq[pos] = pq[newPos];
        pq[newPos] = temp;
    }

    private static boolean less(Comparable o1, Comparable o2) {
        return o1.compareTo(o2) < 0;
    }
}
