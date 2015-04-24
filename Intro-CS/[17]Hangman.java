import java.util.Scanner;

/**
 * @title Hangman Game (Kind of)
 * @author Chelsea Valentine
 * @date April 24, 2015
 * 
 * @assignment: 
 * 
 * Write a hangman game that randomly generates a word and prompts the user to guess one
 * letter at a time. Each letter in the word is displayed as an asterisk. When the user
 * makes a correct guess, the actual letter is then displayed. When the user finishes a 
 * word, display the number of misses and ask the user whether to continue to play with
 * another word. Declare the array to store words, as follows:
 * 
 * String [] words = { time, person, year, way, day, thing, etc };
 *
 */

public class Hangman {
		public static void main (String[] args) {
			//Tell the user what this program is about
			System.out.println("Welcome to the Hangman game. Try to guess what the woord is,"
					+ "one letter at a time!\n");
			
			//Define the array of words that could be chosen to be used in the game
			String[] words = {"time", "person", "year", "way", "day", "thing", "man", "world",
					"life", "hand", "part", "child", "eye", "woman", "place", "work", "week",
					"case", "point", "government", "company", "number", "group", "problem",
					"fact"};
			
			//Let's allow user input!
			Scanner in = new Scanner(System.in);
			
			//Keep track of whether the user has guessed the word correctly & guess mistakes
			boolean notGuessed = true;
			int misses = 0;
			boolean play = true;
			
			while (play) {
				//This will be the word we use in the game
				String word = chooseWord(words);
				
				//Convert that word into stars!
				StringBuilder stars = new StringBuilder(); 
				for (int i = 0; i < word.length(); i++) {
					stars.append("*");
				}
				
				String stringStars = stars.toString();
								
				//Let's see what it is
				System.out.println(word + " " + stars);
				
				//Need to compare whether the user has guessed correctly, if they haven't,
				//then we want to increment the amount of misses
				String originalStars;
				
				while (notGuessed) {
					System.out.println("(Guess) Enter a letter in word " + stars + " > ");
					
					//Take in the user's guess
					originalStars = stringStars;
					char guess = in.next().charAt(0);
					
					//Set the value of stars to the updated one
					stringStars = correctChoice(stars, guess, word);
					
					//The user made an incorrect guess, so let's increment their misses
					if (originalStars.equals(stars.toString())) {
						misses += 1;
					}
					
					//Let's check whether the user is done
					if (stars.toString().equalsIgnoreCase(word)) {
						notGuessed = false;
					}
				}
				
				//Show the user how well they did
				System.out.println("The word is " + word + ". You missed " + misses + " time(s).\n");
				
				//Check whether the user wants to continue playing
				System.out.println("Do you want to guess another word? Enter y or n > ");
				char response = in.next().charAt(0);
				
				if (response == 'n') {
					play = false;
					System.out.println("\nThanks for playing! Bye bye~");
				}
				
				else {
					notGuessed = true;
					misses = 0;
				}
			}
			
			in.close();
		}
		
		/** Randomly choose a word for the user to guess in the hangman game
		 * @param words The list of words
		 * @return the word the user will guess
		 */
		public static String chooseWord (String[] words) {
			//Choose a random index of the words array
			int position = (int)Math.floor(Math.random() * words.length);
			String word = words[position];
			return word;
		}
		
		
		public static String correctChoice (StringBuilder stars, char guess, String word) {
			
			for (int i = 0; i < word.length(); i++) {
				if (word.charAt(i) == guess) {
					stars.replace(i, i+1, Character.toString(guess));
				}
			}		
			
			return stars.toString();
		}
}
