import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test for MoveToFrontList.
 * 
 * @author Chun-Wei Chen
 * @version CSE 332 02/05/13
 */
public class TestMoveToFrontList {
	private static final int TIMEOUT = 2000;
	private MoveToFrontList<Integer> list;
	
	@Before
	public void setUp() throws Exception {
		list = new MoveToFrontList<Integer>(new Comparator<Integer>() {
			public int compare(Integer e1, Integer e2) {
				return e1 - e2;
			}
		});
	}
	
	@Test(timeout = TIMEOUT)
	public void listHasSize0WhenConstructed() {
		assertEquals("Constructed a list and checked its size", list.getSize(), 0);
	}
	
	private void addAndTestSize(int[] nums, int unique) {
		for(int i = 0; i < nums.length; i++)
			list.incCount(nums[i]);
		assertEquals("Added list of numbers " + intArrayToString(nums) + " to tree", 
				     unique, list.getSize());
	}
	
	@Test(timeout = TIMEOUT)
	public void listHasSize1AfterAdding1() {
		addAndTestSize(new int[]{1}, 1);
	}
	
	@Test(timeout = TIMEOUT)
	public void listHasSize1AfterAddingRepeat1s() {
		addAndTestSize(new int[]{1,1}, 1);
	}
	
	@Test(timeout = TIMEOUT)
	public void listHasSize5AfterAdding1To5() {
		addAndTestSize(new int[]{1,2,3,4,5}, 5);
	}
	
	@Test(timeout = TIMEOUT)
	public void listHasSize5AfterAddingRepeat1To5s() {
		addAndTestSize(new int[]{1,1,1,2,2,3,3,3,3,4,4,4,5,5,5,5,5}, 5);
	}
	
	@Test(timeout = TIMEOUT)
	public void listHasSize5AfterAddingRepeat1To5sInSequence() {
		addAndTestSize(new int[]{1,2,3,4,5,1,2,3,4,5}, 5);
	}
	
	private void addAndGetCount(int[] nums, int getThis, int expected) {
		for(int i = 0; i < nums.length; i++)
			list.incCount(nums[i]);
		int actual = list.getCount(getThis);
		assertEquals("Added " + intArrayToString(nums) + " and got count of " + getThis, 
				     expected, actual);
	}
	
	@Test(timeout = TIMEOUT)
	public void listHas5of1s() {
		addAndGetCount(new int[]{1,1,1,1,1}, 1, 5);
	}
	
	@Test(timeout = TIMEOUT)
	public void listHas4of1s() {
		addAndGetCount(new int[]{1,2,3,1,0,1,2,1,0}, 1, 4);
	}
	
	@Test(timeout = TIMEOUT)
	public void iteratorGetsAllDataFromTree() {
		int[] startArray = {3, -2, -4, -2, 3, 5, 1, 5, -2, 1};
		String startArrayToString = intArrayToString(startArray);
		for(int i = 0; i < startArray.length; i++)
			list.incCount(startArray[i]);
		int[] expected = {1, -2, 5, 3, -4};
		
		SimpleIterator<DataCount<Integer>> it = list.getIterator();
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
	public void iteratorThrows() { 
		list.incCount(21); 
		SimpleIterator<DataCount<Integer>> iter = list.getIterator();
		iter.next();
		iter.next(); // throw exception
	}
	
	private String intArrayToString(int[] nums) {
		if(nums.length == 0)
			return "{}";
		String s = "{" + nums[0];
		for(int i = 1; i < nums.length; i++)
			s += "," + nums[i];
		s += "}";
		return s;
	}
}