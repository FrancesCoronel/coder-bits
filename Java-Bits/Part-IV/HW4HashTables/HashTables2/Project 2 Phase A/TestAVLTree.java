import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test for AVLTree.
 * 
 * @author Chun-Wei Chen
 * @version CSE 332 02/05/13
 */
public class TestAVLTree {
	private static final int TIMEOUT = 2000;
	private AVLTree<Integer> avl;
	
	@Before
	public void setUp() throws Exception {
		avl = new AVLTree<Integer>(new Comparator<Integer>() {
			public int compare(Integer e1, Integer e2) {
				return e1 - e2;
			}
		});
	}
	
	@Test(timeout = TIMEOUT)
	public void treeHasSize0WhenConstructed() {
		assertEquals("Constructed a tree and checked its size", 
				     avl.getSize(), 0);
	}
	
	private void addAndTestSize(int[] nums, int unique) {
		for(int i = 0; i < nums.length; i++)
			avl.incCount(nums[i]);
		assertEquals("Added avl of numbers " + intArrayToString(nums) + " to tree", 
				     unique, avl.getSize());
	}
	
	@Test(timeout = TIMEOUT)
	public void avlHasSize1AfterAdding1() {
		addAndTestSize(new int[]{1}, 1);
	}
	
	@Test(timeout = TIMEOUT)
	public void avlHasSize1AfterAddingRepeat1s() {
		addAndTestSize(new int[]{1,1}, 1);
	}
	
	@Test(timeout = TIMEOUT)
	public void avlHasSize5AfterAdding1To5() {
		addAndTestSize(new int[]{1,2,3,4,5}, 5);
	}
	
	@Test(timeout = TIMEOUT)
	public void avlHasSize5AfterAddingRepeat1To5s() {
		addAndTestSize(new int[]{1,1,1,2,2,3,3,3,3,4,4,4,5,5,5,5,5}, 5);
	}
	
	@Test(timeout = TIMEOUT)
	public void avlHasSize5AfterAddingRepeat1To5sInSequence() {
		addAndTestSize(new int[]{1,2,3,4,5,1,2,3,4,5}, 5);
	}
	
	private void addAndGetCount(int[] nums, int getThis, int expected) {
		for(int i = 0; i < nums.length; i++)
			avl.incCount(nums[i]);
		int actual = avl.getCount(getThis);
		assertEquals("Added " + intArrayToString(nums) + " and got count of " + getThis, 
				     expected, actual);
	}
	
	@Test(timeout = TIMEOUT)
	public void avlHas5of1s() {
		addAndGetCount(new int[]{1,1,1,1,1}, 1, 5);
	}
	
	@Test(timeout = TIMEOUT)
	public void avlHas4of1s() {
		addAndGetCount(new int[]{1,2,3,1,0,1,2,1,0}, 1, 4);
	}
	
	@Test(timeout = TIMEOUT)
	public void testAVLStructureAndCount() {
		int[] startArray = {3, -2, -4, -2, 3, 5, 1, 5, -2, 1};
		for(int i = 0; i < startArray.length; i++)
			avl.incCount(startArray[i]);
		String expected = "([-2,3] ([-4,1] . .) ([3,2] ([1,2] . .) ([5,2] . .)))";
		String actual = avl.dump();
		assertEquals(expected, actual);
	}
	
	@Test(timeout = TIMEOUT)
	public void testAVLStructureAndHeight() {
		int[] startArray = {3, -2, -4, -2, 3, 5, 1, 5, -2, 1, 6};
		for(int i = 0; i < startArray.length; i++)
			avl.incCount(startArray[i]);
		String expected = "([3,2] ([-2,1] ([-4,0] . .) ([1,0] . .)) ([5,1] . ([6,0] . .)))";
		String actual = avl.dataAndHeight();
		assertEquals(expected, actual);
	}
	
	@Test(timeout = TIMEOUT)
	public void testSingleRotationCase1() {
		int[] startArray = {3, -2, -4};
		for(int i = 0; i < startArray.length; i++)
			avl.incCount(startArray[i]);
		String expected = "([-2,1] ([-4,0] . .) ([3,0] . .))";
		String actual = avl.dataAndHeight();
		assertEquals(expected, actual);
	}
	
	@Test(timeout = TIMEOUT)
	public void testSingleRotationCase4() {
		int[] startArray = {-4, -2, 3};
		for(int i = 0; i < startArray.length; i++)
			avl.incCount(startArray[i]);
		String expected = "([-2,1] ([-4,0] . .) ([3,0] . .))";
		String actual = avl.dataAndHeight();
		assertEquals(expected, actual);
	}
	
	@Test(timeout = TIMEOUT)
	public void testDoubleRotationCase2() {
		int[] startArray = {3, -4, -2};
		for(int i = 0; i < startArray.length; i++)
			avl.incCount(startArray[i]);
		String expected = "([-2,1] ([-4,0] . .) ([3,0] . .))";
		String actual = avl.dataAndHeight();
		assertEquals(expected, actual);
	}
	
	@Test(timeout = TIMEOUT)
	public void testDoubleRotationCase3() {
		int[] startArray = {-4, 3, -2};
		for(int i = 0; i < startArray.length; i++)
			avl.incCount(startArray[i]);
		String expected = "([-2,1] ([-4,0] . .) ([3,0] . .))";
		String actual = avl.dataAndHeight();
		assertEquals(expected, actual);
	}
	
	@Test(timeout = TIMEOUT)
	public void testAVLInOrder() {
		int[] startArray = {3, -2, -4, 5, 1};
		for(int i = 0; i < startArray.length; i++)
			avl.incCount(startArray[i]);
		String expected = "(-4, -2, 1, 3, 5)";
		String actual = avl.InOrder();
		assertEquals(expected, actual);
	}
		
	@Test(timeout = TIMEOUT)
	public void iteratorGetsAllDataFromTree() {
		int[] startArray = {3, -2, -4, -2, 3, 5, 1, 5, -2, 1};
		String startArrayToString = intArrayToString(startArray);
		for(int i = 0; i < startArray.length; i++)
			avl.incCount(startArray[i]);
		int[] expected = {-4, -2, 1, 3, 5};
		
		SimpleIterator<DataCount<Integer>> it = avl.getIterator();
		int[] actual = new int[expected.length];
		int i = 0;
		while(it.hasNext()) {
			actual[i] = it.next().data;
			i++;
		}
		Arrays.sort(actual);
		assertArrayEquals("Added " + startArrayToString + " and used iterator", 
				          expected, actual);
	}
	
	@Test(timeout = TIMEOUT, expected = java.util.NoSuchElementException.class)
	public void iteratorThrows() { 
		avl.incCount(21); 
		SimpleIterator<DataCount<Integer>> iter = avl.getIterator();
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