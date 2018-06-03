//Student : Garrett Leckrone
//Class : CS260
//Project 3
//Description: This project helps in understanding the various implementations of different sorting techniques such as 
//insertionSort and MergeSort using both linked lists and arrays to test. 

public class Node {
	
	//Fields
	 Node link;
	 int counter = 0;
	 int data;

	//Constructor
	public Node(int data){
		this.data = data; 
	}
	public Node(Node link){
		this.link = link;
	}
	public Node(){};
	
	//toString
	public String toString(){
		return data + "";
	}
	
}


