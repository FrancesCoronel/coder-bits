/* 
	FVCproductions
	
	Question:
	
	You will  get compiler  errors, when  you try to compile the given  code example below.

	Read the error messages that the compiler  produces and fix the errors, so your  source code com-

	piles sucessfully. Then fix the program  to print the correct result.

	#include <stdio.h>

	float result;  // The    result  of  the division  //

	int  main() {

	result =   6   / 23.0;

	printf(“The result is  %d\n”,  result);

	return  0;

	}
*/

#include <stdio.h>

float result; /* The result of the division */

int main() {
	result = 6 / 23.0;
	printf("The result is %f\n", result);
	return 0;
}