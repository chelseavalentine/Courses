import java.util.*;

/* @title: Reverse String
 * @author: Chelsea Valentine
 * @date: Tuesday, February 17, 2015
 * 
 * Assignment:
 * 
 * Write a program that prompts the user for a string and then prints out the same string in reverse. You
 * should allow the user to enter spaces in the string. The user hits enter when they're done with the input.
 * You're not allowed to use the method reverse() from the String class. Implement your own method that given
 * a String object as a parameter, returns a String object that is a reverse of the parameter. Your method
 * should have the following signature:
 * 
 * 		public static String reverse ( String textToReverse )
 * 
 * Hint: note the difference b/t next() & nextLine() Scanner methods
 * Note: document your method as we discussed in class
 */

public class ReverseString {
	public static void main (String[] args){
		//Tell user what program does
		System.out.println("This program will give you the reverse of a string that you enter.\n");
		
		//Get user input
		Scanner in = new Scanner(System.in);
		
		System.out.print("Please enter the string that you want to reverse: ");
		String originalString = in.nextLine();
		
		//Give the reversed string back to the user
		System.out.println(reverse(originalString));
		
		in.close();
	}
	
	public static String reverse ( String textToReverse ){
		
		//Create a stringbuilder since they're mutable
		StringBuilder reversedString = new StringBuilder();
		
		//Iterate over the original string backwards to reverse it, adding each character
		//to the stringbuilder
		for (int i = (textToReverse.length()-1); i >= 0; i--){
			String addToReversedString = Character.toString(textToReverse.charAt(i));
			reversedString.append(addToReversedString);
		}
		
		return reversedString.toString();
	}
}
