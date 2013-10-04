package sorting;

public abstract class AbstractSort {

	private long startTime;
	private long endTime;

	/**
	 * sorts the provided array
	 * 
	 * @param array
	 * @return
	 */
	public int[] sort(int array[]) {
		this.startTime = System.currentTimeMillis();
		int[] result = null;
		if (array != null) {
			result = this.doSorting(array);
		}
		this.endTime = System.currentTimeMillis();
		return result;
	}

	/**
	 * prints out the processing time take for the provided algorithm
	 */
	public void printProcessingTime() {
		if (startTime > 0 && endTime > 0) {
			System.out.println("Sorting time was: " + (this.endTime - this.startTime) + " ms");
		} else {
			System.out.println("Sorting not done or not run");
		}
	}

	/**
	 * swaps the array elements
	 * 
	 * @param array
	 * @param i
	 * @param j
	 */
	protected void swap(int[] array, int i, int j) {
		if (array != null && i >= 0 && j >= 0 && i < array.length && j < array.length) {
			int temp = array[j];
			array[j] = array[i];
			array[i] = temp;
		}
	}

	public abstract int[] doSorting(int[] array);
}