import java.util.ArrayList;

public class SortedList<T extends Comparable<T>> {

	private Node topNode;
	private int size;

	private class Node {
		private T data;
		private Node next;

		private Node(T data) {
			this.data = data;
			this.next = null;
		}

        public T getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {

            this.next = next;
        }

    }

	public SortedList() {
		topNode = null;
		size = 0;
	}


	public boolean isEmpty() {
		if (size == 0) {
			assert topNode == null;
			return true;
		} else {
			assert topNode != null;
			return false;
		}
	}

	public int getSize() {
		return size;
	}


    public boolean add(T item) {
        Node newnode = new Node(item);
        Node lastone = null;
        Node current = topNode;
        while ((current != null) && (current.getData().compareTo(item) > 0)){

            lastone = current;
            current = current.getNext();
        }
        if (lastone == null){
            newnode.setNext(topNode);
            topNode = newnode;
        }
        else {lastone.setNext(newnode);
            newnode.setNext(current);
        }
        size++;
        return true;
    }

	/**
	 * Finds the item at index i, and returns the item to the caller.
	 * 
	 * You will need to implement this method. In general, this means stepping
	 * through the list and maintaining a count until you reach the proper
	 * element, then returning that item.
	 * 
	 * @param i the index of the requested item
	 * @return the data field of node i, null if i does not exist
	 */
	public T get(int i) {
        {
            if(i < 0 || i >= this.getSize())
                return null;

            Node current = topNode;
            for(int ind = 0; ind < i; i++)
            {
                if(current.getNext() == null)
                    return null;

                current = current.getNext();
            }
            return current.getData();
        }
	}

	/**
	 * Returns an ArrayList that maintains the proper order of this SortedList.
	 * 
	 * You will need to implement this method. In general, this means adding the
	 * stepping through each node in the SortedList and adding it in the proper
	 * location to the ArrayList.
	 * 
	 * @return An ArrayList representation of this SortedList. null if this list
	 *         is empty.
	 */
	public ArrayList<T> toList() {
        ArrayList<T> mylist = new ArrayList<>();
        Node current = topNode;
        while(current.getNext() != null){
            mylist.add(current.getData());
            current = current.getNext();
        }
        mylist.add(current.getData());
		return mylist;
	}
}
