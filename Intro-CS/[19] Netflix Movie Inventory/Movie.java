package netflix;
import java.util.*;
import java.io.*;

/**
 * @title Netflix Movie Inventory
 * @author Chelsea Valentine
 * @date Tuesday, May 5, 2015
 *  
 * @assignment:
 * 
 * Write a program that keeps track of Netflix's movie inventory. You need to design the following classes:
 *
 * 
 * MOVIE: a single movie offered by Netflix. 
 * 
 * {{assignment description pertaining to inventory is continued in Inventory.java}}
 *
 * 
 * THE PROGRAM: your program should take a single command line parameter. The parameter is the name of the file containing
 * the movie database. The program needs to read in the file and populate the inventory with the movies from the file. The
 * input file contains one movie per line and the information is separated with dashes "-". The fields on each line are:
 * 
 * title - year - duration - rating
 */


public class Movie {
	private String title;
	private int yearReleased;
	private double rating;
	private int quantity;
	private int duration;
	
	
	public static void main (String[] args) {
		// Explain what the program does.
		System.out.println("This program will take in a list of movies as input, and return"
				+ " a clean inventory list.\n");
		
		// Make sure that the user knows how to use the program.
		if (args.length > 0) {
			try {
				// Set up the movie list for input
				Scanner file = new Scanner (new File(args[0]));
				
				// create new inventory
				Inventory movies = new Inventory();
				
				// Feed every line through the program, and create a Movie for each line.
				while (file.hasNext()) {
					String[] entries = file.nextLine().split(" - ");
					String newTitle = entries[0];
					int newYear = Integer.parseInt(entries[1]);
					int newDuration = Integer.parseInt(entries[2]);
					double newRating = Double.parseDouble(entries[3]);
					
					// Add movies to the list of movies.
					try {
						movies.add(newTitle, newYear, newDuration, newRating);
					}
					
					// Explain why their movie wasn't created.
					catch (IllegalArgumentException e) {
						System.out.println("Uh oh. Something went wrong with one of the movies.");
						System.out.println("Make sure that each movie adheres to the following "
								+ "requirements: \n");
						
						System.out.println("The year the movie was released should be between"
								+ " 1870 and 2015.");
						System.out.println("The ratiing should be between 0.0 and 4.0");
						System.out.println("The duration of the movie needs to be a positive integer.");
					}
				}
				
				// Show the inventory list.
				System.out.println(movies.toString());
				
				file.close();
			}
			
			catch (FileNotFoundException e) {
				System.out.println("The 'movies_db.txt' file does not exist, or isn't where"
						+ " the program expected it to be.\n\nPlease put it where your"
						+ " src folder is.");
			}
			
		} else {
			System.out.println("Yo. You need to pass the name of the .txt file as a parameter.");
		}	
	}
	
	
	/** Create a Movie object, that represents a movie we have in stock.
	 * @param title The title of the movie.
	 * @param yearReleased The year the movie was released.
	 * @param duration The length of the movie in minutes.
	 * @param rating The rating of the movie.
	 * @throws IllegalArgumentException If the user tries to make a movie that doesn't fit certain criteria, this exception is thrown.
	 */
	public Movie (String title, int yearReleased, int duration, double rating) throws IllegalArgumentException {
		this.title = title;
		
		// Ensure that the movie was released before 2015 and after 1870.
		if (yearReleased < 1870 | yearReleased > 2015) throw new IllegalArgumentException();
		this.yearReleased = yearReleased;
		
		// Ensure that the rating is between 0.0 and 4.0.
		if (rating < 0.0 | rating > 4.0) throw new IllegalArgumentException();
		this.rating = rating;
		
		// Ensure that the duration is a positive integer.
		if (duration < 0) throw new IllegalArgumentException();
		this.duration = duration;
		
		this.quantity = 1;
	}
	
	
	/**
	 * Increase the quantity of a particular movie by 1.
	 */
	public void increaseQuantityBy1 () {
		this.quantity++;
	}
	
	
	/** 
	 * Decrease the quantity of a particular movie by 1.
	 */
	public void decreaseQuantityBy1 () {
		// Only decrement the quantity if the quantity won't drop below 0
		if (this.quantity > 0) {
			this.quantity--;
		}
	}
	
	
	/** Get the quantity of a particular movie.
	 * @return the amount of a movie that's in stock
	 */
	public int getQuantity() {
		return this.quantity;
	}
	
	
	/** Find whether a movie already exists in our stock, for deletion or addition to inventory purposes.
	 * @param title The title of the movie that we're looking for.
	 * @param year The year that the movie we're looking for was released.
	 * @return Whether the movie matches the comparison parameters.
	 */
	public boolean checkMovie (String title, int year) {
		
		// If the movie does exist, return true
		if (this.title == title && this.yearReleased == year) {
			return true;
		} else {
			// Otherwise, the movie doesn't exist, so return false
			return false;
		}
	}
	
	
	public String toString() {
		String display = String.format("%s (%d), rating: %.1f, # in stock: %d", this.title, this.yearReleased, this.rating, this.quantity);
		return display;
	}
}
