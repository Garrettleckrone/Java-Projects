/*Garrett Leckrone
CS161 Project 1*/

import javax.swing.JFrame;

public class LoanCalculateGUI extends JFrame {
	/*
	 * Constructor
	 */
	public LoanCalculateGUI() {

		// Fields
		final int WINDOW_HEIGHT = 500;
		final int WINDOW_WIDTH = 600;

		// Set title
		setTitle("Auto Loan Calculator");

		// Set size
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		// Set default close operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Add CombinedPanels object to the Frame
		this.add(new CombinedPanels());

		// Set visible to true
		setVisible(true);

	}
}
