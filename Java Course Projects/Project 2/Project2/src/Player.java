//Garrett Leckrone
//CS 161
//Project 2
import java.util.*;
import java.awt.*;

public abstract class Player {

	//Fields
	protected ArrayList<Card> hand = new ArrayList<Card>();	//The players hand
	protected Deck deck;
	
	//Constructor
	public Player(Deck deck){
		this.deck = deck;	
	}
	
	//Abstract Methods
	abstract boolean stand();
	abstract int valueOf();
	//
	//Methods
	//
	//Clears players hand
	public void clearHand(){		
		hand.clear();
	}
	
	//Determines if the player busts
	public boolean bust(){			
		int handSum = 0;
		
		if (hand.isEmpty()){ 		//If hand is empty, the player has not busted	
			return false;
		}
		for (int counter = 0; counter < hand.size(); counter++){  
			handSum += hand.get(counter).valueOf();	//Add all the values of the faces
		}
		if (handSum >= 21) return true;				//If the sum is 21 or over, the player busts
		else if (handSum <= 20) return false;		//If the sum is less than 21, the player does not bust
		else return false;							//Default return of False
	}
	
	//The player "hits" the deck
	public void hit(){		
		hand.add(deck.dealCard());
	}
	
	//The player plays
	public void play(){
		//First, draw two cards. A bust is guarenteed not to occur from two cards.
		hit();	hit();	//Two hits
		//Will we stand?
		while (stand() != true){
			//If we're not standing, hit the deck
			hit();
			//Did we bust from that?
			if (bust() == true){
				break; 				//If yes, break 
									//Player loses
			}
		}
	}
	//Getter for the hand
	public ArrayList<Card> getHand(){
		return hand;
	}
	
	//Developer defined toString method
	public String toString(){
		String outputString = "";
		
		for (int counter = 0; counter < hand.size(); counter++) {

		}
		return outputString;
	}
}
