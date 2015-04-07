package accounts;

/**
 * @title Program 1: Account
 * @author Chelsea Valentine
 * @date April 6th 2015
 * 
 * 
 * Assignment:
 * 
 * Write a program that will allow you to represent and manipulate bank customers' accounts
 */
public class Account {
	
	//The variables that will characterize an account
	double balance;
	double annualInterestRate;
	String owner;
	String accountNumber;
	
	
	/**
	 * @param balance the account balance to be kept in the account
	 * @param annualInterestRate annual interest rate for the account
	 * @param owner name of the account owner
	 * @param accountNumber account number
	 */
	public Account (double balance, double annualInterestRate, String owner, String accountNumber) {
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
		this.owner = owner;
		this.accountNumber = accountNumber;
	}
	
	/** Adds the return value of the monthly interest to the balance of the chosen account
	 * @return the new balance with the monthly interest added
	 */
	public double addMonthlyInterest() {
		double interest = ((annualInterestRate/12.0)/100.0) * balance;
		balance += interest;
		return balance;
	}
	
	/** Get the current balance of the chosen account
	 * @return the current balance of the chosen account
	 */
	public double checkBalance() {
		return balance;
	}
	
	/** Deposit a specified amount into the account
	 * @param amount the amount that you want to deposit
	 * @return the new balance after the amount is added
	 */
	public double deposit (double amount) {
		//The amount deposited must be at least 0 for this constructor to do anything
		if (amount >= 0){
			balance += amount;
		}
		
		return balance;
	}
	
	/** Get the current annual interest rate of an account
	 * @return the current annual interest rate of the account
	 */
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	
	/** Get the value of the monthly interest of an account, using its annual interest rate and current balance
	 * @return the monthly interest of an account
	 */
	public double getMonthlyInterest() {
		double monthlyInterest = annualInterestRate/12.0/100.0 *  balance;
		return monthlyInterest;
	}
		
	/** Compute the string representation of an account
	 * @return the formatted string listing the account number, owner, balance, and annual interest rate
	 */
	public String toString() {
		//12 character-wide field for account number (right-aligned);
		//15-character field for owner's name (right-aligned);
		//10-digit field for balance (w/ 2 digits after decimal point & a $)
		//5-digit field for annual interest rate (w/ 2 digits after decimal point & %)
		String representation = String.format("%12s %15s %10.2f$ %5.2f%%", accountNumber, owner, balance,
				annualInterestRate);
		return representation;
	}
	
	/** Withdraw the specified amount from the account (if request meets criteria)
	 * @param amount the amount to be withdrawn
	 * @return the new balance after the withdrawal is made
	 */
	public double withdraw (double amount) {
		if (amount >= 0  && amount <= balance) {
			balance -= amount;
		}
		
		return balance;
	}
}
