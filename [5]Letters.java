import java.util.*;

/* @title: Vowel or consonant?
 * @author: Chelsea Valentine
 * @date: February 8, 2015
 * 
 * Assignment:
 * 
 * Write a program that prompts the user to enter a single character from the keyboard and then checks if
 * it is a letter, and if so, determines if it is a consonant or a vowel.
 * 
 * Note 1: You should read chapter 4 before attempting this problem.
 * Note 2: Think the problem through. The task of determining if the letter is a consonant or a vowel can 
 * be solved in many ways: some of them take much longer to implement (try to find a short way)
 */

public class Letters {
	public static void main(String[] args){

		//Explain what this program does
		System.out.println("This program will prompt you to enter a letter, and then will tell you whether the "
				+ "letter you enter is a vowel or a consonant.\n");
		
		//Ask the user for input
		Scanner in = new Scanner (System.in);
		System.out.print("Please enter a letter: ");
		
		//Select the first character entered to be used as the character we check for vowel/consonant membership
		char letter = in.next().charAt(0);
		
		//Make sure the input is lowercase
		letter = Character.toLowerCase(letter);
		
		//Determine whether the input is a letter
		if (Character.isLetter(letter) == true){
			
			//Determine whether the input is a consonant or vowel
			if (letter == 'a' | letter == 'e' | letter == 'i' | letter == 'o' | letter == 'u'){
				System.out.println("The letter is a vowel.");
			}
			else{
				System.out.println("The letter is a consonant.");
			}
		}
		
		else{
			System.out.println("This is not a letter. The program will end now.");
		}

		in.close();
	}
}