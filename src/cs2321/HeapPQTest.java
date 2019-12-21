package cs2321;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import net.datastructures.AdaptablePriorityQueue;
import net.datastructures.Entry;

public class HeapPQTest {

	AdaptablePriorityQueue<String, Integer> heappq;
	Entry<String, Integer> hold;
	
	@Before
	public void setUp() throws Exception {
		heappq = new HeapPQ<String, Integer>();
		heappq.insert("Bulbous Bouffant", 16);
		heappq.insert("Gazebo", 6);
		heappq.insert("Balooga", 7);
		hold = heappq.insert("Galoshes", 8);
		heappq.insert("Eskimo", 6);
		heappq.insert("Mukluks", 7);
		heappq.insert("Macadamia", 9);
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
		while(!heappq.isEmpty()){
			e = heappq.removeMin();
			assertEquals(expected[i],  e.getKey());
			i++;
		}
	}


	@Test
	public void testSize() {
		org.junit.Assert.assertEquals(7, heappq.size());
	}
	

	@Test
	public void testIsEmpty() {
		org.junit.Assert.assertEquals(false, heappq.isEmpty());
	}

	@Test
	public void testInsert() {
		heappq.insert("Falloo", 22);
		for (int n = 0; n < 3; n++) {
			heappq.removeMin();
		}
		org.junit.Assert.assertEquals("Falloo",heappq.min().getKey());
	}
	
	@Test
	public void testInsertExtra1() {
		heappq.insert("Aaron", 3);
		org.junit.Assert.assertEquals("Aaron",heappq.min().getKey());
	}
	
	@Test
	public void testInsertExtra2() {
		heappq.insert("Zed", 17);
		while(heappq.size() != 1) {
			heappq.removeMin();
		}
		org.junit.Assert.assertEquals("Zed",heappq.min().getKey());
	}

	@Test
	public void testMin() {
		org.junit.Assert.assertEquals("Balooga", heappq.min().getKey());
	}


	@Test
	public void testRemove() {
		heappq.remove(hold);
		Entry<String, Integer> e;
		String[] expected= {
				"Balooga", 
				"Bulbous Bouffant",
				"Eskimo", 
				"Gazebo", 
				"Macadamia",
				"Mukluks"
		};
		
		int i=0;
		while(!heappq.isEmpty()){
			e = heappq.removeMin();
			assertEquals(expected[i],  e.getKey());
			i++;
		}
	}

	@Test
	public void testReplaceKey() {
		heappq.replaceKey(hold, "Zed");
		Entry<String, Integer> e;
		String[] expected= {
				"Balooga", 
				"Bulbous Bouffant",
				"Eskimo", 
				"Gazebo", 
				"Macadamia",
				"Mukluks",
				"Zed"
		};
		
		int i=0;
		while(!heappq.isEmpty()){
			e = heappq.removeMin();
			assertEquals(expected[i],  e.getKey());
			i++;
		}
	}

	@Test
	public void testReplaceValue() {
		heappq.replaceValue(hold, 66);
		Entry<String, Integer> e;
		Integer[] expected= {
				7, 
				16,
				6, 
				66,
				6, 
				9,
				7,
				9
		};
		
		int i=0;
		while(!heappq.isEmpty()){
			e = heappq.removeMin();
			assertEquals(expected[i],  e.getValue());
			i++;
		}
	}

}
