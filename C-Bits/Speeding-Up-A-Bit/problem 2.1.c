/*
	FVCproductions
	
	Write a program  which  does the following:

	1.  reads two floats from the keyboard,

	2.  prints the sum of the two floats,

	3.  prints the difference  of the two floats,

	4.  prints the square of the first float,

	5.  reads two integers from the keyboard,

	6.  computes the sum, product  of the two integers,

	7.  prints the sum, and the product  of the integers.

*/

	#include <stdio.h>

	int main() 
	
	{
	int a, b;
	int addint, multint;
	float x,y; 
	float add,sub,sq; 
	
	printf("enter any two float numbers : "); 
	scanf("%f%f",&x,&y); 
	
	add = x + y; 
	sub = x - y; 
	sq = x * x;
	
	printf("addition: %f\n",add);
	printf("subtraction: %f\n", sub); 
	printf("square :%f\n", sq);
	
	printf("enter any two int numbers: ");
	scanf("%d%d", &a,&b);
	
	addint = a + b;
	multint = a * b;
	
	printf("addition: %d\n", addint);
	printf("multiplication: %d\n", multint);
	
	return 0; 
	}
