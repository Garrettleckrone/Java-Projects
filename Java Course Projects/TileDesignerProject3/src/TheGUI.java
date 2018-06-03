import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TheGUI extends JFrame {
	
	//Tiles_________________________________
	Tiles[][] tiles = new Tiles[9][9];
	
	
	//Listeners____________________________
	TileListener tileHandeler;
	
	//Colors________________________________
	JRadioButton black,red,white,green,blue,pink,cyan,magenta,gray,yellow,orange;
	JComboBox foregroundBox;
	String[] foregroundColor = {"Black","White","Green","Blue","Yellow","Red"};
	
	//Panels___________________________
	JPanel tilePanel;
	JPanel buttonsPanel;
	JPanel framePanel;
	JPanel colorsPanel;
	
	//Buttons_______________________________
	JFileChooser fc;
	
	
	
	
	public TheGUI(){
	setTitle("Title Designer");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(new BorderLayout());
	
	 try {
     UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
 } 
 catch (UnsupportedLookAndFeelException e) {
	 
 }
 catch (ClassNotFoundException e) {
	   
 }
 catch (InstantiationException e) {
    // handle exception
 }
 catch (IllegalAccessException e) {
    // handle exception
 }
	
	//Tiles
	tilePanel = new JPanel();
	
	tilePanel.setPreferredSize(new Dimension(800,800));
	tilePanel.setLayout(new GridLayout(9,9));
	for(int i = 0; i<tiles.length;i++){
    	  for(int j=0;j<tiles[i].length;j++){
    		  tiles[i][j] = new Tiles("O",Color.BLACK,Color.WHITE);
    		  tileHandeler = new TileListener(tiles[i][j]);
    		  //tiles[i][j].setSize(new Dimension(5,5));
    		  tiles[i][j].addActionListener(tileHandeler);
    		  tilePanel.add(tiles[i][j]);
    	  }}
    //Buttons Panel      
	colorsPanel = new JPanel();
	colorsPanel.setLayout(new BorderLayout());
	colorsPanel.add(ResetButton(), BorderLayout.NORTH);
	colorsPanel.add(FGColorPanelOne(), BorderLayout.EAST);
	colorsPanel.add(BGColorPanel(), BorderLayout.SOUTH);
	
	
ButtonPanel();

	add(tilePanel, BorderLayout.WEST);
	add(colorsPanel, BorderLayout.EAST);
	add(buttonsPanel, BorderLayout.SOUTH);
		
	
	pack();
	 setVisible(true);
	 }

	
	public JButton ResetButton(){
		JButton reset = new JButton("Reset");
		reset.addActionListener(new ResetButtonListener());
		
		reset.setMnemonic(KeyEvent.VK_R);
		
		reset.setToolTipText("Reset the GUI to default");
		
		return reset;
	}
	public void setToDefault(){
		  foregroundBox.setSelectedIndex(0);
		  white.doClick();
		for(int i = 0; i<tiles.length;i++){
	    	  for(int j=0;j<tiles[i].length;j++){
	    		  tiles[i][j].setFGColor(Color.WHITE);
	    		  tiles[i][j].setBGColor(Color.BLACK);
	    		  tiles[i][j].setText("O");
	    	  
	    	  }
		}	 
	    
	}
	public JPanel FGColorPanelOne()
	{
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("FG Color"));
		panel.setLayout(new GridLayout(5,2));
		black = new JRadioButton("Black");
		white = new JRadioButton("White");
		red = new JRadioButton("Red");
		green = new JRadioButton("Green");
		blue = new JRadioButton("Blue");
		pink = new JRadioButton("Pink");
		cyan = new JRadioButton("Cyan");
		magenta = new JRadioButton("Magenta");
		orange = new JRadioButton("Orange");
		yellow = new JRadioButton("Yellow");
		
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(black);
		bg.add(white);
		bg.add(red);
		bg.add(green);
		bg.add(blue);
		
		panel.add(black);
		panel.add(white);
		panel.add(red);
		panel.add(green);
		panel.add(blue);
		panel.add(pink);
		panel.add(cyan);
		panel.add(magenta);
		panel.add(orange);
		panel.add(yellow);
		
		
		return panel;
	}
	
	//Return the foreground color
	public Color FGColor()
	{
		Color selectedFGColor = null;
		
	if (black.isSelected())
		selectedFGColor = Color.BLACK;
	else if(white.isSelected())
		selectedFGColor = Color.WHITE;
	else if(red.isSelected())
		selectedFGColor = Color.RED;
	else if(green.isSelected())
		selectedFGColor = Color.GREEN;
	else if(blue.isSelected())
		selectedFGColor = Color.BLUE;
	else if (pink.isSelected())
		selectedFGColor = Color.PINK;
	else if(cyan.isSelected())
		selectedFGColor = Color.CYAN;
	else if(magenta.isSelected())
		selectedFGColor = Color.MAGENTA;
	else if(orange.isSelected())
		selectedFGColor = Color.ORANGE;
	else
		selectedFGColor = Color.YELLOW;
		
	return selectedFGColor;
		
	}
	
	public JPanel BGColorPanel()
	{
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("BG Color"));
		foregroundBox = new JComboBox(foregroundColor);
		panel.add(foregroundBox);
		
		return panel;
	}
	//Return the background color
	public Color BGColor()
	{	
	
		Color selectedFGColor = null;
		String FGselection = (String) foregroundBox.getSelectedItem();
		if(FGselection.equals("Black"))
			selectedFGColor = Color.BLACK;
		else if(FGselection.equals("Green"))
			selectedFGColor = Color.GREEN;
		else if(FGselection.equals("Yellow"))
			selectedFGColor = Color.YELLOW;
		else if(FGselection.equals("Red"))
			selectedFGColor = Color.RED;
		else if(FGselection.equals("Blue"))
			selectedFGColor = Color.BLUE;
		else if(FGselection.equals("White"))
			selectedFGColor = Color.WHITE;
		
		return selectedFGColor;
	}
	
	//Builds save, load, and exit  buttons, then adds them to the buttonsPanel
	public void ButtonPanel()
	{
		buttonsPanel = new JPanel();
			buttonsPanel.setLayout(new GridLayout(1,3));
			
		JButton save = new JButton("Save");
			save.addActionListener(new SaveButtonListener());
		JButton load = new JButton("Load");
			load.addActionListener(new LoadButtonListener());
		JButton exit = new JButton("Exit");
			exit.addActionListener(new ExitButtonListener());
			
			save.setMnemonic(KeyEvent.VK_S);
			load.setMnemonic(KeyEvent.VK_L);
			exit.setMnemonic(KeyEvent.VK_X);
			
			save.setToolTipText("Save the desgin");
			load.setToolTipText("Load a design");
			exit.setToolTipText("Leave!");
			
		buttonsPanel.add(save);
		buttonsPanel.add(load);
		buttonsPanel.add(exit);
	}
	
