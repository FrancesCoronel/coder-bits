//fvcproductions
//programs reads a text file until there is no more data left

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class ReadTillNoData {
    
	public static void main(String args[]) throws IOException {
		Scanner fileScanner = new Scanner(new File("fake_text.txt")); //txt file doesn't exist
		while (fileScanner.hasNext()) {
    		System.out.println(fileScanner.nextLine());
		}
    }
}