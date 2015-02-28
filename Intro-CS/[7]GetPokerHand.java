import java.util.*;

/* @title: Generating Cards
 * @author: Chelsea Valentine
 * @date: Tuesday, February 17, 2015
 * 
 * Assignment:
 * 
 * Write a program that generates a random poker hand of cards (5 random cards). Each card should come
 * from a 52 card deck. The standard deck has 4 suits: spades, hearts, diamonds, clubs. In each suit there
 * are 13 cards: ace, king, queen, jack, & the number cards from 2 to 10.
 * 
 * The main() method of your program is responsible for generating the hand and printing the results to the
 * screen. You should also have a method that generates a single random card from a 52 card deck. (Hint: the
 * main() method should make 5 calls to that method.)
 * 
 * Your program should print the names of the suit and the card "number" of all 5 randomly generated cards.
 * (eg. Your hand is:
 * 		9 of Spades
 * 		...)
 * 
 * You don't need to worry about repetitions of a card.
 * 
 * Note 1: Use a random number generator to pick a random card.
 * Note 2: Your program shouldn't have a huge switch/if-else statement w/ 52 cases.
 * Note 3: Your program doesn't ask the user for anything.
 * 
 * Extra credit: Modify the program to make sure the cards in the generated hand are unique -- there's no
 * chance of a repeated card.
 */

public class GetPokerHand {
	public static void main (String[] args){
		
		//Let the user know what this program does
		System.out.println("This program will 'randomly' generate 5 cards from a standard"
				+ " deck of 52 cards.\n");
		
		//Let the user know what their hand is
		System.out.println("Your hand is:");
		cards(5);
	}

	/**
	 * Generates a specified number of random cards from a deck of 52 cards
	 * @param numberOfCards the number of cards to randomly generate
	 */
	public static void cards (int numberOfCards){
		//Create the 4 arrays for hearts, clubs, spades, & diamonds
		ArrayList<String> hearts = new ArrayList<>(13);
		ArrayList<String> spades = new ArrayList<>(13);
		ArrayList<String> clubs = new ArrayList<>(13);
		ArrayList<String> diamonds = new ArrayList<>(13);
		
		addHighCards(hearts, "Hearts");
		addHighCards(spades, "Spades");
		addHighCards(clubs, "Clubs");
		addHighCards(diamonds, "Diamonds");
		
		//Add cards 2 through 10 to each of the decks
		for (int i = 2; i<=10; i++){
			hearts.add(Integer.toString(i) + " of Hearts");
			spades.add(Integer.toString(i) + " of Spades");
			clubs.add(Integer.toString(i) + " of Clubs");
			diamonds.add(Integer.toString(i) + " of Diamonds");
		}
		
		//Add the all of the cards to a main stack of cards
		List <String> mainStack = new ArrayList<String>();
		
		//Add cards of each suit to the main deck of cards
		for (int i=0; i < 13; i++){
			mainStack.add(hearts.get(i));
			mainStack.add(spades.get(i));
			mainStack.add(clubs.get(i));
			mainStack.add(diamonds.get(i));
		}

		//Choose a random card out of the 52 cards; no repeats
		Set<String> chosenCards = new HashSet<String>();
		
		while (chosenCards.size() != numberOfCards){
			int chosenCard = (int)Math.floor(Math.random() * 52);
			chosenCards.add(mainStack.get(chosenCard));
		}
		
		//Create an iterator to be able to display all elements of the set
		Iterator<String> yourCardsAre = chosenCards.iterator();
		while (yourCardsAre.hasNext())
			System.out.println(yourCardsAre.next());
	}
	

	/** 
	 * Adds the Ace, King, Queen, and Jack cards, of each of the suits, to the main deck.
	 * @param deck the suit we'll be generating the cards for
	 * @param name the name of the suit we'll be generating cards for
	 */
	public static void addHighCards(ArrayList<String> deck, String name){
		deck.add("Ace of " + name);
		deck.add("King of " + name);
		deck.add("Queen of " + name);
		deck.add("Jack of " + name);
	}
}