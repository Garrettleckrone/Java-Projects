//Garrett Leckrone
//CS 161
//Project 2
import java.util.*;
import java.awt.*;

public class Guest extends Player {
	// Fields
	Random random = new Random();

	// Constructor
	public Guest(Deck deck) {
		super(deck); // Takes a deck to use for the player

	}//End Constructor

	// Methods
	public boolean stand() { 	// Guest will always stand if their total is at least 19.
								// Guest will stand half the time if their total
								// is between 16 and 18 inclusively
		if (valueOf() >= 19)
			return true;
		else if ((valueOf() >= 16) && (valueOf() <= 18)) {
			if (random.nextBoolean()) {
				return true;
			} // Using a random object for a 50% chance of standing
			else
				return false; // if the value of the hand is between 16 and 18.
		} else if (valueOf() < 16) {
			return false;
		} else
			return false;
	}
	//Determines the value of the guests hand
	public int valueOf() { // Guest will always use ace as a 1
		int handSum = 0;
		for (int counter = 0; counter < hand.size(); counter++) {
			handSum += hand.get(counter).valueOf();
		}
		return handSum;
	}

}