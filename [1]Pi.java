import java.util.*;

/* @title: Approximating Pi
 * @author: Chelsea Valentine
 * 
 * Assignment:
 * 
 * The value of Pi can be approximated using the following formula:
 * Pi is approximately equal to 4 * (1 - 1/3 + 1/5 - 1/7 + 1/9 - 1/11 + ... ).
 * 
 * Write a program that computes and displays the result of 4 * (1 - 1/3 + 1/5 - 1/7 + 1/9 - 1/11) &
 *  4 * (1 - 1/3 + 1/5 - 1/7 + 1/9 - 1/11 + 1/13). How good approximations are those?
 *  
 *  Extra credit: Compute a third value that uses the first 1000 terms of the above summation (instead of 6 and 7 terms above).
 *  
 *  Note: you should be using 1.0 instead of 1 in your program in all of the above computations. Why?
 */

public class Pi {
	public static void main(String[] args) {
		
		//Calculate the answer to the first question: 4 x (1 - 1/3 + 1/5 - 1/7 + 1/9 - 1/11)
		System.out.print("The answer to 4 x (1 - 1/3 + 1/5 - 1/7 + 1/9 - 1/11) is: \n\n");
		
		//Calculate the answer to the second question: 4 x (1 - 1/3 + 1/5 - 1/7 + 1/9 - 1/11)
		System.out.print("The answer to 4 x (1 - 1/3 + 1/5 - 1/7 + 1/9 - 1/11 + 1/13) is:  \n\n");
		
		//Calculate the answer to the extra credit portion
		System.out.print("The answer to an expression using the first 1,000 terms of the above summation, rather than 6 or 7, is: \n\n");
	}
}
