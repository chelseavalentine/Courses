package netflix;
import java.util.*;

/**
 * @title Netflix Movie Inventory
 * @author Chelsea Valentine
 * @date Tuesday, May 5, 2015
 * @assignment description continued from Movie.java...
 * 
 * INVENTORY: the current inventory in a Netflix distribution center
 * 
 * This class should be based on an ArrayList of Movie objects. Your methods can use the corresponding methods of the ArrayList
 * class.
 * 
 * This class has one private data field:
 * list (ArrayList<Movie>): list of all of the movies
 * 
 * This class needs to provide the following functionalities:
 * 
 * add: has (title, year, duration, rating) as parameters. If the movie matching the title & year doesn't exist in the
 * inventory, then the new movie is created & added to the list. If the movie already exists, then its count should be
 * incremented by 1, and the rating updated to the new one. (Don't worry if the duration matches or not.) This method
 * should catch a possible IllegalArgumentsException thrown by the constructor of the Movie class. If such an exception
 * is thrown, it should be ignored and no movie should be added to the inventory.
 * 
 * toString: returns a multi-line String object containing the list of all the movies in the inventory (use the
 * toString() method of the Movie class)
 */

public class Inventory {	
	private ArrayList<Movie> list;
	
	public Inventory () {
		this.list = new ArrayList<Movie>();
	}
	
	public void add(String title, int year, int duration, double rating) {
		Movie addMovie = new Movie (title, year, duration, rating);
		this.list.add(addMovie);	
	}
	
	public void remove(String title, int year) {
		for (int i = 0; i < this.list.size(); i++) {
			Movie checkThis = this.list.get(i);
			if (checkThis.checkForRemoval(title, year)) {
				//It exists so let's decrement the quantity.
				checkThis.decreaseQuantityBy1();
				
				if (checkThis.getQuantity() == 0) {
					this.list.remove(this.list.get(i));
				}
			}
		}
	}
	
	public String toString() {
		StringBuilder inventoryString = new StringBuilder();
		for (int i = 0; i < this.list.size(); i++) {
			Movie displayThis = this.list.get(i);
			inventoryString.append(displayThis.toString() + "\n");
		}
		return inventoryString.toString();
	}
}
