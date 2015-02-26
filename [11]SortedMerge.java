import java.util.*;

/*
 * @title: Merge two lists
 * @author: Chelsea Valentine
 * @date: Wednesday, February 25, 2015
 * 
 * Assignment:
 * 
 * Write a program that merges two lists of sorted whole numbers entered by the user. The program
 * should use merge method with the following header:
 * 		public static int [] merge (int [] list1, int [] list2)
 * 
 * The list returned by the method should contain all elements of the sorted list1 and sorted list2.
 * The list returned by the method should be sorted. Your implementation should be as efficient as
 * possible. Use the isSorted() method (that you developed in problem 1) to verify that both lists are
 * sorted from smallest to largest & that your merged list is sorted.
 * 
 * Your program should ask the user for the length of each list and then read in the content of the
 * two lists. Your program should print to the console the content of the merged list (numbers
 * should be separated by commas and spaces).
 * 
 * Hint: Don't copy the 2 lists into a new array and sort the whole array. Take advantage of the
 * fact that both list1 and list2 are in sorted order.
 * 
 * Note: Don't use Arrays or ArrayList classes.
 */

public class SortedMerge {
	public static void main(String[] args){
		//Explain what the program does
		System.out.println("This program will have you input two sorted lists of integers and "
				+ "merge them together in order.\n");
		
		//Ask the user for the lengths of the lists
		int length1, length2;
		Scanner in = new Scanner (System.in);
		
		System.out.print("How many integers will your first list have? ");

		length1 = in.nextInt();
		
		System.out.print("\nHow many integers will your second list have? ");
		length2 = in.nextInt();
		
		//Create the two lists that'll be filled by the user.
		int [] list1 = new int [length1];
		int [] list2 = new int [length2];
		
		//Get the user to enter the integers for the first list
		System.out.println("First we're going to fill up the first list of integers. \n");
		enterList(list1);
		isSorted(list1);
		
		//Get the user to enter the integers for the second list
		System.out.println("Now we'll fill up the second list of integers. \n");
		enterList(list2);
		isSorted(list2);
		
		//Merge the lists
		merge(list1, list2);
		
		in.close();
	}
	
	/**
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static int [] merge (int [] list1, int [] list2){
		int mergedListLength = list1.length + list2.length;
		int [] mergedList = new int [mergedListLength];
		
		for (int i = 0; i < mergedListLength; i++ ){
			for (int j = 0; j < list1.length; j++){
				
			}
			if ()
		}
		return mergedList;
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
				System.out.println("Your list is NOT sorted.");
				break;
			}
		}
		
		if (stillSorted == true){
			System.out.println("Your list is sorted.");
		}
	}
	
	/** 
	 * Get the user to fill up a list with integer values
	 * @param list the list that needs to be filled in with integers
	 * @return the list with all of the spaces in the list filled in
	 */
	public static int[] enterList (int [] list){
		Scanner in = new Scanner(System.in);
		
		//Iterate through the loop, asking for an input for every space in the list.
		for (int i = 0; i < list.length; i++){
			System.out.print("Please enter an integer: ");
			list[i] = in.nextInt();
		}
		
		in.close();
		return list;
	}
}