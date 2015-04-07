package accounts;

/**
 * @title Program 1: Account
 * @author Chelsea Valentine
 * @date April 6th 2015
 * 
 * 
 * 
 * Assignment:
 * 
 * 
 */
public class Account {
	//The things that characterize an account
	
	double balance; //account balance to be kept in the account
	double annualInterestRate; //annual interest rate for the account
	String owner; //name of the account owner
	String accountNumber; //account number
	
	
	public Account (double balance, double annualInterestRate, String owner, String accountNumber) {
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
		this.owner = owner;
		this.accountNumber = accountNumber;
	}
	
	//Adds the value of the monthly interest to the balance of this account
	public double addMonthlyInterest() {
		double interest = ((annualInterestRate/12.0)/100.0) * balance;
		balance += interest;
		return balance;
	}
	
	//Returns the current balance of this account
	public double checkBalance() {
		return balance;
	}
	
	//Deposits a specified amount into the account
	public double deposit (double amount) {
		//The amount deposited must be at least 0 for this constructor to do anything
		if (amount >= 0){
			balance += amount;
		}
		
		return balance;
	}
	
	//Returns the current annual interest rate of this account
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	
	//Returns the value of the monthly interest given the current balance and
	//the current annual interest rate of this account
	public double getMonthlyInterest() {
		double monthlyInterest = annualInterestRate/12.0/100.0 *  balance;
		return monthlyInterest;
	}
	
	//Computes the string representation of this account.
	public String toString() {
		//12 character-wide field for account number (right-aligned);
		//15-character field for owner's name (right-aligned);
		//10-digit field for balance (w/ 2 digits after decimal point & a $)
		//5-digit field for annual interest rate (w/ 2 digits after decimal point & %)
		String representation = String.format("%12s %15s %10.2f$ %5.2f%%", accountNumber, owner, balance,
				annualInterestRate);
		return representation;
	}
	
	//Withdraws specified amount from the account
	public double withdraw (double amount) {
		if (amount >= 0  && amount <= balance) {
			balance -= amount;
		}
		
		return balance;
	}
}
