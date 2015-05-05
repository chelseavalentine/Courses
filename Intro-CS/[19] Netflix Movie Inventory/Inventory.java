package netflix;

/**
 * @title Netflix Movie Inventory
 * @author Chelsea Valentine
 * @date Tuesday, May 5, 2015
 * @assignment continued from Movie.java...
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
 * incremented by 1, and the rating updated to the new one. (Don't worry i the duration matches or not.) This method
 * should catch a possible IllegalArgumentsException thrown by the constructor of the Movie class. If such an exception
 * is thrown, it should be ignored and no movie should be added to the inventory.
 * 
 * remove: has (title, year) as parameters. If the movie matching the title & year exist in the inventory, its count
 * should be decreased by 1. If the count of a given movie goes down to 0, it should be completely removed from the
 * inventory. If the movie matching the title & year doesn't exist in the inventory, nothing happens.
 * 
 * toString: returns a multi-line String object containing the list of all the movies in the inventory (use the
 * toString() method of the Movie class)
 * 
 *
 */

public class Inventory {

}
