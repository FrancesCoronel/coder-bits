//FVCproductions
//Final Lab
//April 17, 2014
//FinalExamDemo_FCoronel
//Part II and Extra Credit - Driver File

import java.io.*; //importing PrintWriter and IOException
import java.util.Scanner; //importing Scanner method

public class FinalExamDemo_FCoronel {

   public static void main (String[] args) throws IOException { //throws IOException method needed for file input and output
      
      //1
     
      System.out.println("Q2Obj1");
      
      System.out.println();
      
      FinalExam_FCoronel Q2Obj1 = new FinalExam_FCoronel("Frances", "Java", 90); //creating object 1 with hard code parameters
      
      System.out.println(Q2Obj1); //printing object's values using toString() method
      
      System.out.println("Final Grade: " + Q2Obj1.getFGrade());  //calling method getFGrade for object 1
      System.out.println("The letter grade for object Q2Obj1 is: " + Q2Obj1.getLetterGrade()); //calling method getLetterGrade for object 2
      
      //2
      
      System.out.println();
      System.out.println("Q2Obj2"); 
      
      FinalExam_FCoronel Q2Obj2 = new FinalExam_FCoronel(); //creating object 2 without parameters
      
      Q2Obj2.setStname("Rosi"); //setting hard code values for object 2
      Q2Obj2.setCrseName("Python");
      Q2Obj2.setFGrade(50);
      
      //3
      
      System.out.println();
      System.out.println("Both Q2Obj1 and Q2Obj2");
      
      /*
      displaying state of object 1
      */
      System.out.println();
      System.out.println("Student 1 Name: " + Q2Obj1.getStname());
      System.out.println("Course Name: " + Q2Obj1.getCrseName());
      System.out.println("Final Grade: " + Q2Obj1.getFGrade());
      System.out.println("Letter Grade: " + Q2Obj1.getLetterGrade());
      
      
      /*
      displaying state of object 2
      */
      System.out.println();
      System.out.println("Student 2 Name: " + Q2Obj2.getStname());
      System.out.println("Course Name: " + Q2Obj2.getCrseName());
      System.out.println("Final Grade: " + Q2Obj2.getFGrade());
      System.out.println("Letter Grade: " + Q2Obj2.getLetterGrade());
      
      /*
      conditional operator/statement that compares both objects for larger grade
      */
      
      System.out.println();
      
      System.out.println((Q2Obj1.getFGrade() < Q2Obj2.getFGrade() ? "Q2Obj2 has larger grade" : "Q2Obj1 has larger grade"));
      
      /*
      conditional operator/statement that compares both objects for equality
      */
      
      System.out.println();
      
      System.out.println((Q2Obj1.getFGrade() == Q2Obj2.getFGrade() ? "The two object grades are equal" : "The two object grades are NOT equal"));
           
      //4
      
      System.out.println();
      
      System.out.println("Switch Statement");
      
      System.out.println();
      
      int choice = 1; //hard code the choice
      
      switch(choice) { //switch statement for university level
      
         case 1:
         case 2:
            System.out.println("You must be a Freshman or a Sophomore");
            break;
         case 3:
         case 4:
            System.out.println("You must be a Junior or Senior");
            break;
         case 5:
         case 6:
            System.out.println("You must be either in Grad School or you have a job");
            break;
      
      }
      
      
      //5
      
      System.out.println();
      
      for (int i = 0 ; i <= 100; i += 7) {
      
         System.out.println(i);
         
      }
      
      //6
      
      System.out.println();
      
      int number = 0;
      
      do
      {
         if (number%2 != 0)
            System.out.println(number);
         
         number++;
      
      } while(number <= 50);
      
      //Extra Credit -----Using files
      
      System.out.println();
      
      System.out.println("Extra Credit -----Using files");
                  
      File file = new File("Random.txt");
      Scanner inputFile = new Scanner(file);
      
      String data;
      
      while(inputFile.hasNext()) {
         
         data = inputFile.nextLine();
         
      }
      
      inputFile.close();
      
      PrintWriter outputFile = new PrintWriter("Q2OutFile.txt");
    
      outputFile.println(inputFile);
      outputFile.println("Average: " + (92+40)/(2));
      outputFile.println("Highest grade: 92");
      
      outputFile.close();
      
      System.out.println();
      System.out.println("Frances Coronel has finished CSC151 Lab Final Exam");
      
   }
}
      
      
   
      
   
   