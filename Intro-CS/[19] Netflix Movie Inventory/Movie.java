package netflix;

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
 * 
 * MOVIE: a single movie offered by Netflix. Has the following data fields:
 * - title (String): title of the movie
 * - yearReleased (int): year that the movie was released (and a positive integer between 1870 and 2015)
 * - rating (double): user rating (any positive floating number between 0.0 and 4.0)
 * - quantity (int): number of discs at the distribution center (a positive integer)
 * - duration (int): duration of the movie in minutes (a positive integer)
 * 
 * The class provides one constructor that takes 4 parameters (title, yearReleased, duration, rating) and sets
 * the quantity to 1;
 * 
 * The constructor should verify the parameters provided and throw an IllegalArgumentEception exception if any
 * of the parameters are invalid.
 * 
 * The class needs to provide a way of modifying the quantity data field. The quantity should never fall below 0.
 * 
 * The class should provide a .toString() method that returns a String object in the following format:
 * 
 * TITLE (YEAR_RELEASED), rating: RATING, # in stock: QUANTITY
 * 
 * in which all the uppercase words are replaced by values of the corresponding data fields. Using the String.format(...)
 * method to format the string.
 * 
 * The class doesn't need any other getters & setters (but some of them may be useful). All data fields have to be private.
 * 
 * 
 * {{assignment description pertaining to inventory is continued in Inventory.java}}
 *
 * 
 * 
 * THE PROGRAM: your program should take a single command line parameter. The parameter is the name of the file containing
 * the movie database. The program needs to read in the file and populate the inventory with the movies from the file. The
 * input file contains one movie per line and the information is separated with dashes "-". The filds on each line are:
 * 
 * title - year - duration - rating
 */

public class Movie {

}
