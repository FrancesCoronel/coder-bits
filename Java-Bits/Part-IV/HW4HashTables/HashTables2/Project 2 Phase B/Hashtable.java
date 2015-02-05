/**
 * Hashtable implements the DataCounter interface using a hash table.
 * 
 * @param <E> type of data whose count we are recording.
 * @author Chun-Wei Chen
 * @version CSE 332 02/18/13
 */
public class Hashtable<E> implements DataCounter<E> {
	private Node[] hashtable;  // hash table
	private int size;          // size of the hash table
	private Hasher<? super E> hasher;  // function object to hash elements of type E into integer value, passed in constructor
	protected Comparator<? super E> comparator; // function object to compare elements of type E, passed in constructor
	
	/**
	 * Inner 'Node' class.
	 */
	protected class Node {
		public E data;     // a data of type E
		public int count;  // the count for this data element
		
		/**
		 * Constructs a node which holds a data of type E and a pointer to the next node
		 * 
		 * @param d a data of type E
		 * @param c the count of the data
		 */
		public Node(E d, int c) {
			data = d;
			count = c;
		}	
	}
	
	/**
	 * Construct an empty hash table.
	 * 
	 * @param c function object to compare elements of type E
	 * @param h function object to hash elements of type E into integer value
	 */
	@SuppressWarnings("unchecked")
	public Hashtable(Comparator<? super E> c, Hasher<? super E> h) {
		hashtable = (Node[]) new Hashtable.Node[11];
		size = 0;
		comparator = c;
		hasher = h;
	}
	
	/**
     * Increase the count for a particular data element.
     * 
     * @param data data element whose count is to be increased
     */
	public void incCount(E data) {
		if (size == hashtable.length)
			rehash();
		int key = hasher.hash(data) % hashtable.length;
		while (hashtable[key] != null) {
			if (hashtable[key].data.equals(data)) {
				hashtable[key].count += 1;
				return;
			}
			key = (key + 1) % hashtable.length;
		}
		hashtable[key] = new Node(data, 1);
		size++;	
	}
	
	/**
	 * Rehash the hash table when it is full.
	 */
	@SuppressWarnings("unchecked")
	private void rehash() {
		Node[] temp = (Node[]) new Hashtable.Node[2 * hashtable.length + 1];
		int newKey;
		for (int i = 0; i < hashtable.length; i++) {
			if (hashtable[i] != null) {
				newKey = (hasher.hash(hashtable[i].data)) % temp.length;
				while (temp[newKey] != null) {
					newKey = (newKey + 1) % temp.length;
				}
				temp[newKey] = new Node(hashtable[i].data, hashtable[i].count);
			}
		}
		hashtable = temp;
	}

	/**
     * The number of unique data elements in the hash table.
     * 
     * @return the number of unique data elements in the hash table.
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
		int key = hasher.hash(data) % hashtable.length;
		if (hashtable[key] == null) {
			return 0;
		} else if (hashtable[key].data.equals(data)) {
			return hashtable[key].count;
		}
		int key2 = (hasher.hash(data) + 1) % hashtable.length;
		while (hashtable[key2] != null && key2 != key) {
			if (hashtable[key2].data.equals(data))
				return hashtable[key2].count;
			key2 = (key2 + 1) % hashtable.length;
		}
		return 0;
	}

	/**
	 * Iterator for hash table.
	 * 
	 * @return an iterator for the elements.
	 */
	public SimpleIterator<DataCount<E>> getIterator() {
		return new SimpleIterator<DataCount<E>>() {
			int count = 0;
			int idx = 0;
			
    		/**
    		 * Return true if the list has another item to be iterated.
    		 * 
    		 * @return true if the list has another item to be iterated
    		 */
    		public boolean hasNext() {
        		return count < size;
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
        		while (hashtable[idx] == null)
        			idx++;
        		count++;
        		idx++;
        		return new DataCount<E>(hashtable[idx - 1].data, hashtable[idx - 1].count);
        	}
		};
	}
	
	/**
	 * Return string representation of the hash table.
	 * 
	 * @return string representation of the hash table
	 */
	protected String dataAndCount() {
		if (hashtable != null)
			return dataAndCount(hashtable);
		return "<EmptyTable>";
	}
	
	/**
	 * Helper method to produce string representation of the hash table.
	 * 
	 * @param ht a hash table
	 * @return string representation of the hash table
	 */
	private String dataAndCount(Node[] ht) {
		String result = "(";
		for (int i = 0; i < ht.length; i++) {
			if (ht[i] != null)
				result += "[" + ht[i].data + "," + ht[i].count + "]";
			else
				result += "[X]";
		}
		result += ")";
		return result;
	}
}