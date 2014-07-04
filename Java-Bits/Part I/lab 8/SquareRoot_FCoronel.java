//FVCproductions
//Lab 8
//April 3, 2014
//SquareRoot_FCoronel

import static java.lang.System.out; //importing System.out method

public class SquareRoot_FCoronel {
	
	public static void main (String[] args) {
		
		//for loop that increments from 1 to 10
		
		for (int i = 1; i <= 10; i++) {
			
			//printing out numbers 1 through 10 and then the squareroot next to number
			
			out.println(i + "\t" + Math.sqrt((double) i));
			
			
		}
		
	}
}