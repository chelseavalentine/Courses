import java.util.*;

/* @title: Matrix
  *@author: Chelsea Valentine
 * @date: Monday, March 9, 2015
 * 
 * Assignment:
 * 
 * Write a program that allows the user to manipulate matrices.
 * 
 * The matrix should have dimensions of at most 5 x 5, and at least 1 x 1.
 * 
 * Give the user options to horizontally/vertically flip the matrix, find the transpose, find the row maxima,
 *  and find the column sums.
 */

public class Matrix {
	public static void main (String args[]){
		//Explain what program does
		System.out.println("This program will take a matrix, of a size that you'll specify, and "
				+ "then manipulate it in several ways.\n");
		
		//Initialize variables
		int rows = 0, cols = 0;
		
		//Get matrix size
		Scanner in = new Scanner(System.in);
		
		boolean pesterUser = false; //Boolean to determine whether to continue asking user for valid input
		do {
			System.out.print("How many rows should the matrix have (integer 1 to 5)? ");
			
			rows = in.nextInt();
			
			//If the input isn't in the interval [1, 5], make the user provide input again.
			if (rows < 1 || rows > 5){
				System.out.println("This integer isn't in the range [1, 5]. Do it again.\n");
				pesterUser = true;
			}
			
			//Otherwise, the input is good, so we can stop bugging the user and continue
			else{
				pesterUser = false;
			}
			
		} while (pesterUser == true);
		
		pesterUser = false; //Reset this to test for valid input of number of columns
		do {
			System.out.print("How many columns should the matrix have (integer 1 to 5)? ");
			cols = in.nextInt();
			
			//If the input isn't in the interval [1, 5], make the user provide input again.
			if (cols < 1 || cols > 5){
				System.out.println("You didn't follow the instructions. Do it again.\n");
				pesterUser = true;
			}
			
			//Otherwise, the input is good, so we can stop bugging the user and continue
			else{
				pesterUser = false;
			}
			
		} while (pesterUser == true);
		
		//Create matrix to hold values
		int [][] original = new int[rows][cols];
		
		//Assign values to the matrix
		for (int i = 0; i < rows ; i++){
			for (int j = 0; j < cols; j++){
				//Generate a random number for each place in the matrix
				int num = (int) Math.floor(Math.random() * 20) - 10;
				original[i][j] = num;
			}
		}
		
		System.out.println("\nYour original matrix:");
		printMatrix(original);
		
		//Ask user what they want to do to their matrix
		char choice = 'x';
		
		//As long as the user hasn't indicated that they want to quit, keep asking them what they want to do
		while (choice != 'Q'){
			System.out.println("\nType the letter corresponding to the way that you want to "
					+ "manipulate your matrix.\n");
			
			System.out.println("H - horizontal flip (reverse each row) \n"
					+ "V - vertical flip (reverse each column)\n"
					+ "T - transpose (rows become columns & vice-versa)\n"
					+ "R - row max (find largest value in each row)\n"
					+ "C - column sum (find the sum of the values in each column)\n"
					+ "Q - quit (terminate the program)\n");
			System.out.print("What's your choice? ");
			
			//the program understands the option regardless of whether the letter is uppercase or lowercase
			choice = in.next().charAt(0);
			choice = Character.toUpperCase(choice);
			
			if (choice == 'H'){
				System.out.println("\nYour matrix once it has been horizontally flipped is");
				printMatrix(horizontalFlip(original));
			}
			if (choice == 'V'){
				System.out.println("\nYour matrix once it has been vertically flipped is");
				printMatrix(verticalFlip(original));
			}
			if (choice == 'T'){
				System.out.println("\nThe transpose of your matrix is");
				printMatrix(transpose(original));
			}
			if (choice == 'R'){
				System.out.println("\nThe maxima of each of the rows are");
				printMatrix(rowMax(original));
			}
			if (choice == 'C'){
				System.out.println("\nThe sums of each of the columns are");
				printMatrix(columnSum(original));
			}
			if (choice != 'H' && choice != 'V' && choice != 'T' && choice != 'R' && choice!= 'C' && choice != 'Q'){
				System.out.println("\n\nSorry, that isn't an option. Try again. \n");
			}
		}
		
		System.out.println("Thanks for manipulating matrices. Come again.");
		in.close();
	}
	
