import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * FileInput
 * @author Chelsea Valentine
 * Date created: 9/26/2015
 * 
 * Handles the file input
 */
public class FileInput {
    private String mFileName;
    private Scanner mFile = null;

    public FileInput(String inputFileName) {
        mFileName = inputFileName;
        validateInputFile();
    }

    /**
     * Connect to the input file if it exists, and read its contents.
    */
    private void validateInputFile() {
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
     *
     * Precondition: words in file are sorted
     */
    public ArrayList readInputFile() {
        ArrayList<String> lines = new ArrayList<>();

        while (mFile.hasNext()) {
            lines.add(mFile.nextLine());
        }

        mFile.close();
        return lines;
    }
}
