import java.util.Comparator;


public class MergeSort <E> extends AbstractSorter<E> {


	public void sort(E[] data, Comparator<E> comparator) {
		mergeSort(data, comparator, 0, data.length-1);

	}

	public void mergeSort(E[] data, Comparator<E> comparator, int beginIndex, int endIndex){
		if(beginIndex < endIndex)
		{
			int mid = ((beginIndex + endIndex)/2);
			mergeSort(data, comparator, beginIndex, mid);
			mergeSort(data, comparator, mid+1, endIndex);
			merge(data, comparator, beginIndex, mid, mid+1, endIndex); 
		}
	}

	public void merge( E[] data, Comparator<E> comparator, 
					  int startA, int endA, 
					  int startB, int endB ) {
		
		@SuppressWarnings("unchecked")
		// make a temp array of the appropriate size to handle the two sub-arrays
		// we are merging during this step
		E[] mergedArray = (E[]) new Object[ (endB - startA) + 1];

		int finalStart = startA;
		int finalEnd = endB;
		int index=0;
		// merge
		while( (startA <= endA) && (startB <= endB) ) {
			if( comparator.compare(data[startA], data[startB]) <= 0 ) {
				mergedArray[index] = data[startA];
				startA++;
				incNumComparisons();
				incNumWrites();
			}
			else {
				mergedArray[index] = data[startB];
				startB++;
				incNumWrites();
				incNumComparisons();
			}
			index++;
			incNumWrites();
		}
		
		// Add the leftovers from one sub-array or the other.
		// Note that only one of the two following loops will 
		// execute in a single invocation of merge,.
		while (startA <= endA) {
			mergedArray[index] = data[startA];
			startA++;
			index++;
			incNumWrites();
		}

		while (startB <= endB) {
			mergedArray[index] = data[startB];
			startB++;
			index++;
			incNumWrites();
		}

		// Put the merged data from the temp array back into the real array
		index = 0;
		for (int i = finalStart; i <= finalEnd; i++) {
			data[i] = mergedArray[index];
			index++;
			incNumWrites();
		}
		
	}

}
