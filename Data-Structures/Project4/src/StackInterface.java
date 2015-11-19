/**
 * Stack Interface
 * @author Chelsea
 * @since 11/3/2015
 *
 */
public interface StackInterface<E> {
    /**
     * Tests if this stack is empty
     * @return
     */
    boolean empty();

    /**
     * Looks at the object at the top of this stack without removing it
     * from the stack
     * @return
     */
    E peek();

    /**
     * Removes the object at the top of this stack & returns that object as
     * the value of this method
     * @return
     */
    E pop();

    /**
     * Pushes an item onto the top of this stack
     * @param item
     * @return
     */
    E push(E item);

    /**
     * Returns the 1-based position where an object is on this stack
     * @param o
     * @return
     */
    int search(Object o);
}
