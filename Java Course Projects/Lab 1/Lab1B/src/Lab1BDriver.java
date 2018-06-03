import java.io.*;
import java.util.*;


public class Lab1BDriver {

	public static void main(String[] args) throws IOException {
		
		File file = new File("Lab1B_IN.txt");
		Scanner scan = new Scanner(file);
		FileWriter fileWriter = new FileWriter("Lab1B_out.txt");
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.println("Student\tTest1\tTest2\tTest3\tTest4\tTest5\tAve\tGrade");
		int test1, test2, test3, test4, test5;
		
		int[] scores;
		int counter = 0;
		while (scan.hasNextLine()){
			String name;
			
			Student tempStudent = new Student();
			//Scan Name
			name = scan.next();
			tempStudent.setName(name);
			//Scan Tests
			test1 = scan.nextInt();
			test2 = scan.nextInt();
			test3 = scan.nextInt();
			test4 = scan.nextInt();
			test5 = scan.nextInt();
			tempStudent.setScores(test1, test2, test3, test4, test5);
			tempStudent.calculateAverage();
			tempStudent.calculateGrade();
			tempStudent.generateOutput(printWriter);
			
			++counter;
		}
	System.exit(0);
	}
}
