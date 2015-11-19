import java.util.*;
import java.util.stream.Collectors;

/**
 * Dictionary
 * @author Chelsea Valentine
 * Date created: 9/26/2015
 *
 * A class representing the colslection of words read from the input file.
 * It performs queries in the dictionary.
 */
public class Dictionary implements DictionaryInterface {
    private final ArrayList<String> mWords = new ArrayList<>();

    public Dictionary(ArrayList<String> words) {
        mWords.addAll(words.stream().collect(Collectors.toList()));
    }

    /**
     * Determine whether a given word is in the dictionary.
     *
     * @param word the word to be checked
     * @return whether the word is in the dictionary
     */
    @Override
    public boolean findWord(String word) {
        for (String mWord : mWords) {
            if (word.equals(mWord)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Determine whether a given prefix is a prefix of a word that exists in the dictionary.
     *
     * @param prefix the prefix to be checked
     * @return whether a word in this dictionary has this prefix
     */
    @Override
    public boolean findPrefix(String prefix) {
        for (String mWord : mWords) {
            if (mWord.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }
}
