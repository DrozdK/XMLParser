package collections;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.MyStack;
import utilities.StackADT;

import static org.testng.Assert.*;
import static org.testng.Assert.assertFalse;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

public class MyStackTest {

    private MyStack<Integer> testingStack;

    @BeforeMethod
    public void initStack() {
        testingStack = new MyStack<>();
    }

    @Test(groups = "myStackTests")
    public void testMyStackInitialSize() {
        Assert.assertEquals(testingStack.size(), 0);
    }

    @Test(groups = "myStackTests")
    public void testMyStackPush() {
        testingStack.push(6);
        Assert.assertEquals(testingStack.size(), 1);
    }

    @Test(groups = "myStackTests")
    public void testMyStackPop() {
        StackADT<String> stack = new MyStack<>();
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        Assert.assertEquals(stack.pop(), "Three");
    }

    @Test(groups = "myStackTests")
    public void testMyStackPeek() {
        StackADT<String> stack = new MyStack<>();
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        assertEquals(stack.peek(), "Three");
    }

    @Test(groups = "myStackTests")
    public void testMyStackClear() {
        StackADT<String> stack = new MyStack<>();
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        stack.clear();
        assertTrue(stack.isEmpty());
    }

    @Test(groups = "myStackTests")
    public void testMyStackToArray() {
        String[] array = {"One", "Two", "Three"};
        StackADT<String> stack = new MyStack<>();
        String[] expected = {"One", "Two", "Three"};
        assertArrayEquals(stack.toArray(array), expected);
    }

    @Test(groups = "myStackTests")
    public void testMyStackSearch() {
        SoftAssert softly = new SoftAssert();
        StackADT<String> stack1 = new MyStack<>();
        stack1.push("test");
        StackADT<String> stack2 = new MyStack<>();
        StackADT<String> stack3 = new MyStack<>();
        stack3.push("alsoTest");
        stack3.push("secondTest");
        softly.assertEquals(stack1.search(null), -1);
        softly.assertEquals(stack2.search("test"), -1);
        softly.assertEquals(stack3.search("secondTest"), 1);
        softly.assertEquals(stack3.search("alsoTest"), 2);
        softly.assertAll();
    }

    @Test(groups = "myStackTests")
    public void testMyStackEquals() {
        StackADT<String> stack1 = new MyStack<>();
        stack1.push("test");
        stack1.push("alsoTest");
        StackADT<String> stack2 = new MyStack<>();
        stack2.push("test");
        stack2.push("secondTest");
        assertFalse(stack1.equals(stack2));
    }
}
