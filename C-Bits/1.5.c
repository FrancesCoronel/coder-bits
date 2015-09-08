/* 
	FVCproductions
		
	Question:
		
	Write a program  which:

	1.  declares and initializes  an integer variable a with 123, and prints the value of a over 7 places,

	2.  declares and intializes  an float variable  b with  −89.6548754, and prints the value  of b over

	10 places and with  a floating point precision of 4,

	3.  declares and initializes a char variable c with  ’b’, and prints the character on the screen,
	
	4.  declares and intializes a double variable d with  19.987243, and prints  the value of d with a floating point precision  of 2.
*/

	#include <stdio.h>

	int main() {
		
		int a;
		float b;
		char c;
		double d;
		
		a = 123;
		b = -89.6548754;
		c = 'b';
		d = 19.987243;
		
		printf("a is: %7d\n", a);
	
		printf("b is: %10.4f\n", b);
		
		printf("c is: %c\n", c);
		
		printf("d is: %6.2f\n", d);
		
		return 0;
	}
