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
    private static PrintWriter dataPrinter;

    public static void main(String[] args) {
        // Create input and output file names
        mFileName = args[0];
        mOutputFileName = mFileName.substring(0, mFileName.length() - 4); // everything except the extension .txt
        mOutputFileName += ".out"; // add the output extension

        // get file input
        validateInputFile();

        // read the input file and calculate the answer one line at a time
        readInputFileAndCalculate();
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
        } catch (NullPointerException e) {
            System.out.println("You need to specify a file name as a command line argument. Please try again.");
            System.exit(0);
        }
    }

    /**
     * Parse and store the data from the input file.
     */
    private static void readInputFileAndCalculate() {
        String expression, postfix, result;
        openPrintWriter();

        while (mFile.hasNext()) {
            expression = mFile.nextLine();

            // if the line is blank, the expression is invalid.
            if (expression.trim().equals("")) writeToOutputFile("INVALID");

            else {
                try {
                    postfix = ExpressionTools.convertInfixToPostfix(expression);
                    result = ExpressionTools.evaluatePostfix(postfix);
                    writeToOutputFile(result);
                } catch (PostFixException e) {
                    e.printStackTrace();
                }
            }
        }

        mFile.close();
        closePrintWriter();
    }

    private static void openPrintWriter() {
        File outputFile = new File(mOutputFileName);
        try {
            dataPrinter = new PrintWriter(outputFile);
        } catch (FileNotFoundException e) {
            System.out.println("We couldn't find the file or create " + mOutputFileName + " to write to. Terminating.");
            System.exit(0);
        }

    }

    private static void closePrintWriter() {
        dataPrinter.close();
    }
    private static void writeToOutputFile(String answer) {
        dataPrinter.print(answer + "\n");
    }
}
