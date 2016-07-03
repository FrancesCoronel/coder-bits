//fvcproductions
//simple guessing game
//uses while loop

import static java.lang.System.out;
import java.util.Scanner;
import java.util.Random;

class LehGuessingGame {
    
    public static void main(String args[]) {
        
        Scanner keyboard = new Scanner(System.in);
        
        int numGuesses = 0; //counter for number of guesses
        int randomNumber = new Random().nextInt(10) + 1; //generating a random number from 1 to 10

        out.println("Enter an int from 1 to 10: "); //asking user for number
        int inputNumber = keyboard.nextInt();
        
        numGuesses++; //increasing number of guesses
        
        while (inputNumber != randomNumber) {
            
            out.println();
            out.println("Try again...");
            out.println("Enter an int from 1 to 10: "); //asking user again if guess is incorrect
            inputNumber =  keyboard.nextInt();
            numGuesses++;
        
        }
        
        out.print("You win after ");
        out.println(numGuesses + " guesses.");
        
    }
}
