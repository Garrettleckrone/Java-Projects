//Developed by: 	Garrett Leckrone
//Project 1: 		Sequence of Rectangles
//Professor: 		Liu
//For:	 			CS 260 Data Structures
//Date: 			3/31/2016
//Class description: The node class defines a Node with both data and a link to another Node. This will be used to link all of the data in our structure.

public class Node <T> {
	private T data;
	private Node link;
	
	public Node(T data, Node link)
	{
		this.data = data;
		this.link = link;
	}
	public Boolean isData()
	{
		if (data != null){
			return true;
		}
		else return false;
	}
	public T getData()
	{
		return data;
	}
	public Node getLink()
	{
		return link;
	}
	
	public void setLink(Node n)
	{
		link = n;
	}
	public Node addNodeAfter(Node newLink)
	{
		Node tempLink = this;
		newLink.setLink(tempLink.getLink());
		tempLink.setLink(newLink);
		return this;
	}
	
	public Node removeNodeAfter()
	{
		Node oldLink = link;
		link = null;
		return oldLink;
	}
	
	public String toString()
	{
		if ((isData() == true && link == null) || (isData() == true && link != null))
		{
			return data.toString() + " " ;
		}
		else return "null element";
	}
	
	public static Node listCopy(Node source)
	{
		Node copyHead;
		Node copyTail;
		
		if(source  == null)
			return null;
		
		copyHead = new Node(source.data, null);
		copyTail = copyHead;
		
		while (source.link != null)
		{
			source = source.link;
			copyTail = copyTail.addNodeAfter(source.link);
		}
		
		return copyHead;
	}
	
	public static Node listPosition(Node head, int position)
	{
		Node cursor = head;
		
		if (position <= 0)
			throw new IllegalArgumentException("Position is not positive.");
		
		for ( int i = 1; (i < position) && (cursor.link != null); i++)
		{
		cursor = cursor.link;
		}
		return cursor;
		
	}
	
	public static int listLength(Node head){
		Node cursor;
		int counter;
		
		counter = 0;
		for ( cursor = head; cursor.link != null; cursor = cursor.link){
			counter++;
		}
	
		return counter;
	}
	
	public static Node getTail(Node source){
		
		
		
		Node copyHead;
		Node copyTail;
		
		if(source  == null)
			return null;
		
		copyHead = new Node(source.data, null);
		copyTail = copyHead;
		
		while (source.link != null)
		{
			source = source.link;
			copyTail = copyTail.addNodeAfter(source.link);
		}
		
		return copyTail;
	}
	
}
