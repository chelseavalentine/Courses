package sorting_algorithms;

/**
 * Merge
 * @author: Chelsea Valentine
 * @date: 10/20/2015

 * Sorts by mergesort
 */
public class Merge {
    private static boolean less(Comparable a1, Comparable a2) {
        return (a1.compareTo(a2) < 0);
    }

    private static void swap(Comparable[] a, int a1, int a2) {
        Comparable temp = a[a1];
        a[a1] = a[a2];
        a[a2] = temp;
    }
}
