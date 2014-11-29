/*

Frances
CSC 251
November 20, 2014
Detailed Description of each file and what it is supposed to do

"I Frances have completed this program individually without any student or faculty support. The penalty for not completing this program individually is a zero for the program and admission of CHEATING in my student file."

*/

import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;

public class DLinkListFC {
	
	public static void main(String[] args) throws IOException {
		
		MyLinkedListFC myList = new MyLinkedListFC();
		
		String command;
		String stringWord = "";					
		
		File inputFile = new File("list.txt");
		Scanner readFile = new Scanner(inputFile);
	
		while(readFile.hasNext()) {
		
			String newLine = readFile.nextLine();
			
			StringTokenizer st = new StringTokenizer(newLine);
			command = st.nextToken();
			System.out.print("Command: " + command);
			
			if (st.hasMoreTokens()) {
				
				stringWord = st.nextToken();
				System.out.print(" " + stringWord);
			
			}
			
			System.out.println();
			
			if(command.equals("add")) { //had to complete
			
				myList.add(stringWord);
			
			}
			
			else if(command.equals("size")) { //had to complete
				
				myList.size();
				
			}
			
			else if(command.equals("printForward")) { //had to complete
				
				myList.printForward();
			}

			else if(command.equals("printReverse")) { //had to complete
			
				myList.printReverse();
				
			}

			else if(command.equals("isEmpty")) { //had to complete
				
				if(myList.isEmpty()) {
					
					System.out.println("List is empty.");
				
				}
				
				else {
				
					System.out.println("List is not empty.");
				
				}
			}
			
			else if(command.equals("get")) {
				
				try {
					
					myList.EmptyListException();
					
					try {
						
						myList.ItemNotPresentException(stringWord);
						System.out.print("\t" + myList.get(stringWord));
						System.out.println("  ***Successful!***");
						System.out.println();
					}
					
					catch(MyLinkedListExceptionFC notPresent) {
						
						System.out.println("\t***Unsuccessful*** \n" + notPresent.getMessage());
						System.out.print("List: ");
						myList.printForward();
						System.out.println();
					
					}	
				}
				
				catch(MyLinkedListExceptionFC underflow) {
					
					System.out.println("\t***Unsuccessful*** \n" + underflow.getMessage());
					System.out.println();
				
				}
			
			}

			else if(command.equals("remove")) { //had to complete
				
				try {
					
					myList.EmptyListException();
					
					try {

					}
					
					catch(MyLinkedListExceptionFC notPresent) {
               
						System.out.println("\t***Unsuccessful*** \n" + notPresent.getMessage());
						System.out.print("List: ");
						myList.printForward();
						System.out.println();
					
					}
				}
				
				catch(MyLinkedListExceptionFC underflow) {
               
					System.out.println("\t***Unsuccessful*** \n" + underflow.getMessage());
					System.out.println();
				
				}
			}
			
			else if(command.equals("clear")) { //had to complete
      			
				myList.clear();
			
			}

			else {
				
				System.out.println("!!!Command not clear!!!");
				System.out.println();
			
			}
	
		}
		
		readFile.close();				
	
	}
}