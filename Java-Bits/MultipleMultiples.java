//fvcproductions
/*prints a multiplication table 

n * 1  = ...
n * 2 = ...
...

n+1 * 1 = ...
n+1 * 2 = ...
...

n+2 * 1 = 
...

...and so on
*/
/*
output looks like this if number = 2

1 x 1 = 1
1 x 2 = 2
1 x 3 = 3
1 x 4 = 4
1 x 5 = 5
1 x 6 = 6
1 x 7 = 7
1 x 8 = 8
1 x 9 = 9
1 x 10 = 10

2 x 1 = 2
2 x 2 = 4
2 x 3 = 6
2 x 4 = 8
2 x 5 = 10
2 x 6 = 12
2 x 7 = 14
2 x 8 = 16
2 x 9 = 18
2 x 10 = 20

*/

class MultipleMultiples {
    
    public static void main(String args[]) {
    
		int number = 5; //can be set to whatever
	
		for (int i = 1; i <= number; i++) {
	
			for (int j = 1; j <= 10; j++) {
		
				System.out.println(i + " x " + j + " = " + i * j); 
		
			}
	
		System.out.println();
	
		}
    }
}