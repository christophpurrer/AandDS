package sorting.custom;

public class MergeSortedArrays {

	public int[] mergeSorted(int[] a, int aNumElements, int b[]) {

		if (a != null && b != null && a.length >= aNumElements + b.length) {
			int aInsertIndex = aNumElements + b.length - 1;
			int j = b.length - 1;
			aNumElements--;

			while (j > 0) {
				if (b[j] > a[aNumElements]) {
					a[aInsertIndex] = b[j];
					j--;
				} else {
					a[aInsertIndex] = a[aNumElements];
					aNumElements--;
				}
			}

			return a;
		}
		return null;

	}
}
