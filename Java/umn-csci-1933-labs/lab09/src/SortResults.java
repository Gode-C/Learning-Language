import java.util.Comparator;
import java.util.Random;

public class SortResults {
	public static void main(String[] args){
		Sorter<Integer> mergeSorter;
		Sorter<Integer> insertionSorter;
		Comparator<Integer> comp;

		int smallArraySize;
		int bigArraySize;
		int maxIntToInclude;
		Integer[] smallRandom;
		Integer[] smallSorted;
		Integer[] bigRandom;
		Integer[] bigSorted;

		//Set Up
		mergeSorter = new MergeSort<Integer>();
		insertionSorter = new InsertionSort<Integer>();
		comp = new CompareByIntegerValue();
		
		smallArraySize = 10;
		bigArraySize = 100000;
		maxIntToInclude = Math.min(bigArraySize * 2, 10000);
		
		smallRandom = new Integer[smallArraySize];
		smallSorted = new Integer[smallArraySize];
		bigRandom = new Integer[bigArraySize];
		bigSorted = new Integer[bigArraySize];
		
		Random r = new Random();
		
		// Make the small and big random arrays
		for (int i = 0; i < smallArraySize; i++) {
			smallRandom[i] = r.nextInt(maxIntToInclude); 
		}

		for (int i = 0; i < bigArraySize; i++) {
			bigRandom[i] = r.nextInt(maxIntToInclude); 
		}
		
		// make the small and big sorted arrays
		for (int i = 0; i < smallArraySize; i++) {
				smallSorted[i] = i; 
		}

		for (int i = 0; i < bigArraySize; i++) {
			bigSorted[i] = i; 
		}

		//Running MergeSort
		mergeSorter.reset();
		mergeSorter.sort(smallRandom,  comp);
		System.out.format("MS: random: size = %d\t#comp = %d #write = %d\n", 
				smallRandom.length,
				mergeSorter.getNumComparisons(),
				mergeSorter.getNumWrites()
				);
			
		mergeSorter.reset();
		mergeSorter.sort(bigRandom,  comp);
		System.out.format("MS: random: size = %d\t#comp = %d #write = %d\n", 
				bigRandom.length,
				mergeSorter.getNumComparisons(),
				mergeSorter.getNumWrites()
				);
		
		mergeSorter.reset();
		mergeSorter.sort(smallSorted,  comp);
		System.out.format("MS: sorted: size = %d\t#comp = %d #write = %d\n", 
				smallSorted.length,
				mergeSorter.getNumComparisons(),
				mergeSorter.getNumWrites()
				);
			
		mergeSorter.reset();
		mergeSorter.sort(bigSorted,  comp);
		System.out.format("MS: sorted: size = %d\t#comp = %d #write = %d\n", 
				bigSorted.length,
				mergeSorter.getNumComparisons(),
				mergeSorter.getNumWrites()
				);

		// Make the small and big random arrays
		for (int i = 0; i < smallArraySize; i++) {
			smallRandom[i] = r.nextInt(maxIntToInclude); 
		}

		for (int i = 0; i < bigArraySize; i++) {
			bigRandom[i] = r.nextInt(maxIntToInclude); 
		}
		
		// make the small and big sorted arrays
		for (int i = 0; i < smallArraySize; i++) {
				smallSorted[i] = i; 
		}

		for (int i = 0; i < bigArraySize; i++) {
			bigSorted[i] = i; 
		}


		//Running InsertionSort
		insertionSorter.reset();
		insertionSorter.sort(smallRandom,  comp);
		System.out.println();
		System.out.format("IS: random: size = %d\t#comp = %d #write = %d\n", 
				smallRandom.length,
				insertionSorter.getNumComparisons(),
				insertionSorter.getNumWrites()
				);

		insertionSorter.reset();
		insertionSorter.sort(bigRandom,  comp);
		System.out.format("IS: random: size = %d\t#comp = %d #write = %d\n", 
				bigRandom.length,
				insertionSorter.getNumComparisons(),
				insertionSorter.getNumWrites()
				);

		insertionSorter.reset();
		insertionSorter.sort(smallSorted,  comp);
		System.out.format("IS: sorted: size = %d\t#comp = %d #write = %d\n", 
				smallSorted.length,
				insertionSorter.getNumComparisons(),
				insertionSorter.getNumWrites()
				);

		insertionSorter.reset();
		insertionSorter.sort(bigSorted,  comp);
		System.out.format("IS: sorted: size = %d\t#comp = %d #write = %d\n", 
				bigSorted.length,
				insertionSorter.getNumComparisons(),
					insertionSorter.getNumWrites()
				);

	}	

}
