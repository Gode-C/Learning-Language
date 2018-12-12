import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.lang.UnsupportedOperationException;

/**
 * Created by bjhecht on 10/25/15.
 */
public class LinkedList1933<T> implements List<T>{
    private LinkedListNode<T> head = new LinkedListNode<>(null, null);
    private int listCount;

    public LinkedList1933()
    {
        listCount = 0;
    }

    public boolean add(T data)
    {
        LinkedListNode<T> temp = new LinkedListNode<>(data, null);
        LinkedListNode<T> current = head;
        while(current.getNext() != null)
        {
            current = current.getNext();
        }
        current.setNext(temp);
        listCount++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    public void add(int index, T data)
    {
        LinkedListNode<T> temp = new LinkedListNode<>(data, null);
        LinkedListNode<T> current = head;
        for(int i = 0; i < index && current.getNext() != null; i++)
        {
            current = current.getNext();
        }
        temp.setNext(current.getNext());
        current.setNext(temp);
        listCount++;
    }

    public T get(int index)
    {
        if(index < 0 || index >= size())
            return null;

        LinkedListNode<T> current = head.getNext();
        for(int i = 0; i < index; i++)
        {
            if(current.getNext() == null)
                return null;

            current = current.getNext();
        }
        return current.getData();
    }

    @Override
    public T set(int index, T element) {
        throw new UnsupportedOperationException();
    }

    public T remove(int index)
    {
        if(index < 0 || index >= size())
            return null;

        LinkedListNode<T> current = head;
        for(int i = 0; i < index; i++)
        {
            if(current.getNext() == null)
                return null;

            current = current.getNext();
        }
        current.setNext(current.getNext().getNext());
        listCount--;
        return current.getData();
    }

    @Override
    public int indexOf(Object object) {
        LinkedListNode<T> current = head;
        int index = 0;
        while(current.getNext() != null)
        {
            if(object.equals(current.getData())){
                return index;
            }
            index++;
            current = current.getNext();
        }
        return -1;

    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    public int size()
    {
        return listCount;
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Object o) {
        LinkedListNode<T> current = head;
        while(current.getNext() != null)
        {
            if(o.equals(current.getData())){
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException();
    }
}
