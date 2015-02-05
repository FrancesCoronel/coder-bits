/**
 * FourHeap implements PriorityQueue interface using array. The FourHeap maintains in the way 
 * that the item has the least priority stored at root (first item in the array), 
 * and all the parent has less priority than its children.
 * 
 * @param <E>
 * @author Chun-Wei Chen
 * @version CSE 332 02/05/13
 */
public class FourHeap<E> implements PriorityQueue<E> {
	private E[] fourHeap;  // a four-heap
	private int size;      // size of the heap
	private Comparator<? super E> comparator;  // function object to compare elements of type E
	
	/**
	 * Construct an empty four-heap.
	 * 
	 * @param c a comparator object
	 */
	@SuppressWarnings("unchecked")
	public FourHeap(Comparator<? super E> c) {
		fourHeap = (E[]) new Object[10];
		size = 0;
		comparator = c;
	}
	
	/**
	 * Resize the array which holds the elements of heap if it is full.
	 */
	@SuppressWarnings("unchecked")
	private void resize() {
		E[] temp = (E[]) new Object[fourHeap.length * 2];
		for (int i = 0; i < size; i++) {
			temp[i] = fourHeap[i];
		}
		fourHeap = temp;
	}
	
	/**
	 * Insert a data into heap.
	 * 
	 * @param item a data to be stored in the heap
	 */
	public void insert(E item) {
		if (size == fourHeap.length)
			resize();  // resize the heap if the heap is full
		size++;
		int i = percolateUp(size - 1, item);
		fourHeap[i] = item;
	}
	
	/**
	 * Swap the position of new data and its parent if compare method returns negative value, 
	 * and return the index of the position to put the new data.
	 * 
	 * @param hole the index of the array currently holds data val
	 * @param val a data
	 * @return the index of the array to put data val
	 */
	private int percolateUp(int hole, E val) {
		while (hole > 0 && comparator.compare(val, fourHeap[(hole - 1) / 4]) < 0) {
			fourHeap[hole] = fourHeap[(hole - 1) / 4];
			hole = (hole - 1) / 4;
		}
		return hole;
	}
	
	/**
	 * Return the item at the top of the heap in the heap without modifying the heap.
	 * 
	 * @return the item at the top of the heap
	 * @throws java.util.NoSuchElementException if the heap is empty
	 */
	public E findMin() {
		if (isEmpty())
			throw new java.util.NoSuchElementException();
		return fourHeap[0];
	}
	
	/**
	 * Return the item at the top of the heap and remove it from the heap.
	 * 
	 * @return the item at the top of the heap
	 * @throws java.util.NoSuchElementException if the heap is empty
	 */
	public E deleteMin() {
		E min = findMin();
		int hole = percolateDown(0, fourHeap[size - 1]);
		fourHeap[hole] = fourHeap[size - 1];
		size--;
		return min;
	}
	
	/**
	 * Move the last item to the root of the heap and move it to the appropriate position. 
	 * Swap the position of the parent and one of the child if compare method returns negative value. 
	 * Return the index of the position to put the last item.
	 * 
	 * @param hole the index of the array currently holds data val
	 * @param val a data
	 * @return the index of the array to put data val
	 */
	private int percolateDown(int hole, E val) {
		while (4 * hole + 1 < size) {
			int first = 4 * hole + 1;
			int second = first + 1;
			int third = second + 1;
			int fourth = third + 1;
			int target;
			// determine which child should be compared to and possibly be swapped with parent
			if (second > size - 1 || third > size - 1 && comparator.compare(fourHeap[first], fourHeap[second]) < 0 
				|| fourth > size - 1 && comparator.compare(fourHeap[first], fourHeap[second]) < 0 && comparator.compare(fourHeap[first], fourHeap[third]) < 0 
				|| comparator.compare(fourHeap[first], fourHeap[second]) < 0 && comparator.compare(fourHeap[first], fourHeap[third]) < 0 && comparator.compare(fourHeap[first], fourHeap[fourth]) < 0) {
				target = first;
			} else if (third > size - 1 && comparator.compare(fourHeap[second], fourHeap[first]) < 0 
					   || fourth > size - 1 && comparator.compare(fourHeap[second], fourHeap[first]) < 0 && comparator.compare(fourHeap[second], fourHeap[third]) < 0 
					   || comparator.compare(fourHeap[second], fourHeap[first]) < 0 && comparator.compare(fourHeap[second], fourHeap[third]) < 0 && comparator.compare(fourHeap[second], fourHeap[fourth]) < 0) {
				target = second;
			} else if (fourth > size - 1 && comparator.compare(fourHeap[third], fourHeap[first]) < 0 && comparator.compare(fourHeap[third], fourHeap[second]) < 0 
					   || comparator.compare(fourHeap[third], fourHeap[first]) < 0 && comparator.compare(fourHeap[third], fourHeap[second]) < 0 && comparator.compare(fourHeap[third], fourHeap[fourth]) < 0) {
				target = third;
			} else {
				target = fourth;
			}
			if (comparator.compare(fourHeap[target], val) < 0) {
				fourHeap[hole] = fourHeap[target];
				hole = target;
			} else {
				break;
			}
		}
		return hole;
	}
	
	/**
	 * Return true if the heap is empty.
	 * 
	 * @return true if the heap is empty
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * Return string representation of the array contains all the items in four-heap.
	 * 
	 * @return string representation of the array contains all the items in four-heap 
	 */
	protected String getFourHeapInString() {
		String result = "[";
		for(int i = 0; i < size - 1; i++)
			result += fourHeap[i] + ", ";
		result += fourHeap[size - 1] + "]";
		return result;
	}
}