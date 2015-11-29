/**
 * Binary Search Tree Interface
 * Created by chelsea on 11/28/15.
 */
public interface BSTInterface <E extends Comparable<E>> {
    /**
     * Adds an item to this binary search tree.
     * @param item the item to be added
     */
    void insert(E item);

    /**
     * Removes an item from this binary search tree.
     * If the item isn't in the tree, the structure is unchanged.
     * @param item the item to be removed
     */
    void remove(E item);

    /**
     * Determines if an item is located in this binary search tree.
     * @param item
     * @return
     */
    boolean contains(E item);
}
