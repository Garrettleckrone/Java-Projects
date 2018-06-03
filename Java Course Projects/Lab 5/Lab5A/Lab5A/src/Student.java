
public class Student {

	//Fields
	private String name; //Store the name of the student
	private char grade;	 //Store the letter grade of the student
	private double average; //Store the average score
	private int scores[] = new int[5]; //Store the five exam scores for the student
	
	//Constructor
	public Student(String name){
		this.name = name;
		
	}
	
	//Accessor methods
	public String getName(){
		return name;
	}
	public double getAverage(){
		calculateAverage();
		return average;
	}
	public char getGrade(){
		return grade;
	}
	
	
	//Modifier methods
	public void setScores(int[] scores){
		for (int counter = 0; counter<scores.length; counter++){
			this.scores[counter] = scores[counter];
		}
	}
	//Calculate average method
	public void calculateAverage(){
		for (int counter = 0; counter<scores.length;counter++){
			int sum = 0;
			sum += scores[counter];
			average = sum/(scores.length);
		}
	}
	//Calculate grade method
	public void calculateGrade(){
		calculateAverage();
		if (average < 0 || average > 100){
			grade = 'X'; //The character 'X' will be used as a flag if the average is not an expected value 
		}
		else if (average > 90){
			grade = 'A';
		}
		else if (average > 80){
			grade = 'B';
		}
		else if (average > 70){
			grade = 'C';
		}
		else if (average > 60){
			grade = 'D';
		}
		else if (average > 50){
			grade = 'F';
		}
		else 
			grade = 'X';
	}
	
}
