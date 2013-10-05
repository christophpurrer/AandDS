import sorting.AbstractSort;
import sorting.nlogn.*;
import sorting.o2n.*;

public class Main {

	// constants
	private static final int MaxArrayElementsToPrint = 40;
	private final int DefaultArrayLength = 10000;
	private final String Space = " ";

	/**
	 * main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new Main();
	}

	/**
	 * constructor
	 */
	public Main() {
		int[] randomNumbers = generateRandomArray(DefaultArrayLength);

		System.out.println("## Sorting algorithms n^2 for " + DefaultArrayLength + " elements ##");
		int[] randomInsertionNumbers = new int[] { 7, 8, 5, 2, 4, 6, 3 };
		sortNumbers(randomInsertionNumbers, new InsertionSort());

		sortNumbers(randomNumbers, new BubbleSortSimple());
		sortNumbers(randomNumbers, new BubbleSort());
		sortNumbers(randomNumbers, new SelectionSort());
		sortNumbers(randomNumbers, new InsertionSort());

		System.out.println("## Sorting algorithms n log n for " + DefaultArrayLength + " elements ##");
		sortNumbers(randomNumbers, new MergeSort());
		sortNumbers(randomNumbers, new QuickSort());
		sortNumbers(randomNumbers, new HeapSort());
	}

	/**
	 * helper method to perform sorting
	 * 
	 * @param randomNumbers
	 * @param abstractSort
	 */
	private void sortNumbers(int[] randomNumbers, AbstractSort abstractSort) {
		int[] numbers = new int[randomNumbers.length];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = randomNumbers[i];
		}

		System.out.println(abstractSort.getClass().getName() + Space);
		printArray(numbers, abstractSort);
		numbers = abstractSort.sort(numbers);
		abstractSort.printProcessingTime();
		printArray(numbers, abstractSort);
		System.out.println();
	}

	/**
	 * prints the content of the provided array including the used sorting class
	 * 
	 * @param numbers
	 * @param bubbleSort
	 */
	private void printArray(int[] numbers, AbstractSort bubbleSort) {
		if (numbers != null && bubbleSort != null) {
			int lenth = Math.min(numbers.length, MaxArrayElementsToPrint);
			for (int i = 0; i < lenth; i++) {
				System.out.print(numbers[i] + Space);
			}
			System.out.println();
		} else {
			System.out.println("Invaild numbers array or bubbleSort class supplied");
		}
	}

	/**
	 * generates an int array with random numbers with the specified length or
	 * length {DefaultArrayLength} if an invalid length parameter is supplied
	 * 
	 * @param length
	 * @return
	 */
	private int[] generateRandomArray(int length) {
		int[] numbers = null;
		if (length <= 0) {
			length = DefaultArrayLength;
		}

		numbers = new int[length];
		for (int i = 0; i < length; i++) {
			numbers[i] = (int) (Math.random() * (double) length);
		}
		return numbers;
	}
}
