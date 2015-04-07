package accounts;

/**
 * @title Program 2: Bank
 * @author Chelsea Valentine
 * @date April 6th 2015
 * 
 * 
 * Assignment:
 * 
 * Implement a simulated bank program in which 10 dummy accounts are created.
 */
public class Bank {
	public static void main(String args[]) {
		Account[] allAccounts = new Account[10]; //Create an array to hold 10 accounts
		for (int i = 0; i < allAccounts.length; i++) { //Create 10 accounts, 1 at a time
			double interestRate = Math.random() * 10; //Choose some random number for their annualInterestRate
			double theirBalance = 50000 + Math.floor(Math.random() * 50000); //Select a random balance for the owners to have
			String[] owners = {"Bill", "Abby", "Carrie", "alex", "Zake", "Jill", "Ally", "Cho",
					"linzy", "Chelsea"}; //Select names that'll become the owner names
			String accountNum = "10000" + i; //Systematically create account numbers

			allAccounts[i] = new Account(theirBalance, interestRate, owners[i], accountNum); //Create account
		}
		
		System.out.println("The accounts are as follows:");
		printAccounts(allAccounts);
		
		System.out.println("\nThe largest balance is \n" + largestBalance(allAccounts) + "\n");
		System.out.println("\nThe smallest balance is \n" + smallestBalance(allAccounts) + "\n");
		
		System.out.println("\nThe list of accounts, sorted by balance from least to greatest is:");
		balanceSort(allAccounts);
		
		System.out.println("\nThe list of accounts, sorted alphabetically, is:");
		alphabeticSort(allAccounts);
	}
	
	/** Find the largest balance of a list of accounts
	 * @param accounts the array of accounts to be searched for the largest balance
	 * @return the account with the largest balance
	 */
	public static String largestBalance(Account[] accounts) {
		String largest;
		double largeBalance = accounts[0].balance; //Assume that the first account to be the largest balance
		int largeAccount = 0; //Hold the index of our current largest balance
		
		for (int i = 1; i < accounts.length; i++) { //Iterate through the array of accounts to find the actual largest
			if (largeBalance < accounts[i].balance) {
				largeBalance = accounts[i].balance; //Save  the largest balance
				largeAccount = i; //Save the largest account's index
			}
		}
		largest = accounts[largeAccount].toString(); //This'll be returned to show the user the account with the largest balance
	
		return largest;
	}
	
	/** Find the smallest balance of a list of accounts
	 * @param accounts the array of accounts to be searched for the smallest balance
	 * @return the account with the smallest balance
	 */
	public static String smallestBalance(Account[] accounts) {
		String smallest;
		double smallBalance = accounts[0].balance; //Assume that the first account has the smallest balance
		int smallAccount = 0; //Hold the index of our current smallest balance
		
		for (int i = 1; i < accounts.length; i++) { //Iterate through the array of accounts to find the actual smallest
			if (smallBalance > accounts[i].balance) {
				smallBalance = accounts[i].balance; //Save the smallest balance
				smallAccount = i; //Save the smallest account's index
			}
		}
		smallest = accounts[smallAccount].toString(); //This'll be returned to show the user the account w/ smallest balance
		
		return smallest;
	}
	
	/** Display all of the accounts in the account array
	 * @param accounts the array of accounts to be displayed
	 */
	public static void printAccounts (Account[] accounts) {
		for (int i = 0; i < accounts.length; i++) { //Print all of the accounts, one at a time
			System.out.println(accounts[i]);
		}
	}
	
	/** List the accounts sorted alphabetically by the owner's name
	 * @param accounts the array of accounts to be alphabetically sorted
	 */
	public static void alphabeticSort (Account[] accounts) {
		for (int i = 0; i < accounts.length; i++){
			for (int j = 0; j < accounts.length - 1; j++) {
				if (accounts[j].owner.toLowerCase().compareTo(accounts[j+1].owner.toLowerCase()) > 0 ) { //Force lowercase for accurate alphabetical ordering
					Account holder = accounts[j]; //Temporarily hold the original item in index j so it isn't overwritten
					accounts[j] = accounts [j+1]; //Make the (respectively) 2nd item the 1st item
					accounts[j+1] = holder; //Now assign the original 1st item to be the (respective) 2nd item
				}
			}
		}
		
		printAccounts(accounts);
	}
	
	//List of accounts sorted by the balance (lowest to highest)
	/** Sort the array of accounts by smallest to largest balance
	 * @param accounts the arraya of accounts to be numerically sorted
	 */
	public static void balanceSort (Account[] accounts) {
		for (int i = 0; i < accounts.length; i++) {
			for (int j = 0; j < accounts.length - 1; j++) {
				if (accounts[j].balance > accounts[j+1].balance){ //Check whether the 2nd account has a higher balance than the 1st account
					Account holder = accounts[j]; //Temporarily hold the original item in index j so it isn't overwritten
					accounts[j] = accounts[j+1]; //Make the (respectively) 2nd item the 1st item
					accounts[j+1] = holder; //Now assign the original 1st item to be the (respective) 2nd item
				}
			}
		}
		
		printAccounts(accounts);
	}
}
