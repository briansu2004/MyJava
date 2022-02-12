package com.sutek.java.hashmap;

import org.junit.Test;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class MyHashmapTest {

	@Test
	public void whenHashCodeIsCalledOnPut_thenCorrect() {
		MyKey key = new MyKey(1);
		Map<MyKey, String> map = new HashMap<>();
		map.put(key, "val");
	}

	@Test
	public void givenNullKeyAndVal_whenAccepts_thenCorrect() {
		Map<String, String> map = new HashMap<>();
		map.put(null, null);
	}

	@Test
	public void givenExistingKey_whenPutReturnsPrevValue_thenCorrect() {
		Map<String, String> map = new HashMap<>();
		map.put("key1", "val1");

		String rtnVal = map.put("key1", "val2");

		assertEquals("val1", rtnVal);

		assertEquals("val2", map.get("key1"));
	}

	@Test
	public void givenNewKey_whenPutReturnsNull_thenCorrect() {
		Map<String, String> map = new HashMap<>();

		String rtnVal = map.put("key1", "val1");

		assertNull(rtnVal);
	}

	@Test
	public void givenNullVal_whenPutReturnsNull_thenCorrect() {
		Map<String, String> map = new HashMap<>();

		String rtnVal = map.put("key1", null);

		assertNull(rtnVal);
	}

	@Test
	public void whenGetWorks_thenCorrect() {
		Map<String, String> map = new HashMap<>();
		map.put("key", "val");

		String val = map.get("key");

		assertEquals("val", val);
	}

	@Test
	public void whenHashCodeIsCalledOnGet_thenCorrect() {
		MyKey key = new MyKey(1);
		Map<MyKey, String> map = new HashMap<>();
		map.put(key, "val");
		String val = map.get(key);
	}

	@Test
	public void givenUnmappedKey_whenGetReturnsNull_thenCorrect() {
		Map<String, String> map = new HashMap<>();

		String rtnVal = map.get("key1");

		assertNull(rtnVal);
	}

	@Test
	public void givenNullVal_whenRetrieves_thenCorrect() {
		Map<String, String> map = new HashMap<>();
		map.put("key", null);

		String val = map.get("key");

		assertNull(val);
	}

	@Test
	public void whenContainsDistinguishesNullValues_thenCorrect() {
		Map<String, String> map = new HashMap<>();

		String val1 = map.get("key");
		boolean valPresent = map.containsKey("key");

		assertNull(val1);
		assertFalse(valPresent);

		map.put("key", null);
		String val = map.get("key");
		valPresent = map.containsKey("key");

		assertNull(val);
		assertTrue(valPresent);
	}

	@Test
	public void givenHashMap_whenRetrievesKeySet_thenCorrect() {
		Map<String, String> map = new HashMap<>();
		map.put("name", "brian");
		map.put("type", "su");

		Set<String> keys = map.keySet();

		assertEquals(2, keys.size());
		assertTrue(keys.contains("name"));
		assertTrue(keys.contains("type"));
	}

	@Test
	public void givenKeySet_whenChangeReflectsInMap_thenCorrect() {
		Map<String, String> map = new HashMap<>();
		map.put("name", "brian");
		map.put("type", "su");

		assertEquals(2, map.size());

		Set<String> keys = map.keySet();
		keys.remove("name");

		assertEquals(1, map.size());
	}

	@Test
	public void givenHashMap_whenRetrievesValues_thenCorrect() {
		Map<String, String> map = new HashMap<>();
		map.put("name", "brian");
		map.put("type", "su");

		Collection<String> values = map.values();

		assertEquals(2, values.size());
		assertTrue(values.contains("brian"));
		assertTrue(values.contains("su"));
	}

	@Test
	public void givenHashMap_whenRetrievesEntries_thenCorrect() {
		Map<String, String> map = new HashMap<>();
		map.put("name", "brian");
		map.put("type", "su");

		Set<Map.Entry<String, String>> entries = map.entrySet();

		assertEquals(2, entries.size());
		for (Map.Entry<String, String> e : entries) {
			String key = e.getKey();
			String val = e.getValue();
			assertTrue(key.equals("name") || key.equals("type"));
			assertTrue(val.equals("brian") || val.equals("su"));
		}
	}

	@Test(expected = ConcurrentModificationException.class)
	public void givenIterator_whenFailsFastOnModification_thenCorrect() {
		Map<String, String> map = new HashMap<>();
		map.put("name", "brian");
		map.put("type", "su");

		Set<String> keys = map.keySet();
		Iterator<String> it = keys.iterator();
		map.remove("type");
		while (it.hasNext()) {
			String key = it.next();
		}
	}

	@Test
	public void givenIterator_whenRemoveWorks_thenCorrect() {
		Map<String, String> map = new HashMap<>();
		map.put("name", "brian");
		map.put("type", "su");

		Set<String> keys = map.keySet();
		Iterator<String> it = keys.iterator();

		while (it.hasNext()) {
			it.next();
			it.remove();
		}

		assertEquals(0, map.size());
	}

	@Test
	public void whenCallsEqualsOnCollision_thenCorrect() {
		HashMap<MyKey2, String> map = new HashMap<>();
		MyKey2 k1 = new MyKey2(1, "firstKey");
		MyKey2 k2 = new MyKey2(2, "secondKey");
		MyKey2 k3 = new MyKey2(2, "thirdKey");

		System.out.println("storing value for k1");
		map.put(k1, "firstValue");
		System.out.println("storing value for k2");
		map.put(k2, "secondValue");
		System.out.println("storing value for k3");
		map.put(k3, "thirdValue");

		System.out.println("retrieving value for k1");
		String v1 = map.get(k1);
		System.out.println("retrieving value for k2");
		String v2 = map.get(k2);
		System.out.println("retrieving value for k3");
		String v3 = map.get(k3);

		assertEquals("firstValue", v1);
		assertEquals("secondValue", v2);
		assertEquals("thirdValue", v3);
	}


}