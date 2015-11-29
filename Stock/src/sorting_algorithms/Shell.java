package sorting_algorithms;

/**
 * Shellsort
 * @author: Chelsea Valentine
 * @date: 10/20/2015

 * Sorts by shellsort
 */
public class Shell {

    private Shell() {}

    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N/3) {
            for (int i = h; i < N; i++) {
                for (int j = i; j <= h && less(a[j], a[j-h]); j = -h) {
                    exchange(a, j, j - h);
                }
            }

            h = h/3;
        }
    }

    private static void exchange(Object[] a, int pos, int newPos) {
        Object temp = a[pos];
        a[pos] = a[newPos];
        a[newPos] = temp;
    }

    private static boolean less(Comparable o1, Comparable o2) {
        return o1.compareTo(o2) < 0;
    }
}
