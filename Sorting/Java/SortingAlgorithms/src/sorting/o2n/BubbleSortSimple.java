package sorting.o2n;

import sorting.AbstractSort;

public class BubbleSortSimple extends AbstractSort {

	@Override
	public int[] doSorting(int[] array) {
		int length = array.length;

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length - 1; j++) {
				if (array[j] > array[j + 1]) {
					swap(array, j, j + 1);
				}
			}
		}

		return array;
	}
}
