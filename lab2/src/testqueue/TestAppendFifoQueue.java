package testqueue;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import queue_singlelinkedlist.FifoQueue;

public class TestAppendFifoQueue {
	
	private FifoQueue<Integer> q1;
	private FifoQueue<Integer> q2;

	@Before
	public void setUp() throws Exception {
		q1 = new FifoQueue<Integer>();
		q2 = new FifoQueue<Integer>();
	}

	@After
	public void tearDown() throws Exception {
		q1 = null;
		q2 = null;
	}
	
	
	/*
	 * two empty queues
	 */
	@Test
	public void testTwoEmptyQueues() {
		q1.append(q2);
		assertTrue("queue is null", q1.isEmpty());
		assertTrue("q1 size is 0", q1.size() == 0);
		assertTrue("q2 size is 0", q2.size() == 0);
		assertFalse("second queue not empty",!q2.isEmpty());
		
		//fail("Not yet implemented");
	}
	
	/*
	 * empty queue append to non empty queue
	 */
	@Test
	public void testEmptyToNonEmpty() {
		for(int i = 1; i < 4; i++)
			q1.offer(i);
		q1.append(q2);
		for (int i = 1; i <4; i++) {
			int k = q1.poll();
			assertEquals("peek returns incorrect element", i, k);
		}
		assertTrue("queue is null", q1.isEmpty());
		assertTrue("queue is null", q2.isEmpty());
		//fail("Not yet implemented");
	}

	/*
	 * non empty queue append to empty queue
	 * 
	 */
	@Test
	public void testNonEmptyToEmpty() {
		for(int i = 1; i < 4; i++)
			q2.offer(i);
		q1.append(q2);
		assertTrue("queue is null", !q1.isEmpty());
		for (int i = 1; i <4; i++) {
			int k = q1.poll();
			assertEquals("peek returns incorrect element", i, k);
		}
		assertTrue("queue is null", q1.isEmpty());
		assertTrue("queue is not null", q2.isEmpty());
		//fail("Not yet implemented");
	}
	/*
	 * two non empty queues
	 * 
	 */
	@Test
	public void testTwoNonEmpty() {
		
		for(int i = 1; i < 4; i++)
			q1.offer(i);
		for(int i = 4; i < 7; i++)
			q2.offer(i);
		q1.append(q2);
		assertTrue("queue is null", !q1.isEmpty());
		for (int i = 1; i <7; i++) {
			int k = q1.poll();
			assertEquals("peek returns incorrect element", i, k);
		}
		assertTrue("queue is null", q1.isEmpty());
		assertTrue("queue is not null", q2.isEmpty());
		//fail("Not yet implemented");
	}
	/*
	 * append same queue to itself
	 */

	@Test
	public void testQueueToItself() {
		for(int i = 1; i < 4; i++)
			q1.offer(i);
		
		try {
			q1.append(q1);
			fail("Should raise IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			//test went through
		}
		//fail("Not yet implemented");
	}

}