private class TileListener implements ActionListener{	
	Tiles t;
	public TileListener(Tiles tile){
		this.t = tile;
	}
	public void actionPerformed(ActionEvent e){	
    t = (Tiles) e.getSource();
		    
    		if(t.getSymbol().equals("O"))
		    t.setSymbol("X");
    		else if(t.getSymbol().equals("X"))
    		t.setSymbol(" ");
    		else if(t.getSymbol().equals(" "))
    		t.setSymbol("X");
    		
		    t.setBGColor(BGColor());
		    t.setFGColor(FGColor());
		  
	}
}

private class SaveButtonListener implements ActionListener{	
	public void actionPerformed(ActionEvent event){
	
		
	 try {
		 FileOutputStream f = new FileOutputStream("D4.til");
		 ObjectOutputStream ostream = new ObjectOutputStream(f);		 
		 for(int i = 0; i<tiles.length;i++){
  	    	  for(int j=0;j<tiles[i].length;j++){
  	    		  ostream.writeObject(tiles[i][j]);
  	    	  }}
	    ostream.close();
	     } catch (IOException e) {
	         e.printStackTrace();
	       
		}
		
		
	}
}
private class LoadButtonListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
		
		//Make a JFileChooser
		JFileChooser chooser = new JFileChooser();
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Tile file","til");
	    chooser.setFileFilter(filter);
	    int returnVal = chooser.showOpenDialog(null);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
			ObjectInputStream in;
			try {
			   in = new ObjectInputStream(new FileInputStream(chooser.getSelectedFile()));
			   
	             for(int i = 0; i<tiles.length;i++){
	   	    	  for(int j=0;j<tiles[i].length;j++){
	   	    		  Tiles newTiles =  (Tiles)in.readObject();
	   	    		//tilePanel.remove(tiles[i][j]);
	   	    		//tiles[i][j] = newTiles;
	             tiles[i][j].setSymbol(newTiles.getText());
	             tiles[i][j].setBGColor(newTiles.getBackground());
	             tiles[i][j].setFGColor(newTiles.getForeground());
//	             tilePanel.add(tiles[i][j]);
	   	    		tiles[i][j].repaint();
	             
	   	    	  }}
	             tilePanel.validate();
	             in.close();
	         } catch (Exception a) {
	             a.printStackTrace();
	         }
			
	    }
		
		
		
		
     }
			
	
	
}
private class ExitButtonListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
		
		System.exit(0);
	}
	
}
private class ResetButtonListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
		
			setToDefault();
	}
}
	
public static void main(String[] arg)
{
	TheGUI t = new TheGUI();
//	t.setToDefault();
}
}
