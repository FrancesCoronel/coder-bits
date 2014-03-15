/* 
	FVCproductions
	
	Write a program which does the following:

	1.  reads an integer from the keyboard,

	2.  and prints the integer in decimal, octal and hexadecimal  notation.
*/	

		#include <stdio.h>

		int main() 
		
		{
		
		int a;

		printf("Enter an integer number please: "); 
		scanf("%d",&a); 
		
		printf("Decimal Notation: %d\n", a);
		printf("Octal Notation: %o\n", a); 
		printf("Hexadecimal Notation: %x\n", a);
		
		return 0; 
		
		}
