package cs2321;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import net.datastructures.Entry;
import net.datastructures.PriorityQueue;

public class UnorderedPQTest {
	PriorityQueue<String, Integer> unordpq;
	
	@Before
	public void setUp() throws Exception {
		unordpq = new UnorderedPQ<String, Integer>();
		unordpq.insert("Bulbous Bouffant", 16);
		unordpq.insert("Gazebo", 6);
		unordpq.insert("Balooga", 7);
		unordpq.insert("Galoshes", 8);
		unordpq.insert("Eskimo", 6);
		unordpq.insert("Mukluks", 7);
		unordpq.insert("Macadamia", 9);
	}

	@Test
	public void testSize() {
		org.junit.Assert.assertEquals(7, unordpq.size());
	}

	@Test
	public void testIsEmpty() {
		org.junit.Assert.assertEquals(false, unordpq.isEmpty());
	}

	@Test
	public void testInsert() {
		unordpq.insert("Falloo", 22);
		for (int n = 0; n < 3; n++) {
			unordpq.removeMin();
		}
		org.junit.Assert.assertEquals("Falloo",unordpq.min().getKey());
	}
	
	@Test
	public void testInsertExtra1() {
		unordpq.insert("Aaron", 3);
		org.junit.Assert.assertEquals("Aaron",unordpq.min().getKey());
	}
	
	@Test
	public void testInsertExtra2() {
		unordpq.insert("Zed", 17);
		while(unordpq.size() != 1) {
			unordpq.removeMin();
		}
		org.junit.Assert.assertEquals("Zed",unordpq.min().getKey());
	}

	@Test
	public void testMin() {
		org.junit.Assert.assertEquals("Balooga", unordpq.min().getKey());
	}

	@Test
	public void testRemoveMin() {
		Entry<String, Integer> e;
		String[] expected= {
				"Balooga", 
				"Bulbous Bouffant",
				"Eskimo", 
				"Galoshes", 
				"Gazebo", 
				"Macadamia",
				"Mukluks"
		};
		
		int i=0;
		while(!unordpq.isEmpty()){
			e = unordpq.removeMin();
			assertEquals(expected[i],  e.getKey());
			i++;
		}
	}
}
