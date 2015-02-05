import static org.junit.Assert.*;
import org.junit.*;

/**
 * JUnit test for GArrayStack.
 * 
 * @author Chun-Wei Chen
 * @version CSE 332 02/05/13
 */
public class TestGArrayStack {
	private static final int TIMEOUT = 2000;
	private GArrayStack<Integer> testGArrayStack;  // a GArrayStack holds Double value
	
	/**
	 * Construct an empty GArrayStack before every test method is called.
	 */
	@Before
	public void setUp() throws Exception {
		testGArrayStack = new GArrayStack<Integer>();
	}
	
	@Test(timeout = TIMEOUT)
	public void testIsEmpty() {
		assertTrue(testGArrayStack.isEmpty());
	}
	
	@Test(timeout = TIMEOUT)
	public void testPush() {
		testGArrayStack.push(23);
		assertFalse(testGArrayStack.isEmpty());
	}
	
	@Test(timeout = TIMEOUT, expected = java.util.EmptyStackException.class)
	public void testPopEmptyStack() {
		testGArrayStack.pop();
	}
	
	@Test(timeout = TIMEOUT)
	public void testPop() {
		testGArrayStack.push(1);
		testGArrayStack.push(2);
		testGArrayStack.push(3);
		int[] expected = {3, 2, 1};
		int[] actual = new int[expected.length];
		for(int i = 0; i < actual.length; i++)
			actual[i] = testGArrayStack.pop();
		assertArrayEquals("The order of item poping out from the stack follows LIFO",
				          expected, actual);
	}
	
	@Test(timeout = TIMEOUT, expected = java.util.EmptyStackException.class)
	public void testPeekEmptyStack() {
		testGArrayStack.peek();
	}
	
	@Test(timeout = TIMEOUT)
	public void testPeek() {
		testGArrayStack.push(1);
		testGArrayStack.push(2);
		testGArrayStack.push(3);
		int top = testGArrayStack.peek();
		assertEquals(3, top);
		int[] expected = {3, 2, 1};
		int[] actual = new int[expected.length];
		for(int i = 0; i < actual.length; i++)
			actual[i] = testGArrayStack.pop();
		assertArrayEquals("The order of item poping out from the stack follows LIFO",
				          expected, actual);
	}
	
	/**
	 * Test is stack can hold more items than its initial capacity allowed.
	 */
	@Test(timeout = TIMEOUT)
	public void testEnsureCapacity() {
		testGArrayStack.push(2);
		testGArrayStack.push(1);
		testGArrayStack.push(6);
		testGArrayStack.push(4);
		testGArrayStack.push(7);
		testGArrayStack.push(8);
		testGArrayStack.push(3);
		testGArrayStack.push(5);
		testGArrayStack.push(9);
		testGArrayStack.push(11);
		testGArrayStack.push(111);
	}
}