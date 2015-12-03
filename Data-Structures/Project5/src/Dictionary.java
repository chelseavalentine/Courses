import java.util.ArrayList;

/**
 * Dictionary
 * A dictionary that is modified to represent the collection of words with a BST,
 * rather than an array list
 *
 * The class represent a dictionary of words.
 * It provides a way of searching through the dictionary.
 * It also can produce a dictionary in which the words are limited
 * to a particular length.
 *
 * @author Joanna Klukowska
 * @maintainer Chelsea Valentine
 *
 */
public class Dictionary extends BST<String>
                        implements DictionaryInterface {
    //actual storage for the words
    private BST<String> words;

    /**
     * Creates an empty Dictionary object (no words).
     */
    public Dictionary() {
        words = new BST<>();
    }

    /**
     * Creates a Dictionary object containing all words from the
     * listOfWords passed as a parameter.
     *
     * @param listOfWords the list of words to be stored in the newly created
     * Dictionary object
     */
    public Dictionary ( BST<String> listOfWords ) {
        words = listOfWords;
        if (null == words) {
            words = new BST<>();
        }
    }

    /**
     * Creates a Dictionary object containing all words from the
     * listOfWords passed as a parameter.
     *
     * @param listOfWords the list of words to be stored in the newly created
     * Dictionary object
     */
    public Dictionary ( ArrayList<String> listOfWords ) {
        words = new BST<>();
        for (int i = 0; i < listOfWords.size(); i++) {
            words.insert(listOfWords.get(i));
        }
    }

    /**
     * Creates a new Dictionary object from this Dictionary object that
     * contains words of a specified size.
     * @param size length of the words that should be included in the new
     * Dictionary object
     * @return a new Dictionary object containing only the words of specified
     * size
     */
    public Dictionary getWordsBySize ( int size ) {
        BST<String> wordsBySize = new BST<>();

        // add word to the BST if it's the specified size
        getWordsBySize(wordsBySize, wordsBySize.root, size);

        return new Dictionary (wordsBySize);
    }

    /**
     *
     * @param bst the bst to add words to
     * @param node the node to check the size of
     * @param size the length of the word
     */
    private void getWordsBySize(BST bst, Node node, int size) {
        if (node == null) return;

        // work on left subtree
        getWordsBySize(bst, node.left, size);

        // process node
        if (node.item.length() == size)
            // add node if it's the specified size
            bst.insert(node.item);

        // work on right subtree
        getWordsBySize(bst, node.right, size);
    }

    /**
     * Performs (binary) search in this Dictionary object for a given word.
     * @param word  the word to look for in this Dictionary object.
     * @return true if the word is in this Dictionary object, false otherwise
     */
    public boolean findWord ( String word ) {
        return words.contains(word);
    }

    /**
     * Performs (binary) search in this Dictionary object for a given prefix.
     * @param prefix  the prefix to look for in this Dictionary object.
     * @return true if at least one word with the specified prefix exists
     * in this Dictionary object, false otherwise
     */
    public boolean findPrefix (String prefix ) {
        return isPrefixInDictionaryRecursive(words.root, prefix);
    }

    /**
     * The actual method providing recursive implementation of the binary search
     * for the prefix.
     * @param node the root of the subtree to search through for the prefix
     * @param prefix the prefix to look for in this Dictionary object.
     * @return true if at least one word with the specified prefix exists
     * in this Dictionary object, false otherwise
     */
    private boolean isPrefixInDictionaryRecursive(Node node, String prefix) {
        return node != null
                && (node.item.toLowerCase().startsWith(prefix)
                // check the left side of the tree
                || isPrefixInDictionaryRecursive(node.left, prefix)
                // check the right side of the tree
                || isPrefixInDictionaryRecursive(node.right, prefix));
    }
}
