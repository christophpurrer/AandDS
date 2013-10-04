package sorting.o2n;

import sorting.AbstractSort;

public class InsertionSort extends AbstractSort {

	@Override
	public int[] doSorting(int[] array) {
		int length = array.length;

		for (int i = 1; i < length; i++) {
			int temp = array[i];

			int j;
			for (j = i - 1; j >= 0 && temp < array[j]; j--) {
				array[j + 1] = array[j];
			}
			array[j + 1] = temp;
		}

		return array;
	}
}
