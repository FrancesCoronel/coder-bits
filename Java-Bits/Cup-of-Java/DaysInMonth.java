//fvcproductions
//prints out the days of the month based on what month # user gives

import java.util.Scanner;
import static java.lang.System.out;

class DaysInMonth {

    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Enter the month number please:  ");
        int monthNumber = keyboard.nextInt();
        
        switch (monthNumber) {
            
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                out.println("There are 31 days in that month");
                break;
            case 2: case 4: case 6: case 9: case 11:
                out.println("There are 28 days in that month");
                break;
        
        }
    }    
}
