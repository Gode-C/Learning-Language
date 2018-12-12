
public abstract class AbstractSorter<E> implements Sorter<E> {
	private long numComparisons;
	private long numWrites;

	public long getNumComparisons() {
		return numComparisons;
	}

	public void incNumComparisons() {
		numComparisons++;
	}

	public long getNumWrites() {
		return numWrites;
	}

	public void incNumWrites() {
		numWrites++;
	}
		
	public void reset() {
		numComparisons = 0;
		numWrites = 0;
	}

}
