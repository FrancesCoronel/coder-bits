/***************************************************

CSC-152 Inclass Exercise: Arrays

Purpose: this program is to read *7* integers and 
         calculate sum and average

****************************************************/

// import necessary classes

/*
THIS PROGRAM USES AN ARRAY INSTEAD
*/

import java.util.Scanner;

public class CORONEL_F_IC1_ArrayP1 {
	
	public static void main (String []args) {
		
		// define variables
		
		int sum = 0;
		int count = 0;
		
		double average;
		
		Scanner keyboard = new Scanner(System.in);
		
		//creating array with 7 defined as value
		
		int[] CORONEL_num_array = new int[7];
		
		// read 7 integers from keyboard
		
		System.out.println("You are to enter 7 numbers.");
		System.out.println();
		
		/*
		for loop that grabs the 7 numbers using array
		also calculates sum through count variable
		*/
		
		for (count = 0; count < 7; count++) {
			
			System.out.print("Enter number " + (count + 1) + ": ");
			CORONEL_num_array[count] = keyboard.nextInt(); 
			sum += CORONEL_num_array[count];
			
		}
		
		System.out.println();
		System.out.print("You entered the numbers: ");
		
		//for loop that prints out numbers within array
		
		for (int my_array: CORONEL_num_array) {
			System.out.print(my_array + " ");
		}
		
		System.out.println();
		
		// calculation
		
		average = (double) sum / 7 ;
		
		// results
		System.out.println();
		System.out.println("The sum of the 7 integers is : " + sum + "\n" +
                          "The average of the 7 integers is : " + average );
   
     
   }
}