/***************************************************

CSC-152 Inclass Exercise: Arrays

Purpose: this program is to read *7* integers and 
         calculate sum and average

****************************************************/

// import necessary classes
import java.util.Scanner;

public class CORONEL_F_IC1_P1
{
   public static void main (String []args)
   {
   
      // define variables
      int sum, num1, num2, num3, num4, num5, num6, num7;
      double average;
      
      Scanner keyboard = new Scanner(System.in);
      
      // read 7 integers from keyboard
      
      System.out.print ("Please enter 7 integers: ");
      
      num1 = keyboard.nextInt();	
      num2 = keyboard.nextInt();	
      num3 = keyboard.nextInt();	
      num4 = keyboard.nextInt();	
      num5 = keyboard.nextInt();	
	  num6 = keyboard.nextInt();
	  num7 = keyboard.nextInt();
      
      
      // calculation

      sum = num1 + num2 + num3 + num4 + num5 + num6 + num7;
      
      average = (double) sum / 7 ;
      
      // results
      
      System.out.println ("You enter " + num1 + " " + num2 + " " + 
                     num3 + " " + num4 + " " + num5 + " " + num6 + " " + num7);
      System.out.println ("The sum of the 7 integers is : " + sum + "\n" +
                          "The average of the 7 integers is : " + average );
                               
      
      
   }
}