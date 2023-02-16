package collections;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.MyArrayList;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MyArrayListTest {

    private MyArrayList<Integer> testingArray;

    @BeforeMethod
    public void initArray() {
        testingArray = new MyArrayList<>();
    }

    @Test
    public void testInitialSize() {
        assertEquals(testingArray.size(), 0);
    }

    @Test(groups = "myArrayListTests")
    public void testMyArrayListAddElement() {
        testingArray.add(5);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(testingArray.size(), 1);
        softAssert.assertEquals(testingArray.get(0).intValue(), 5);
        softAssert.assertAll();
    }

    @Test(groups = "myArrayListTests")
    public void testMyArrayListDeleteElement() {
        testingArray.add(5);
        testingArray.remove(0);
        Assert.assertTrue(testingArray.isEmpty());
    }

    @Test(groups = "myArrayListTests")
    public void testMyArrayListGetElement() {
        testingArray.add(10);
        testingArray.add(4);
        assertEquals(testingArray.get(1).intValue(), 4);
    }

    @Test(groups = "myArrayListTests")
    public void testMyArrayListSetElement() {
        testingArray.add(5);
        testingArray.set(0, 6);
        assertEquals(testingArray.get(0).intValue(), 6);
    }

    @Test(groups = "myArrayListTests")
    public void testMyArrayListAddToIndexAndGetThisElement() {
        SoftAssert softly = new SoftAssert();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add(0, "3");
        softly.assertEquals(arrayList.get(0),"3");
        softly.assertEquals(arrayList.get(1),"1");
        softly.assertEquals(arrayList.get(2),"2");
        softly.assertAll();
    }

    @Test(groups = "myArrayListTests")
    public void testMyArrayListAddToIndex() {
        testingArray.add(1);
        testingArray.add(2);
        testingArray.add(3);
        assertEquals(testingArray.toArray().length,3);
    }

    @Test(groups = "myArrayListTests")
    public void testMyArrayListAddAll() {
        ArrayList<String> firstArrayList = new ArrayList<>();
        firstArrayList.add("test");
        ArrayList<String> secondArrayList = new ArrayList<>();
        secondArrayList.add("secondTest");
        secondArrayList.addAll(firstArrayList);
        ArrayList<String> thirdArrayList = new ArrayList<>();
        thirdArrayList.add("secondTest");
        thirdArrayList.add("test");
        assertEquals(secondArrayList.toArray(), thirdArrayList.toArray());
    }

    @Test(groups = "myArrayListTests")
    public void testMyArrayListRemoveElement() {
        ArrayList<String> firstArrayList = new ArrayList<>();
        firstArrayList.add("test");
        firstArrayList.add("secondTest");
        firstArrayList.add("also test");
        firstArrayList.remove("also test");
        ArrayList<String> secondArrayList = new ArrayList<>();
        secondArrayList.add("test");
        secondArrayList.add("secondTest");
        assertEquals(firstArrayList.toArray(), secondArrayList.toArray());
    }

    @Test(groups = "myArrayListTests")
    public void testMyArrayListRemoveElementByIndex() {
        ArrayList<String> firstArrayList = new ArrayList<>();
        firstArrayList.add("test");
        firstArrayList.add("secondTest");
        firstArrayList.add("also test");
        firstArrayList.remove(2);
        ArrayList<String> secondArrayList = new ArrayList<>();
        secondArrayList.add("test");
        secondArrayList.add("secondTest");
        assertEquals(secondArrayList.toArray().length, firstArrayList.toArray().length);
    }

    @Test(groups = "myArrayListTests")
    public void testMyArrayListContains() {
        testingArray.add(1);
        testingArray.add(2);
        testingArray.add(3);
        assertTrue(testingArray.contains(1));
    }
}