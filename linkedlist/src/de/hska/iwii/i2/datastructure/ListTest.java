/**
 * 
 */
package de.hska.iwii.i2.datastructure;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author susana.biro
 *
 */
public class ListTest {

	/**
	 * Test methode für add(java.lang.Object).
	 */
	@Test
	public void testAdd() {
		List<Integer> list = new List<Integer>();
	
		list.add(0,1);
		list.add(1,2);
		list.add(2,3);

		assertTrue(list.get(0) == 1);
		assertTrue(list.get(1) == 2);
		assertTrue(list.get(2) == 3);
		assertFalse(list.get(2) == 2);
		
			}

	/**
	 * Test methode für get(int).
	 */
	@Test
	public void testGet() {
		List<Integer> list = new List<Integer>();
		
		list.add(0,1);
		list.add(1,2);
		list.add(2,3);
		
		list.get(1);
		list.get(2);
        assertTrue( list.get(1)==2);
        assertTrue( list.get(2)==3);
        assertFalse( list.get(1) == 0);
		
	}

	/**
	 * Test methode für addFirst(java.lang.Object).
	 */
	@Test
	public void testAddFirst() {
		List<Integer> list = new List<Integer>();
		list.addFirst(4);
		assertTrue(list.get(0) == 4);
		assertFalse(list.get(0) == 5);
		List<Integer> list1 = new List<Integer>();
		list1.addFirst(5);
		assertTrue(list1.get(0) == 5);
		assertFalse(list1.get(0)==6);
	}

	/**
	 * Test methode für addLast(java.lang.Object).
	 */
	@Test
	public void testAddLast() {
		List<Integer> list = new List<Integer>();
		
		list.addLast(6);
		assertTrue(list.get(0) == 6);
		assertFalse(list.get(0) == 5);
		
	}

	/**
	 * Test methode für removeFirst().
	 */
	@Test
	public void testRemoveFirst() {
		List<Integer> list = new List<Integer>();
		
		list.add(0,1);
		list.add(1,2);
		list.removeFirst();

		
		assertTrue(list.get(0) == 2);
		assertFalse(list.get(0) == 1);
			}
   
	/**
	 * Test methode für removeLast().
	 */
	@Test
	public void testRemoveLast() {
        List<Integer> list = new List<Integer>();
		
		list.add(0,1);
		list.add(1,2);
		list.add(2,6);
		list.removeLast();

		
		assertTrue(list.get(1) == 2 );
		assertFalse(list.get(1) == 1);
			}
	

	/**
	 * Test methode für remove(int).
	 */
	@Test
	public void testRemove() {
        List<Integer> list = new List<Integer>();
       
		list.add(0,1);
		list.add(1,2);
		list.add(2,6);
		list.add(3,8);
		
		list.remove(2);
       
		
		assertTrue(list.getSize() == 3 );
		
		assertFalse(list.getSize() == 6);
			}
	

	/**
	 * Test methode für getSize().
	 */
	@Test
	public void testGetSize() {
		List<Integer> list = new List<Integer>();
		
		list.add(0,1);
		list.add(1,2);
		list.add(2,3);
		list.getSize();

		assertEquals(list.getSize() == 3,true);
		assertEquals(list.getSize() == 5,false);
	
	}

}
