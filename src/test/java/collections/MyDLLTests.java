package collections;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ListADT;
import utilities.MyDLL;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

public class MyDLLTests {

    ListADT<String> list;

    @BeforeMethod
    public void initializeList() {
        list = new MyDLL<>();
    }

    @Test(groups = "myDLLTests")
    public void testMyDLLIsEmpty() {
        assertTrue(list.isEmpty());
    }

    @Test(groups = "myDLLTests")
    public void testMyDLLIsNotEmpty() {
        list.add("test");
        assertFalse(list.isEmpty());
    }

    @Test(groups = "myDLLTests")
    public void testMyDLLToArray() {
        String[] expected = {"1", "2"};
        assertArrayEquals(list.toArray(expected), expected);
    }

    @Test(groups = "myDLLTests")
    public void testMyDLLContains() {
        list.add("1");
        list.add("2");
        assertTrue(list.contains("2"));
    }

    @Test(groups = "myDLLTests")
    public void testMyDLLAddAll() {
        ListADT<String> toAdd = new MyDLL<>();
        toAdd.add("1");
        toAdd.add("2");
        list.addAll(toAdd);
        assertArrayEquals(list.toArray(), toAdd.toArray());
    }

    @Test(groups = "myDLLTests")
    public void testMyDLLAddAllEmpty() {
        assertTrue(list.addAll(new MyDLL<>()));
    }

    @Test(groups = "myDLLTests")
    public void testMyDLLRemove() {
        list.add("1");
        list.add("2");
        list.remove(0);
        String[] expected = {"2"};
        assertArrayEquals(list.toArray(), expected);
    }

    @Test(groups = "myDLLTests")
    public void testMyDLLClear() {
        list.add("1");
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test(groups = "myDLLTests")
    public void testMyDLLAdd() {
        list.add("1");
        list.add("3");
        list.add(1, "2");
        String[] expected = {"1", "2", "3"};
        assertArrayEquals(list.toArray(), expected);
    }

    @Test(groups = "myDLLTests")
    public void testMyDLLGet(){
        list.add("1");
        assertEquals(list.get(0), "1");
    }

    @Test(groups = "myDLLTests")
    public void testMyDLLSet(){
        list.add("1");
        list.add("2");
        list.set(0, "0");
        String[]expected = {"0", "2"};
        assertArrayEquals(list.toArray(), expected);
    }
}