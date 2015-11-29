package sorting_algorithms;

/**
 * Shuffle
 * @author: Chelsea Valentine
 * @date: 10/20/2015

 * Sorts by selection sort
 */
public class Shuffle {
    private Shuffle() {}

    public static void sort(Object[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            // int r = StdRandom.uniform(i + 1);
            int r = (int) Math.floor(Math.random() * (i + 1));
            exchange(a, i, r);
        }
    }

    private static void exchange(Object[] a, int pos, int newPos) {
        Object temp = a[pos];
        a[pos] = a[newPos];
        a[newPos] = temp;
    }
}
