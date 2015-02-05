import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test for Hashtable.
 * 
 * @author Chun-Wei Chen
 * @version CSE 332 02/18/13
 */
public class TestHashtable {
	private static final int TIMEOUT = 2000;
	private Hashtable<Integer> ht;
	
	@Before
	public void setUp() throws Exception {
		ht = new Hashtable<Integer>(new Comparator<Integer>() {
			public int compare(Integer e1, Integer e2) {
				return e1 - e2;
			}
		}, new Hasher<Integer>() {
			public int hash(Integer e) {
				return Math.abs(e);
			}
		});
	}

	@Test(timeout = TIMEOUT)
	public void tableHasSize0WhenConstructed(){
		assertEquals("Constructed a table and checked its size", ht.getSize(), 0);
	}
	
	private void addAndTestSize(int[] nums, int unique){
		for(int i = 0; i < nums.length; i++)
			ht.incCount(nums[i]);
		assertEquals("Added list of numbers " + intArrayToString(nums) + " to tree", unique, ht.getSize());
	}
	
	@Test(timeout = TIMEOUT)
	public void hashtableHasSize1AfterAdding2() {
		addAndTestSize(new int[]{2}, 1);
	}
	
	@Test(timeout = TIMEOUT)
	public void hashtableHasSize1AfterAddingRepeat2s() {
		addAndTestSize(new int[]{2,2}, 1);
	}
	
	@Test(timeout = TIMEOUT)
	public void hashtableHasSize5AfterAdding1To5() {
		addAndTestSize(new int[]{1,2,3,4,5}, 5);
	}
	
	@Test(timeout = TIMEOUT)
	public void hashtableHasSize5AfterAddingRepeat1To5s() {
		addAndTestSize(new int[]{1,1,1,2,2,3,3,3,3,4,4,4,5,5,5,5,5}, 5);
	}
	
	@Test(timeout = TIMEOUT)
	public void hashtableHasSize5AfterAddingRepeat1To5sInSequence() {
		addAndTestSize(new int[]{1,2,3,4,5,1,2,3,4,5}, 5);
	}
	
	private void addAndGetCount(int[] nums, int getThis, int expected) {
		for(int i = 0; i < nums.length; i++)
			ht.incCount(nums[i]);
		int actual = ht.getCount(getThis);
		assertEquals("Added " + intArrayToString(nums) + " and got count of " + getThis, 
				     expected, actual);
	}
	
	@Test(timeout = TIMEOUT)
	public void hashtableHas5of1s() {
		addAndGetCount(new int[]{1,1,1,1,1}, 1, 5);
	}
	
	@Test(timeout = TIMEOUT)
	public void hashtableHas4of1s() {
		addAndGetCount(new int[]{1,2,3,1,0,1,2,1,0}, 1, 4);
	}
	
	@Test(timeout = TIMEOUT)
	public void testHashtableStructureAndCount() {
		int[] startArray = {3, -2, -4, -2, 3, 5, 1, 7};
		for(int i = 0; i < startArray.length; i++)
			ht.incCount(startArray[i]);
		String expected = "([X][1,1][-2,2][3,2][-4,1][5,1][X][7,1][X][X][X])";
		String actual = ht.dataAndCount();
		assertEquals(expected, actual);
	}
	
	@Test(timeout = TIMEOUT)
	public void testHashtableStructureAndCountAndCollision() {
		int[] startArray = {3, -2, -4, -2, 3, 5, 1, 5, 2, -1};
		for(int i = 0; i < startArray.length; i++)
			ht.incCount(startArray[i]);
		String expected = "([X][1,1][-2,2][3,2][-4,1][5,2][2,1][-1,1][X][X][X])";
		String actual = ht.dataAndCount();
		assertEquals(expected, actual);
	}
	
	@Test(timeout = TIMEOUT)
	public void iteratorGetsAllDataFromTable() {
		int[] startArray = {3, -2, -4, -2, 3, 5, 1, 5, 2, -1};
		String startArrayToString = intArrayToString(startArray);
		for(int i = 0; i < startArray.length; i++)
			ht.incCount(startArray[i]);
		int[] expected = {1, -2, 3, -4, 5, 2, -1};
		
		SimpleIterator<DataCount<Integer>> it = ht.getIterator();
		int[] actual = new int[expected.length];
		int i = 0;
		while(it.hasNext()) {
			actual[i] = it.next().data;
			i++;
		}
		assertArrayEquals("Added " + startArrayToString + " and used iterator", 
				          expected, actual);
	}
	
	@Test(timeout = TIMEOUT, expected = java.util.NoSuchElementException.class)
	public void iteratorThrows(){ 
		ht.incCount(21); 
		SimpleIterator<DataCount<Integer>> iter = ht.getIterator();
		iter.next();
		iter.next();
	}
	
	@Test(timeout = TIMEOUT)
	public void hashtableResizeWhenItIsFull() {
		int[] arr = {1, 12, 23, 34, 45, 56, 67, 78, 89, 100, 111, 123};
		for (int i = 0; i < arr.length; i++)
			ht.incCount(arr[i]);
		String expected = "([23,1][1,1][X][X][X][X][X][X][100,1][78,1][56,1][34,1][12,1]" +
				          "[123,1][X][X][X][X][X][111,1][89,1][67,1][45,1])";
		String actual = ht.dataAndCount();
		assertEquals(expected, actual);
	}
	
	private String intArrayToString(int[] nums){
		if(nums.length == 0)
			return "{}";
		String s = "{" + nums[0];
		for(int i = 1; i < nums.length; i++)
			s += "," + nums[i];
		s += "}";
		return s;
	}
}