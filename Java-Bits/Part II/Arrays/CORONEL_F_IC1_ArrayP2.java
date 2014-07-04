/***************************************************

CSC-152 Inclass Exercise: Arrays

Purpose: this program is to read *10* integers and 
         calculate sum and average in separate methods

****************************************************/

// import necessary classes

/*
THIS PROGRAM USES AN ARRAY INSTEAD WITH 10 NUMBERS INSTEAD OF 7
*/

import java.util.Scanner;

public class CORONEL_F_IC1_ArrayP2 {
	
	public static void main (String []args) {
	
		//creating scanner with scanner class
		
		Scanner keyboard = new Scanner(System.in);
		
		//creating array with 10 defined as value
		
		int[] CORONEL_num_array = new int[10];
		
		//specifying how many numbers are to be entered
		
		System.out.println("You are to enter 10 numbers.");
		System.out.println();
		
		//for loop that asks for 10 numbers one after the other
		
		for (int i = 0; i < 10; i++) {
			System.out.print("Enter number " + (i + 1) + ": ");
			CORONEL_num_array[i] = keyboard.nextInt(); 
		}
		
		//stating which numbers were entered
		
		System.out.println();
		System.out.print("You entered the numbers: ");
		
		//for loop that prints out numbers within array
		
		for (int my_array: CORONEL_num_array) {
			System.out.print(my_array + " ");
		}
		
		System.out.println();
		
		System.out.println();
		
		// results printed out
		//sum, average, min, max
		
		System.out.println("The sum of the 10 integers is : " + findSum(CORONEL_num_array));
		System.out.println("The average of the 10 integers is : " + findAverage(CORONEL_num_array));
		System.out.println("The minimum value of the 10 integers is: " + findMin(CORONEL_num_array));
		System.out.println("The maximum value of the 10 integers is: " + findMax(CORONEL_num_array));
		
   }

//method that calculates maximum value using for loop

public static int findMax(int[] CORONEL_num_array) {  
    int max = CORONEL_num_array[0];  
	for(int i = 1; i < CORONEL_num_array.length; i++) {  
		if(CORONEL_num_array[i] > max){
			max = CORONEL_num_array[i];  
        }  
    }  
	return max;  
}  
  
//method that calculates minimum value using for loop

public static int findMin(int[] CORONEL_num_array) {  
	int min = CORONEL_num_array[0];
    for(int i = 1; i < CORONEL_num_array.length; i++) {  
		if(CORONEL_num_array[i] < min) {
			min= CORONEL_num_array[i];  
        }  
    }  
    return min;  
}

//method that calculates sum value using for loop

public static int findSum(int[] CORONEL_num_array) {
	int sum = 0;
	for (int i : CORONEL_num_array) {
		sum += i;		
	}
	return sum;
}

//method that calculates sum value using for loop

public static double findAverage(int[] CORONEL_num_array) {
	return ((double) (findSum(CORONEL_num_array)) / 10) ;
}

}