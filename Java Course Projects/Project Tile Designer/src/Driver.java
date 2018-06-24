import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Driver {
	JFrame frame;
	JPanel framePanel;
	Container cp;
	JPanel frameP, buttons;
	JButton tile;
	public Driver(){
		// TODO Auto-generated method stub
		
		
		frame = new JFrame("Test");
		frame.setLayout(new BorderLayout());
		//cp = frame.getContentPane();
		
		framePanel = new JPanel();
		tile = new JButton("X");
		tile.addActionListener(new TileActionListener());
		JButton save = new JButton("Save");
		save.addActionListener(new SaveButtonListener());
		JButton load = new JButton("Load");
		load.addActionListener(new LoadButtonListener());
		
		buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		buttons.add(save);
		buttons.add(load);
		
		framePanel.add(tile);
		frame.add(framePanel);
		frame.add(buttons, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setVisible(true);

}
	class TileActionListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			JButton button = (JButton) event.getSource();
			button.setForeground(Color.RED);
			button.setBackground(Color.GREEN);
			button.setText("O");
	}
	}	
	class SaveButtonListener implements ActionListener{	
		public void actionPerformed(ActionEvent event){
		
			
		 try {
			 FileOutputStream f = new FileOutputStream("myfile.dat");
			 ObjectOutputStream ostream = new ObjectOutputStream(f);		 
			ostream.writeObject((Object)tile);
		    ostream.close();
		     } catch (IOException e) {
		         e.printStackTrace();
		       
			}
			
			
		}
	}
	 class LoadButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			 try {
	             XMLDecoder d = new XMLDecoder(new BufferedInputStream(new FileInputStream("Test.xml")));
	             Object result = d.readObject();
	             framePanel.remove(tile);
	             tile = (JButton) result;
	             framePanel.add(tile);
	             framePanel.validate();
	             d.close();
	         } catch (IOException a) {
	             a.printStackTrace();
	         }
	     }
				
		
		
	
}	
	public static void main(String[] arg){
		new Driver();
	}
}
