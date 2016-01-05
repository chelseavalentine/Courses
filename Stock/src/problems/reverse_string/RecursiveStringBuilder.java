package problems.reverse_string;

import java.util.Scanner;

/**
 * Reversing a string using a string builder and recursion
 * Created by chelsea on 12/19/15.
 */
public class RecursiveStringBuilder {
    public static void main(String[] args) {
        String input;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a phrase or word you want reversed: ");
        input = in.nextLine();
        System.out.println(reverseString(input));
    }

    private static String reverseString(String string) {
        if (string == null) return null;
        return reverseString(new StringBuilder(), string, string.length() - 1).toString();
    }

    private static StringBuilder reverseString(StringBuilder builder, String string, int pos) {
        if (pos < 0) {
            return builder;
        }
        builder.append(string.charAt(pos));
        return reverseString(builder, string, --pos);
    }
}
