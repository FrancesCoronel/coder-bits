/* 
	FVCproductions
	
	Write a program  which  
	reads an integer variable val from the keyboard
	and prints the value  on the screen.
	Then declare and initialize a pointer ptr val to val, 
	print the address where the pointer points to on the screen, 
	increment (add 1 to it) the value of val by using the pointer variable 
	and print the modified value and the address of the pointer on the screen as well.
*/	

	#include <stdio.h>

	int main()
	
	{ 
    
	int val;           
    	int *ptr_val;          
   
	printf("please enter variable val please: \n");
	scanf("%d", &val);  
	
	*ptr_val = val + 1;        
    
	printf("ptr_val is: %d\n", *ptr_val); 

	return 0;
	
	}

