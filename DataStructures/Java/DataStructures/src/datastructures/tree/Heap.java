package datastructures.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Heap<T extends Comparable<T>> {

	private List<T> items;

	public Heap() {
		this.items = new ArrayList<T>();
	}

	private void siftUp() {
		int k = items.size() - 1;
		while (k > 0) {
			int p = (k - 1) / 2;
			T item = items.get(k);
			T parent = items.get(p);
			if (item.compareTo(parent) > 0) {
				// swap
				items.set(k, parent);
				items.set(p, item);

				// move up one level
				k = p;
			} else {
				break;
			}
		}
	}

	public void insert(T item) {
		items.add(item);
		siftUp();
	}

	private void shiftDown() {
		int k = 0;
		int l = 2 * k + 1;
		while (l < items.size() && l > 2) {
			int max = l, r = l + 1;

			if (r < items.size()) {
				if (items.get(r).compareTo(items.get(l)) > 0) {
					// switch
					T temp = items.get(k);
					items.set(k, items.get(max));
					items.set(max, temp);
					k = max;
					l = 2 * k + 1;
				} else {
					break;
				}
			}
		}
	}

	public T delete() throws NoSuchElementException {
		if (items.size() == 0) {
			throw new NoSuchElementException();
		}

		if (items.size() == 1) {
			return items.remove(0);
		}

		T hold = items.get(0);
		items.set(0, items.remove(items.size() - 1));
		shiftDown();
		return hold;
	}

	public int size() {
		return items.size();
	}

	public boolean isEmpty() {
		return items.isEmpty();
	}

	@Override
	public String toString() {
		return items.toString();
	}
}
