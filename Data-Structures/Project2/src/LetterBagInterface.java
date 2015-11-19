import java.util.ArrayList;

/**
 * Letter Bag Interface
 * @author Chelsea Valentine
 * Date created: 9/26/2015
 *
 * An interface that defines the methods a letter bag should possess
 */
public interface LetterBagInterface {
    /**
     * Determine the list of words that can be created from a LetterBag object that are present in the
     * provided dictionary
     *
     * @param dict the Dictionary object to be used
     * @return a list of valid words in alphabetical order
     */
    ArrayList<String> getAllWords(Dictionary dict);
}
