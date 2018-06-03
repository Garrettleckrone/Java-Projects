import java.io.File;
import java.io.*;
import java.util.*;

public class lab5B {

	public static void main(String[] PagenSquirtles) 
			throws IOException {
		File file = new File("Lab5Text.txt");
		Scanner scan = new Scanner(file);
		
		int countWords = 0;
		int countSentance = 0;
		int countA = 0;
		int countE = 0;
		int countI = 0;
		int countO = 0;
		int countU = 0;
		
	
		while(scan.hasNextLine()){
			String line = scan.nextLine();
			countSentance++;
			
			Scanner inLine = new Scanner(line);
			while(inLine.hasNext()){
				String words;
				words = inLine.next();
				countWords++;
				
				for(int i = 0; i<words.length(); i++){
					char c = line.charAt(i);
					if((c == 'a') || (c =='A')){
						countA++;
					}
					else if((c == 'e') || (c =='E')){
						countE++;
					}
					else if((c == 'i') || (c =='I')){
						countI++;
					}
					else if((c == 'o') || (c =='O')){
						countO++;
					}
					else if((c == 'u') || (c =='U')){
						countU++;
					}
					
				}
			}
			
			
		}
		System.out.println("Total number of sentences = " + countSentance);
		System.out.println("Total number of words = " + countWords);
		System.out.println("The frequency of char a = "  + countA);
		System.out.println("The frequency of char e = "  + countE);
		System.out.println("The frequency of char i = "  + countI);
		System.out.println("The frequency of char o = "  + countO);
		System.out.println("The frequency of char u = "  + countU);
		
		scan.close();
	}

}
