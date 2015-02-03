/* @title: Approximating Pi
 * @author: Chelsea Valentine
 * 
 * @date: Tuesday, Feb 3, 2015
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
		
		//Define variables
		double denominator = 1;
		double sign = 1; //Variable to control whether the fraction is positive or negative
		double answer1, answer2, answer3;
		answer1 = answer2 = answer3 = 0;

		//Calculate the answer to the first question: 4 x (1 - 1/3 + 1/5 - 1/7 + 1/9 - 1/11)
		System.out.print("The answer to 4 x (1 - 1/3 + 1/5 - 1/7 + 1/9 - 1/11) is: ");
		
		//add a fraction to the total (answer1), incrementing the denominator by 2 each time
		for(double i=1; i<12; i+=2){ 
			answer1 += (1/i)*sign; 
			sign *= -1;
		}
		
		answer1 *= 4;
		System.out.println(answer1);

		//Calculate the answer to the second question: 4 x (1 - 1/3 + 1/5 - 1/7 + 1/9 - 1/11)
		System.out.print("The answer to 4 x (1 - 1/3 + 1/5 - 1/7 + 1/9 - 1/11 + 1/13) is: ");
		
		//add a fraction to the total (answer2), incrementing the denominator by 2 each time
		for(double i=1; i<14; i+=2){
			answer2 += (1/i)*sign;
			sign *= -1;
		}
		
		answer2 *= 4;
		System.out.println(answer2);
		
		sign = 1; //Reset sign to 1, because it was -1 before.
		
		//Calculate the answer to the extra credit portion
		System.out.print("The answer to an expression using the first 1,000 terms of the above summation, rather than 6 or 7, is: ");
		
		//add a fraction to the total (answer3), incrementing the denominator by 2 each time
		for (double i=1; i<1001; i++){ //This allows us to find the sum of the first 1000 terms
			answer3 += (1/denominator) * sign;
			denominator += 2;
			sign *= -1;
		}
		
		answer3 *= 4;
		System.out.println(answer3);
	}
}
