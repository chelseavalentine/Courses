package potions;

/**
 * This class represents a potion that consists of multiple
 * ingredients (represented by characters). 
 * 
 * @title OOP Potions Challenge 3
 * @author Chelsea Valentine &  csci 101, sec. 1,2
 * @date Tuesday, March 31, 2015
 * 
 * Description:
 * Given a list of items to mix into a 5-item potion, find the potion that won't
 * burn when you heat it.
 * 
 */

public class Potion {
	
	public static void main(String[] args)
	{
		// create a Potion object
		Potion potionOne = new Potion();
		
		// create a Bucket object
		Bucket bucketOne = new Bucket();
		
		// items to mix in
		String itemsToMix = "brcaxpaxdqaqdrrdtpaxxdbapprbbpqaqaqqpacbxcaaprrardawpaccrxpabqqqqwcpqpxdawrpbadddddqppcaccbxdpbbpxwqqrcrbarraqqxpabrrbcrqpbbcxbbprqacbxbwaccpbrqadxpqdwrqawwdrcpwcqpqawpabrcqqxdabpbbbcppwpbxbdbbrbbcwaxrqxqcqdqpapwdcdadawxaxprrdxaqpbcpqcpdqbpwwwcxdwcardcxcbcxxwwaqrcdxpwpdpaqrabwqddqqdqqpbarqqdqqcaddwwabdabraxxpabqxrabrxdqqcaxaaxxaxqqbrcrracxwdqxxxwxbwdcwcpxrrrddcdxxdbwrwxppcpxcrxdxqrcqpawppcdqppbxbqbqawqwqcpcqapcwwawbrpqbpqcqxrrcarpbqqqacxadbararrxaawpqqacqprccrdqpraawcaabrqqrqqwbwdwqqdaqcqdqparbb";
		
		// iterate over all items, adding the ingredients one at a time
		// until the potion is full
		for (int i = 0; i < itemsToMix.length(); i++)
		{
			//If the potion is full, check whether you can heat it
			System.out.println(potionOne.ingredientList.length() + ", " + potionOne.ingredientList);
			
			//Check whether the potion is full,  if it is, try heating
			if (potionOne.isFull()){
				if (potionOne.heatPotion(bucketOne)){
					break; //If the potion can be successfully heated, we're done
				}
			}
			
			// extract item to mix in
			char item = itemsToMix.charAt(i);
			
			// attempt to add the item to the potion
			boolean result = potionOne.addIngredient( item );
				
			// if it failed, add it to the bucket
			if (!result)
				bucketOne.dumpIngredient(item);
		}
		
		// output
		System.out.println("Potion: " + potionOne.toString() );
		System.out.println("Bucket: " + bucketOne.toString() );
	}
	
	private int numOfIngredients;
	private String ingredientList;
	
	/**
	 * Creates a Potion object that can hold maximum of 10 ingredients. 
	 */
	public Potion() {
		numOfIngredients = 5;
		ingredientList = "";		
	}
	
	/**
	 * Creates a Potion object that can hold specified number of ingredients.
	 * @param numOfIngredients the maximum number of ingredients
	 * allowed in this Potion object.
	 */
	public Potion ( int numOfIngredients ) {
		this.numOfIngredients = numOfIngredients; 
		ingredientList = "";	
	}
	
	/**
	 * Adds a specified ingredient to this Potion object. 
	 * @param ingredient ingredient to be added.
	 * @return true if the ingredient is a valid one (one of 'a', 'b', 'c', 'd', 'w')
	 * and this Potion did not reach the maximum number of ingredients 
	 * allowed, false, otherwise. 
	 */
	public boolean addIngredient( char ingredient ) {
		
		if ( ingredientList.length() >= numOfIngredients ){
			return false;
		}
		
		if ( ingredient != 'a' && ingredient != 'b' 	&& ingredient != 'c'
				&& ingredient != 'd' && ingredient != 'w')
			return false;
		
		ingredientList = ingredientList + ingredient; 
		return true;
		
	}
	
	/**
	 * Represents the content of this Potion object as a string. 
	 */
	public String toString() {
		return ingredientList; 
	}
	
	/** Heat the potion if it has water in it, otherwise discard it
	 * @param b The bucket that the discarded ingredients will be placed into
	 * @return whether the potion has water
	 */
	public boolean heatPotion(Bucket b){
		boolean hasWater = false;
		//Check every ingredient of the potion to see if it is water
		for (int i = 0; i < ingredientList.length(); i++) {
			if (this.ingredientList.charAt(i) == 'w'){
				hasWater = true;
				this.ingredientList = this.ingredientList.replace("w", ""); //Get rid of the water
				break; //Once we find water, we're good so we can stop
			}
		}
		
		if (hasWater == false){
			//If the potion doesn't have water, it'll burn, so discard it
			discardPotion(b);
			ingredientList = ""; //Clear out the ingredient list
		}
		
		return hasWater;
	}
	
	/** Discard a potion when it burns
	 * @param b the bucket that the discarded ingredients will be placed into
	 */
	public void discardPotion (Bucket b){
		//Throw each ingredient in the potion into the bucket
		for (int i = 0; i < ingredientList.length(); i++){
			char item = ingredientList.charAt(i);
			b.dumpIngredient(item);
		}
	}
	
	/** Check whether the potion is full (has 5 ingredients in it)
	 * @return whether the potion is full
	 */
	public boolean isFull() {
		boolean full = false;
		if (this.ingredientList.length() == 5){
			full = true;
		}
		return full;
	}
	

}