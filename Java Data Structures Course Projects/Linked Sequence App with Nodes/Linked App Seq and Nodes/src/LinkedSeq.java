//Developed by: 	Garrett Leckrone
//Project 1: 		Sequence of Rectangles
//Professor: 		Liu
//For:	 			CS 260 Data Structures
//Date: 			3/31/2016
//Class description: The LinkedSeq class is used to define and manipulate a sequence of nodes by storing the Head node, the Tail node, and utilizing a cursor to traverse the structure
//This class also holds methods that are required for using the Linked Sequence.

public class LinkedSeq <T> {

	//Fields
	private Node head;			//
	private Node tail;			//
	private Node cursor;		//
	private Node precursor;		//
	
	//Constructor
	public LinkedSeq(Node head)
	{
		this.head = head;
		cursor = head;		//Initialize as head
		precursor = head;
		tail = head;
	}

	
	public void setTail(Node T)
	{
		tail = T;
	}
	public Node getTail()
	{
		return tail;
	}
	public Node getTail(Node head){
		 
		Node tempCursor = head;
		while ( tempCursor.getLink() != null){
			tempCursor = tempCursor.getLink();
		}
		return tempCursor;
	}
	public void setHead(Node H)
	{
		head = H;
	}
	public Node getHead()
	{

		
		return head;
	}
	
	//Add After
	public Node addAfter(T data)
	{
		Node tempNode = new Node(data, cursor.getLink());
		precursor.setLink(tempNode);
		cursor = tempNode;		//Sets the newly added node as the cursor
		return tempNode;
	}
	//addBefore
	public Node addBefore(T data)
	{
		Node tempNode = new Node(data, precursor.getLink());
		tempNode.setLink(cursor);
		cursor = tempNode;
		return tempNode;
	}
	public void addAll(LinkedSeq other)
	{
	//First check other
		if (other.head == null || other == null)
		{
			return;
		}
		if (this.head == null){		//If the calling Seq is empty
			this.setHead(other.head); 
			this.setTail(other.tail);
		}
	//If neither sequence is empty
		tail.setLink(other.getHead());
		tail = other.getTail();
	}
	public void advance()
	{
		//If the cursor is null
		if (cursor == null)
		{
			cursor = head;
		}
		//If the cursor is the tail
		if (cursor == tail)
		{
			cursor = null;
		}
		//If cursor is not null and not the tail
		precursor = cursor;
		cursor = cursor.getLink();
	}
	
	public LinkedSeq clone() throws OutOfMemoryError
	{
		LinkedSeq tempSeq = new LinkedSeq(this.getHead());
		Node tempCursor = this.getHead();
		
		do{
			tempSeq.addAfter(tempCursor.getLink());
			tempCursor = tempCursor.getLink();
			
		}while(tempCursor != this.getTail());
		
		return tempSeq;
	}
	
	public static LinkedSeq concatenate(LinkedSeq firstSeq, LinkedSeq secondSeq)
	{
		LinkedSeq newLS= new LinkedSeq(Node.listCopy(firstSeq.getHead()));
		newLS.addAll(secondSeq);
		
		return newLS;
		
	}
	
	public Node removeCurrent() throws IllegalStateException
	{
		Node tempNode =  cursor;
		//If the head is removed
		if (cursor == null)
		{
			throw  new IllegalStateException("No selected element");
		}
		if (cursor == head)
		{
			precursor = cursor.getLink();
			cursor = head.getLink(); 
			return tempNode;
		}
		//Update cursor
		cursor = precursor;		
		return tempNode; 
		
	}
	public void displayList() throws NullPointerException
	{
		Node tempCursor = head;
//		do {
//			//Prints the nodes to the console using the toString method
//			System.out.println((Node)tempCursor);
//			//Select next element
//			tempCursor = tempCursor.getLink();
//		} while (tempCursor.isData() != null);
		
		while (tempCursor != tail)
		{
			//Prints the nodes to the console using the toString method
			System.out.println(tempCursor);
			//Select next element
			tempCursor = tempCursor.getLink();
		}
		System.out.println(tail);
		
	}
	public Boolean isCurrent()
	{
		if (cursor != null)
		{return true;}
		else if (cursor == null)
		{return false;}
		else return false;
	}
	public Node getCurrent()throws IllegalStateException
	{
		if (isCurrent() == true) 
			return cursor;
		else 
			throw new IllegalStateException("There is no selected element");
		
	}
	public void start()
	{
		//If the list is populated, sets the cursor to the Head of the sequence
		if (head != null)
		{
			cursor = head;
		}
	}

}
