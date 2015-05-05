package potions;

/**
 * This class represents a Bucket that holds discarded
 * potion ingredients. 
 * 
 * @author csci 101, sec. 1,2
 *
 */
public class Bucket {
	
	private String discardedIngredients;
	
	/**
	 * Creates an empty Bucket object.  
	 */
	public Bucket () {
		discardedIngredients = "";
	}
	
	/**
	 * Adds the ingredient to this Bucket object. 
	 * @param ingredient an ingredient to be discarded
	 */
	public void dumpIngredient(char ingredient) {
		discardedIngredients = discardedIngredients + ingredient;
	}
	
	/**
	 * Represents the content of this Bucket object as a string. 
	 */
	public String toString() {
		return discardedIngredients;
	}
	
	/**
	 * Gets the number of discarded ingredients in this Bucket object. 
	 * @return number of ingredients in this Bucket object
	 */
	public int getSize() {
		return discardedIngredients.length();
	}
	
}