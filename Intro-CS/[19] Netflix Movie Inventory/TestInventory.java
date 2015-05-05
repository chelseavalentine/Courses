package netflix;

/**
 * @title: the test program for the two classes;
 * REMEMBER TO COMPLETE THE PART WHERE THE INPUT FILE IS READ
 */

public class TestInventory {
	public static void main (String[] args) {
		Inventory movieList = new Inventory();
		
		//TO-DO:
		//Read in the input file and populate the movieList
		
		movieList.add("Bears", 2014, 78, 3.5);
		movieList.add("Star  Wars − A New Hope", 1977, 121, 3.8);
		movieList.add("Casablanca", 1942, 102, 3.9);
		movieList.add("Duck Soup", 1933, 68, 3.75);
		
		System.out.println(movieList.toString());
		
		movieList.add("Casablanca", 1942, 102, 3.9);
		
		System.out.println(movieList.toString());
		
		movieList.add("Bears", 2050, 78, 3.5);
		
		System.out.println(movieList.toString());
		
		movieList.remove("The Nightmare Before Christmas", 1993);
		
		System.out.println(movieList.toString());
		
		movieList.remove("Duck Soup", 1933);
		
		System.out.println(movieList.toString());
	}
}
