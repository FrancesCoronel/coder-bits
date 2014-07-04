/*
FVCproductions
Purpose of this program is to test my concepts on inheritance as well as manipulation objects in an array.
In the program there's an application that manages a list of the Person class using an array classes using the subclasses Student and Faculty to assign values to each student's info.
*/

import java.util.Scanner;
import java.util.Random;

import java.util.ArrayList;

class managerPerson_CORONEL_9124 {
	
	public static void main(String[] args) {
		
		System.out.println("I, FRANCES, did not receive any assistant from anyone other than Dr. Boonthum-Denecke.");
		
		System.out.println();
		System.out.println("Initial Money");
		System.out.println("Name\t\t\tAge\tMoney\t\tAdditional Info");
		System.out.println("---------------------------------------------------------------------------");
		
		ArrayList<Person> CORONEL_9124_PersonList = new ArrayList<Person>();
		
		//1 Person - Me
		Person frances = new Person("Frances", "Coronel", 18, 50); 
		
		//1st Student
		Student rosi = new Student("Rosi", "Coronel", 16, 40); 
		
		//2nd Student
	 	Student jiaqi = new Student("Jiaqi", "Song", 19, 30, "International Logistics", 0); 
		
		//1st Faculty Member
		Faculty math_teacher = new Faculty("Ira", "Walker", 45, 80);
		
		//2nd Faculty Member
		Faculty cs_teacher = new Faculty("Katina", "Brown", 35, 70, "Instructor", "Computer Science");
		
		CORONEL_9124_PersonList.add(frances);
		CORONEL_9124_PersonList.add(rosi);
		CORONEL_9124_PersonList.add(jiaqi);
		CORONEL_9124_PersonList.add(math_teacher);
		CORONEL_9124_PersonList.add(cs_teacher);
		
		Random generator = new Random(); //creating Random generator for initial money
				
		double randValue = 0;
				
		for (int i = 0; i < CORONEL_9124_PersonList.size(); i++){
			
			System.out.print(CORONEL_9124_PersonList.get(i));
			
			randValue = generator.nextDouble();
			
			if (randValue < .5) {
					
				int workValue = 0;
				workValue = generator.nextInt(50)+50;
				
				double newWMoney = CORONEL_9124_PersonList.get(i).getMoney();
				newWMoney += workValue;
				CORONEL_9124_PersonList.get(i).setMoney(newWMoney);
				
				System.out.println("[[W + " + workValue + " ]]");
			}
			
			else if (randValue > .5) {
				
				int shopValue = 0;
				shopValue = generator.nextInt(10)+20;
				
				double newSMoney = CORONEL_9124_PersonList.get(i).getMoney();
				newSMoney -= shopValue;
				CORONEL_9124_PersonList.get(i).setMoney(newSMoney);
				
				System.out.println("[[S - " + shopValue + " ]]");
			}
		}
		
		System.out.println();
		System.out.println();
		System.out.println("Final Money");
		System.out.println("Name\t\t\tAge\tMoney\t\tAdditional Info");
		System.out.println("---------------------------------------------------------------------------");
		
		for (int j = 0; j < CORONEL_9124_PersonList.size(); j++)
			System.out.println(CORONEL_9124_PersonList.get(j));
		
		System.out.println("\n\nThis program is completed by FRANCES, COMPUTER SCIENCE, 00319124.");

	}
}


/* ---OUTPUT---

   ----jGRASP exec: java managerPerson_CORONEL_9124

    I, FRANCES, did not receive any assistant from anyone other than Dr. Boonthum-Denecke.
    
    Initial Money
    Name			Age	Money		Additional Info
    ---------------------------------------------------------------------------
    Frances Coronel		18	50.0		[[W + 86 ]]
    S: Rosi Coronel		16	40.0		n/a	[[S - 28 ]]
    S: Jiaqi Song		19	30.0		International Logistics	[[W + 87 ]]
    F: Ira Walker		45	80.0		n/a	[[W + 64 ]]
    F: Katina Brown		35	70.0		Computer Science, Instructor	[[S - 25 ]]
    
    
    Final Money
    Name			Age	Money		Additional Info
    ---------------------------------------------------------------------------
    Frances Coronel		18	136.0		
    S: Rosi Coronel		16	12.0		n/a	
    S: Jiaqi Song		19	117.0		International Logistics	
    F: Ira Walker		45	144.0		n/a	
    F: Katina Brown		35	45.0		Computer Science, Instructor	
    
    
    This program is completed by FRANCES, COMPUTER SCIENCE, 00319124.
    
     ----jGRASP: operation complete.

*/