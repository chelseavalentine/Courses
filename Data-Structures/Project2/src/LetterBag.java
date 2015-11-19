import java.util.ArrayList;

/**
 * Letter Bag
 * @author Chelsea Valentine
 * Date created: 9/26/2015
 *
 * A class representing the letters entered by the user.
 * It creates puts together combinations of those letters to create different words, using the Dictionary object.
 */
public class LetterBag implements LetterBagInterface {
    private char[] mLetters;
    private Dictionary mDictionary;
    private ArrayList<String> mAnagrams;

    public LetterBag(char[] letters) {
        mLetters = letters;
    }

    /**
     * Determine the list of words that can be created from a LetterBag object that are present in the
     * provided dictionary
     *
     * @param dict the Dictionary object to be used
     * @return a list of valid words in alphabetical order
     */
    @Override
    public ArrayList<String> getAllWords(Dictionary dict) {
        mDictionary = dict;
        mAnagrams = new ArrayList<>();
        char[] prefix;

        for (int i = 0; i < mLetters.length; i++) {
            prefix = new char[mLetters.length];
            prefix[0] = mLetters[i];
            buildAnagram(prefix, 1);
        }

        return mAnagrams;
    }

    /**
     * Create an anagram from a list of letters.
     *
     * @param prefix the prefix that's being constructed
     * @param position the position in the prefix char array to put the next character in
     */
    private void buildAnagram(char[] prefix, int position) {
        if (position == mLetters.length) {
            String word = String.valueOf(prefix);
            if (mDictionary.findWord(word) && !areTooManyOfALetter(word)) {
                mAnagrams.add(word);
            }
        } else {
            if (mDictionary.findPrefix(String.valueOf(prefix).trim())) {
                for (int i = 0; i < mLetters.length; i++) {
                    char letter = mLetters[i];
                    prefix[position] = letter;
                    buildAnagram(prefix.clone(), position + 1);
                }
            }
        }
    }

    /**
     * Check whether a word has more instances of a character that are in the array of letters
     * @param word the word to check
     * @return whether a word has more instances of a character that are in the array of letters
     */
    private boolean areTooManyOfALetter(String word) {
        int numInWord, numInList;

        for (char c : mLetters) {
            numInList = 0;
            for (int i = 0; i < mLetters.length; i++) {
                if (mLetters[i] == c) {
                    numInList++;
                }
            }

            numInWord = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == c) {
                    numInWord++;
                }
            }

            if (numInWord > numInList) {
                return true;
            }
        }
        return false;
    }
}
