package datastructures.list;

public class LinkedList<E> {

	private class LinkedNode<T> {
		private T item;
		private LinkedNode<T> next;

		/**
		 * constructor to build a node with no successor
		 * 
		 * @param the
		 *            value to be stored by this node
		 */
		private LinkedNode(T value) {
			this.item = value;
		}

		/**
		 * constructor to build a node with specified (maybe null) successor
		 * 
		 * @param the
		 *            value to be stored by this node
		 * @param the
		 *            next field for this node
		 */
		private LinkedNode(T value, LinkedNode<T> reference) {
			this.item = value;
			this.next = reference;
		}
	}

	public LinkedNode<E> head;
	public LinkedNode<E> tail;
	public int size;

	/**
	 * checks assertion
	 * 
	 * @throws java.lang.AssertionError
	 *             if the assertion is not true
	 */
	private void verify(boolean mustBeTrue) {
		if (!mustBeTrue) {
			throw new java.lang.AssertionError("assertion error");
		}
	}

	/**
	 * checks class invariants
	 * 
	 * @throws java.lang.AssertionError
	 *             if the invariant is violated
	 */
	private void checkInvariants() {
		verify((head == null) == (tail == null));
		verify((size == 0) == (head == null));
		verify(size >= 0);

		// if the list only has one element, head should be the same as tail
		// (and also if the list has no elements), otherwise they should differ
		verify((head == tail) == (size <= 1));

		// a non-null tail variable should always have a null "next" field
		verify((tail == null) || (tail.next == null));

		// check to make sure size is the same as the length of the list.
		// this code takes O(n), so comment it out if performance is important
		int measuredSize = 0;
		LinkedNode<E> node = head;
		// if visitedLast is null, the list is empty, and tail should also be
		// null

		LinkedNode<E> visitedLast = null;
		while (node != null) {
			visitedLast = node;
			node = node.next;
			measuredSize++;
		}
		verify(measuredSize == size);
		// also make sure "last" really is the last node in the linked list
		verify(visitedLast == tail);
	}

	/**
	 * initializes an empty linked list
	 */
	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;

		// one of the constructor's jobs is to make sure that the invariants
		// hold.
		checkInvariants();
	}

	// these private (helper) methods simplify implementation of
	// the public "add" methods
	// the helper methods never modify "size", the public methods
	// take care of that, so the invariants probably do not hold at the end of
	// a helper methods

	/**
	 * adds at the head of the list
	 * 
	 * @param the
	 *            value to be added
	 */
	private void addAtFront(E value) {
		head = new LinkedNode<E>(value, head);
		if (tail == null) {
			tail = head;
		}
	}

	/**
	 * adds at the tail of the list. Assumes (and checks) that tail is not null
	 * 
	 * @param the
	 *            value to be added
	 * @throws RuntimeException
	 */
	private void addAtEnd(E value) {
		if (tail == null) {
			throw new RuntimeException("invalid call to addAtEnd, tail is null");
		}
		LinkedNode<E> newNode = new LinkedNode<E>(value);
		tail.next = newNode;
		tail = newNode;
	}

	/**
	 * adds a value to the list after the given node
	 * 
	 * @param the
	 *            node after which the new value is added
	 * @param the
	 *            value to be added
	 */
	private void addAfter(LinkedNode<E> reference, E value) {
		LinkedNode<E> newNode = new LinkedNode<E>(value, reference.next);
		reference.next = newNode;
		if (reference == tail) { // if added at end, update tail value
			tail = newNode;
		}
	}

	/**
	 * adds a value to the end of the list
	 * 
	 * @param the
	 *            value to be added
	 * @return true (the add always succeeds)
	 */
	public boolean add(E value) {
		checkInvariants(); // useful for debugging
		if (head != null) {
			addAtEnd(value);
		} else {
			addAtFront(value);
		}
		size++;
		checkInvariants(); // invariants valid at start, are they still valid?
							// i.e., did this method break the invariants?
		return true;
	}

	/**
	 * returns the node at the requested position, may take time O(n)
	 * 
	 * @param the
	 *            position of the requested node, 0 for the head node
	 * @return the requested node
	 * @throws NullPointerException
	 *             if the index is larger than the linked list
	 */
	private LinkedNode<E> nodeAtPosition(int index) {
		verify(index >= 0);
		LinkedNode<E> result = head;
		while (index > 0) {
			result = result.next;
			index--;
		}
		verify(result != null);
		return result;
	}

	/**
	 * adds a value to the list, in the given position
	 * 
	 * @param the
	 *            position at which to add: 0 to add at the start
	 * @param the
	 *            value to be added
	 * @throws IndexOutOfBoundsException
	 *             if the index is less than 0 or greater than the number of
	 *             elements in the linked list
	 */
	public void add(int index, E value) {
		checkInvariants();
		if ((index < 0) || (index > size)) {
			String badIndex = new String("index " + index + " must be between 0 and " + size);
			throw new IndexOutOfBoundsException(badIndex);
		}
		if (index == 0) {
			addAtFront(value);
		} else {
			addAfter(nodeAtPosition(index - 1), value);
		}
		size++;
		checkInvariants();
	}

	/**
	 * concatenates the elements of the linked list, separated by " ==> "
	 * 
	 * @return the string representation of the list
	 */
	public String toString() {
		checkInvariants();
		LinkedNode<E> node = head;
		StringBuffer result = new StringBuffer();
		while (node != null) {
			result.append(node.item.toString());
			node = node.next;
			if (node != null) {
				result.append(" ==> ");
			}
		}
		checkInvariants(); // make sure we didn't break anything
		return result.toString();
	}
}