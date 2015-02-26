import java.util.*;

/*
 * @title: Is it sorted?
 * @author: Chelsea Valentine
 * @date: Wednesday, February 25, 2015
 * 
 * Assignment:
 * 
 * Write a program that prompts the user to enter a list of 10 integers. Your program should save
 * the numbers to an array & then verify if the list is sorted or not. If the numbers are sorted,
 * your program should print the message "Your list is sorted" to the console. If not, "Your list
 * is NOT sorted".
 * 
 * Note 1: You must have a method that given a list of numbers, determines if they're sorted
 * Note 2: You should be able to only make 1 pass through the array to determine if the content
 * is sorted or not -- plan your solution before implementing the program.
 */

public class IsSorted {
	public static void main(String[] args){
		//Explain what the program does
		System.out.println("This program will accept a list of 10 integers and tell you whether they are sorted from"
				+ " least to greatest.\n");
		
		//Get the user to enter a list of 10 integers
		int [] list = new int [10];
		Scanner in = new Scanner(System.in);
		enterIntegerList(list, in);
		
		//Check whether the list is sorted by comparing adjacent elements
		isSorted(list);
		
		in.close();
	}
	
	/** 
	 * Tells you whether the list you input has its integers sorted from least to greatest
	 * @param list the list to check for least to greatest ordering
	 */
	public static void isSorted (int [] list){
		boolean stillSorted = true; //Keep track of whether the list is sorted
		
		//Compare adjacent elements to check whether the list is sorted
		for (int i = 0; i < (list.length - 1); i++){
			if (list[i] <= list[i+1]){
				continue;
			}
			else{
				stillSorted = false;
				System.out.println("Your list is NOT sorted.\n");
				break;
			}
		}
		
		if (stillSorted == true){
			System.out.println("Your list is sorted.\n");
		}
	}
	
	/** 
	 * Get the user to fill up a list with integer values
	 * @param list the list that needs to be filled in with integers
	 * @param in the name of the variable that accepts input from the keyboard
	 * @return the list with all of the spaces in the list filled in
	 */
	public static int[] enterIntegerList (int [] list, Scanner in){
		//Iterate through the loop, asking for an input for every space in the list.
		for (int i = 0; i < list.length; i++){
			System.out.print("Please enter an integer: ");
			list[i] = in.nextInt();
		}
				
		return list;
	}
}