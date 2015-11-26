import java.util.Scanner;
import java.util.Stack;

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
     * Converts an infix expression, such as 23 - 2 * 5 to
     * @throws PostFixException
     */
    public static String convertInfixToPostfix(String infix) throws PostFixException {
        Stack<Character> operatorStack = new Stack<>();

        // Create a scanner to look through the infix expression
        Scanner expressionReader = new Scanner(infix);
        StringBuilder postfix = new StringBuilder();
        String token;

        // for each token in the input infix expression
        while (expressionReader.hasNext()) {
            token = expressionReader.next();

            // the token is an operand (ie. an integer), add it to the postfix string expression
            if (isOperand(token)) {
                postfix.append(token + " ");
            }

            // the token is a left brace, then push it onto the operator stack
            else if (token.equals("(")) {
                operatorStack.push(token.charAt(0));
            }

            // the token is an operator
            else if(token.equals("*") || token.equals("/") || token.equals("+") || token.equals("-")) {
                if (!operatorStack.empty()) {
                    // while the top stack element has higher or equal precedence, pop the operator stack and append the
                    // operator to the postfix expression
                    while (!(operatorStack.empty()) && higherOrEqualPrecedence(token.charAt(0), operatorStack.peek())) {
                        postfix.append(operatorStack.pop() + " ");
                    }
                }
                // push the current operator onto the operator stack
                operatorStack.push(token.charAt(0));
            }

            // the token is a right brace
            else if (token.equals(")")) {
                while (!operatorStack.empty()) {
                    // if the top of the operator stack isn't a matching left brace, pop the operator stack and append
                    // it to the postfix expression
                    if (operatorStack.peek() != '(') {
                        postfix.append(operatorStack.pop() + " ");
                    } else {
                        // if it's a left brace, pop it and discard it
                        operatorStack.pop();
                        break;
                    }
                }
            }
            // the token isn't an operator, brace, or integer, so it's some other character that we cannot use in
            // calculations
            else {
                throw new PostFixException(infix + " is not a valid infix expression because it contains token " + token);
            }
        }

        // while the operator stack isn't empty, add each character to the postfix expression one by one
        while (!operatorStack.empty()) {
            postfix.append(operatorStack.pop() + " ");
        }

        return postfix.toString();
    }

    /**
     * Evaluates whether the second operator has higher or equal precedence than the first operator, based on PEMDAS
     * (Parentheses > Exponent > (Multiplication | Division) > (Addition | Subtraction).
     * @param operator1 first operator compared against
     * @param operator2 what the first operator is being compared to
     * @return whether operator 2 has higher or equal precedence than operator 1
     */
    private static boolean higherOrEqualPrecedence(char operator1, char operator2) {
        switch (operator1) {
            // We need to deal with the parentheses too because they're also pushed onto the operator stack
            case '(':
                return true;
            // The '*' case is empty because it will fall to the '/' case when operator is '*'. Multiplication and
            // division have equal precedence, so this is fine
            case '*':
            case '/':
                return (operator2 == '*' || operator2 == '/');

            // The '+' case is empty because it will fall to the '-' case when operator is '+'. Addition and subtraction
            // have equal precedence, so this is fine
            case '+':
            case '-':
                return (operator2 == '*' || operator2 == '/' || operator2 == '+' || operator2 == '-');

        }
        return false;
    }

    /**
     * Evaluate a postfix expression
     * @param postfix the postfix expression
     * @return the computation result of the expression
     */
    public static String evaluatePostfix(String postfix) {
        // Create a scanner to look through the infix expression
        Scanner reader = new Scanner(postfix);
        MyStack<Integer> operandStack = new MyStack<>();
        String result;
        int operand1, operand2;
        String token;
        // scan the given postfix expression from left to right
        while (reader.hasNext()) {
            token = reader.next();

            // the token is an operand
            if (isOperand(token)) {
                operandStack.push(Integer.parseInt(token));
            }

            // the token is an operator
            else if (isOperator(token)) {
                // compute operand1 operator operand2
                // if there aren't two operands to go w/ this operator, we don't have enough operands, and that means we
                // have an invalid expression
                if (!operandStack.empty()) operand2 = operandStack.pop();
                else return "INVALID";
                if (!operandStack.empty()) operand1 = operandStack.pop();
                else return "INVALID";
                result = computeResult(operand1, token.charAt(0), operand2);

                // push the result unto the stack
                if (!isOperand(result)) return result; // if this computation is undefined, the whole thing is undefined
                else if (isOperand(result)) operandStack.push(Integer.parseInt(result));
            }
        }
        // return the top of the stack as the result
        return operandStack.pop() + "";
    }

    /**
     * Compute the result of 2 operands and an operator
     * @param operand1 the first integer
     * @param operator the operator
     * @param operand2 the second integer
     * @return the answer to operand1 operator operand2
     */
    private static String computeResult(int operand1, char operator, int operand2) {
        switch (operator) {
            case '*':
                return (operand1 * operand2) + "";
            case '/':
                if (operand2 == 0) return "UNDEFINED"; // dividing by 0 is not possible
                return (operand1 / operand2) + "";
            case '+':
                return (operand1 + operand2) + "";
            case '-':
                return (operand1 - operand2) + "";
        }

        return 0 + "ya";
    }

    /**
     * Determine whether the token is an operand
     * @param token a string
     * @return whether the token is an operand (aka an integer)
     */
    private static boolean isOperand(String token) {
        return token.matches("\\d*") || (token.charAt(0) == '-' && token.substring(1, token.length()).matches("\\d*")
                && !isOperator(token));
    }

    /**
     * Determine whether the token is an operator
     * @param token a string
     * @return whether the token is an operator *, /, +, or -
     */
    private static boolean isOperator(String token) {
        // if the token isn't one character, it's definitely not an operator, so return false
        if (token.length() != 1) return false;
        return token.charAt(0) == '*' || token.charAt(0) == '/' || token.charAt(0) == '+' || token.charAt(0) == '-';
    }
}