	/** Prints a 1-dimensional matrix
	 * @param matrix a 1-dimensional array, representing a matrix
	 */
	public static void printMatrix(int[] matrix){
		for (int i = 0; i < matrix.length; i++){
			System.out.printf("%5d", matrix[i]);
		}
	}
	
	/** Prints a 2-dimensional matrix
	 * @param matrix a 2-dimensional array, representing a matrix
	 */
	public static void printMatrix (int[][] matrix){
		for (int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix[0].length; j++){
				//Print the values, one row at a time
				System.out.printf("%5d", matrix[i][j]);
			}
			System.out.println(); //Create a break, to indicate next row
		}
	}
	
	/** Flips a matrix horizontally
	 * @param matrix a 2-dimensional array, representing a matrix to be flipped horizontally
	 * @return the original matrix, flipped horizontally
	 */
	public static int [][] horizontalFlip (int [][] matrix){
		int[][] flipped = new int[matrix.length][matrix[0].length];
		
		for (int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix[0].length; j++){
				//Assign the columns of each row to the flipped matrix, in reverse
				flipped[i][j] = matrix[i][(matrix[0].length-1)-j];
			}
		}		
		return flipped;
	}
	
	/** Flips a matrix vertically
	 * @param matrix a 2-dimensional array, representing a matrix to be flipped vertically
	 * @return the original matrix, flipped vertically
	 */
	public static int[][] verticalFlip (int [][] matrix){
		int[][] flipped = new int[matrix.length][matrix[0].length];
		
		for (int i = 0; i < matrix[0].length; i++){
			for (int j = 0; j < matrix.length; j++){
				//Assign the rows of each column to the flipped matrix, in reverse
				flipped[j][i] = matrix[(matrix.length-1)-j][i];
			}
		}
		return flipped;
	}
	
	/** Takes the transpose of a 2-dimensional matrix
	 * @param matrix a 2-dimensional array, representing a matrix, which the transpose will be taken of
	 * @return the transpose of the original matrix
	 */
	public static int [][] transpose (int [][] matrix){
		int[][] transpose = new int[matrix[0].length][matrix.length];
		for (int i = 0; i < matrix[0].length; i++){
			for (int j = 0; j < matrix.length; j++){
				//Switch the rows with the columns & vice-versa
				transpose[i][j] = matrix[j][i];
			}
		}
		return transpose;
	}
	
	/** Finds the maximum of each row of the matrix
	 * @param matrix a 2-dimensional array, representing a matrix
	 * @return a 1-dimensional array of each of the maximums of the matrix's rows
	 */
	public static int [] rowMax (int [][] matrix){
		int[] maxes = new int[matrix.length];
		for (int i = 0; i < matrix.length; i++){
			int max = -10; //assume the maximum is the very lowest that it could be
			for (int j = 0; j < matrix[0].length; j++){
				
				//If a value is greater than the maximum, replace it
				if (matrix[i][j] > max){
					max = matrix[i][j];
				}
			}
			//Now we've found the maximum of that row, so we can add it to the array of row maxima
			maxes[i] = max;
		}
		return maxes;
	}
	
	/** Gives the sum of each of the columns of a matrix
	 * @param matrix a 2-dimensional array, representing a matrix
	 * @return a 1-dimensional array, with each entry being the sum of column of the matrix
	 */
	public static int [] columnSum(int [][] matrix){
		int[] sums = new int[matrix[0].length];
		for (int i = 0; i < matrix[0].length; i++){
			int summed = 0;
			
			//For each column, add all of the entries of that column to the sum
			for (int j = 0; j < matrix.length; j++){
				summed += matrix[j][i];
			}
			
			//Now we've found the sum of all of the column entries, so we can add it to the array of column sums
			sums[i] = summed;
		}
		return sums;
	}
}