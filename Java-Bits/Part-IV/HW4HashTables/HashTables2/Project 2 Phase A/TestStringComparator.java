import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test for StringComparator.
 * 
 * @author Chun-Wei Chen
 * @version CSE 332 02/05/13
 */
public class TestStringComparator {
	private static final int TIMEOUT = 2000;
    StringComparator sc;
    
    @Before
	public void setUp() throws Exception {
    	sc = new StringComparator();
    }
    
	@Test(timeout = TIMEOUT)
	public void testCompare1() {
		assertTrue(sc.compare("apple", "banana") < 0);
	}
	
	@Test(timeout = TIMEOUT)
	public void testCompare2() {
		assertTrue(sc.compare("apple", "ace") > 0);
	}
	
	@Test(timeout = TIMEOUT)
	public void testCompare3() {
		assertTrue(sc.compare("eve", "even") < 0);
	}
	
	@Test(timeout = TIMEOUT)
	public void testCompare4() {
		assertTrue(sc.compare("kite", "kit") > 0);
	}
	
	@Test(timeout = TIMEOUT)
	public void testCompare5() {
		assertTrue(sc.compare("cat", "cat") == 0);
	}
}