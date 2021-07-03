/**
 * 
 */
package bst;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * @author Milad
 *
 */
public class Test {

	 BinarySearchTree<Integer> bst;


	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		bst = new BinarySearchTree<>();

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		bst = null;

	}

	@org.junit.Test
	public void test() {
		for(int i=0; i< 100; i++) {
			assertTrue(bst.add(i));
		}
		assertEquals(100, bst.height());
		assertEquals(100, bst.size());
		
	}

}
