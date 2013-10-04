package sorting.o2n;

import sorting.AbstractSort;

public class BubbleSort extends AbstractSort {

	@Override
	public int[] doSorting(int[] array) {
		int length = array.length;

		for (int i = 0; i < length; i++) {
			for (int j = length - 1; j > i; j--) {
				if (array[j] < array[j - 1]) {
					swap(array, j, j - 1);
				}
			}
		}

		return array;
	}
}
