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
		ArrayList<Double> values = new ArrayList<Double>();
		values.add(24.2);
		values.add(24.4);
		values.add(28.5);
		values.add(25.3);
		values.add(32.2);
		values.add(19.6);
		values.add(32.9);
		values.add(21.3);
		values.add(24.0);
		values.add(26.5);
		for (Double value : values) {
			metrics.insertValue(value);
		}
	}
	
	//verificar qual seria um bom epslon
	@Test
	public void testGetMean() {	
		assertEquals(25.89, metrics.getMean(), 0.000001);
	}

	@Test
	public void testGetVariance() {
		assertEquals(18.418777, metrics.getVariance(), 0.000001);
	}

	@Test
	public void testInsertValue() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetSuperLimit(){
		assertEquals(25.889999, metrics.getSuperiorLimit(), 0.000001);
	}
	
	@Test
	public void testGetInferiorLimit(){
		assertEquals(15.0, metrics.getInferiorLimit(), 0.000001);
	}
}
