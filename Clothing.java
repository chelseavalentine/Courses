import java.util.*;

public class Clothing {
	public static void main (String[] args){
		Scanner in = new Scanner (System.in);
		boolean keepGoing = true;
		double price = 0, sum = 0;
		int items = 0;
		
		System.out.print("Enter the total price so far: ");
		price = in.nextDouble();
		sum += price;
		
		System.out.print("Enter the total number of items so far: ");
		items = in.nextInt();
		
		while (keepGoing){
			System.out.print("Enter a price, or exit ('0'): ");
			price = in.nextDouble();
			if (price == 0){
				break;
			}
			else{
				sum += price;
				items++;
			}
		}
		
		System.out.println("There were " + items + " items that cost " + sum);
		in.close();
	}
}
