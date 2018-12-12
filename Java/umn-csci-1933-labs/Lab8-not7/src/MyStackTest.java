import junit.framework.TestCase;

public class MyStackTest extends TestCase {

    public void testadd() {
        MyStack<String> tStack = new MyStack<String>();
        tStack.push("A");
        assertEquals (tStack.top(), "A");
        tStack.push("B");
        assertEquals (tStack.top(), "B");
        tStack.push("C");
        assertEquals (tStack.top(), "C");
    }

    public void testRemove() {
        MyStack<String> tStack = new MyStack<String>();
        tStack.push("A");
        tStack.push("B");
        tStack.push("C");

        assertEquals(tStack.pop(), "C");
        assertEquals(tStack.pop(), "B");
        assertEquals(tStack.pop(), "A");
        assertEquals(tStack.pop(), null);
    }

    public void testNumContains(){

    }

    public void testContains() {
        MyStack<String> tStack = new MyStack<String>();
        tStack.push("A");
        tStack.push("B");
        tStack.push("C");

        assertEquals(tStack.contains("C"), 1);
        assertEquals(tStack.contains("B"), 2);
        assertEquals(tStack.contains("A"), 3);
        assertEquals(tStack.contains("X"), -1);
    }

}

