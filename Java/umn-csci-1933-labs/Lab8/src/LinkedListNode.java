/**
 * Created by bjhecht on 10/25/15.
 */
public class LinkedListNode<T> {

    private T data;
    private LinkedListNode<T> next;

    public LinkedListNode(T data, LinkedListNode<T> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Gets the 'payload' for this node
     * @return
     */
    public T getData() {
        return data;
    }

    /**
     * Sets the 'payload' for this node
     * @param data
     */
    public void setData(T data) {
        this.data = data;
    }


    /**
     * Gets the next item in a linked list
     * @return
     */
    public LinkedListNode<T> getNext() {
        return next;
    }

    /**
     * Sets the next item in a linked list
     * @param next
     */
    public void setNext(LinkedListNode<T> next) {
        this.next = next;
    }
}
