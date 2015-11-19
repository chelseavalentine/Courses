import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Calculator
 * @author Chelsea Valentine
 * @since 11/3/2015
 *
 * Main class. Is responsible for input and output operations (the input file is
 * read by this class, & the class writes to the output file)
 */
public class Calculator {
    // I/O
    private static String mFileName;
    private static Scanner mFile = null;
    private static String mOutputFileName;

    // Computations

    public static void main(String[] args) {
        // get file input
        validateInputFile();

        // start program
        //TODO: change this method name and all of the in-between
        runProgram();

        // write to output file
    }

    /**
     * Connect to the input file if it exists, and read its contents.
     */
    private static void validateInputFile() {
        try {
            mFile = new Scanner(new File(mFileName));
        } catch (FileNotFoundException e) {
            System.out.println("The system tried to open " + mFileName + ", but it was nowhere to be found. Please check" +
                    " that you're specifying the right input file.");
            System.exit(0);
        }
    }

    /**
     * Parse and store the data from the input file.
     */
    private static ArrayList<String> readInputFile() {
        ArrayList<String> lines = new ArrayList<>();
        String equation;

        while (mFile.hasNext()) {
            equation = mFile.nextLine();
            try {
                ExpressionTools.convertInfixToPostfix(equation);
            } catch (PostFixException e) {
                System.out.println("Your expression was invalid!");
            }

            lines.add(mFile.nextLine());
        }

        mFile.close();
        return lines;
    }

    private static void runProgram() {


        //TODO: replace w/ actual answer
        writeToOutputFile(new String());
    }

    private static void writeToOutputFile(String answer) {
        File outputFile = new File(mOutputFileName);
        PrintWriter dataConclusions = null;

        try {
            dataConclusions = new PrintWriter(outputFile);
            dataConclusions.print(answer);
        } catch (FileNotFoundException e) {
            System.out.println("We couldn't find the file or create " + mOutputFileName + " to write to. Terminating.");
            System.exit(0);
        }

        dataConclusions.close();
    }
}
