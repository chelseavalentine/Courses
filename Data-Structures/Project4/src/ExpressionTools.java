import java.util.Scanner;

/**
 * ExpressionTools
 * @author Chelsea
 * @since 11/3/2015
 *
 * The class that provides methods for infix to postfix conversion and for
 * postfix evaluation. The class only provides tools (so you shouldn't be able
 * to create instances of the class, and all methods should be static)
 */
public class ExpressionTools {
    private ExpressionTools() {}

    /**
     * 
     * @throws PostFixException
     */
    public static void convertInfixToPostfix(String expression) throws PostFixException {
        MyStack<Integer> operandStack = new MyStack<Integer>();
        MyStack<String> operatorStack = new MyStack<String>();

        // Create a scanner to look through the equation
        Scanner expressionReader = new Scanner(expression);
        StringBuilder postfix = new StringBuilder();
        String token;
        int operand;

        // for each token in the input infix expression
        while (expressionReader.hasNext()) {
            token = expressionReader.next();

            // check whether the token is one of the operators
            // if it is, add it to the operator stack
            if(token.equals("*") || token.equals("/") || token.equals("+") || token.equals("-"))
                operatorStack.push(token);

            // if the token is a left brace
            else if(token.equals("("))
                operatorStack.push(token);

            // if the token is a right brace
            else if(token.equals("(")) {
                // while the operator stack isn't empty
                while (!operatorStack.empty()) {
                    // if the top of the operator stack isn't a matching left brace
                    if(false) {
                        // pop the operator stack and append to the postfix string expression
                    }
                    // else
                    else {
                        // pop the left brace and discard
                        break;
                    }
                }
                operatorStack.push(token);
            }
            // the token isn't an operator, nor a brace, then it's either an integer--which we
            // want--or a letter, which we don't want
            else {
                for (int i = 0; i < token.length(); i++) {
                    char character = token.charAt(i);
                    // If the character is a digit, or the character is the first character & a negative or positive
                    // sign, then do nothing
                    if (Character.isDigit(character) || ((character == '-' || character == '+') && i == 0));
                    // Else, we don't have an integer and we have an invalid expression
                    else break;
                    // TODO: print invalid
                }

                // Parse the integer to add to our stack
                operand = Integer.parseInt(token);
                operandStack.push(operand);
            }

               // append to postfix string expression
            // else if the token is a left brace
                // push it onto the operator stack
            // else if the token is an operator
                // if the operator stack is not empty
                    // while the top element on the stack has precedence higher or equal
                        // pop the stack and append to postfix string expression
                // push it (the current operator) onto the operator stack
            // else if the token is a right brace
                // while the operator stack is not empty
                    //if the top of the operator stack is not a matching left brace
                        // pop the operator stack and append to postfix string expression
                    // else
                        // pop the left brace and discard
                        // break
            // while the operator stack is not empty
                // pop the operator stack and append it to the postfix string operation
        }
    }

    public static void evaluatePostfix() {
        // scan the given postfix expression from left to right
        // for each token in the input postfix expression
            // if the token is an operand
                // push it (its value) onto a stack
            // else if the token is an operator
                // operand2 = pop stack
                // operand1 = popstack
                // compute operand1 operator operand2
                // push result onto stack
        // return top of the stack as a result
    }
}
