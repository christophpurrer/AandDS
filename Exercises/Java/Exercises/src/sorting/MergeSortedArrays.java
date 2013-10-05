package sorting;

public class MergeSortedArrays {

	public int[] mergeSorted(int[] a, int aNumElements, int b[]) {

		if (a != null && b != null && a.length >= aNumElements + b.length) {
			int aInsertIndex = aNumElements + b.length - 1;
			int j = b.length - 1;
			aNumElements--;

			// int[] a = { 1, 3, 3, 6, 0, 0, 0, 0 , 0, 0};
			// int aNumElements = 4;
			// int[] b = { 2, 4, 7, 9 };

			while (j >= 0 && aInsertIndex >= 0) {
				if (b[j] >= a[aNumElements]) {
					a[aInsertIndex] = b[j];
					j--;
				} else {
					a[aInsertIndex] = a[aNumElements];
					aNumElements--;
				}
				aInsertIndex--;
			}

			return a;
		}
		return null;

	}
}
