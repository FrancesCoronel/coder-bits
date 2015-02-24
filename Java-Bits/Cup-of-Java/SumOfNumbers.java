//incomplete

import java.util.Scanner;
import static java.lang.System.out;

class SumOfNumbers {

    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter an int from 5 to 100: ");
        int n = keyboard.nextInt();
        int sum = 0;
        out.println("Sum is: ");
        // your for loop goes here
        for (sum = 1; sum < n; sum++) {
        }
        
        System.out.println(sum);
    }    
}