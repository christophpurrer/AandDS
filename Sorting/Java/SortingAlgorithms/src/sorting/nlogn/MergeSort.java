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
	 * @param right
	 * @param rightEnd
	 * @return
	 */
	private int[] merge(int[] array, int[] temp, int left, int right, int rightEnd) {
		int leftEnd = right - 1;
		int k = left;
		int num = rightEnd - left + 1;

		while (left <= leftEnd && right <= rightEnd) {
			if (array[left] < array[right]) {
				temp[k++] = array[left++];
			} else {
				temp[k++] = array[right++];
			}
		}

		// Copy rest of first half
		while (left <= leftEnd) {
			temp[k++] = array[left++];
		}

		// Copy rest of right half
		while (right <= rightEnd) {
			temp[k++] = array[right++];
		}

		// Copy temp back
		for (int i = 0; i < num; i++, rightEnd--) {
			array[rightEnd] = temp[rightEnd];
		}

		return array;
	}
}
