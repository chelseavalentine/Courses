import java.util.*;

/* @title: Shifting Strings
 * @author: Chelsea Valentine
 * @date: Tuesday, February 17, 2015
 * 
 * Assignment:
 * 
 * Write a program that prompts the user for a string and then prints out the same string shifted by one
 * character to the right. The last character should become the first one after the shift. You should use
 * toCharArray() method from the String class to convert the String that you read from the user to individual
 * characters. The array of characters should then be shifted by one character to the right. For example:
 * 
 * If the user enters "Hello", you shift the string to "oHell"
 * 
 * Once the shift is done, the character array should be converted back to string and displayed to the user.
 * 
 * The  shift operation should be performed by a method with the following header:
 *			public static String shift ( String word )
 *
 * Hint: given a char array called letters, you can convert it to a string using the following syntax:
 *
 *		String shiftedWord = new String (letters);
 *
 * Extra credit: Implement a second method that shifts a string by an arbitrary number of letters. The number
 * should be provided as a parameter to the method:
 * 		public static String shift ( String word, int numberToShift )
 */

public class ShiftString {
	public static void main (String[] args){
		//Explain what this program does
		System.out.println("This program takes a word that you input and shift a letter"
				+ "by a random amount of characters to the right.");
		
		//Get user input
		Scanner in = new Scanner ( System.in );
		System.out.print("Please enter the word that you want to shift: ");
		String originalWord = in.next(); 
		
		//Generate the random number of places that you will shift the last letter of the string to the right
		int randomPlaces = (int)Math.floor(Math.random() * originalWord.length());
		System.out.println(randomPlaces);
		shift(originalWord, randomPlaces);
		in.close();
	}
	
	public static String shift ( String word, int placesToShift ){
		String shiftedString = "yo";
		return shiftedString;
	}
}
