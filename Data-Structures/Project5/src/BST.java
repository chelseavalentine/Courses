/**
 * BST (Binary Search Tree)
 * @author Chelsea Valentine
 * @since 11/28/2015
 */
public class BST<E extends Comparable<E>> implements BSTInterface<E> {
    protected Node root;

    public BST() {
    }

    /**
     * Get the value of a node we want to find
     * @param item the value we're looking to find
     * @return the value if it exists
     */
    public E get(E item) {
        return get(root, item);
    }

    /**
     * Get a node from the BST
     * @param node the root node of the subtree to add our node to
     * @param item the value of the node
     * @return the node in the tree, if it exists
     */
    protected E get(Node node, E item) {
        if (item == null) return null;

        // compare the values of the nodes to decide where to search
        int comparison = item.compareTo(node.item);
        if (comparison < 0) return get(node.left, item);
        else if (comparison > 0) return get(node.right, item);
        else return node.item;
    }

    /**
     * Adds an item to this binary search tree.
     * @param item the item to be added
     */
    @Override
    public void insert(E item) {
        root = insert(root, item);
    }

    /**
     * Add a node to the BST
     * @param node the root node of the subtree to add our node to
     * @param item the value of the node
     * @return the updated subtree
     */
    protected Node insert(Node node, E item) {
        if (node == null) return new Node(item);

        // compare the values of the nodes to decide where to put it
        int comparison = item.compareTo(node.item);
        if (comparison > 0) node.right = insert(node.right, item);
        else if (comparison < 0) node.left = insert(node.left, item);
        else node.item = item;

        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }

    /**
     * Get the size of the bst
     * @return the size
     */
    public int size() {
        return size(root);
    }

    /**
     * Get the size of a subtree of the node
     * @param node the root of the subtree we're getting the size
     * @return the size of the subtree
     */
    protected int size(Node node) {
        if (node == null) return 0;
        return node.count;
    }

    /**
     * Removes an item from this binary search tree.
     * If the item isn't in the tree, the structure is unchanged.
     * @param item the item to be removed
     */
    @Override
    public void remove(E item) {
        if (item == null) return;
        root = remove(root, item);
    }

    /**
     * Remove an item from the BST if it's there
     * @param node the root of the subtree
     * @param item the value of the node that we want to remove
     * @return the updated subtree
     */
    protected Node remove(Node node, E item) {
        // item is not in the tree
        if (node == null) return null;

        int comparison = item.compareTo(node.item);

        // search in the left subtree
        if (comparison < 0) node.left = remove(node.left, item);

        // search in the right subtree
        else if (comparison > 0) node.right = remove(node.right, item);

        // found it!
        else {
            // rearrange the tree to account for deletion
            // get the predecessor
            if (node.right == null)
                return node.left;
            else if (node.left == null)
                return node.right;

            Node temp = node;
            node = getMinimum(temp.right);
            node.right = deleteMinimum(temp.right);
            node.left = temp.left;
        }

        // update the size count of the node
        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }

    /**
     * Get the smallest-valued node
     * @param node the root node of a subtree
     * @return the smallest-valued node
     */
    private Node getMinimum(Node node) {
        if (node.left == null)
            return node;
        else
            return (getMinimum(node.left));
    }

    /**
     * Delete the minimum valued note
     * @param node the node to find the minimum value of to remove
     * @return the minimum node
     */
    private Node deleteMinimum(Node node) {
        if (node.left == null)
            return node.right;

        // check the left subtree, which contains smaller words
        node.left = deleteMinimum(node.left);

        // update the size of the node
        node.count = 1 + size(node.left) + size(node.right);

        return node;
    }

    /**
     * Determines if an item is located in this binary search tree.
     * @param item
     * @return
     */
    @Override
    public boolean contains(E item) {
        if (item == null) return false;
        return get(item) != null;
    }

    protected class Node {
        protected E item;
        protected Node left, right;
        protected int count = 1; // helps us keep track of the size of this node

        Node(E item) {
            this.item = item;
        }
    }
}
