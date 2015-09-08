//fvcproductions
//prints sum of all even numbers from 1 to n
//uses while loop

import java.util.Scanner;

class SumOfEven {
	
	public static void main(String args[]) {
		
		Scanner keyboard = new Scanner(System.in);
	
		System.out.print("Enter Your Input Please: ");
		int number = keyboard.nextInt();
		
		int sum = 0;
		int i = 1;
		
		while (i <= number) {
      
			if (i % 2 == 0) {
				sum += i;
			}
			
		i = i+1;

		}
		
		System.out.println("The sum is " + sum);
    
	}
}