package tests;

import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import simulator.Metrics;

public class TestMetrics {

	Metrics metrics = new Metrics();
	
	@Before
	public void init(){
		ArrayList<Integer> values = new ArrayList<Integer>();
		values.add(1);
		values.add(2);
		values.add(3);
		values.add(4);
		values.add(5);
		for (Integer value : values) {
			metrics.insertValue(value);
		}
	}
	
	@Test
	public void testGetMean() {
		
		assertEquals(3, metrics.getMean(), 0.1);
	}

	@Test
	public void testGetVariance() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertValue() {
		//fail("Not yet implemented");
	}

}
