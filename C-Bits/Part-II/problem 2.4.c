/* 
	FVCproductions
	
	Write a program  that converts Centigrades (also known  as Celsius) to Fahrenheit.
	You should  be able to enter a number,
	then the result should  be computed
	and printed to the screen according to the following transformation  

	Formula Needed: F = (9/5)C + 32
*/	

	#include <stdio.h>

	int main ()
	
	{

	int celsius, fahrenheit;

	printf("Enter temperature in degrees Celsius:\n");
	scanf("%d", &celsius);
	
	fahrenheit = (1.8)*(celsius) + 32;
	
	printf ("Converted temperature in degrees Fahrenheit is %d\n", fahrenheit);

	return 0;

	}
