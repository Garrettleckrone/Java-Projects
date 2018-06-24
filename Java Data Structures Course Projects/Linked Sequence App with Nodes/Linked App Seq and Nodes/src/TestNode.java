//Developed by: 	Garrett Leckrone
//Project 1: 		Sequence of Rectangles
//Professor: 		Liu
//For:	 			CS 260 Data Structures
//Date: 			3/31/2016
//Class description: The TestNode class does not run when the program is executed, and is therefore commented out.

//public class TestNode {
//
//	//This is a class used to test all methods in the node class
//	public static void main(String[] args){
//		
//		//Create three-node long lists of String type
//		//I will test with 2 lists
//		
//		//Populate the first list
//		Node A = new Node("Abacus", null);
//		Node B = new Node("Broadband", A);
//		Node C = new Node("Centurian", B);
//		LinkedSeq FirstSeq = new LinkedSeq(C);
//		
//		//Populate the second list
//		Node X = new Node("Xenocide", null);
//		Node Y = new Node("Ypsilon" , X);
//		Node Z = new Node("Zebra", Y);
//		LinkedSeq SecondSeq = new LinkedSeq (Z);
//		
//		
//		//Test the addNodeAfter method
//		Node D = new Node("Durango", null);
//		D.addNodeAfter(B);
//		SecondSeq.displayList();
//		
//		//Test the ToString
//		System.out.println(A);
//		
//		//Test the listCopy
//		Node newList = Node.listCopy(B);
//		System.out.println(newList);
//		
//		//Test the listPosition
//		Node aNode = Node.listPosition(C, 1);
//		System.out.println(aNode);
//		
//		//Test the getTail
//		System.out.println(Node.getTail(A));
//		
//		
//	}
//}
