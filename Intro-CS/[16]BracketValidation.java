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
 * 		if the stack if empty
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

}
