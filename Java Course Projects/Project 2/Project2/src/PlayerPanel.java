//Garrett Leckrone
//CS 161
//Project 2
import java.util.*;
import java.awt.*;

import javax.swing.*;

public class PlayerPanel extends JPanel {

	// Fields
	JLabel playerSum = new JLabel("Sum = 0"); // Holds the guest sum total to bedisplayed
	String playersHand;
	Player thePlayer; // ***This line has too much swag***

	// Constructor
	public PlayerPanel(String whoseHand, Player player) {
		playersHand = whoseHand; // This will be the title of the titled panel.
									// (e.g "Dealer's Hand")
		thePlayer = player;

		// Format the JPanel
		this.setBorder(BorderFactory.createTitledBorder(playersHand)); // Creates the titled border with the title.
		this.setLayout(new GridLayout(13, 1)); // Formats the layout so that lines stack on top of each other.
	}//End constructor

	public void setPlayerSum(int sum) {
		// Turns sum to string to be displayed as the sum
		playerSum.setText("Sum = " + sum);
	}

	public void setEmptyHand() {
		clearEmpties(); // Clear hand
		this.add(playerSum); // Add sum
		for (int counter = 0; counter <= 8; counter++) { // Add empties
			this.add(new JLabel("Empty"));
		}
	}

	public void clearEmpties() {
		removeAll();
		revalidate(); // I looked up these snazzy methods online. Idk what they
						// do but it worked so huzzah?
		repaint();

		this.add(playerSum);
		playerSum.setText("Sum = 0"); // Set sum to 0
	}

	public void displayHand(Player player) { // Displays the hand
		ArrayList<Card> theHand = player.getHand();

		for (int counter = 0; counter < theHand.size(); counter++) {
			this.add(new JLabel(theHand.get(counter) + ""));

		}
	}
}
