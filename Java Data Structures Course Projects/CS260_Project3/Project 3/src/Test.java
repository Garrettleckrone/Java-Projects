import java.util.Random;

//Student : Garrett Leckrone
//Class : CS260
//Project 3
//Description: This project helps in understanding the various implementations of different sorting techniques such as 
//insertionSort and MergeSort using both linked lists and arrays to test. 

public class Test {

	//Fields
	private int[] data;
	private Node head;
	private final int TOP = 12000000;
	private final int numberOfDataElements = 20;
	
	//Constructor
	public Test(){};
	
	
	
	//Tried to move the main method to its own class because there was errors with a static main method and non-static methods in my class as shown below, 
	//I moved it to a separate class but it caused more errors and I ran out of time and have to submit it as is :^(
	//Please be merciful in grading, this project determines whether I pass the class, but with the errors I am getting I couldn't even troubleshoot the output to the console.
	//I was also having tremendous errors with my heapsort method so I removed it from the project because it felt like a trainwreck.
	
	public static void main(String[] args){
		//First instantiate data by randomly generating a linked list and array
	    int numberOfElements = 20;
		randomData(numberOfElements);
		//Display the randomly generated array and list before they are sorted
		displayArray();
		displayList();
		//Test the run times of each sorting technique using both arrays and lists
		testSort();
		
	}
	
	
	
	//Calls the sorting methods and measures the time difference
	//between when it was first called and finished executing to calculate the runtime
	public void testSort()
	{
		//Holds the value of the system time
		Long totalTime;
		
		//Test the time of the InsertionSort using an array
		totalTime = System.currentTimeMillis();
		displayArray();
		Sortings.insertionSort(data);
		displayArray();
		totalTime = totalTime - System.currentTimeMillis();
		System.out.println("The run time of the Insertion Sort using an array: " + totalTime);
		
		//Test the time of the InsertionSort using a linked list
		totalTime = System.currentTimeMillis();
		displayList();
		Sortings.insertionSort(head);
		displayList();
		totalTime = totalTime - System.currentTimeMillis();
		System.out.println("The run time of the Insertion Sort using a linked list: " + totalTime);
		
		//Randomize Data
		randomData(numberOfDataElements);
		
		
		//Test the time of the MergeSort using an array
		totalTime = System.currentTimeMillis();
		displayArray();
		Sortings.mergesort(data, data[0], data.length);
		displayArray();
		totalTime = totalTime - System.currentTimeMillis();
		System.out.println("The run time of the Merge Sort using an array: " + totalTime);
		
		//Test the time of the MergeSort using a linked list
		totalTime = System.currentTimeMillis();
		displayList();
		Sortings.MergeSort(head);
		displayList();
		totalTime = totalTime - System.currentTimeMillis();
		System.out.println("The run time of the Merge Sort using a linked list: " + totalTime);
		
	}
	
	public void randomData(int length){
		//Generate random data using 
		//Instantiate the integer array and linked list
		data = new int[length];
		head = new Node(null);
		Node current = head;
		Random rand = new Random();
		for (int i = 0; i < length; i++)
		{
			int currentRandom = rand.nextInt();
			//Generate the list one link at a time
			current.link = new Node(currentRandom);
			//Fill the array one random element at a time
			data[i] = currentRandom;
		}
	}
	
	public void displayArray(){
		System.out.print("The array: ");
		if (data.length < 50){
		for (int i = 0; i < data.length; i++){
			System.out.print(data[i] + " ");
		}
		}
		if (data.length > 50){
			for (int i = 0; i < 50; i++){
				System.out.print(data[i] + " ");
			}
			}

	}
	
	public void displayList(){
		System.out.print("The list: ");
		int counter = 0;
		Node cursor = head;
		while (counter < 50) {
			System.out.println(cursor.data + " ");
			cursor = cursor.link;
			counter ++;
		}

	}
	
	
}
