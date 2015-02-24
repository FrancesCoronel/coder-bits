//fvcproductions
//print all prime numbers from 1 till number
//uses while loop

//prime numbers defined: natural numbers greater than 1 that are divisible by 1 and itself

class Prime {
	
	public static void main(String args[]) {
		
		int number = 2;
		
		while (number <= 20) {
			
			boolean isPrime = true;
			int trial = 2;
			
			while (trial * trial < number) {
				
				if ((number % trial) == 0)
					isPrime = false; 
				
				trial += 1;
            }
            
            if (isPrime)
            	System.out.println(number);
            
            number += 1;
        }
    
    }
}