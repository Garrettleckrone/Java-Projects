//Student : Garrett Leckrone
//Class : CS260
//Project 3
//Description: This project helps in understanding the various implementations of different sorting techniques such as 
//insertionSort and MergeSort using both linked lists and arrays to test. 

public class Sortings {


	//Insertion Sort with an array
	public static void insertionSort(int array[]) 
	{
        int n = array.length;
        //Outer for loop traverses the array
        for (int j = 1; j < n; j++)
        {
            int i = j-1;
            
            while ( (i > -1) && ( array [i] > array[j] ) )
            {
                array [i+1] = array [i];
                i--;
            }
            array[i+1] = array[j];
            //Print the results to the console
            for (int k = 0; k < array.length; k++) 
            {
                System.out.print(array[i] + ", ");
            }
            System.out.println("\n");
        }
	}
	
	//Insertion Sort with a linked list
	 public static void insertionSort(Node head)
	 {
	      Node current = head;
	      Node tail = null;
	      while(current != null&& tail != head )
	      {
	        Node next = current;
	       for( ; next.link != tail;  next = next.link)
	     {
	     if(next.data <= next.link.data)
	         {
	         int temp = next.data;
	         next.data = next.link.data;
	             next.link.data = temp;
	         }
	     }
	     tail = next;
	     current = head;
	   }
	      //Print the results to the console
          for ( ; current.link!=null; current = current.link) 
          {
              System.out.print(current.data + ", ");
          }
          System.out.println("\n");
	 }
	 
	 //Merge sort using an Array
	 public static void mergesort(int[ ] data, int first, int size)
	   {
	      int firstHalf; 
	      int secondHalf; 

	      if (size > 1)
	      {
	         // Compute sizes of the two halves
	         firstHalf = size / 2;
	         secondHalf = size - firstHalf;

	         //Recursive calls
	         mergesort(data, first, firstHalf);      
	         mergesort(data, first + firstHalf, secondHalf);
	         merge(data, first, firstHalf, secondHalf);
	      }
	   } 
	 //Merge sort using an Array
	 private static void merge(int[ ] data, int first, int firstHalf, int secondHalf)
	   {
	      int[ ] temp = new int[firstHalf + secondHalf]; 
	      int copieds  = 0; // Number of elements copied from data to temp
	      int copied1 = 0;
	      int copied2s = 0; 
	      int i;          

	      // Merge elements, using temporary array
	      while ((copied1 < firstHalf) && (copied2 < secondHalf))
	      {
	         if (data[first + copied1] < data[first + firstHalf + copied2])
	            temp[copied++] =
	            	data[first + (copied1++)];
	         else
	            temp[copied++] =
	            	data[first + firstHalf + (copied2++)];
	      }

	      // Copy any remaining entries in the left and right halves.
	      while (copied1 < firstHalf)
	         temp[copied++] = data[first + (copied1++)];
	      while (copied2 < secondHalf)
	         temp[copied++] = data[first + firstHalf + (copied2++)];

	      // Copy from temp back to the data array.
	      for (i = 0; i < firstHalf+secondHalf; i++)
	         data[first + i] = temp[i];
	   }
	   
	 //Merge sort using a linked list
	 public static Node MergeSort(Node head) 
	    {
	        if (head == null || head.link == null)
	            return head;
	        Node a = head;
	        Node b = head.link;
	        while ((b != null) && (b.link != null)) 
	        {
	        	head = head.link;
	            b = (b.link).link;
	        }
	        b = head.link;
	        head.link = null;
	        return merge(MergeSort(a), MergeSort(b));
	    }
	  //Merge sort using a linked list
	  public static Node merge(Node a, Node b) 
	    {
	        Node temp = new Node();
	        Node head = temp;
	        Node c = head;
	        while ((a != null) && (b != null)) 
	        {
	            if (a.data <= b.data) 
	            {
	                c.link = a;
	                c = a;
	                a = a.link;
	            }
	            else 
	            {
	                c.link = b;
	                c = b;
	                b = b.link;
	            }
	        }
	        c.link = (a == null) ? b : a;
	        return head.link;
	    }
	  

	      
}
	 

