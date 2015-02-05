/** 
 * interface for a priority queue that your FourHeap should implement
 */
public interface PriorityQueue<E> {
	void insert(E item);
	E findMin();
	E deleteMin();
	boolean isEmpty();
}
