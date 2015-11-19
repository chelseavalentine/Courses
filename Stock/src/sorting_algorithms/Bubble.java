package sorting_algorithms;

/**
 * Bubble
 * @author: Chelsea Valentine
 * @date: 10/20/2015

 * Sorts by bubble sort:
 * For each pair of elements, swap them if they're out of order.
 */
public class Bubble {
    public static void sort(Comparable[] a) {
        int N = a.length;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - i - 1; j++) {
                if (less(a[j + 1], a[j])) {
                    swap(a, j, j+1);
                }
            }
        }
    }
    private static boolean less(Comparable a1, Comparable a2) {
        return (a1.compareTo(a2) < 0);
    }

    private static void swap(Comparable[] a, int a1, int a2) {
        Comparable temp = a[a1];
        a[a1] = a[a2];
        a[a2] = temp;
    }
}
