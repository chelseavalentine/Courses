/**
 * Binary
 * @author: Chelsea Valentine
 * @date: 10/20/2015

 * Searches for an element using binary search.
 */
public class Binary {
    /**
     * Iterative binary search.
     * @param a
     * @param item
     * @return
     */
    public static int searchIter(Comparable[] a, Comparable item) {
        int left = 0,
                right = a.length - 1,
                mid;

        while (left != right) {
            mid = (left + right) / 2;
            if (0 > a[mid].compareTo(item)) left = mid; //if mid element < item discard left half
            else if (0 < a[mid].compareTo(item)) right = mid; //if mid element > item discard right half
            else return mid; // found it, return the index
        }

        return -1;
    }

    public static int searchBin(Comparable[] a, Comparable item) {
        return -1;
    }
}
