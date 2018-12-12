/**
 * Created by Manchanda on 26-10-2015.
 */
import junit.framework.TestCase;


public class ListTest extends TestCase {
    private LinkedList1933<String> list1;
    public void setUp() {
        list1 = new LinkedList1933<String>();
        list1.add("This");
        list1.add("is");
        list1.add("JUnit");
        list1.add("test");
    }

    public void testSize() {
        if(list1.size() == 3 || list1.size() == 5)
            System.out.println("The LinkedList1933 class returns size of list possible offset by 1. Check your loop conditions");
        assertEquals(list1.size(), 4);
    }
    public void testRemove() {
        System.out.println("Checking the remove function");
        list1.remove(2);
        if(list1.size() == 4)
            System.out.println("Did you update the linked list or its size in your remove routine?");
        assertEquals(list1.size(), 3);
    }
    public void testAdd() {
        System.out.println("Checking the add function");
        list1.add(3, "just");
        list1.size();
        if(list1.size() != 5)
            System.out.println("Correct size not returned after adding element!");
        assertEquals(list1.size(), 5);
    }
    public void testGet() {
        System.out.println("Checking the Get function");
        assertEquals(list1.get(0), "This");
        assertEquals(list1.get(1), "is");
        assertEquals(list1.get(2), "JUnit");
        assertEquals(list1.get(3), "test");

    }
}
