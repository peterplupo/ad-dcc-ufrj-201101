package tests;


import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import simulator.EventQueue;

public class TestEventQueue {
	EventQueue eventQueue;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		eventQueue = new EventQueue(0.2);
	}
	
	@Test
	public void testQueue() {
		Assert.assertEquals("0.0-1.0-2.0-4.0-6.0-7.0-8.0-9.0-10.0", eventQueue.testProcessing());
	}

	@After
	public void tearDown() throws Exception {
	}

}
