import javax.swing.*;
import java.awt.*;

/* 
/This is Part A for lab 3 which creates only the GUI.
*/

public class ConversionCalculator extends JFrame{
	
	private final int WINDOW_WIDTH = 600;
	private final int WINDOW_HEIGTH = 150;
	
	
	public ConversionCalculator(){
		
		//
		//Create Frame
		//
		JFrame frame = new JFrame("Conversion Calculator");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setBounds(500, 500, WINDOW_WIDTH, WINDOW_HEIGTH); //Window opens with top left corner at (500,500)
		frame.setLayout(new GridLayout(1,3));
		
		//
		//Creates 3 panels, one in each column
		//
		JPanel panel1 = new JPanel();	//Panel 1
		JPanel panel2 = new JPanel();	//Panel 2
		JPanel panel3 = new JPanel();	//Panel 3
		
		frame.add(panel1);				//Adds panels to frame
		frame.add(panel2);
		frame.add(panel3);
		
		//SetLayouts
		panel1.setLayout(new GridLayout(2,2));	//2x2 grid for panel 1	
		panel2.setLayout(new GridLayout(2,2));	//2x2 grid for panel 2
		panel3.setLayout(new GridLayout(3,1));	//3x1 grid for panel 3 for buttons
	
		//
		//Panel 1 and 2
		//
		TextField centimetersTextField = new TextField("0.00"); //Creates all 4 text Fields
		TextField metersTextField 	   = new TextField("0.00");
		TextField inchesTextField	   = new TextField("0.00");
		TextField yardsTextField       = new TextField("0.00");
		
		JLabel centimetersLabel = new JLabel("Centimeters");
		JLabel metersLabel = new JLabel("Meters");
		JLabel inchesLabel = new JLabel("Inches");
		JLabel yardsLabel = new JLabel("Yards");
		
		//Add components to panel 1
		panel1.add(centimetersLabel);		//Centimeters
		panel1.add(centimetersTextField);
		panel1.add(metersLabel);			//Meters
		panel1.add(metersTextField);
		
		//Add components to panel 2
		panel2.add(inchesLabel);		//Inches
		panel2.add(inchesTextField);
		panel2.add(yardsLabel);			//Yards
		panel2.add(yardsTextField);
		
		
		
		
		//
		//Panel 3
		//
		JButton clearButton = new JButton("Clear");	//Creates buttons for panel 3
		JButton calculateButton = new JButton("Calculate");
		JButton exitButton = new JButton("Exit");
		
		panel3.add(clearButton);		//Adds buttons to panel 3
		panel3.add(calculateButton);
		panel3.add(exitButton);
		
		
		
		
		
	}
	
	
}