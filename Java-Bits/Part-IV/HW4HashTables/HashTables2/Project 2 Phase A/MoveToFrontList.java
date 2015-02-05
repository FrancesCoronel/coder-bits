/**
 * MoveToFrontList implements the DataCounter interface using a LinkedList.
 * It either adds new item to the front of the list, or increases the count of 
 * the item and moves the node of the item to the front of the list.
 * 
 * @param <E>
 * @author Chun-Wei Chen
 * @version CSE 322 02/05/13
 */
public class MoveToFrontList<E> implements DataCounter<E> {
	private Node MTFList;  // pointer to the head of the move-to-front-list
	private int size;      // size of the move-to-front list
	protected Comparator<? super E> comparator;  // function object to compare elements of type E, passed in constructor
	
	/**
	 * Inner 'Node' class.
	 */
	protected class Node {
		public E data;     // a data of type E
		public int count;  // the count for this data element
		public Node next;  // pointer to the next node
		
		/**
		 * Constructs a node which holds a data of type E and a pointer to the next node
		 * 
		 * @param d a data of type E
		 * @param n pointer to next node
		 */
		public Node(E d, Node n) {
			data = d;
			count = 1;
			next = n;
		}	
	}
	
	/**
	 * Construct an empty move-to-front list.
	 * 
	 * @param c function object to compare elements of type E
	 */
	public MoveToFrontList(Comparator<? super E> c) {
		MTFList = null;
		size = 0;
		comparator = c;
	}
	
	/**
     * Increase the count for a particular data element.
     * 
     * @param data data element whose count is to be increased
     */
    public void incCount(E data) {
    	if (MTFList == null) {
    		MTFList = new Node(data, null);
    		size++;
    		return;
    	}
    	Node p = MTFList;  // create a pointer that points to the front of the move-to-front list
    	if (p.data.equals(data)) {
    		p.count++;  // increase the count if the data is already in the list
			return;
    	}
    	while (p.next != null) {
    		if (p.next.data.equals(data)) {
    			p.next.count++;  // increase the count if the data is already in the list
    			// move the node to the front of the list
    			Node temp = p.next;
    			p.next = p.next.next;
    			temp.next = MTFList;
    			MTFList = temp;
    			return;
    		}
    		p = p.next;
    	}
    	// add new item to the front of the list;
    	MTFList = new Node(data, MTFList);
    	size++;
    }

    /**
     * The number of unique data elements in the structure.
     * 
     * @return the number of unique data elements in the structure.
     */
    public int getSize() {
    	return size;
    }
   
    /**
     * The current count for the data, 0 if it is not in the counter.
     * 
     * @param data the data whose count is asked to be found
     * @return the current count for the data, 0 if it is not in the counter
     */
    public int getCount(E data) {
    	Node p = MTFList;
    	if (p.data.equals(data))
    		return p.count;
    	while (p.next != null) {
    		if (p.next.data.equals(data)) {
    			// move the node to the front of the list
    			Node temp = p.next;
    			p.next = p.next.next;
    			temp.next = MTFList;
    			MTFList = temp;
    			return temp.count;
    		}
    		p = p.next;
    	}
    	return 0;  // data passed in is not in the list
    }
    
    /**
     * Clients must not increment counts between an iterator's creation and its
     * final use.  Data structures need not check this.
     * 
     * @return an iterator for the elements.
     */
    public SimpleIterator<DataCount<E>> getIterator() {
    	return new SimpleIterator<DataCount<E>>() {
    		Node head = MTFList;  // create a pointer that points to the front of the move-to-front list
    		/**
    		 * Return true if the list has another item to be iterated.
    		 * 
    		 * @return true if the list has another item to be iterated
    		 */
    		public boolean hasNext() {
        		return head != null;
        	}
    		
    		/**
    		 * Return the next item in the iteration
    		 *  
    		 * @return next item in the iteration
    		 * @throws java.util.NoSuchElementException if there is no element can be returned
    		 */
        	public DataCount<E> next() {
        		if(!hasNext())
        			throw new java.util.NoSuchElementException();
        		Node nextNode = head;
        		head = head.next;
        		nextNode.next = null;
        		return new DataCount<E>(nextNode.data, nextNode.count);
        	}
    	};
    }
}
