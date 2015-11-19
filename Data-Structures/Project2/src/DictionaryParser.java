import java.util.ArrayList;
import java.util.List;

/**
 * Dictionary Parser
 * @author Chelsea Valentine
 * Date created: 9/26/2015
 *
 * Parses the dictionary for lines that don't include words & removes them
 */
public class DictionaryParser {
    ArrayList<String> mWords;

    public DictionaryParser(ArrayList<String> words) {
        mWords = words;
        parseFile();
    }

    /**
     * Removes words that are just spaces or blank lines
     */
    private void parseFile() {
        for (String word : mWords) {
            if (word.equals(" ") || word.equals("")) {
                mWords.remove(word);
            }
        }
    }

    public ArrayList<String> getWords() {
        return mWords;
    }
}
