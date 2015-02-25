/**
 * priority queue implemented as ternary heap
 * @see  ThreeHeap.java
 * @author  FVCproductions
 * @since  2-19-15
 * @version  1.0
 */

public class ThreeHeap implements PriorityQueue {
	
	private double[] threeHeap;	//array representation of  threeHeap
	private int size;			//amount of elements in  priority queue

	//constructs priority queue ADT
	public ThreeHeap() {
		this.threeHeap = new double[10];
		this.size = 0;
	}
	
	/**
	  * @return true if priority queue is empty, false otherwise
	 */
	public boolean isEmpty() {
		return (this.size == 0);
	}

	/**  
	 * @return # of elements in priority queue
	 */	
	public int size() {
		return this.size;
	}

	/**
	 * @return smallest element in priority queue, throws EmptyPQException otherwise
	 */	
	public double findMin() {
		if (this.isEmpty()) {
			throw new EmptyPQException();
		}
		return this.threeHeap[1];
	}

	/**  
	 * insert element into priority queue 
	 * @param x [element to be inserted]
	 */
	public void insert(double x) {
		this.size++;
		//resize if necessary
		if (this.size == this.threeHeap.length) {
			double[] bigHeap = new double[this.threeHeap.length * 2];
			for (int i = 0; i < this.threeHeap.length; i++) {
				bigHeap[i] = this.threeHeap[i];
			}
			this.threeHeap = bigHeap;
		}
		int index = percolateUp(this.size, x);
		threeHeap[index] = x;	
	}

	/**  
	 * removes and returns smallest element from priority queue
	 * throws EmptyPQException if empty
	 * @return smallest element from priority queue
	 */
	public double deleteMin() {
		if (this.isEmpty()) {
			throw new EmptyPQException();
		}
		double min = threeHeap[1];
		int hole = percolateDown(1, threeHeap[this.size]);
		threeHeap[hole] = threeHeap[this.size];
		this.size--;
		return min;
		
	}

	/**  
	 * resets priority queue to empty
	 */
	public void makeEmpty() {
		this.threeHeap = new double[10];
		this.size = 0;
	}
	
	/**
	 * excludes index at 0
	 * @return [string representation of  three-heap as an array]
	 */
	//excludes index 0
	public String toString() {
		if (this.isEmpty()) {
			return "top [] bottom";
		} else {
			String result = "top [";
			for (int i = 1; i < this.size; i++) {
				result += threeHeap[i] + ", " ;
			}
			return result + threeHeap[size] + "] bottom";
		}
	}
	
	/**  
	 * restores heap order property upon insertion of element
	 */
	private int percolateUp(int hole, double val) {
		while (hole > 1 && val < threeHeap[(hole + 1) / 3]) {
			threeHeap[hole] = threeHeap[(hole + 1) / 3];
			hole = (hole + 1) / 3;
		}
		return hole;
	}
	
	/**  
	 * restores heap order property upon deletion of element
	 */
	private int percolateDown(int hole, double val) {
		int left;
		int mid;
		int right;
		int target;
		
		while (3 * hole - 1 <= this.size) {
			left = hole * 3 - 1;
			mid = left + 1;
			right = left + 2;
			if (mid > this.size ||
			(threeHeap[left] < threeHeap[mid] && threeHeap[left] < threeHeap[right])) {
				target = left;
			} else if (right > this.size ||
			threeHeap[mid] < threeHeap[left] && threeHeap[mid] < threeHeap[right]){
				target = mid;
			} else {
				target = right;
			}
			if (threeHeap[target] < val) { 
				threeHeap[hole] = threeHeap[target];
				hole = target;
			} else {
				break;
			}
		}
		return hole;
	}
}

