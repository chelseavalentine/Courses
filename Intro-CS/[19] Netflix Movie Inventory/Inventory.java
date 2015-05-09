package netflix;
import java.util.*;

/**
 * @title Netflix Movie Inventory
 * @author Chelsea Valentine
 * @date Tuesday, May 5, 2015
 * @assignment description continued from Movie.java file...
 * 
 * INVENTORY: the current inventory in a Netflix distribution center
 * 
 * This class should be based on an ArrayList of Movie objects.
 */

public class Inventory {	
	private ArrayList<Movie> list;
	
	public Inventory () {
		this.list = new ArrayList<Movie>();
	}
	
	public void add(String title, int year, int duration, double rating) {
		try {
			boolean doesNotExist = true;
			for (int i = 0; i < this.list.size(); i++) {
				Movie checkThis = this.list.get(i);
				if (checkThis.checkForRemoval(title, year)) {
					//It exists, so let's accurately reflect that
					doesNotExist = false;
					checkThis.increaseQuantityBy1();
				}
			}
			
			if (doesNotExist) {
				Movie addMovie = new Movie (title, year, duration, rating);
				this.list.add(addMovie);
			}
		} catch (IllegalArgumentException e) {}
		
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
