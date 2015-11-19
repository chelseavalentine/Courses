/**
 * Dictionary Interface
 * @author Chelsea Valentine
 * Date created: 9/26/2015
 *
 * An interface that defines the methods that a dictionary should possess
 */
public interface DictionaryInterface {
    /**
     * Determine whether a given word is in the dictionary.
     *
     * @param word the word to be checked
     * @return whether the word is in the dictionary
     */
    boolean findWord(String word);

    /**
     * Determine whether a given prefix is a prefix of a word that exists in the dictionary.
     *
     * @param prefix the prefix to be checked
     * @return whether a word in this dictionary has this prefix
     */
    boolean findPrefix(String prefix);
}
