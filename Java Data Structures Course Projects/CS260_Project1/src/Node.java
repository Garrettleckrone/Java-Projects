
public class Node <T> {
	private T data;
	private Node link;
	
	public Node(T data, Node link)
	{
		this.data = data;
		this.link = link;
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
		Node oldLink = link;
		link = newLink;
		return oldLink;
	}
	
	public Node removeNodeAfter()
	{
		Node oldLink = link;
		link = null;
		return oldLink;
	}
	
	public String toString()
	{
		return data.toString() + "/n" + link.toString();
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
		Node cursor;
		int i;
		
		if (position <= 0)
			throw new IllegalArgumentException("Position is not positive.");
		
		cursor = head;
		for ( i = 1; (i < position) && (cursor != null); i++)
		{
		cursor = cursor.link;
		}
		return cursor;
		
	}
	
	public static int listLength(Node head){
		Node cursor;
		int answer;
		
		answer = 0;
		for ( cursor = head; cursor != null; cursor = cursor.link){
			answer++;
		}
	
		return answer;
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
