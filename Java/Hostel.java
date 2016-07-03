//fvcproductions
//hostel simulation

//incomplete

import static java.lang.System.out;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

class Hostel {
	
	public static void main(String args[]) throws IOException {
		
		Scanner keyboard = new Scanner(System.in);
		Scanner scan = new Scanner(new File("GuestList.txt"));
	        
		int guests[] = new int[10];
		int roomNum;
		
		for (roomNum = 0; roomNum < 10; roomNum++) {
			
			guests[roomNum] = scan.nextInt();
			
		}
		
		System.out.println("Good Day! How can I help you today? (check-in / check-out)");
		String choice = keyboard.next();
		
		if ("check-in".equalsIgnoreCase(choice)) {
			
			//needs code
			
		} 
		
		if ("check-out".equalsIgnoreCase(choice)) {
			
			//needs code
		}
    
	}
}