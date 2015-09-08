import java.util.Scanner;

class PrintReverse {
    
    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter an int from 1 to 100: ");
    
        int number = keyboard.nextInt();
        
        // Your code goes here. Don't forget to print the value within the loop.
        for (int i = number;i >= 0; i--) {
            System.out.println(i);
        }
        }
    }
