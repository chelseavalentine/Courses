import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * WordFinder
 * @author Chelsea Valentine
 * Date created: 9/26/2015
 *
 * Finds anagrams using the characters that the user inputs
 */
public class WordFinder {
    private ArrayList<String> mWords;
    private Dictionary mDictionary;
    private DictionaryParser mDictionaryParser;

    private UserInput mUserInput;
    private LetterBag mLetterBag;
    private String mWord;
    private ArrayList<String> mAnagrams;

    public WordFinder(ArrayList<String> words) {
        mWords = words;
    }

    /**
     * initialize the dictionary object
     */
    public void createDictionary() {
        mDictionaryParser = new DictionaryParser(mWords);
        mWords = mDictionaryParser.getWords();

        mDictionary = new Dictionary(mWords);
    }

    /**
     * initalize the letter bag object
     */
    public void createLetterBag() {
        mUserInput = new UserInput();
        mWord = mUserInput.getLowercaseInput();
        mLetterBag = new LetterBag(mWord.toCharArray());
    }

    /**
     * Generates anagrams from the user input
     */
    public void generateAnagrams() {
        mAnagrams = mLetterBag.getAllWords(mDictionary);
        sortAnagramsAlphabetically();
        removeDuplicateAnagrams();
    }

    /**
     * Sort the anagrams in alphabetical order.
     */
    private void sortAnagramsAlphabetically() {
        String temp;

        for (int i = 0; i < mAnagrams.size() - 1; i++) {
            for (int j = i + 1; j < mAnagrams.size(); j++) {
                if (compareWords(mAnagrams.get(i), mAnagrams.get(j)) > 0) {
                    temp = mAnagrams.get(i);
                    mAnagrams.set(i, mAnagrams.get(j));
                    mAnagrams.set(j, temp);
                }
            }
        }
    }

    /**
     * Compare two words to see which one comes earlier, alphabetically
     * @param word1 word to compare word2 against
     * @param word2 word to compare against word1
     * @return {
     *     -1 if word1 comes before word2
     *     0 if words hold the same place alphabetically
     *     1 if word1 comes after word2
     * }
     */
    private int compareWords(String word1, String word2) {
        String shorterWord;
        if (word1.length() < word2.length()) {
            shorterWord = word1;
        } else {
            shorterWord = word2;
        }
        for (int i = 0; i < shorterWord.length(); i++) {
            if (word1.charAt(i) > word2.charAt(i)) {
                return 1;
            } else if (word1.charAt(i) < word2.charAt(i)) {
                return -1;
            }
        }
        return 0;
    }

    /**
     * Get rid of any duplicate anagrams in the list
     */
    private void removeDuplicateAnagrams() {
        mAnagrams = (ArrayList) mAnagrams.stream().distinct().collect(Collectors.toList());
    }

    /**
     * Show the anagrams.
     */
    public void displayAnagrams() {
        for (String anagram : mAnagrams) {
            System.out.println(anagram);
        }
    }
}
