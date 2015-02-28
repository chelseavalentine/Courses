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
		System.out.println("This program takes a word that you input and shift the last letter"
				+ " by a random amount of characters to the right.\n");
		
		//Get user input
		Scanner in = new Scanner ( System.in );
		System.out.print("Please enter the word that you want to shift: ");
		String originalWord = in.next(); 
		
		//Generate the random number of places that you will shift the last letter of the string to the right
		int randomPlaces = (int)Math.ceil(Math.random() * originalWord.length());
		
		//Explicitly print the result to the user
		System.out.println("We shifted the last letter of your word '" + originalWord + "' "
				+ randomPlaces + " places to the right and we ended up the result: "
						+ shift(originalWord, randomPlaces));
		
		in.close();
	}
	
	/**
	 * Shifts the last letter of the word right by a random number of places
	 * @param word
	 * @param placesToShift the random number of places that the last letter will be shifted right
	 * @return the shifted word in string format
	 */
	public static String shift ( String word, int placesToShift ){
		//Convert the string into a char array so we can move things around
		char[] wordCharArray = word.toCharArray();
		
		//Declare a StringBuilder so we can construct our shifted string in it
		StringBuilder shiftedString = new StringBuilder();
		
		//Hold the value of the last character, which is the character that'll get shifted
		char shiftedCharacter = wordCharArray[wordCharArray.length-1];
				
		//Start from the end of the string so you don't overwrite any values
		for (int i = wordCharArray.length-1; i>= placesToShift; i--){
			wordCharArray[i] = wordCharArray[i-1]; //Move a letter 'x' (for instance) to the position after it
		}
		
		//Insert the original last character to it's shifted place
		wordCharArray[placesToShift-1] = shiftedCharacter;
		
		//Iterate through the charArray & add it to the StringBuilder
		for (char c: wordCharArray){
			shiftedString.append(c);
		}
		
		return shiftedString.toString();
	}
}