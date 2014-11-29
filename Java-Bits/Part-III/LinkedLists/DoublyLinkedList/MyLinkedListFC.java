/*

Frances
CSC 251
November 20, 2014
Detailed Description of each file and what it is supposed to do

"I Frances have completed this program individually without any student or faculty support. The penalty for not completing this program individually is a zero for the
program and admission of CHEATING in my student file."

*/

public class MyLinkedListFC { //replaced with my initials so FC
	
	private static class Node<String> {
		
		public Node(String i) {
			
			info = i;							
		
		}
		
		public String info;						
		public Node<String> previous;			
		public Node<String> next;				
	
	}
	
	public int numItems = 0; //acts as our counter		
	public Node<String> last; //acts as tail			
	public Node<String> position; //acts as current position
	public Node<String> list; //acts as head				
	
	public MyLinkedListFC() { //replaced with my initials so FC
		
		clear();
	
	}

	public void clear() { //had to complete
		
		list = last = null;
		
	}

	public boolean isEmpty() { //had to complete
		
		return (list == last == null);
	}
	
	public String size() { //had to complete
	
		position = list;
		
		while(!position.info.equalsIgnoreCase(aString) && position.next != null) {
			
			numItems++;
			position = position.next;
			
		}
		
		return numItems.toString();
									
	}
	
	public void add(String aString) { //had to complete
		
        Node last = post.prev;
        Node x = new Node();
        x.item = item;
        x.next = post;
        x.prev = last;
        post.prev = x;
        last.next = x;
        N++;
		
		 Node x = current.prev;
		            Node y = new Node();
		            Node z = current;
		            y.item = item;
		            x.next = y;
		            y.next = z;
		            z.prev = y;
		            y.prev = x;
		            N++;
		            index++;
		            lastAccessed = null;
	}
	
	public String get(String aString) { //had to complete
		
		position = list;
		
		while(!position.info.equalsIgnoreCase(aString) && position.next != null) {
			
			position = position.next;
			
		}
		
		return position.info;
	}
	
	
	public String remove(String aString) { //had to complete
		
		position = list;
								
		while(!position.info.equalsIgnoreCase(aString) && position.next != null) {
			
			if(list == last) {
	      
			}
			
			else if(position == list) {
	   
			}
			
			else if(position == last) {     
				
			}
			
			else {
	         
			}
		
		}
		
		numItems--;	
		
		return aString;	
							
	}
	
	public void printForward() { //had to complete
		
		position = list;
		
		while (position != null) {
			
			System.out.println(position.info + " ");
			position = position.next;
		
		}
		
		System.out.println();
	}
	
	public void printReverse() { //had to complete
		
		position = last;
		
		while (position != null) {
			
			System.out.println(position.info + " ");
			position = position.previous;
		
		}
		
		System.out.println();
		
	}
	
	public void EmptyListException() throws MyLinkedListExceptionFC { //had to complete
		
		MyLinkedListExceptionFC underflow = new MyLinkedListExceptionFC("Error. The list is empty.");
		
		if (isEmpty()) {
			
			throw underflow;
		
		}
		
	}
	
	
	public void ItemNotPresentException(String aString) throws MyLinkedListExceptionFC { //had to complete
   
		MyLinkedListExceptionFC notPresent = new MyLinkedListExceptionFC("Error. That item is not present in the linked list.");
		
		position = list;
		found = false;
			
		while (position != null) {
			
			if (aString == position.info) {
				
				found = true;
			
			}
			
			position = position.next;

		}
		
		if(found == false) {
			
			throw notPresent;
		
		}
		
	}
	
}