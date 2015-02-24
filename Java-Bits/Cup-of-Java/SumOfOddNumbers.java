//incomplete

import java.util.Scanner;

class SumOfOddNumbers {

    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a number from 10 to 100: ");
        int n = keyboard.nextInt();
        int sum = 0;
        
        // Your code goes here
        for (int i = 1; i <= n; i = i + 2) {
            sum += 1;
        }

/*
for (int i = 0; i <= n; i++) {
    if (i % 2 != 0) {
        sum += i; // or you can even do sum = sum + i;   
    }
}
*/
        System.out.println(sum);
    }    
}