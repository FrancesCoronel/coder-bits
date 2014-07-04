/* 
	FVCproductions
	
	Write a program  where  you  can enter  hours  and  minutes  as input  from  the keyboard.
	Your program  should  compute and output by printing on the screen the the total number of minutes.
*/	
	
	#include <stdio.h>

	int main()
	
	{ 
		int hour,minute,minute1,total; 
		
		printf("Hour:"); 
		scanf("%d",&hour);
		
		printf("Minutes:"); 
		scanf("%d",&minute);
		
		minute1=hour*60; 
		total=minute1+minute; 
		
		printf(" total minutes =  %d",total); 
		
		return 0;
	}
