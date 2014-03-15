/* 
	FVCproductions
		
	Question:
	
	Write a program  which  does the following:

	1.  assigns 13 to a and 9 to b,

	2.  computes the sum of a and b and prints the result,

	3.  computes the product  of a and b and prints the result,

	4.  computes the difference  of a and b and prints the result,

	5.  computes the division of a and b and prints the result (the result should  be a float),

	6.  computes the remainder  of the division of a and b and prints the result,

	7.  prints the values of a and b.
*/
	
	#include <stdio.h>

	int main()

	{
	
	int a = 13, b = 9, result;
	float div;
	
	result = a+b;
	printf("Addition: %d\n", result);
	
	result = a-b;
	printf("Subtraction: %d\n", result);
	
	result = a*b;
	printf("Multiplication: %d\n", result);
	
	div = a/(float)b;
	printf("Division: %f\n", div);
	
	result = a%b;
	printf("Remainder: %d\n", result);
	
	result = a;
	printf("a: %d\n", result);
	
	result = b;
	printf("b: %d\n", result);
	
	return 0;
	
	}