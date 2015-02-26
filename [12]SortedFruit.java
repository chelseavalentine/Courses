/*
 * @title: Sorting fruit
 * @author: Chelsea Valentine
 * @date: Wednesday, February 25, 2015
 * 
 * Assignment:
 * 
 * Write a method to sort fruits. Pick your favorite algorithm. Start with ArrayOperations.java file
 * from lecture05 notes. Add your own implementation of a sort for strings and use it to sort the
 * mixed fruit. Modify the main() method to display mixedFruit array before and after it is sorted.
 * Your method should modify (i.e. sort) the array that's passed to it. Your method should have the
 * following header:
 * 		public static sort (String [] list)
 * 
 * Hint: remember that the == operator can't be used to compare two strings.
 */

public class SortedFruit {
	public static void main(String[] args){
		//Explain what the program does
		System.out.println("This program takes a preset shuffled array of fruits and sorts the list alphabetically.\n");
		
		//The code below this comment, but before the next comment, was taken from the ArrayOperations.java class notes
		String [] fruits = {"Apple", "Apricot", "Banana", "Bilberry", "Blackberry", "Blackcurrant", 
				"Blueberry", "Coconut", "Currant", "Cherry", "Cherimoya", "Clementine", "Date", "Damson", 
				"Durian", "Elderberry", "Fig", "Feijoa", "Gooseberry", "Grape", "Grapefruit", "Huckleberry", 
				"Jackfruit", "Jambul", "Jujube", "Kiwifruit", "Kumquat", "Lemon", "Lime", "Loquat", "Lychee", "Mango", "Mangostine", 
				"Melon", "Cantaloupe", "Honeydew", "Watermelon", "Rock melon", "Nectarine", "Orange", "Passionfruit", 
				"Peach", "Pear", "Plum", "Prune", "Pineapple", "Pomegranate", "Pomelo", "Raisin", "Raspberry", "Rambutan", 
				"Redcurrant", "Satsuma", "Strawberry", "Tangerine", "Ugli Fruit"};
		
		System.out.println("length of fruits list is " + fruits.length);
		
		String [] mixedFruits = shuffleArray(fruits);
		
		//Display the mixedFruit array before it's sorted
		System.out.println("The mixed (unsorted) fruit array is:\n");
		for (int i = 0; i < mixedFruits.length; i++){
			if (i != mixedFruits.length - 1)
				System.out.print(mixedFruits[i] + ", ");
			else
				System.out.println(mixedFruits[i] + ".");
		}

		//Sort the mixedFruit array
		String [] sortedFruits = sort(mixedFruits);
		
		//Display the mixedFruit array after it's sorted
		for (int i = 0; i < sortedFruits.length; i++){
			if (i != sortedFruits.length - 1)
				System.out.print(sortedFruits[i] + ", ");
			else
				System.out.println(sortedFruits[i] + ".");
		}
	}
	
	/**
	 * Takes a list of strings and sorts them alphabetically
	 * @param list the mixed up list that will be sortedd
	 * @return the sorted list
	 */
	public static String[] sort (String [] list){
		for (int j = 0; j < list.length; j++){
			for (int i = 0; i < list.length - 1; i++){
				//Check to see whether the comparison of the two strings is less than or equal to 0, because
				//if it is, then the string in list[i+1] comes before string list[i]
				if (list[i + 1].compareTo(list[i]) < 0){
					String temp = list[i + 1]; //save list[i + 1] so it doesn't get overwritten
					list [i + 1] = list[i];
					list [i] = temp;
				}
			}
		}
		
		return list;
	}
	
	
	//The all of the code below this comment was copied from class notes lecture05's ArrayOperations.java
	
	/**
	 * Computes and returns a shuffled version of a given list. 
	 * The original list is not modified. 
	 * @param list the array to be shuffled
	 * @return an array containing exactly same elements as the 
	 * parameter array, but in a different (pseudo-random) order
	 */
	public static String [] shuffleArray (String [] list ) {
		String [] mixedList = new String[list.length ];
		
		//make a copy of the parameter array first
		for (int i = 0; i < list.length; i++)
			mixedList[i] = list[i];
		
		//shuffle the entries in the mixedList
		int pos1, pos2;
		for (int i = 0; i < mixedList.length; i++) {
			pos1 = (int) (Math.random()*(mixedList.length) );
			pos2 = (int) (Math.random()*(mixedList.length) );
			swap ( mixedList, pos1, pos2 );
		}
		
		return mixedList;
	}
	
	/**
	 * Swaps values of two elements in an array.
	 * If either pos1 or pos2 is larger than the size of the list,
	 * array is not changed. 
	 * @param list array of strings
	 * @param pos1 position of the first string
	 * @param pos2 position of the second string
	 */
	public static void swap ( String [] list, int pos1, int pos2 ) {
		if (pos1 >= list.length || pos2 >= list.length )
			return;
		String tmp = list[pos1];
		list[pos1] = list[pos2];
		list[pos2] = tmp;
	}
}