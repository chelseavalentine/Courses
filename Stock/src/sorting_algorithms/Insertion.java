package sorting_algorithms;

import java.util.Random;

/**
 * Insertion
 * @author: Chelsea Valentine
 * @date: 10/20/2015

 * Iterates through the list, swapping each element with the element
 * to its left if it's larger
 */
public class Insertion {
    public static void main(String[] args) {
        Integer[] numbers = {1, 10, 3, 2, 4, 7, 9, 6, 5};
        sort(numbers);
        for (Integer number : numbers) {
            System.out.println(number);
        }
    }

    public static void sort(Comparable[] a) {
        int N = a.length;

        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j-1])) swap(a, j, j-1);
                else break;
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
