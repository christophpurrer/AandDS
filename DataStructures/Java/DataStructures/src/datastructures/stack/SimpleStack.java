package datastructures.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * A stack class implemented as a wrapper around a java.util.LinkedList. All
 * stack methods simply delegate to LinkedList methods.
 */
public class SimpleStack<T> implements IStack<T> {

	private List<T> list = new ArrayList<T>();

	public void push(T item) {
		list.add(item);
	}

	public T pop() {
		if (!isEmpty()) {
			return list.remove(0);
		}
		return null;
	}

	public T peek() {
		if (!isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}
}
