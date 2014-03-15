/* 
	FVCproductions
	
	Write a program  which  reads two  float variables  a and b  from  the keyboard.
	
	Then  declare and initialize three pointers  ptr1, ptr2 and ptr3 
	such that ptr1 and ptr2 will  both point to the variable a and  ptr3  will  point  to b.
	
	By  using  printf  show  that ptr1  and  ptr2  contain  the same memory address 
	and ptr3 contains a different  address.
	
*/	

	#include <stdio.h>

	int main()

	{ 
   
	float a, b;           
	float *ptr1 = &a, *ptr2 = &a, *ptr3 = &b;          
	
	printf("please enter float variable a: \n");    
	scanf( "%f", &a); 
	
	printf("now please enter float variable b: \n");
	scanf("%f", &b);
	
	printf("ptr1 is: %f\n", *ptr1);
	printf("ptr2 is: %f\n", *ptr2); 
	printf("ptr3 is: %f\n", *ptr3);

	return 0;
	
	}
	
