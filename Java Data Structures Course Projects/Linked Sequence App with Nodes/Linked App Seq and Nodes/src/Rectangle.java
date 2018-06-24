//Developed by: 	Garrett Leckrone
//Project 1: 		Sequence of Rectangles
//Professor: 		Liu
//For:	 			CS 260 Data Structures
//Date: 			3/31/2016
//Class description: The Rectangle class defines the Rectangle object that will be used to populate the linked sequence in the LinkedApp class.


public class Rectangle 
{
	private int width;
	private int length;
	
	public Rectangle(int length, int width)
	{
		this.width = width;
		this.length = length;
	}
	
	public String toString()
	{
		return ("Rectangle: Width = " + width + ", Length = " + length);
	}
	
	public int getLength()
	{
		return length;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	
	public boolean equals(Object o)
	{
		if (o.getClass() != this.getClass())
		{
			return false;
		}
		
		Rectangle other = (Rectangle) o;
		
		if(other.getLength() == length && other.getWidth() == width)
		{
			return true;
		}
		return false;
	}

}
