/**
 * priority queue implemented as binary heap
 * @see  PriorityQueue.java
 * @author  FVCproductions
 * @since  2-19-15
 * @version  1.0
 */

public class BinaryHeap implements PriorityQueue {
		
	private double[] heap;
	private int size;
	
	/**  
	 * creates priority queue that sorts elements according to natural ordering
	 */
	public BinaryHeap() {
		this.heap = new double[10];
		this.size = 0;
	}
	
	/**  
	 * @return true if priority queue is empty, false otherwise
	 */
	public boolean isEmpty() {
		return size() == 0;
	}

	/**  
	 * @return # of elements in priority queue
	 */
	public int size() {
		return size;
	}

	/**
	 * @return smallest element in priority queue, throws EmptyPQException otherwise
	 */
	public double findMin() {
		if (this.isEmpty()) {
			throw new EmptyPQException("priority queue is empty");
		}		
		return heap[1];
	}

	/**  
	 * insert element into priority queue 
	 * @param x [element to be inserted]
	 */
	public void insert(double x) {
		// resize heap if not enough space
		if (size >= heap.length - 1) {
			resize();
		}
		size++;
		heap[size] = x;
		percolateUp();
	}

	/**  
	 * removes and returns smallest element from priority queue
	 * throws EmptyPQException if empty
	 * @return smallest element from priority queue
	 */
	public double deleteMin() {
		if (this.isEmpty()) {
			throw new EmptyPQException("priority queue is empty");
		}
		
		// record min value
		final double min = findMin();
		
		// remove min value
		heap[1] = heap[size];
		size--;
		
		// restore heap property
		percolateDown();
		return min;
	}

	/**  
	 * resets priority queue to empty
	 */
	public void makeEmpty() {
		heap = new double[10];
		size = 0;
	}
	
	/**  
	 * restores heap order property upon deletion of element
	 */
	private void percolateDown() {
		// start at "root"
		int index = 1;
		
		// look for smallest child
		while (hasLeftChild(index)) {
			int smallerChild = leftChild(index);
			
			if (hasRightChild(index) && heap[rightChild(index)] < heap[smallerChild]) {
				smallerChild = rightChild(index);
			}
			
			// if the smaller child is smaller than parent
			if (heap[index] > heap[smallerChild]) {
				// swap it with parent
				trade(index, smallerChild);
			} else {
				// otherwise stop looking
				break;
			}
			index = smallerChild;
		}
	}
	
	/**  
	 * restores heap order property upon insertion of element
	 */
	private void percolateUp() {
		int index = size;
		
		// check if "node's" parent is greater
		while (hasParent(index) && heap[index] < heap[parent(index)]) {
			// swap places and keep looking
			trade(index, parent(index));
			index = parent(index);
		}
	}
	
	/**  
	 * trade values of items in two indices
	 * @param  index1  [index to trade with index2]
	 * @param  index2  [index to trade with index1]
	 */
	private void trade(int index1, int index2) {
		final double temp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = temp;
	}
	
	/**  
	 * resize BinaryHeap when not enough space
	 */
	private void resize() {
		final double[] temp = new double[heap.length * 2];
		for (int i = 0; i <= size; i++) {
			temp[i] = heap[i];
		}
		heap = temp;
	}
	
	// private methods with formulas to keep code clean
	private boolean hasLeftChild(int i) {
		return leftChild(i) <= size;
	}
	
	private int leftChild(int i) {
		return i * 3 - 1;
	}
	
	private boolean hasMiddleChild(int i) {
		return middleChild(i) <= size;
	}
	
	private int middleChild(int i) {
		return i * 3;
	}
	
	private boolean hasRightChild(int i) {
		return rightChild(i) <= size;
	}
	
	private int rightChild(int i) {
		return i * 3 + 1;
	}
	
	private boolean hasParent(int i) {
		return i > 1;
	}
	
	private int parent(int i) {
		return (i + 1) / 3;
	}

}
