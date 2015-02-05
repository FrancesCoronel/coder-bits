import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test for FourHeap.
 * 
 * @author Chun-Wei Chen
 * @version CSE 332 02/05/13
 */
public class TestFourHeap {
	private static final int TIMEOUT = 2000;
	private FourHeap<Integer> fh;
	
	@Before
	public void setUp() throws Exception {
		fh = new FourHeap<Integer>(new Comparator<Integer>() {
			public int compare(Integer e1, Integer e2) {
				return e1 - e2;
			}
		});
	}
	
	@Test(timeout = TIMEOUT)
	public void testIsEmptyWhenConstructed() {
		assertTrue(fh.isEmpty());
	}
	
	@Test(timeout = TIMEOUT)
	public void testIsEmptyAfterInsert1() {
		fh.insert(1);
		assertFalse(fh.isEmpty());
	}
	
	@Test(timeout = TIMEOUT)
	public void testResizeWhenStoring11thItem() {
		fh.insert(2);
		fh.insert(1);
		fh.insert(6);
		fh.insert(4);
		fh.insert(7);
		fh.insert(8);
		fh.insert(3);
		fh.insert(5);
		fh.insert(9);
		fh.insert(11);
		fh.insert(111); // won't be able to insert this one if it doesn't resize since initial capacity is 10
	}

	@Test(timeout = TIMEOUT)
	public void testPercolateUp() {
		int[] arr = {3, 5, 2, 4, 1};
		for(int i = 0; i < arr.length; i++)
			fh.insert(arr[i]);
		String expected = "[1, 5, 3, 4, 2]";
		String actual = fh.getFourHeapInString();
		assertEquals(expected, actual);
	}
	
	@Test(timeout = TIMEOUT)
	public void testFindMin() {
		int[] arr = {3, 5, 2, 1, 4};
		for(int i = 0; i < arr.length; i++)
			fh.insert(arr[i]);
		int min = fh.findMin();
		assertEquals(1, min);
	}

	@Test(timeout = TIMEOUT)
	public void testPercolateDown() {
		int[] arr = {3, 5, 2, 1, 4};
		for(int i = 0; i < arr.length; i++)
			fh.insert(arr[i]);
		fh.deleteMin();
		String expected = "[2, 5, 3, 4]";
		String actual = fh.getFourHeapInString();
		assertEquals(expected, actual);
	}
}