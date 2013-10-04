package sorting.nlogn;

import sorting.AbstractSort;

public class QuickSort extends AbstractSort {

	@Override
	public int[] doSorting(int[] array) {
		return quicksort(array, 0, array.length - 1);
	}

	private int[] quicksort(int[] array, int low, int high) {
		int i = low, j = high;

		// Get the pivot element from the middle of the list
		int pivot = array[low + (high - low) / 2];

		// Divide into two lists
		while (i <= j) {
			// If the current value from the left list is smaller then the pivot
			// element then get the next element from the left list
			while (array[i] < pivot) {
				i++;
			}

			// If the current value from the right list is larger then the pivot
			// element then get the next element from the right list
			while (array[j] > pivot) {
				j--;
			}

			// If we have found a values in the left list which is larger then
			// the pivot element and if we have found a value in the right list
			// which is smaller then the pivot element then we exchange the
			// values. As we are done we can increase i and j
			if (i <= j) {
				swap(array, i, j);
				i++;
				j--;
			}
		}
		
		// Recursion
		if (low < j) {
			quicksort(array, low, j);
		}
		if (i < high) {
			quicksort(array, i, high);
		}
		
		return array;
	}
}
