/*
The Java Motel
Instructions

In this exercise, we will simulate a motel reservation system for our “Java Motel”. We will create an int array of length 10, to simulate the rooms. Each of these components will store an int value, indicating the number of guests in a room.

The exercise reads the number of guests in a room, from a txt file. The txt file is shown below:

1 4 2 0 2 1 4 3 0 2
Observe the following:

The initialization statement, int guests[] = new int[10]
How values are stored in an array, using indices. For example, guests[roomNum] = diskScanner.nextInt()
Use of for loops to access value at each index.
Click on Save to compile the code and then click on Run to view the output.

*/
import static java.lang.System.out;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

class ShowGuests {

    public static void main(String args[]) 
                                  throws IOException {
        int guests[] = new int[10];
        Scanner diskScanner = 
               new Scanner(new File("GuestList.txt"));

        for(int roomNum = 0; roomNum < 10; roomNum++) {
            guests[roomNum] = diskScanner.nextInt();
        }

        out.println("Room\tGuests");

        for(int roomNum = 0; roomNum < 10; roomNum++) {
            out.print(roomNum);
            out.print("\t");
            out.println(guests[roomNum]);
        }
    }
}
