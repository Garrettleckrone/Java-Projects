/* Class Name: SpinWheel
 * Developer: Garrett Leckrone
 * 
 * Class Description:
 * 
 * 
 */
import java.lang.*;
import java.util.Random;
import java.util.Scanner;
public class SpinWheel 
{
	private static int manyWedges; //Number of wedges in the wheel
	private static IntNode pointer;
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		manyWedges = 100;
		
		SpinWheel(manyWedges);
		System.out.println("Welcome to Spin the Wheel game: ");
		System.out.println("Ready to spin ‘Y’ or ‘N’: ");
		while(kb.nextLine().equals("Y"))
		{
			//Populate the wheel
			SpinWheel(manyWedges);
			//Spin the wheel!
			int theUsersPrize = spin();
			//Tell the user what they won!
			System.out.println("Your Prize: " + theUsersPrize);
			
			
			
			
			System.out.println("Ready to spin ‘Y’ or ‘N’: ");
		}
		System.out.println("Thank you for spinning the wheel of mythicality.");
		
	}
	public static void SpinWheel(int wedgeNum)
	{
		IntNode curNode = new IntNode(wedgeNum, null);
		IntNode tail = curNode;
		
		//Populating the spinwheel
		for(int i = wedgeNum; i > 0; i--)
		{
			IntNode next = new IntNode(i, curNode);
			curNode = next;
			
		}
		pointer = curNode;
		tail.setLink(curNode);	
		
	}
	 
	public static int spin()
	{
		//Spin the wheel
		Random randomNumber = new Random();
		int finalCount = randomNumber.nextInt(100);
		IntNode Cursor = pointer;
		
		//Traverse through nodes until the value of finalCount
		for(int i = 0; i < finalCount; i++){
			if (Cursor.getLink() == null){
				//If the linked list is empty. The list should never be empty at this point
				throw new NullPointerException();
			}
			
			Cursor = Cursor.getLink();
		}
		//After the linked list is traversed and Cursor is pointing to the correct node return the data stored in the cursors link.
		return Cursor.getLink().getData();
	}
}