import java.util.*;

/* @title: Distance of two points
 * @author: Chelsea Valentine
 * @date: Tuesday, February 3, 2015
 * 
 * Assignment:
 * 
 * Write a program that prompts the user to enter the length of the side of a hexagon and computes its area and perimeter.
 * The area of a hexagon with size x can be computed using:
 * 
 * Area = (6x^2)/(4tan(pi/6))
 * 
 * and the perimeter of a hexagon with size x can be computed using:
 * 
 * Perimeter = 6x.
 * 
 * Note 1: You can use Math.tan(a) to compute tan(a)
 * Note 2: There's no exponentiation operator in Java. In order to square a number, you can either multiply it by itself (good solution),
 * or use Math.pow(a, 2) (bad solution)
 */

public class Hexagon {
	public static void main(String[] args) {
		
		//Explain what the program does
		System.out.println("This program will calculate the area and perimeter of a regular hexagon."
				+ "Units are not necessary.\n\n");
		
		//Initialize variables
		double length, area, perimeter;
		
		//Ask user for length of regular hexagon sides
		System.out.print("What is the length of your regular hexagon? ");
		Scanner in = new Scanner (System.in); //ensure that keyboard is available for input
		length = in.nextDouble();
		
		//Compute the area of the hexagon & display it to user
		System.out.println("\nThe area of the hexagon is: " + ((6*length*length)/(4*Math.tan(Math.PI/6))));
		
		//Compute the perimeter of the hexagon & display it to user
		System.out.println("The perimeter of the hexagon is: " + 6*length);
		
		in.close();
	}
}