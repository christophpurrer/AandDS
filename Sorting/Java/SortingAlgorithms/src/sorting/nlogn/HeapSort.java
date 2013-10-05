package sorting.nlogn;

import sorting.AbstractSort;

public class HeapSort extends AbstractSort {

	@Override
	public int[] doSorting(int[] array) {
		int length = array.length - 1;
		for (int i = length / 2; i >= 0; i--) {
			maxheap(array, i, length);
		}

		for (int i = length; i > 0; i--) {
			swap(array, 0, i);
			length = length - 1;
			maxheap(array, 0, length);
		}

		return array;
	}

	private void maxheap(int[] array, int i, int length) {
		int left = 2 * i;
		int right = 2 * i + 1;
		int largest = i;

		if (left <= length && array[left] > array[i]) {
			largest = left;
		}
		if (right <= length && array[right] > array[largest]) {
			largest = right;
		}

		if (largest != i) {
			swap(array, i, largest);
			maxheap(array, largest, length);
		}
	}
}
