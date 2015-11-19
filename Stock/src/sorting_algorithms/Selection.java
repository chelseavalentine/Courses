package sorting_algorithms;

/**
 * Selection
 * @author: Chelsea Valentine
 * @date: 10/20/2015

 * Sorts by selection sort
 * Find the smallest item in the list and then swap it with the first element of the list
 */
public class Selection {
    public static void main(String[] args) {
        Integer[] numbers = {1, 10, 3, 2, 4, 7, 9, 6, 5};
        sort(numbers);
        for (Integer number : numbers) {
            System.out.println(number);
        }
    }

    public static void sort(Comparable[] a) {
        int N = a.length,
            minIndex = 0;
        Comparable min = null;

        for (int i = 0; i < N - 1; i++) {
            min = a[i];
            minIndex = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], min)) {
                    minIndex = j;
                    min = a[j];
                }
            }
            swap(a, minIndex, i);
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
