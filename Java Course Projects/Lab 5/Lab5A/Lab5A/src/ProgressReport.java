import java.io.*;
import java.util.*;


public class ProgressReport {
	//Field
	Student[][] sectionArray = new Student[2][];
	
	//Constructor
	public ProgressReport(){
		
	}
	
	//Accessor Methods
	
	
	//Modifiers Methods
	
	
	//Read input file method
	public void readInputFile() throws IOException{
		//Instantiate the input file and set up scanner object
		File inputFile = new File("Lab5Ainput.txt");
		Scanner scan = new Scanner(inputFile);
		
		int numStudents1; //How many students in first section
		int numStudents2; //How many students in the second section
		final int NUM_OF_COLS = 5;
		
		//Create students for first section
			numStudents1 = scan.nextInt();
			for (int counter = 0; counter<numStudents1; counter++){
				String name = scan.next();
				//Create a new student object each time
				Student student = new Student(name);
				int[] temp = new int[5];
				
				for (int i = 0; i<NUM_OF_COLS; i++){
					temp[i] = scan.nextInt();
				}
				//Set the scores for each student
				student.setScores(temp);
				
				sectionArray[0][counter] = student;
			}
			//Repeat for the second section
			numStudents2 = scan.nextInt();
			for (int counter = 0; counter<numStudents2; counter++){
				String name = scan.next();
				//Create a new student object each time
				Student student = new Student(name);
				int[] temp = new int[5];
				
				for (int i = 0; i<NUM_OF_COLS; i++){
					temp[i] = scan.nextInt();
				}
				//Set the scores for each student
				student.setScores(temp);
				
				sectionArray[1][counter] = student;
			}
			
			scan.close();
	}
	//Generate report method
	public void generateReport(){
		System.out.println("Section 1");
		for (int counter = 0; counter < sectionArray[0].length; counter++){
			System.out.print(""  + sectionArray[0][counter].getName());
			System.out.print(" " + sectionArray[0][counter].getAverage());
			System.out.println(" " + sectionArray[0][counter].getGrade());
		}
		System.out.println("Section 2");
		for (int counter = 0; counter < sectionArray[1].length; counter++){
			System.out.print(""  + sectionArray[1][counter].getName());
			System.out.print(" " + sectionArray[1][counter].getAverage());
			System.out.println(" " + sectionArray[1][counter].getGrade());
		}
	}
	
	//Sort by name method
	public void sortByName(){
		
	}
	//Binary search method
	
	
	
}
