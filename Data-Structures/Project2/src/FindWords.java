import java.util.ArrayList;
import java.util.Scanner;

/**
 * Find Words
 * @author Chelsea Valentine
 * Date created: 9/26/2015
 *
 * Is the main program from which everything else is called.
 *
 */
public class FindWords {
    private static FileInput mFileInput;

    public static void main(String[] args) {
        validateArguments(args);
        runAnagramFindingProgram();
    }

    /**
     * Validate the number of command line arguments.
     * @param args command line arguments
     */
    private static void validateArguments(String[] args) {

        // If the user doesn't provide an argument, tell them the requirements and end the program.
        if (args.length != 1) {
            System.out.println("This program requires that you provide the input file name. For instance:");
            System.out.println("java FindWords input.txt\n");
            System.out.println("Please try again.");
            System.exit(0);
        }

        mFileInput = new FileInput(args[0]);
    }

    /**
     * Start program that finds anagrams
     */
    private static void runAnagramFindingProgram() {
        WordFinder mWordFinder;

        mWordFinder = new WordFinder(mFileInput.readInputFile());
        mWordFinder.createDictionary();
        mWordFinder.createLetterBag();
        mWordFinder.generateAnagrams();
        mWordFinder.displayAnagrams();
    }
}
