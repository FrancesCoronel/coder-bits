//FVCproductions
//March 20, 2014
//TestResults_FCoronel
//4.4 Driver File

import static java.lang.System.out;
import java.util.Scanner;

public class TestResults_FCoronel {
	
	public static void main(String[] args) {
	
		Scanner keyboard = new Scanner(System.in); //importing System.out method
		
		//delcaring private variables
		
		int input;
		String letter;
		
		//asking user for score and declaring input as grade
	
		out.println("Enter your numeric test score and I will tell you the grade: ");
	
		input = keyboard.nextInt();
	
		TestGrade_FCoronel test = new TestGrade_FCoronel(input); //creating object
		
		letter = test.getLetterGrade(); //declaring letter grade
		
		out.println();
		
		out.println("Your grade is " + letter); //printing letter grade out
	
	}
}