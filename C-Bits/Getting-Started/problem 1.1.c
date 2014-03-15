/* 
	FVCproductions
	
	Question:
	
	Why is the result 0.000? Please fix it.

	#include <stdio.h>

	float answer; //  The result  of  our calculation  //

	int  main() {
	answer  =   1/8;
	printf("The value of  1/8 is  %f\n", answer);
	return  0;
	}
*/

#include <stdio.h>

float answer; /* The result of our calculation */

int main () {
	answer = 1/8.0;
	printf ("The value of 1/8.0 is %f\n", answer);
	return 0;
}