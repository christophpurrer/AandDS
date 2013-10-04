package sorting.o2n;

import sorting.AbstractSort;

public class SelectionSort extends AbstractSort {

	@Override
	public int[] doSorting(int[] array) {
		int length = array.length;

		for (int i = 0; i < length - 1; i++) {
			int iMin = i;

			// find the min element, assume it is the first one
			for (int j = i + 1; j < length; j++) {
				if (array[j] < array[iMin]) {
					iMin = j;
				}
			}

			// swap
			if (iMin != i) {
				swap(array, i, iMin);
			}
		}

		return array;
	}
}
