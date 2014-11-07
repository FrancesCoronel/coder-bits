// Frances Coronel
// Linked Lists Implementation - Java


// importing necessary classes

import java.util.*;

// declaring Node class

class Node {
	
	// declaring Node next
	// declaring int data
	
	Node next;
    int data;
    
	// creating constructor for Node that has 1 input argument of value/dataEntry
	
	public Node(int value) {
		
		data = value;
		next = null;
    
	}

}

// actual class with linked list methods

class LinkedList {

	// head starts out as null
	
    private Node head = null;
	private Scanner keyboard = new Scanner(System.in);

    // addToEmpty method
    // adds node (assuming an empty list)

    public void addToEmpty(int item) {
		
		head = new Node(item);
		
	}

    // addToHead method
    // adds node to front/head of the list

    public void addToHead(int item) {
	
		Node lastNode = returnLast();
		
		if (lastNode == null) {
			
			head = new Node(item);
		
		} else {
			
			lastNode.next = new Node(item);
			
		}
	
	}

	// addToMid method
	// adds node to middle of the list

    public void addToMid(int item) {

		Node lastNode = returnLast();
		
		if (lastNode == null) {
			
			head = new Node(item);
		
		} else {
			
			lastNode.next = new Node(item);
			
		}

	}

	// addToEnd method
	// adds node to end of the list

    public void addToEnd(int item) {

		if (isEmpty()) {
			return;
		}

		while((head.next != null)) {
			head = head.next;
		}
		
		head.next = new Node(item);

	}

	// removeAfter method
	// removes the node that is lcoated after the argument node passed in

    public void removeAfter(int item) {
	
		if (isEmpty()) {
			
			return;
		
		}
		
		Node prev = null;
		
		Node current = head;
		
		while (current != null && current.data != item) {
			
			prev = current;
			current = current.next;
		
		}
		
		if (prev == null) {
		
			head = head.next;
			return;
		
		}
		
		if (current == null) {
			
			System.out.println("The node you are trying to remove does not exist.");
			return;

		}
		
		prev.next = current.next;
		
    }

    // removeLast method
	// removes last node 

	public void removeLast() {

		if(isEmpty()) {
			
			return;
		
		}
		
		Node temp = head;
		
		while (temp.next != null) {
			
			temp = temp.next;
			
		}

		head.next = temp.next;

	}

    // isEmpty method
    // checks if list is empty
    	// if empty, return true
    	// else, returns false

	public boolean isEmpty() {
		
		return (head == null);
	
	}
	
	// print method
	
	public void print() {
		
		if(isEmpty()) {
			
			System.out.print("The linked list is empty.");
			return;
		
		}
		
		Node temp = head;
		
		while (temp != null) {
	
			System.out.print(temp.data + " ---> " );
			temp = temp.next;
			
		}
	
	}
	
	// returnLast method
	// used for addToFront method 
	
	private Node returnLast() {
		
		if(isEmpty()) {
			
			return null;
		
		}
		
		Node temp = head;
		
		while (temp.next != null) {
			
			temp = temp.next;
			
		}
		
		return temp;
		
	}
	
	// main method
	// testing all methods

	public static void main(String[] args) throws IOException {
		
		// creating new object for LinkedList
		
		LinkedList myList = new LinkedList();
		
		

	}

}