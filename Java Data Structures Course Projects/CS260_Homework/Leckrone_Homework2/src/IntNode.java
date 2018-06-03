/* Class Name: IntNode
 * Developer: Garrett Leckrone
 * 
 * Class Description:
 * 
 * 
 * 
 */
public class IntNode
{
	private int data;          //integer value 
	private IntNode link;      //next node in the list
	
	public IntNode(int data, IntNode link)
	{
		this.data = data;
		this.link = link;
	}
	
	
	//returns the value of data
	public int getData()
	{
		return data;
	}
	
	//returns the value link
	public IntNode getLink()
	{
		return link;
	}
	
	//sets the value of data
	public void setData(int data)
	{
		this.data = data;
	}
	
	//sets the value of link
	public void setLink(IntNode link)
	{
		this.link = link;
	}
	
}