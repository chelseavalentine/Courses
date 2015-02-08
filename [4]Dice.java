/*
 * @title: Rolling a Dice
 * @author: Chelsea Valentine
 * 
 * Assignment:
 * 
 * Write a program that simulates rolling a dice. Your program should roll a single dice 100,000 times and
 * count occurrences of each result. Once you have the totals, your program should display the percentage
 * of times that each score was achieved.
 * 
 * The numbers should be displayed with exactly four decimal places followed by a percent sign.
 * 
 * Note 1: Your numbers should add up to about 100, but may not add up to exactly 100.
 * Note 2: This program is not interactive. It does not take any input from the user.
 */

public class Dice {
	public static void main(String[] args){
		
		//Set up accumulative variables
		double rolled1, rolled2, rolled3, rolled4, rolled5, rolled6;
		rolled1 = rolled2 = rolled3 = rolled4 = rolled5 = rolled6 = 0;
		
		//Roll the dice 100,000 times.
		for (int i=0; i<100000; i++){
			//Generate a random number and round it up to the lowest higher integer.
			double roll = Math.ceil( Math.random() * 6 );
			
			//Depending on what the random number is, add to the total number of rolls of that number
			if (roll == 1){
				rolled1 += 1;
			}
			
			if (roll == 2){
				rolled2 += 1;
			}
			
			if (roll == 3){
				rolled3 += 1;
			}
			
			if (roll == 4){
				rolled4 += 1;
			}
			
			if (roll == 5){
				rolled5 += 1;
			}
			
			if (roll == 6){
				rolled6 += 1;
			}
		}
		
		//Present results
		//Divide the counts by 100,000, then multiply by 100 to get the percentage of times the number was rolled.		
		System.out.printf("The number 1 was rolled %.4f%% of the time.\n", (rolled1/100000)*100);
		System.out.printf("The number 2 was rolled %.4f%% of the time.\n", (rolled2/100000)*100);
		System.out.printf("The number 3 was rolled %.4f%% of the time.\n", (rolled3/100000)*100);
		System.out.printf("The number 4 was rolled %.4f%% of the time.\n", (rolled4/100000)*100);
		System.out.printf("The number 5 was rolled %.4f%% of the time.\n", (rolled5/100000)*100);
		System.out.printf("The number 6 was rolled %.4f%% of the time.\n", (rolled6/100000)*100);
	}
}