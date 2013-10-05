package sorting;

public class MergeSortedArraysTest {

	// constants
	private static final int MaxArrayElementsToPrint = 40;
	private final String Space = " ";

	public static void main(String[] args) {
		new MergeSortedArraysTest();
	}

	public MergeSortedArraysTest() {
		int[] a = { 1, 3, 3, 6, 0, 0, 0, 0, 0, 0 };
		int aNumElements = 4;
		int[] b = { 2, 4, 7, 9 };

		printArray(a);

		a = new MergeSortedArrays().mergeSorted(a, aNumElements, b);

		printArray(a);

	}

	/**
	 * prints the content of the provided array including the used sorting class
	 * 
	 * @param numbers
	 * @param bubbleSort
	 */
	private void printArray(int[] numbers) {
		if (numbers != null) {
			int lenth = Math.min(numbers.length, MaxArrayElementsToPrint);
			for (int i = 0; i < lenth; i++) {
				System.out.print(numbers[i] + Space);
			}
			System.out.println();
		}
	}

}
