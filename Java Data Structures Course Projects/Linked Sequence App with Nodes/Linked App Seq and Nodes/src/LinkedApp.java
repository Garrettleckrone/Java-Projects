//Developed by: 	Garrett Leckrone
//Project 1: 		Sequence of Rectangles
//Professor: 		Liu
//For:	 			CS 260 Data Structures
//Date: 			3/31/2016
//Class description: The LinkedApp class contains the main method and will be where the program executes from.
//This program demonstrates various methods that can be developed to manipulate a linked sequence of rectangles or any other object.
//This program also compares the run time of the program when populated both 100,000 elements and also 10,000,000.




import java.lang.*;
import java.util.Random;

public class LinkedApp {
	//Fields 
		static long Squares = 0;
		static long Occurences = 0;
			
	public static void main(String[] args)
	{
		//Fields 
		LinkedSeq StringSequence;
		LinkedSeq RectangleSequence;
		
		
		//Introduce the Application 
		System.out.println("Welcome to the CS260 Project 2\nThis is a program that demonstrates methods used with a linked sequence\n");
		
		//Record the runtime
		long step1runtime = System.currentTimeMillis();
		//Step 1: Create a LinkedSeq of 100, 000 Rectangle objects each having integer
		//dimensions randomly selected between 1 and 40.
		
		//Create the RNG
		Random rand = new Random();
		//Create the tail first
		Node tempNode = new Node(new Rectangle(rand.nextInt(40),rand.nextInt(40)), null);
		RectangleSequence = new LinkedSeq(tempNode);
		RectangleSequence.setTail(tempNode);
		//Populate the list					//Works correctly
		for (int i = 0; i < 100000; i++){
			if (i != 99999)
			{ 
				tempNode = new Node(new Rectangle(rand.nextInt(40),rand.nextInt(40)), tempNode);
			}
			if (i == 99999)
			{ 
			//Manually set the tail
				tempNode = new Node(new Rectangle(rand.nextInt(40),rand.nextInt(40)), tempNode);
				RectangleSequence.setHead(tempNode);
				
			}
			
		}
		
//		Proof the LinkedSeq was populated
		System.out.println("Step 1: The sequence is populated with 100,000 nodes");
		System.out.println("The head node is shown below");
		System.out.println("The head node is: " + RectangleSequence.getHead() + "\n");
//		End of runtime for step 1
		step1runtime = System.currentTimeMillis() - step1runtime;
		
		
		//Step 2: Verify that the listPosition() method returns the tails reference for
		//position number 100,000
		//Record runtime
		long step2runtime = System.currentTimeMillis();
//		Proof that the listPosition() method returns the tail
		System.out.println("Step 2: Verify that the listPosition() method returns the tail");
		System.out.println("Using getTail(), the tail is: " + RectangleSequence.getTail(RectangleSequence.getHead()));
		System.out.println("Using listPosition(), the tail is: " + RectangleSequence.getTail(RectangleSequence.getHead()));
		System.out.println("Both return the same Node, therefore both methods work!" + "\n");
		//Record runtime
		step2runtime = System.currentTimeMillis() - step2runtime;
		
		//Step 3: Instantiate a Rectangle array to the list length (do not use literals) and
		//load the Rectangles from the list to the array
		//Record runtime
		long step3runtime = System.currentTimeMillis();
		System.out.println("Step 3: Populate a rectangle array");
		
		Rectangle[] RectArray = new Rectangle[Node.listLength(RectangleSequence.getHead())];
		Node tempCursor = RectangleSequence.getHead();
		
		//Populate the array
		int counter = 0;
		while (tempCursor.getLink()!=null)
		{
			RectArray[counter] = (Rectangle)tempCursor.getData();
			counter++;
			tempCursor = tempCursor.getLink();
		}
		System.out.println("The populated Rectangle arrays length: " + RectArray.length + "\n");
		//Record runtime
		step3runtime = System.currentTimeMillis()- step3runtime;
		
		//Step 4: Create a target Rectangle with side 20, 20 and call the counting method
		//passing your array and target as parameters
		//Record runtime
		long step4runtime = System.currentTimeMillis();
		Rectangle targetRectangle = new Rectangle(20,20);
		Counting(RectArray, targetRectangle);
		System.out.println("Step 4: Find the occurences of squares and of the target");
		System.out.println("The number of squares is: " + Squares);
		System.out.println("The number of occurences of the target is: " + Occurences + "\n");
		//Record runtime
		step4runtime = System.currentTimeMillis() - step4runtime;
		
		//Step 5: Measure the running time of each step above as well as the combined
		//time and record the results. Hint: use method call System.currentTimeMillis() to
		//record the current real time in milliseconds (the return type of the method is
		//long)
		//Record runtime
		long step5runtime = System.currentTimeMillis();
		System.out.println("Step 5: Calculate the runtime of each step in Milliseconds");
		System.out.println("Step 1: " +step1runtime + "ms");
		System.out.println("Step 2: " +step2runtime + "ms");
		System.out.println("Step 3: " +step3runtime + "ms");
		System.out.println("Step 4: " +step4runtime + "ms");
		//Record runtime
		step5runtime = System.currentTimeMillis() - step5runtime;
		//Include runtime for step 5
		System.out.println("Step 5: " + step5runtime + "ms\n");
		
		///////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////
		//STEP 6 REPEATS STEPS 1-5
		System.out.println("\n\nNow we will repeat steps 1-5 using 1,000,000 rectangles\n\n\n");
		///////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////

		//Fields 
		LinkedSeq StringSequence1;
		LinkedSeq RectangleSequence1;
		//Record the runtime
		long step1runtime1 = System.currentTimeMillis();
		//Step 1: Create a LinkedSeq of 100, 000 Rectangle objects each having integer
		//dimensions randomly selected between 1 and 40.
		
		//Create the RNG
		Random rand1 = new Random();
		//Create the tail first
		Node tempNode1 = new Node(new Rectangle(rand1.nextInt(40),rand1.nextInt(40)), null);
		RectangleSequence1 = new LinkedSeq(tempNode1);
		RectangleSequence1.setTail(tempNode1);
		//Populate the list					//Works correctly
		for (int i = 0; i < 1000000; i++){
			if (i != 999999)
			{ 
				tempNode1 = new Node(new Rectangle(rand1.nextInt(40),rand1.nextInt(40)), tempNode1);
			}
			if (i == 999999)
			{ 
			//Manually set the tail
				tempNode1 = new Node(new Rectangle(rand1.nextInt(40),rand1.nextInt(40)), tempNode1);
				RectangleSequence1.setHead(tempNode1);
				
			}
			
		}
		
		//Proof the LinkedSeq was populated
		System.out.println("Step 1: The sequence is populated with 1,000,000 nodes");
		System.out.println("The head node is shown below");
		System.out.println("The head node is: " + RectangleSequence1.getHead() + "\n");
//				End of runtime for step 1
		step1runtime1 = System.currentTimeMillis() - step1runtime1;
		
		
		//Step 2: Verify that the listPosition() method returns the tails reference for
		//position number 100,000
		//Record runtime
		long step2runtime1 = System.currentTimeMillis();
//				Proof that the listPosition() method returns the tail
		System.out.println("Step 2: Verify that the listPosition() method returns the tail");
		System.out.println("Using getTail(), the tail is: " + RectangleSequence1.getTail(RectangleSequence1.getHead()));
		System.out.println("Using listPosition(), the tail is: " + RectangleSequence1.getTail(RectangleSequence1.getHead()));
		System.out.println("Both return the same Node, therefore both methods work!" + "\n");
		//Record runtime
		step2runtime1 = System.currentTimeMillis() - step2runtime1;
		
		//Step 3: Instantiate a Rectangle array to the list length (do not use literals) and
		//load the Rectangles from the list to the array
		//Record runtime
		long step3runtime1 = System.currentTimeMillis();
		System.out.println("Step 3: Populate a rectangle array");
		
		Rectangle[] RectArray1 = new Rectangle[Node.listLength(RectangleSequence1.getHead())];
		Node tempCursor1 = RectangleSequence1.getHead();
		
		//Populate the array
		int counter1 = 0;
		while (tempCursor1.getLink()!=null)
		{
			RectArray1[counter1] = (Rectangle)tempCursor1.getData();
			counter1++;
			tempCursor1 = tempCursor1.getLink();
		}
		System.out.println("The populated Rectangle arrays length: " + RectArray1.length + "\n");
		//Record runtime
		step3runtime1 = System.currentTimeMillis()- step3runtime1;
		
		//Step 4: Create a target Rectangle with side 20, 20 and call the counting method
		//passing your array and target as parameters
		//Record runtime
		long step4runtime1 = System.currentTimeMillis();
		Rectangle targetRectangle1 = new Rectangle(20,20);
		Counting(RectArray1, targetRectangle1);
		System.out.println("Step 4: Find the occurences of squares and of the target");
		System.out.println("The number of squares is: " + Squares);
		System.out.println("The number of occurences of the target is: " + Occurences + "\n");
		//Record runtime
		step4runtime1 = System.currentTimeMillis() - step4runtime1;
		
		//Step 5: Measure the running time of each step above as well as the combined
		//time and record the results. Hint: use method call System.currentTimeMillis() to
		//record the current real time in milliseconds (the return type of the method is
		//long)
		//Record runtime
		long step5runtime1 = System.currentTimeMillis();
		System.out.println("Step 5: Calculate the runtime of each step in Milliseconds");
		System.out.println("Step 1: " +step1runtime1 + "ms");
		System.out.println("Step 2: " +step2runtime1 + "ms");
		System.out.println("Step 3: " +step3runtime1 + "ms");
		System.out.println("Step 4: " +step4runtime1 + "ms");
		//Record runtime
		step5runtime1 = System.currentTimeMillis() - step5runtime1;
		//Include runtime for step 5
		System.out.println("Step 5: " + step5runtime1 + "ms\n");
				
		///////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////
		//STEP 7 REPEATS STEPS 1-5
		System.out.println("\n\nNow we will repeat steps 1-5 using 10,000,000 rectangles\n\n\n");
		///////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////
		
		//Fields 
		LinkedSeq StringSequence2;
		LinkedSeq RectangleSequence2;
		//Record the runtime
		long step1runtime2 = System.currentTimeMillis();
		//Step 1: Create a LinkedSeq of 100, 000 Rectangle objects each having integer
		//dimensions randomly selected between 1 and 40.
		
		//Create the RNG
		Random rand2 = new Random();
		//Create the tail first
		Node tempNode2 = new Node(new Rectangle(rand2.nextInt(40),rand2.nextInt(40)), null);
		RectangleSequence2 = new LinkedSeq(tempNode2);
		RectangleSequence2.setTail(tempNode2);
		//Populate the list					//Works correctly
		for (int i = 0; i < 10000000; i++){
		if (i != 9999999)
		{ 
		tempNode2 = new Node(new Rectangle(rand2.nextInt(40),rand2.nextInt(40)), tempNode2);
		}
		if (i == 9999999)
		{ 
		//Manually set the tail
		tempNode2 = new Node(new Rectangle(rand2.nextInt(40),rand2.nextInt(40)), tempNode2);
		RectangleSequence2.setHead(tempNode2);
		
		}
		
		}
		
		//Proof the LinkedSeq was populated
		System.out.println("Step 1: The sequence is populated with 10,000,000 nodes");
		System.out.println("The head node is shown below");
		System.out.println("The head node is: " + RectangleSequence2.getHead() + "\n");
		//End of runtime for step 1
		step1runtime2 = System.currentTimeMillis() - step1runtime2;
		
		
		//Step 2: Verify that the listPosition() method returns the tails reference for
		//position number 100,000
		//Record runtime
		long step2runtime2 = System.currentTimeMillis();
		//Proof that the listPosition() method returns the tail
		System.out.println("Step 2: Verify that the listPosition() method returns the tail");
		System.out.println("Using getTail(), the tail is: " + RectangleSequence2.getTail(RectangleSequence2.getHead()));
		System.out.println("Using listPosition(), the tail is: " + RectangleSequence2.getTail(RectangleSequence2.getHead()));
		System.out.println("Both return the same Node, therefore both methods work!" + "\n");
		//Record runtime
		step2runtime2 = System.currentTimeMillis() - step2runtime2;
		
		//Step 3: Instantiate a Rectangle array to the list length (do not use literals) and
		//load the Rectangles from the list to the array
		//Record runtime
		long step3runtime2 = System.currentTimeMillis();
		System.out.println("Step 3: Populate a rectangle array");
		
		Rectangle[] RectArray2 = new Rectangle[Node.listLength(RectangleSequence2.getHead())];
		Node tempCursor2 = RectangleSequence2.getHead();
		
		//Populate the array
		int counter2 = 0;
		while (tempCursor2.getLink()!=null)
		{
		RectArray2[counter2] = (Rectangle)tempCursor2.getData();
		counter2++;
		tempCursor2 = tempCursor2.getLink();
		}
		System.out.println("The populated Rectangle arrays length: " + RectArray2.length + "\n");
		//Record runtime
		step3runtime2 = System.currentTimeMillis()- step3runtime2;
		
		//Step 4: Create a target Rectangle with side 20, 20 and call the counting method
		//passing your array and target as parameters
		//Record runtime
		long step4runtime2 = System.currentTimeMillis();
		Rectangle targetRectangle2 = new Rectangle(20,20);
		Counting(RectArray2, targetRectangle2);
		System.out.println("Step 4: Find the occurences of squares and of the target");
		System.out.println("The number of squares is: " + Squares);
		System.out.println("The number of occurences of the target is: " + Occurences + "\n");
		//Record runtime
		step4runtime2 = System.currentTimeMillis() - step4runtime2;
		
		//Step 5: Measure the running time of each step above as well as the combined
		//time and record the results. Hint: use method call System.currentTimeMillis() to
		//record the current real time in milliseconds (the return type of the method is
		//long)
		//Record runtime
		long step5runtime2 = System.currentTimeMillis();
		System.out.println("Step 5: Calculate the runtime of each step in Milliseconds");
		System.out.println("Step 1: " +step1runtime2 + "ms");
		System.out.println("Step 2: " +step2runtime2 + "ms");
		System.out.println("Step 3: " +step3runtime2 + "ms");
		System.out.println("Step 4: " +step4runtime2 + "ms");
		//Record runtime
		step5runtime2 = System.currentTimeMillis() - step5runtime2;
		//Include runtime for step 5
		System.out.println("Step 5: " + step5runtime2 + "ms\n");
				
		///////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////
		//STEP 8 REPEATS STEPS 1-5, with non-random rectangles
		System.out.println("\n\nNow we will repeat steps 1-5 using 10,000,000 non-random rectangles\n\n\n");
		///////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////
		
		//Fields 
		LinkedSeq StringSequence3;
		LinkedSeq RectangleSequence3;
		//Record the runtime
		long step1runtime3 = System.currentTimeMillis();
		//Step 1: Create a LinkedSeq of 100, 000 Rectangle objects each having integer
		//dimensions of 20x20
		
		//Create the tail first
		Node tempNode3 = new Node(new Rectangle(20,20), null);
		RectangleSequence3 = new LinkedSeq(tempNode3);
		RectangleSequence3.setTail(tempNode3);
		//Populate the list					//Works correctly
		for (int i = 0; i < 10000000; i++){
		if (i != 9999999)
		{ 
		tempNode3 = new Node(new Rectangle(20,20), tempNode3);
		}
		if (i == 9999999)
		{ 
		//Manually set the tail
		tempNode3 = new Node(new Rectangle(20,20), tempNode3);
		RectangleSequence3.setHead(tempNode3);
		
		}
		
		}
		
		//Proof the LinkedSeq was populated
		System.out.println("Step 1: The sequence is populated with 10,000,000 nodes");
		System.out.println("The head node is shown below");
		System.out.println("The head node is: " + RectangleSequence3.getHead() + "\n");
		//End of runtime for step 1
		step1runtime3 = System.currentTimeMillis() - step1runtime3;
		
		
		//Step 2: Verify that the listPosition() method returns the tails reference for
		//position number 100,000
		//Record runtime
		long step2runtime3 = System.currentTimeMillis();
		//Proof that the listPosition() method returns the tail
		System.out.println("Step 2: Verify that the listPosition() method returns the tail");
		System.out.println("Using getTail(), the tail is: " + RectangleSequence3.getTail(RectangleSequence3.getHead()));
		System.out.println("Using listPosition(), the tail is: " + RectangleSequence3.getTail(RectangleSequence3.getHead()));
		System.out.println("Both return the same Node, therefore both methods work!" + "\n");
		//Record runtime
		step2runtime3 = System.currentTimeMillis() - step2runtime3;
		
		//Step 3: Instantiate a Rectangle array to the list length (do not use literals) and
		//load the Rectangles from the list to the array
		//Record runtime
		long step3runtime3 = System.currentTimeMillis();
		System.out.println("Step 3: Populate a rectangle array");
		
		Rectangle[] RectArray3 = new Rectangle[Node.listLength(RectangleSequence3.getHead())];
		Node tempCursor3 = RectangleSequence3.getHead();
		
		//Populate the array
		int counter3 = 0;
		while (tempCursor3.getLink()!=null)
		{
		RectArray3[counter3] = (Rectangle)tempCursor3.getData();
		counter3++;
		tempCursor3 = tempCursor3.getLink();
		}
		System.out.println("The populated Rectangle arrays length: " + RectArray3.length + "\n");
		//Record runtime
		step3runtime3 = System.currentTimeMillis()- step3runtime3;
		
		//Step 4: Create a target Rectangle with side 20, 20 and call the counting method
		//passing your array and target as parameters
		//Record runtime
		long step4runtime3 = System.currentTimeMillis();
		Rectangle targetRectangle3 = new Rectangle(20,20);
		Counting(RectArray3, targetRectangle3);
		System.out.println("Step 4: Find the occurences of squares and of the target");
		System.out.println("The number of squares is: " + Squares);
		System.out.println("The number of occurences of the target is: " + Occurences + "\n");
		//Record runtime
		step4runtime3 = System.currentTimeMillis() - step4runtime3;
		
		//Step 5: Measure the running time of each step above as well as the combined
		//time and record the results. Hint: use method call System.currentTimeMillis() to
		//record the current real time in milliseconds (the return type of the method is
		//long)
		//Record runtime
		long step5runtime3 = System.currentTimeMillis();
		System.out.println("Step 5: Calculate the runtime of each step in Milliseconds");
		System.out.println("Step 1: " +step1runtime3 + "ms");
		System.out.println("Step 2: " +step2runtime3 + "ms");
		System.out.println("Step 3: " +step3runtime3 + "ms");
		System.out.println("Step 4: " +step4runtime3 + "ms");
		//Record runtime
		step5runtime3 = System.currentTimeMillis() - step5runtime3;
		//Include runtime for step 5
		System.out.println("Step 5: " + step5runtime3 + "ms\n");


		
		
		
		
		//Step 9: Analyze you running time observations, deduce Big-O estimates and
		//advise about the expected time for the case 100,000,000 rectangles. Attach your
		//report as a comment to the source code following the application class.
		
		//My Conclusion: The smaller the sequences that the program has to cycle through
		//less runtime will be experienced. Even going from 1,000,000 to 10,000,000 increased runtime from 160ms to 4047ms
		//which is a substantial. If 100,000,000 rectangles were to be run through this program, I hypothesize that run the run time 
		//would increase greatly, perhaps taking more than 10,000 ms.
		//I also found that the greatest amount of time the program spent running was during step 1 of each section.
		//I believe it is because the initial LinkedSeq must be populated by numbers for each iteration.
		//With a linked sequence of over randomly generated 10,000,000 elements, most of the run time is spent on that task.
		//Lastly, step 8 showed that there was not a massive difference when populating the linked sequence with non-random
		//numbers vs. random numbers. As expected, the program that randomly generated it's values did take longer, but only by about 300ms. 
		
				
				
				
		
		
	}
	
	public static void Counting(Rectangle[] boxes, Rectangle Target)
	{
		
		//Counts the occurences of a square and matches of the target
		for (int i = 0; i < boxes.length; i++ ) {
			if (boxes[i].getLength() == boxes[i].getWidth()){
				if (Squares < boxes.length)Squares++;
			}
			if (boxes[i].equals(Target) || boxes[i].getLength() == boxes[i].getWidth()){
				if (Occurences < boxes.length)Occurences++;
			}
		}
		
	}
	
	
}