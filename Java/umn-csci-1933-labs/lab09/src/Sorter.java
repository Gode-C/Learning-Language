import java.util.Comparator;

/**
 * Interface for data sorting routines. Modified by Loren Terveen to
 * require counting number of comparisons and number of writes made
 * by the algorithm.
 * @author Michael Ekstrand, then heavily modified by Loren Terveen
 *
 */
public interface Sorter<E> {
	/**
	 * Sort a data array with the specified comparator.
	 * @param data The data to sort.
	 * @param comparator The comparator to use in sorting the data.
	 */
	public void sort(E[] data, Comparator<E> comparator);
	
	/**
	 * Return the number of comparisons made by this comparator
	 * @return number of comparisons 
	 */
	public long getNumComparisons();
	
	/**
	 * Increment the number of comparisons made by this comparator
	 */
	public void incNumComparisons();
	
	/**
	 * Return the number of writes made by this comparator
	 * @return number of comparisons 
	 */
	public long getNumWrites();
	
	/**
	 * Increment the number of writes made by this comparator
	 */
	public void incNumWrites();
	
	/**
	 * Reset the number of comparisons and writes to 0.
	 */
	public void reset();

}


