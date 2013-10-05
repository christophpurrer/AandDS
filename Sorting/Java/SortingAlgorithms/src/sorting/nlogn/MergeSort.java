package sorting.nlogn;

import sorting.AbstractSort;

public class MergeSort extends AbstractSort {

	@Override
	public int[] doSorting(int[] array) {
		return mergeSort(array, new int[array.length], 0, array.length - 1);
	}

	/**
	 * the divide step
	 * 
	 * @param array
	 * @param temp
	 * @param left
	 * @param right
	 * @return
	 */
	private int[] mergeSort(int[] array, int[] temp, int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;
			mergeSort(array, temp, left, middle);
			mergeSort(array, temp, middle + 1, right);
			return merge(array, temp, left, middle + 1, right);
		}
		return null;
	}

	/**
	 * the merge step
	 * 
	 * @param array
	 * @param temp
	 * @param left
	 * @param middle
	 * @param right
	 * @return
	 */
	private int[] merge(int[] array, int[] temp, int left, int middle, int right) {
		int leftEnd = middle - 1;
		int tempPos = left;
		int numElements = right - left + 1;

		while (left <= leftEnd && middle <= right) {
			if (array[left] < array[middle]) {
				temp[tempPos++] = array[left++];
			} else {
				temp[tempPos++] = array[middle++];
			}
		}

		// Copy rest of first half
		while (left <= leftEnd) {
			temp[tempPos++] = array[left++];
		}

		// Copy rest of right half
		while (middle <= right) {
			temp[tempPos++] = array[middle++];
		}

		// Copy temp back
		for (int i = 0; i < numElements; i++, right--) {
			array[right] = temp[right];
		}

		return array;
	}
}
