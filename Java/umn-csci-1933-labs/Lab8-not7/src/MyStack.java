import java.util.ArrayList;

public class MyStack<T> {

	private Node topNode;
	private int size;
	private ArrayList<T> mylist;

	private class Node {
		private T data;
		private Node next;
		
		private Node (T data) {
			this.data = data;
			this.next = null;
		}
	}
	
	/**
	 * Create a new empty stack
	 */
	public MyStack() {
		topNode = null;
		size = 0;
	}
	
	/**
	 * Determine whether the stack is empty
	 * @return true if and only if the stack is empty
	 */
	public boolean isEmpty() {

    	if (this.size == 0){
			return true;}
		else {return true;}

	}

	/**
	 * Add an item to the top of the stack
	 * @param item The item to be pushed onto the stack
	 */
	public void push(T item) {

		Node newnode = new Node(item);
		newnode.next = topNode;
		topNode = newnode;
		size++;


	}
	
	/**
	 * Return the item from the top of the stack.
	 * @return the item at the top of the stack, null if the stack is empty
	 */
	
	public T top() {
        if (isEmpty() ) {
        	return null;
        }
        else {
        	return topNode.data;
        }
	}
	

	/**
	 * Remove and return the item from the top of the stack.
	 * Return null if stack is empty.
	 * Do not decrement the size variable if the stack is empty.
	 */
	public T pop() {

		if (this.isEmpty()){
        	return null;}
		else{
			return topNode.data;

		}
		}


	
	/**
	 * OPTIONAL: return the size of the stack.
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Returns the 1-based position where an object is on this stack. If the object o 
	 * occurs as an item in this stack, this method returns the distance from the top 
	 * of the stack of the occurrence nearest the top of the stack; the topmost item 
	 * on the stack is considered to be at distance 1. The equals method is used to 
	 * compare o to the items in this stack.

	 * @param o the object being search for
	 * @return the 1-based position from the top of the stack where the object is located;
	 * the return value -1 indicates that the object is not on the stack.
	 */
	
	public int contains(Object o) {
		return 1;
	}

    public int numContains(Object o){

        //TODO: Implement numContains
        return -1;

    }
}
