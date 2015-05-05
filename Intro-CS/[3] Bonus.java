import java.util.*;

/*
 * @title: Highest bonus
 * @name: Chelsea Valentine
 * 
 * Assignment:
 * 
 * Write a program that prompts the user first to enter the number of employees and then to enter the name and bonus amount for each
 * employee (the name should be a single string with no spaces, the bonus should be a real number).
 * 
 * The program should then display the name and bonus amount for the employee with the highest bonus.
 * 
 * Extra credit (5 points): Modify the above program to display two employees with the highest bonus amount.
 * 
 * Note: You are not allowed to use arrays, ArrayLists, etc.
 */
public class Bonus {
	public static void main(String[] args) {
		
		//Explain what this program does
		System.out.println("This program will tell you the two employees who earned the highest bonus.\n");
		
		//Initialize variables
		double employees, bonus, highestBonus, secondHighestBonus;
		highestBonus = secondHighestBonus = 0;
		String employee, highestEmployee, secondHighestEmployee;
		employee = highestEmployee = secondHighestEmployee = "";
		
		//Ask the user how many employees they're entering data for
		System.out.print("How many employees do you have? ");
		Scanner in = new Scanner (System.in);
		employees = in.nextInt();
		
		for (int i=1; i<=employees; i++){
			
			System.out.print("What is the name of employee #" + i + "? ");
			employee = in.next();
			
			System.out.print("What was " + employee + "'s bonus? (omit the '$' sign) ");
			bonus = in.nextDouble();
			
			if (bonus >= secondHighestBonus && bonus < highestBonus){
				
				//Take into account the possibility that 2 employees have the second highest bonus
				if (bonus == secondHighestBonus){
					secondHighestEmployee = secondHighestEmployee + " and " + employee;
				}
				
				//If 2 employees don't share the second highest bonus, then just replace the 2nd highest completely.
				else{
					secondHighestBonus = bonus;
					secondHighestEmployee = employee;
				}
			}
			
			else if (bonus >= highestBonus){
				
				//Take into account the possibility that 2 employees have the highest bonus
				if (bonus == highestBonus){
					highestEmployee = highestEmployee + " and " + employee;
				}
				
				else{
					//Make the current highestBonus be the secondHighestBonus
					secondHighestBonus = highestBonus;
					secondHighestEmployee = highestEmployee;
					
					//If 2 employees don't share the highest bonus, then just replace the highest bonus completely
					highestBonus = bonus;
					highestEmployee = employee;
				}
			}
		}
		
		System.out.println("The highest bonus went to " + highestEmployee + " with $" + highestBonus + "\n");
		
		//Take into account that chance that there's only one employee
		if (secondHighestEmployee != ""){
			System.out.println("The second highest bonus went to " + secondHighestEmployee + " with $" + secondHighestBonus);
		}
				
		in.close();
	}
}