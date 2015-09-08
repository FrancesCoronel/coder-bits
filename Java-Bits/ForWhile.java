//fvcproductions
//demonstrating program that calculates sum of 1 to limit
//uses a while loop and then a for loop 

class ForWhile {
	
	public static void main(String[] args) {
	
		int number = 1;
		int sum = 0;
		int limit = 10; //can change limit to whatever
		
		//while loop
		while ( number < limit) {
			
			number += 1;
			sum += number;
		
		}
	        
		System.out.println("Sum using while loop: " + sum);
		
		//resetting sum and number
		sum = 0;
		number = 1;
		
		//for loop
		for(int i = 1; i < limit; i++){
			
			number += 1;
			sum += number;
		}
		
		System.out.println("Sum using for loop: " + sum);

    }
}