import java.util.*;

/* @title: Interesting sequence
 * @author: Chelsea Valentine
 * @date: February 8, 2015
 * 
 * Assignment:
 * 
 * Write a program that reads as input from the user a single positive integer, call it n, and then uses n
 * to compute the next number in the sequence as follows:
 * 
 * [*] if n is even, the next number n is divided by 2 (integer division)
 * [*] if n is odd, the next number is n multiplied by 3 plus 1
 * 
 * The next number is computed based on the previous value and so on... For example, if n starts at 11, the
 * sequence is 11, 34, 17, 52, 26, 13, 40, 20, 10, ...
 * 
 * This algorithm produces an infinite sequence of numbers. Compute the first hundred terms of the sequence
 * and print the numbers using standard output. The numbers should be separated by a comma and a single space.
 * Run your program several times using different input numbers. What do you notice about the sequences? (Answer
 * this question in the comments below the code in your program.)
 * 
 * Note: provide user interface that prompts the user for the input.
 */

public class Sequence {
	public static void main(String[] args){
		
		//Explain what the program does
		System.out.println("This program will create a sequence out of a single number that you provide, and then "
				+ "give you the first 100 terms of the sequence.\n");
		
		//Establish variables and lists
		List <Integer> sequence = new ArrayList<Integer>();
		int currentTerm = 0;
		
		//Get user's input
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter a single number that'll be the initial number in the sequence: ");
		int n = in.nextInt();
		sequence.add(n);
		currentTerm = n;
		
		//Get the first 100 terms and add it to the list
		for (int i = 0; i<100; i++){
			
			//If the term is even, do this
			if (currentTerm%2 == 0){
				currentTerm /= 2;
			}
			//If it's odd, do this instead
			if (currentTerm%2 != 0){
				currentTerm = (currentTerm *3) + 1;
			}
			sequence.add(currentTerm);
		}
			
		//Iterate through the list & print the sequence
		System.out.print("The first 100 terms of your sequence are: ");
		for (int j = 0; j < 100; j++){
			if (j != 99){
				System.out.print(sequence.get(j) + ", ");
			}
			else{
				System.out.print(sequence.get(j) +".");
			}			
		}
		
		in.close();
	}
}

/* After running the program several times with different initial terms, I've noticed that the sequences 
 * eventually end up just alternating between 1-3 numbers.
 */