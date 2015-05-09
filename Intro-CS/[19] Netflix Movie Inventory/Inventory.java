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
	
	/**
	 * Create an Inventory object to hold all of our movies.
	 */
	public Inventory () {
		this.list = new ArrayList<Movie>();
	}
	
	/** Add a movie to the inventory.
	 * @param title The title of the movie.
	 * @param year The year the movie was released.
	 * @param duration The length of the movie in minutes.
	 * @param rating The rating of the movie.
	 */
	public void add(String title, int year, int duration, double rating) {
		try {
			// We first need to see if the movie doesn't exist, because we only want to add
			// a new object if it doesn't already exist
			boolean doesNotExist = true;
			
			// Check through all of the movies to see if it matches the parameters fed in
			// to create a new Movie.
			for (int i = 0; i < this.list.size(); i++) {
				Movie checkThis = this.list.get(i);
				
				if (checkThis.checkMovie(title, year)) {
					//It exists, so let's accurately reflect that
					doesNotExist = false;
					checkThis.increaseQuantityBy1();
				}
			}
			
			// If the movie really doesn't exist, let's go ahead and create our new movie
			// then add it to our inventory.
			if (doesNotExist) {
				Movie addMovie = new Movie (title, year, duration, rating);
				this.list.add(addMovie);
			}
		} catch (IllegalArgumentException e) {}	
	}
	
	
	/** Remove a movie from the inventory.
	 * @param title The title of the movie that we want to remove.
	 * @param year The release year of the movie that we want to remove.
	 */
	public void remove(String title, int year) {
		
		// Check through the movies in our inventory to see if we have a movie with
		// that release year and title
		for (int i = 0; i < this.list.size(); i++) {
			Movie checkThis = this.list.get(i);
			
			if (checkThis.checkMovie(title, year)) {
				// It exists so let's decrement the quantity.
				checkThis.decreaseQuantityBy1();
				
				// If the quantity of the movie is now 0, let's get rid of it all together.
				if (checkThis.getQuantity() == 0) {
					this.list.remove(this.list.get(i));
				}
			}
		}
	}
	
	
	public String toString() {
		// Create a StringBuilder to hold the list of all of the movies in the inventory
		StringBuilder inventoryString = new StringBuilder();
		
		// Add each movie to the movie list one by one
		for (int i = 0; i < this.list.size(); i++) {
			Movie displayThis = this.list.get(i);
			inventoryString.append(displayThis.toString() + "\n");
		}
		
		return inventoryString.toString();
	}
}
