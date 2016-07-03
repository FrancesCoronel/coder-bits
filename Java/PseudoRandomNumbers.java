/*
Pseudo-Random Numbers
PseudoRandomNumbers.java
Discrete Structures
FVCproductions
September 19, 2014
*/

/*

The method usually used to generate pseudorandom numbers is called linear congruential method.  This method requires four integers;
 
       the modulus m
       the multiplier a,
       the increment c,
       and the seed s
 
satisfying    2 ≤ a < m,     0 ≤ c < m,     0 ≤ s < m.
 
We then set = s.  The sequence of pseudorandom numbers generated, , , . . . ,  is given by the formula
 
         =  (a + c) mod m.
 
The formula computes the next pseudorandom number using its immediate predecessor.
 
For example, if        
         m = 11,     a = 7,     c = 5,    s = 3.
then
        = (a + c) mod m
          = (7 ∙ 3 + 5) mod 11 = 4
and
        = (a + c) mod m
          = (7 ∙ 4 + 5) mod 11 = 0.
 
Similar computations show that the sequence continues:
 
          = 5,   = 7,   = 10,   = 9, = 2,   = 8,   = 6,   = 3.
 
Since = 3, which is the value of the seed, the sequence now repeats:
       
         3, 4, 0, 5, 7, . . . .
 
Much effort has been invested in finding good values for a linear congruential method.  Critical simulations such as those involving aircraft and nuclear research require “good” random numbers.  In practice, large values are used for m and a.  
Commonly used values are
 
       m  =   − 1  =  2,147,483,647
       a  =    =  16,807
       c  =  0
 
which generate a sequence of − 1 integers before repeating a value.
 
Once your program has been written it should be executed with two set of initial values.  The first example given in the PowerPoint and textbook will generate a small series of Pseudo Random Numbers, i.e., initial values are:
 
       m = 11,     a = 7,     c = 5,    s = 3.
       ​
The second example given in the PowerPoint and textbook will generate a large series of Pseudo Random Numbers, i.e., initial values are:
 
       m  =  2,147,483,647,     a  =  16,807,     c  =  0,     s = 3.
 
Call the Psuedo Random Number Generator in a loop 50 times and verify that your program produces the same results as the sample output below.  

*/


public class PseudoRandomNumbers {
	
	public static void main(String[] args) {
		
		System.out.print("Small series of Pseudo Random Numbers\n");
		
		long m = 11; 
		long a = 7; 
		long c = 5; 
		long s = 3;
		
		for (int i = 0; i < 50; i++) {
			System.out.print(RandomGen(m,a,c,s) + " ");
			s = RandomGen(m,a,c,s);
			RandomGen(m,a,c,s);
		}
		
		System.out.print("\n\nLarge series of Pseudo Random Numbers\n");
		
		m = 2147483647;
		a = 16807;
		c = 0; 
		s = 3;
		
		for (int i = 0; i < 50; i++) {
			System.out.print(RandomGen(m,a,c,s) + " ");
			s = RandomGen(m,a,c,s);
			RandomGen(m,a,c,s);
		}
		
	}
	
	public static long RandomGen(long m, long a, long c, long s) {
		return (a*s + c)%(m);
	}
	
}