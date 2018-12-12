import java.util.Comparator;


public class InsertionSort<E> extends AbstractSorter<E> {

	@Override
	public void sort(E[] data, Comparator<E> comparator) {
		for (int i = 1; i < data.length; i++) {
			  E unsorted = data[i];
			  int curPosInSorted = i-1;
			  // to find the proper position in the sorted partition for unsorted, 
			  // shift items in the sorted partition to the right as long as
			  // unsorted item is less than them.

			  while ( curPosInSorted >= 0 && comparator.compare(unsorted, data[curPosInSorted]) < 0 ) {
				  data[curPosInSorted + 1] = data[curPosInSorted];
				  curPosInSorted--;
				  incNumWrites();
				  incNumComparisons();
			  }
				incNumComparisons();
			  
			  // when we exit the loop, we've done all the shifting we need to,
			  // and curPosInSorted is the index of the first element that should
			  // come before unsorted.  Therefore, insert unsorted at position
			  // curPosInSorted + 1

			  data[curPosInSorted+1]= unsorted;
			incNumWrites();
			}
	}
	

}
