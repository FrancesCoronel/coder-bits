import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

/**
 * Things to note if you're new to unit testing:
 * Test names tend to be long. This lets us get away with fewer comments. 
 * assertEquals(x,y) is preferable to assertTrue(x == y).
 * Tests tend to be short and usually should only have 1 assertion. 
 * There may be several tests for 1 method (eg. test add x, test add y, ...)
 * Eliminate redundancy with private helper methods. 
 */

public class TestBinarySearchTree {
	// Timeouts are good style just in case of infinite loops, but not necessary. 
	private static final int TIMEOUT = 2000; // 2000 ms = 2 s
	BinarySearchTree<Integer> bst;
	
	@Before
	public void setUp() throws Exception {
		bst = new BinarySearchTree<Integer>(new Comparator<Integer>() {
			public int compare(Integer e1, Integer e2) {
				return e1 - e2;
			}
		});
	}

	@Test(timeout = TIMEOUT)
	public void treeHasSize0WhenConstructed(){
		assertEquals("Constructed a tree and checked its size", 
				bst.getSize(), 0);
	}
	
	private void addAndTestSize(int[] nums, int unique){
		for(int i = 0; i < nums.length; i++)
			bst.incCount(nums[i]);
		assertEquals("Added list of numbers " + intArrayToString(nums) + " to tree", 
				bst.getSize(), unique);
	}
	
	@Test(timeout = TIMEOUT) 
	public void treeHasSize1AfterAdding5(){
		addAndTestSize(new int[]{5}, 1);
	}
	
	@Test(timeout = TIMEOUT)
	public void treeHasSize1AfterAddingRepeat5s(){
		addAndTestSize(new int[]{5,5}, 1);
	}

	@Test(timeout = TIMEOUT)
	public void treeHasSize5AfterAdding0To4(){
		addAndTestSize(new int[]{0,1,2,3,4}, 5);
	}
	
	@Test(timeout = TIMEOUT)
	public void treeHasSize5AfterAddingRepeat0To4s(){
		addAndTestSize(new int[]{0,0,1,1,2,2,3,3,4,4}, 5);
	}
	
	@Test(timeout = TIMEOUT)
	public void treeHasSize5AfterAddingRepeat0To4InSequence(){
		addAndTestSize(new int[]{0,1,2,3,4,0,1,2,3,4}, 5);
	}

	private void addAndGetCount(int[] nums, int getThis, int expected){
		for(int i = 0; i < nums.length; i++)
			bst.incCount(nums[i]);
		int actual = bst.getCount(getThis);
		assertEquals("Added " + intArrayToString(nums) + " and got count of " + getThis, 
				expected, actual);
	}
	
	@Test(timeout = TIMEOUT)
	public void treeHas7Of9(){
		addAndGetCount(new int[]{9, 9, 9, 9, 9, 9, 9}, 9, 7);
	}
	
	@Test(timeout = TIMEOUT)
	public void treeHas3Of5(){
		addAndGetCount(new int[]{0, 5, -1, 5, 1, 5, 2}, 5, 3);
	}
	
	@Test(timeout = TIMEOUT)
	public void iteratorGetsAllDataFromTree(){
		int[] startArray = {7, -5, -5, -6, 6, 10, -9, 4, 8, 6};
		String startArrayToString = intArrayToString(startArray);
		for(int i = 0; i < startArray.length; i++)
			bst.incCount(startArray[i]);
		// the expected array has no duplicates and is sorted
		int[] expected = {-9, -6, -5, 4, 6, 7, 8, 10};
		
		// construct the actual array returned by the iterator
		SimpleIterator<DataCount<Integer>> iter = bst.getIterator();
		int[] actual = new int[expected.length];
		int i = 0;
		while(iter.hasNext())
			actual[i++] = iter.next().data;
		Arrays.sort(actual);
		assertArrayEquals("Added " + startArrayToString + " and used iterator", 
				expected, actual);
	}
	
	@Test(timeout = TIMEOUT, expected = java.util.NoSuchElementException.class)
	public void iteratorThrows(){
		// Start by adding an item, because we get NullPointerException if 
		// we try to create an iterator from an empty tree. 
		bst.incCount(21); 
		SimpleIterator<DataCount<Integer>> iter = bst.getIterator();
		iter.next(); // OK (should return 21)
		iter.next(); // Exception!
	}
	/* The above is equivalent to doing something like
	 * try{ ...; iter.next(); fail("should have crashed!") }
	 * catch(NoSuchElementException e){ }
	 */
	
	// pre: nums is not null
	// post: returns a String representation of nums 
	// in the form of {1,2,3,4}
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
