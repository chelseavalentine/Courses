package accounts;

/**
 * This class provides tests for correctness of implementation of the
 * Account class. When the implementation is correct (according to the specification), 
 * this Driver program prints a single line of text: 
 *    All tests completed. 
 * Any discovered errors are reported before that line is printed to the output. 
 * Note that a reported error may be a result of error condition that occurs prior
 * to it. Errors should be read and resolved in order they are listed.  
 * 
 * @author Joanna Klukowska
 *
 */
public class AccountDriver {
	public static void main(String [] args) {
		//run all tests
		testConstructor();
		testDeposit();
		testWithdraw();
		testGetMonthlyInterest();
		testAddMonthlyInterest();
		testToString();
		
		System.out.println("\nAll tests completed.");
		
	}
	
	/**
	 * Provides test for the 4-argument constructor of the Account class. 
	 */
	public static void testConstructor() {
		Account a = new Account(100, 1.2, "Joanna", "100000000");
		if (a==null)  printErrorAndQuit("Constructor did not create object.");
		if (a.checkBalance() != 100) printError("Constructor did not set balance correctly");
		if(a.getAnnualInterestRate() != 1.2) printError("Constructor did not set annual interest rate correctly.");
	}
	
	/**
	 * Provides test for the deposit() method of the Account class.
	 */
	public static void testDeposit() {
		Account a = new Account(100, 1.2, "Joanna", "100000000");
		if  (a.deposit(5.0) != 105) printError("Deposit of $5.0 not handled correctly.");
		if (a.deposit(-5.0) != 105) printError("Deposit of negative amount not handled correctly");
		if (a.deposit(0.0) != 105) printError("Deposit of $0.0 not handled correctly.");
		if (a.deposit(100) != 205) printError("Deposit of $100.0 not handled correctly.");
	}
	
	/**
	 * Provides test for the withdraw() method of the Account class.
	 */
	public static void testWithdraw() {
		Account a = new Account(100, 1.2, "Joanna", "100000000");
		if ( a.withdraw(5) != 95) printError("Withdrawal of $5.00 not handled correctly");
		if (a.withdraw(-5) != 95) printError("Withdrawal of negative amount not handled correctly");
		if (a.withdraw(200) != 95) printError("Withdrawal of amount greater than balance not handled correctly");
		if (a.withdraw(95) != 0.0) printError("Withdrawal of all funds not handled correctly");
		if (a.withdraw(5) != 0.0) printError("Withdrawal of from empty account not handled correctly");
	}
	
	/**
	 * Provides test for the getMonthlyInterest() method of the Account class.
	 */
	public static void testGetMonthlyInterest() {
		Account a = new Account(100, 1.2, "Joanna", "100000000");
		if ( a.getMonthlyInterest() !=( 1.2/12.0*100.0) / 100.0 )
			 printError("Monthly interest amount  not computed correctly");
		Account b = new Account(150.0, 1.5, "Bob", "100000001");
		if ( b.getMonthlyInterest() !=( 1.5/12.0*150.0) / 100.0 )
			 printError("Monthly interest amount  not computed correctly");
	}
	
	/**
	 * Provides test for the addMonthlyInterest() method of the Account class.
	 */
	public static void testAddMonthlyInterest() {
		Account a = new Account(100, 1.2, "Joanna", "100000000");
		double amount = ( 1.2/12.0*100.0) / 100.0 + a.checkBalance();
		if ( a.addMonthlyInterest() != amount)
			 printError("Adding monthly interest amount  not computed correctly"); 
		if (a.checkBalance() != amount)
			 printError("Balance invalid after adding monthly interest amount.");
		
	}
	
	/**
	 * Provides test for the toString() method of the Account class.
	 */
	public static void testToString () {
		Account a = new Account(100, 1.2, "Joanna", "100000000");
		if (! a.toString().equals("   100000000          Joanna     100.00$  1.20%") ) 
			printError("The value of toString is invalid.");
		
	}
	
	/**
	 * Prints the provided error message to the standard output and terminates the program. 
	 * @param error error message to be printed
	 */
	public static void printErrorAndQuit(String error) {
		System.err.printf("ERROR: %s\n", error);
		System.exit(-1);
	}
	
	/**
	 * Prints the provided error message to the standard output. 
	 * @param error error message to be printed
	 */
	public static void printError(String error) {
		System.err.printf("ERROR: %s\n", error);
	}

}