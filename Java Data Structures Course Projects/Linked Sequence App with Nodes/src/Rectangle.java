
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
		return ("rectangle: width " + width + ", length " + length);
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
