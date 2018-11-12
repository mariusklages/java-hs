package space.harbour.java.hw5;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import space.harbour.java.hw3.MyHashMap;

import java.lang.reflect.Array;
import java.util.*;

import static java.util.Objects.hash;
import static org.junit.Assert.*;

public class MyHashMapTest extends TestCase {
    MyHashMap mhMap;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        mhMap = new MyHashMap();
    }

    @After
    public void tearDown() throws Exception {
        mhMap = null;
    }

    @org.junit.Test
    public void testmyHash() {
        mhMap.put("MK", "Marius Klages");
        int hashedKey = mhMap.myHash("MK");

        assertEquals(13, hashedKey);
    }

    @Test
    public void testsize() {
        mhMap.put("MK", "Marius Klages");

        double size = mhMap.size();
        assertEquals(1.00, size, 0);
    }

    @Test
    public void testisEmpty() {
        boolean size = mhMap.isEmpty();
        assertTrue("The HashMap is NOT empty", size);
    }

    @Test
    public void testcontainsKey() {
        mhMap.put("MK", "Marius Klages");
        boolean containsKey = mhMap.containsKey("MK");
        assertTrue("The HashMap does NOT contain the key MK", containsKey);
    }

    @Test
    public void testcontainsValue() {
        mhMap.put("MK", "Marius Klages");
        boolean containsValue = mhMap.containsValue("Marius Klages");
        assertTrue("The HashMap does NOT contain the value Marius Klages", containsValue);
    }

    @Test
    public void testget() {
        mhMap.put("MK", "Marius Klages");
        Object getValue = mhMap.get("MK");
        assertEquals("Marius Klages", getValue);
    }

    @Test
    public void testput() {
        mhMap.put("MK", "Marius Klages");
        int sizeAfterPut = mhMap.size();
        assertEquals(1, sizeAfterPut);
    }

    @Test
    public void testremove() {
        mhMap.put("MK", "Marius Klages");
        Object removedValue = mhMap.remove("MK");
        assertEquals("Marius Klages", removedValue);
    }

    @Test
    public void testputAll() {
        mhMap.put("MK", "Marius Klages");
        mhMap.put("DG", "Diego Gladig");


        MyHashMap<String, String> nameMap = new MyHashMap<>();

        nameMap.putAll(mhMap);

        assertEquals(mhMap.containsValue("Marius Klages"), nameMap.containsValue("Marius Klages"));
        assertEquals(mhMap.containsValue("Diego Gladig" ), nameMap.containsValue("Diego Gladig"));

    }

    @Test
    public void testclear() {
        mhMap.put("MK", "Marius Klages");
        mhMap.put("DG", "Diego Gladig");
        mhMap.put("DO", "Daniela Osorio");
        int size = mhMap.size();
        assertEquals(3,size);
        System.out.println("The HashMap contains 3 pairs of keys and values");
        mhMap.clear();
        int sizeAfterClearing = mhMap.size();
        assertEquals(0,sizeAfterClearing);
        System.out.println("The HashMap is empty");
    }

    @Test
    public void testkeySet() {
        mhMap.put("MK", "Marius Klages");
        mhMap.put("DG", "Diego Gladig");
        mhMap.put("DO", "Daniela Osorio");

        Collection<String> keysInput = new HashSet<>();
        keysInput.add("MK");
        keysInput.add("DG");
        keysInput.add("DO");

        Set keys = mhMap.keySet();

        assertEquals(keysInput, keys);
    }

    @Test
    public void testvalues() {
        mhMap.put("MK", "Marius Klages");
        mhMap.put("DG", "Diego Gladig");
        mhMap.put("DO", "Daniela Osorio");

        Collection<String> valueInput = new HashSet<>();
        valueInput.add("Marius Klages");
        valueInput.add("Diego Gladig");
        valueInput.add("Daniela Osorio");

        Collection<String> values = mhMap.values();

        assertEquals(valueInput, values);
    }

    @Test
    public void testIsNotEmpty() {
        mhMap.put("MK", "Marius Klages");
        mhMap.put("DG", "Diego Gladig");
        mhMap.put("DO", "Daniela Osorio");

        System.out.println(mhMap.size());

        assertFalse("the hashmap is empty", mhMap.isEmpty());
    }

    @Test
    public void testChangeValueByKey() {
        mhMap.put("MK", "Marius Klages");
        mhMap.put("DG", "Diego Gladig");
        mhMap.put("DO", "Daniela Osorio");

        System.out.println(mhMap);

        mhMap.put("MK", "Marius Alexander Klages");

        System.out.println(mhMap);

        HashMap<String, String> newMHMap = new HashMap<>();
        newMHMap.put("MK", "Marius Alexander Klages");
        newMHMap.put("DG", "Diego Gladig");
        newMHMap.put("DO", "Daniela Osorio");

        assertEquals(newMHMap, mhMap);
    }

    @Test
    public void testRetrieveValueByNonExistentKey() {
        mhMap.put("MK", "Marius Klages");
        mhMap.put("DG", "Diego Gladig");
        mhMap.put("DO", "Daniela Osorio");

        Object value = mhMap.get("Hello");
        assertEquals(null, value);

    }

    @Test
    public void testAddingPairWithKeyIsNull() {
        mhMap.put("MK", "Marius Klages");
        mhMap.put("DG", "Diego Gladig");
        mhMap.put("DO", "Daniela Osorio");
        mhMap.put(null, "Hallo");

        assertTrue("It is not added", mhMap.containsValue("Hallo"));
    }

    @Test
    public void testAddingPairWithValueIsNull() {
        mhMap.put("MK", "Marius Klages");
        mhMap.put("DG", "Diego Gladig");
        mhMap.put("DO", "Daniela Osorio");
        mhMap.put("Null", null);

        assertNull("The key of the added pair is null",mhMap.get("Null"));

    }

    @Test
    public void testDoesNotContainValue() {
        mhMap.put("MK", "Marius Klages");
        boolean containsValue = mhMap.containsValue("Diego Gladig");
        assertFalse("The HashMap does contain the value Diego Gladig", containsValue);
    }

    @Test
    public void testDoesNotContainKey(){
        mhMap.put("MK", "Marius Klages");
        boolean containsValue = mhMap.containsValue("DG");
        assertFalse("The HashMap does contain the key DG", containsValue);
    }

    @Test
    public void testputAllAndClear() {
        mhMap.put("MK", "Marius Klages");
        mhMap.put("DG", "Diego Gladig");

        MyHashMap<String, String> nameMap = new MyHashMap<>();

        nameMap.putAll(mhMap);

        assertEquals(mhMap.containsValue("Marius Klages"), nameMap.containsValue("Marius Klages"));
        assertEquals(mhMap.containsValue("Diego Gladig"), nameMap.containsValue("Diego Gladig"));

        mhMap.clear();
        nameMap.clear();

        int size = mhMap.size();
        int newSize = nameMap.size();

        assertEquals(size, newSize);

    }



}