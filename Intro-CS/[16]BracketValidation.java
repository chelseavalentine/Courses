package hw8;

/**
 * @title Expression Validation
 * @author Chelsea Valentine
 * @date April 24, 2015
 *
 * @assignment:
 * 
 * Write a program that uses the StackOfCharacters class (discussed in class) to validate
 * mathematical expressions.
 * 
 * Your program should read in the mathematical expression as its command line argument.
 * It should determine that if the mathematical expression is valid (based on matching
 * parentheses) and print VALID or INVALID to the screen, accordingly.
 * 
 * The algorithm for validation:
 * 
 * for each character in the input string (the mathematical expression)
 * 	if the character is an opening bracket
 * 		push it on the stack
 * 	if the character is a closing bracket
 * 		if the stack is empty
 * 			return invalid
 * 		if the top of the stack is an opening bracket
 * 			pop it
 * 	if the stack is empty
 * 		return true
 * 	otherwise
 * 		return false
 * 
 * 
 * Assumptions:
 * 	You can assume that the mathematical expression provided in the command line argument
 * does not contain any spaces (only digits, mathematical operations, & parentheses)
 * 
 */

public class BracketValidator {
	public static void main (String[] args) {
		
		System.out.println("This program will take in a mathematical expression through the "
				+ "command line, and then tell you whether it is valid.\n\n");
		//Create our stack using the StackOfCharacters object
		StackOfCharacters stack = new StackOfCharacters();

		//Keep track of whether the mathematical expression is valid or invalid
		boolean validity = true;
		
		//cycle through all of the characters in the input string
		for (int i = 0; i < args[0].length(); i++) {
			
			
			//If the character is an opening bracket, push it on the stack
			if (args[0].charAt(i) == '(') {				
				stack.push(args[0].charAt(i));
			}
			
			//if the character is a closing bracket, do this stuff
			if (args[0].charAt(i) == ')') {
				
				//if the stack is empty, the equation is INVALID
				if (stack.empty()) {
					validity = false;
				}
				
				//if the top of the stack is an opening bracket, pop it off the top
				if (stack.peek() == '(') {
					stack.pop();
				}
			}
		}
		
		//if the stack is empty, the expression is VALID
		if (stack.empty()) {
			validity = true;
		}
		
		//if the stack isn't empty, the expression is INVALID
		else {
			validity = false;
		}
		
		//Display the validity of the math expression
		if (validity) {
			System.out.println("VALID");
		}
		else {
			System.out.println("INVALID");
		}
	}

}
