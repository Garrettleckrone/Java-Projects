import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;

public class Tiles extends JButton  implements Serializable { //<- start here...
	private String symbol;
	private Color BGColor,FGColor;
	boolean Clicked = false;
	
	public Tiles(String s,Color bg,Color fg){
	
		symbol = s;
		BGColor = bg;
		FGColor = fg;
		
	setText(symbol);
	setBackground(BGColor);
	setForeground(FGColor);
			
	}	public String getSymbol() {
		return symbol;
	}
	
	public void setSymbol(String s) {
		symbol = s;
		setText(symbol);
	}
	public Color getBGColor() {
		return BGColor;
	}
	public void setBGColor(Color bGColor) {
		BGColor = bGColor;
		setBackground(BGColor);
	}
	public Color getFGColor() {
		return FGColor;
	}
	public void setFGColor(Color fGColor) {
		FGColor = fGColor;
		setForeground(FGColor);
		
	}
	
}
