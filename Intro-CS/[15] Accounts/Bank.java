package accounts;

public class Bank {
	public static void main(String args[]) {
		//Create an array of accounts
		Account[] allAccounts = new Account[10];
		for (int i = 0; i < allAccounts.length; i++) {
			double interestRate = Math.random() * 10; //Choose some random number for their annual Interest Rate
			double theirBalance = 50000 + Math.floor(Math.random() * 50000);
			String[] owners = {"Bill", "Abby", "Carrie", "alex", "Zake", "Jill", "Ally", "Cho",
					"linzy", "Chelsea"};
			String accountNumber = "10000" + i;

			allAccounts[i] = new Account(theirBalance, interestRate, owners[i], accountNumber);
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
	
	public static String largestBalance(Account[] accounts) {
		String largest;
		double largeBalance = accounts[0].balance;
		int largeAccount = 0;
		
		for (int i = 1; i < accounts.length; i++) {
			if (largeBalance < accounts[i].balance) {
				largeBalance = accounts[i].balance;
				largeAccount = i;
			}
		}
		largest = accounts[largeAccount].toString(); 
	
		return largest;
	}
	
	public static String smallestBalance(Account[] accounts) {
		String smallest;
		double smallBalance = accounts[0].balance;
		int smallAccount = 0;
		
		for (int i = 1; i < accounts.length; i++) {
			if (smallBalance > accounts[i].balance) {
				smallBalance = accounts[i].balance;
				smallAccount = i;
			}
		}
		smallest = accounts[smallAccount].toString(); 
		
		return smallest;
	}
	
	public static void printAccounts (Account[] accounts) {
		for (int i = 0; i < accounts.length; i++) {
			System.out.println(accounts[i]);
		}
	}
	
	//List of accounts sorted by owner's name
	public static void alphabeticSort (Account[] accounts) {
		for (int i = 0; i < accounts.length; i++){
			for (int j = 0; j < accounts.length - 1; j++) {
				if (accounts[j].owner.toLowerCase().compareTo(accounts[j+1].owner.toLowerCase()) > 0 ) {
					Account holder = accounts[j];
					accounts[j] = accounts [j+1];
					accounts[j+1] = holder;
				}
			}
		}
		
		printAccounts(accounts);
	}
	
	//List of accounts sorted by the balance (lowest to highest)
	public static void balanceSort (Account[] accounts) {
		for (int i = 0; i < accounts.length; i++) {
			for (int j = 0; j < accounts.length - 1; j++) {
				if (accounts[j].balance > accounts[j+1].balance){
					Account holder = accounts[j];
					accounts[j] = accounts[j+1];
					accounts[j+1] = holder;
				}
			}
		}
		
		printAccounts(accounts);
	}
}
