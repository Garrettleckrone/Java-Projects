
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
		
		tail = Node.getTail(head);
	}
	public void setTail(Node T)
	{
		tail = T;
	}
	public Node getTail()
	{
		return tail;
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
	
	public Node removeCurrent()
	{
		Node tempNode =  cursor;
		if (cursor == head)
		{
			precursor = cursor.getLink();
			cursor = head.getLink(); 
			return tempNode;
		}
		
		cursor = precursor;
		precursor = 
				
		while 
		
		
		
		
	}
	

}
