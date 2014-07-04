//FVCproductions
//March 20, 2014
//TestResults2_FCoronel
//4.5 Driver File

//importing Scanner method and System.out method

import static java.lang.System.out;
import java.util.Scanner;

public class TestResults2_FCoronel {
	
	public static void main(String[] args) {
	
		Scanner keyboard = new Scanner(System.in); //creating Scanner object
		
		//declaring necessary variables
		
		int input;
		String letter;
		
		//asking user for score and declaring it as input
	
		out.println("Enter your numeric test score and I will tell you the grade: ");
	
		input = keyboard.nextInt(); 
	
		TestGrade2_FCoronel test = new TestGrade2_FCoronel(input); //creating object from Constructor
		
		letter = test.getLetterGrade(); //defining letter grade
		
		out.println();
		
		out.println("Your grade is " + letter); //printing out letter grade
	
	}
}