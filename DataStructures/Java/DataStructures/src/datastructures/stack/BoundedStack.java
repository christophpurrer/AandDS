package datastructures.stack;

import java.util.NoSuchElementException;

public class BoundedStack<T> implements IStack<T> {

	private T[] array;
	private int size = 0;

	public BoundedStack(int capacity) {
		array = (T[]) new Object[capacity];
	}

	public void push(T item) {
		if (size == array.length) {
			throw new IllegalStateException("Cannot add to full stack");
		}
		array[size++] = item;
	}

	public T pop() {
		if (size == 0) {
			throw new NoSuchElementException("Cannot pop from empty stack");
		}
		T result = array[size - 1];
		array[--size] = null;
		return result;
	}

	public T peek() {
		if (size == 0) {
			throw new NoSuchElementException("Cannot peek into empty stack");
		}
		return array[size - 1];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

}
