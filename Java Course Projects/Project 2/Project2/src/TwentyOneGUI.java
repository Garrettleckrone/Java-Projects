//Garrett Leckrone
//CS 161
//Project 2

//Imports
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class TwentyOneGUI extends JFrame {

	// Fields
	// Players
	Guest guest;
	int guestPoints = 0;
	Dealer dealer;
	int dealerPoints = 0;
	// The deck
	Deck theDeck;
	JPanel declareWinnerPanel = new JPanel();           // This panel be used to say who wins, if the game is pushed, or if someone busts.
	JLabel declareWinner = new JLabel("Empty Table");   // The label that displays the winner
	JFrame scoreBoard = new JFrame(); 					// Also create a new panel for the score board
	// Create panels for the Game Table
	JPanel handsPanel = new JPanel(); // Holds everything but the Declare Winner Panel
	PlayerPanel guestHandPanel = new PlayerPanel("Guest Hand", guest);    // Holds the guest hand information
	PlayerPanel dealerHandPanel = new PlayerPanel("Dealer Hand", dealer); // Holds the dealers hand information
	// Create buttons for the score board
	JButton startGameButton = new JButton("Play"); 			  // Start game button
	JButton dealGuestCardsButton = new JButton("Deal Guest Cards");   // Deal guest button
	JButton leaveTableButton = new JButton("Leave Table"); 			  // Leave table button
	JButton dealDealerCardsButton = new JButton("Deal Dealer Cards"); // Deal dealer button
	// Create variables for "Guest Wins" and "Dealer Wins" sections on the scoreboard
	JPanel guestWinsPanel = new JPanel();				 // Panel that holds the guests score
	JLabel guestWinsLabel = new JLabel("Guest Wins"); 	 // Label that reads "Guest Wins"
	JLabel guestScoreLabel = new JLabel("0");			 // Label that displays guest score
	JPanel dealerWinsPanel = new JPanel(); 				 // Panel that holds the dealers score
	JLabel dealerWinsLabel = new JLabel("Dealer Wins");  // Label that reads "Dealer Wins"
	JLabel dealerScoreLabel = new JLabel("0"); 			 // Label that displays dealers score
	JPanel leftButtonPanel = new JPanel(); 				 // Holds Start Game and Deal Guest buttons
	JPanel rightButtonPanel = new JPanel(); 			 // Holds Leave Table and Deal Dealer buttons

	// Constructor
	public TwentyOneGUI() {
		// Set Title
		this.setTitle("TwentyOne Game Table");
		// Set Sizes and Locations
		this.setSize(400, 600); 	  // Set size of the game table frame
		this.setLayout(new BorderLayout());
		this.setLocation(1100, 100);
		scoreBoard.setSize(500, 200); // Set size of the score board
		scoreBoard.setLocation(550, 500);
		// Set default close operation
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		scoreBoard.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Format and add the banner to display the winner
		// Put the banner in a JPanel so that the background color can be set
		declareWinner.setHorizontalAlignment(JLabel.CENTER);
		declareWinnerPanel.setBackground(Color.GREEN);
		declareWinnerPanel.add(declareWinner);
		this.add(declareWinnerPanel, BorderLayout.NORTH);

		//
		// The Following is for
		// For the Score Board Frame
		//

		// Create and format the score board
		scoreBoard.setTitle("Score Board");
		scoreBoard.setLayout(new GridLayout(2, 2)); // 2x2 layout, top quandrants are for the
													// scores, bottom quadrants are for buttons

		// Format the "Guest Wins" and "Dealer wins" section
		// Configure Labels
		guestWinsLabel.setHorizontalAlignment(JLabel.CENTER);
		dealerWinsLabel.setHorizontalAlignment(JLabel.CENTER);
		guestScoreLabel.setHorizontalAlignment(JLabel.CENTER);
		dealerScoreLabel.setHorizontalAlignment(JLabel.CENTER);
		// Configure Panels
		guestWinsPanel.setLayout(new GridLayout(2, 1));
		guestWinsPanel.setBackground(Color.MAGENTA);
		guestWinsPanel.add(guestWinsLabel);
		guestWinsPanel.add(guestScoreLabel);
		dealerWinsPanel.setLayout(new GridLayout(2, 1));
		dealerWinsPanel.setBackground(Color.CYAN);
		dealerWinsPanel.add(dealerWinsLabel);
		dealerWinsPanel.add(dealerScoreLabel);

		// Add components to the score board
		leftButtonPanel.setLayout(new GridLayout(2, 1));
		rightButtonPanel.setLayout(new GridLayout(2, 1));
		scoreBoard.add(guestWinsPanel);
		scoreBoard.add(dealerWinsPanel);
		leftButtonPanel.add(startGameButton);
		leftButtonPanel.add(dealGuestCardsButton);
		rightButtonPanel.add(leaveTableButton);
		rightButtonPanel.add(dealDealerCardsButton);
		scoreBoard.add(leftButtonPanel);
		scoreBoard.add(rightButtonPanel);

		// Add hands panels
		this.add(handsPanel, BorderLayout.CENTER); // Adds the overall
		handsPanel.setLayout(new GridLayout(1, 2)); // Sets two columns
		handsPanel.add(guestHandPanel); // Add guest panel
		handsPanel.add(dealerHandPanel); // Add dealer panel

		//
		// GUI IS COMPLETED
		//

		// Deal card buttons are disabled at the beginning of the program until
		// the game is start
		dealGuestCardsButton.setEnabled(false);
		dealDealerCardsButton.setEnabled(false);

		// Add button listeners
		leaveTableButton.addActionListener(new LeaveTableButtonListener());
		startGameButton.addActionListener(new StartGameButtonListener());
		dealGuestCardsButton
				.addActionListener(new DealGuestCardsButtonListener());
		dealDealerCardsButton
				.addActionListener(new DealDealerCardsButtonListener());

		// Finally, set visible
		scoreBoard.setVisible(true);
		this.setVisible(true);

	}

	// Start Game private inner class button Listener
	private class StartGameButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Instantiate new Deck, Guest, and Dealer objects

			theDeck = new Deck(); 		  // Creates a new deck
			theDeck.shuffle();
			guest = new Guest(theDeck);   // Creates a guest object
			dealer = new Dealer(theDeck); // Creates dealer object using the
										  // same deck

			dealGuestCardsButton.setEnabled(true);  // Enables the user to deal
													// themselves cards
			declareWinner.setText("Good Luck!");    // Sets the message to good
													// luck!

			guestHandPanel.setEmptyHand();
			dealerHandPanel.setEmptyHand();
		}
	}//End Listener

	// Deal Guest Cards button listener
	private class DealGuestCardsButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			guestHandPanel.clearEmpties();
			guest.play(); // The guest plays and gets all of his cards
			guestHandPanel.displayHand(guest);

			guestHandPanel.setPlayerSum(guest.valueOf());
			if (guest.valueOf() < 21) { // If the player did not bust right away
				dealGuestCardsButton.setEnabled(false);
				dealDealerCardsButton.setEnabled(true);
			} else if (guest.valueOf() >= 21) { // If the player busts right
												// away
				declareWinner.setText("Guest Bust => Dealer Wins!");

				dealGuestCardsButton.setEnabled(false);
				dealDealerCardsButton.setEnabled(false);

				dealerPoints++; // Give the dealer a point
				dealerScoreLabel.setText(dealerPoints + ""); // Update his
																// points on the
																// label

			}
		}
	}//End Listener

	// Deal Dealer Cards button listener
	private class DealDealerCardsButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dealerHandPanel.clearEmpties();
			dealer.play();
			dealerHandPanel.displayHand(dealer);

			dealerHandPanel.setPlayerSum(dealer.valueOf());	
			if (dealer.valueOf() < 21) { 	//If the dealer does not bust, points are compared and the winner receives his point.
				
				//Compare the points
				if (dealer.valueOf() == guest.valueOf()){
					//If their points equal, the game is "Pushed"
					declareWinner.setText("Game Pushed");
					//Both players receive points in a draw
					guestPoints++; // Give the dealer a point
					guestScoreLabel.setText(guestPoints + ""); // Update his
																// points on the
																// label
					dealerPoints++; // Give the dealer a point
					dealerScoreLabel.setText(dealerPoints + ""); // Update his
																	// points on the
																	// label
					dealGuestCardsButton.setEnabled(false);
					dealDealerCardsButton.setEnabled(false);
				}
				else if (dealer.valueOf() > guest.valueOf()){
					//Dealer wins, dealer gets point
					declareWinner.setText("Dealer Wins");
					dealerPoints++;
					dealerScoreLabel.setText(dealerPoints + "");
					dealGuestCardsButton.setEnabled(false);
					dealDealerCardsButton.setEnabled(false);
				}
				else if (guest.valueOf() > dealer.valueOf()){
					//Guest wins, guest gets point
					declareWinner.setText("Guest Wins");
					guestPoints++;
					guestScoreLabel.setText(guestPoints + "");
					dealGuestCardsButton.setEnabled(false);
					dealDealerCardsButton.setEnabled(false);
				}
				
				
			
			
			} else if (dealer.valueOf() >= 21) { //If the dealer does bust, guest receives points
				declareWinner.setText("Dealer Bust => Guest Wins!");

				dealGuestCardsButton.setEnabled(false);
				dealDealerCardsButton.setEnabled(false);

				guestPoints++; // Give the dealer a point
				guestScoreLabel.setText(guestPoints + ""); // Update his
															// points on the
															// label
			}
		}
	}//End Listener
		
	// Leave table button listener
		private class LeaveTableButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		}

	}//End Listener

