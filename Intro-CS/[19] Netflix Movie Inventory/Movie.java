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
 * Write a program that keeps track of "Netflix"'s movie inventory. You need to design the following classes:
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
		if (args.length > 0) {
			try {
				Scanner file = new Scanner (new File(args[0]));
				
				//create new inventory
				Inventory movies = new Inventory();
				
				while (file.hasNext()) {
					String[] entries = file.nextLine().split(" - ");
					String newTitle = entries[0];
					int newYear = Integer.parseInt(entries[1]);
					int newDuration = Integer.parseInt(entries[2]);
					double newRating = Double.parseDouble(entries[3]);
					
					try {
						movies.add(newTitle, newYear, newDuration, newRating);
					}
					
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
	
	public Movie (String title, int yearReleased, int duration, double rating) throws IllegalArgumentException {
		this.title = title;
		
		if (yearReleased < 1870 | yearReleased > 2015) throw new IllegalArgumentException();
		this.yearReleased = yearReleased;
		
		this.rating = rating;
		if (rating < 0.0 | rating > 4.0) throw new IllegalArgumentException();
		
		this.duration = duration;
		if (duration < 0) throw new IllegalArgumentException();
		
		this.quantity = 1;
	}
	
	
	public void increaseQuantityBy1 () {
		this.quantity++;
	}
	
	public void decreaseQuantityBy1 () {
		//Only decrement the quantity if the quantity won't drop below 0
		if (this.quantity > 0) {
			this.quantity--;
		}
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public boolean checkForRemoval (String title, int year) {
		if (this.title == title && this.yearReleased == year) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		String display = String.format("%s (%d), rating: %.1f, # in stock: %d", this.title, this.yearReleased, this.rating, this.quantity);
		return display;
	}
}
