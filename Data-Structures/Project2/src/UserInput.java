import java.util.Scanner;

/**
 * UserInput
 * @author Chelsea Valentine
 * Date created: 9/26/2015
 *
 * Handles user input.
 */
public class UserInput {
    private String mUserInput;

    public UserInput() {
        requestUserInput();
    }

    /**
     * Ask for user input
     */
    private void requestUserInput() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter letters to find anagrams of: ");
        validateInput(in.next());
    }

    /**
     * Check whether the user input consists only of characters
     * @param userInput what the user entered
     */
    private void validateInput(String userInput) {;
        char[] characters = userInput.toCharArray();
        boolean isSpaceChar, isNotLetter;

        for (char character : characters) {
            isSpaceChar = Character.isSpaceChar(character);
            isNotLetter = !Character.isLetter(character);

            if (isSpaceChar || isNotLetter) {
                terminateProgram();
            }
        }

        mUserInput = userInput;
    }

    /**
     * End the program.
     */
    private void terminateProgram() {
        System.out.print("Error: What you entered included characters that were" +
                " not letters. Consequently, the program will end.");
        System.exit(0);
    }

    public String getLowercaseInput() {
        return mUserInput.toLowerCase();
    }
}
