package sorting_algorithms;

/**
 * Merge
 * @author: Chelsea Valentine
 * @date: 10/20/2015

 * Sorts by mergesort
 */
public class Merge {
    private static Comparable[] aux;
    private static int times = 0, sortTimes = 0;

    public static void main(String[] args) {
        Integer[] numbers = {1, 10, 2, 4, 7, 9, 6, 5, 3};
        sort(numbers);
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
    private static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, aux, 0, a.length-1);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi-lo) /2; // get midpoint for us to split list in half
        sort(a, aux, lo, mid); // recursively split the halves into halves until they're size 1 partitions
        sort(a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi); // merge the each partition w/ the adjacent partition until no more to merge
        System.out.println("Sort was called " + ++sortTimes + " times; lo & hi are " + lo + " and " + hi);
    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        // copy original array into auxiliary array
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int i = lo, j = mid +1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }

        System.out.println("this merge was called " + ++times + " times; lo & hi are " + lo + " and " + hi);
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
