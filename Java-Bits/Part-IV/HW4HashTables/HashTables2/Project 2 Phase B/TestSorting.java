import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit test for sorting algorithms.
 * 
 * @author Chun-Wei Chen
 * @version CSE 332 02/19/13
 */
public class TestSorting {
	private static final int TIMEOUT = 2000;
	Integer[] array = new Integer[]{1, -5, -10, 3, 0, 2, -4, 8, 7};
	Integer[] expected = new Integer[]{-10, -5, -4, 0, 1, 2, 3, 7, 8};
	Comparator<Integer> c = new Comparator<Integer>() {
		public int compare(Integer e1, Integer e2) {
			return e1 - e2;
		}
	};

	@Test(timeout = TIMEOUT)
	public void testInsertionSort() {
		WordCount.insertionSort(array, c);
		assertArrayEquals(expected, array);
	}

	@Test(timeout = TIMEOUT)
	public void testHeapSort() {
		WordCount.heapSort(array, c);
		assertArrayEquals(expected, array);
	}

	@Test(timeout = TIMEOUT)
	public void testMergeSort() {
		WordCount.mergeSort(array, c);
		assertArrayEquals(expected, array);
	}
}